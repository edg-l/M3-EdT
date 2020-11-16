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
        menu.addLine("20. Inicialitzar llista de rutes", false);
        menu.addLine("21. Ficar tots els waypoints en un set", false);
        menu.addLine("22. Waypoints que estan en totes les rutes", false);
        menu.addLine("23. Waypoints que estan en la ruta A i no en la ruta B", false);
        menu.addLine("24. Ordenar les rutes per waypoints i ID (el id de mes gran a mes petit)", false);
        menu.addLine("25. ", false);
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
                    comprovacioRendiment = Ruta.inicialitzarRuta(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 11:
                    Ruta.visualitzarRuta(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 12:
                    Ruta.invertirRuta(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 13:
                    Ruta.existeixWaypointEnRuta(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 20:
                    comprovacioRendiment = Ruta.inicialitzaLListaRutes(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 21:
                    Ruta.setUnio(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 22:
                    Ruta.setInterseccio(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 23:
                    Ruta.setResta(comprovacioRendiment);
                    waitForInput = true;
                    break;
                case 24:
                    Ruta.crearSetOrdenatDeRutes(comprovacioRendiment);
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
