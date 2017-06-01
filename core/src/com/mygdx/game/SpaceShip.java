package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by 1 on 28.05.2017.
 */
public class SpaceShip {
    private Texture texture;
    private Vector2 position;
    private float speed;
    private int health;

    private int screenWidth = Background.SCREEN_WIDTH;
    private int screenHeight = Background.SCREEN_HEIGHT;

    public SpaceShip() {
        texture = new Texture("spaceship4_100x71.png");
        position = new Vector2(100, 330);
        speed = 8.0f;
        health = 10;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP) && position.y <= screenHeight - texture.getHeight()) {
            position.y += speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && position.y >= 0) {
            position.y -= speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && position.y <= screenWidth - texture.getWidth()) {
            position.y += speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && position.y >= 0) {
            position.y -= speed;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            fire();
        }
    }

    public void fire() {
        for(Weapon weapon : MyGdxGame.weapons) {
            if(!weapon.isActive()) {
                weapon.setup(position.x, position.y);
                break;
            }
        }
    }
}
