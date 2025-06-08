import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

//creo la clase es una clase destinada a consumir (recibir) datos desde una API.
// Normalmente se encarga de hacer peticiones HTTP a un servidor.
public class ApiCaller {

    //public String ObtenerDatos(String url)
    public ExchangeResponse obtenerDatos(String url){
        //Estás instanciando un cliente HTTP con la clase HttpClient.
        // este cliente es el objeto que va a enviar solicitudes al servidor y recibir las respuestas
        // (como un navegador, pero en código).

        HttpClient cliente = HttpClient.newHttpClient();
        //Crear una HttpRequest, que contenga la URL que recibís como parámetro.
        HttpRequest request =HttpRequest.newBuilder().uri(URI.create(url)).build();

        //declaro una variable llamada response.
        HttpResponse <String> response;
        try {
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException|InterruptedException e) {
            throw new RuntimeException("Error al enviar la solicitud HTTP",e);
        }
        //Cuerpo de la api en formato String
        String json = response.body();
        //gson creado
        Gson gson = new Gson();
        //Objeto exchangeResponse que recibe el json en formato String, y lo transforma a formato gson y me retorna
        //lo que me indica el requerimiento del DTO.
        ExchangeResponse exchangeResponse = gson.fromJson(json,ExchangeResponse.class);
        return exchangeResponse;

    }

}
