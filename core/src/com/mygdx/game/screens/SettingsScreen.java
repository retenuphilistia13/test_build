package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.GameConstants;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Dewa on 2/19/2017.
 */
public class SettingsScreen implements Screen {

    final MyGdxGame game;
    private Skin mySkin;
    private Stage stage;

    public SettingsScreen(final MyGdxGame game){
        this.game = game;
        mySkin = new Skin(Gdx.files.internal(GameConstants.skin));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);


        Button homeBtn = new TextButton("HOME",mySkin,"default");
        homeBtn.setSize(GameConstants.col_width,GameConstants.row_height);
        homeBtn.setPosition(0,GameConstants.screenHeight - homeBtn.getHeight());

        //home btn litener
        homeBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.gotoMenuScreen();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        stage.addActor(homeBtn);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
       // Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
       // game.screenPort.update(width,height);

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
        mySkin.dispose();
        stage.dispose();

    }
}
