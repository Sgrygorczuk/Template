package com.mygdx.templet;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;

public class Templet extends Game {

	private final AssetManager assetManager = new AssetManager();	//Holds the UI images and sound files

	/*
	Input: Boolean tells us if the game is started from Android or PC
	Output: Void
	Purpose: Tells the game what controls/information it should provide
	*/
	public Templet(){}

	/*
	Input: Void
	Output: Asset Manager
	Purpose: Returns asset manager with all its data
	*/
	AssetManager getAssetManager() { return assetManager; }

	/*
	Input: Void
	Output: Void
	Purpose: Starts the app
	*/
	@Override
	public void create () { setScreen(new LoadingScreen(this)); }

}
