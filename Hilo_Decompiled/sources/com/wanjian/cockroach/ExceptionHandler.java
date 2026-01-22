package com.wanjian.cockroach;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class ExceptionHandler {
    public final void bandageExceptionHappened(Throwable th) {
        try {
            onBandageExceptionHappened(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void enterSafeMode() {
        try {
            onEnterSafeMode();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void mayBeBlackScreen(Throwable th) {
        try {
            onMayBeBlackScreen(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public abstract void onBandageExceptionHappened(Throwable th);

    public abstract void onEnterSafeMode();

    public void onMayBeBlackScreen(Throwable th) {
    }

    public abstract void onUncaughtExceptionHappened(Thread thread, Throwable th);

    public final void uncaughtExceptionHappened(Thread thread, Throwable th) {
        try {
            onUncaughtExceptionHappened(thread, th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
