package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class p {

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f٣٦٧٩d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final int f٣٦٨٠a;

    /* renamed from: b, reason: collision with root package name */
    private final n f٣٦٨١b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f٣٦٨٢c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, int i10) {
        this.f٣٦٨١b = nVar;
        this.f٣٦٨٠a = i10;
    }

    private w2.a g() {
        ThreadLocal threadLocal = f٣٦٧٩d;
        w2.a aVar = (w2.a) threadLocal.get();
        if (aVar == null) {
            aVar = new w2.a();
            threadLocal.set(aVar);
        }
        this.f٣٦٨١b.d().j(aVar, this.f٣٦٨٠a);
        return aVar;
    }

    public void a(Canvas canvas, float f10, float f11, Paint paint) {
        Typeface g10 = this.f٣٦٨١b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g10);
        canvas.drawText(this.f٣٦٨١b.c(), this.f٣٦٨٠a * 2, 2, f10, f11, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i10) {
        return g().h(i10);
    }

    public int c() {
        return g().i();
    }

    public int d() {
        return this.f٣٦٨٢c & 3;
    }

    public int e() {
        return g().k();
    }

    public int f() {
        return g().l();
    }

    public short h() {
        return g().m();
    }

    public int i() {
        return g().n();
    }

    public boolean j() {
        return g().j();
    }

    public boolean k() {
        if ((this.f٣٦٨٢c & 4) > 0) {
            return true;
        }
        return false;
    }

    public void l(boolean z10) {
        int d10 = d();
        if (z10) {
            this.f٣٦٨٢c = d10 | 4;
        } else {
            this.f٣٦٨٢c = d10;
        }
    }

    public void m(boolean z10) {
        int i10;
        int i11 = this.f٣٦٨٢c & 4;
        if (z10) {
            i10 = i11 | 2;
        } else {
            i10 = i11 | 1;
        }
        this.f٣٦٨٢c = i10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(f()));
        sb.append(", codepoints:");
        int c10 = c();
        for (int i10 = 0; i10 < c10; i10++) {
            sb.append(Integer.toHexString(b(i10)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
