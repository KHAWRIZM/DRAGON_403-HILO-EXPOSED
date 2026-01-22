package com.wanjian.cockroach;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.wanjian.cockroach.compat.ActivityKillerV21_V23;
import com.wanjian.cockroach.compat.ActivityKillerV24_V25;
import com.wanjian.cockroach.compat.ActivityKillerV26;
import com.wanjian.cockroach.compat.ActivityKillerV28;
import com.wanjian.cockroach.compat.IActivityKiller;
import java.lang.Thread;
import java.lang.reflect.Field;
import reflection.Reflection;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class Cockroach {
    private static IActivityKiller sActivityKiller;
    private static ExceptionHandler sExceptionHandler;
    private static boolean sInstalled;
    private static boolean sIsSafeMode;

    private Cockroach() {
    }

    private static void hookmH() {
        Class<?> cls = Class.forName("android.app.ActivityThread");
        Object invoke = cls.getDeclaredMethod("currentActivityThread", null).invoke(null, null);
        Field declaredField = cls.getDeclaredField("mH");
        declaredField.setAccessible(true);
        final Handler handler = (Handler) declaredField.get(invoke);
        Field declaredField2 = Handler.class.getDeclaredField("mCallback");
        declaredField2.setAccessible(true);
        declaredField2.set(handler, new Handler.Callback() { // from class: com.wanjian.cockroach.Cockroach.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (message.what != 159) {
                        return false;
                    }
                    try {
                        handler.handleMessage(message);
                    } catch (Throwable th) {
                        Cockroach.sActivityKiller.finishLaunchActivity(message);
                        Cockroach.notifyException(th);
                    }
                    return true;
                }
                int i = message.what;
                if (i != 104) {
                    if (i != 107) {
                        if (i != 109) {
                            switch (i) {
                                case 100:
                                    try {
                                        handler.handleMessage(message);
                                    } catch (Throwable th2) {
                                        Cockroach.sActivityKiller.finishLaunchActivity(message);
                                        Cockroach.notifyException(th2);
                                    }
                                    return true;
                                case 101:
                                    try {
                                        handler.handleMessage(message);
                                    } catch (Throwable th3) {
                                        Cockroach.sActivityKiller.finishPauseActivity(message);
                                        Cockroach.notifyException(th3);
                                    }
                                    return true;
                                case 102:
                                    try {
                                        handler.handleMessage(message);
                                    } catch (Throwable th4) {
                                        Cockroach.sActivityKiller.finishPauseActivity(message);
                                        Cockroach.notifyException(th4);
                                    }
                                    return true;
                                default:
                                    return false;
                            }
                        }
                        try {
                            handler.handleMessage(message);
                        } catch (Throwable th5) {
                            Cockroach.notifyException(th5);
                        }
                        return true;
                    }
                    try {
                        handler.handleMessage(message);
                    } catch (Throwable th6) {
                        Cockroach.sActivityKiller.finishResumeActivity(message);
                        Cockroach.notifyException(th6);
                    }
                    return true;
                }
                try {
                    handler.handleMessage(message);
                } catch (Throwable th7) {
                    Cockroach.sActivityKiller.finishStopActivity(message);
                    Cockroach.notifyException(th7);
                }
                return true;
            }
        });
    }

    private static void initActivityKiller() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            sActivityKiller = new ActivityKillerV28();
        } else if (i >= 26) {
            sActivityKiller = new ActivityKillerV26();
        } else if (i != 25 && i != 24) {
            if (i <= 23) {
                sActivityKiller = new ActivityKillerV21_V23();
            }
        } else {
            sActivityKiller = new ActivityKillerV24_V25();
        }
        try {
            hookmH();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void install(Context context, ExceptionHandler exceptionHandler) {
        if (sInstalled) {
            return;
        }
        try {
            Reflection.unseal(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        sInstalled = true;
        sExceptionHandler = exceptionHandler;
        initActivityKiller();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.wanjian.cockroach.Cockroach.1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th2) {
                ExceptionHandler exceptionHandler2 = Cockroach.sExceptionHandler;
                if (exceptionHandler2 != null) {
                    exceptionHandler2.uncaughtExceptionHappened(thread, th2);
                }
                if (thread == Looper.getMainLooper().getThread()) {
                    Cockroach.isChoreographerException(th2);
                    Cockroach.safeMode();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isChoreographerException(Throwable th) {
        StackTraceElement[] stackTrace;
        if (th == null || sExceptionHandler == null || (stackTrace = th.getStackTrace()) == null) {
            return;
        }
        int length = stackTrace.length;
        while (true) {
            length--;
            if (length <= -1 || stackTrace.length - length > 20) {
                return;
            }
            StackTraceElement stackTraceElement = stackTrace[length];
            if ("android.view.Choreographer".equals(stackTraceElement.getClassName()) && "Choreographer.java".equals(stackTraceElement.getFileName()) && "doFrame".equals(stackTraceElement.getMethodName())) {
                sExceptionHandler.mayBeBlackScreen(th);
                return;
            }
        }
    }

    public static boolean isSafeMode() {
        return sIsSafeMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyException(Throwable th) {
        if (sExceptionHandler == null) {
            return;
        }
        if (isSafeMode()) {
            sExceptionHandler.bandageExceptionHappened(th);
        } else {
            sExceptionHandler.uncaughtExceptionHappened(Looper.getMainLooper().getThread(), th);
            safeMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void safeMode() {
        sIsSafeMode = true;
        ExceptionHandler exceptionHandler = sExceptionHandler;
        if (exceptionHandler != null) {
            exceptionHandler.enterSafeMode();
        }
        while (true) {
            try {
                Looper.loop();
            } catch (Throwable th) {
                isChoreographerException(th);
                if (sExceptionHandler != null) {
                    sExceptionHandler.bandageExceptionHappened(th);
                }
            }
        }
    }
}
