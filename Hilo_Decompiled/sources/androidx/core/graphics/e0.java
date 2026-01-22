package androidx.core.graphics;

import android.graphics.PointF;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f٢٨٤٠a;

    /* renamed from: b, reason: collision with root package name */
    private final float f٢٨٤١b;

    /* renamed from: c, reason: collision with root package name */
    private final PointF f٢٨٤٢c;

    /* renamed from: d, reason: collision with root package name */
    private final float f٢٨٤٣d;

    public e0(PointF pointF, float f10, PointF pointF2, float f11) {
        this.f٢٨٤٠a = (PointF) androidx.core.util.h.h(pointF, "start == null");
        this.f٢٨٤١b = f10;
        this.f٢٨٤٢c = (PointF) androidx.core.util.h.h(pointF2, "end == null");
        this.f٢٨٤٣d = f11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (Float.compare(this.f٢٨٤١b, e0Var.f٢٨٤١b) == 0 && Float.compare(this.f٢٨٤٣d, e0Var.f٢٨٤٣d) == 0 && this.f٢٨٤٠a.equals(e0Var.f٢٨٤٠a) && this.f٢٨٤٢c.equals(e0Var.f٢٨٤٢c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = this.f٢٨٤٠a.hashCode() * 31;
        float f10 = this.f٢٨٤١b;
        int i11 = 0;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            i10 = Float.floatToIntBits(f10);
        } else {
            i10 = 0;
        }
        int hashCode2 = (((hashCode + i10) * 31) + this.f٢٨٤٢c.hashCode()) * 31;
        float f11 = this.f٢٨٤٣d;
        if (f11 != DownloadProgress.UNKNOWN_PROGRESS) {
            i11 = Float.floatToIntBits(f11);
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "PathSegment{start=" + this.f٢٨٤٠a + ", startFraction=" + this.f٢٨٤١b + ", end=" + this.f٢٨٤٢c + ", endFraction=" + this.f٢٨٤٣d + '}';
    }
}
