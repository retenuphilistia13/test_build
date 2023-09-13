package com.mygdx.game.managers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.GameConstants;

/**
 * Created by Dewa on 3/7/2017.
 */
public class MyAssetManager {
    public final AssetManager manager = new AssetManager();

    public void queueAddSkin(){
        SkinParameter parameter = new SkinParameter(GameConstants.skinAtlas);//assign skin Atlas
        manager.load(GameConstants.skin,Skin.class,parameter);

    }
    public void addMusic(){
        manager.load(GameConstants.backgroundMusic, Music.class);
    }
}