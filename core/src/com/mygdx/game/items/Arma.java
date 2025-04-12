package com.mygdx.game.items;

public class Arma extends Item{

	public int danio;
	
    public Arma() {
    }
	
	public Arma(String nombre, String descripcion, int precio, String tipo, int danio) {
		super(nombre, descripcion, precio, tipo);
		this.danio = danio;
	}
	
}
