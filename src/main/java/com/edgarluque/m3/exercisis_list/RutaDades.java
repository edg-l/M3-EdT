package com.edgarluque.m3.exercisis_list;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
}