package com.opendream.minesweeper.indicator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.opendream.minesweeper.utils.Indicator;

public class IndicatorService {
    private static final Texture bot = new Texture(Gdx.files.internal("indicator/bot.png"));
    private static final Texture botLeft = new Texture(Gdx.files.internal("indicator/bot-left.png"));
    private static final Texture botRight = new Texture(Gdx.files.internal("indicator/bot-right.png"));
    private static final Texture mid = new Texture(Gdx.files.internal("indicator/mid.png"));
    private static final Texture top = new Texture(Gdx.files.internal("indicator/top.png"));
    private static final Texture topLeft = new Texture(Gdx.files.internal("indicator/top-left.png"));
    private static final Texture topRight = new Texture(Gdx.files.internal("indicator/top-right.png"));
    private static final ZeroOnIndicator zero = new ZeroOnIndicator(top, topLeft, topRight, bot, botLeft, botRight);
    private static final OneOnIndicator one = new OneOnIndicator(topRight, botRight);
    private static final TwoOnIndicator two = new TwoOnIndicator(top, topRight, mid, botLeft, bot);
    private static final ThreeOnIndicator three = new ThreeOnIndicator(top, topRight, mid, botRight, bot);
    private static final FourOnIndicator four = new FourOnIndicator(topLeft, topRight, mid, botRight);
    private static final FiveOnIndicator five = new FiveOnIndicator(top, topLeft, mid, botRight, bot);
    private static final SixOnIndicator six = new SixOnIndicator(top, topLeft, botLeft, bot, botRight, mid);
    private static final SevenOnIndicator seven = new SevenOnIndicator(top, topRight, botRight);
    private static final EightOnIndicator eight = new EightOnIndicator(top, topLeft, topRight, bot, botLeft, botRight, mid);
    private static final NineOnIndicator nine = new NineOnIndicator(top, topLeft, topRight, mid, botRight, bot);
    private final ObjectMap<Indicator, IIndicator> indicators;

    public IndicatorService() {
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

    public Array<Texture> getTexturesForDrawingNumbers(String number) {
        return indicators.get(Indicator.of(number)).getTexturePack();
    }
}
