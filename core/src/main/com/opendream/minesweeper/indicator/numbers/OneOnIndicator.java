package com.opendream.minesweeper.indicator.numbers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public class OneOnIndicator implements IIndicator {
    private final Array<Texture> pack = new Array<>();

    public OneOnIndicator(Texture topRight,
                          Texture botRight) {
        this.pack.add(topRight);
        this.pack.add(botRight);
    }

    @Override
    public Indicator getNumber() {
        return Indicator.ONE;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
