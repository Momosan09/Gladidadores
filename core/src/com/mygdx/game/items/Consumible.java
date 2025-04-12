package com.mygdx.game.items;

public class Consumible extends Item {
	
	public String efecto;
	public long duracion;

	public Consumible(String nombre, String descripcion, int precio, String tipo, String efecto, long duracion) {
		super(nombre, descripcion, precio, tipo);
		this.efecto = efecto;
		this.duracion = duracion;
	}

}
