package com.opendream.minesweeper.mod;

public class Beginner implements GameMode {
    private static final int MINE_NUMBER = 10;
    private static final int WIDTH = 192;
    private static final int HEIGHT = 234;
    private static final int INDICATOR_POSITION_Y = 197;
    private static final int INDICATOR_POSITION_X = 11;
    private static final int TIMER_POSITION_X = 140;
    @Override
    public int getMineNumber() {
        return MINE_NUMBER;
    }

    @Override
    public int getWindowWidth() {
        return WIDTH;
    }

    @Override
    public int getWindowHeight() {
        return HEIGHT;
    }

    @Override
    public int getIndicatorPositionY() {
        return INDICATOR_POSITION_Y;
    }

    @Override
    public int getIndicatorPositionX() {
        return INDICATOR_POSITION_X;
    }

    @Override
    public int getTimerPositionX() {
        return TIMER_POSITION_X;
    }
}
