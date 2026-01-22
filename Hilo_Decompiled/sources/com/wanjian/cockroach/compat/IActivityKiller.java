package com.wanjian.cockroach.compat;

import android.os.Message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IActivityKiller {
    void finishLaunchActivity(Message message);

    void finishPauseActivity(Message message);

    void finishResumeActivity(Message message);

    void finishStopActivity(Message message);
}
