package com.edgarluque.m3.exercisis_list;

import java.util.Scanner;

public class Krona {
    public static void run() {
        MenuConstructorPantalla menu = new MenuConstructorPantalla();
        menu.addTitle("Orbita 10", true);
        menu.addEmptyLine();
        menu.addLine("RV-18A Krona", true);
        menu.addEmptyLine();
        menu.addSeparator();
        menu.addLine("1. Inicialitzar el procés de comprovació d'un ArrayList i un LinkedList de waypoints.",
                false);
        menu.addLine("2. Comprovar rendiment d'inicialització d'un ArrayList i un LinkedList de waypoints.", false);
        menu.addLine("3. Comprovar rendiment d'inserció en un ArrayList i en un LinkedList de waypoints.", false);
        menu.addLine("4. Modificació dels ID's dels waypoints de l'ArrayList i del LinkedList.", false);
        menu.addLine("5. ", false);
        menu.addLine("6. ", false);
        menu.addLine("7. ", false);
        menu.addEmptyLine();
        menu.addLine("10. Carregar en la BD les rutes.", false);
        menu.addLine("10. Carregar en la BD les rutes carregades en memòria", false);
        menu.addLine("11. Llistar les rutes (només amb els ID dels waypoints)", false);
        menu.addEmptyLine();
        menu.addLine("50. Tornar al menú pare (PNS-24 Puma)", false);
        menu.addSeparator();

        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        ComprovacioRendiment comprovacioRendiment = null;

        while (running) {
            menu.print();

            System.out.print("Opció: ");
            int opcio = scanner.nextInt();
            boolean waitForInput = false;

            switch (opcio) {
                case 1:
                    comprovacioRendiment = Waypoint.inicialitzarComprovacioRendiment();
                    break;
                case 2:
                    Waypoint.comprovarRendimentInicialitzacio(10, comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 3:
                    Waypoint.comprovarRendimentInsercio(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 50:
                    running = false;
                    break;
                default:
                    System.out.println("Aquesta funcionalitat encara no esta implementada.");
                    waitForInput = true;
            }

            if(waitForInput) {
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
