package com.mygdx.game.pantallas;

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
import com.mygdx.game.utiles.ConfiguracionesJuego;

import java.util.EnumMap;

public class RepartirAtributos implements Screen {

    private Game g;
    private Stage stage;
    private Skin skin;

    private EnumMap<Atributos, Label> labelsAtributos = new EnumMap<>(Atributos.class); // para actualizar visualmente

    public RepartirAtributos(Game g) {
        this.g = g;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        skin = VisUI.getSkin();
        Gdx.input.setInputProcessor(stage);

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

        label = new Label("Clase: " + ConfiguracionesJuego.claseJugador, skin);
        table1.add(label).padBottom(5);
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
                g.setScreen(new SeleccionClase(g));
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
                    g.setScreen(new NombrarPersonaje(g));
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

    @Override
    public void render(float delta) {
        stage.draw();
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
}
