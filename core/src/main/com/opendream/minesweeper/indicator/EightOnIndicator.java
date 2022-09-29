package com.opendream.minesweeper.indicator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public class EightOnIndicator implements IIndicator {
    private final Array<Texture> pack = new Array<>();

    public EightOnIndicator(Texture top,
                            Texture topLeft,
                            Texture topRight,
                            Texture bot,
                            Texture botLeft,
                            Texture botRight,
                            Texture mid) {
        this.pack.add(top);
        this.pack.add(topLeft);
        this.pack.add(topRight);
        this.pack.add(bot);
        this.pack.add(botLeft);
        this.pack.add(botRight);
        this.pack.add(mid);
    }

    @Override
    public Indicator getNumber() {
        return Indicator.EIGHT;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
