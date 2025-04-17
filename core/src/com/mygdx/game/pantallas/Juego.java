package com.mygdx.game.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Principal;
import com.mygdx.game.enums.EstadosDelJuego;
import com.mygdx.game.utiles.ConfiguracionesJuego;

public class Juego extends Pantalla{

	private UIManager pm;
	
	public Juego() {

		pm = new UIManager();

	}
	
	
	@Override
	public void show() {
		ConfiguracionesJuego.estadoDelJuego = EstadosDelJuego.PLAZA;
	}

	@Override
	public void render(float delta) {

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
