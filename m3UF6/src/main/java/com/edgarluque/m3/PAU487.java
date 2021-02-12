package com.edgarluque.m3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.edgarluque.m3.Pantalles.MenuConstructorPantalla;


/**
 *
 * @author gmartinez
 */
public class PAU487 {
    /*
    SISTEMA DE NAVEGACIÓ BASAT EN WAYPOINTS.
    ES DONEN D'ALTA DIVERSOS WAYPOINTS DE L'ESPAI (ORBITA MARCIANA, PUNT LAGRANGE TERRA-LLUNA, PHOBOS, SATURN, LLUNA,...).
    ES PODEN MEMORITZAR DIVERSES RUTES AFEGINT DIVERSOS WAYPOINTS A CADA RUTA.
    
    */
    
    public static void bloquejarPantalla() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nToca 'C' per a continuar ");
        while (in.hasNext()) {
            if ("C".equalsIgnoreCase(in.next())) break;
        }
    }
    
    
    public static void menuPAU487() throws IOException  {
        // Resetejar la base de dades
        File pathDb = new File(IKSRotarranConstants.pathBD);
        pathDb.delete();
        //

    	EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        ObjectContainer db = Db4oEmbedded.openFile(config, IKSRotarranConstants.pathBD);
    	
        String opcio;
        Scanner sc = new Scanner(System.in);
        StringBuilder menu = new StringBuilder("");

        
        do {
        	menu.delete(0, menu.length());
            
            menu.append(System.getProperty("line.separator"));
            menu.append("PAU-487 ");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            menu.append("1. Crea els departaments a partir dels que hi ha en IKSRotaranConstants.DEPARTAMENT i els fica en la BD");
            menu.append(System.getProperty("line.separator"));
            menu.append("2. Veure tots els departaments que hi ha en la BD");
            menu.append(System.getProperty("line.separator"));
            menu.append("3. Veure tripulants vs departament");
            menu.append(System.getProperty("line.separator"));
            menu.append("10. Inserta/Update tripulants en la BD");
            menu.append(System.getProperty("line.separator"));
            menu.append("11. Veure tots els tripulants");
            menu.append(System.getProperty("line.separator"));
            menu.append("12. Assignar els tripulants a l'ArrayList del departament");
            menu.append(System.getProperty("line.separator"));
            menu.append("21. Esborrar un departament i els tripulants assignats en cascada");
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            menu.append(System.getProperty("line.separator"));
            menu.append("50. Tancar el sistema");
            menu.append(System.getProperty("line.separator"));
            
            System.out.print(MenuConstructorPantalla.constructorPantalla(menu));
            
            opcio = sc.next();
            
            switch (opcio) {
                case "1":
                	Departament.menu1(db);
                    bloquejarPantalla();
                    break;
                case "2":
                    Departament.menu2(db);
                    bloquejarPantalla();
                    break;
                case "3":
                    Departament.menu3(db);
                    bloquejarPantalla();
                    break;
                case "10":
                    Tripulant.menu10(db);
                    bloquejarPantalla();
                    break;
                case "11":
                    Tripulant.menu11(db);
                    bloquejarPantalla();
                    break;
                case "12":
                    Tripulant.menu12(db);
                    bloquejarPantalla();
                    break;
                case "21":
                    db = Departament.menu21(db);
                    bloquejarPantalla();
                    break;
                case "50":
                	db.close();
                    break; 
                default:
                    System.out.println("COMANDA NO RECONEGUDA");
            }  
        } while (!opcio.equals("50"));
        db.close();
    }
}
