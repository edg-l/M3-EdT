package com.edgarluque.m3;

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
        return new ComprovacioRendiment();
    }

    public static ComprovacioRendiment modificarWaypoints(ComprovacioRendiment comprovacioRendimentTmp) {
        return new ComprovacioRendiment();
    }

    public static ComprovacioRendiment esborrarWaypoint(ComprovacioRendiment comprovacioRendimentTmp) {
        return new ComprovacioRendiment();
    }
}
