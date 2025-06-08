public class Conversor {

    public static void main(String[] args) {
        ApiCaller apiCaller = new ApiCaller();

        String url = "https://v6.exchangerate-api.com/v6/9979fac049b336a82b6d090f/latest/USD";

        ExchangeResponse respuesta = apiCaller.obtenerDatos(url);

        System.out.println("Base : " + respuesta.getBase_code());
        System.out.println("Tasa de cambio ARS" + respuesta.getConversion_rates().get("ARS"));


    }


}
