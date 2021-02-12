package com.edgarluque.m3;

import com.db4o.ObjectContainer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Departament_Dades implements Comparable<Departament_Dades> {
    private int id;
    private String nom;
    private String email;
    private String telefon;
    private List<Tripulant_Dades> tripulants = new ArrayList<>();

    public Departament_Dades(int id, String nom, String email, String telefon) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telefon = telefon;
    }

    // Si l’objecte tripulant que vols afegir ja existeix en
    // l’ArrayList a llavors fes un update i sinó, fes un add().
    public void addTripulant(ObjectContainer db, Tripulant_Dades tripulantDades) {
        if(!this.tripulants.contains(tripulantDades)) {
            this.tripulants.add(tripulantDades);
        } else {
            db.store(tripulantDades);
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<Tripulant_Dades> getTripulants() {
        return tripulants;
    }

    public void setTripulants(List<Tripulant_Dades> tripulants) {
        this.tripulants = tripulants;
    }

    @Override
    public int compareTo(Departament_Dades departament_dades) {
        return Integer.compare(getId(), departament_dades.getId());
    }

    @Override
    public String toString() {
        return "Departament_Dades{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", tripulants=" + tripulants +
                '}';
    }
}
