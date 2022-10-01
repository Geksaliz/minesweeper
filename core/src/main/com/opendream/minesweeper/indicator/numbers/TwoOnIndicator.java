package com.opendream.minesweeper.indicator.numbers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public class TwoOnIndicator implements IIndicator {
    private final Array<Texture> pack = new Array<>();

    public TwoOnIndicator(Texture top,
                          Texture topRight,
                          Texture mid,
                          Texture botLeft,
                          Texture bot) {
        this.pack.add(top);
        this.pack.add(topRight);
        this.pack.add(mid);
        this.pack.add(botLeft);
        this.pack.add(bot);
    }

    @Override
    public Indicator getNumber() {
        return Indicator.TWO;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
