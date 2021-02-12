package com.edgarluque.m3;

public abstract class Cadena {
	
	public static boolean stringIsInt(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

}
