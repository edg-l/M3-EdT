package com.edgarluque.m3.exercisis;

import java.io.*;
import java.util.Scanner;

public class Kristall {
    public static void run() {
        MenuConstructorPantalla menu = new MenuConstructorPantalla();
        menu.addTitle("Orbita 10", true);
        menu.addEmptyLine();
        menu.addLine("Kristall", true);
        menu.addEmptyLine();
        menu.addSeparator();
        menu.addLine("1. Comparar 2 fitxers", false);
        menu.addLine("2. Nº de linies i caracters d'una llista d'arxius (I)", false);
        menu.addLine("3. Nº de linies i caracters d'una llista d'arxius (II)", false);
        menu.addLine("4. Nº de repeticions de caracters en un fitxer", false);
        menu.addLine("5. Links d'una URL a un fitxer", false);
        menu.addEmptyLine();
        menu.addLine("10. Mostrar contingut d'un directori", false);
        menu.addLine("10. Fer copia seguretat d'un directori (copia automatica)", false);
        menu.addLine("11. Fer copia seguretat d'un directori (copia manual)", false);
        menu.addEmptyLine();
        menu.addLine("20. FileUtils I", false);
        menu.addLine("21. FileUtils II", false);
        menu.addLine("22. FileUtils III", false);
        menu.addEmptyLine();
        menu.addLine("30. Guardar les naus amb RandomAccessFile", false);
        menu.addLine("30. Recuperar les naus amb RandomAccessFile", false);
        menu.addLine("30. Recuperar les naus amb RandomAccessFile", false);
        menu.addEmptyLine();
        menu.addLine("50. Tornar al menu pare (PNS-24 Puma)", false);

        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        while (running) {
            menu.print();

            System.out.print("Opció: ");
            int opcio = scanner.nextInt();
            boolean waitForInput = false;

            switch (opcio) {
                case 1:
                    menu1();
                    waitForInput = true;
                    break;
                case 50:
                    running = false;
                    break;
                default:
                    System.out.println("Aquesta funcionalitat encara no esta implementada.");
                    waitForInput = true;
                    break;
            }

            if (waitForInput) {
                System.out.println("Presiona qualsevol tecla per continuar.");
                try {
                    System.in.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

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
            while(reader.ready() && reader2.ready()) {
                String l1 = reader.readLine();
                String l2 = reader2.readLine();

                System.out.println("Linia a: " + l1);
                System.out.println("Linia b: " + l2);

                if(!l1.equals(l2)) {
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
}
