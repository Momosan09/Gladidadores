package com.mygdx.game.pantallas;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Principal;
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

	private Principal g;
	private ArrayList<Pantalla> pantallas;
	private SeleccionClase slCls;
	private NombrarPersonaje nomPers;
	private RepartirAtributos repAtr;
	private Juego juego;
	private Tienda tienda;
	private Pantalla pantallaAcutal;
	
	public PantallasManager(Principal g) {
		this.g = g;
		pantallas = new ArrayList<Pantalla>();
		
	}
	
	public void determinarPantalla() {
		switch (ConfiguracionesJuego.pantallaActual) {
		case SELECCION_CLASE:
			if(slCls == null) {
				slCls = new SeleccionClase();
				pantallas.add(slCls);
				ConfiguracionesJuego.muxPantallas.addProcessor(slCls.getStage());
			}
			if(!ConfiguracionesJuego.muxPantallas.getProcessors().contains(slCls.getStage(), false)) {
				ConfiguracionesJuego.muxPantallas.addProcessor(slCls.getStage());
			}
			pantallaAcutal = slCls;
			break;

		case REPARTIR_ATRIBUTOS:
			if(repAtr == null) {
				repAtr = new RepartirAtributos();
				pantallas.add(repAtr);
				ConfiguracionesJuego.muxPantallas.addProcessor(repAtr.getStage());
			}
			if(!ConfiguracionesJuego.muxPantallas.getProcessors().contains(repAtr.getStage(), false)) {
				ConfiguracionesJuego.muxPantallas.addProcessor(repAtr.getStage());
			}
			pantallaAcutal = repAtr;
			break;
			
		case NOMBRAR_PERSONAJE:
			if(nomPers == null) {
				nomPers = new NombrarPersonaje();
				pantallas.add(nomPers);
				ConfiguracionesJuego.muxPantallas.addProcessor(nomPers.getStage());
			}
			if(!ConfiguracionesJuego.muxPantallas.getProcessors().contains(nomPers.getStage(), false)) {
				ConfiguracionesJuego.muxPantallas.addProcessor(nomPers.getStage());
			}
			
			pantallaAcutal = nomPers;
			break;
			
		case JUEGO:
			if(juego == null) {
				if(slCls != null)slCls.dispose();//Una vez que se entra al juego no se vuelve a usar
				
				//repAtr.dispose();
				if(nomPers != null)nomPers.dispose();//Una vez que se entra al juego no se vuelve a usar
				juego = new Juego();
//				ConfiguracionesJuego.muxPantallas.addProcessor(juego.getStage());
			}
//			if(!ConfiguracionesJuego.muxPantallas.getProcessors().contains(juego.getStage(), false)) {
//				ConfiguracionesJuego.muxPantallas.addProcessor(juego.getStage());
//			}
			pantallaAcutal = juego;
			break;
			
		default:
			break;
		}
		
		if(pantallaAcutal !=null && g.getScreen() != pantallaAcutal) {
			g.setPantalla(pantallaAcutal);
			System.out.println(pantallaAcutal);
			for(int i = 0; i< pantallas.size();i++) {
				if(pantallas.get(i) != pantallaAcutal) {
					pantallas.get(i).setVisible(false);
					ConfiguracionesJuego.muxPantallas.removeProcessor(pantallas.get(i).getStage());
				}
			}
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
