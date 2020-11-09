package com.edgarluque.m3.exercisis;

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
        menu.addLine("5. Esborrar waypoints de l'ArrayList i del LinkedList", false);
        menu.addLine("6. Modificar coordenades i nom dels waypoints de l'ArrayList amb ID parell.", false);
        menu.addLine("7. Visualitzar els waypoints de l'ArrayList ordenats", false);
        menu.addLine("8. Llistar els waypoints de l'ArrayList que es trobin a certa distancia de la terra.", false);
        menu.addEmptyLine();
        menu.addLine("10. Inicialitzar una ruta.", false);
        menu.addLine("11. Visualitzar una ruta.", false);
        menu.addLine("12. Invertir una ruta.", false);
        menu.addLine("13. Existeix el waypoint 'Òrbita de Júpiter REPETIDA' en la ruta?.", false);
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
                    comprovacioRendiment = Waypoint.comprovarRendimentInicialitzacio(10, comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 3:
                    comprovacioRendiment = Waypoint.comprovarRendimentInsercio(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 4:
                    comprovacioRendiment = Waypoint.modificarWaypoints(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 5:
                    comprovacioRendiment = Waypoint.esborrarWaypoint(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 6:
                    comprovacioRendiment = Waypoint.modificarCoordenadesINomDeWaypoints(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 7:
                    Waypoint.visualitzarWaypointsOrdenats(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 8:
                    Waypoint.waypointsACertaDistanciaMaxDeLaTerra(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 10:
                    comprovacioRendiment = RutaDades.inicialitzarRuta(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 11:
                    RutaDades.visualitzarRuta(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 12:
                    RutaDades.invertirRuta(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 13:
                    RutaDades.existeixWaypointEnRuta(comprovacioRendiment);
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
