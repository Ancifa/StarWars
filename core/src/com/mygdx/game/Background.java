package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by 1 on 28.05.2017.
 */
public class Background {

    public final static int SCREEN_WIDTH = Gdx.graphics.getWidth(); // 1280
    public final static int SCREEN_HEIGHT = Gdx.graphics.getHeight(); // 720

    class Star {
        private Vector2 position;
        private float speed;

        public Star() {
            position = new Vector2((float) Math.random() * SCREEN_WIDTH, (float) Math.random() * SCREEN_HEIGHT);
            speed = 2.0f + (float) Math.random() * 6.0f;
        }

        public void update() {
            position.x -= speed;
            if (position.x < 0) {
                position.x = SCREEN_WIDTH;
                position.y = (float) Math.random() * SCREEN_HEIGHT;
                speed = 2.0f + (float) Math.random() * 6.0f;
            }
        }
    }

    private Texture textureBg;
    private Texture textureStar;
    private final int STARS_COUNT = 200;
    private Star[] stars;

    public Background() {
        textureBg = new Texture("bg.png");
        textureStar = new Texture("star.png");
        stars = new Star[STARS_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureBg, 0, 0);
        for (int i = 0; i < stars.length; i++) {
            batch.draw(textureStar, stars[i].position.x, stars[i].position.y);
        }
    }

    public void update() {
        for (int i = 0; i < stars.length; i++) {
            stars[i].update();
        }
    }
}
