import java.util.Map;
//Esta clase será el modelo de datos que usamos para representar el JSON que devuelve la API de tasas de cambio.

public class ExchangeResponse {

    //ExchangeResponse es una estructura de datos (DTO) que refleja el JSON que devuelve la API.
    //No contiene lógica de negocio ni impresión. Solo se encarga de representar los datos de forma clara y segura.

    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getResult() {
        return result;
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}
