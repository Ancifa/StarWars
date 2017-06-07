package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by 1 on 31.05.2017.
 */
public class Weapon {
    private int power;
    private float speed;
    private Vector2 position;
    private boolean active;
    private WeaponType type;
    private Texture texture;

    public Weapon() {
        this(WeaponType.ROCKET);
    }

    public Weapon(WeaponType type) {
        position = new Vector2(0, 0);
        active = false;
        switch (type) {
            case ROCKET:
                texture = new Texture("missile2.png");
                power = 10;
                speed = 10.0f;
                break;
            case MISSILE:
                texture = new Texture("missile.png");
                power = 20;
                speed = 20.0f;
                break;
        }
    }

    public void setup(float x, float y) {
        position.x = x;
        position.y = y;
        active = true;
    }

    public void destroy() {
        active = false;
    }

    public void update() {
        position.x += speed;
        if(position.x > Background.SCREEN_WIDTH) {
            destroy();
        }
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector2 getPosition() {
        return position;
    }

    public boolean isActive() {
        return active;
    }
}
