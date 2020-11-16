package com.edgarluque.m3.exercisis;

import com.edgarluque.m3.llibreries.varies.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public void printCoordenades() {
        System.out.printf("Coordenades: (%d, %d, %d)\n", coordenades[0], coordenades[1], coordenades[2]);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        final StringBuilder sb = new StringBuilder();
        sb.append("WAYPOINT ").append(id).append(System.lineSeparator());
        sb.append("\tnom = ").append(nom).append(System.lineSeparator());
        sb.append("\tcoordenades(x, y, z) = ").append(String.format("(%d,%d,%d)", coordenades[0], coordenades[1], coordenades[2]))
                .append(String.format(" (distancia = %d)", distanciaATerra())).append(System.lineSeparator());
        sb.append("\tactiu = ").append(Boolean.toString(actiu)).append(System.lineSeparator());
        sb.append("\tdataCreacio = ").append(Data.imprimirData(dataCreacio)).append(System.lineSeparator());
        sb.append("\tdataAnulacio = ").append(Data.imprimirData(dataAnulacio)).append(System.lineSeparator());
        sb.append("\tdataModificacio = ").append(Data.imprimirData(dataModificacio)).append(System.lineSeparator());
        return sb.toString();
    }

    public int distanciaATerra() {
        return (int) (Math.pow(coordenades[0], 2) + Math.pow(coordenades[1], 2) + Math.pow(coordenades[2], 2));
    }

    public int compareTo(WaypointDades dades) {
        double dist1 = distanciaATerra();
        double dist2 = dades.distanciaATerra();

        if(dist1 < dist2)
            return -1;
        if(dist1 > dist2)
            return 1;

        return nom.compareTo(dades.getNom());
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

    public int[] getCoordenades() {
        return coordenades;
    }

    public void setCoordenades(int[] coordenades) {
        this.coordenades = coordenades;
    }
}
