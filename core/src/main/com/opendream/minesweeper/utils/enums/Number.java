package com.opendream.minesweeper.utils.enums;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

import com.badlogic.gdx.utils.Array;

import java.util.Optional;

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
        return find(number)
                .orElseThrow(() -> new IllegalArgumentException(format("Unsupported number=%s", number)));
    }

    public static Optional<Number> find(String number) {
        Number curNumber = null;
        for (Number indicator : new Array<>(Number.values())) {
            if (indicator.number.equals(number)) {
                curNumber = indicator;
            }
        }

        return ofNullable(curNumber);
    }
}
