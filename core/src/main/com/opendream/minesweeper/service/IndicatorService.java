package com.opendream.minesweeper.service;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.opendream.minesweeper.indicator.EightOnIndicator;
import com.opendream.minesweeper.indicator.FiveOnIndicator;
import com.opendream.minesweeper.indicator.FourOnIndicator;
import com.opendream.minesweeper.indicator.IIndicator;
import com.opendream.minesweeper.indicator.NineOnIndicator;
import com.opendream.minesweeper.indicator.OneOnIndicator;
import com.opendream.minesweeper.indicator.SevenOnIndicator;
import com.opendream.minesweeper.indicator.SixOnIndicator;
import com.opendream.minesweeper.indicator.ThreeOnIndicator;
import com.opendream.minesweeper.indicator.TwoOnIndicator;
import com.opendream.minesweeper.indicator.ZeroOnIndicator;
import com.opendream.minesweeper.utils.Indicator;

public class IndicatorService {
    private final ObjectMap<Indicator, IIndicator> indicators;

    public IndicatorService(Texture bot,
                            Texture botLeft,
                            Texture botRight,
                            Texture mid,
                            Texture top,
                            Texture topLeft,
                            Texture topRight
    ) {
        final ZeroOnIndicator zero = new ZeroOnIndicator(top, topLeft, topRight, bot, botLeft, botRight);
        final OneOnIndicator one = new OneOnIndicator(topRight, botRight);
        final TwoOnIndicator two = new TwoOnIndicator(top, topRight, mid, botLeft, bot);
        final ThreeOnIndicator three = new ThreeOnIndicator(top, topRight, mid, botRight, bot);
        final FourOnIndicator four = new FourOnIndicator(topLeft, topRight, mid, botRight);
        final FiveOnIndicator five = new FiveOnIndicator(top, topLeft, mid, botRight, bot);
        final SixOnIndicator six = new SixOnIndicator(top, topLeft, botLeft, bot, botRight, mid);
        final SevenOnIndicator seven = new SevenOnIndicator(top, topRight, botRight);
        final EightOnIndicator eight = new EightOnIndicator(top, topLeft, topRight, bot, botLeft, botRight, mid);
        final NineOnIndicator nine = new NineOnIndicator(top, topLeft, topRight, mid, botRight, bot);

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
}
