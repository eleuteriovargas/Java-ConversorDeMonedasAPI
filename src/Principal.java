public class Principal {
    public static void main(String[] args) {
        try {
            Conversor.iniciar();
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado. ¡Hasta pronto!");
        }
    }
}
