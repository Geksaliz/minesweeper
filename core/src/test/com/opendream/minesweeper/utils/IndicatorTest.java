package com.opendream.minesweeper.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static java.lang.String.format;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class IndicatorTest {

    private static Object[][] dataProvider() {
        return new Object[][]{
                {"0", Indicator.ZERO},
                {"1", Indicator.ONE}
        };
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void ofValidTest(String number, Indicator indicator) {
        assertEquals(Indicator.of(number), indicator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "10", "err"})
    public void ofInvalidTest(String number) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                Indicator.of(number), format("Unsupported indicator number=%s", number));
    }
}