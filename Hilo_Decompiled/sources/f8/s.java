package f8;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import s7.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class s {

    /* renamed from: c, reason: collision with root package name */
    o f١٤٢٥١c;

    /* renamed from: a, reason: collision with root package name */
    boolean f١٤٢٤٩a = false;

    /* renamed from: b, reason: collision with root package name */
    boolean f١٤٢٥٠b = false;

    /* renamed from: d, reason: collision with root package name */
    RectF f١٤٢٥٢d = new RectF();

    /* renamed from: e, reason: collision with root package name */
    final Path f١٤٢٥٣e = new Path();

    public static s a(View view) {
        if (Build.VERSION.SDK_INT >= 33) {
            return new u(view);
        }
        return new t(view);
    }

    private boolean d() {
        RectF rectF = this.f١٤٢٥٢d;
        if (rectF.left <= rectF.right && rectF.top <= rectF.bottom) {
            return true;
        }
        return false;
    }

    private void k() {
        if (d() && this.f١٤٢٥١c != null) {
            p.l().d(this.f١٤٢٥١c, 1.0f, this.f١٤٢٥٢d, this.f١٤٢٥٣e);
        }
    }

    abstract void b(View view);

    public boolean c() {
        return this.f١٤٢٤٩a;
    }

    public void e(Canvas canvas, a.InterfaceC٠٢٢٨a r32) {
        if (j() && !this.f١٤٢٥٣e.isEmpty()) {
            canvas.save();
            canvas.clipPath(this.f١٤٢٥٣e);
            r32.a(canvas);
            canvas.restore();
            return;
        }
        r32.a(canvas);
    }

    public void f(View view, RectF rectF) {
        this.f١٤٢٥٢d = rectF;
        k();
        b(view);
    }

    public void g(View view, o oVar) {
        this.f١٤٢٥١c = oVar;
        k();
        b(view);
    }

    public void h(View view, boolean z10) {
        if (z10 != this.f١٤٢٤٩a) {
            this.f١٤٢٤٩a = z10;
            b(view);
        }
    }

    public void i(View view, boolean z10) {
        this.f١٤٢٥٠b = z10;
        b(view);
    }

    abstract boolean j();
}
