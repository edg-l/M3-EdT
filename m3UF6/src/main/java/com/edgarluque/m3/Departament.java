package com.edgarluque.m3;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Departament {
    // Exercisi 4
    public static void menu1(ObjectContainer db) {
        Departament_Dades departament;
        String email;
        String telefon;


        // La 1a posició de IKSRotarranConstants.DEPARTAMENTS[] no té res.
        for (int i = 1; i < IKSRotarranConstants.DEPARTAMENTS.length; i++) {
            email = IKSRotarranConstants.DEPARTAMENTS[i] + "@IKSRotarran.ik";

            telefon = "";
            for (int j = 0; j < 9; j++) {
                telefon = telefon + String.valueOf(i);
            }

            departament = new Departament_Dades(i, IKSRotarranConstants.DEPARTAMENTS[i], email, telefon);

            db.store(departament);
            System.out.println(String.format("CREAT EL DEPARTAMENT %s AMB ID = %d", departament.getNom(), departament.getId()));
        }
    }

    // Exercisi 4
    public static void menu2(ObjectContainer db) {
        ObjectSet<Departament_Dades> objectSet = db.query(Departament_Dades.class);

        List<Departament_Dades> deps = new ArrayList<>();

        while (objectSet.hasNext()) {
            Departament_Dades d = objectSet.next();
            deps.add(d);
        }

        Collections.sort(deps);

        System.out.println("DEPARTAMENTS:");
        for(Departament_Dades d: deps) {
            System.out.println(String.format("%d - %s", d.getId(), d.getNom()));
        }
    }

    public static void menu3(ObjectContainer db) {
        ObjectSet<Departament_Dades> objectSet = db.query(Departament_Dades.class);

        List<Departament_Dades> deps = new ArrayList<>();

        while (objectSet.hasNext()) {
            Departament_Dades d = objectSet.next();
            deps.add(d);
        }

        Collections.sort(deps);

        for(Departament_Dades d: deps) {
            System.out.println(String.format("%d - %s", d.getId(), d.getNom()));
        }

        int numero = 0;
        boolean error = false;

        Scanner sc = new Scanner(System.in);

        do {
            error = false;
            System.out.println("Introdueix un numero:");
            String resposta = sc.nextLine();
            if(!Cadena.stringIsInt(resposta)) {
                System.out.println("No es nombre valid.");
                error = true;
            }
            else {
                numero = Integer.parseInt(resposta);
            }
        } while (error);

        final int idDepartament = numero;

        ObjectSet<Tripulant_Dades> resultTripulants = db.query(new Predicate<Tripulant_Dades>() {
            @Override
            public boolean match(Tripulant_Dades tripulantDades) {
                return tripulantDades.getDepartamentId() == idDepartament;
            }
        });

        List<Tripulant_Dades> tripulants = new ArrayList<>();

        while(resultTripulants.hasNext()) {
            tripulants.add(resultTripulants.next());
        }

        // Funciona perque Tripulant_Dades implementa Comparable
        Collections.sort(tripulants);

        for(Tripulant_Dades t: tripulants) {
            System.out.println(t);
        }
    }

    // Esborrar un departament i els tripulants assignats en cascada
    public static ObjectContainer menu21(ObjectContainer db) {
        db.close();
        // Obrir db amb cascade
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Departament_Dades.class).cascadeOnDelete(true);
        config.common().objectClass(Tripulant_Dades.class).cascadeOnDelete(true);
        db = Db4oEmbedded.openFile(config, IKSRotarranConstants.pathBD);


        // Mostra departaments per escollir un.
        ObjectSet<Departament_Dades> objectSet = db.query(Departament_Dades.class);

        List<Departament_Dades> deps = new ArrayList<>();

        while (objectSet.hasNext()) {
            Departament_Dades d = objectSet.next();
            deps.add(d);
        }

        Collections.sort(deps);

        System.out.println("DEPARTAMENTS:");
        for(Departament_Dades d: deps) {
            System.out.println(String.format("%d - %s ", d.getId(), d.getNom()));
        }

        int numero = 0;
        boolean error = false;

        Scanner sc = new Scanner(System.in);

        do {
            error = false;
            System.out.println("Selecciona un departament:");
            String resposta = sc.nextLine();
            if(!Cadena.stringIsInt(resposta)) {
                System.out.println("No es nombre valid.");
                error = true;
            }
            else {
                numero = Integer.parseInt(resposta);
            }
        } while (error);

        for(Departament_Dades d: deps) {
            if(d.getId() == numero) {
                System.out.println(d);
                System.out.println("ELIMINAT EN CASCADA EL DEPARTAMENT " + d.getNom());
                db.delete(d);
                break;
            }
        }

        db.close();

        // Retorna db sense cascade
        EmbeddedConfiguration config2 = Db4oEmbedded.newConfiguration();
        db = Db4oEmbedded.openFile(config2, IKSRotarranConstants.pathBD);
        return db;
    }
}
