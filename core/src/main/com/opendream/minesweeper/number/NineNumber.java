package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class NineNumber implements INumber {
    private final Array<Texture> pack = new Array<>();

    public NineNumber(Texture top,
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
    public Number getNumber() {
        return Number.NINE;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
