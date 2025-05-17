# 💱 Conversor de Monedas con API

Aplicación Java que obtiene tasas de cambio en tiempo real desde una API pública y realiza conversiones entre distintas monedas.

## ✨ Características

- Consulta tasas de cambio actualizadas desde [ExchangeRate-API](https://www.exchangerate-api.com/)
- Soporta múltiples monedas (USD, EUR, GBP, ARS, MXN, etc.)
- Interfaz de línea de comandos interactiva
- Sistema de historial que guarda y muestra las conversiones realizadas incluso si el programa fue cerrada.
- Registros con Marca de Tiempo
- Guardado automático de tasas en formato JSON

## 📋 Requisitos

- Java JDK 11 o superior
- Conexión a internet (para consultar la API)
- Cuenta en [ExchangeRate-API](https://www.exchangerate-api.com/) (API key gratuita)

🏦 Monedas soportadas
Código	Moneda
USD	Dólar estadounidense
EUR	Euro
GBP	Libra esterlina
ARS	Peso argentino
MXN	Peso mexicano
JPY	Yen japonés
...	(Ver clase Moneda.java)
