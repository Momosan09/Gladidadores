package com.mygdx.game.utiles;

import java.util.EnumMap;

import com.badlogic.gdx.InputMultiplexer;
import com.mygdx.game.enums.Atributos;
import com.mygdx.game.enums.Clases;
import com.mygdx.game.enums.EstadosDelJuego;
import com.mygdx.game.enums.PantallasDelJuego;

public abstract class ConfiguracionesJuego {

	public static Clases claseJugador = Clases.SINCLASE;
	public static String nombre;
	public static String apodo;
	public static int puntosDisponibles = 12;
	public static EnumMap<Atributos, Integer> puntosAtributos = new EnumMap<>(Atributos.class);
	public static EstadosDelJuego estadoDelJuego;
	public static PantallasDelJuego pantallaActual;
	
	
	//Input 
	public static InputMultiplexer muxPantallas = new InputMultiplexer();//mux de input para todas las pantallas
	
	//Gladidador
	public static int oroInicial = 200;
}
