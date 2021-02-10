package com.edgarluque.m3;

import com.db4o.ObjectContainer;

import java.util.ArrayList;
import java.util.List;

public class Producte {
    public static void menu1(ObjectContainer db) {
        List<Producte_Dades> producteList = new ArrayList<>();
        producteList.add(new Producte_Dades(1, "Ració de combat", 1, 0));
        producteList.add(new Producte_Dades(2, "Torpede mark 2", 100, 2));
        producteList.add(new Producte_Dades(3, "Autopilot SAU-6", 10, 3));
        producteList.add(new Producte_Dades(4, "Sistema inercial MIS-P", 11, 3));
        producteList.add(new Producte_Dades(5, "Bobina d'inducció magnèticadel reactor principal", 10000, 4));
        producteList.add(new Producte_Dades(6, "Sistema de navegació dellarg abast RSDN-10", 12, 3));

        for(Producte_Dades p: producteList) {
            db.store(p);
        }
    }
}
