package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;

public class ImageObject extends GameObject{
    AnimationFrame animationFrame;
    Animation animationState;
    public ImageObject(float x, float y,String filename) {
        super(x, y);
        animationFrame=new AnimationFrame(this);



        animationFrame.loadTexture(filename);
        setBounds(0,0,getWidth(),getHeight());
        animationState=Animation.IDLE;
    }


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

        if (!animationPaused) {//if not paused
            elapsedTime += dt;
        }
    }

public void setImageToScreen(){

    float multi=1.0f;

    do{
        this.setSize(this.getWidth()*multi,this.getHeight()*multi);
//
        this.setWidth(this.getWidth()*multi);
        this.setHeight(this.getHeight()*multi);
        multi+=0.1;

    }while(this.getWidth()<= Gdx.graphics.getWidth()||this.getHeight()<=Gdx.graphics.getHeight());
}


}
