package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import sun.plugin2.main.server.ServerPrintHelper;

/**
 * Created by 1 on 31.05.2017.
 */
public class Weapon {
    private int power;
    private float speed;
    private Vector2 position;
    private WeaponType type;
    private Texture texture;

    public Weapon() {
        this(WeaponType.ROCKET);
    }

    public Weapon(WeaponType type) {
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

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {

    }
}
