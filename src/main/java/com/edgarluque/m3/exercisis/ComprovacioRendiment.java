package com.edgarluque.m3.exercisis;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ComprovacioRendiment {
    int[] coordenadesTmp = null;
    List<WaypointDades> llistaArrayList;
    List<WaypointDades> llistaLinkedList;
    WaypointDades wtmp;
    public Deque<WaypointDades> pilaWaypoints;

    public ComprovacioRendiment() {
        coordenadesTmp = new int[] {0,0,0};
        llistaArrayList = new ArrayList<>();
        llistaLinkedList = new LinkedList<>();
        wtmp = null;
        pilaWaypoints = new LinkedList<>();
    }
}
