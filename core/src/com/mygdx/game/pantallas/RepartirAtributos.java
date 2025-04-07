package com.mygdx.game.pantallas;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.kotcrab.vis.ui.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.enums.Atributos;
import com.mygdx.game.enums.Clases;
import java.util.EnumMap;
import com.mygdx.game.utiles.Recursos;

public class RepartirAtributos implements Screen{

	private Game g;
	private Stage stage;
	private Skin skin;
	private Clases claseElegida;
	


	private int puntosDisponibles = 12;
	private EnumMap<Atributos, Integer> puntosAtributos = new EnumMap<>(Atributos.class);
	private EnumMap<Atributos, Label> labelsAtributos = new EnumMap<>(Atributos.class); // para actualizar visualmente

	
	public RepartirAtributos (Game g, Clases claseElegida) {
		this.g = g;
		this.claseElegida = claseElegida;
	}
	
	@Override
	public void show() {
		stage = new Stage(new ScreenViewport());
		Skin skin = VisUI.getSkin(); // Usar la skin que viene con VisUI
		Gdx.input.setInputProcessor(stage);
		
		for (Atributos atributo : Atributos.values()) {
		    puntosAtributos.put(atributo, 0);
		}


		Table table = new Table();
		table.setFillParent(true);

		Table table1 = new Table();

		Label label = new Label("Reparta Atributos", skin);
		table1.add(label);

		table1.row();

		label = new Label("Clase: " + claseElegida, skin);
		table1.add(label).padBottom(5);
		table1.row();
		
		final Label labelPuntos = new Label("Puntos: " + puntosDisponibles, skin);
		table1.add(labelPuntos).padBottom(20);
		table1.row();

		Table table2 = new Table();

		ImageButton imageButton = new ImageButton(skin);
		imageButton.setColor(skin.getColor("red"));
		imageButton.addListener(new ClickListener() {
	        @Override
	        public void clicked(InputEvent event, float x, float y) {

	        	System.out.println("Volver para atras click");
	        	g.setScreen(new SeleccionClase(g));
	        }
	    });
		table2.add(imageButton);

		Table table3 = new Table();

		Table table4 = new Table();



		for (Atributos atributo : Atributos.values()) {

		    // Botón "-" (disminuir)
		    final ImageTextButton botonMenos = new ImageTextButton("-", skin);
		    botonMenos.setUserObject(atributo);
		    botonMenos.addListener(new ClickListener() {
		        @Override
		        public void clicked(InputEvent event, float x, float y) {
		            Atributos atr = (Atributos) botonMenos.getUserObject();
		            if (puntosAtributos.get(atr) > 0) {
		                puntosAtributos.put(atr, puntosAtributos.get(atr) - 1);
		                puntosDisponibles++;
		                labelsAtributos.get(atr).setText(String.valueOf(puntosAtributos.get(atr)));
		                System.out.println(atr + ": " + puntosAtributos.get(atr));
		            }
		        }
		    });
		    table4.add(botonMenos);

		    // Label del valor actual
		    Label labelValor = new Label("0", skin);
		    labelsAtributos.put(atributo, labelValor);
		    table4.add(new Label(atributo.toString(), skin)).pad(5);
		    table4.add(labelValor).width(40);

		    // Botón "+" (aumentar)
		    final ImageTextButton botonMas = new ImageTextButton("+", skin);
		    botonMas.setUserObject(atributo);
		    botonMas.addListener(new ClickListener() {
		        @Override
		        public void clicked(InputEvent event, float x, float y) {
		            Atributos atr = (Atributos) botonMas.getUserObject();
		            if (puntosDisponibles > 0) {
		                puntosAtributos.put(atr, puntosAtributos.get(atr) + 1);
		                puntosDisponibles--;
		                labelsAtributos.get(atr).setText(String.valueOf(puntosAtributos.get(atr)));
		                System.out.println(atr + ": " + puntosAtributos.get(atr));
		                labelPuntos.setText("Puntos: " + puntosDisponibles);

		            }
		        }
		    });
		    table4.add(botonMas);

		    table4.row();
		}

		



			table3.add(table4);
			table2.add(table3).grow();
			imageButton = new ImageButton(skin);
			imageButton.setColor(skin.getColor("red"));
			imageButton.addListener(new ClickListener() {
		        @Override
		        public void clicked(InputEvent event, float x, float y) {

		            if (puntosDisponibles == 0) {
		            	System.out.println("Click");
		            }else {
		            	System.out.println("Primero asigne todos los puntos");
		            }
		        }
		    });
			table2.add(imageButton);
		
		table1.add(table2).grow();
		table.add(table1).grow();
		stage.addActor(table);

	}

	@Override
	public void render(float delta) {
		stage.draw();
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

}
