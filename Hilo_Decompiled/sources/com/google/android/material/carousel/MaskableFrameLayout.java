package com.google.android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import f8.r;
import f8.s;
import s7.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaskableFrameLayout extends FrameLayout implements g, r {

    /* renamed from: a, reason: collision with root package name */
    private float f٨٦٣٨a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f٨٦٣٩b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f٨٦٤٠c;

    /* renamed from: d, reason: collision with root package name */
    private o f٨٦٤١d;

    /* renamed from: e, reason: collision with root package name */
    private final s f٨٦٤٢e;

    /* renamed from: f, reason: collision with root package name */
    private Boolean f٨٦٤٣f;

    /* renamed from: g, reason: collision with root package name */
    private View.OnHoverListener f٨٦٤٤g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٨٦٤٥h;

    public MaskableFrameLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f8.d d(f8.d dVar) {
        if (dVar instanceof f8.a) {
            return f8.c.b((f8.a) dVar);
        }
        return dVar;
    }

    private void e() {
        this.f٨٦٤٢e.f(this, this.f٨٦٣٩b);
    }

    private void f() {
        if (this.f٨٦٣٨a != -1.0f) {
            float b10 = p7.a.b(DownloadProgress.UNKNOWN_PROGRESS, getWidth() / 2.0f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, this.f٨٦٣٨a);
            setMaskRectF(new RectF(b10, DownloadProgress.UNKNOWN_PROGRESS, getWidth() - b10, getHeight()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f٨٦٤٢e.e(canvas, new a.InterfaceC٠٢٢٨a() { // from class: t7.e
            @Override // s7.a.InterfaceC٠٢٢٨a
            public final void a(Canvas canvas2) {
                MaskableFrameLayout.this.c(canvas2);
            }
        });
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        RectF rectF = this.f٨٦٣٩b;
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public RectF getMaskRectF() {
        return this.f٨٦٣٩b;
    }

    @Deprecated
    public float getMaskXPercentage() {
        return this.f٨٦٣٨a;
    }

    @Override // f8.r
    public o getShapeAppearanceModel() {
        return this.f٨٦٤١d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.f٨٦٤٣f;
        if (bool != null) {
            this.f٨٦٤٢e.h(this, bool.booleanValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f٨٦٤٣f = Boolean.valueOf(this.f٨٦٤٢e.c());
        this.f٨٦٤٢e.h(this, true);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (!this.f٨٦٣٩b.isEmpty() && (action == 9 || action == 10 || action == 7)) {
            if (!this.f٨٦٣٩b.contains(motionEvent.getX(), motionEvent.getY())) {
                if (this.f٨٦٤٥h && this.f٨٦٤٤g != null) {
                    motionEvent.setAction(10);
                    this.f٨٦٤٤g.onHover(this, motionEvent);
                }
                this.f٨٦٤٥h = false;
                return false;
            }
        }
        if (this.f٨٦٤٤g != null) {
            if (!this.f٨٦٤٥h && action == 7) {
                motionEvent.setAction(9);
                this.f٨٦٤٥h = true;
            }
            if (action == 7 || action == 9) {
                this.f٨٦٤٥h = true;
            }
            this.f٨٦٤٤g.onHover(this, motionEvent);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.getBoundsInScreen(this.f٨٦٤٠c);
        if (getX() > DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٨٦٤٠c.left = (int) (r0.left + this.f٨٦٣٩b.left);
        }
        if (getY() > DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٨٦٤٠c.top = (int) (r0.top + this.f٨٦٣٩b.top);
        }
        Rect rect = this.f٨٦٤٠c;
        rect.right = rect.left + Math.round(this.f٨٦٣٩b.width());
        Rect rect2 = this.f٨٦٤٠c;
        rect2.bottom = rect2.top + Math.round(this.f٨٦٣٩b.height());
        accessibilityNodeInfo.setBoundsInScreen(this.f٨٦٤٠c);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f٨٦٣٩b.isEmpty()) {
            if (!this.f٨٦٣٩b.contains(motionEvent.getX(), motionEvent.getY())) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.f٨٦٣٨a != -1.0f) {
            f();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f٨٦٣٩b.isEmpty() && motionEvent.getAction() == 0) {
            if (!this.f٨٦٣٩b.contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setForceCompatClipping(boolean z10) {
        this.f٨٦٤٢e.h(this, z10);
    }

    @Override // com.google.android.material.carousel.g
    public void setMaskRectF(RectF rectF) {
        this.f٨٦٣٩b.set(rectF);
        e();
    }

    @Deprecated
    public void setMaskXPercentage(float f10) {
        float a10 = j2.a.a(f10, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        if (this.f٨٦٣٨a != a10) {
            this.f٨٦٣٨a = a10;
            f();
        }
    }

    @Override // android.view.View
    public void setOnHoverListener(View.OnHoverListener onHoverListener) {
        this.f٨٦٤٤g = onHoverListener;
    }

    @Override // f8.r
    public void setShapeAppearanceModel(o oVar) {
        o z10 = oVar.z(new o.c() { // from class: t7.d
            @Override // f8.o.c
            public final f8.d a(f8.d dVar) {
                f8.d d10;
                d10 = MaskableFrameLayout.d(dVar);
                return d10;
            }
        });
        this.f٨٦٤١d = z10;
        this.f٨٦٤٢e.g(this, z10);
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٨٦٣٨a = -1.0f;
        this.f٨٦٣٩b = new RectF();
        this.f٨٦٤٠c = new Rect();
        this.f٨٦٤٢e = s.a(this);
        this.f٨٦٤٣f = null;
        this.f٨٦٤٥h = false;
        setShapeAppearanceModel(o.f(context, attributeSet, i10, 0, 0).m());
    }

    @Override // com.google.android.material.carousel.g
    public void setOnMaskChangedListener(t7.f fVar) {
    }
}
