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
    private final ObjectMap<Indicator, IIndicator> indicators;

    public IndicatorService() {
        this.indicators = new ObjectMap<>();
        this.indicators.put(zero.getNumber(), zero);
    }

    public Array<Texture> getTexturePack(String number) {
        return indicators.get(Indicator.of(number)).getTexturePack();
    }
}
