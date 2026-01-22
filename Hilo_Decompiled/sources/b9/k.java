package b9;

import com.luck.picture.lib.config.Crop;
import com.qhqc.core.basic.net.exception.ApiErrorException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class k {

    /* renamed from: i, reason: collision with root package name */
    static final k[] f٥٥٦٣i;

    /* renamed from: j, reason: collision with root package name */
    private static k[] f٥٥٦٤j;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f٥٥٦٥a;

    /* renamed from: b, reason: collision with root package name */
    private final int f٥٥٦٦b;

    /* renamed from: c, reason: collision with root package name */
    private final int f٥٥٦٧c;

    /* renamed from: d, reason: collision with root package name */
    public final int f٥٥٦٨d;

    /* renamed from: e, reason: collision with root package name */
    public final int f٥٥٦٩e;

    /* renamed from: f, reason: collision with root package name */
    private final int f٥٥٧٠f;

    /* renamed from: g, reason: collision with root package name */
    private final int f٥٥٧١g;

    /* renamed from: h, reason: collision with root package name */
    private final int f٥٥٧٢h;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, Crop.REQUEST_EDIT_CROP, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, ApiErrorException.REQUEST_TIMEOUT, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f٥٥٦٣i = kVarArr;
        f٥٥٦٤j = kVarArr;
    }

    public k(boolean z10, int i10, int i11, int i12, int i13, int i14) {
        this(z10, i10, i11, i12, i13, i14, i10, i11);
    }

    private int e() {
        int i10 = this.f٥٥٧٠f;
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2 && i10 != 4) {
                if (i10 == 16) {
                    return 4;
                }
                if (i10 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i11;
    }

    private int k() {
        int i10 = this.f٥٥٧٠f;
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static k l(int i10, l lVar, v8.b bVar, v8.b bVar2, boolean z10) {
        for (k kVar : f٥٥٦٤j) {
            if ((lVar != l.FORCE_SQUARE || !kVar.f٥٥٦٥a) && ((lVar != l.FORCE_RECTANGLE || kVar.f٥٥٦٥a) && i10 <= kVar.f٥٥٦٦b)) {
                return kVar;
            }
        }
        if (!z10) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i10)));
    }

    public final int a() {
        return this.f٥٥٦٦b;
    }

    public int b(int i10) {
        return this.f٥٥٧١g;
    }

    public final int c() {
        return this.f٥٥٦٧c;
    }

    public final int d(int i10) {
        return this.f٥٥٧٢h;
    }

    public int f() {
        return this.f٥٥٦٦b / this.f٥٥٧١g;
    }

    public final int g() {
        return k() * this.f٥٥٦٩e;
    }

    public final int h() {
        return e() * this.f٥٥٦٨d;
    }

    public final int i() {
        return g() + (k() << 1);
    }

    public final int j() {
        return h() + (e() << 1);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f٥٥٦٥a) {
            str = "Rectangular Symbol:";
        } else {
            str = "Square Symbol:";
        }
        sb.append(str);
        sb.append(" data region ");
        sb.append(this.f٥٥٦٨d);
        sb.append('x');
        sb.append(this.f٥٥٦٩e);
        sb.append(", symbol size ");
        sb.append(j());
        sb.append('x');
        sb.append(i());
        sb.append(", symbol data size ");
        sb.append(h());
        sb.append('x');
        sb.append(g());
        sb.append(", codewords ");
        sb.append(this.f٥٥٦٦b);
        sb.append('+');
        sb.append(this.f٥٥٦٧c);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f٥٥٦٥a = z10;
        this.f٥٥٦٦b = i10;
        this.f٥٥٦٧c = i11;
        this.f٥٥٦٨d = i12;
        this.f٥٥٦٩e = i13;
        this.f٥٥٧٠f = i14;
        this.f٥٥٧١g = i15;
        this.f٥٥٧٢h = i16;
    }
}
