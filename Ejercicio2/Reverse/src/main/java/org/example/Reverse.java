package org.example;

import java.io.*;

public class Reverse {
    public static void main(String[] args) {
        // Creo un hilo secundario para leer las líneas del usuario
        Thread userInputThread = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String userInput;
                while (!(userInput = reader.readLine()).equals("stop")) {
                    System.out.println("Proceso secundario: " + new StringBuilder(userInput).reverse());

                    // Escribo la cadena reversa en reverses.txt
                    try (PrintWriter writer = new PrintWriter(new FileWriter("reverses.txt", true))) {
                        writer.println(new StringBuilder(userInput).reverse());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Inicio el hilo secundario
        userInputThread.start();

        // Leo las líneas del usuario y muestro en pantalla
        try (BufferedReader mainReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (!(input = mainReader.readLine()).equals("stop")) {
                System.out.println("Proceso principal: " + new StringBuilder(input).reverse());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Espero a que el hilo secundario termine
        try {
            userInputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
