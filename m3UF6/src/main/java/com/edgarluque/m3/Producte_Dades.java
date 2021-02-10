package com.edgarluque.m3;

import java.io.Serializable;
import java.text.Collator;

public class Producte_Dades implements Comparable<Producte_Dades>, Serializable {
    private int producteId;
    private String producteNom;
    private int productePreu; // La moneda de l'Imperi Klingon és el darkset.
    private int idDepartamentQueElPotDemanar;

    public Producte_Dades(int producteId, String producteNom, int productePreu, int idDepartamentQueElPotDemanar) {
        this.producteId = producteId;
        this.producteNom = producteNom;
        this.productePreu = productePreu;
        this.idDepartamentQueElPotDemanar = idDepartamentQueElPotDemanar;
    }

    @Override
    public int compareTo(Producte_Dades producte_dades) {
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.SECONDARY);
        return collator.compare(producteNom, producte_dades.producteNom);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Producte: ").append(producteId).append(System.lineSeparator());
        sb.append("Nom: ").append(producteNom).append(System.lineSeparator());
        sb.append("Preu: ").append(productePreu).append(System.lineSeparator());
        sb.append("Departament: ").append(idDepartamentQueElPotDemanar).append(System.lineSeparator());
        return sb.toString();
    }

    public int getProducteId() {
        return producteId;
    }

    public void setProducteId(int producteId) {
        this.producteId = producteId;
    }

    public String getProducteNom() {
        return producteNom;
    }

    public void setProducteNom(String producteNom) {
        this.producteNom = producteNom;
    }

    public int getProductePreu() {
        return productePreu;
    }

    public void setProductePreu(int productePreu) {
        this.productePreu = productePreu;
    }

    public int getIdDepartamentQueElPotDemanar() {
        return idDepartamentQueElPotDemanar;
    }

    public void setIdDepartamentQueElPotDemanar(int idDepartamentQueElPotDemanar) {
        this.idDepartamentQueElPotDemanar = idDepartamentQueElPotDemanar;
    }
}
