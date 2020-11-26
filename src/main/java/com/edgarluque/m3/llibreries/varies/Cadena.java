package com.edgarluque.m3.llibreries.varies;

import java.util.Scanner;

public class Cadena {
    public static boolean stringIsInt(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static int getInt(String pregunta) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(pregunta);
            String v = sc.next();

            if(!stringIsInt(v)) {
                System.out.println("Ha de ser un integer.");
                continue;
            }

            return Integer.parseInt(v);
        }
    }
}
