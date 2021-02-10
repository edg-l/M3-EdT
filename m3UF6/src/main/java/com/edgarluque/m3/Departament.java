package com.edgarluque.m3;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;

public class Departament {
    public static void menu3(ObjectContainer db) {
        for(int i = 1; i < IKSRotarranConstants.DEPARTAMENTS.length; i++) {
            String nom = IKSRotarranConstants.DEPARTAMENTS[i];
            String telefon = "";
            for(int j = 0; j < 9; j++) {
                telefon += i;
            }
            Departament_Dades dep = new Departament_Dades(
                i, nom, nom + "@IKSRotarran.ik",
                telefon
            );
            db.store(dep);
        }
    }

    public static void menu4(ObjectContainer db) {
        List<Departament_Dades> deps = new ArrayList<>();

        ObjectSet<Departament_Dades> result = db.query(Departament_Dades.class);
        while(result.hasNext()) {
            Departament_Dades dep = result.next();
            deps.add(dep);
            System.out.println(dep);
        }
    }
}
