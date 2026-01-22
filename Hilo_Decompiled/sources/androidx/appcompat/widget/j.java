package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.core.view.d1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f١٥٦٢a;

    /* renamed from: b, reason: collision with root package name */
    private n0 f١٥٦٣b;

    /* renamed from: c, reason: collision with root package name */
    private n0 f١٥٦٤c;

    /* renamed from: d, reason: collision with root package name */
    private n0 f١٥٦٥d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٥٦٦e = 0;

    public j(ImageView imageView) {
        this.f١٥٦٢a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f١٥٦٥d == null) {
            this.f١٥٦٥d = new n0();
        }
        n0 n0Var = this.f١٥٦٥d;
        n0Var.a();
        ColorStateList a10 = androidx.core.widget.g.a(this.f١٥٦٢a);
        if (a10 != null) {
            n0Var.f١٦٢٢d = true;
            n0Var.f١٦١٩a = a10;
        }
        PorterDuff.Mode b10 = androidx.core.widget.g.b(this.f١٥٦٢a);
        if (b10 != null) {
            n0Var.f١٦٢١c = true;
            n0Var.f١٦٢٠b = b10;
        }
        if (!n0Var.f١٦٢٢d && !n0Var.f١٦٢١c) {
            return false;
        }
        f.i(drawable, n0Var, this.f١٥٦٢a.getDrawableState());
        return true;
    }

    private boolean l() {
        if (this.f١٥٦٣b != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f١٥٦٢a.getDrawable() != null) {
            this.f١٥٦٢a.getDrawable().setLevel(this.f١٥٦٦e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f١٥٦٢a.getDrawable();
        if (drawable != null) {
            c0.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            n0 n0Var = this.f١٥٦٤c;
            if (n0Var != null) {
                f.i(drawable, n0Var, this.f١٥٦٢a.getDrawableState());
                return;
            }
            n0 n0Var2 = this.f١٥٦٣b;
            if (n0Var2 != null) {
                f.i(drawable, n0Var2, this.f١٥٦٢a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList d() {
        n0 n0Var = this.f١٥٦٤c;
        if (n0Var != null) {
            return n0Var.f١٦١٩a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode e() {
        n0 n0Var = this.f١٥٦٤c;
        if (n0Var != null) {
            return n0Var.f١٦٢٠b;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        if (this.f١٥٦٢a.getBackground() instanceof RippleDrawable) {
            return false;
        }
        return true;
    }

    public void g(AttributeSet attributeSet, int i10) {
        int n10;
        Context context = this.f١٥٦٢a.getContext();
        int[] iArr = R.styleable.AppCompatImageView;
        p0 v10 = p0.v(context, attributeSet, iArr, i10, 0);
        ImageView imageView = this.f١٥٦٢a;
        d1.o0(imageView, imageView.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        try {
            Drawable drawable = this.f١٥٦٢a.getDrawable();
            if (drawable == null && (n10 = v10.n(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = r1.a.b(this.f١٥٦٢a.getContext(), n10)) != null) {
                this.f١٥٦٢a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                c0.b(drawable);
            }
            int i11 = R.styleable.AppCompatImageView_tint;
            if (v10.s(i11)) {
                androidx.core.widget.g.c(this.f١٥٦٢a, v10.c(i11));
            }
            int i12 = R.styleable.AppCompatImageView_tintMode;
            if (v10.s(i12)) {
                androidx.core.widget.g.d(this.f١٥٦٢a, c0.e(v10.k(i12, -1), null));
            }
            v10.x();
        } catch (Throwable th) {
            v10.x();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Drawable drawable) {
        this.f١٥٦٦e = drawable.getLevel();
    }

    public void i(int i10) {
        if (i10 != 0) {
            Drawable b10 = r1.a.b(this.f١٥٦٢a.getContext(), i10);
            if (b10 != null) {
                c0.b(b10);
            }
            this.f١٥٦٢a.setImageDrawable(b10);
        } else {
            this.f١٥٦٢a.setImageDrawable(null);
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ColorStateList colorStateList) {
        if (this.f١٥٦٤c == null) {
            this.f١٥٦٤c = new n0();
        }
        n0 n0Var = this.f١٥٦٤c;
        n0Var.f١٦١٩a = colorStateList;
        n0Var.f١٦٢٢d = true;
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(PorterDuff.Mode mode) {
        if (this.f١٥٦٤c == null) {
            this.f١٥٦٤c = new n0();
        }
        n0 n0Var = this.f١٥٦٤c;
        n0Var.f١٦٢٠b = mode;
        n0Var.f١٦٢١c = true;
        c();
    }
}
