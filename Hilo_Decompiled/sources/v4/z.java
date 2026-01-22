package v4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class z {

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f١٨٥٦٤e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f١٨٥٦٥f;

    /* renamed from: g, reason: collision with root package name */
    private static final File f١٨٥٦٦g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile z f١٨٥٦٧h;

    /* renamed from: b, reason: collision with root package name */
    private int f١٨٥٦٩b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٨٥٧٠c = true;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f١٨٥٧١d = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private final int f١٨٥٦٨a = 20000;

    static {
        boolean z10;
        int i10 = Build.VERSION.SDK_INT;
        boolean z11 = false;
        if (i10 < 29) {
            z10 = true;
        } else {
            z10 = false;
        }
        f١٨٥٦٤e = z10;
        if (i10 >= 28) {
            z11 = true;
        }
        f١٨٥٦٥f = z11;
        f١٨٥٦٦g = new File("/proc/self/fd");
    }

    z() {
    }

    private boolean a() {
        if (f١٨٥٦٤e && !this.f١٨٥٧١d.get()) {
            return true;
        }
        return false;
    }

    public static z b() {
        if (f١٨٥٦٧h == null) {
            synchronized (z.class) {
                try {
                    if (f١٨٥٦٧h == null) {
                        f١٨٥٦٧h = new z();
                    }
                } finally {
                }
            }
        }
        return f١٨٥٦٧h;
    }

    private int c() {
        if (e()) {
            return 500;
        }
        return this.f١٨٥٦٨a;
    }

    private synchronized boolean d() {
        try {
            boolean z10 = true;
            int i10 = this.f١٨٥٦٩b + 1;
            this.f١٨٥٦٩b = i10;
            if (i10 >= 50) {
                this.f١٨٥٦٩b = 0;
                int length = f١٨٥٦٦g.list().length;
                long c10 = c();
                if (length >= c10) {
                    z10 = false;
                }
                this.f١٨٥٧٠c = z10;
                if (!z10 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + c10);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f١٨٥٧٠c;
    }

    private static boolean e() {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i10, int i11, boolean z10, boolean z11) {
        if (!z10) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!f١٨٥٦٥f) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z11) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i10 >= 0 && i11 >= 0) {
            if (!d()) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                }
                return false;
            }
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        Bitmap.Config config;
        boolean f10 = f(i10, i11, z10, z11);
        if (f10) {
            config = Bitmap.Config.HARDWARE;
            options.inPreferredConfig = config;
            options.inMutable = false;
        }
        return f10;
    }

    public void h() {
        f5.l.b();
        this.f١٨٥٧١d.set(true);
    }
}
