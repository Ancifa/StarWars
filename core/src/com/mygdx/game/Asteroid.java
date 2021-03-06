package com.mygdx.game;

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
    private float size;
    private float speed;
    private float angle;
    private int health;
    private Rectangle rectangle;

    private int screenWidth = Background.SCREEN_WIDTH;
    private int screenHeight = Background.SCREEN_HEIGHT;

    public Asteroid() {
        if(texture == null) {
            texture = new Texture("asteroid.png");
        }
        position = new Vector2((float) Math.random() * screenWidth + screenWidth,
                (float) Math.random() * screenHeight);
        speed = 5.0f +(float) Math.random() * 5.0f;
        angle = (float) Math.random() * 360;
        size = 0.5f + (float) Math.random();
        health = 3;
        rectangle = new Rectangle(position.x, position.y, 256, 256);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, 128, 128, 256, 256,
                size, size, angle, 0, 0, 256, 256, false, false);
    }

    public void update() {
        position.x -= speed;
        angle += speed / 4;
        if(position.x < -256) {
            recreate();
        }
        rectangle.x = position.x;
        rectangle.y = position.y;
    }

    public boolean makeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            recreate();
            return true;
        }
        return false;
    }

    public void recreate() {
        position.x = screenWidth + 256;
        position.y = (float) Math.random() * (screenHeight + 256) - 256;
        speed = 5.0f +(float) Math.random() * 5.0f;
        angle = (float) Math.random() * 360;
        size = 0.5f + (float) Math.random();
        health = 3;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
