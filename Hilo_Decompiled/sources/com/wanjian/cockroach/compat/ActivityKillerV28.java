package com.wanjian.cockroach.compat;

import android.app.ActivityManager;
import android.app.servertransaction.ClientTransaction;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ActivityKillerV28 implements IActivityKiller {
    private void finish(IBinder iBinder) {
        Object invoke = ActivityManager.class.getDeclaredMethod("getService", null).invoke(null, null);
        Class<?> cls = invoke.getClass();
        Class<?> cls2 = Integer.TYPE;
        Method declaredMethod = cls.getDeclaredMethod("finishActivity", IBinder.class, cls2, Intent.class, cls2);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(invoke, iBinder, 0, null, 0);
    }

    private void tryFinish1(Message message) {
        finish(((ClientTransaction) message.obj).getActivityToken());
    }

    private void tryFinish2(Message message) {
        Object obj = message.obj;
        finish((IBinder) obj.getClass().getDeclaredMethod("getActivityToken", null).invoke(obj, null));
    }

    private void tryFinish3(Message message) {
        Object obj = message.obj;
        finish((IBinder) obj.getClass().getDeclaredField("mActivityToken").get(obj));
    }

    @Override // com.wanjian.cockroach.compat.IActivityKiller
    public void finishLaunchActivity(Message message) {
        try {
            tryFinish1(message);
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                tryFinish2(message);
            } catch (Throwable th2) {
                th2.printStackTrace();
                try {
                    tryFinish3(message);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    @Override // com.wanjian.cockroach.compat.IActivityKiller
    public void finishPauseActivity(Message message) {
    }

    @Override // com.wanjian.cockroach.compat.IActivityKiller
    public void finishResumeActivity(Message message) {
    }

    @Override // com.wanjian.cockroach.compat.IActivityKiller
    public void finishStopActivity(Message message) {
    }
}
