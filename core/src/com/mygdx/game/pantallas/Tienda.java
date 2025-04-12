package com.mygdx.game.pantallas;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
import com.mygdx.game.items.Item;

import java.util.EnumMap;

import com.mygdx.game.utiles.ConfiguracionesJuego;
import com.mygdx.game.utiles.Recursos;


public class Tienda implements Screen{

	
	private Game g;
	protected Stage stage;
	protected Skin skin;
	
	protected Table tablaDeItems;
	protected Label labelDeDescirpcion;
	protected ScrollPane scrollPaneItems;
	
	protected Item itemSeleccionado;//se asigna en las clases hijas
	
	public Tienda(Game g) {
		this.g = g;
	}
	
	@Override
	public void show() {
	    stage = new Stage(new ScreenViewport());
	    skin = VisUI.getSkin();
	    Gdx.input.setInputProcessor(stage);

	    Table table = new Table();
	    table.setFillParent(true);

	    Table table1 = new Table(); // contenedor principal horizontal (oro + detalles + lista de ítems)

	    // ORO
	    Label oroLabel = new Label("Oro=9999", skin);
	    oroLabel.setAlignment(Align.center);
	    oroLabel.setColor(skin.getColor("white"));
	    table1.add(oroLabel).padTop(20.0f).align(Align.top).width(150.0f).height(0.0f);

	    // PANEL DE DESCRIPCIÓN Y BOTONES
	    Table panelCentral = new Table();

	    labelDeDescirpcion = new Label("Este item viene de directo desde lorem, su ipsum es inigualable...", skin);
	    labelDeDescirpcion.setAlignment(Align.topLeft);
	    labelDeDescirpcion.setWrap(true);
	    labelDeDescirpcion.setColor(skin.getColor("white"));
	    ScrollPane descripcionScroll = new ScrollPane(labelDeDescirpcion, skin);
	    panelCentral.add(descripcionScroll).width(300.0f).height(200.0f);

	    panelCentral.row();

	    Table botones = new Table();


	    ImageButton botonCancelar = new ImageButton(skin);
	    botonCancelar.setColor(skin.getColor("red"));
	    botones.add(botonCancelar).expandX();
	    
	    ImageButton botonComprar = new ImageButton(skin);
	    botonComprar.setColor(skin.getColor("green"));
	    botonComprar.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                	if(itemSeleccionado !=null) {                		
                    System.out.println("Comprar " + itemSeleccionado.precio);
                	}
                    
        
                }
            });
	    botones.add(botonComprar).expandX();

	    panelCentral.add(botones).growX();

	    table1.add(panelCentral).padLeft(30.0f).padBottom(100.0f).grow().size(200.0f);

	    // LISTA DE ÍTEMS
	 // LISTA DE ÍTEMS
	    tablaDeItems = new Table();
	    tablaDeItems.top(); // asegura que los ítems se alineen arriba

	    scrollPaneItems = new ScrollPane(tablaDeItems, skin);
	    scrollPaneItems.setScrollingDisabled(true, false); // solo scroll vertical
	    scrollPaneItems.setFadeScrollBars(false); // opcional, para que siempre se vean las barras
	    scrollPaneItems.setScrollbarsOnTop(true); // opcional

	    // Tamaño fijo para el scrollpane
	    float anchoScroll = 200f;
	    float altoScroll = 100f;
	    table1.add(scrollPaneItems)
	        .width(anchoScroll)
	        .height(altoScroll)
	        .padLeft(50f)
	        .padRight(20f)
	        .padBottom(200f);


	    table.add(table1).grow();
	    stage.addActor(table);
	}

	

	@Override
	public void render(float delta) {
		stage.act();
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
