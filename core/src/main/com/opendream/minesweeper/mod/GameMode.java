package com.opendream.minesweeper.mod;

public interface GameMode {
    int getMineNumber();
    int getWindowWidth();
    int getWindowHeight();
    int getIndicatorPositionY();
    int getIndicatorPositionX();
    int getTimerPositionX();
}
