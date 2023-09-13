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
        setX(position.x);
        setY(position.y);

    }

    protected void movingPhysics(float dt){
//
//        if (getX() < 0) {
//            isBoundToWorld = true;
//            setX(0);
//            setVelocityVecX(-getVelocityVec().x);
//            setAccelerationVecX(-getAccelerationVec().x);
//
//            repelAngle=180;
//        }
//
//        // Check right edge
//        if (getX() + getWidth() > worldBounds.width) {
//            isBoundToWorld = true;
//            setX(worldBounds.width - getWidth());
//            setVelocityVecX(-getVelocityVec().x);
//            setAccelerationVecX(-getAccelerationVec().x);
//
//            repelAngle=0;
//        }
//
//        // Check bottom edge
//        if (getY() < 0) {
//            isBoundToWorld = true;
//            setY(0);
//            setVelocityVecY(-getVelocityVec().y);
//            setAccelerationVecY(-getAccelerationVec().y);
//
//        }
//
//        // Check top edge
//        if (getY() + getHeight() > worldBounds.height) {
//            isBoundToWorld = true;
//
//            setVelocityVecY(-getVelocityVec().y);
//            accel.y=-accel.y;
//
//            setY(worldBounds.height - getHeight());
//
//        }
    }

}
