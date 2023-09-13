package com.mygdx.game.screens;

import static sun.security.util.Debug.println;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Affine2;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GameConstants;
import com.mygdx.game.MyGdxGame;

import com.mygdx.game.actors.ImageObject;
import jdk.internal.net.http.common.Log;

/**
 * Created by Dewa on 2/18/2017.
 */
public class MenuScreen implements Screen {

    final MyGdxGame game;
//    private Texture badlogic;
    private Skin mySkin;
    private Stage stage;

//    private SpriteBatch batch;
//
//    private Viewport screenPort;


    public MenuScreen(final MyGdxGame game){
        this.game = game;
        game.myAssetManager.queueAddSkin();
        game.myAssetManager.manager.finishLoading();
        mySkin = game.myAssetManager.manager.get(GameConstants.skin);

        ImageObject menuBackground=new ImageObject(0,0,"background.png");

        menuBackground.setImageToScreen();

        mySkin = new Skin(Gdx.files.internal(GameConstants.skin));

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

//        batch =new SpriteBatch();


        Label gameTitle = new Label("GAME MENU",mySkin,"default");
        gameTitle.setSize(GameConstants.col_width*2,GameConstants.row_height*2);
        gameTitle.setPosition(GameConstants.centerX - gameTitle.getWidth()/2,GameConstants.centerY + GameConstants.row_height);
        gameTitle.setAlignment(Align.center);

        Button startBtn = new TextButton("START GAME",mySkin,"default");
        startBtn.setSize(GameConstants.col_width*2,GameConstants.row_height);
        startBtn.setPosition(GameConstants.centerX - startBtn.getWidth()/2,GameConstants.centerY - 15);
        startBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.gotoGameScreen();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button settingsBtn = new TextButton("SETTINGS",mySkin,"default");
        settingsBtn.setSize(GameConstants.col_width*2,GameConstants.row_height);
        settingsBtn.setPosition(GameConstants.centerX - settingsBtn.getWidth()/2,startBtn.getY() - GameConstants.row_height -15);
        settingsBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.gotoSettingsScreen();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

stage.addActor(menuBackground);
        stage.addActor(gameTitle);
        stage.addActor(startBtn);
        stage.addActor(settingsBtn);


    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


//       batch.begin();
//       batch.draw(badlogic,0,0);
//       batch.end();

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

//
//        badlogic.dispose();
//        batch.dispose();
        mySkin.dispose();
        stage.dispose();

    }
}
