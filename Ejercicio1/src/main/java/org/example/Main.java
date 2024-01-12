package org.example;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] comando = {"cmd", "/c", "dir"};
        ejercicio1(comando);
    }

    public static void ejercicio1(String[] comando) {
        ProcessBuilder pb = new ProcessBuilder(comando);

        pb.redirectErrorStream(true);

        try {
            Process process = pb.start();

            int timeoutSeconds = 2;
            boolean processCompleted = process.waitFor(timeoutSeconds, java.util.concurrent.TimeUnit.SECONDS);

            // Leo la salida del proceso
            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

            // Imprimir el resultado del proceso hijo
            System.out.println("Resultado de la ejecución del proceso hijo: ");
            System.out.println(output);

            if (processCompleted) {
                System.out.println("El tiempo de espera ha finalizado.");
            } else {
                System.out.println("El tiempo de espera ha agotado. ");

                // Obtener la salida del proceso hijo
                int exitValue = process.exitValue();

                if (exitValue == 0) {

                    String directorioActual = System.getProperty("user.dir");

                    String rutaOutput = directorioActual + File.separator + "output.txt";

                    // Escribir en el archivo output.txt
                    try (PrintWriter writer = new PrintWriter(new FileWriter(rutaOutput))) {
                        writer.write(output.toString());
                        System.out.println("Archivo output.txt creado exitosamente en: " + rutaOutput);
                    } catch (IOException e) {
                        System.out.println("Error al escribir en el archivo output.txt: " + e.getMessage());
                    }
                } else {
                    System.out.println("Error en la ejecución del proceso hijo. Código de salida: " + exitValue);
                }
            }
            process.destroy();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
