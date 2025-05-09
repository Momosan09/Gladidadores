package com.mygdx.game.pantallas.ui;

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
import com.mygdx.game.enums.Clases;
import com.mygdx.game.enums.PantallasDelJuego;
import com.mygdx.game.pantallas.Ocultable;
import com.mygdx.game.pantallas.Pantalla;
import com.mygdx.game.utiles.ConfiguracionesJuego;
import com.mygdx.game.utiles.Recursos;

public class SeleccionClase extends Pantalla{
	
	public SeleccionClase() {
		stage = new Stage(new ScreenViewport());
		// ATENCION, La creacion de la stage va en el constructor de la clase y no en show porque como lo que estoy haciendo en PantallasManager es que se mantenga la misma pantalla (y no crear distintas instacias de la misma) cada vez que se cambia de pantalla cuando se "va y vuelve" entre pantallas, con el formato del show, me esta creando todos los actores de la stage de cero. haciendo que si incialmente una stage tiene 20 actores, la segunda vez que se "abra" esa pantalla va a tener 40, la tercera 60 y asi. Dejando la creacion en el constructor las cosas solo se crean una vez. Se puede usar show para otras cosas igual, como por ejemplo un contador de tiempo, ahi si, queres que el tiempo se reinicie cada vez que se abre la pantalla
		crearActores();
		
	}
	
	@Override
	public void show() {
		// ATENCION, La creacion de la stage va en el constructor de la clase y no en show porque como lo que estoy haciendo en PantallasManager es que se mantenga la misma pantalla (y no crear distintas instacias de la misma) cada vez que se cambia de pantalla cuando se "va y vuelve" entre pantallas, con el formato del show, me esta creando todos los actores de la stage de cero. haciendo que si incialmente una stage tiene 20 actores, la segunda vez que se "abra" esa pantalla va a tener 40, la tercera 60 y asi. Dejando la creacion en el constructor las cosas solo se crean una vez. Se puede usar show para otras cosas igual, como por ejemplo un contador de tiempo, ahi si, queres que el tiempo se reinicie cada vez que se abre la pantalla


	}

	@Override
	public void render(float delta) {

		if(visible) {
		stage.act(delta);
		stage.draw();
		visBandera = false;
		}else {
			if(!visBandera) {
				stage.unfocusAll();
				visBandera = true;
			}
		}
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
		stage.unfocusAll();
		stage.dispose();
	}

	public Stage getStage() {
		return stage;
	}
	

	private void crearActores() {
		Skin skin = VisUI.getSkin(); // Usar la skin que viene con VisUI


		Table table = new Table();
		table.setFillParent(true);
		table.pad(5);

		Table table1 = new Table();

		Label label = new Label("Elija Clase", skin);
		label.setAlignment(Align.center);
		table1.add(label).growX().colspan(2);

		table1.add();

		table1.row();

		Table table2 = new Table();

		ImageTextButton imageTextButton = new ImageTextButton("MAGO", skin);
		imageTextButton.setUserObject(Clases.MAGO);
		table2.add(imageTextButton).pad(5.0f).size(100);

		imageTextButton = new ImageTextButton("CABALLERO", skin);
		imageTextButton.setUserObject(Clases.CABALLERO);
		table2.add(imageTextButton).pad(5.0f).size(100);
		

		imageTextButton = new ImageTextButton("CLASE", skin);
		imageTextButton.setUserObject(Clases.SINCLASE);
		table2.add(imageTextButton).pad(5.0f).size(100);

		table2.row();
		imageTextButton = new ImageTextButton("BARDO", skin);
		imageTextButton.setUserObject(Clases.BARDO);
		table2.add(imageTextButton).pad(5.0f).size(100);

		imageTextButton = new ImageTextButton("CLASE", skin);
		imageTextButton.setUserObject(Clases.SINCLASE);
		table2.add(imageTextButton).size(100);

		table2.add();

		table2.row();
		table2.add();

		table2.add();

		table2.add();
		
		for (int i = 0; i < table2.getChildren().size; i++) {
		    final ImageTextButton child = (ImageTextButton) table2.getChild(i);
		    child.addListener(new ClickListener() {
		        @Override
		        public void clicked(InputEvent event, float x, float y) {
		            ConfiguracionesJuego.claseJugador = (Clases) child.getUserObject(); // casteo directo
		            System.out.println("Clase seleccionada: " + ConfiguracionesJuego.claseJugador);
		        }
		    });
		}

		
		ScrollPane scrollPane = new ScrollPane(table2, skin, "list");
		table1.add(scrollPane).grow().colspan(2);

		ImageButton imageButton = new ImageButton(skin);
		
		imageButton.addListener(new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		    	if(ConfiguracionesJuego.claseJugador != Clases.SINCLASE) {		    		
		        System.out.println("click");
		        stage.unfocusAll();
		        ConfiguracionesJuego.pantallaActual = PantallasDelJuego.REPARTIR_ATRIBUTOS;
		    	}else {
		    		System.out.println("Debe elegir una clase");
		    	}
		    }
		});

		imageButton.setColor(skin.getColor("red"));
		table1.add(imageButton);
		table.add(table1).grow();
		stage.addActor(table);
	}
}
