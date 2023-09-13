package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.GameConstants;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actors.*;

import java.util.ArrayList;
import java.util.Iterator;

import static com.mygdx.game.GameConstants.screenHeight;
import static com.mygdx.game.GameConstants.screenWidth;


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
    Player player;

//    StarFish starFish;

    ArrayList<StarFish> starList;
    public GameScreen(final MyGdxGame game){
        this.game = game;
        stage = new Stage();
        mySkin = new Skin(Gdx.files.internal(GameConstants.skin));

        ImageObject backgroundImage=new ImageObject(0,0,"background_rinbow.png");
        // System.out.println("width "+screenWidth+ " \nheight "+screenHeight);


        backgroundImage.setImageToScreen();
        GameObject.setWorldBounds(backgroundImage.getWidth(),backgroundImage.getHeight());
//        GameObject.setWorldBounds(200,200);
        stage.addActor(backgroundImage);



        initHomeBtn();

//        Touchpad touch=new Touchpad(10.0f,mySkin,"default");
        touchpad=new Controller(20.0f,mySkin,"default");

        touchpad.setBounds(25,25,300,300);
        touchpad.getColor().a=0.70f;

        int count=1,i=0;

        String[] walkFrame=new String[6];

        for( i=0,count=1;i<6;i++,  count++){
            walkFrame[i]="skin/run/g_run("+Integer.toString(count)+").png";

        }

player =new Player(walkFrame);

       starList=new ArrayList<>();

float scale=300;
        player.setBounds(0,0, player.getWidth()+scale,player.getHeight()+scale);

generateStars();


for(int j=0;j<starList.size()-1;j++){
    stage.addActor(starList.get(j));
}

        stage.addActor(player);
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

    public void update(float dt) {
//        float knobX = touchpad.getKnobX();
//        float knobY = touchpad.getKnobY();
        //System.out.println("originx"+controller.getKnobPercentX()+" prigin y"+controller.getKnobPercentY());


        player.setMoveX(touchpad.getKnobPercentX());
        player.setMoveY(touchpad.getKnobPercentY());

//        collectStar();


    }

private void collectStar(){

//        if (g!= GameState.WIN) {
    for(int i=0;i<starList.size();i++) {
        if (starList.get(i).isAlive) {
            Iterator<StarFish> iterator = starList.iterator();
            while (iterator.hasNext()) {
                StarFish starfish = iterator.next();

                if (player.overlaps(starfish)) {
                    System.out.println("hitting");
                    starfish.isAlive = false;
                    starfish.remove(); // This removes the actor from the stage.
                    iterator.remove(); // Remove it from the list.
                    // If you want to remove the texture (assuming you have a removeTexture method), do it here.
//                    starfish.removeTexture();

                   userPoints++;
//                    System.out.println("points user: " + userPoints);
//
//                    System.out.println("points to win: " + winPoints);
                }
            }

        }
    }
}

int userPoints=0;
    private void generateStars(){
        Action spin ;

        int minX =0;
        int maxX = screenWidth;

        int minY= 0;
        int maxY = screenHeight ;
        int randomInt ;
        boolean loop;

        int loopCount=0;

        int starFishNumber=10;
        int x=0,y=0;
float width,height;
        for (int i = 0; i < starFishNumber; i++) {

            StarFish starFish=new StarFish(0,0); // Create a new StarFish object in each iteration
width=starFish.getWidth()*1.2f;
height=starFish.getHeight()*1.2f;
            do {

                loopCount++;
                randomInt = minX + (int) (Math.random() * (maxX - minX));

                // Calculate random x and y positions
                 x = 0 + randomInt;

                randomInt = minY + (int) (Math.random() * (maxY - minY));

                 y = 0 + randomInt;

                // Ensure the starfish stays within the screen boundaries
                if (x < 0) {
                    x = 0;
                } else if (x > screenWidth -width) {
                    x = screenWidth - (int) width;
                }

                if (y < 0) {
                    y = 0;
                } else if (y > screenHeight - height) {
                    y = screenHeight - (int) height;
                }

                starFish = new StarFish(x, y);
//                stage.addActor(starFish);
                //scale it down
//                float factor=0.4f;
                starFish.setBounds(x,y,width,height);
                //starFish.setOrigin(starFish.getWidth()/2,starFish.getHeight()/2);//take the origin of the modified size starfish
//                starFish.updateOrigin();
                if(isStarPlace(starFish)==false|| isStarPlayerCollide(starFish,player)) {//not accurate isStarPlayerCollide(starFish,player) at all need fixes
                    loop=true;
                    starFish.remove();

                }else {
                    loop=false;
                }

            }while(loop);

            stage.addActor(starFish);
            //scale it down
//            float factor=0.4f;
            starFish.setBounds(x,y,width,height);
            //starFish.setOrigin(starFish.getWidth()/2,starFish.getHeight()/2);//take the origin of the modified size starfish
            starFish.updateOrigin();
            starList.add(starFish);

            ///spining action for star
            randomInt = 4 + (int) (Math.random() * (8 - 4));

            int spinAmount=20 + (int) (Math.random() * (60 - 20));
            if(i%2==0)
                spin = Actions.rotateBy(spinAmount, randomInt);
            else{
                spin = Actions.rotateBy(-spinAmount, randomInt);
            }

            starList.get(i).addAction(Actions.forever(spin));

            winPoints++;
        }

        System.out.println("loop count" + loopCount);
    }
int winPoints=0;
    private  boolean isStarPlace(StarFish starFish){

        for (StarFish fish : starList) {
            if (starFish.overlaps(fish)) {
                return false;
            }

        }

        return true;
    }

    private boolean isStarPlayerCollide(StarFish starFish, Player player){

        return player.overlaps(starFish);
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
        homeBtn.setPosition(0, screenHeight - homeBtn.getHeight());
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
