package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class TwoNumber implements INumber {
    private final Array<Texture> pack = new Array<>();
    private final Texture number;

    public TwoNumber(Texture top,
                     Texture topRight,
                     Texture mid,
                     Texture botLeft,
                     Texture bot,
                     Texture two
    ) {
        this.pack.add(top);
        this.pack.add(topRight);
        this.pack.add(mid);
        this.pack.add(botLeft);
        this.pack.add(bot);
        this.number = two;
    }

    @Override
    public Number getNumber() {
        return Number.TWO;
    }

    @Override
    public Array<Texture> getTexturePack() {
        return pack;
    }

    @Override
    public Texture getNumberTexture() {
        return number;
    }
}
