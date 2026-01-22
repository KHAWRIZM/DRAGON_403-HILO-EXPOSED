package p9;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f١٦٩٨٣a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    private static Handler f١٦٩٨٤b = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        f١٦٩٨٣a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        f١٦٩٨٤b.post(runnable);
    }
}
