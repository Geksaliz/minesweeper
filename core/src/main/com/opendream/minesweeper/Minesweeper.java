package com.opendream.minesweeper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.opendream.minesweeper.mod.Beginner;
import com.opendream.minesweeper.screen.GameScreen;

public class Minesweeper extends Game {

	private SpriteBatch batch;
	private BitmapFont font;

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() {
		return font;
	}

	public void create() {
		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		this.setScreen(new GameScreen(this, new Beginner()));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}
