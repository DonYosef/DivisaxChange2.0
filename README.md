# **<center>Proyecto Divisax Change 2.0</center>**
##### *Entrega final del cuso Java POO (+ implementacion propia de JavaFX) para Alura Latam ( Programa Oracle next education, grupo 6)*

El presente código desarrollado en Java + JavaFX, tiene por finalidad crear una pequeña aplicación de escritorio para convertir divisas de distintas nacionalidades en tiempo real, para esto se realizará la conexión con la API de  [Exchangerate](https://www.exchangerate-api.com/docs/overview "Link API") y asi por medio de está obtener la tasa actual de cambio para cada divisa. Una vez se obtiene dicha tasa es multiplicada y parseada para ser mostrar al usuario el cambio de divisa seleccionado, esto se logra por medio de la interfaz grafica de JavaFX(21) así también se implementó el patrón arquitectonico de MVC para trabajar con los respectivos métodos y vistas de la aplicación.

![0421(1)](https://github.com/DonYosef/DivisaxChange2.0/assets/103342394/35231f9b-f6c1-4bb8-894f-9818df09ec77)

**Método de conexión con la API:**

    public DivisaModel informacionAPI(String base, String target) throws IOException, InterruptedException {
    
        HttpClient client = HttpClient.newHttpClient();

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/482bd76f99b196223709930e/pair/"+base+"/"+target);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        HttpResponse<String> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gsn = new GsonBuilder().create();

        return gsn.fromJson(response.body(), DivisaModel.class);
    }

La anterior conexión tiene un desfase máximo de 12 horas, debido a que de momento está funcionando con una versión gratutita que permite máximo (1000 request), por lo que el monto de conversión puede variar muy levemente.
