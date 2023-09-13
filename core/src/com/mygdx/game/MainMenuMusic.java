package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MainMenuMusic {

  public  Music mainMusic;

public void setMp3(int a){//not important

    switch(a){
        case 1:

            mainMusic = Gdx.audio.newMusic(Gdx.files.internal(GameConstants.backgroundMusic));
            break;

        default:
            mainMusic = Gdx.audio.newMusic(Gdx.files.internal(GameConstants.backgroundMusic));
            break;
    }

}

public void playMp3(){
    mainMusic.setLooping(true);
    mainMusic.setVolume(0.5f);
    mainMusic.play();
}

    public void stopMp3(){
        mainMusic.setLooping(false);
        //mp3Sound.setVolume(0.5f);
        mainMusic.stop();
    }


    public void pauseMp3(){
        mainMusic.pause();
    }
}
