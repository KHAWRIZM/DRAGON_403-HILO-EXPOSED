package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import com.google.android.material.progressindicator.a;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.a> extends ProgressBar {

    /* renamed from: p, reason: collision with root package name */
    static final int f٩٥٧٠p = R.style.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: a, reason: collision with root package name */
    com.google.android.material.progressindicator.a f٩٥٧١a;

    /* renamed from: b, reason: collision with root package name */
    private int f٩٥٧٢b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٩٥٧٣c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٩٥٧٤d;

    /* renamed from: e, reason: collision with root package name */
    private final int f٩٥٧٥e;

    /* renamed from: f, reason: collision with root package name */
    private final int f٩٥٧٦f;

    /* renamed from: g, reason: collision with root package name */
    private long f٩٥٧٧g;

    /* renamed from: h, reason: collision with root package name */
    b8.a f٩٥٧٨h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f٩٥٧٩i;

    /* renamed from: j, reason: collision with root package name */
    private int f٩٥٨٠j;

    /* renamed from: k, reason: collision with root package name */
    boolean f٩٥٨١k;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f٩٥٨٢l;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f٩٥٨٣m;

    /* renamed from: n, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f٩٥٨٤n;

    /* renamed from: o, reason: collision with root package name */
    private final androidx.vectordrawable.graphics.drawable.b f٩٥٨٥o;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.k();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.this.j();
            BaseProgressIndicator.this.f٩٥٧٧g = -1L;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c extends androidx.vectordrawable.graphics.drawable.b {
        c() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void b(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.p(baseProgressIndicator.f٩٥٧٢b, BaseProgressIndicator.this.f٩٥٧٣c);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d extends androidx.vectordrawable.graphics.drawable.b {
        d() {
        }

        @Override // androidx.vectordrawable.graphics.drawable.b
        public void b(Drawable drawable) {
            super.b(drawable);
            if (!BaseProgressIndicator.this.f٩٥٧٩i) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setVisibility(baseProgressIndicator.f٩٥٨٠j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseProgressIndicator(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(g8.a.d(context, attributeSet, i10, f٩٥٧٠p), attributeSet, i10);
        this.f٩٥٧٧g = -1L;
        this.f٩٥٧٩i = false;
        this.f٩٥٨٠j = 4;
        this.f٩٥٨٢l = new a();
        this.f٩٥٨٣m = new b();
        this.f٩٥٨٤n = new c();
        this.f٩٥٨٥o = new d();
        Context context2 = getContext();
        this.f٩٥٧١a = i(context2, attributeSet);
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.BaseProgressIndicator, i10, i11, new int[0]);
        this.f٩٥٧٥e = i12.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.f٩٥٧٦f = Math.min(i12.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        i12.recycle();
        this.f٩٥٧٨h = new b8.a();
        this.f٩٥٧٤d = true;
    }

    private h getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().y();
        }
        if (getProgressDrawable() == null) {
            return null;
        }
        return getProgressDrawable().D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ((g) getCurrentDrawable()).s(false, false, true);
        if (m()) {
            setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f٩٥٧٦f > 0) {
            this.f٩٥٧٧g = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean m() {
        if ((getProgressDrawable() != null && getProgressDrawable().isVisible()) || (getIndeterminateDrawable() != null && getIndeterminateDrawable().isVisible())) {
            return false;
        }
        return true;
    }

    private void n() {
        o();
        if (getProgressDrawable() != null) {
            getProgressDrawable().o(this.f٩٥٨٥o);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().o(this.f٩٥٨٥o);
        }
    }

    private void q() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().u(this.f٩٥٨٥o);
            getIndeterminateDrawable().x().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().u(this.f٩٥٨٥o);
        }
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        if (isIndeterminate()) {
            return getIndeterminateDrawable();
        }
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f٩٥٧١a.f٩٥٩٩h;
    }

    public int[] getIndicatorColor() {
        return this.f٩٥٧١a.f٩٥٩٦e;
    }

    public int getIndicatorTrackGapSize() {
        return this.f٩٥٧١a.f٩٦٠٠i;
    }

    public int getShowAnimationBehavior() {
        return this.f٩٥٧١a.f٩٥٩٨g;
    }

    public int getTrackColor() {
        return this.f٩٥٧١a.f٩٥٩٧f;
    }

    public int getTrackCornerRadius() {
        return this.f٩٥٧١a.f٩٥٩٣b;
    }

    public float getTrackCornerRadiusFraction() {
        return this.f٩٥٧١a.f٩٥٩٤c;
    }

    public int getTrackThickness() {
        return this.f٩٥٧١a.f٩٥٩٢a;
    }

    public int getWaveAmplitude() {
        return this.f٩٥٧١a.f٩٦٠٣l;
    }

    public int getWaveSpeed() {
        return this.f٩٥٧١a.f٩٦٠٤m;
    }

    public int getWavelengthDeterminate() {
        return this.f٩٥٧١a.f٩٦٠١j;
    }

    public int getWavelengthIndeterminate() {
        return this.f٩٥٧١a.f٩٦٠٢k;
    }

    protected void h(boolean z10) {
        if (!this.f٩٥٧٤d) {
            return;
        }
        ((g) getCurrentDrawable()).s(r(), false, z10);
    }

    abstract com.google.android.material.progressindicator.a i(Context context, AttributeSet attributeSet);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    boolean l() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() != 0) {
                    return false;
                }
                return true;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().x().d(this.f٩٥٨٤n);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (r()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f٩٥٨٣m);
        removeCallbacks(this.f٩٥٨٢l);
        ((g) getCurrentDrawable()).j();
        q();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (getPaddingRight() == 0 || getPaddingBottom() != 0) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (getPaddingRight() == 0) {
            }
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        getCurrentDrawingDelegate().g();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i10, int i11) {
        int f10;
        int e10;
        try {
            h currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate == null) {
                return;
            }
            if (currentDrawingDelegate.f() < 0) {
                f10 = View.getDefaultSize(getSuggestedMinimumWidth(), i10);
            } else {
                f10 = currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight();
            }
            if (currentDrawingDelegate.e() < 0) {
                e10 = View.getDefaultSize(getSuggestedMinimumHeight(), i11);
            } else {
                e10 = currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(f10, e10);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        boolean z10;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        h(z10);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        h(false);
    }

    public void p(int i10, boolean z10) {
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.f٩٥٧٢b = i10;
                this.f٩٥٧٣c = z10;
                this.f٩٥٧٩i = true;
                if (getIndeterminateDrawable().isVisible() && this.f٩٥٧٨h.a(getContext().getContentResolver()) != DownloadProgress.UNKNOWN_PROGRESS) {
                    getIndeterminateDrawable().x().f();
                    return;
                } else {
                    this.f٩٥٨٤n.b(getIndeterminateDrawable());
                    return;
                }
            }
            return;
        }
        super.setProgress(i10);
        if (getProgressDrawable() != null && !z10) {
            getProgressDrawable().jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        if (isAttachedToWindow() && getWindowVisibility() == 0 && l()) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(b8.a aVar) {
        this.f٩٥٧٨h = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f٩٦٦٦c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f٩٦٦٦c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i10) {
        this.f٩٥٧١a.f٩٥٩٩h = i10;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z10) {
        try {
            if (z10 == isIndeterminate()) {
                return;
            }
            g gVar = (g) getCurrentDrawable();
            if (gVar != null) {
                gVar.j();
            }
            super.setIndeterminate(z10);
            g gVar2 = (g) getCurrentDrawable();
            if (gVar2 != null) {
                gVar2.s(r(), false, false);
            }
            if ((gVar2 instanceof j) && r()) {
                ((j) gVar2).x().g();
            }
            this.f٩٥٧٩i = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setIndeterminateAnimatorDurationScale(@FloatRange(from = 0.10000000149011612d, to = 10.0d) float f10) {
        com.google.android.material.progressindicator.a aVar = this.f٩٥٧١a;
        if (aVar.f٩٦٠٥n != f10) {
            aVar.f٩٦٠٥n = f10;
            getIndeterminateDrawable().x().c();
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable instanceof j) {
            ((g) drawable).j();
            super.setIndeterminateDrawable(drawable);
        } else {
            if (!this.f٩٥٨١k) {
                super.setIndeterminateDrawable(drawable);
                return;
            }
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{v7.a.b(getContext(), androidx.appcompat.R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.f٩٥٧١a.f٩٥٩٦e = iArr;
            getIndeterminateDrawable().x().c();
            invalidate();
        }
    }

    public void setIndicatorTrackGapSize(int i10) {
        com.google.android.material.progressindicator.a aVar = this.f٩٥٧١a;
        if (aVar.f٩٦٠٠i != i10) {
            aVar.f٩٦٠٠i = i10;
            aVar.h();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i10) {
        if (isIndeterminate()) {
            return;
        }
        p(i10, false);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable instanceof f) {
            f fVar = (f) drawable;
            fVar.j();
            super.setProgressDrawable(fVar);
            fVar.N(getProgress() / getMax());
            return;
        }
        if (!this.f٩٥٨١k) {
            super.setProgressDrawable(drawable);
            return;
        }
        throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
    }

    public void setShowAnimationBehavior(int i10) {
        this.f٩٥٧١a.f٩٥٩٨g = i10;
        invalidate();
    }

    public void setTrackColor(int i10) {
        com.google.android.material.progressindicator.a aVar = this.f٩٥٧١a;
        if (aVar.f٩٥٩٧f != i10) {
            aVar.f٩٥٩٧f = i10;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i10) {
        com.google.android.material.progressindicator.a aVar = this.f٩٥٧١a;
        if (aVar.f٩٥٩٣b != i10) {
            aVar.f٩٥٩٣b = Math.min(i10, aVar.f٩٥٩٢a / 2);
            this.f٩٥٧١a.f٩٥٩٥d = false;
            invalidate();
        }
    }

    public void setTrackCornerRadiusFraction(@FloatRange(from = 0.0d, to = 0.5d) float f10) {
        com.google.android.material.progressindicator.a aVar = this.f٩٥٧١a;
        if (aVar.f٩٥٩٤c != f10) {
            aVar.f٩٥٩٤c = Math.min(f10, 0.5f);
            this.f٩٥٧١a.f٩٥٩٥d = true;
            invalidate();
        }
    }

    public void setTrackThickness(int i10) {
        com.google.android.material.progressindicator.a aVar = this.f٩٥٧١a;
        if (aVar.f٩٥٩٢a != i10) {
            aVar.f٩٥٩٢a = i10;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i10) {
        if (i10 != 0 && i10 != 4 && i10 != 8) {
            throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.f٩٥٨٠j = i10;
    }

    public void setWaveAmplitude(int i10) {
        com.google.android.material.progressindicator.a aVar = this.f٩٥٧١a;
        if (aVar.f٩٦٠٣l != i10) {
            aVar.f٩٦٠٣l = Math.abs(i10);
            requestLayout();
        }
    }

    public void setWaveSpeed(int i10) {
        boolean z10;
        this.f٩٥٧١a.f٩٦٠٤m = i10;
        f progressDrawable = getProgressDrawable();
        if (this.f٩٥٧١a.f٩٦٠٤m != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        progressDrawable.L(z10);
    }

    public void setWavelength(int i10) {
        setWavelengthDeterminate(i10);
        setWavelengthIndeterminate(i10);
    }

    public void setWavelengthDeterminate(int i10) {
        com.google.android.material.progressindicator.a aVar = this.f٩٥٧١a;
        if (aVar.f٩٦٠١j != i10) {
            aVar.f٩٦٠١j = Math.abs(i10);
            if (!isIndeterminate()) {
                requestLayout();
            }
        }
    }

    public void setWavelengthIndeterminate(int i10) {
        com.google.android.material.progressindicator.a aVar = this.f٩٥٧١a;
        if (aVar.f٩٦٠٢k != i10) {
            aVar.f٩٦٠٢k = Math.abs(i10);
            if (isIndeterminate()) {
                requestLayout();
            }
        }
    }

    @Override // android.widget.ProgressBar
    public j getIndeterminateDrawable() {
        return (j) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public f getProgressDrawable() {
        return (f) super.getProgressDrawable();
    }
}
