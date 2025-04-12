package com.mygdx.game.items;

public class Armadura extends Item{

	public int indiceArmadura;
	
	public Armadura(String nombre, String descripcion, int precio, String tipo, int indiceArmadura) {
		super(nombre, descripcion, precio, tipo);
		this.indiceArmadura = indiceArmadura;
		
	}

}
