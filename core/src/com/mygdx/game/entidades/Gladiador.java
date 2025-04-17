package com.mygdx.game.entidades;

import java.util.ArrayList;
import java.util.EnumMap;

import com.mygdx.game.enums.Atributos;
import com.mygdx.game.enums.Clases;
import com.mygdx.game.items.Arma;
import com.mygdx.game.items.Armadura;
import com.mygdx.game.items.Consumible;
import com.mygdx.game.items.Item;
import com.mygdx.game.utiles.ConfiguracionesJuego;

public class Gladiador {

	private Clases clase;
	private EnumMap<Atributos, Integer> atributos = new EnumMap<>(Atributos.class);
	private int nivel;
	private float experiencia;
	private int oro;
	private ArrayList<Armadura> armaduraPuesta;
	private ArrayList<Arma> armasPuestas;
	private ArrayList<Consumible> pociones;
	private ArrayList<Item> inventario;
	
	
	public Gladiador(Clases clase, EnumMap<Atributos, Integer> atributos) {
		this.clase = clase;
		this.atributos = atributos;
		this.nivel = 0;
		this.experiencia = 0;
		this.oro = ConfiguracionesJuego.oroInicial;
		this.armaduraPuesta = new ArrayList<Armadura>();
		this.armasPuestas = new ArrayList<Arma>();
		this.pociones = new ArrayList<Consumible>();
		this.inventario = new ArrayList<Item>();
	}
	
	
	
}
