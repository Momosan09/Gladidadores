package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.kotcrab.vis.ui.VisUI;
import com.mygdx.game.enums.Clases;
import com.mygdx.game.enums.PantallasDelJuego;
import com.mygdx.game.pantallas.Juego;
import com.mygdx.game.pantallas.Pantalla;
import com.mygdx.game.pantallas.PantallasManager;
import com.mygdx.game.pantallas.ui.NombrarPersonaje;
import com.mygdx.game.pantallas.ui.RepartirAtributos;
import com.mygdx.game.pantallas.ui.SeleccionClase;
import com.mygdx.game.pantallas.ui.Tienda;
import com.mygdx.game.pantallas.ui.tiendas.TiendaArmaduras;
import com.mygdx.game.pantallas.ui.tiendas.TiendaArmas;
import com.mygdx.game.utiles.ConfiguracionesJuego;

public class Principal extends Game {

	private PantallasManager pm;
	
	@Override
	public void create () {
		Gdx.input.setInputProcessor(ConfiguracionesJuego.muxPantallas);
		VisUI.load();
		pm = new PantallasManager(this);
		ConfiguracionesJuego.pantallaActual = PantallasDelJuego.SELECCION_CLASE;

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		pm.determinarPantalla();
		super.render();


	}
	
	@Override
	public void dispose () {
		VisUI.dispose();
		super.dispose();
	}
	

	public void setPantalla(Pantalla screen) {
		super.setScreen(screen);
		screen.setVisible(true);
	}
}
