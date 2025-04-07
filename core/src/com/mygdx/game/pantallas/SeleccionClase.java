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
import com.mygdx.game.enums.Clases;
import com.mygdx.game.utiles.Recursos;

public class SeleccionClase implements Screen{

	private Game g;
	private Stage stage;
	private Skin skin;
	private Clases claseSeleccionada = Clases.SINCLASE;
	public SeleccionClase(Game g) {
		this.g = g;
	}
	
	@Override
	public void show() {
		stage = new Stage(new ScreenViewport());
		Skin skin = VisUI.getSkin(); // Usar la skin que viene con VisUI
		Gdx.input.setInputProcessor(stage);

		Table table = new Table();
		table.setFillParent(true);

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
		            claseSeleccionada = (Clases) child.getUserObject(); // 👈 casteo directo
		            System.out.println("Clase seleccionada: " + claseSeleccionada);
		        }
		    });
		}

		
		ScrollPane scrollPane = new ScrollPane(table2, skin, "list");
		table1.add(scrollPane).grow().colspan(2);

		ImageButton imageButton = new ImageButton(skin);
		
		imageButton.addListener(new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		    	if(claseSeleccionada != Clases.SINCLASE) {		    		
		        System.out.println("click");
		        g.setScreen(new RepartirAtributos(g, claseSeleccionada));
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

	private void determinarClase() {
		
	}
	
}
