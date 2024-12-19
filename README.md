# Conversor de Monedas

Este proyecto es un programa en Java que permite realizar conversiones de moneda en tiempo real utilizando la API [ExchangeRate-API](https://www.exchangerate-api.com/). El usuario puede seleccionar entre varias opciones de conversión y proporcionar una cantidad para obtener el valor convertido.

## Características

- Soporte para múltiples pares de monedas:
  - Dólar estadounidense (USD) ⇆ Peso argentino (ARS)
  - Dólar estadounidense (USD) ⇆ Real brasileño (BRL)
  - Dólar estadounidense (USD) ⇆ Peso colombiano (COP)
- Integración con la API ExchangeRate-API para obtener tasas de cambio actualizadas.
- Interfaz interactiva basada en consola para la selección de opciones y entrada de datos.

## Requisitos

- [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- Biblioteca [Gson](https://github.com/google/gson) para el manejo de JSON
- Conexión a internet para acceder a la API de ExchangeRate

## Estructura del Código

El código se divide en dos clases principales:

### `PrincipalConBusqueda`

Esta clase contiene el método `main` que:
- Muestra un menú interactivo para que el usuario seleccione las monedas a convertir.
- Solicita al usuario la cantidad a convertir.
- Llama a la clase `ConversorMoneda` para realizar la conversión.

### `ConversorMoneda`

Esta clase encapsula la lógica de la conversión:
- Envía una solicitud HTTP a la API con las monedas seleccionadas.
- Parse el JSON de respuesta para extraer la tasa de conversión.
- Calcula el valor convertido y lo imprime en la consola.

## Cómo Ejecutar

1. Clona este repositorio o copia el archivo `PrincipalConBusqueda.java`.
2. Asegúrate de tener configurada la biblioteca Gson en tu proyecto.
   - Si usas un gestor de dependencias como Maven, añade esta dependencia:
     ```xml
     <dependency>
         <groupId>com.google.code.gson</groupId>
         <artifactId>gson</artifactId>
         <version>2.8.9</version>
     </dependency>
     ```
3. En la variable `clave` pon tu propia clave de API de ExchangeRate-API.
4. Compila y ejecuta el programa:
   ```bash
   javac PrincipalConBusqueda.java
   java PrincipalConBusqueda
   ```

## Ejemplo de Uso

1. El programa muestra un menú con opciones de conversión:
   ```
   *****************************************************
   Sea bienvenido/a al conversor de moneda =] 
   1) Dólar => Peso argentino
   2) Peso argentino => Dólar
   3) Dólar => Real brasileño
   4) Real brasileño => Dólar
   5) Dólar => Peso colombiano
   6) Peso colombiano => Dólar
   7) Salir
   Elija una opción válida: 
   *****************************************************
   ```
2. El usuario selecciona una opción, por ejemplo, `1` para convertir de Dólar a Peso argentino.
3. Se solicita la cantidad a convertir:
   ```
   Ingrese la cantidad a convertir:
   100
   ```
4. El programa muestra el resultado de la conversión:
   ```
   100.00 USD equivale a 9475.00 ARS
   ```

## Notas

- Asegúrate de que la clave de la API sea válida y tenga suficiente cuota para las solicitudes.
- Si la API no responde o hay un error de conexión, el programa mostrará un mensaje de error apropiado.


