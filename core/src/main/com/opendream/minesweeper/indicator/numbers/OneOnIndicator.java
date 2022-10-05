package com.opendream.minesweeper.indicator.numbers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public class OneOnIndicator implements IIndicator {
    private final Array<Texture> pack = new Array<>();
    private final Texture number;

    public OneOnIndicator(Texture topRight,
                          Texture botRight,
                          Texture one) {
        this.pack.add(topRight);
        this.pack.add(botRight);
        this.number = one;
    }

    @Override
    public Indicator getNumber() {
        return Indicator.ONE;
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
