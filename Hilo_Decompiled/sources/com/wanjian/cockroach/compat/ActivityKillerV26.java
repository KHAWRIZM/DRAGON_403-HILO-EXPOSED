package com.wanjian.cockroach.compat;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ActivityKillerV26 implements IActivityKiller {
    private void finish(IBinder iBinder) {
        Object invoke = ActivityManager.class.getDeclaredMethod("getService", null).invoke(null, null);
        Class<?> cls = invoke.getClass();
        Class<?> cls2 = Integer.TYPE;
        Method declaredMethod = cls.getDeclaredMethod("finishActivity", IBinder.class, cls2, Intent.class, cls2);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(invoke, iBinder, 0, null, 0);
    }

    private void finishSomeArgs(Message message) {
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField("arg1");
            declaredField.setAccessible(true);
            finish((IBinder) declaredField.get(obj));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.wanjian.cockroach.compat.IActivityKiller
    public void finishLaunchActivity(Message message) {
        try {
            Object obj = message.obj;
            Field declaredField = obj.getClass().getDeclaredField("token");
            declaredField.setAccessible(true);
            finish((IBinder) declaredField.get(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.wanjian.cockroach.compat.IActivityKiller
    public void finishPauseActivity(Message message) {
        finishSomeArgs(message);
    }

    @Override // com.wanjian.cockroach.compat.IActivityKiller
    public void finishResumeActivity(Message message) {
        finishSomeArgs(message);
    }

    @Override // com.wanjian.cockroach.compat.IActivityKiller
    public void finishStopActivity(Message message) {
        finishSomeArgs(message);
    }
}
