package com.mygdx.game.pantallas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.pantallas.mapa.Plaza;
import com.mygdx.game.utiles.ConfiguracionesJuego;
import com.mygdx.game.utiles.Recursos;


/**
 * Esta clase determina que UI o HUD debe dibujarse mientras se esta en la pantalla Juego
 * @author  Momosan09
 *
 */
public class UIManager {
	
	
	private Plaza plaza = new Plaza();
	private PantallasDelJuego pantallaADibujar = new Plaza();
	
	public void determinarPantalla() {
		switch (ConfiguracionesJuego.estadoDelJuego) {
		case COLISEO:
			//dibuja pantalla de seleccion de clase
			break;

		case PLAZA:
			pantallaADibujar = plaza;
			break;
		default:
			break;
		}
	}
	
	/**
	 * Devuelve la pantalla que se debe dibujar
	 * @return
	 */
	public PantallasDelJuego getPantallaCorrespondiente() {
		return pantallaADibujar;
	}
}
