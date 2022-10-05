package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class ZeroNumber implements INumber {
    private final Array<Texture> pack = new Array<>();

    public ZeroNumber(Texture top,
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
    public Number getNumber() {
        return Number.ZERO;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
