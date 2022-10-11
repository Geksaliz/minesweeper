package com.opendream.minesweeper.service;

import static com.badlogic.gdx.math.MathUtils.random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.OrderedMap;
import com.badlogic.gdx.utils.OrderedSet;

public class InitializationService {
    private final NumberService numberService;
    private final Texture mine;
    private final Array<Rectangle> buttons;
    private static final OrderedSet<Rectangle> mines = new OrderedSet<>();
    private int mineNumber;

    public InitializationService(Texture mine,
                                 NumberService numberService,
                                 Array<Rectangle> buttons,
                                 int mineNumber) {
        this.mine = mine;
        this.numberService = numberService;
        this.buttons = buttons;
        this.mineNumber = mineNumber;
    }

    public ObjectMap<Rectangle, Texture> initField() {
        final OrderedMap<Rectangle, Texture> field = new OrderedMap<>();
        final int[][] coordinate = new int[9][9];
        final ObjectSet<Integer> mineCoordinates = new ObjectSet<>(10);

        while (mineNumber > 0) {
            if (mineCoordinates.add(random(80))) {
                mineNumber--;
            }
        }

        for (int mine : mineCoordinates) {
            int i = 0;
            while (mine >= 9) {
                i++;
                mine = mine - 9;
            }
            coordinate[i][mine] = 99;
        }

        int i = 0;
        for (int[] row : coordinate) {
            int j = 0;
            for (int cellValue : row) {
                if (cellValue > 50) {
                    if (j != 0) {
                        coordinate[i][j - 1] += 1;
                    }
                    if (j != 8) {
                        coordinate[i][j + 1] += 1;
                    }
                    if (i != 0) {
                        coordinate[i - 1][j] += 1;
                        if (j != 0) {
                            coordinate[i - 1][j - 1] += 1;
                        }
                        if (j != 8) {
                            coordinate[i - 1][j + 1] += 1;
                        }
                    }
                    if (i != 8) {
                        coordinate[i + 1][j] += 1;
                        if (j != 0) {
                            coordinate[i + 1][j - 1] += 1;
                        }
                        if (j != 8) {
                            coordinate[i + 1][j + 1] += 1;
                        }
                    }
                }
                j++;
            }
            i++;
        }

        int x = 0;
        int y = 0;
        for (Rectangle button : buttons) {
            if (coordinate[x][y] == 0) {
                x++;
                if (x > 8) {
                    y++;
                    x = 0;
                }
                continue;
            }

            if (coordinate[x][y] > 50) {
                field.put(button, mine);
                mines.add(button);
            } else {
                System.out.println(coordinate[x][y]);
                field.put(button, numberService.getNumberTexture(coordinate[x][y]));
            }

            x++;
            if (x > 8) {
                y++;
                x = 0;
            }
        }

        return field;
    }

    public OrderedSet<Rectangle> getMines() {
        return mines;
    }
}
