package com.opendream.minesweeper.indicator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public class SixOnIndicator implements IIndicator {
    private final Array<Texture> pack = new Array<>();

    public SixOnIndicator(Texture top,
                          Texture topLeft,
                          Texture botLeft,
                          Texture bot,
                          Texture botRight,
                          Texture mid) {
        this.pack.add(top);
        this.pack.add(topLeft);
        this.pack.add(botLeft);
        this.pack.add(bot);
        this.pack.add(botRight);
        this.pack.add(mid);
    }

    @Override
    public Indicator getNumber() {
        return Indicator.SIX;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
