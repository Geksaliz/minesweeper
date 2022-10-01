package com.opendream.minesweeper.indicator.numbers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public interface IIndicator {
    Indicator getNumber();
    Array<Texture> getTexturePack();
}
