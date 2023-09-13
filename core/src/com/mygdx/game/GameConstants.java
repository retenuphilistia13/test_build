package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by Dewa on 2/18/2017.
 */

import com.badlogic.gdx.audio.Music;
public class GameConstants {
    public static final String skin = "skin/awesome_skin.json";
    public static final String skinAtlas = "skin/awesome_skin.atlas";

    public static final String backgroundMusic="Sounds/gambull_theme.ogg";

    public static final int screenWidth = Gdx.graphics.getWidth();
    public static final int screenHeight = Gdx.graphics.getHeight();
    public static final int centerX = screenWidth/2;
    public static final int centerY = screenHeight/2;
    public static final int col_width = screenWidth/8;
    public static final int row_height = screenHeight/8;
}
