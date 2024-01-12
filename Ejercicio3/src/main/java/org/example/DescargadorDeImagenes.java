package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DescargadorDeImagenes {

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

    public static List<String> extraerUrlsDeImagenes(String html) {
        List<String> urlsDeImagenes = new ArrayList<>();
        Pattern pattern = Pattern.compile("<img [^>]*src=[\"']([^\"']+)[\"'][^>]*>");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            urlsDeImagenes.add(matcher.group(1));
        }

        return urlsDeImagenes;
    }

    public static void descargaImagenes(String url) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("/usr/bin/curl", "-O", url);
        pb.directory(new File("Images"));
        Process proceso = pb.start();
        proceso.waitFor();
    }
}
