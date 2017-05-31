package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Background background;
	private SpaceShip spaceShip;
	private final int ASTEROISD_COUNT = 30;
	private Asteroid[] asteroids;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		spaceShip = new SpaceShip();
		asteroids = new Asteroid[ASTEROISD_COUNT];
		for(Asteroid asteroid: asteroids) {
			asteroid = new Asteroid();
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
		for(Asteroid asteroid : asteroids) {
			asteroid.render(batch);
		}
		batch.end();
	}

	public void update() {
		background.update();
		spaceShip.update();
		for(Asteroid asteroid : asteroids) {
			asteroid.update();
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
