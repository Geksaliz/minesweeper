package com.opendream.minesweeper.utils;

import com.badlogic.gdx.utils.Timer;

public class CustomTimer {
    private static int second = 0;
    private static boolean isStarted = false;
    private final Timer timer;

    public CustomTimer() {
        timer = Timer.instance();
    }

    public boolean isStarted() {
        return isStarted;
    }

    public int getTime() {
        return second;
    }

    public void start() {
        second = 0;
        timer.scheduleTask(new CustomTask(), 1, 1);
        isStarted = true;
    }

    public void stop() {
        timer.stop();
        isStarted = false;
    }

    private static class CustomTask extends Timer.Task {
        @Override
        public void run() {
            second++;
        }
    }
}
