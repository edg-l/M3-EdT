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
                    Streams.menu1();
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

}
