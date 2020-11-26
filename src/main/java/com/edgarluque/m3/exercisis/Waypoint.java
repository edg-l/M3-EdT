package com.edgarluque.m3.exercisis;

import com.edgarluque.m3.llibreries.varies.Cadena;
import com.edgarluque.m3.llibreries.varies.Data;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Waypoint {

    public static ComprovacioRendiment inicialitzarComprovacioRendiment() {
        return new ComprovacioRendiment();
    }

    public static ComprovacioRendiment comprovarRendimentInicialitzacio(int numObjACrear,
                                                                        ComprovacioRendiment comprovacioRendimentTmp) {
        if (comprovacioRendimentTmp == null) {
            System.out.println("ComprovacioRendiment no esta inicialitzada.");
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("El temps es mostra en millis.");

        long now = System.nanoTime();
        for (int i = 0; i < numObjACrear; i++) {
            comprovacioRendimentTmp.llistaLinkedList.add(new WaypointDades(
                    0, "Òrbita de la Terra",
                    new int[]{0, 0, 0}, true,
                    LocalDateTime.parse("15-08-1954 00:01", formatter),
                    null, null
            ));
        }

        long linkedListTime = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar %d waypoints en LinkedList: %d",
                numObjACrear,
                Duration.ofNanos(linkedListTime).toMillis()));

        now = System.nanoTime();
        for (int i = 0; i < numObjACrear; i++) {
            comprovacioRendimentTmp.llistaArrayList.add(new WaypointDades(
                    0, "Òrbita de la Terra",
                    new int[]{0, 0, 0}, true,
                    LocalDateTime.parse("15-08-1954 00:01", formatter),
                    null, null
            ));
        }
        long arrayListTime = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar %d waypoints en l'ArrayList: %d",
                numObjACrear,
                Duration.ofNanos(arrayListTime).toMillis()));

        return comprovacioRendimentTmp;
    }

    public static ComprovacioRendiment comprovarRendimentInsercio(ComprovacioRendiment comprovacioRendimentTmp) {
        if (comprovacioRendimentTmp == null) {
            System.out.println("ComprovacioRendiment no esta inicialitzada.");
            return null;
        }

        System.out.println("El temps es mostra en nanos.");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        int meitatLinked = comprovacioRendimentTmp.llistaLinkedList.size() / 2;
        int meitatArray = comprovacioRendimentTmp.llistaArrayList.size() / 2;

        System.out.println("llistaLinkedList.size(): " + comprovacioRendimentTmp.llistaLinkedList.size());
        System.out.println("llistaLinkedList meitat: " + meitatLinked);

        long now = System.nanoTime();
        comprovacioRendimentTmp.llistaLinkedList.add(0, new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        long time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar 1a pos LinkedList: %d",
                time));

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaArrayList.add(0, new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar 1a pos ArrayList: %d",
                time));

        System.out.println("----");

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaLinkedList.add(meitatLinked, new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar a la meitat LinkedList: %d",
                time));

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaArrayList.add(meitatArray, new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar a la meitat ArrayList: %d",
                time));

        System.out.println("----");

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaLinkedList.add(new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar al final LinkedList: %d",
                Duration.ofNanos(time).toMillis()));

        now = System.nanoTime();
        comprovacioRendimentTmp.llistaArrayList.add(new WaypointDades(
                0, "Òrbita de la Terra",
                new int[]{0, 0, 0}, true,
                LocalDateTime.parse("15-08-1954 00:01", formatter),
                null, null
        ));

        time = System.nanoTime() - now;
        System.out.println(String.format("Temps per insertar al final ArrayList: %d",
                time));

        return comprovacioRendimentTmp;
    }

    public static ComprovacioRendiment modificarWaypoints(ComprovacioRendiment comprovacioRendimentTmp) {
        System.out.println("----Apartat 1-----");
        List<Integer> idsPerArrayList = new ArrayList<>();
        for (int i = 0, n = comprovacioRendimentTmp.llistaArrayList.size(); i < n; i++) {
            idsPerArrayList.add(i);
        }
        System.out.println("S'ha inicialitzat idsPerArrayList amb " + comprovacioRendimentTmp.llistaArrayList.size() + " nombres.");
        System.out.println("Primer valor te un: " + idsPerArrayList.get(0));
        System.out.println("L'ultim valor te un: " + idsPerArrayList.get(idsPerArrayList.size() - 1));

        // Apartat 2
        System.out.println("---Apartat 2---");
        for (Integer id : idsPerArrayList) {
            System.out.printf("Abans del canvi (i=%d): %d\n", id, comprovacioRendimentTmp.llistaArrayList.get(id).getId());
            comprovacioRendimentTmp.llistaArrayList.get(id).setId(id);
            System.out.printf("Despres del canvi (i=%d): %d\n\n", id, comprovacioRendimentTmp.llistaArrayList.get(id).getId());
        }

        System.out.println("---Apartat 3.1 (bucle for)---");
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            System.out.printf("ID = %d, nom = %s\n", dades.getId(), dades.getNom());
        }

        System.out.println();
        System.out.println("---Apartat 3.2 (iterador)---");
        for (Iterator<WaypointDades> it = comprovacioRendimentTmp.llistaArrayList.iterator(); it.hasNext(); ) {
            WaypointDades dades = it.next();
            System.out.printf("ID = %d, nom = %s\n", dades.getId(), dades.getNom());
        }

        System.out.println();
        System.out.println("---Apartat 4---");
        System.out.printf("La llista linked list s'esborrara amb %d elements.\n", comprovacioRendimentTmp.llistaLinkedList.size());
        comprovacioRendimentTmp.llistaLinkedList.clear();
        System.out.println("Esborrada.");

        comprovacioRendimentTmp.llistaLinkedList.addAll(comprovacioRendimentTmp.llistaArrayList);
        System.out.println("Copiat els elements de llistaArrayList a llistaLinkedList: " + comprovacioRendimentTmp.llistaLinkedList.size());

        System.out.println("---Apartat 5.1 (bucle for)---");
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            if (dades.getId() > 5) {
                dades.setNom("Òrbita de Mart.");
                System.out.println("Modificat waypoint amb id = " + dades.getId());
            }
        }

        System.out.println();
        System.out.println("---Apartat 5.1 (comprovacio)---");
        for (int i = 0; i < comprovacioRendimentTmp.llistaArrayList.size(); i++) {
            WaypointDades dades = comprovacioRendimentTmp.llistaArrayList.get(i);
            System.out.printf("El waypoint amb id = %d te el nom = %s\n", dades.getId(), dades.getNom());
        }

        System.out.println("---Apartat 5.2 (bucle for)---");
        for (WaypointDades dades : comprovacioRendimentTmp.llistaLinkedList) {
            if (dades.getId() < 5) {
                dades.setNom("Punt Lagrange entre la Terra i la LLuna");
                System.out.println("Modificat waypoint amb id = " + dades.getId());
            }
        }

        System.out.println();
        System.out.println("---Apartat 5.2(comprovacio)---");
        for (int i = 0; i < comprovacioRendimentTmp.llistaLinkedList.size(); i++) {
            WaypointDades dades = comprovacioRendimentTmp.llistaLinkedList.get(i);
            System.out.printf("El waypoint amb id = %d te el nom = %s\n", dades.getId(), dades.getNom());
        }

        return comprovacioRendimentTmp;
    }

    public static ComprovacioRendiment esborrarWaypoint(ComprovacioRendiment comprovacioRendimentTmp) {
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            if (dades.getId() < 6) {
                comprovacioRendimentTmp.llistaArrayList.remove(dades);
            }
        }

        System.out.println("---Apartat 2 iterator---");
        for (Iterator<WaypointDades> it = comprovacioRendimentTmp.llistaLinkedList.iterator(); it.hasNext(); ) {
            WaypointDades dades = it.next();

            if (dades.getId() > 4) {
                System.out.println("Esborrat waypoint amb id = " + dades.getId());
                it.remove();
            }
        }

        System.out.println("---Apartat 2 comprovacio---");
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            System.out.printf("El waypoint amb id = %d te el nom = %s\n", dades.getId(), dades.getNom());
        }

        System.out.println("---Apartat 3 listiterator---");
        for (ListIterator<WaypointDades> it = comprovacioRendimentTmp.llistaLinkedList.listIterator(1); it.hasNext(); ) {
            WaypointDades dades = it.next();

            if (dades.getId() == 2) {
                System.out.println("Esborrat waypoint amb id = " + dades.getId());
                it.remove();
            }
        }

        System.out.println("---Apartat 3 comprovacio---");
        for (ListIterator<WaypointDades> it =
             comprovacioRendimentTmp.llistaLinkedList.listIterator(comprovacioRendimentTmp.llistaLinkedList.size()); it.hasPrevious(); ) {
            WaypointDades dades = it.previous();

            System.out.printf("El waypoint amb id = %d te el nom = %s\n", dades.getId(), dades.getNom());
        }
        return comprovacioRendimentTmp;
    }

    public static ComprovacioRendiment modificarCoordenadesINomDeWaypoints(ComprovacioRendiment comprovacioRendimentTmp) {
        Scanner sc = new Scanner(System.in);
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            if(dades.getId() % 2 != 0)
                continue;
            System.out.println("---Modificar waypoint amb id " + dades.getId() + "----");
            System.out.println("Nom: " + dades.getNom());
            dades.printCoordenades();
            System.out.println("Introdueix el nou nom:");
            dades.setNom(sc.nextLine());

            boolean done = false;
            int[] coordenades = new int[3];
            while (!done) {
                System.out.println("Introdueix les noves coordenades:");
                String[] coords = sc.nextLine().split(" ");

                if (coords.length < 3)
                    continue;

                for (int i = 0; i < coords.length; i++) {
                    if (Cadena.stringIsInt(coords[i])) {
                        coordenades[i] = Integer.parseInt(coords[i]);
                        done = true;
                    } else {
                        done = false;
                        break;
                    }
                }
            }

            dades.setCoordenades(coordenades);
            System.out.println("Coordenades noves:");
            dades.printCoordenades();
        }

        return comprovacioRendimentTmp;
    }

    public static void visualitzarWaypointsOrdenats(ComprovacioRendiment comprovacioRendimentTmp) {
        comprovacioRendimentTmp.llistaArrayList.sort(WaypointDades::compareTo);
        for (WaypointDades dades : comprovacioRendimentTmp.llistaArrayList) {
            System.out.println(dades.toString());
        }
    }

    public static void waypointsACertaDistanciaMaxDeLaTerra(ComprovacioRendiment comprovacioRendimentTmp) {
        Scanner sc = new Scanner(System.in);
        int dist = 0;

        while (true) {
            String stringNum = sc.nextLine();
            System.out.println("Distancia maxima de la terra:");
            if (Cadena.stringIsInt(stringNum)) {
                dist = Integer.parseInt(stringNum);
                break;
            }
        }

        List<WaypointDades> dades = new ArrayList<>(comprovacioRendimentTmp.llistaArrayList.size());

        for (WaypointDades w : comprovacioRendimentTmp.llistaArrayList) {
            if (w.distanciaATerra() >= dist)
                dades.add(w);
        }

        dades.sort(WaypointDades::compareTo);

        for (WaypointDades w : dades) {
            System.out.println(w.toString());
        }
    }

    public static void menu40(ComprovacioRendiment tmp) {
        if(!tmp.llistaWaypoints.isEmpty())
            tmp.llistaWaypoints.clear();

        tmp.llistaWaypoints.add(new WaypointDades(0, "Òrbita de la Terra", new int[] {0,0,0}, true,
                LocalDateTime.parse("21-10-2020 01:10", Data.FORMATTER), null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER), 0));

        tmp.llistaWaypoints.add(new WaypointDades(1, "Punt Lagrange Terra-LLuna", new int[] {1,1,1}, true,
                LocalDateTime.parse("21-10-2020 01:00", Data.FORMATTER), null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER),6));

        tmp.llistaWaypoints.add(new WaypointDades(2, "Òrbita de la LLuna", new int[] {2,2,2}, true,
                LocalDateTime.parse("21-10-2020 00:50", Data.FORMATTER), null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER),1));

        tmp.llistaWaypoints.add(new WaypointDades(3, "Òrbita de Mart", new int[] {3,3,3}, true,
                LocalDateTime.parse("21-10-2020 00:40", Data.FORMATTER), null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER),0));

        tmp.llistaWaypoints.add(new WaypointDades(4, "Òrbita de Júpiter", new int[] {4,4,4}, true,
                LocalDateTime.parse("21-10-2020 00:30", Data.FORMATTER), null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER),0));

        tmp.llistaWaypoints.add(new WaypointDades(5, "Punt Lagrange Júpiter-Europa", new int[] {5,5,5}, true,
                LocalDateTime.parse("21-10-2020 00:20", Data.FORMATTER), null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER),6));

        tmp.llistaWaypoints.add(new WaypointDades(6, "Òrbita de Europa", new int[] {6,6,6}, true,
                LocalDateTime.parse("21-10-2020 00:10", Data.FORMATTER), null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER),0));

        tmp.llistaWaypoints.add(new WaypointDades(7, "Òrbita de Venus", new int[] {7,7,7}, true,
                LocalDateTime.parse("21-10-2020 00:01", Data.FORMATTER), null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER),0));
    }

    public static void menu41(ComprovacioRendiment tmp) {
        int id = 0;
        for(WaypointDades dades: tmp.llistaWaypoints) {
            if(dades.getId() > id)
                id = dades.getId();
        }
        id++;

        Scanner sc = new Scanner(System.in);

        System.out.println("Nom del waypoint:");
        String nom = sc.nextLine();

        int[] coordenades = new int[3];
        System.out.println("Introdueix les coordenades, 3 numeros separats per espai:");
        do {
            String numeros = sc.nextLine();
            System.out.println("numeros:");
            System.out.println(numeros);
            String[] nums = numeros.split(" ");
            if(nums.length != 3) {
                System.out.println("Has de pasar 3 numeros separats per espais.");
                continue;
            }

            boolean isOk = true;
            for(int i = 0; i < 3; i++) {
                if(!Cadena.stringIsInt(nums[i])) {
                    System.out.println("Has de pasar numeros valids.");
                    isOk = false;
                    break;
                }
                coordenades[i] = Integer.parseInt(nums[i]);
            }

            if(isOk)
                break;
        } while (true);

        Collator comp = Collator.getInstance();
        comp.setStrength(Collator.PRIMARY);

        boolean actiu = false;

        do {
            System.out.println("Esta actiu (true/false): ");
            String res = sc.nextLine();

            if(comp.compare(res, "true") == 0) {
                actiu = true;
                break;
            }
            else if(comp.compare(res, "false") == 0) {
                actiu = false;
                break;
            }
            else {
                System.out.println("Entrada no valida.");
            }
        } while (true);

        LocalDateTime dataCreacio = LocalDateTime.now();
        LocalDateTime dataModificacio = LocalDateTime.now();

        LocalDateTime dataAnulacio = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        do {
            System.out.println("Data anulacio (DD-MM-AAAA):");
            String res = sc.nextLine();

            if(Data.esData(res)) {
                dataAnulacio = LocalDate.parse(res, formatter).atStartOfDay();
                break;
            } else {
                System.out.println("Entrada no valida.");
            }
        } while (true);

        for(int i = 0; i < Constants.TIPUS_WAYPOINT.length; i++) {
            System.out.println("ID: " + i + " - " + Constants.TIPUS_WAYPOINT[i]);
        }

        int tipus = 0;

        do {
            System.out.println("Introdueix id del tipus:");
            int tipusTmp = sc.nextInt();

            if(tipusTmp < 0 || tipusTmp >= Constants.TIPUS_WAYPOINT.length) {
                System.out.println("Tipus invalid.");
            }
            else {
                tipus = tipusTmp;
                break;
            }
        } while (true);

        tmp.llistaWaypoints.add(new WaypointDades(
                id, nom, coordenades, actiu, dataCreacio, dataAnulacio, dataModificacio, tipus
        ));
        System.out.println("Waypoint afegit.");
    }

    public static void menu42(ComprovacioRendiment tmp) {
        System.out.println("Tipus de waypoints:");

        for(int i = 0; i < Constants.TIPUS_WAYPOINT.length; i++) {
            System.out.println("ID: " + i + " - " + Constants.TIPUS_WAYPOINT[i]);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix el tipus de waypoint:");
        int tipus = sc.nextInt();

        List<WaypointDades> llistaA = new ArrayList<>(tmp.llistaWaypoints);
        List<WaypointDades> llistaB = new ArrayList<>();

        Iterator<WaypointDades> it = llistaA.iterator();
        while (it.hasNext()) {
            WaypointDades dades = it.next();

            if(dades.getTipus() == tipus) {
                System.out.println("Eliminat waypoint amb id " + dades.getId());
                llistaB.add(dades);
                it.remove();
            }
        }

        System.out.println("LListaB waypoints de tipus " + tipus);
        for(WaypointDades dades: llistaB) {
            System.out.printf("ID %d: %s de tipus %d\n", dades.getId(), dades.getNom(), dades.getTipus());
        }
    }

    public static void menu43(ComprovacioRendiment tmp) {
        Set<WaypointDades> set = new HashSet<>(tmp.llistaWaypoints);

        Map<Integer, Integer> mapTipusCount = new HashMap<>();

        Iterator<WaypointDades> it = set.iterator();
        while (it.hasNext()) {
            WaypointDades dades = it.next();
            mapTipusCount.merge(dades.getTipus(), 1, (a, b) -> a+b);
        }

        for (Map.Entry<Integer, Integer> ent: mapTipusCount.entrySet()) {
            System.out.printf("Tipus %d (%s): hi ha %d naus\n",
                    ent.getKey(), Constants.TIPUS_WAYPOINT[ent.getKey()],
                    ent.getValue());
        }
    }

    public static void menu44(ComprovacioRendiment tmp) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nom del waypoint:");
        String nom = sc.nextLine();

        Collator comp = Collator.getInstance();
        comp.setStrength(Collator.SECONDARY);

        for(WaypointDades dades: tmp.llistaWaypoints) {
            if(comp.compare(dades.getNom(), nom) == 0) {
                System.out.println("id " + dades.getId() + ": " + dades.getNom());
            }
        }
    }

    public static void menu45(ComprovacioRendiment tmp) {
        tmp.llistaWaypoints.sort(new Comparator<WaypointDades>() {
            @Override
            public int compare(WaypointDades waypointDades, WaypointDades t1) {
                return waypointDades.getDataCreacio().compareTo(t1.getDataCreacio());
            }
        });

        for(WaypointDades dades: tmp.llistaWaypoints) {
            System.out.printf("ID %d: %s, data alta: %s\n",
                    dades.getId(), dades.getNom(), dades.getDataCreacio());
        }
    }
}
