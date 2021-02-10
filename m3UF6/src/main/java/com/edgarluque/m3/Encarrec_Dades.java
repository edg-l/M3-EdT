package com.edgarluque.m3;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Encarrec_Dades {
    private int idEncarrec;
    private int idDepartamentQueElDemana;
    private ArrayList<Producte_Dades> llistaProductes = new ArrayList<Producte_Dades>();
    private LocalDateTime data;

    public Encarrec_Dades(int idEncarrec, int idDepartamentQueElDemana, LocalDateTime data) {
        this.idEncarrec = idEncarrec;
        this.idDepartamentQueElDemana = idDepartamentQueElDemana;
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Encarrec: ").append(idEncarrec).append(System.lineSeparator());
        sb.append("Departament: ").append(idDepartamentQueElDemana).append(System.lineSeparator());
        sb.append("Data:").append(data).append(System.lineSeparator());
        sb.append("Productes:").append(System.lineSeparator());
        for(Producte_Dades p: llistaProductes) {
            sb.append(p.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
