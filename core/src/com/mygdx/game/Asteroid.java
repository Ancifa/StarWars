package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by 1 on 31.05.2017.
 */
public class Asteroid {
    private static Texture texture;
    private Vector2 position;
    private int size;
    private float speed;
    private int health;
    private Rectangle rectangle;

    private int screenHeight = Gdx.graphics.getHeight();
    private int screenWidth = Gdx.graphics.getWidth();

    public Asteroid() {
        if(texture == null) {
            texture = new Texture("asteroid.png");
        }
        position = new Vector2((float) Math.random() * screenWidth + screenWidth,
                (float) Math.random() * screenHeight);
        speed = 5.0f +(float) Math.random() * 10.0f;
        rectangle = new Rectangle(position.x, position.y, 256, 256);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        position.x -= speed;
        if(position.x < -256) {
            recreate();
        }
        rectangle.x = position.x;
        rectangle.y = position.y;
    }

    private void recreate() {
        position.x = screenWidth + 256;
        position.y = (float) Math.random() * screenHeight;
        speed = 2.0f +(float) Math.random() * 6.0f;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}