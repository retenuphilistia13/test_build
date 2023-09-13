package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import static com.mygdx.game.GameConstants.screenHeight;
import static com.mygdx.game.GameConstants.screenWidth;

public class Player extends DynamicGameObject{



    //private Animation<TextureRegion> walkAnimation;

    AnimationFrame walkFrame;

    private float controlX,controlY;

    private Rotation rotation;
    private Animation animationState;
    float elapsedTime;
    private boolean animationPaused;


    public void setMoveX(float mX){

        position.x+=mX*5;
        if(mX>0)
        rotation=Rotation.RIGHT;
        else if(mX<0){
            rotation=Rotation.LEFT;
        }


    }

    public void setMoveY(float mY){


//        if(mY>0)
//            rotation=Rotation.UP;
//        else if(mY<0){
//            rotation=Rotation.DOWN;
//        }


        position.y+=mY*5;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        Color c = getColor(); // used to apply tint color effect
        batch.setColor(c.r, c.g, c.b, c.a);

if(animationState==Animation.IDLE) {
    if (isVisible() && walkFrame.animation != null)
        batch.draw(walkFrame.animation.getKeyFrame(elapsedTime),
                getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

    else if (isVisible()) {
        batch.draw(walkFrame.getTextureRegion(),
                getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

}

else if(animationState==Animation.RUN) {

    if (isVisible() && walkFrame.animation != null)
        batch.draw(walkFrame.animation.getKeyFrame(elapsedTime),
                getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

    else if (isVisible()) {
        batch.draw(walkFrame.getTextureRegion(),
                getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

}



    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(!animationPaused){//if not paused
            elapsedTime+=delta;
        }

        super.boundToGame();

clearActions();//in case

//        Action move= Actions.moveBy(position.x,getY());
if(position.x==0){
    animationState=Animation.IDLE;
}
        if (rotation==rotation.LEFT) {
            // Flip the player horizontally
            setScaleX(-1);
            // Set the origin at the center of the player
            setOrigin(getWidth() / 2, getHeight() / 2);
            rotation=Rotation.LEFT;
            animationState=Animation.RUN;
        } else if(rotation==rotation.RIGHT){
            rotation=Rotation.RIGHT;
            setScaleX(1); // Set it back to the original scale (no flip)
            setOrigin(getWidth() / 2, getHeight() / 2);
            animationState=Animation.RUN;
        }
//        addAction(move);
if(position.x>screenWidth-getWidth()){
    position.x=screenWidth-getWidth();
}else if(position.x<0){
    position.x=0;
}

        if(position.y>screenHeight-getHeight()){
            position.y=screenHeight-getHeight();
        }else if(position.y<0){
            position.y=0;
        }

    }
    //end act/////

    public void setAnimationPaused(boolean pause) {
        animationPaused = pause;
    }
    public Player(String fileName){

        super(0,0,100,100);
        rotation=Rotation.RIGHT;

        animationPaused = false;

        elapsedTime = 0;

        String[] fileNames = new String[1];
        fileNames[0] = fileName;


        walkFrame=new AnimationFrame(this);
        walkFrame.loadAnimationFromFiles(fileNames,1,true);



        controlX=0;
        controlY=0;


    }
    public Player(String[] fileAnimation){

        super(0,0,100,100);



        rotation=Rotation.RIGHT;

        animationPaused = false;

        animationState=Animation.IDLE;

        elapsedTime = 0;

//        runFrame=new AnimationFrame(this);
//        runFrame.loadAnimationFromFiles(runAnimation,0.1f,true);


        walkFrame=new AnimationFrame(this);
        walkFrame.loadAnimationFromFiles(fileAnimation,0.1f,true);


        controlX=0;
        controlY=0;


    }





}
