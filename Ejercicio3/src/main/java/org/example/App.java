package org.example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        String url = "https://portal.edu.gva.es/cipfpbatoi/secretaria/";

        try {
            String html = DescargadorDeImagenes.descargarHTML(url);
            List<String> urlsImagenes = DescargadorDeImagenes.extraerUrlsDeImagenes(html);

            ExecutorService executor = Executors.newFixedThreadPool(urlsImagenes.size());
            for (String imgUrl : urlsImagenes) {
                executor.submit(() -> {
                    try {
                        DescargadorDeImagenes.descargaImagenes(imgUrl);
                    } catch (Exception e) {
                        e.printStackTrace();
                        // Manejar errores de descarga de imagen
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar errores generales
        }
    }
}
