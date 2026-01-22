package tech.sud.gip.base;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ThreadUtils {
    private static final Handler sHandler = new Handler(Looper.getMainLooper());

    public static boolean checkUIThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static Handler getUIHandler() {
        return sHandler;
    }

    public static void postDelayedUITask(Runnable runnable, long j) {
        sHandler.postDelayed(runnable, j);
    }

    public static void postTask(Looper looper, Runnable runnable) {
        if (Looper.myLooper() != looper) {
            try {
                new Handler(looper).post(runnable);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        runnable.run();
    }

    public static void postUITask(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            sHandler.post(runnable);
        } else {
            runnable.run();
        }
    }
}
