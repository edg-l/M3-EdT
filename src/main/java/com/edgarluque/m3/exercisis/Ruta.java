package com.edgarluque.m3.exercisis;

import com.edgarluque.m3.llibreries.varies.Cadena;
import com.edgarluque.m3.llibreries.varies.Data;

import javax.xml.transform.stream.StreamResult;
import java.time.LocalDateTime;
import java.util.*;

public class Ruta {
    public static List<WaypointDades> crearRutaInicial() {
        List<WaypointDades> ruta = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ruta.add(new WaypointDades(
                    i, "A" + Integer.toString(i), new int[]{0, i, i * 2}, true, LocalDateTime.now(),
                    null, null
            ));
        }

        return ruta;
    }

    public static ComprovacioRendiment inicialitzarRuta(ComprovacioRendiment tmp) {
        List<WaypointDades> rutaInicial = crearRutaInicial();

        for (WaypointDades w : rutaInicial) {
            tmp.pilaWaypoints.push(w);
            System.out.println("Afegit waypoint amb id " + w.getId() + " a la pila.");
        }

        WaypointDades nouWaypoint = new WaypointDades(4,
                "Òrbita de Júpiter REPETIDA",
                new int[]{4, 4, 4}, true,
                LocalDateTime.parse("21-10-2020 00:30", Data.FORMATTER),
                null,
                LocalDateTime.parse("22-10-2020 23:55", Data.FORMATTER));

        tmp.pilaWaypoints.push(nouWaypoint);
        tmp.wtmp = nouWaypoint;
        return tmp;
    }

    public static void visualitzarRuta(ComprovacioRendiment tmp) {
        System.out.println("Ruta formada per waypoints:");
        for (WaypointDades w : tmp.pilaWaypoints) {
            System.out.println(w.toString());
        }
    }

    public static void invertirRuta(ComprovacioRendiment tmp) {
        Deque<WaypointDades> inversa = new ArrayDeque<>(tmp.pilaWaypoints.size());

        while (!tmp.pilaWaypoints.isEmpty()) {
            inversa.push(tmp.pilaWaypoints.pop());
        }

        System.out.println("Pila inversa:");
        for (WaypointDades w : inversa) {
            System.out.println(w.toString());
        }

        tmp.pilaWaypoints = inversa;
    }

    public static void existeixWaypointEnRuta(ComprovacioRendiment tmp) {
        if (tmp.wtmp == null)
            return;

        for (WaypointDades w : tmp.pilaWaypoints) {
            if (tmp.wtmp == w) {
                System.out.println("S'ha trobut el waypoint wtmp.");
                return;
            }
        }

        System.out.println("No s'ha trobat el waypoint wtmp.");
    }

    public static ComprovacioRendiment inicialitzaLListaRutes(ComprovacioRendiment tmp) {
        RutaDades ruta_0 = new RutaDades(0, "ruta   0:   Terra   -->   Punt   Lagrange   Júpiter-Europa", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5)), true, LocalDateTime.parse("28-10-2020 16:30", Data.FORMATTER), null, LocalDateTime.parse("28-10-2020 16:30", Data.FORMATTER));
        RutaDades ruta_1 = new RutaDades(1, "ruta 1: Terra --> Òrbita de Mart (directe)", new ArrayList<Integer>(Arrays.asList(0, 3)), true, LocalDateTime.parse("28-10-2020 16:31", Data.FORMATTER), null, LocalDateTime.parse("28-10-2020 16:31", Data.FORMATTER));
        RutaDades ruta_2 = new RutaDades(2, "ruta 2.1: Terra --> Òrbita de Venus", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)), true, LocalDateTime.parse("28-10-2020 16:32", Data.FORMATTER), null, LocalDateTime.parse("28-10-2020 16:32", Data.FORMATTER));
        RutaDades ruta_3 = new RutaDades(3, "ruta 3: Terra --> Mart (directe) --> Òrbita de Júpiter ", new ArrayList<Integer>(Arrays.asList(0, 3, 4)), true, LocalDateTime.parse("28-10-2020 16:33", Data.FORMATTER), null, LocalDateTime.parse("28-10-2020 16:33", Data.FORMATTER));
        RutaDades ruta_4 = new RutaDades(4, "ruta   2.2:   Terra   -->   Òrbita   de   Venus   (REPETIDA)", new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)), true, LocalDateTime.parse("28-10-2020 16:32", Data.FORMATTER), null, LocalDateTime.parse("30-10-2020 19:49", Data.FORMATTER));

        tmp.llistaRutes.add(ruta_0);
        tmp.llistaRutes.add(ruta_1);
        tmp.llistaRutes.add(ruta_2);
        tmp.llistaRutes.add(ruta_3);
        tmp.llistaRutes.add(ruta_4);

        System.out.println("insertades les rutes:");
        for (RutaDades dades : tmp.llistaRutes) {
            dades.imprimir();
        }
        return tmp;
    }

    public static void setUnio(ComprovacioRendiment tmp) {
        HashSet<Integer> waypoints = new HashSet<>();

        for(RutaDades dades: tmp.llistaRutes) {
            waypoints.addAll(dades.getWaypoints());
        }
        System.out.println("ID dels waypoints ficats en el set: " + waypoints);
    }

    public static void setInterseccio(ComprovacioRendiment tmp) {
        HashSet<Integer> waypoints = new HashSet<>();

        for(RutaDades dades: tmp.llistaRutes) {
            waypoints.addAll(dades.getWaypoints());
        }

        for(RutaDades dades: tmp.llistaRutes) {
            waypoints.retainAll(dades.getWaypoints());
        }

        System.out.println("ID dels waypoints ficats en el set: " + waypoints);
    }

    private static int buscarRuta(int numRuta, ComprovacioRendiment tmp) {
        for(int i = 0, n = tmp.llistaRutes.size(); i < n; i++) {
            RutaDades dades = tmp.llistaRutes.get(i);
            if(dades.getId() == i) {
                return i;
            }
        }

        return -1;
    }

    public static void setResta(ComprovacioRendiment tmp) {
        System.out.println("Rutes actuals:");
        for(RutaDades dades: tmp.llistaRutes) {
            dades.imprimir();
        }

        Scanner sc = new Scanner(System.in);
        String[] rutes = new String[]{};
        int a = 0;
        int b = 0;

        boolean ok = false;
        while (!ok) {
            System.out.print("Selecciona ruta A i B (format: 3 17): ");
            rutes = sc.nextLine().split(" ");

            if(rutes.length < 2) {
                System.out.println("Error: Introduir 2 parametres separats per espai en blanc, has introduit " + rutes.length + " parametres");
                continue;
            }
            ok = true;

            for(String s: rutes) {
                if(!Cadena.stringIsInt(s)) {
                    System.out.println("Error: Introduir nombres, no strings.");
                    ok = false;
                    break;
                }
            }
        }

        a = Integer.parseInt(rutes[0]);
        b = Integer.parseInt(rutes[1]);

        RutaDades rutaA = tmp.llistaRutes.get(buscarRuta(a, tmp));
        RutaDades rutaB = tmp.llistaRutes.get(buscarRuta(b, tmp));
        HashSet<Integer> waypoints = new HashSet<>(rutaA.getWaypoints());
        System.out.println("HashSet amb waypoints de ruta a = " + waypoints);
        waypoints.removeAll(rutaB.getWaypoints());
        System.out.println("HashSet treient els de b = " + waypoints);
    }

    public static void crearSetOrdenatDeRutes(ComprovacioRendiment tmp) {
        TreeSet<RutaDades> rutes = new TreeSet<>(tmp.llistaRutes);

        for(RutaDades dades: rutes) {
            dades.imprimir();
        }
    }
}
