package com.edgarluque.m3.exercisis_list;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Waypoint {
    public static ComprovacioRendiment inicialitzarComprovacioRendiment() {
        return new ComprovacioRendiment();
    }

    public static ComprovacioRendiment comprovarRendimentInicialitzacio(int numObjACrear,
                                                                        ComprovacioRendiment comprovacioRendimentTmp) {
        if(comprovacioRendimentTmp == null) {
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
        if(comprovacioRendimentTmp == null) {
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
        return new ComprovacioRendiment();
    }

    public static ComprovacioRendiment esborrarWaypoint(ComprovacioRendiment comprovacioRendimentTmp) {
        return new ComprovacioRendiment();
    }
}
