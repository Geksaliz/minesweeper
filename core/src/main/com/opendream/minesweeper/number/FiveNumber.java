package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class FiveNumber implements INumber {
    private final Array<Texture> pack = new Array<>();

    public FiveNumber(Texture top,
                      Texture topLeft,
                      Texture mid,
                      Texture botRight,
                      Texture bot) {
        this.pack.add(top);
        this.pack.add(topLeft);
        this.pack.add(mid);
        this.pack.add(botRight);
        this.pack.add(bot);
    }

    @Override
    public Number getNumber() {
        return Number.FIVE;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
