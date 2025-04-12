package com.mygdx.game.items;

public class Item {

	public String nombre;
	public String descripcion;
	public int precio;
	public String tipo;
	
	
	public Item() {
		
	}
	
	public Item(String nombre, String descripcion, int precio, String tipo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipo = tipo;
	}
	
}
