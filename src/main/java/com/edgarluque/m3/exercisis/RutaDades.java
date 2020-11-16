package com.edgarluque.m3.exercisis;

import llibreries.varies.Data;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RutaDades {
    private int id;
    private String nom;
    private ArrayList<Integer> waypoints;
    private boolean actiu;
    private LocalDateTime dataCreacio;
    private LocalDateTime dataAnulacio;
    private LocalDateTime dataModificacio;

    public RutaDades(int id,
                     String nom,
                     ArrayList<Integer> waypoints,
                     boolean actiu,
                     LocalDateTime dataCreacio,
                     LocalDateTime dataAnulacio,
                     LocalDateTime dataModificacio) {
        this.id = id;
        this.nom = nom;
        this.waypoints = waypoints;
        this.actiu = actiu;
        this.dataCreacio = dataCreacio;
        this.dataAnulacio = dataAnulacio;
        this.dataModificacio = dataModificacio;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RutaDades{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", waypoints=").append(waypoints);
        sb.append(", actiu=").append(actiu);
        sb.append(", dataCreacio=").append(dataCreacio);
        sb.append(", dataAnulacio=").append(dataAnulacio);
        sb.append(", dataModificacio=").append(dataModificacio);
        sb.append('}');
        return sb.toString();
    }

    public static List<WaypointDades> crearRutaInicial() {
        List<WaypointDades> ruta = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ruta.add(new WaypointDades(
                    i, "A" + Integer.toString(i), new int[]{0, i, i * 2}, true, LocalDateTime.now(),
                    null, null
            ));
        }

        return ruta;
    }

    public static ComprovacioRendiment inicialitzarRuta(ComprovacioRendiment tmp) {
        List<WaypointDades> rutaInicial = crearRutaInicial();

        for (WaypointDades w : rutaInicial) {
            tmp.pilaWaypoints.push(w);
            System.out.println("Afegit waypoint amb id " + w.getId() + " a la pila.");
        }

        WaypointDades nouWaypoint = new WaypointDades(4,
                "Òrbita de Júpiter REPETIDA",
                new int[]{4, 4, 4}, true,
                LocalDateTime.parse("21-10-2020 00:30", Data.FORMATTER),
                null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER));

        tmp.pilaWaypoints.push(nouWaypoint);
        tmp.wtmp = nouWaypoint;
        return tmp;
    }

    public static void visualitzarRuta(ComprovacioRendiment tmp) {
        System.out.println("Ruta formada per waypoints:");
        for(WaypointDades w: tmp.pilaWaypoints) {
            System.out.println(w.toString());
        }
    }

    public static void invertirRuta(ComprovacioRendiment tmp) {
        Deque<WaypointDades> inversa = new ArrayDeque<>(tmp.pilaWaypoints.size());

        while(!tmp.pilaWaypoints.isEmpty()) {
            inversa.push(tmp.pilaWaypoints.pop());
        }

        System.out.println("Pila inversa:");
        for(WaypointDades w: inversa) {
            System.out.println(w.toString());
        }

        tmp.pilaWaypoints = inversa;
    }

    public static void existeixWaypointEnRuta(ComprovacioRendiment tmp) {
        if(tmp.wtmp == null)
            return;

        for(WaypointDades w: tmp.pilaWaypoints) {
            if(tmp.wtmp == w) {
                System.out.println("S'ha trobut el waypoint wtmp.");
                return;
            }
        }

        System.out.println("No s'ha trobat el waypoint wtmp.");
    }
}
