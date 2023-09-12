package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class DynamicGameObject extends GameObject{

    public  Vector2 velocity;
    public  Vector2 accel;

    public DynamicGameObject(float x, float y, float width, float height, Vector2 velocity, Vector2 accel) {
        super(x, y, width, height);
        this.velocity = velocity;
        this.accel = accel;
    }

    public DynamicGameObject(float x, float y, float width, float height) {
        super(x, y, width, height);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
