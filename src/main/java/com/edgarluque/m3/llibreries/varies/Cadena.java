package com.edgarluque.m3.llibreries.varies;

public class Cadena {
    public static boolean stringIsInt(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
