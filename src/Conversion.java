import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Conversion(
        String monedaOrigen,
        String monedaDestino,
        double cantidad,
        double resultado,
        String fecha
) implements Serializable {
    public Conversion(String monedaOrigen, String monedaDestino, double cantidad, double resultado) {
        this(monedaOrigen,
                monedaDestino,
                cantidad,
                resultado,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}