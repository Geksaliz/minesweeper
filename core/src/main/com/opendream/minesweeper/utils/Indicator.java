package com.opendream.minesweeper.utils;

import static java.lang.String.format;

import com.badlogic.gdx.utils.Array;

public enum Indicator {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    TREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9");

    private final String number;

    Indicator(String number) {
        this.number = number;
    }

    public static Indicator of(String number) {
        final Array<Indicator> indicators = new Array<>(Indicator.values());
        for (Indicator indicator : indicators) {
            if (indicator.number.equals(number)) {
                return indicator;
            }
        }

        throw new IllegalArgumentException(format("Unsupported indicator number=%s", number));
    }
}
