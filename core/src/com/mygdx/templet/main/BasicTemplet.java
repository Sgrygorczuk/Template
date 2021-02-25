package com.mygdx.templet.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.templet.screens.LoadingScreen;

public class BasicTemplet extends Game {

	//Holds the UI images and sound files
	private final AssetManager assetManager = new AssetManager();

	/**
	 * Purpose: Tells the game what controls/information it should provide
	*/
	public BasicTemplet(){}

	/**
	 * 	Purpose: Returns asset manager with all its data
	 * 	Output: Asset Manager
	*/
	public AssetManager getAssetManager() { return assetManager; }

	/**
	Purpose: Starts the app
	*/
	@Override
	public void create () { setScreen(new LoadingScreen(this)); }

}
