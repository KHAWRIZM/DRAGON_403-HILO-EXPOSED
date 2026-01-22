package q4;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.amazonaws.services.s3.internal.Constants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final int f١٧١٤٠a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٧١٤١b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f١٧١٤٢c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٧١٤٣d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        static final int f١٧١٤٤i;

        /* renamed from: a, reason: collision with root package name */
        final Context f١٧١٤٥a;

        /* renamed from: b, reason: collision with root package name */
        ActivityManager f١٧١٤٦b;

        /* renamed from: c, reason: collision with root package name */
        c f١٧١٤٧c;

        /* renamed from: e, reason: collision with root package name */
        float f١٧١٤٩e;

        /* renamed from: d, reason: collision with root package name */
        float f١٧١٤٨d = 2.0f;

        /* renamed from: f, reason: collision with root package name */
        float f١٧١٥٠f = 0.4f;

        /* renamed from: g, reason: collision with root package name */
        float f١٧١٥١g = 0.33f;

        /* renamed from: h, reason: collision with root package name */
        int f١٧١٥٢h = 4194304;

        static {
            int i10;
            if (Build.VERSION.SDK_INT < 26) {
                i10 = 4;
            } else {
                i10 = 1;
            }
            f١٧١٤٤i = i10;
        }

        public a(Context context) {
            this.f١٧١٤٩e = f١٧١٤٤i;
            this.f١٧١٤٥a = context;
            this.f١٧١٤٦b = (ActivityManager) context.getSystemService("activity");
            this.f١٧١٤٧c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.f١٧١٤٦b)) {
                this.f١٧١٤٩e = DownloadProgress.UNKNOWN_PROGRESS;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f١٧١٥٣a;

        b(DisplayMetrics displayMetrics) {
            this.f١٧١٥٣a = displayMetrics;
        }

        @Override // q4.i.c
        public int a() {
            return this.f١٧١٥٣a.heightPixels;
        }

        @Override // q4.i.c
        public int b() {
            return this.f١٧١٥٣a.widthPixels;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        int i10;
        boolean z10;
        this.f١٧١٤٢c = aVar.f١٧١٤٥a;
        if (e(aVar.f١٧١٤٦b)) {
            i10 = aVar.f١٧١٥٢h / 2;
        } else {
            i10 = aVar.f١٧١٥٢h;
        }
        this.f١٧١٤٣d = i10;
        int c10 = c(aVar.f١٧١٤٦b, aVar.f١٧١٥٠f, aVar.f١٧١٥١g);
        float b10 = aVar.f١٧١٤٧c.b() * aVar.f١٧١٤٧c.a() * 4;
        int round = Math.round(aVar.f١٧١٤٩e * b10);
        int round2 = Math.round(b10 * aVar.f١٧١٤٨d);
        int i11 = c10 - i10;
        int i12 = round2 + round;
        if (i12 <= i11) {
            this.f١٧١٤١b = round2;
            this.f١٧١٤٠a = round;
        } else {
            float f10 = i11;
            float f11 = aVar.f١٧١٤٩e;
            float f12 = aVar.f١٧١٤٨d;
            float f13 = f10 / (f11 + f12);
            this.f١٧١٤١b = Math.round(f12 * f13);
            this.f١٧١٤٠a = Math.round(f13 * aVar.f١٧١٤٩e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f١٧١٤١b));
            sb.append(", pool size: ");
            sb.append(f(this.f١٧١٤٠a));
            sb.append(", byte array size: ");
            sb.append(f(i10));
            sb.append(", memory class limited? ");
            if (i12 > c10) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            sb.append(", max size: ");
            sb.append(f(c10));
            sb.append(", memoryClass: ");
            sb.append(aVar.f١٧١٤٦b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f١٧١٤٦b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f10, float f11) {
        float memoryClass = activityManager.getMemoryClass() * Constants.MB;
        if (e(activityManager)) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i10) {
        return Formatter.formatFileSize(this.f١٧١٤٢c, i10);
    }

    public int a() {
        return this.f١٧١٤٣d;
    }

    public int b() {
        return this.f١٧١٤٠a;
    }

    public int d() {
        return this.f١٧١٤١b;
    }
}
