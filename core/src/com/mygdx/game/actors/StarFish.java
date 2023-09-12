package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class StarFish extends DynamicGameObject {
    AnimationFrame animationFrame;

    private Animation animationState;
    public StarFish(){
        super(10,10,100,100);

        elapsedTime=0;
        animationFrame=new AnimationFrame(this);

        animationFrame.loadTexture("assets/starfish.png");
        animationState=Animation.IDLE;
//        setAcceleration(20);
//        setMaxSpeed(2);

    }

//
//    public StarFish(float x, float y, Stage s){
//        super(x,y,s);
//        loadTexture("starfish.png");
//
//        setAcceleration(10);
//        setMaxSpeed(3 + (int) (Math.random() * (10 - 3)));
//
//        //   setDeceleration(0);
//        randomInt = -360 + (int) (Math.random() * (360 - -360));
//    }
    int randomInt;
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        Color c = getColor(); // used to apply tint color effect
        batch.setColor(c.r, c.g, c.b, c.a);


            if (animationState == Animation.IDLE) {
                if (isVisible() && animationFrame.animation != null)
                    batch.draw(animationFrame.animation.getKeyFrame(elapsedTime),
                            getX(), getY(), getOriginX(), getOriginY(),
                            getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

                else if (isVisible()) {
                    batch.draw(animationFrame.getTextureRegion(),
                            getX(), getY(), getOriginX(), getOriginY(),
                            getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
                }

            }




    }

    float elapsedTime;
    boolean animationPaused;
    @Override
    public void act(float dt) {
        super.act(dt);

        if(!animationPaused){//if not paused
            elapsedTime+=dt;
        }
//
//    repelToWorld(dt);
//
////        System.out.println("angle to accelarate "+getMotionAngle());
//       accelerateAtAngle(randomInt);
//
//
//    movingPhysics(dt);
}

//
//            accelerateAtAngle(randomInt);
//
//
//        movingPhysics(dt);




}
