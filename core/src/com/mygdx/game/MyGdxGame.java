package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.managers.MyAssetManager;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.SettingsScreen;

import com.mygdx.game.MainMenuMusic;


public class MyGdxGame extends Game {


	public MyAssetManager myAssetManager = new MyAssetManager();
	public Music music;

	@Override
	public void create () {



		this.setScreen(new MenuScreen(this));

		myAssetManager.addMusic();
		myAssetManager.manager.finishLoading();

		music = myAssetManager.manager.get(GameConstants.backgroundMusic, Music.class);

		music.setLooping(true);
		music.play();


	}

	public void gotoMenuScreen(){

     music.play();
		MenuScreen menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}

	public void gotoSettingsScreen(){
		music.pause();
		SettingsScreen settingsScreen = new SettingsScreen(this);
		setScreen(settingsScreen);
	}

	public void gotoGameScreen(){

		GameScreen gameScreen = new GameScreen(this);
		setScreen(gameScreen);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
