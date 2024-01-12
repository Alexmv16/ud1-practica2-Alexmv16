package org.example;


import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        reverseInputStrings(scanner);
    }

    private static void reverseInputStrings(Scanner scanner) {
        String input = "";
        while (!input.equals("stop")) {
            input = readInput(scanner);
            String reversedString = reverseString(input);
            printReversedString(reversedString);
        }
    }

    private static String readInput(Scanner scanner) {
        return scanner.next();
    }

    private static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    private static void printReversedString(String reversedString) {
        System.out.println(reversedString);
    }
}