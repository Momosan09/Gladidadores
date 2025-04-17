package com.mygdx.game.pantallas;

/**
 * Cuando una pantalla(Screen) se puede cerrar pero despues volver a abrir es ocultable. se usa para evitar crear multiples instancias de la misma pantalla
 * @author  Momosan09
 *
 */
public interface Ocultable {
	
	boolean getVisible();
	void setVisible(boolean visible);
}
