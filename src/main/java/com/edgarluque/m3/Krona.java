package com.edgarluque.m3;

import java.util.Scanner;

public class Krona {
    public static void run() {
        TextFrame textFrame = new TextFrame();
        textFrame.addTitle("Orbita 10", true);
        textFrame.addEmptyLine();
        textFrame.addLine("RV-18A Krona", true);
        textFrame.addEmptyLine();
        textFrame.addSeparator();
        textFrame.addLine("1. Inicialitzar el procés de comprovació d'un ArrayList i un LinkedList de waypoints.",
                false);
        textFrame.addLine("2. Comprovar rendiment d'inicialització d'un ArrayList i un LinkedList de waypoints.", false);
        textFrame.addLine("3. Comprovar rendiment d'inserció en un ArrayList i en un LinkedList de waypoints.", false);
        textFrame.addLine("4. Modificació dels ID's dels waypoints de l'ArrayList i del LinkedList.", false);
        textFrame.addLine("5. ", false);
        textFrame.addLine("6. ", false);
        textFrame.addLine("7. ", false);
        textFrame.addEmptyLine();
        textFrame.addLine("10. Carregar en la BD les rutes.", false);
        textFrame.addLine("10. Carregar en la BD les rutes carregades en memòria", false);
        textFrame.addLine("11. Llistar les rutes (només amb els ID dels waypoints)", false);
        textFrame.addEmptyLine();
        textFrame.addLine("50. Tornar al menú pare (PNS-24 Puma)", false);
        textFrame.addSeparator();

        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        ComprovacioRendiment comprovacioRendiment = null;

        while (running) {
            textFrame.print();

            System.out.print("Opció: ");
            int opcio = scanner.nextInt();
            boolean waitForInput = false;

            switch (opcio) {
                case 1:
                    comprovacioRendiment = Waypoint.inicialitzarComprovacioRendiment();
                    break;
                case 2:
                    Waypoint.comprovarRendimentInicialitzacio(50000, comprovacioRendiment);
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
