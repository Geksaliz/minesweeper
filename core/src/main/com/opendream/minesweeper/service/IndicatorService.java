package com.opendream.minesweeper.service;

import static java.lang.String.valueOf;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.opendream.minesweeper.indicator.numbers.EightOnIndicator;
import com.opendream.minesweeper.indicator.numbers.FiveOnIndicator;
import com.opendream.minesweeper.indicator.numbers.FourOnIndicator;
import com.opendream.minesweeper.indicator.numbers.IIndicator;
import com.opendream.minesweeper.indicator.numbers.NineOnIndicator;
import com.opendream.minesweeper.indicator.numbers.OneOnIndicator;
import com.opendream.minesweeper.indicator.numbers.SevenOnIndicator;
import com.opendream.minesweeper.indicator.numbers.SixOnIndicator;
import com.opendream.minesweeper.indicator.numbers.ThreeOnIndicator;
import com.opendream.minesweeper.indicator.numbers.TwoOnIndicator;
import com.opendream.minesweeper.indicator.numbers.ZeroOnIndicator;
import com.opendream.minesweeper.utils.Indicator;

public class IndicatorService {
    private final ObjectMap<Indicator, IIndicator> indicators;

    public IndicatorService(Texture bot,
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
        final IIndicator zero = new ZeroOnIndicator(top, topLeft, topRight, bot, botLeft, botRight);
        final IIndicator one = new OneOnIndicator(topRight, botRight, oneTexture);
        final IIndicator two = new TwoOnIndicator(top, topRight, mid, botLeft, bot, twoTexture);
        final IIndicator three = new ThreeOnIndicator(top, topRight, mid, botRight, bot, threeTexture);
        final IIndicator four = new FourOnIndicator(topLeft, topRight, mid, botRight);
        final IIndicator five = new FiveOnIndicator(top, topLeft, mid, botRight, bot);
        final IIndicator six = new SixOnIndicator(top, topLeft, botLeft, bot, botRight, mid);
        final IIndicator seven = new SevenOnIndicator(top, topRight, botRight);
        final IIndicator eight = new EightOnIndicator(top, topLeft, topRight, bot, botLeft, botRight, mid);
        final IIndicator nine = new NineOnIndicator(top, topLeft, topRight, mid, botRight, bot);

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
        return indicators.get(Indicator.of(number)).getTexturePack();
    }

    public Texture getNumberTexture(int number) {
        return indicators.get(Indicator.of(valueOf(number))).getNumberTexture();
    }
}
