package com.opendream.minesweeper.indicator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.Indicator;

public class FourOnIndicator implements IIndicator {
    private final Array<Texture> pack = new Array<>();

    public FourOnIndicator(Texture topLeft,
                           Texture topRight,
                           Texture mid,
                           Texture botLeft) {
        this.pack.add(topLeft);
        this.pack.add(topRight);
        this.pack.add(mid);
        this.pack.add(botLeft);
    }

    @Override
    public Indicator getNumber() {
        return Indicator.FOUR;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
