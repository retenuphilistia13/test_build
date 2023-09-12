package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.awt.*;

public class GameObject extends Actor {

    public final Vector2 position;
    public final Rectangle bounds;

    private static com.badlogic.gdx.math.Rectangle playerWorldBounds;
    public GameObject (float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.bounds = new Rectangle((int) (x - width / 2), (int) (y - height / 2), (int) width, (int) height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }



    public  static void setWorldBounds(float width,float height){
        playerWorldBounds =new com.badlogic.gdx.math.Rectangle(0,0,width,height);

    }

    public  static com.badlogic.gdx.math.Rectangle getPlayerWorldBounds(){
        return playerWorldBounds;

    }


    public  static void setPlayerWorldBounds(com.badlogic.gdx.scenes.scene2d.Actor b){
        setWorldBounds(b.getWidth(),b.getHeight());
    }

    boolean isBoundToWorld;
    public void boundToGame(){

        if(getX()<0){
            setX(0);
        }
        if(getX() + getWidth()> playerWorldBounds.width){
            setX(playerWorldBounds.width-getWidth());
        }
        if(getY()<0){
            setY(0);
        }

        if(getY()+getHeight()> playerWorldBounds.height){
            setY(playerWorldBounds.height-getHeight());
        }



    }
}
