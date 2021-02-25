package com.mygdx.templet.tools;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.templet.Const.WORLD_HEIGHT;
import static com.mygdx.templet.Const.WORLD_WIDTH;

public class TiledSetUp {

    //================================= Variables ==================================================
    SpriteBatch batch;
    Camera camera;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private float levelHeight;
    private float levelWidth;

    //====================================== Constructor ===========================================
    TiledSetUp(AssetManager tiledManager, SpriteBatch batch, Camera camera, String mapName){
        this.batch = batch;
        this.camera = camera;
        showTiled(tiledManager, mapName);
    }
    
    //========================================= Methods ============================================
    /**
     * Purpose: Collects that data necessary for drawing and extracting stuff from Tiled
     * @param tiledManager the asset manager we will pull the map from
     * @param mapName name of the map which we will refer to
     */
    private void showTiled(AssetManager tiledManager, String mapName){
        //Gets the map
        tiledMap = tiledManager.get(mapName);
        //Makes it into a drawing that we can call
        orthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, batch);
        //Center the drawing based on the camera
        orthogonalTiledMapRenderer.setView((OrthographicCamera) camera);

        //Uses to tell
        TiledMapTileLayer tiledMapTileLayer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
        levelHeight = tiledMapTileLayer.getHeight() * tiledMapTileLayer.getTileHeight();
        levelWidth = tiledMapTileLayer.getWidth() * tiledMapTileLayer.getTileWidth();
    }

    /**
     * Purpose: Scroll camera vertically
     * @param delta timing
     * @param speed at which camera moves
     */
    public void scrollCameraVertically(float delta, float speed) {
        if (camera.position.y + delta * speed + WORLD_HEIGHT < levelHeight) {
            camera.position.y += delta * speed;
            camera.position.set(camera.position.x, camera.position.y, camera.position.z);
            camera.update();
            orthogonalTiledMapRenderer.setView((OrthographicCamera) camera);
        }
    }

    /**
     * Purpose: Scroll camera horizontally
     * @param delta timing
     * @param speed at which camera moves
     */
    public void scrollCameraHorizontally(float delta, float speed) {
        if (camera.position.x + delta * speed + WORLD_HEIGHT < levelHeight) {
            camera.position.x += delta * speed;
            camera.position.set(camera.position.x, camera.position.y, camera.position.z);
            camera.update();
            orthogonalTiledMapRenderer.setView((OrthographicCamera) camera);
        }
    }

    /**
     * Purpose: Moves around the camera given the position
     * @param x coordinate
     * @param y coordinate
     */
    public void updateCameraPosition(float x, float y) {
        if((x > WORLD_WIDTH/2f) && (x < levelWidth - WORLD_WIDTH/2f)) {
            camera.position.set(x, camera.position.y, camera.position.z);
            camera.update();
            orthogonalTiledMapRenderer.setView((OrthographicCamera) camera);
        }

        if((y > WORLD_HEIGHT/2f) && (x < levelHeight - WORLD_HEIGHT/2f)) {
            camera.position.set(camera.position.x, y, camera.position.z);
            camera.update();
            orthogonalTiledMapRenderer.setView((OrthographicCamera) camera);
        }
    }

    /**
     * Purpose: Allow user to get coordinates of all the objects in that layer
     * @param layerName tells us the name of the layer we want to pull from
     * @return a Vector2 of coordinates
     */
    private Vector2[] getLayerCoordinates(String layerName) {
        //Grab the layer from tiled map
        MapLayer mapLayer = tiledMap.getLayers().get(layerName);
        Vector2[] coordinates = new Vector2[mapLayer.getObjects().getCount()];

        //Grabs the coordinates for each instance of that object in the map
        for (int i = 0; i < mapLayer.getObjects().getCount(); i++) {
            coordinates[i].x = mapLayer.getObjects().get(i).getProperties().get("x", Float.class);
            coordinates[i].y = mapLayer.getObjects().get(i).getProperties().get("y", Float.class);
        }
        return coordinates;
    }

    /**
     * Purpose: Draws the tiled map
     */
    private void drawTiledMap() {
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        orthogonalTiledMapRenderer.render();
    }

}
