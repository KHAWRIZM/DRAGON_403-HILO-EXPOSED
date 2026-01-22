package com.tencent.qcloud.tuicore.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BackgroundTasks {
    private static final BackgroundTasks instance = new BackgroundTasks();
    private final Handler handler = new Handler(Looper.getMainLooper());

    private BackgroundTasks() {
    }

    public static BackgroundTasks getInstance() {
        return instance;
    }

    public boolean postDelayed(Runnable runnable, long j) {
        return this.handler.postDelayed(runnable, j);
    }

    public void runOnUiThread(Runnable runnable) {
        this.handler.post(runnable);
    }
}
