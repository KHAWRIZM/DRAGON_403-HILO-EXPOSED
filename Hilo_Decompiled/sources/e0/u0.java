package e0;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings;
import com.amazonaws.services.s3.internal.Constants;
import java.io.File;
import okio.ByteString;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class u0 {

    /* renamed from: a, reason: collision with root package name */
    public static final StringBuilder f١٣٨٣٥a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f١٣٨٣٦b = ByteString.encodeUtf8("RIFF");

    /* renamed from: c, reason: collision with root package name */
    public static final ByteString f١٣٨٣٧c = ByteString.encodeUtf8("WEBP");

    public static int a(Context context) {
        int memoryClass;
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        if ((context.getApplicationInfo().flags & Constants.MB) != 0) {
            memoryClass = activityManager.getLargeMemoryClass();
        } else {
            memoryClass = activityManager.getMemoryClass();
        }
        return (int) ((memoryClass * 1048576) / 7);
    }

    public static int b(Bitmap bitmap) {
        int allocationByteCount = bitmap.getAllocationByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static long c(File file) {
        long j10;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j10 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j10 = 5242880;
        }
        return Math.max(Math.min(j10, 20971520L), 5242880L);
    }

    public static void d() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        } else {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static boolean e(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 0) {
            return false;
        }
        return true;
    }
}
