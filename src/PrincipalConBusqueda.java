import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.ConversorMoneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner pedirMonedaAConvertir = new Scanner(System.in);

        while (true) {
            System.out.println("*****************************************************");
            System.out.println("Sea bienvenido/a al conversor de moneda =] ");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida: ");
            System.out.println("*****************************************************");
            int opcion = Integer.parseInt(pedirMonedaAConvertir.nextLine());

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            }

            System.out.println("Ingrese la cantidad a convertir:");
            double cantidad = Double.parseDouble(pedirMonedaAConvertir.nextLine());

            ConversorMoneda conversor = new ConversorMoneda();
            switch (opcion) {
                case 1 -> conversor.convertir("USD", "ARS", cantidad);
                case 2 -> conversor.convertir("ARS", "USD", cantidad);
                case 3 -> conversor.convertir("USD", "BRL", cantidad);
                case 4 -> conversor.convertir("BRL", "USD", cantidad);
                case 5 -> conversor.convertir("USD", "COP", cantidad);
                case 6 -> conversor.convertir("COP", "USD", cantidad);
                default -> System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }
}


