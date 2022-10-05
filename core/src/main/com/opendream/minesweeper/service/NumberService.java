package com.opendream.minesweeper.service;

import static java.lang.String.valueOf;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.opendream.minesweeper.number.EightNumber;
import com.opendream.minesweeper.number.FiveNumber;
import com.opendream.minesweeper.number.FourNumber;
import com.opendream.minesweeper.number.INumber;
import com.opendream.minesweeper.number.NineNumber;
import com.opendream.minesweeper.number.OneNumber;
import com.opendream.minesweeper.number.SevenNumber;
import com.opendream.minesweeper.number.SixNumber;
import com.opendream.minesweeper.number.ThreeNumber;
import com.opendream.minesweeper.number.TwoNumber;
import com.opendream.minesweeper.number.ZeroNumber;
import com.opendream.minesweeper.utils.enums.Number;

public class NumberService {
    private final ObjectMap<Number, INumber> indicators;

    public NumberService(Texture bot,
                         Texture botLeft,
                         Texture botRight,
                         Texture mid,
                         Texture top,
                         Texture topLeft,
                         Texture topRight,
                         Texture oneTexture,
                         Texture twoTexture,
                         Texture threeTexture
    ) {
        final INumber zero = new ZeroNumber(top, topLeft, topRight, bot, botLeft, botRight);
        final INumber one = new OneNumber(topRight, botRight, oneTexture);
        final INumber two = new TwoNumber(top, topRight, mid, botLeft, bot, twoTexture);
        final INumber three = new ThreeNumber(top, topRight, mid, botRight, bot, threeTexture);
        final INumber four = new FourNumber(topLeft, topRight, mid, botRight);
        final INumber five = new FiveNumber(top, topLeft, mid, botRight, bot);
        final INumber six = new SixNumber(top, topLeft, botLeft, bot, botRight, mid);
        final INumber seven = new SevenNumber(top, topRight, botRight);
        final INumber eight = new EightNumber(top, topLeft, topRight, bot, botLeft, botRight, mid);
        final INumber nine = new NineNumber(top, topLeft, topRight, mid, botRight, bot);

        this.indicators = new ObjectMap<>();
        this.indicators.put(zero.getNumber(), zero);
        this.indicators.put(one.getNumber(), one);
        this.indicators.put(two.getNumber(), two);
        this.indicators.put(three.getNumber(), three);
        this.indicators.put(four.getNumber(), four);
        this.indicators.put(five.getNumber(), five);
        this.indicators.put(six.getNumber(), six);
        this.indicators.put(seven.getNumber(), seven);
        this.indicators.put(eight.getNumber(), eight);
        this.indicators.put(nine.getNumber(), nine);
    }

    public Array<Texture> getTexturesForNumberDrawing(String number) {
        return indicators.get(Number.of(number)).getTexturePack();
    }

    public Texture getNumberTexture(int number) {
        return indicators.get(Number.of(valueOf(number))).getNumberTexture();
    }
}
