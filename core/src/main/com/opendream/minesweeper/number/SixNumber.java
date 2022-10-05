package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class SixNumber implements INumber {
    private final Array<Texture> pack = new Array<>();

    public SixNumber(Texture top,
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
    public Number getNumber() {
        return Number.SIX;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
