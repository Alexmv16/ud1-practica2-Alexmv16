import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DescargadorDeImagenes {

    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "http://ejemplo.com";
        String html = descargarHTML(url);
        String[] urlsDeImagenes = extraerUrlsDeImagenes(html);

        // TODO: Crear y gestionar procesos para descargar cada imagen
        // TODO: Asegurarse de que todos los procesos de descarga finalicen correctamente
    }

    public static String descargarHTML(String url) throws IOException, InterruptedException {
        ProcessBuilder curlPB = new ProcessBuilder("/usr/bin/curl", "-s", "-X", "GET", url);
        Process proceso = curlPB.start();

        StringBuilder html = new StringBuilder();
        try (Scanner scanner = new Scanner(proceso.getInputStream())) {
            while (scanner.hasNextLine()) {
                html.append(scanner.nextLine()).append(System.lineSeparator());
            }
        }
        proceso.waitFor();
        return html.toString();
    }

    public static String[] extraerUrlsDeImagenes(String html) {
        List<String> urlsDeImagenes = new ArrayList<>();
        Pattern pattern = Pattern.compile("<img [^>]*src=[\"']([^\"']+)[\"'][^>]*>");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            urlsDeImagenes.add(matcher.group(1));
        }

        return urlsDeImagenes.toArray(new String[0]);
    }
}
