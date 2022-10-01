package com.opendream.minesweeper.indicator.numbers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public class ZeroOnIndicator implements IIndicator {
    private final Array<Texture> pack = new Array<>();

    public ZeroOnIndicator(Texture top,
                           Texture topLeft,
                           Texture topRight,
                           Texture bot,
                           Texture botLeft,
                           Texture botRight) {
        this.pack.add(top);
        this.pack.add(topLeft);
        this.pack.add(topRight);
        this.pack.add(bot);
        this.pack.add(botLeft);
        this.pack.add(botRight);
    }

    @Override
    public Indicator getNumber() {
        return Indicator.ZERO;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
