package com.opendream.minesweeper.number;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.opendream.minesweeper.utils.enums.Number;

public class ThreeNumber implements INumber {
    private final Array<Texture> pack = new Array<>();
    private final Texture number;

    public ThreeNumber(Texture top,
                       Texture topRight,
                       Texture mid,
                       Texture botRjght,
                       Texture bot,
                       Texture three
    ) {
        this.pack.add(top);
        this.pack.add(topRight);
        this.pack.add(mid);
        this.pack.add(botRjght);
        this.pack.add(bot);
        this.number = three;
    }

    @Override
    public Number getNumber() {
        return Number.THREE;
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
