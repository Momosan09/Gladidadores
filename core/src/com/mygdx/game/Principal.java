package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.kotcrab.vis.ui.VisUI;
import com.mygdx.game.enums.Clases;
import com.mygdx.game.pantallas.SeleccionClase;
import com.mygdx.game.pantallas.RepartirAtributos;

public class Principal extends Game {

	
	@Override
	public void create () {
		VisUI.load();
		this.setScreen(new SeleccionClase(this));
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		super.render();

	}
	
	@Override
	public void dispose () {
		VisUI.dispose();
	}
}
