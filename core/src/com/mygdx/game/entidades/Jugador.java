package com.mygdx.game.entidades;

import com.mygdx.game.utiles.ConfiguracionesJuego;

public class Jugador {

	private int oro;
	private Gladiador gladiador;
	
	
	public Jugador() {
		
	}
	
	public Jugador(Gladiador g) {
		this.gladiador = g;
		this.oro = ConfiguracionesJuego.oroInicial;
	}
	
	public int getOro() {
		return oro;
	}


	public void setOro(int oro) {
		this.oro = oro;
	}


	public Gladiador getGladiador() {
		return gladiador;
	}


	public void setGladiador(Gladiador gladiador) {
		this.gladiador = gladiador;
	}

}
