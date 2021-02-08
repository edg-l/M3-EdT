package com.edgarluque.m3;

import java.text.Collator;

public class Producte_Dades implements Comparable<Producte_Dades> {
    private int producteId;
    private String producteNom;
    private int productePreu; // La moneda de l'Imperi Klingon és el darkset.
    private int idDepartamentQueElPotDemanar;

    @Override
    public int compareTo(Producte_Dades producte_dades) {
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.SECONDARY);
        return collator.compare(producteNom, producte_dades.producteNom);
    }
}
