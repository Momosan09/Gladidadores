package com.mygdx.game.pantallas;

import com.mygdx.game.utiles.ConfiguracionesJuego;


/**
 * Esta clase determina que UI o HUD debe dibujarse mientras se esta en la pantalla Juego
 * @author  Momosan09
 *
 */
public class UIManager {

	public void determinarPantalla() {
		switch (ConfiguracionesJuego.estadoDelJuego) {
		case COLISEO:
			//dibuja pantalla de seleccion de clase
			break;

		default:
			break;
		}
	}
}
