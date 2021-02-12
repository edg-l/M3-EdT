package com.edgarluque.m3;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Tripulant {
    public static void menu10(ObjectContainer db) {
        ArrayList<Tripulant_Dades> llistaTripulants = new ArrayList<Tripulant_Dades>();
        llistaTripulants.add(new Tripulant_Dades(0, "Kurn_0_1", 1));
        llistaTripulants.add(new Tripulant_Dades(3, "Kurn_3_1", 1));
        llistaTripulants.add(new Tripulant_Dades(2, "Kurn_2_2", 2));
        llistaTripulants.add(new Tripulant_Dades(4, "Worf_4_1", 1));
        llistaTripulants.add(new Tripulant_Dades(1, "Kurn_1_1", 1));

        for (Tripulant_Dades t : llistaTripulants) {
            ObjectSet<Tripulant_Dades> result = db.query(new Predicate<Tripulant_Dades>() {
                @Override
                public boolean match(Tripulant_Dades tripulantDades) {
                    return tripulantDades.getTripulantId() == t.getTripulantId();
                }
            });

            if (result.hasNext()) {
                System.out.println("UPDATE");
                Tripulant_Dades antic = result.next();
                System.out.println(antic);
                System.out.println("Canviat a...");
                antic.setTripulantNom(t.getTripulantNom());
                antic.setDepartamentId(t.getDepartamentId());
                System.out.println(antic);
                db.store(antic);
            } else {
                System.out.println("INSERT");
                System.out.println(t);
                db.store(t);
            }
        }
    }

    //  Veure tots els tripulants
    public static void menu11(ObjectContainer db) {
        ObjectSet<Tripulant_Dades> result = db.query(Tripulant_Dades.class);

        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    // Assignar els tripulants a l'ArrayList del departament
    public static void menu12(ObjectContainer db) {
        ObjectSet<Tripulant_Dades> tripulantsResult = db.query(new Predicate<Tripulant_Dades>() {
            @Override
            public boolean match(Tripulant_Dades tripulantDades) {
                return true;
            }
        });
        ObjectSet<Departament_Dades> departamentsResult = db.query(new Predicate<Departament_Dades>() {
            @Override
            public boolean match(Departament_Dades departament_dades) {
                return true;
            }
        });

        List<Departament_Dades> departaments = new ArrayList<>();
        List<Tripulant_Dades> tripulants = new ArrayList<>();

        while (departamentsResult.hasNext()) {
            Departament_Dades d = departamentsResult.next();
            departaments.add(d);
        }

        while (tripulantsResult.hasNext()) {
            Tripulant_Dades t = tripulantsResult.next();
            tripulants.add(t);
        }

        for (Departament_Dades d : departaments) {
            for (Tripulant_Dades t : tripulants) {
                if (d.getId() == t.getDepartamentId()) {
                    System.out.println("UPDATE");
                    System.out.println(d);
                    d.addTripulant(db, t);
                    db.store(d);
                    System.out.println("Canviat a...");
                    System.out.println(d);
                }
            }
        }
    }
}
