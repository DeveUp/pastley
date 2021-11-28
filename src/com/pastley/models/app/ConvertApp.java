package com.pastley.models.app;

public class ConvertApp {
	public static String statu(boolean estado) {
		return (estado) ? "ACTIVO" : "BLOQUEDAO";
	}

	public static String plural(int size, String cadena) {
		return (size > 1) ? cadena + "s" : cadena;
	}
}
