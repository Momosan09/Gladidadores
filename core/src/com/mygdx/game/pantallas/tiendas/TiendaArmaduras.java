package com.mygdx.game.pantallas.tiendas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.items.Arma;
import com.mygdx.game.items.Armadura;
import com.mygdx.game.pantallas.Tienda;
import com.mygdx.game.utiles.Recursos;

public class TiendaArmaduras extends Tienda{

    private Array<Armadura> armaduras;
	
	public TiendaArmaduras(Game g) {
		super(g);

	}


    @Override
    public void show() {
        super.show(); // para armar UI base
        Json json = new Json();

        armaduras = json.fromJson(Array.class, Armadura.class, Gdx.files.internal(Recursos.ARMADURAS));

        for (final Armadura armadura : armaduras) {
            final Label label = new Label(armadura.nombre + " (indice de armadura: " + armadura.indiceArmadura + ")", skin);
            label.setWrap(true);
            label.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println("click");
                    itemSeleccionado = armadura;
                    labelDeDescirpcion.setText(armadura.descripcion);
                }
            });
            tablaDeItems.add(label).growX().row();
        }
        
        //crearScrollPane();

    }
}
