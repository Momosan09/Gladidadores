package com.mygdx.game.pantallas.ui.tiendas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.items.Arma;
import com.mygdx.game.pantallas.ui.Tienda;
import com.mygdx.game.utiles.Recursos;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.utils.Json;

public class TiendaArmas extends Tienda{

	
    private Array<Arma> armas;
	
	public TiendaArmas(Game g) {
		super(g);

	}


    @Override
    public void show() {
        super.show(); // para armar UI base
        Json json = new Json();

        armas = json.fromJson(Array.class, Arma.class, Gdx.files.internal(Recursos.ARMAS));

        for (final Arma arma : armas) {
            final Label label = new Label(arma.nombre + " (Daño: " + arma.danio + ")", skin);
            label.setWrap(true);
            label.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println("click");
                    itemSeleccionado = arma;
                    labelDeDescirpcion.setText(arma.descripcion);
                }
            });
            tablaDeItems.add(label).growX().row();
        }
        
        //crearScrollPane();

    }
}
