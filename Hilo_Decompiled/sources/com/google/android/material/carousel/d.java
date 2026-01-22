package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.R;
import com.google.android.material.carousel.e;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d {
    static float a(float f10, float f11, int i10) {
        return f10 + (Math.max(0, i10 - 1) * f11);
    }

    static float b(float f10, float f11, int i10) {
        return i10 > 0 ? f10 + (f11 / 2.0f) : f10;
    }

    static e c(Context context, float f10, int i10, a aVar) {
        float f11;
        float f12;
        float min = Math.min(f(context) + f10, aVar.f٨٦٥١f);
        float f13 = min / 2.0f;
        float f14 = DownloadProgress.UNKNOWN_PROGRESS - f13;
        float b10 = b(DownloadProgress.UNKNOWN_PROGRESS, aVar.f٨٦٤٧b, aVar.f٨٦٤٨c);
        float j10 = j(DownloadProgress.UNKNOWN_PROGRESS, a(b10, aVar.f٨٦٤٧b, (int) Math.floor(aVar.f٨٦٤٨c / 2.0f)), aVar.f٨٦٤٧b, aVar.f٨٦٤٨c);
        float b11 = b(j10, aVar.f٨٦٥٠e, aVar.f٨٦٤٩d);
        float j11 = j(j10, a(b11, aVar.f٨٦٥٠e, (int) Math.floor(aVar.f٨٦٤٩d / 2.0f)), aVar.f٨٦٥٠e, aVar.f٨٦٤٩d);
        float b12 = b(j11, aVar.f٨٦٥١f, aVar.f٨٦٥٢g);
        float j12 = j(j11, a(b12, aVar.f٨٦٥١f, aVar.f٨٦٥٢g), aVar.f٨٦٥١f, aVar.f٨٦٥٢g);
        float b13 = b(j12, aVar.f٨٦٥٠e, aVar.f٨٦٤٩d);
        float b14 = b(j(j12, a(b13, aVar.f٨٦٥٠e, (int) Math.ceil(aVar.f٨٦٤٩d / 2.0f)), aVar.f٨٦٥٠e, aVar.f٨٦٤٩d), aVar.f٨٦٤٧b, aVar.f٨٦٤٨c);
        float f15 = i10 + f13;
        float b15 = c.b(min, aVar.f٨٦٥١f, f10);
        float b16 = c.b(aVar.f٨٦٤٧b, aVar.f٨٦٥١f, f10);
        float b17 = c.b(aVar.f٨٦٥٠e, aVar.f٨٦٥١f, f10);
        e.b a10 = new e.b(aVar.f٨٦٥١f, i10).a(f14, b15, min);
        if (aVar.f٨٦٤٨c > 0) {
            f11 = b15;
            a10.g(b10, b16, aVar.f٨٦٤٧b, (int) Math.floor(r7 / 2.0f));
        } else {
            f11 = b15;
        }
        if (aVar.f٨٦٤٩d > 0) {
            a10.g(b11, b17, aVar.f٨٦٥٠e, (int) Math.floor(r4 / 2.0f));
        }
        a10.h(b12, DownloadProgress.UNKNOWN_PROGRESS, aVar.f٨٦٥١f, aVar.f٨٦٥٢g, true);
        if (aVar.f٨٦٤٩d > 0) {
            f12 = 2.0f;
            a10.g(b13, b17, aVar.f٨٦٥٠e, (int) Math.ceil(r4 / 2.0f));
        } else {
            f12 = 2.0f;
        }
        if (aVar.f٨٦٤٨c > 0) {
            a10.g(b14, b16, aVar.f٨٦٤٧b, (int) Math.ceil(r0 / f12));
        }
        a10.a(f15, f11, min);
        return a10.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e d(Context context, float f10, int i10, a aVar, int i11) {
        if (i11 == 1) {
            return c(context, f10, i10, aVar);
        }
        return e(context, f10, i10, aVar);
    }

    static e e(Context context, float f10, int i10, a aVar) {
        float min = Math.min(f(context) + f10, aVar.f٨٦٥١f);
        float f11 = min / 2.0f;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS - f11;
        float b10 = b(DownloadProgress.UNKNOWN_PROGRESS, aVar.f٨٦٥١f, aVar.f٨٦٥٢g);
        float j10 = j(DownloadProgress.UNKNOWN_PROGRESS, a(b10, aVar.f٨٦٥١f, aVar.f٨٦٥٢g), aVar.f٨٦٥١f, aVar.f٨٦٥٢g);
        float b11 = b(j10, aVar.f٨٦٥٠e, aVar.f٨٦٤٩d);
        float b12 = b(j(j10, b11, aVar.f٨٦٥٠e, aVar.f٨٦٤٩d), aVar.f٨٦٤٧b, aVar.f٨٦٤٨c);
        float f13 = i10 + f11;
        float b13 = c.b(min, aVar.f٨٦٥١f, f10);
        float b14 = c.b(aVar.f٨٦٤٧b, aVar.f٨٦٥١f, f10);
        float b15 = c.b(aVar.f٨٦٥٠e, aVar.f٨٦٥١f, f10);
        e.b h10 = new e.b(aVar.f٨٦٥١f, i10).a(f12, b13, min).h(b10, DownloadProgress.UNKNOWN_PROGRESS, aVar.f٨٦٥١f, aVar.f٨٦٥٢g, true);
        if (aVar.f٨٦٤٩d > 0) {
            h10.b(b11, b15, aVar.f٨٦٥٠e);
        }
        int i11 = aVar.f٨٦٤٨c;
        if (i11 > 0) {
            h10.g(b12, b14, aVar.f٨٦٤٧b, i11);
        }
        h10.a(f13, b13, min);
        return h10.i();
    }

    static float f(Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float g(Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float h(Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int[] iArr) {
        int i10 = Integer.MIN_VALUE;
        for (int i11 : iArr) {
            if (i11 > i10) {
                i10 = i11;
            }
        }
        return i10;
    }

    static float j(float f10, float f11, float f12, int i10) {
        return i10 > 0 ? f11 + (f12 / 2.0f) : f10;
    }
}
