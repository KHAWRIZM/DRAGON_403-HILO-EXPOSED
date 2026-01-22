package x7;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.x;
import c8.b;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final int f١٨٩٦٩f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f١٨٩٧٠a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٨٩٧١b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٨٩٧٢c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٨٩٧٣d;

    /* renamed from: e, reason: collision with root package name */
    private final float f١٨٩٧٤e;

    public a(Context context) {
        this(b.b(context, R.attr.elevationOverlayEnabled, false), v7.a.b(context, R.attr.elevationOverlayColor, 0), v7.a.b(context, R.attr.elevationOverlayAccentColor, 0), v7.a.b(context, R.attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean f(int i10) {
        if (x.l(i10, KotlinVersion.MAX_COMPONENT_VALUE) == this.f١٨٩٧٣d) {
            return true;
        }
        return false;
    }

    public float a(float f10) {
        if (this.f١٨٩٧٤e <= DownloadProgress.UNKNOWN_PROGRESS || f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return Math.min(((((float) Math.log1p(f10 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i10, float f10) {
        int i11;
        float a10 = a(f10);
        int alpha = Color.alpha(i10);
        int k10 = v7.a.k(x.l(i10, KotlinVersion.MAX_COMPONENT_VALUE), this.f١٨٩٧١b, a10);
        if (a10 > DownloadProgress.UNKNOWN_PROGRESS && (i11 = this.f١٨٩٧٢c) != 0) {
            k10 = v7.a.j(k10, x.l(i11, f١٨٩٦٩f));
        }
        return x.l(k10, alpha);
    }

    public int c(int i10, float f10) {
        if (this.f١٨٩٧٠a && f(i10)) {
            return b(i10, f10);
        }
        return i10;
    }

    public int d(float f10) {
        return c(this.f١٨٩٧٣d, f10);
    }

    public boolean e() {
        return this.f١٨٩٧٠a;
    }

    public a(boolean z10, int i10, int i11, int i12, float f10) {
        this.f١٨٩٧٠a = z10;
        this.f١٨٩٧١b = i10;
        this.f١٨٩٧٢c = i11;
        this.f١٨٩٧٣d = i12;
        this.f١٨٩٧٤e = f10;
    }
}
