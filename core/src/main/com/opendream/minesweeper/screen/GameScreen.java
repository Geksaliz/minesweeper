package com.opendream.minesweeper.screen;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;
import static java.lang.String.format;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.OrderedMap;
import com.badlogic.gdx.utils.OrderedSet;
import com.opendream.minesweeper.Minesweeper;
import com.opendream.minesweeper.service.IndicatorService;
import com.opendream.minesweeper.service.InitializationService;

public class GameScreen implements Screen {
    private static int mineNumber = 10;
    private final Minesweeper game;
    private final OrthographicCamera camera;
    private final IndicatorService indicatorService;
    private final InitializationService initializationService;
    private final Texture background;
    private final Texture buttonTexture;
    private final Array<Rectangle> buttons;
    private final Texture backgroundIndicatorTexture;
    private final Texture flagTexture;
    private final OrderedMap<Rectangle, Texture> gameField = new OrderedMap<>();
    private final OrderedSet<Rectangle> buttonFields = new OrderedSet<>();
    private final OrderedSet<Rectangle> flagFields = new OrderedSet<>();

    private Vector3 touchPosition;

    public GameScreen(final Minesweeper game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 192, 234);
        indicatorService = new IndicatorService(
                new Texture(Gdx.files.internal("indicator/bot.png")),
                new Texture(Gdx.files.internal("indicator/bot-left.png")),
                new Texture(Gdx.files.internal("indicator/bot-right.png")),
                new Texture(Gdx.files.internal("indicator/mid.png")),
                new Texture(Gdx.files.internal("indicator/top.png")),
                new Texture(Gdx.files.internal("indicator/top-left.png")),
                new Texture(Gdx.files.internal("indicator/top-right.png")),
                new Texture(Gdx.files.internal("number/one.png")),
                new Texture(Gdx.files.internal("number/two.png")),
                new Texture(Gdx.files.internal("number/three.png"))
        );
        background = new Texture(Gdx.files.internal("background.png"));
        buttonTexture = new Texture(Gdx.files.internal("button.png"));
        backgroundIndicatorTexture = new Texture(Gdx.files.internal("indicator/background.jpg"));
        flagTexture = new Texture(Gdx.files.internal("flag.png"));

        buttons = new Array<>();
        placeButtons();
        initializationService = new InitializationService(
                new Texture(Gdx.files.internal("mine.png")),
                indicatorService,
                buttons,
                mineNumber
        );
        gameField.putAll(initializationService.initField());
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        initRender();
        setMineIndicators(mineNumber, 11, 197);
        game.getBatch().end();

        if (Gdx.input.justTouched()) {
            touchPosition = camera.getPickRay(Gdx.input.getX(), Gdx.input.getY()).origin;

            for (Rectangle button : buttons) {
                if (button.overlaps(new Rectangle(touchPosition.x, touchPosition.y, 0, 0))) {
                    if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                        if (!flagFields.contains(button)) {
                            buttonFields.remove(button);
                        }
                    }

                    if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
                        final Rectangle element = new Rectangle(button);
                        if (flagFields.contains(element)) {
                            flagFields.remove(element);
                            mineNumber++;
                        } else if (mineNumber != 0 && flagFields.add(element)) {
                            mineNumber--;
                        }
                    }
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
                final Rectangle element = new Rectangle(currentButton);
                buttons.add(element);
                buttonFields.add(element);
                currentButton.x = currentButton.x + 20;
            }
            currentButton.x = 7;
            currentButton.y = currentButton.y + 20;
        }
    }

    private void initRender() {
        game.getBatch().draw(background, 0, 0);
        game.getBatch().draw(backgroundIndicatorTexture, 11, 197);
        game.getBatch().draw(backgroundIndicatorTexture, 25, 197);
        game.getBatch().draw(backgroundIndicatorTexture, 39, 197);
        game.getBatch().draw(backgroundIndicatorTexture, 140, 197);
        game.getBatch().draw(backgroundIndicatorTexture, 154, 197);
        game.getBatch().draw(backgroundIndicatorTexture, 168, 197);

        for (Rectangle currentButton : buttons) {
            final Texture currentMine = gameField.get(currentButton);
            if (currentMine != null) {
                game.getBatch().draw(currentMine, currentButton.x, currentButton.y);
            }

            if (buttonFields.contains(currentButton)) {
                game.getBatch().draw(buttonTexture, currentButton.x, currentButton.y);
            }

            if (flagFields.contains(currentButton)) {
                game.getBatch().draw(flagTexture, currentButton.x, currentButton.y);
                setMineIndicators(mineNumber, 11, 197);
            }
        }
    }

    private void setMineIndicators(int count, int x, int y) {
        final String[] numbers = prepareIndicator(count);
        for (String number : numbers) {
            setIndicator(indicatorService.getTexturesForNumberDrawing(number), x, y);
            x += 14;
        }
    }

    private void setIndicator(Array<Texture> pack, int x, int y) {
        for (Texture texture : pack) {
            game.getBatch().draw(texture, x, y);
        }
    }

    private String[] prepareIndicator(int count) {
        final StringBuilder numbers = new StringBuilder(String.valueOf(count));
        if (numbers.length() > 3) {
            throw new IllegalArgumentException(format("Number indicator mast be less then 1000, current value=%s", count));
        }
        while (numbers.length() < 3) {
            numbers.insert(0, "0");
        }

        return numbers.toString().split("");
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