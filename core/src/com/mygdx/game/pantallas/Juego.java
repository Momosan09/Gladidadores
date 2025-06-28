package com.mygdx.game.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Principal;
import com.mygdx.game.enums.EstadosDelJuego;
import com.mygdx.game.utiles.ConfiguracionesJuego;
import com.mygdx.game.utiles.Render;


public class Juego extends Pantalla{

	private UIManager pm;
	
	private PantallasDelJuego pantallaADibujar;
	
	public Juego() {

		pm = new UIManager();

	}
	
	
	@Override
	public void show() {
		ConfiguracionesJuego.estadoDelJuego = EstadosDelJuego.PLAZA;
		pantallaADibujar = pm.getPantallaCorrespondiente();


		

	}

	@Override
	public void render(float delta) {
		Render.batch.begin();
		pantallaADibujar.dibujar();
		Render.batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

}
