package b;

import android.util.Log;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ISudLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements ISudLogger {

    /* renamed from: a, reason: collision with root package name */
    public int f٥٢٩٦a = 4;

    public final void log(int i10, String str, String str2) {
        ThreadUtils.checkUIThread();
        if (2 == i10 && this.f٥٢٩٦a <= 2) {
            Log.v(str, str2);
            return;
        }
        if (3 == i10 && this.f٥٢٩٦a <= 3) {
            Log.d(str, str2);
            return;
        }
        if (4 == i10 && this.f٥٢٩٦a <= 4) {
            Log.i(str, str2);
            return;
        }
        if (5 == i10 && this.f٥٢٩٦a <= 5) {
            Log.w(str, str2);
            return;
        }
        if (6 == i10 && this.f٥٢٩٦a <= 6) {
            Log.e(str, str2);
        } else {
            if (7 != i10 || this.f٥٢٩٦a > 7) {
                return;
            }
            Log.e(str, str2);
        }
    }

    public final void setLogLevel(int i10) {
        this.f٥٢٩٦a = i10;
    }

    public final void log(int i10, String str, String str2, Throwable th) {
        if (2 == i10 && this.f٥٢٩٦a <= 2) {
            Log.v(str, str2, th);
            return;
        }
        if (3 == i10 && this.f٥٢٩٦a <= 3) {
            Log.d(str, str2, th);
            return;
        }
        if (4 == i10 && this.f٥٢٩٦a <= 4) {
            Log.i(str, str2, th);
            return;
        }
        if (5 == i10 && this.f٥٢٩٦a <= 5) {
            Log.w(str, str2, th);
            return;
        }
        if (6 == i10 && this.f٥٢٩٦a <= 6) {
            Log.e(str, str2, th);
        } else {
            if (7 != i10 || this.f٥٢٩٦a > 7) {
                return;
            }
            Log.e(str, str2, th);
        }
    }
}
