package com.mygdx.game.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.pantallas.ui.NombrarPersonaje;
import com.mygdx.game.pantallas.ui.RepartirAtributos;
import com.mygdx.game.pantallas.ui.SeleccionClase;
import com.mygdx.game.pantallas.ui.Tienda;
import com.mygdx.game.utiles.ConfiguracionesJuego;

/**
 * Esta clase determina que pantalla(Screen) se dibuja
 * @author  Momosan09
 *
 */
public class PantallasManager {

	private Game g;
	private SeleccionClase slCls;
	private NombrarPersonaje nomPers;
	private RepartirAtributos repAtr;
	private Tienda tienda;
	private Screen pantallaAcutal;
	
	public PantallasManager(Game g) {
		this.g = g;
		
	}
	
	public void determinarPantalla() {
		switch (ConfiguracionesJuego.pantallaActual) {
		case SELECCION_CLASE:
			if(slCls == null) {
				slCls = new SeleccionClase();
				ConfiguracionesJuego.muxPantallas.addProcessor(slCls.getStage());
			}
			pantallaAcutal = slCls;
			break;

		case REPARTIR_ATRIBUTOS:
			if(repAtr == null) {
				repAtr = new RepartirAtributos();
				ConfiguracionesJuego.muxPantallas.addProcessor(repAtr.getStage());
			}
			pantallaAcutal = repAtr;
			
			break;
			
		default:
			break;
		}
		
		if(pantallaAcutal !=null && g.getScreen() != pantallaAcutal) {
			g.setScreen(pantallaAcutal);
		}
	}
	
	
	/* ver como crear un metodo generico que acepte una Screen y que devuelva el objeto con la clase correspondiente
	  
	private void contenidoDelSwich(Screen s) {
		if(s == null) {
			s = new SeleccionClase, por ejemplo
			ConfiguracionesJuego.muxPantallas.addProcessor(s.getStage());
		}
		pantallaAcutal = slCls;
	}*/
	
	
}
