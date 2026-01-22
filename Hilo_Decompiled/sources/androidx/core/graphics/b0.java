package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b0 {

    /* renamed from: e, reason: collision with root package name */
    public static final b0 f٢٧٩٢e = new b0(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f٢٧٩٣a;

    /* renamed from: b, reason: collision with root package name */
    public final int f٢٧٩٤b;

    /* renamed from: c, reason: collision with root package name */
    public final int f٢٧٩٥c;

    /* renamed from: d, reason: collision with root package name */
    public final int f٢٧٩٦d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    private b0(int i10, int i11, int i12, int i13) {
        this.f٢٧٩٣a = i10;
        this.f٢٧٩٤b = i11;
        this.f٢٧٩٥c = i12;
        this.f٢٧٩٦d = i13;
    }

    public static b0 a(b0 b0Var, b0 b0Var2) {
        return b(Math.max(b0Var.f٢٧٩٣a, b0Var2.f٢٧٩٣a), Math.max(b0Var.f٢٧٩٤b, b0Var2.f٢٧٩٤b), Math.max(b0Var.f٢٧٩٥c, b0Var2.f٢٧٩٥c), Math.max(b0Var.f٢٧٩٦d, b0Var2.f٢٧٩٦d));
    }

    public static b0 b(int i10, int i11, int i12, int i13) {
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return f٢٧٩٢e;
        }
        return new b0(i10, i11, i12, i13);
    }

    public static b0 c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b0 d(b0 b0Var, b0 b0Var2) {
        return b(b0Var.f٢٧٩٣a - b0Var2.f٢٧٩٣a, b0Var.f٢٧٩٤b - b0Var2.f٢٧٩٤b, b0Var.f٢٧٩٥c - b0Var2.f٢٧٩٥c, b0Var.f٢٧٩٦d - b0Var2.f٢٧٩٦d);
    }

    public static b0 e(Insets insets) {
        int i10;
        int i11;
        int i12;
        int i13;
        i10 = insets.left;
        i11 = insets.top;
        i12 = insets.right;
        i13 = insets.bottom;
        return b(i10, i11, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (this.f٢٧٩٦d == b0Var.f٢٧٩٦d && this.f٢٧٩٣a == b0Var.f٢٧٩٣a && this.f٢٧٩٥c == b0Var.f٢٧٩٥c && this.f٢٧٩٤b == b0Var.f٢٧٩٤b) {
            return true;
        }
        return false;
    }

    public Insets f() {
        return a.a(this.f٢٧٩٣a, this.f٢٧٩٤b, this.f٢٧٩٥c, this.f٢٧٩٦d);
    }

    public int hashCode() {
        return (((((this.f٢٧٩٣a * 31) + this.f٢٧٩٤b) * 31) + this.f٢٧٩٥c) * 31) + this.f٢٧٩٦d;
    }

    public String toString() {
        return "Insets{left=" + this.f٢٧٩٣a + ", top=" + this.f٢٧٩٤b + ", right=" + this.f٢٧٩٥c + ", bottom=" + this.f٢٧٩٦d + '}';
    }
}
