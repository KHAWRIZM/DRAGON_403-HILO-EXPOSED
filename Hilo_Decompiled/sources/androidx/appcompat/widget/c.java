package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.view.d1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final View f١٤٦٦a;

    /* renamed from: d, reason: collision with root package name */
    private n0 f١٤٦٩d;

    /* renamed from: e, reason: collision with root package name */
    private n0 f١٤٧٠e;

    /* renamed from: f, reason: collision with root package name */
    private n0 f١٤٧١f;

    /* renamed from: c, reason: collision with root package name */
    private int f١٤٦٨c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final f f١٤٦٧b = f.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(View view) {
        this.f١٤٦٦a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f١٤٧١f == null) {
            this.f١٤٧١f = new n0();
        }
        n0 n0Var = this.f١٤٧١f;
        n0Var.a();
        ColorStateList u10 = d1.u(this.f١٤٦٦a);
        if (u10 != null) {
            n0Var.f١٦٢٢d = true;
            n0Var.f١٦١٩a = u10;
        }
        PorterDuff.Mode v10 = d1.v(this.f١٤٦٦a);
        if (v10 != null) {
            n0Var.f١٦٢١c = true;
            n0Var.f١٦٢٠b = v10;
        }
        if (!n0Var.f١٦٢٢d && !n0Var.f١٦٢١c) {
            return false;
        }
        f.i(drawable, n0Var, this.f١٤٦٦a.getDrawableState());
        return true;
    }

    private boolean k() {
        if (this.f١٤٦٩d != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f١٤٦٦a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            n0 n0Var = this.f١٤٧٠e;
            if (n0Var != null) {
                f.i(background, n0Var, this.f١٤٦٦a.getDrawableState());
                return;
            }
            n0 n0Var2 = this.f١٤٦٩d;
            if (n0Var2 != null) {
                f.i(background, n0Var2, this.f١٤٦٦a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        n0 n0Var = this.f١٤٧٠e;
        if (n0Var != null) {
            return n0Var.f١٦١٩a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        n0 n0Var = this.f١٤٧٠e;
        if (n0Var != null) {
            return n0Var.f١٦٢٠b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i10) {
        Context context = this.f١٤٦٦a.getContext();
        int[] iArr = R.styleable.ViewBackgroundHelper;
        p0 v10 = p0.v(context, attributeSet, iArr, i10, 0);
        View view = this.f١٤٦٦a;
        d1.o0(view, view.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            int i11 = R.styleable.ViewBackgroundHelper_android_background;
            if (v10.s(i11)) {
                this.f١٤٦٨c = v10.n(i11, -1);
                ColorStateList f10 = this.f١٤٦٧b.f(this.f١٤٦٦a.getContext(), this.f١٤٦٨c);
                if (f10 != null) {
                    h(f10);
                }
            }
            int i12 = R.styleable.ViewBackgroundHelper_backgroundTint;
            if (v10.s(i12)) {
                d1.u0(this.f١٤٦٦a, v10.c(i12));
            }
            int i13 = R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (v10.s(i13)) {
                d1.v0(this.f١٤٦٦a, c0.e(v10.k(i13, -1), null));
            }
            v10.x();
        } catch (Throwable th) {
            v10.x();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f١٤٦٨c = -1;
        h(null);
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i10) {
        ColorStateList colorStateList;
        this.f١٤٦٨c = i10;
        f fVar = this.f١٤٦٧b;
        if (fVar != null) {
            colorStateList = fVar.f(this.f١٤٦٦a.getContext(), i10);
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f١٤٦٩d == null) {
                this.f١٤٦٩d = new n0();
            }
            n0 n0Var = this.f١٤٦٩d;
            n0Var.f١٦١٩a = colorStateList;
            n0Var.f١٦٢٢d = true;
        } else {
            this.f١٤٦٩d = null;
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f١٤٧٠e == null) {
            this.f١٤٧٠e = new n0();
        }
        n0 n0Var = this.f١٤٧٠e;
        n0Var.f١٦١٩a = colorStateList;
        n0Var.f١٦٢٢d = true;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f١٤٧٠e == null) {
            this.f١٤٧٠e = new n0();
        }
        n0 n0Var = this.f١٤٧٠e;
        n0Var.f١٦٢٠b = mode;
        n0Var.f١٦٢١c = true;
        b();
    }
}
