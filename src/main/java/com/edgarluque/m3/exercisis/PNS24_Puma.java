package com.edgarluque.m3.exercisis;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class PNS24_Puma
{
    public static void main( String[] args ) {
        MenuConstructorPantalla menu = new MenuConstructorPantalla();
        menu.addTitle("Orbita 10", true);
        menu.addEmptyLine();
        menu.addLine("PNS-24 Puma" ,true);
        menu.addEmptyLine();
        menu.addSeparator();
        menu.addLine("1. Sistema de navegació Krona", false);
        menu.addLine("2. Sistema d'atac Orion", false);
        menu.addLine("3. Sistema de defensa Sirena", false);
        menu.addLine("4. Sistema de comunicacions Evkalipt", false);
        menu.addLine("5. Sistema d'identificació Khom-Nikel", false);
        menu.addLine("6. Sistema de visualització PPV", false);
        menu.addLine("7. Sistema de grabació Kristall", false);
        menu.addEmptyLine();
        menu.addLine("10. Control de sondes Delta", false);
        menu.addEmptyLine();
        menu.addLine("50. Tancar el sistema", false);
        menu.addEmptyLine();
        menu.addSeparator();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            menu.print();

            System.out.print("Opció: ");
            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    Krona.run();
                    break;
                case 50:
                    running = false;
                    break;
                default:
                    System.out.println("Aquesta funcionalitat encara no esta implementada.");
            }
        }
    }
}
