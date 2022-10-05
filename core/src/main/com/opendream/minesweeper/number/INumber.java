package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public interface INumber {
    Number getNumber();
    Array<Texture> getTexturePack();
    default Texture getNumberTexture() {
        throw new IllegalArgumentException("Number texture not found");
    }
}
