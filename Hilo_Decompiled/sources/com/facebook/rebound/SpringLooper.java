package com.facebook.rebound;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class SpringLooper {
    protected BaseSpringSystem mSpringSystem;

    public void setSpringSystem(BaseSpringSystem baseSpringSystem) {
        this.mSpringSystem = baseSpringSystem;
    }

    public abstract void start();

    public abstract void stop();
}
