package q3;

import android.graphics.PointF;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f١٧٠٨٧a;

    /* renamed from: b, reason: collision with root package name */
    public String f١٧٠٨٨b;

    /* renamed from: c, reason: collision with root package name */
    public float f١٧٠٨٩c;

    /* renamed from: d, reason: collision with root package name */
    public a f١٧٠٩٠d;

    /* renamed from: e, reason: collision with root package name */
    public int f١٧٠٩١e;

    /* renamed from: f, reason: collision with root package name */
    public float f١٧٠٩٢f;

    /* renamed from: g, reason: collision with root package name */
    public float f١٧٠٩٣g;

    /* renamed from: h, reason: collision with root package name */
    public int f١٧٠٩٤h;

    /* renamed from: i, reason: collision with root package name */
    public int f١٧٠٩٥i;

    /* renamed from: j, reason: collision with root package name */
    public float f١٧٠٩٦j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f١٧٠٩٧k;

    /* renamed from: l, reason: collision with root package name */
    public PointF f١٧٠٩٨l;

    /* renamed from: m, reason: collision with root package name */
    public PointF f١٧٠٩٩m;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, float f10, a aVar, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10, PointF pointF, PointF pointF2) {
        a(str, str2, f10, aVar, i10, f11, f12, i11, i12, f13, z10, pointF, pointF2);
    }

    public void a(String str, String str2, float f10, a aVar, int i10, float f11, float f12, int i11, int i12, float f13, boolean z10, PointF pointF, PointF pointF2) {
        this.f١٧٠٨٧a = str;
        this.f١٧٠٨٨b = str2;
        this.f١٧٠٨٩c = f10;
        this.f١٧٠٩٠d = aVar;
        this.f١٧٠٩١e = i10;
        this.f١٧٠٩٢f = f11;
        this.f١٧٠٩٣g = f12;
        this.f١٧٠٩٤h = i11;
        this.f١٧٠٩٥i = i12;
        this.f١٧٠٩٦j = f13;
        this.f١٧٠٩٧k = z10;
        this.f١٧٠٩٨l = pointF;
        this.f١٧٠٩٩m = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f١٧٠٨٧a.hashCode() * 31) + this.f١٧٠٨٨b.hashCode()) * 31) + this.f١٧٠٨٩c)) * 31) + this.f١٧٠٩٠d.ordinal()) * 31) + this.f١٧٠٩١e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f١٧٠٩٢f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f١٧٠٩٤h;
    }

    public b() {
    }
}
