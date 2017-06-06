package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Background background;
	private SpaceShip spaceShip;
	private final int ASTEROIDS_COUNT = 10;
	private Asteroid[] asteroids;
	public final int WEAPONS_COUNT = 200;
	public static Weapon[] weapons;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		spaceShip = new SpaceShip();
		asteroids = new Asteroid[ASTEROIDS_COUNT];
		for(int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid();
		}
		weapons = new Weapon[WEAPONS_COUNT];
		for(int i = 0; i < weapons.length; i++) {
			weapons[i] = new Weapon();
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		spaceShip.render(batch);
		for(int i = 0; i < asteroids.length; i++) {
			asteroids[i].render(batch);
		}
		for(int i = 0; i < weapons.length; i++) {
			if(weapons[i].isActive()) {
				batch.draw(weapons[i].getTexture(),
						weapons[i].getPosition().x + 46, weapons[i].getPosition().y + 23);
			}
		}
		batch.end();
	}

	public void update() {
		background.update();
		spaceShip.update();
		for(int i = 0; i < asteroids.length; i++) {
			asteroids[i].update();
		}
		for(int i = 0; i < weapons.length; i++) {
			if (weapons[i].isActive()) {
				weapons[i].update();
				for (int j = 0; j < asteroids.length; j++) {
					if(asteroids[j].getRectangle().contains(weapons[i].getPosition())) {
						weapons[i].destroy();
						asteroids[j].makeDamage(1);
						break;
					}
				}
			}
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
