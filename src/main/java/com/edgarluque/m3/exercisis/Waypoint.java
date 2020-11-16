package com.edgarluque.m3.exercisis;

import com.edgarluque.m3.llibreries.varies.Cadena;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Waypoint {
    public static ComprovacioRendiment inicialitzarComprovacioRendiment() {
        return new ComprovacioRendiment();
    }

    public static ComprovacioRendiment comprovarRendimentInicialitzacio(int numObjACrear,
                                                                        ComprovacioRendiment comprovacioRendimentTmp) {
        if (comprovacioRendimentTmp == null) {
            System.out.println("ComprovacioRendiment no esta inicialitzada.");
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("El temps es mostra en millis.");

        long now = System.nanoTime();
        for (int i = 0; i < numObjACrear; i++) {
            comprovacioRendimentTmp.llistaLinkedList.add(new WaypointDades(
                    0, "Òrbita de la Terra",
                    new int[]{0, 0, 0}, true,
                    LocalDateTime.parse("15-08-1954 00:01", formatter),
                    null, null
            ));
        }

        long linkedListTime = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar %d waypoints en LinkedList: %d",
                numObjACrear,
                Duration.ofNanos(linkedListTime).toMillis()));

        now = System.nanoTime();
        for (int i = 0; i < numObjACrear; i++) {
            comprovacioRendimentTmp.llistaArrayList.add(new WaypointDades(
                    0, "Òrbita de la Terra",
                    new int[]{0, 0, 0}, true,
                    LocalDateTime.parse("15-08-1954 00:01", formatter),
                    null, null
            ));
        }
        long arrayListTime = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar %d waypoints en l'ArrayList: %d",
                numObjACrear,
                Duration.ofNanos(arrayListTime).toMillis()));

        return comprovacioRendimentTmp;
    }

    public static ComprovacioRendiment comprovarRendimentInsercio(ComprovacioRendiment comprovacioRendimentTmp) {
        if (comprovacioRendimentTmp == null) {
            System.out.println("ComprovacioRendiment no esta inicialitzada.");
            return null;
        }

        System.out.println("El temps es mostra en nanos.");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        int meitatLinked = comprovacioRendimentTmp.llistaLinkedList.size() / 2;
        int meitatArray = comprovacioRendimentTmp.llistaArrayList.size() / 2;

        System.out.println("llistaLinkedList.size(): " + comprovacioRendimentTmp.llistaLinkedList.size());
        System.out.println("llistaLinkedList meitat: " + meitatLinked);

        long now = System.nanoTime();
        comprovacioRendimentTmp.llistaLinkedList.add(0, new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        long time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar 1a pos LinkedList: %d",
                time));

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaArrayList.add(0, new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar 1a pos ArrayList: %d",
                time));

        System.out.println("----");

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaLinkedList.add(meitatLinked, new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar a la meitat LinkedList: %d",
                time));

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaArrayList.add(meitatArray, new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar a la meitat ArrayList: %d",
                time));

        System.out.println("----");

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaLinkedList.add(new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar al final LinkedList: %d",
                Duration.ofNanos(time).toMillis()));

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaArrayList.add(new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar al final ArrayList: %d",
                time));

        return comprovacioRendimentTmp;
    }

    public static ComprovacioRendiment modificarWaypoints(ComprovacioRendiment comprovacioRendimentTmp) {
        System.out.println("----Apartat 1-----");
        List<Integer> idsPerArrayList = new ArrayList<>();
        for (int i = 0, n = comprovacioRendimentTmp.llistaArrayList.size(); i < n; i++) {
            idsPerArrayList.add(i);
        }
        System.out.println("S'ha inicialitzat idsPerArrayList amb " + comprovacioRendimentTmp.llistaArrayList.size() + " nombres.");
        System.out.println("Primer valor te un: " + idsPerArrayList.get(0));
        System.out.println("L'ultim valor te un: " + idsPerArrayList.get(idsPerArrayList.size() - 1));

        // Apartat 2
        System.out.println("---Apartat 2---");
        for (Integer id : idsPerArrayList) {
            System.out.printf("Abans del canvi (i=%d): %d\n", id, comprovacioRendimentTmp.llistaArrayList.get(id).getId());
            comprovacioRendimentTmp.llistaArrayList.get(id).setId(id);
            System.out.printf("Despres del canvi (i=%d): %d\n\n", id, comprovacioRendimentTmp.llistaArrayList.get(id).getId());
        }

        System.out.println("---Apartat 3.1 (bucle for)---");
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            System.out.printf("ID = %d, nom = %s\n", dades.getId(), dades.getNom());
        }

        System.out.println();
        System.out.println("---Apartat 3.2 (iterador)---");
        for (Iterator<WaypointDades> it = comprovacioRendimentTmp.llistaArrayList.iterator(); it.hasNext(); ) {
            WaypointDades dades = it.next();
            System.out.printf("ID = %d, nom = %s\n", dades.getId(), dades.getNom());
        }

        System.out.println();
        System.out.println("---Apartat 4---");
        System.out.printf("La llista linked list s'esborrara amb %d elements.\n", comprovacioRendimentTmp.llistaLinkedList.size());
        comprovacioRendimentTmp.llistaLinkedList.clear();
        System.out.println("Esborrada.");

        comprovacioRendimentTmp.llistaLinkedList.addAll(comprovacioRendimentTmp.llistaArrayList);
        System.out.println("Copiat els elements de llistaArrayList a llistaLinkedList: " + comprovacioRendimentTmp.llistaLinkedList.size());

        System.out.println("---Apartat 5.1 (bucle for)---");
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            if (dades.getId() > 5) {
                dades.setNom("Òrbita de Mart.");
                System.out.println("Modificat waypoint amb id = " + dades.getId());
            }
        }

        System.out.println();
        System.out.println("---Apartat 5.1 (comprovacio)---");
        for (int i = 0; i < comprovacioRendimentTmp.llistaArrayList.size(); i++) {
            WaypointDades dades = comprovacioRendimentTmp.llistaArrayList.get(i);
            System.out.printf("El waypoint amb id = %d te el nom = %s\n", dades.getId(), dades.getNom());
        }

        System.out.println("---Apartat 5.2 (bucle for)---");
        for (WaypointDades dades : comprovacioRendimentTmp.llistaLinkedList) {
            if (dades.getId() < 5) {
                dades.setNom("Punt Lagrange entre la Terra i la LLuna");
                System.out.println("Modificat waypoint amb id = " + dades.getId());
            }
        }

        System.out.println();
        System.out.println("---Apartat 5.2(comprovacio)---");
        for (int i = 0; i < comprovacioRendimentTmp.llistaLinkedList.size(); i++) {
            WaypointDades dades = comprovacioRendimentTmp.llistaLinkedList.get(i);
            System.out.printf("El waypoint amb id = %d te el nom = %s\n", dades.getId(), dades.getNom());
        }

        return comprovacioRendimentTmp;
    }

    public static ComprovacioRendiment esborrarWaypoint(ComprovacioRendiment comprovacioRendimentTmp) {
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            if (dades.getId() < 6) {
                comprovacioRendimentTmp.llistaArrayList.remove(dades);
            }
        }

        System.out.println("---Apartat 2 iterator---");
        for (Iterator<WaypointDades> it = comprovacioRendimentTmp.llistaLinkedList.iterator(); it.hasNext(); ) {
            WaypointDades dades = it.next();

            if (dades.getId() > 4) {
                System.out.println("Esborrat waypoint amb id = " + dades.getId());
                it.remove();
            }
        }

        System.out.println("---Apartat 2 comprovacio---");
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            System.out.printf("El waypoint amb id = %d te el nom = %s\n", dades.getId(), dades.getNom());
        }

        System.out.println("---Apartat 3 listiterator---");
        for (ListIterator<WaypointDades> it = comprovacioRendimentTmp.llistaLinkedList.listIterator(1); it.hasNext(); ) {
            WaypointDades dades = it.next();

            if (dades.getId() == 2) {
                System.out.println("Esborrat waypoint amb id = " + dades.getId());
                it.remove();
            }
        }

        System.out.println("---Apartat 3 comprovacio---");
        for (ListIterator<WaypointDades> it =
             comprovacioRendimentTmp.llistaLinkedList.listIterator(comprovacioRendimentTmp.llistaLinkedList.size()); it.hasPrevious(); ) {
            WaypointDades dades = it.previous();

            System.out.printf("El waypoint amb id = %d te el nom = %s\n", dades.getId(), dades.getNom());
        }
        return comprovacioRendimentTmp;
    }

    public static ComprovacioRendiment modificarCoordenadesINomDeWaypoints(ComprovacioRendiment comprovacioRendimentTmp) {
        Scanner sc = new Scanner(System.in);
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            if(dades.getId() % 2 != 0)
                continue;
            System.out.println("---Modificar waypoint amb id " + dades.getId() + "----");
            System.out.println("Nom: " + dades.getNom());
            dades.printCoordenades();
            System.out.println("Introdueix el nou nom:");
            dades.setNom(sc.nextLine());

            boolean done = false;
            int[] coordenades = new int[3];
            while (!done) {
                System.out.println("Introdueix les noves coordenades:");
                String[] coords = sc.nextLine().split(" ");

                if (coords.length < 3)
                    continue;

                for (int i = 0; i < coords.length; i++) {
                    if (Cadena.stringIsInt(coords[i])) {
                        coordenades[i] = Integer.parseInt(coords[i]);
                        done = true;
                    } else {
                        done = false;
                        break;
                    }
                }
            }

            dades.setCoordenades(coordenades);
            System.out.println("Coordenades noves:");
            dades.printCoordenades();
        }

        return comprovacioRendimentTmp;
    }

    public static void visualitzarWaypointsOrdenats(ComprovacioRendiment comprovacioRendimentTmp) {
        comprovacioRendimentTmp.llistaArrayList.sort(WaypointDades::compareTo);
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            System.out.println(dades.toString());
        }
    }

    public static void waypointsACertaDistanciaMaxDeLaTerra(ComprovacioRendiment comprovacioRendimentTmp) {
        Scanner sc = new Scanner(System.in);
        int dist = 0;

        while (true) {
            String stringNum = sc.nextLine();
            System.out.println("Distancia maxima de la terra:");
            if (Cadena.stringIsInt(stringNum)) {
                dist = Integer.parseInt(stringNum);
                break;
            }
        }

        List<WaypointDades> dades = new ArrayList<>(comprovacioRendimentTmp.llistaArrayList.size());

        for (WaypointDades w : comprovacioRendimentTmp.llistaArrayList) {
            if (w.distanciaATerra() >= dist)
                dades.add(w);
        }

        dades.sort(WaypointDades::compareTo);

        for (WaypointDades w : dades) {
            System.out.println(w.toString());
        }
    }
}
