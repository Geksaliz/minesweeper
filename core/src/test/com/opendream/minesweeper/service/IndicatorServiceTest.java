package com.opendream.minesweeper.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static java.lang.String.format;

import com.badlogic.gdx.graphics.Texture;
import com.opendream.minesweeper.utils.Indicator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

class IndicatorServiceTest {
    private IndicatorService service;

    @BeforeEach
    void init() {
        Texture texture = Mockito.mock(Texture.class);
        service = new IndicatorService(texture, texture, texture, texture, texture, texture, texture);
    }

    @ParameterizedTest
    @CsvSource({
            "0,6",
            "1,2",
            "2,5",
            "3,5",
            "4,4",
            "5,5",
            "6,6",
            "7,3",
            "8,7",
            "9,6",
    })
    void getTexturesForDrawingNumbersSuccess(String input, int countTextures) {
        assertEquals(service.getTexturesForNumberDrawing(input).size, countTextures);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "10", "err"})
    void ofInvalidTest(String number) {
        assertThrows(IllegalArgumentException.class, () ->
                Indicator.of(number), format("Unsupported indicator number=%s", number));
    }
}