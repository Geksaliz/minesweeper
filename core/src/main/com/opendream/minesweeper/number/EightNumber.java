package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class EightNumber implements INumber {
    private final Array<Texture> pack = new Array<>();

    public EightNumber(Texture top,
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
    public Number getNumber() {
        return Number.EIGHT;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
