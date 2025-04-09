package com.mygdx.game.utiles;

import java.util.EnumMap;

import com.mygdx.game.enums.Atributos;
import com.mygdx.game.enums.Clases;

public abstract class ConfiguracionesJuego {

	public static Clases claseJugador = Clases.SINCLASE;
	public static String nombre;
	public static String apodo;
	public static int puntosDisponibles = 12;
	public static EnumMap<Atributos, Integer> puntosAtributos = new EnumMap<>(Atributos.class);
}
