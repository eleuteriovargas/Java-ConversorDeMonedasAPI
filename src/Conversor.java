import java.util.Scanner;

public class Conversor {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ConsultaMonedas consultaMonedas = new ConsultaMonedas();
    private static final GeneradorDeArchivo generador = new GeneradorDeArchivo();
    private static final HistorialConversiones historial = new HistorialConversiones();

    public static void mostrarMenu() {
        System.out.println("""
            ************************************
            *   BIENVENIDO AL CONVERSOR DE MONEDAS   *
            ************************************
            1) USD => ARS (Dólar a Peso Argentino)
            2) USD => EUR (Dólar a Euro)
            3) USD => GBP (Dólar a Libra Esterlina)
            4) EUR => USD (Euro a Dólar)
            5) GBP => USD (Libra a Dólar)
            6) Otras conversiones disponibles
            7) Mostrar tasas de cambio actuales
            8) Ver historial de conversiones
            9) Salir
            ************************************
            """);
    }

    public static void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> convertirMoneda("USD", "ARS");
                case 2 -> convertirMoneda("USD", "EUR");
                case 3 -> convertirMoneda("USD", "GBP");
                case 4 -> convertirMoneda("EUR", "USD");
                case 5 -> convertirMoneda("GBP", "USD");
                case 6 -> conversionPersonalizada();
                case 7 -> mostrarTasasActuales();
                case 8 -> mostrarHistorial();
                case 9 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 9);
    }

    private static void convertirMoneda(String de, String a) {
        try {
            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            Moneda moneda = consultaMonedas.buscaMoneda(de);
            double tasa = obtenerTasa(moneda, a);
            double resultado = cantidad * tasa;

            System.out.printf("\n%.2f %s = %.2f %s\n", cantidad, de, resultado, a);

            // Guardar en historial
            historial.agregarConversion(new Conversion(de, a, cantidad, resultado));
            generador.guardarJson(moneda);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarHistorial() {
        historial.mostrarHistorial();
    }

    private static void conversionPersonalizada() {
        try {
            System.out.println("\n************************************");
            System.out.println("*   SELECCIONE MONEDA DE ORIGEN    *");
            System.out.println("************************************");
            mostrarMonedasDisponibles();
            System.out.print("\nIngrese código de moneda origen (ej: USD): ");
            String de = scanner.nextLine().toUpperCase();

            System.out.println("\n************************************");
            System.out.println("*  SELECCIONE MONEDA DE DESTINO    *");
            System.out.println("************************************");
            mostrarMonedasDisponibles();
            System.out.print("\nIngrese código de moneda destino (ej: EUR): ");
            String a = scanner.nextLine().toUpperCase();

            convertirMoneda(de, a);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarMonedasDisponibles() {
        System.out.println("""
        USD  - Dólar estadounidense
        EUR  - Euro
        GBP  - Libra esterlina
        ARS  - Peso argentino
        AUD  - Dólar australiano
        BRL  - Real brasileño
        CAD  - Dólar canadiense
        CHF  - Franco suizo
        CLP  - Peso chileno
        CNY  - Yuan chino
        COP  - Peso colombiano
        DKK  - Corona danesa
        EGP  - Libra egipcia
        HKD  - Dólar de Hong Kong
        INR  - Rupia india
        JPY  - Yen japonés
        KRW  - Won surcoreano
        MXN  - Peso mexicano
        PEN  - Sol peruano
        RUB  - Rublo ruso
        """);
    }

    private static void mostrarTasasActuales() {
        try {
            System.out.print("Ingrese moneda base para ver tasas (ej: USD): ");
            String base = scanner.nextLine().toUpperCase();

            Moneda moneda = consultaMonedas.buscaMoneda(base);
            System.out.println("\nTasas de cambio para " + base + ":");
            System.out.println("USD: " + moneda.conversion_rates().USD());
            System.out.println("EUR: " + moneda.conversion_rates().EUR());
            System.out.println("GBP: " + moneda.conversion_rates().GBP());
            System.out.println("ARS: " + moneda.conversion_rates().ARS());
            // Agregar más monedas según necesidad

            generador.guardarJson(moneda);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static double obtenerTasa(Moneda moneda, String codigoMoneda) {
        return switch (codigoMoneda) {
            case "USD" -> moneda.conversion_rates().USD();
            case "EUR" -> moneda.conversion_rates().EUR();
            case "GBP" -> moneda.conversion_rates().GBP();
            case "ARS" -> moneda.conversion_rates().ARS();
            case "AUD" -> moneda.conversion_rates().AUD();
            case "BRL" -> moneda.conversion_rates().BRL();
            case "CAD" -> moneda.conversion_rates().CAD();
            case "CHF" -> moneda.conversion_rates().CHF();
            case "CLP" -> moneda.conversion_rates().CLP();
            case "CNY" -> moneda.conversion_rates().CNY();
            case "COP" -> moneda.conversion_rates().COP();
            case "DKK" -> moneda.conversion_rates().DKK();
            case "EGP" -> moneda.conversion_rates().EGP();
            case "HKD" -> moneda.conversion_rates().HKD();
            case "INR" -> moneda.conversion_rates().INR();
            case "JPY" -> moneda.conversion_rates().JPY();
            case "KRW" -> moneda.conversion_rates().KRW();
            case "MXN" -> moneda.conversion_rates().MXN();
            case "PEN" -> moneda.conversion_rates().PEN();
            case "RUB" -> moneda.conversion_rates().RUB();
            default -> throw new IllegalArgumentException("Moneda no soportada: " + codigoMoneda);
        };
    }
}
