package com.facebook.rebound;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SteppingLooper extends SpringLooper {
    private long mLastTime;
    private boolean mStarted;

    @Override // com.facebook.rebound.SpringLooper
    public void start() {
        this.mStarted = true;
        this.mLastTime = 0L;
    }

    public boolean step(long j10) {
        BaseSpringSystem baseSpringSystem = this.mSpringSystem;
        if (baseSpringSystem != null && this.mStarted) {
            long j11 = this.mLastTime + j10;
            baseSpringSystem.loop(j11);
            this.mLastTime = j11;
            return this.mSpringSystem.getIsIdle();
        }
        return false;
    }

    @Override // com.facebook.rebound.SpringLooper
    public void stop() {
        this.mStarted = false;
    }
}
