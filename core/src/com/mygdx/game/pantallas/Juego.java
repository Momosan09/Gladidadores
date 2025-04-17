package com.mygdx.game.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.enums.EstadosDelJuego;
import com.mygdx.game.utiles.ConfiguracionesJuego;

public class Juego implements Screen{

	private Game g;
	private UIManager pm;
	
	public Juego(Game g) {
		this.g = g;
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
