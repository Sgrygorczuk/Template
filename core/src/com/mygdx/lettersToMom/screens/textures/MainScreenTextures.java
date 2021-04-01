package com.mygdx.lettersToMom.screens.textures;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MainScreenTextures {

    //============================================= Textures =======================================
    public Texture backgroundTexture;
    public Texture menuBackgroundTexture;   //Pop up menu to show menu buttons and Help screen
    public Texture letterTexture;
    public Texture rainDropTexture;
    public Texture stampTexture;

    public Texture backgroundBack;
    public Texture backgroundMid;
    public Texture backgroundFront;

    public TextureRegion[][] umbrellaSpriteSheet;

    public MainScreenTextures(){ showTextures(); }

    /**
     * Purpose: Sets up all of the textures
     */
    private void showTextures(){
        backgroundTexture = new Texture(Gdx.files.internal("UI/Background.png"));
        menuBackgroundTexture = new Texture(Gdx.files.internal("UI/Background.png"));
        letterTexture = new Texture(Gdx.files.internal("Sprites/Letter.png"));
        rainDropTexture = new Texture(Gdx.files.internal("Sprites/RainDrop.png"));
        stampTexture = new Texture(Gdx.files.internal("Sprites/Stamp.png"));

        backgroundBack = new Texture(Gdx.files.internal("Sprites/BackgroundBack.png"));
        backgroundMid = new Texture(Gdx.files.internal("Sprites/BackgroundMid.png"));
        backgroundFront = new Texture(Gdx.files.internal("Sprites/BackgroundFront.png"));

        Texture umbrellaTexturePath = new Texture(Gdx.files.internal("Sprites/UmbrellaMan.png"));
        umbrellaSpriteSheet = new TextureRegion(umbrellaTexturePath).split(
                umbrellaTexturePath.getWidth()/3, umbrellaTexturePath.getHeight());

    }

}
