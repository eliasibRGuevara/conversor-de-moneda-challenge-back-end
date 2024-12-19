package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {
    private final String clave = "clave de ExchangeRate-API";

    public void convertir(String base, String target, double cantidad) {
        try {
            // Inicialización de Gson
            Gson gson = new GsonBuilder().create();

            // Configuración de la solicitud HTTP
            HttpClient client = HttpClient.newHttpClient();
            String direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/pair/" + base + "/" + target;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Parsear el JSON usando JsonParser y JsonObject
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            String baseCode = jsonObject.get("base_code").getAsString();
            String targetCode = jsonObject.get("target_code").getAsString();
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();

            // Calcular y mostrar el resultado
            double resultado = cantidad * conversionRate;
            System.out.printf("%.2f %s equivale a %.2f %s%n", cantidad, baseCode, resultado, targetCode);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }
}
