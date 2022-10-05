package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class OneNumber implements INumber {
    private final Array<Texture> pack = new Array<>();
    private final Texture number;

    public OneNumber(Texture topRight,
                     Texture botRight,
                     Texture one) {
        this.pack.add(topRight);
        this.pack.add(botRight);
        this.number = one;
    }

    @Override
    public Number getNumber() {
        return Number.ONE;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }

    @Override
    public Texture getNumberTexture() {
        return number;
    }
}
