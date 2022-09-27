package com.opendream.minesweeper.screen;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.Minesweeper;

public class GameScreen implements Screen {

    private final Minesweeper game;
    private final OrthographicCamera camera;
    private final Texture background;
    private final Texture buttonTexture;
    private final Array<Rectangle> buttons;
    private final Texture indicatorTexture;
    private Vector3 touchPosition;

    public GameScreen(final Minesweeper game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 192, 234);
        background = new Texture(Gdx.files.internal("background.png"));
        buttonTexture = new Texture(Gdx.files.internal("button.png"));
        indicatorTexture = new Texture(Gdx.files.internal("indicator.png"));

        buttons = new Array<>();
        placeButtons();
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        game.getBatch().disableBlending();
        initRender();
        game.getBatch().end();

        if (Gdx.input.justTouched()) {
            touchPosition = camera.getPickRay(Gdx.input.getX(), Gdx.input.getY()).origin;

            for (Rectangle button: buttons) {
                if (button.overlaps(new Rectangle(touchPosition.x, touchPosition.y, 1, 1))) {
                    buttons.removeValue(button, true);
                }
            }
        }
    }

    private void placeButtons() {
        final Rectangle currentButton = new Rectangle();
        currentButton.height = 20;
        currentButton.width = 20;
        currentButton.x = 7;
        currentButton.y = 7;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                buttons.add(new Rectangle(currentButton));
                currentButton.x = currentButton.x + 20;
            }
            currentButton.x = 7;
            currentButton.y = currentButton.y + 20;
        }
    }

    private void initRender() {
        game.getBatch().draw(background, 0, 0);
        game.getBatch().draw(indicatorTexture, 11, 197);
        game.getBatch().draw(indicatorTexture, 24, 197);
        game.getBatch().draw(indicatorTexture, 37, 197);

        for (Rectangle currentButton : buttons) {
            game.getBatch().draw(buttonTexture, currentButton.x, currentButton.y);
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}