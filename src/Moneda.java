public record Moneda(
        String base_code,
        ConversionRates conversion_rates
) {
    public record ConversionRates(
            double USD,  // Dólar estadounidense
            double EUR,  // Euro
            double GBP,  // Libra esterlina
            double ARS,  // Peso argentino
            double AUD,  // Dólar australiano
            double BGN,  // Lev búlgaro
            double BRL,  // Real brasileño
            double CAD,  // Dólar canadiense
            double CHF,  // Franco suizo
            double CLP,  // Peso chileno
            double CNY,  // Yuan chino
            double COP,  // Peso colombiano
            double DKK,  // Corona danesa
            double EGP,  // Libra egipcia
            double HKD,  // Dólar de Hong Kong
            double HRK,  // Kuna croata
            double INR,  // Rupia india
            double JPY,  // Yen japonés
            double KRW,  // Won surcoreano
            double MXN,  // Peso mexicano
            double NOK,  // Corona noruega
            double NZD,  // Dólar neozelandés
            double PEN,  // Sol peruano
            double PHP,  // Peso filipino
            double PLN,  // Złoty polaco
            double RON,  // Leu rumano
            double RUB,  // Rublo ruso
            double SEK,  // Corona sueca
            double SGD,  // Dólar de Singapur
            double THB,  // Baht tailandés
            double TRY,  // Lira turca
            double TWD,  // Nuevo dólar taiwanés
            double ZAR   // Rand sudafricano
    ) {}
}