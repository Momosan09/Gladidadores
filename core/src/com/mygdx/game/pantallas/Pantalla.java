package com.mygdx.game.pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;


/**
 * Agrega funcionalidades extra como metodos para saber si la pantalla esta activa o no
 * @author  Momosan09
 *
 */
public class Pantalla implements Screen, Ocultable{
	
	protected Stage stage;//pense en hacer una clase hija que contenga este campo pero pensandolo bien la mayoria de las pantallas va a necesitar una stage
	protected boolean visible = false;
	protected boolean visBandera = false;//Bandera para visible

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
	
	public Stage getStage() {
		return stage;
	}

}
