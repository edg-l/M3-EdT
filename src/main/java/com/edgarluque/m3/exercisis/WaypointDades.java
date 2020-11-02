package com.edgarluque.m3.exercisis;

import java.time.LocalDateTime;
import java.util.Arrays;

public class WaypointDades {
    private int id;
    private String nom;
    private int[] coordenades;
    private boolean actiu;

    private LocalDateTime dataCreacio;
    private LocalDateTime dataAnulacio;
    private LocalDateTime dataModificacio;

    public WaypointDades(int id,
                         String nom,
                         int[] coordenades,
                         boolean actiu,
                         LocalDateTime dataCreacio,
                         LocalDateTime dataAnulacio,
                         LocalDateTime dataModificacio) {
        this.id = id;
        this.nom = nom;
        this.coordenades = coordenades;
        this.actiu = actiu;
        this.dataCreacio = dataCreacio;
        this.dataAnulacio = dataAnulacio;
        this.dataModificacio = dataModificacio;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WaypointDades{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", coordenades=").append(Arrays.toString(coordenades));
        sb.append(", actiu=").append(actiu);
        sb.append(", dataCreacio=").append(dataCreacio);
        sb.append(", dataAnulacio=").append(dataAnulacio);
        sb.append(", dataModificacio=").append(dataModificacio);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
