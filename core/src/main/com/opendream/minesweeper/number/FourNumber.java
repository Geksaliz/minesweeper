package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class FourNumber implements INumber {
    private final Array<Texture> pack = new Array<>();

    public FourNumber(Texture topLeft,
                      Texture topRight,
                      Texture mid,
                      Texture botLeft) {
        this.pack.add(topLeft);
        this.pack.add(topRight);
        this.pack.add(mid);
        this.pack.add(botLeft);
    }

    @Override
    public Number getNumber() {
        return Number.FOUR;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }
}
