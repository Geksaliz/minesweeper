package com.opendream.minesweeper.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.OrderedMap;
import com.badlogic.gdx.utils.OrderedSet;
import com.badlogic.gdx.utils.Queue;
import com.opendream.minesweeper.Minesweeper;
import com.opendream.minesweeper.mod.GameMode;
import com.opendream.minesweeper.service.InitializationService;
import com.opendream.minesweeper.service.NumberService;
import com.opendream.minesweeper.utils.CustomTimer;

import java.util.HashSet;
import java.util.Set;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;
import static java.lang.String.format;

public class GameScreen extends ScreenAdapter {
    private static int mineNumber;
    private static boolean gameIsFail = false;
    private final Minesweeper game;
    private final OrthographicCamera camera;
    private final NumberService numberService;
    private final GameMode gameMode;
    private final CustomTimer timer;
    private final Texture background;
    private final Texture buttonTexture;
    private final Array<Rectangle> buttons;
    private final Rectangle smileButton;
    private final Texture flagTexture;
    private final Texture smileTexture;
    private final Texture loseTexture;
    private final OrderedMap<Rectangle, Texture> gameField;
    private final OrderedSet<Rectangle> buttonFields;
    private final OrderedSet<Rectangle> flagFields;
    private final OrderedSet<Rectangle> mines;
    private Set<Rectangle> setForRemove;
    private Queue<Rectangle> queueForRemove;

    public GameScreen(final Minesweeper game,
                      final GameMode gameMode) {
        this.game = game;
        this.gameMode = gameMode;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, gameMode.getWindowWidth(), gameMode.getWindowHeight());
        numberService = new NumberService(
                new Texture(Gdx.files.internal("indicator/bot.png")),
                new Texture(Gdx.files.internal("indicator/bot-left.png")),
                new Texture(Gdx.files.internal("indicator/bot-right.png")),
                new Texture(Gdx.files.internal("indicator/mid.png")),
                new Texture(Gdx.files.internal("indicator/top.png")),
                new Texture(Gdx.files.internal("indicator/top-left.png")),
                new Texture(Gdx.files.internal("indicator/top-right.png")),
                new Texture(Gdx.files.internal("number/one.png")),
                new Texture(Gdx.files.internal("number/two.png")),
                new Texture(Gdx.files.internal("number/three.png")),
                new Texture(Gdx.files.internal("number/four.png"))
        );
        mineNumber = gameMode.getMineNumber();
        timer = new CustomTimer();
        background = new Texture(Gdx.files.internal("background.png"));
        buttonTexture = new Texture(Gdx.files.internal("button.png"));
        flagTexture = new Texture(Gdx.files.internal("flag.png"));
        smileTexture = new Texture(Gdx.files.internal("smile/start.png"));
        loseTexture = new Texture(Gdx.files.internal("smile/lose.png"));

