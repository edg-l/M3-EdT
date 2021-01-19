package com.edgarluque.m3.exercisis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Streams {
    public static void menu1() {
        Scanner sc = new Scanner(System.in);
        File f1, f2;

        do {
            System.out.println("Path fitxer 1:");
            f1 = new File(sc.nextLine());
        } while (!f1.exists());

        do {
            System.out.println("Path fitxer 2:");
            f2 = new File(sc.nextLine());
        } while (!f2.exists());

        try (BufferedReader reader = new BufferedReader(new FileReader(f1));
             BufferedReader reader2 = new BufferedReader(new FileReader(f2))) {
            int i = 1;
            int count = 0;

            while (reader.ready() || reader2.ready()) {
                String l1 = reader.readLine();
                String l2 = reader2.readLine();

                System.out.println("Linia a: " + l1);
                System.out.println("Linia b: " + l2);

                if (!l1.equals(l2)) {
                    System.out.println("Falla la linia " + i);
                    count++;
                }
                i++;
            }
            System.out.println("Fallen " + count + " linies");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void menu2() {
        List<String> fitxers = new ArrayList<>();
        fitxers.add("a.txt");
        fitxers.add("b.txt");
        fitxers.add("c.txt");

        for (String nom : fitxers) {
            int lineCount = 0;
            int charCount = 0;
            File f = new File(nom);
            try (BufferedReader rd = new BufferedReader(new FileReader(f))) {
                String line = rd.readLine();
                while (line != null) {
                    lineCount++;
                    charCount += line.length();
                    line = rd.readLine();
                }
                System.out.println(String.format("El fitxer %s te %d lineas i %d caracters.",
                        nom, lineCount, charCount));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
