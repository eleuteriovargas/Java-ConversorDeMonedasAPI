import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {

    public Moneda buscaMoneda(String codigoMonedaBase) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/2c4bd09cfa264f024d6a8e6b/latest/" + codigoMonedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar si la respuesta fue exitosa
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error al consultar la API: " + response.body());
            }

            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar las tasas de cambio: " + e.getMessage());
        }
    }
}