        this.buttons = new Array<>();
        this.buttonFields = new OrderedSet<>();
        // TODO: Use game mode to set position
        this.smileButton = new Rectangle(83, 197, 27, 27);
        placeButtons();
        final InitializationService initializationService = new InitializationService(
                new Texture(Gdx.files.internal("mine.png")),
                numberService,
                buttons,
                mineNumber
        );
        this.flagFields = new OrderedSet<>();
        this.gameField = new OrderedMap<>();
        gameField.putAll(initializationService.initField());
        this.mines = new OrderedSet<>();
        mines.addAll(initializationService.getMines());
    }

    @Override
    public void render(float delta) {
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        game.getBatch().begin();
        initRender();
        setIndicator(mineNumber, gameMode.getIndicatorPositionX(), gameMode.getIndicatorPositionY());
        setIndicator(timer.getTime(), gameMode.getTimerPositionX(), gameMode.getIndicatorPositionY());

        if (gameIsFail) {
            game.getBatch().draw(loseTexture, 83, 197);
        }

        game.getBatch().end();

        if (Gdx.input.justTouched()) {
            processClickToGameField();
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
        // TODO: use game mode
        game.getBatch().draw(smileTexture, 83, 197);

        for (Rectangle currentButton : buttons) {
            final Texture texture = gameField.get(currentButton);
            if (texture != null) {
                game.getBatch().draw(texture, currentButton.x, currentButton.y);
            }

            if (buttonFields.contains(currentButton)) {
                game.getBatch().draw(buttonTexture, currentButton.x, currentButton.y);
            }

            if (flagFields.contains(currentButton)) {
                game.getBatch().draw(flagTexture, currentButton.x, currentButton.y);
                setIndicator(mineNumber, gameMode.getIndicatorPositionX(), gameMode.getIndicatorPositionY());
            }
        }
    }

    private void setIndicator(int count, int x, int y) {
        final String[] numbers = prepareIndicator(count);
        for (String number : numbers) {
            setIndicator(numberService.getTexturesForNumberDrawing(number), x, y);
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

    private void processClickToGameField() {
        timer.start();
        final Vector3 touchPosition = camera.getPickRay(Gdx.input.getX(), Gdx.input.getY()).origin;

        if (smileButton.contains(touchPosition.x, touchPosition.y)) {
            gameIsFail = false;
            timer.stop();
            game.setScreen(new GameScreen(game, gameMode));
        }

        if (gameIsFail) return;

        for (Rectangle button : buttons) {
            if (button.overlaps(new Rectangle(touchPosition.x, touchPosition.y, 0, 0))) {
                processClickToButton(button);
            }
        }
    }

    private void processClickToButton(Rectangle button) {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            processLeftButtonClick(button);
        }

        if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            processRightButtonClick(button);
        }
    }

    private void processLeftButtonClick(Rectangle button) {
        if (!flagFields.contains(button)) {
            buttonFields.remove(button);
        }

        // Hit a mine
        if (mines.contains(button)) {
            timer.stop();
            gameIsFail = true;
            return;
        }

        if (!gameField.containsKey(button)) {
            openEmptyCells(button);
        }
    }

    private void processRightButtonClick(Rectangle button) {
        if (flagFields.contains(button)) {
            flagFields.remove(button);
            mineNumber++;
        } else if (mineNumber != 0 && buttonFields.contains(button)) {
            flagFields.add(button);
            mineNumber--;
        }
    }

    private void openEmptyCells(Rectangle button) {
        if (flagFields.contains(button)) {
            return;
        }

        setForRemove = new HashSet<>();
        setForRemove.add(button);

        queueForRemove = new Queue<>();
        addNeighboringCells(button);

        while (!queueForRemove.isEmpty()) {
            openCell(queueForRemove.first());
            queueForRemove.removeFirst();
        }

        setForRemove.stream()
                .filter(btn -> !flagFields.contains(btn))
                .forEach(buttonFields::remove);
    }

    private void openCell(Rectangle button) {
        if (flagFields.contains(button)) {
            return;
        }

        if (!gameField.containsKey(button)) {
            setForRemove.add(button);
            addNeighboringCells(button);
        }
    }

    private void addNeighboringCells(Rectangle button) {
        Array<Rectangle> listButtons = new Array<>();
        // TODO: describe constants
        if (button.getY() - 7 > 0) {
            listButtons.add(new Rectangle(button.getX(), button.getY() - button.getHeight(), button.getWidth(), button.getHeight()));
        }
        if (button.getY() + 10 + button.getHeight() < gameMode.getIndicatorPositionY()) {
            listButtons.add(new Rectangle(button.getX(), button.getY() + button.getHeight(), button.getWidth(), button.getHeight()));
        }
        if (button.getX() + 7 + button.getWidth() < gameMode.getWindowWidth()) {
            listButtons.add(new Rectangle(button.getX() + button.getWidth(), button.getY(), button.getWidth(), button.getHeight()));
        }
        if (button.getX() - 7 > 0) {
            listButtons.add(new Rectangle(button.getX() - button.getWidth(), button.getY(), button.getWidth(), button.getHeight()));
        }

        for (Rectangle btn : listButtons) {
            if (!setForRemove.contains(btn)) {
                queueForRemove.addLast(btn);
            }
        }
    }

    @Override
    public void dispose() {
        game.dispose();
    }
}
