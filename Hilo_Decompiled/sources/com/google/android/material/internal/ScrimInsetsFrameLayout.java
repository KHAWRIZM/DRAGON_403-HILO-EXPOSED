package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.core.view.d1;
import androidx.core.view.d2;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    Drawable f٩٢٠٣a;

    /* renamed from: b, reason: collision with root package name */
    Rect f٩٢٠٤b;

    /* renamed from: c, reason: collision with root package name */
    private Rect f٩٢٠٥c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٩٢٠٦d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٩٢٠٧e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٩٢٠٨f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٩٢٠٩g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements androidx.core.view.j0 {
        a() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            boolean z10;
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f٩٢٠٤b == null) {
                scrimInsetsFrameLayout.f٩٢٠٤b = new Rect();
            }
            ScrimInsetsFrameLayout.this.f٩٢٠٤b.set(d2Var.k(), d2Var.m(), d2Var.l(), d2Var.j());
            ScrimInsetsFrameLayout.this.g(d2Var);
            ScrimInsetsFrameLayout scrimInsetsFrameLayout2 = ScrimInsetsFrameLayout.this;
            if (d2Var.n() && ScrimInsetsFrameLayout.this.f٩٢٠٣a != null) {
                z10 = false;
            } else {
                z10 = true;
            }
            scrimInsetsFrameLayout2.setWillNotDraw(z10);
            ScrimInsetsFrameLayout.this.postInvalidateOnAnimation();
            return d2Var.c();
        }
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f٩٢٠٤b != null && this.f٩٢٠٣a != null) {
            int save = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.f٩٢٠٦d) {
                this.f٩٢٠٥c.set(0, 0, width, this.f٩٢٠٤b.top);
                this.f٩٢٠٣a.setBounds(this.f٩٢٠٥c);
                this.f٩٢٠٣a.draw(canvas);
            }
            if (this.f٩٢٠٧e) {
                this.f٩٢٠٥c.set(0, height - this.f٩٢٠٤b.bottom, width, height);
                this.f٩٢٠٣a.setBounds(this.f٩٢٠٥c);
                this.f٩٢٠٣a.draw(canvas);
            }
            if (this.f٩٢٠٨f) {
                Rect rect = this.f٩٢٠٥c;
                Rect rect2 = this.f٩٢٠٤b;
                rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
                this.f٩٢٠٣a.setBounds(this.f٩٢٠٥c);
                this.f٩٢٠٣a.draw(canvas);
            }
            if (this.f٩٢٠٩g) {
                Rect rect3 = this.f٩٢٠٥c;
                Rect rect4 = this.f٩٢٠٤b;
                rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
                this.f٩٢٠٣a.setBounds(this.f٩٢٠٥c);
                this.f٩٢٠٣a.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    protected void g(d2 d2Var) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f٩٢٠٣a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f٩٢٠٣a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z10) {
        this.f٩٢٠٧e = z10;
    }

    public void setDrawLeftInsetForeground(boolean z10) {
        this.f٩٢٠٨f = z10;
    }

    public void setDrawRightInsetForeground(boolean z10) {
        this.f٩٢٠٩g = z10;
    }

    public void setDrawTopInsetForeground(boolean z10) {
        this.f٩٢٠٦d = z10;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f٩٢٠٣a = drawable;
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٩٢٠٥c = new Rect();
        this.f٩٢٠٦d = true;
        this.f٩٢٠٧e = true;
        this.f٩٢٠٨f = true;
        this.f٩٢٠٩g = true;
        TypedArray i11 = h0.i(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i10, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f٩٢٠٣a = i11.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        i11.recycle();
        setWillNotDraw(true);
        d1.E0(this, new a());
    }
}
