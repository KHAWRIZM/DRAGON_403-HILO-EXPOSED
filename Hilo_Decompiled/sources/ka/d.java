package ka;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f١٥٥٥٩a = new Handler(Looper.getMainLooper());

    public static void a(Object obj) {
        f١٥٥٥٩a.removeCallbacksAndMessages(obj);
    }

    public static void b(Runnable runnable, long j10) {
        f١٥٥٥٩a.postDelayed(runnable, j10);
    }

    public static void c(Runnable runnable, Object obj, long j10) {
        if (j10 < 0) {
            j10 = 0;
        }
        f١٥٥٥٩a.postAtTime(runnable, obj, SystemClock.uptimeMillis() + j10);
    }
}
