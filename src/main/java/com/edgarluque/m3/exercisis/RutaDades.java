package com.edgarluque.m3.exercisis;

import com.edgarluque.m3.llibreries.varies.Data;

import java.time.LocalDateTime;
import java.util.*;

public class RutaDades implements Comparable<RutaDades> {
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

    public int getId() {
        return id;
    }



    public ArrayList<Integer> getWaypoints() {
        return waypoints;
    }

    public void imprimir() {
        System.out.println(nom + ": waypoints" + waypoints);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dades de la ruta" + System.lineSeparator());
        sb.append("id =").append(id).append(System.lineSeparator());
        sb.append("nom = ").append(nom).append(System.lineSeparator());
        sb.append("waypoints =").append(waypoints).append(System.lineSeparator());
        sb.append("actiu =").append(actiu).append(System.lineSeparator());
        sb.append("dataCreacio =").append(Data.imprimirData(dataCreacio)).append(System.lineSeparator());
        sb.append("dataAnulacio =").append(Data.imprimirData(dataAnulacio)).append(System.lineSeparator());
        sb.append("dataModificacio =").append(Data.imprimirData(dataModificacio));
        return sb.toString();
    }

    @Override
    public int compareTo(RutaDades rutaDades) {
        if(waypoints.size() == rutaDades.waypoints.size()) {
            HashSet<Integer> wp = new HashSet<>(waypoints);
            wp.removeAll(rutaDades.waypoints);
            if(wp.isEmpty())
                return 0;
        }
        return Integer.compare(rutaDades.getId(), id);
    }

    public static int compare(RutaDades a, RutaDades b) {
        return a.compareTo(b);
    }
}
