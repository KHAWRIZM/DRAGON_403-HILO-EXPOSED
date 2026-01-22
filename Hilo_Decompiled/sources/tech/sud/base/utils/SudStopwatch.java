package tech.sud.base.utils;

import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SudStopwatch {
    private long elapsedTime;
    private boolean isRunning;
    private long startTime;

    public long getElapsedTimeInMillis() {
        return this.elapsedTime;
    }

    public void reset() {
        this.isRunning = false;
        this.startTime = 0L;
        this.elapsedTime = 0L;
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.startTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }

    public void stop() {
        if (!this.isRunning) {
            return;
        }
        this.isRunning = false;
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        this.elapsedTime = (millis - this.startTime) + this.elapsedTime;
    }
}
