package com.mygdx.game.pantallas;

import com.badlogic.gdx.Screen;


/**
 * Agrega funcionalidades extra como metodos para saber si la pantalla esta activa o no
 * @author  Momosan09
 *
 */
public class Pantalla implements Screen, Ocultable{
	
	protected boolean visible;

	@Override
	public void show() {
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

	@Override
	public boolean getVisible() {
		return visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
