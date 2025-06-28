package com.mygdx.game.pantallas.mapa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.pantallas.Pantalla;
import com.mygdx.game.pantallas.PantallasDelJuego;
import com.mygdx.game.utiles.ConfiguracionesJuego;
import com.mygdx.game.utiles.Recursos;
import com.mygdx.game.utiles.Render;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Plaza implements PantallasDelJuego{

	private boolean visible = true;
	private Texture fondoTx = new Texture(Recursos.fondos.FONDO_PLAZA);
	private Sprite fondo = new Sprite(fondoTx);
	
	private Skin skin = new Skin(Gdx.files.internal(Recursos.SKINMIA));
	private Stage stage = new Stage(new ScreenViewport());
	private ImageButton botonMercado = new ImageButton(skin, "mercado");
	
	
	
	public Plaza() {
		iniciar();
	}

	public void dibujar() {
		if(visible) {
			stage.act();
			fondo.draw(Render.batch);
		}
	}

	@Override
	public void iniciar() {
		fondo.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		ConfiguracionesJuego.muxPantallas.addProcessor(stage);
		stage.addActor(botonMercado);
	}
}
