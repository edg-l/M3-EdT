package com.edgarluque.m3;


import java.text.Collator;

public class Tripulant_Dades implements Comparable<Tripulant_Dades> {
    private int tripulantId;
    private String tripulantNom;
    private int departamentId;

    public Tripulant_Dades(int tripulantId, String tripulantNom, int departamentId) {
        this.tripulantId = tripulantId;
        this.tripulantNom = tripulantNom;
        this.departamentId = departamentId;
    }

    public int getTripulantId() {
        return tripulantId;
    }

    public void setTripulantId(int tripulantId) {
        this.tripulantId = tripulantId;
    }

    public String getTripulantNom() {
        return tripulantNom;
    }

    public void setTripulantNom(String tripulantNom) {
        this.tripulantNom = tripulantNom;
    }

    public int getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }

    // Exercisi 2
    @Override
    public int compareTo(Tripulant_Dades tripulant_dades) {
        if (departamentId != tripulant_dades.getDepartamentId()) {
            return Integer.compare(departamentId, tripulant_dades.getDepartamentId());
        } else {
            Collator collator = Collator.getInstance();
            collator.setStrength(Collator.SECONDARY);
            return collator.compare(tripulantNom, tripulant_dades.getTripulantNom());
        }
    }

    @Override
    public String toString() {
        return String.format("Tripulant_Dades [Id = %d, nom = %s, departament Id = %d]",
                getTripulantId(), getTripulantNom(), getDepartamentId());
    }
}
