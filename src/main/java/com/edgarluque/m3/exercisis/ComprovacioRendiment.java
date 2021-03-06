package com.edgarluque.m3.exercisis;

import java.util.*;

public class ComprovacioRendiment {
    int[] coordenadesTmp = null;
    List<WaypointDades> llistaArrayList;
    List<WaypointDades> llistaLinkedList;
    WaypointDades wtmp;
    public Deque<WaypointDades> pilaWaypoints;
    public ArrayList<RutaDades> llistaRutes;
    public LinkedHashMap<Integer, RutaDades> mapaLinkedRutes;
    LinkedList<WaypointDades> llistaWaypoints = new LinkedList<>();
    LinkedHashMap<Integer, WaypointDades> mapaWaypoints;

    public ComprovacioRendiment() {
        coordenadesTmp = new int[] {0,0,0};
        llistaArrayList = new ArrayList<>();
        llistaLinkedList = new LinkedList<>();
        wtmp = null;
        pilaWaypoints = new LinkedList<>();
        llistaRutes = new ArrayList<>();
        mapaLinkedRutes = new LinkedHashMap<>();
        mapaWaypoints = new LinkedHashMap<>();
    }
}
