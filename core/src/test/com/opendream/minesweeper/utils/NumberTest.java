package com.opendream.minesweeper.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.lang.String.format;

import com.opendream.minesweeper.utils.enums.Number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    private static Object[][] dataProvider() {
        return new Object[][]{
                {"0", Number.ZERO},
                {"1", Number.ONE}
        };
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void ofValidTest(String number, Number indicator) {
        assertEquals(Number.of(number), indicator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "10", "err"})
    public void ofInvalidTest(String number) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                Number.of(number), format("Unsupported indicator number=%s", number));
    }
}