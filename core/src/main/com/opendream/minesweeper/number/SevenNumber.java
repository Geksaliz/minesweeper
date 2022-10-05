package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class SevenNumber implements INumber {
    private final Array<Texture> pack = new Array<>();

    public SevenNumber(Texture top,
                       Texture topRight,
                       Texture botRight) {
        this.pack.add(top);
        this.pack.add(topRight);
        this.pack.add(botRight);
    }

    @Override
    public Number getNumber() {
        return Number.SEVEN;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
