package com.edgarluque.m3;

import com.db4o.ObjectContainer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Encarrec {
    public static void menu2(ObjectContainer db) {
        List<Encarrec_Dades> encarrecs = new ArrayList<>();
        encarrecs.add(new Encarrec_Dades(0, 1, LocalDateTime.now()));
        encarrecs.add(new Encarrec_Dades(1, 1, LocalDateTime.now()));
        encarrecs.add(new Encarrec_Dades(2, 3, LocalDateTime.now()));
        encarrecs.add(new Encarrec_Dades(3, 1, LocalDateTime.now()));
        encarrecs.add(new Encarrec_Dades(4, 1, LocalDateTime.now()));
        encarrecs.add(new Encarrec_Dades(5, 4, LocalDateTime.now()));
        encarrecs.add(new Encarrec_Dades(6, 3, LocalDateTime.now()));

        for(Encarrec_Dades e: encarrecs) {
            db.store(e);
        }
    }
}
