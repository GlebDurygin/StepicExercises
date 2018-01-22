package com.IdeaProjects.StepicExercises;


import java.io.*;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        double d;
        double sum = 0.0;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                d = scanner.nextDouble();
                sum += d;
            } else {
                scanner.next();
            }
        }
        System.out.printf(Locale.ENGLISH, "%.6f", sum);
    }

}

