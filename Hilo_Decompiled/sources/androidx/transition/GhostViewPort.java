package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

@SuppressLint({"ViewConstructor"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class GhostViewPort extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    final View f٤٢٢٢a;

    /* renamed from: b, reason: collision with root package name */
    private Matrix f٤٢٢٣b;

    /* renamed from: c, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f٤٢٢٤c;

    static GhostViewPort a(View view) {
        return (GhostViewPort) view.getTag(R.id.ghost_view);
    }

    static void b(View view, GhostViewPort ghostViewPort) {
        view.setTag(R.id.ghost_view, ghostViewPort);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b(this.f٤٢٢٢a, this);
        this.f٤٢٢٢a.getViewTreeObserver().addOnPreDrawListener(this.f٤٢٢٤c);
        g0.f(this.f٤٢٢٢a, 4);
        if (this.f٤٢٢٢a.getParent() != null) {
            ((View) this.f٤٢٢٢a.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f٤٢٢٢a.getViewTreeObserver().removeOnPreDrawListener(this.f٤٢٢٤c);
        g0.f(this.f٤٢٢٢a, 0);
        b(this.f٤٢٢٢a, null);
        if (this.f٤٢٢٢a.getParent() != null) {
            ((View) this.f٤٢٢٢a.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        b.a(canvas, true);
        canvas.setMatrix(this.f٤٢٢٣b);
        g0.f(this.f٤٢٢٢a, 0);
        this.f٤٢٢٢a.invalidate();
        g0.f(this.f٤٢٢٢a, 4);
        drawChild(canvas, this.f٤٢٢٢a, getDrawingTime());
        b.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        int i11;
        super.setVisibility(i10);
        if (a(this.f٤٢٢٢a) == this) {
            if (i10 == 0) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            g0.f(this.f٤٢٢٢a, i11);
        }
    }
}
