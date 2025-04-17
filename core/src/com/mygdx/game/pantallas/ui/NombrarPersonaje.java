package com.mygdx.game.pantallas.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.kotcrab.vis.ui.*;
import com.kotcrab.vis.ui.widget.VisTextField.VisTextFieldStyle;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.enums.Atributos;
import com.mygdx.game.enums.Clases;
import com.mygdx.game.enums.PantallasDelJuego;
import com.mygdx.game.pantallas.Pantalla;

import java.util.EnumMap;

import com.mygdx.game.utiles.ConfiguracionesJuego;
import com.mygdx.game.utiles.Recursos;

public class NombrarPersonaje extends Pantalla{
	
	private TextField nombre, apodo;
	
	
	public NombrarPersonaje() {
		stage = new Stage(new ScreenViewport());
		crearActores();// ATENCION, La creacion de la stage va en el constructor de la clase y no en show porque como lo que estoy haciendo en PantallasManager es que se mantenga la misma pantalla (y no crear distintas instacias de la misma) cada vez que se cambia de pantalla cuando se "va y vuelve" entre pantallas, con el formato del show, me esta creando todos los actores de la stage de cero. haciendo que si incialmente una stage tiene 20 actores, la segunda vez que se "abra" esa pantalla va a tener 40, la tercera 60 y asi. Dejando la creacion en el constructor las cosas solo se crean una vez. Se puede usar show para otras cosas igual, como por ejemplo un contador de tiempo, ahi si, queres que el tiempo se reinicie cada vez que se abre la pantalla

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
	}

	public Stage getStage() {
		return stage;
	}
	
	private void crearActores() {
		Skin skin = VisUI.getSkin();
		

		Table table = new Table();
		table.setFillParent(true);
		table.pad(5);

		Table table1 = new Table();

		table1.add();

		Label label = new Label("Nombra a tu gladiador", skin);
		label.setColor(skin.getColor("white"));
		table1.add(label);

		table1.add();

		table1.row();
		ImageButton imageButton = new ImageButton(skin);
		imageButton.addListener(new ClickListener() {
	        @Override
	        public void clicked(InputEvent event, float x, float y) {

	        	System.out.println("Volver para atras click");
	        	ConfiguracionesJuego.pantallaActual = PantallasDelJuego.REPARTIR_ATRIBUTOS;
	        }
	    });
		table1.add(imageButton);

		Table table2 = new Table();

		 nombre = new TextField(null, skin);
		table2.add(nombre).growY();

		table2.row();
		label = new Label("Apodo", skin);
		label.setColor(skin.getColor("white"));
		table2.add(label).growY();

		table2.row();
		apodo = new TextField(null, skin);
		table2.add(apodo).growY();
		table1.add(table2).grow();

		imageButton = new ImageButton(skin);
		imageButton.addListener(new ClickListener() {
	        @Override
	        public void clicked(InputEvent event, float x, float y) {

	        	if(nombre.getText().isBlank()) {
	        		nombre.setColor(Color.RED);

	        	}else {
	        		nombre.setColor(Color.BLACK);
		        	ConfiguracionesJuego.nombre = nombre.getText();
		        	ConfiguracionesJuego.apodo = apodo.getText();
		        	System.out.println(ConfiguracionesJuego.nombre);
	                ConfiguracionesJuego.pantallaActual = PantallasDelJuego.JUEGO;
	        	}
	        }
	    });
		table1.add(imageButton);

		table1.row();
		table1.add();

		table1.add();

		table1.add();
		table.add(table1).grow();
		stage.addActor(table);

	}

}
