package com.opendream.minesweeper.utils.enums;

import static java.lang.String.format;

import com.badlogic.gdx.utils.Array;

public enum Number {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9");

    private final String number;

    Number(String number) {
        this.number = number;
    }

    public static Number of(String number) {
        final Array<Number> indicators = new Array<>(Number.values());
        for (Number indicator : indicators) {
            if (indicator.number.equals(number)) {
                return indicator;
            }
        }

        throw new IllegalArgumentException(format("Unsupported number=%s", number));
    }
}
