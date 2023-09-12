package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.GameConstants;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actors.Controller;
import com.mygdx.game.actors.GameObject;
import com.mygdx.game.actors.Player;
import com.mygdx.game.actors.StarFish;


/**
 * Created by Dewa on 2/19/2017.
 */
public class GameScreen implements Screen {

    final MyGdxGame game;
    private Stage stage;
    private Skin mySkin;
private Button homeBtn;

    Controller touchpad;
    Skin skin;
    Player actor;

    StarFish starFish;
    public GameScreen(final MyGdxGame game){
        this.game = game;
        stage = new Stage();
        mySkin = new Skin(Gdx.files.internal(GameConstants.skin));

        Player.setWorldBounds(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        GameObject.setWorldBounds(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        initHomeBtn();

//        Touchpad touch=new Touchpad(10.0f,mySkin,"default");
        touchpad=new Controller(1.0f,mySkin,"default");

        touchpad.setBounds(25,25,300,300);
        touchpad.getColor().a=0.70f;

        int count=1,i=0;

        String[] walkFrame=new String[6];

        for( i=0,count=1;i<6;i++,  count++){
            walkFrame[i]="skin/run/g_run("+Integer.toString(count)+").png";

        }

actor =new Player(walkFrame);

         starFish=new StarFish();

        actor.setWidth(250); // Set the width of the actor
        actor.setHeight(250); // Set the height of the actor

       stage.addActor(starFish);
        stage.addActor(actor);
        stage.addActor(touchpad);

        stage.addActor(homeBtn);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        stage.act();

        float dt =Gdx.graphics.getDeltaTime();
stage.act();
        update(dt);

        stage.draw();

    }

    public void update(float dt){
        float knobX = touchpad.getKnobX();
        float knobY = touchpad.getKnobY();
        //System.out.println("originx"+controller.getKnobPercentX()+" prigin y"+controller.getKnobPercentY());


        actor.setMoveX(touchpad.getKnobPercentX());
        actor.setMoveY(touchpad.getKnobPercentY());

//
//if(Intersector.overlaps(new Rectangle(100,100,200,200),starFish.getCollisionRectangle())){
//
//}

//		System.out.println("knob X"+knobX+"   knop Y:"+knobY);
// Use knobX and knobY to control your game character or perform other actions

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


    private void initHomeBtn(){
        homeBtn = new TextButton("HOME",mySkin,"default");
        homeBtn.setSize(GameConstants.col_width,GameConstants.row_height);
        homeBtn.setPosition(0,GameConstants.screenHeight - homeBtn.getHeight());
        // System.out.println("screenHeight"+(GameConstants.screenHeight)+"\nbtn height "+homeBtn.getHeight()+"\n"+"claculation"+(GameConstants.screenHeight - homeBtn.getHeight()));

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
    }

}
