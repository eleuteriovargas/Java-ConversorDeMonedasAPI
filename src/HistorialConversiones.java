import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private static final String ARCHIVO_HISTORIAL = "historial_conversiones.dat";
    private List<Conversion> conversiones;

    public HistorialConversiones() {
        this.conversiones = cargarHistorial();
    }

    public void agregarConversion(Conversion conversion) {
        conversiones.add(conversion);
        guardarHistorial();
    }

    public void mostrarHistorial() {
        if (conversiones.isEmpty()) {
            System.out.println("\nNo hay conversiones en el historial.");
            return;
        }

        System.out.println("\n************************************");
        System.out.println("*        HISTORIAL DE CONVERSIONES       *");
        System.out.println("************************************");

        for (int i = 0; i < conversiones.size(); i++) {
            Conversion c = conversiones.get(i);
            System.out.printf("%d. [%s] %.2f %s => %.2f %s\n",
                    i + 1,
                    c.fecha(),
                    c.cantidad(),
                    c.monedaOrigen(),
                    c.resultado(),
                    c.monedaDestino());
        }
        System.out.println("************************************");
    }

    private List<Conversion> cargarHistorial() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_HISTORIAL))) {
            return (List<Conversion>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el historial: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void guardarHistorial() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_HISTORIAL))) {
            oos.writeObject(conversiones);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }
}