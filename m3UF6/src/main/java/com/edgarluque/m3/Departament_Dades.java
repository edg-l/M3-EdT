package com.edgarluque.m3;

import java.util.LinkedList;
import java.util.List;

public class Departament_Dades {
    private int id;
    private String nom;
    private String email;
    private String telefon;
    private List<Encarrec_Dades> llistaEncarrecs = new LinkedList<Encarrec_Dades>();

    public Departament_Dades(int id, String nom, String email, String telefon) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Departament: ").append(id).append(System.lineSeparator());
        sb.append("Nom: ").append(nom).append(System.lineSeparator());
        sb.append("Email: ").append(email).append(System.lineSeparator());
        sb.append("Telefon: ").append(telefon).append(System.lineSeparator());
        sb.append("Encarrecs:").append(System.lineSeparator());
        for(Encarrec_Dades e: llistaEncarrecs) {
            sb.append(e.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String toStringSencill(Encarrec_Dades encarrecTrobat) {
        StringBuffer sb = new StringBuffer();
        sb.append("Departament: ").append(id).append(System.lineSeparator());
        sb.append("Nom: ").append(nom).append(System.lineSeparator());
        sb.append("Email: ").append(email).append(System.lineSeparator());
        sb.append("Telefon: ").append(telefon).append(System.lineSeparator());
        sb.append("Encarrec Trobat:").append(System.lineSeparator());
        sb.append(encarrecTrobat.toString()).append(System.lineSeparator());
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

    public List<Encarrec_Dades> getLlistaEncarrecs() {
        return llistaEncarrecs;
    }

    public void setLlistaEncarrecs(List<Encarrec_Dades> llistaEncarrecs) {
        this.llistaEncarrecs = llistaEncarrecs;
    }
}
