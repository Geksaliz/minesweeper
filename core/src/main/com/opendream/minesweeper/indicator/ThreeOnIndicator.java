package com.opendream.minesweeper.indicator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public class ThreeOnIndicator implements IIndicator {
    private final Array<Texture> pack = new Array<>();

    public ThreeOnIndicator(Texture top,
                            Texture topRight,
                            Texture mid,
                            Texture botRjght,
                            Texture bot) {
        this.pack.add(top);
        this.pack.add(topRight);
        this.pack.add(mid);
        this.pack.add(botRjght);
        this.pack.add(bot);
    }

    @Override
    public Indicator getNumber() {
        return Indicator.THREE;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
