package com.mygdx.game.pantallas.ui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;
import com.mygdx.game.enums.Atributos;
import com.mygdx.game.enums.PantallasDelJuego;
import com.mygdx.game.pantallas.Pantalla;
import com.mygdx.game.utiles.ConfiguracionesJuego;

import java.util.EnumMap;

public class RepartirAtributos extends Pantalla {

    private EnumMap<Atributos, Label> labelsAtributos = new EnumMap<>(Atributos.class); // para actualizar visualmente
    private Label labelClase;

    public RepartirAtributos() {
		stage = new Stage(new ScreenViewport());
		crearActores();// ATENCION, La creacion de la stage va en el constructor de la clase y no en show porque como lo que estoy haciendo en PantallasManager es que se mantenga la misma pantalla (y no crear distintas instacias de la misma) cada vez que se cambia de pantalla cuando se "va y vuelve" entre pantallas, con el formato del show, me esta creando todos los actores de la stage de cero. haciendo que si incialmente una stage tiene 20 actores, la segunda vez que se "abra" esa pantalla va a tener 40, la tercera 60 y asi. Dejando la creacion en el constructor las cosas solo se crean una vez. Se puede usar show para otras cosas igual, como por ejemplo un contador de tiempo, ahi si, queres que el tiempo se reinicie cada vez que se abre la pantalla

    }

    @Override
    public void show() {
    	// ATENCION, La creacion de la stage va en el constructor de la clase y no en show porque como lo que estoy haciendo en PantallasManager es que se mantenga la misma pantalla (y no crear distintas instacias de la misma) cada vez que se cambia de pantalla cuando se "va y vuelve" entre pantallas, con el formato del show, me esta creando todos los actores de la stage de cero. haciendo que si incialmente una stage tiene 20 actores, la segunda vez que se "abra" esa pantalla va a tener 40, la tercera 60 y asi. Dejando la creacion en el constructor las cosas solo se crean una vez. Se puede usar show para otras cosas igual, como por ejemplo un contador de tiempo, ahi si, queres que el tiempo se reinicie cada vez que se abre la pantalla
    	labelClase.setText("Clase: " + ConfiguracionesJuego.claseJugador);
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
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
    
    
    public Stage getStage() {
    	return stage;
    }
    
    private void crearActores() {
    	Skin skin = VisUI.getSkin();

        // Inicializar los atributos solo si no fueron inicializados antes
        if (ConfiguracionesJuego.puntosAtributos.isEmpty()) {
            for (Atributos atributo : Atributos.values()) {
                ConfiguracionesJuego.puntosAtributos.put(atributo, 0);
            }
        }

        Table table = new Table();
        table.pad(5);
        table.setFillParent(true);

        Table table1 = new Table();

        Label label = new Label("Reparta Atributos", skin);
        table1.add(label);

        table1.row();

        labelClase = new Label("Clase: " + ConfiguracionesJuego.claseJugador, skin);
        table1.add(labelClase).padBottom(5);
        table1.row();

        final Label labelPuntos = new Label("Puntos: " + ConfiguracionesJuego.puntosDisponibles, skin);
        table1.add(labelPuntos).padBottom(20);
        table1.row();

        Table table2 = new Table();

        ImageButton imageButton = new ImageButton(skin);
        imageButton.setColor(skin.getColor("red"));
        imageButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Volver para atras click");
                ConfiguracionesJuego.pantallaActual = PantallasDelJuego.SELECCION_CLASE;
            }
        });
        table2.add(imageButton);

        Table table3 = new Table();
        Table table4 = new Table();

        for (Atributos atributo : Atributos.values()) {
            // Botón "-"
            final ImageTextButton botonMenos = new ImageTextButton("-", skin);
            botonMenos.setUserObject(atributo);
            botonMenos.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Atributos atr = (Atributos) botonMenos.getUserObject();
                    if (ConfiguracionesJuego.puntosAtributos.get(atr) > 0) {
                        ConfiguracionesJuego.puntosAtributos.put(atr, ConfiguracionesJuego.puntosAtributos.get(atr) - 1);
                        ConfiguracionesJuego.puntosDisponibles++;
                        labelsAtributos.get(atr).setText(String.valueOf(ConfiguracionesJuego.puntosAtributos.get(atr)));
                        labelPuntos.setText("Puntos: " + ConfiguracionesJuego.puntosDisponibles);
                        System.out.println(atr + ": " + ConfiguracionesJuego.puntosAtributos.get(atr));
                    }
                }
            });
            table4.add(botonMenos);

            // Label con valor actual del atributo
            int valorInicial = ConfiguracionesJuego.puntosAtributos.get(atributo);
            Label labelValor = new Label(String.valueOf(valorInicial), skin);
            labelsAtributos.put(atributo, labelValor);

            table4.add(new Label(atributo.toString(), skin)).pad(5);
            table4.add(labelValor).width(40);

            // Botón "+"
            final ImageTextButton botonMas = new ImageTextButton("+", skin);
            botonMas.setUserObject(atributo);
            botonMas.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Atributos atr = (Atributos) botonMas.getUserObject();
                    if (ConfiguracionesJuego.puntosDisponibles > 0) {
                        ConfiguracionesJuego.puntosAtributos.put(atr, ConfiguracionesJuego.puntosAtributos.get(atr) + 1);
                        ConfiguracionesJuego.puntosDisponibles--;
                        labelsAtributos.get(atr).setText(String.valueOf(ConfiguracionesJuego.puntosAtributos.get(atr)));
                        labelPuntos.setText("Puntos: " + ConfiguracionesJuego.puntosDisponibles);
                        System.out.println(atr + ": " + ConfiguracionesJuego.puntosAtributos.get(atr));
                    }
                }
            });
            table4.add(botonMas);

            table4.row();
        }

        table3.add(table4);
        table2.add(table3).grow();

        // Botón para continuar
        imageButton = new ImageButton(skin);
        imageButton.setColor(skin.getColor("red"));
        imageButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (ConfiguracionesJuego.puntosDisponibles == 0) {
    		        stage.unfocusAll();
    		        ConfiguracionesJuego.pantallaActual = PantallasDelJuego.NOMBRAR_PERSONAJE;
                } else {
                    System.out.println("Primero asigne todos los puntos");
                }
            }
        });
        table2.add(imageButton);

        table1.add(table2).grow();
        table.add(table1).grow();
        stage.addActor(table);
    }
}
