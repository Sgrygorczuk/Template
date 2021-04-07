package com.mygdx.lettersToMom.objects.spriteObject;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class UmbrellaMan extends Person{

    public UmbrellaMan(float x, float y, TextureRegion[][] spriteSheet) {
        super(x, y, spriteSheet);
        umbrellaHitBox = new Circle(x + spriteSheet[0][0].getRegionWidth()/2f,
                y + spriteSheet[0][0].getRegionHeight() - spriteSheet[0][0].getRegionWidth()/2f,
                spriteSheet[0][0].getRegionWidth()/2f);
    }

    @Override
    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(umbrellaHitBox.x, umbrellaHitBox.y, umbrellaHitBox.radius);
        super.drawDebug(shapeRenderer);
    }

    public boolean isCollidingWithUmbrella(Rectangle other){
        Circle otherCircle = new Circle(other.x, other.y, other.width);
        return this.umbrellaHitBox.overlaps(otherCircle);
    }

    @Override
    public void update() {
        super.update();
        umbrellaHitBox.x = hitBox.x + hitBox.width/2f;
    }
}
