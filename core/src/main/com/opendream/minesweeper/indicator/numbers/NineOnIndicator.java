package com.opendream.minesweeper.indicator.numbers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public class NineOnIndicator implements IIndicator {
    private final Array<Texture> pack = new Array<>();

    public NineOnIndicator(Texture top,
                           Texture topLeft,
                           Texture topRight,
                           Texture mid,
                           Texture botRight,
                           Texture bot) {
        this.pack.add(top);
        this.pack.add(topLeft);
        this.pack.add(topRight);
        this.pack.add(mid);
        this.pack.add(botRight);
        this.pack.add(bot);
    }

    @Override
    public Indicator getNumber() {
        return Indicator.NINE;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
