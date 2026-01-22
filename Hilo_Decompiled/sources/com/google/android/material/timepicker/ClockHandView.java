package com.google.android.material.timepicker;

import a8.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import com.google.android.material.R;
import com.google.android.material.internal.k0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ClockHandView extends View {

    /* renamed from: a, reason: collision with root package name */
    private final int f١٠٢٩٦a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeInterpolator f١٠٢٩٧b;

    /* renamed from: c, reason: collision with root package name */
    private final ValueAnimator f١٠٢٩٨c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٠٢٩٩d;

    /* renamed from: e, reason: collision with root package name */
    private float f١٠٣٠٠e;

    /* renamed from: f, reason: collision with root package name */
    private float f١٠٣٠١f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٠٣٠٢g;

    /* renamed from: h, reason: collision with root package name */
    private final int f١٠٣٠٣h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٠٣٠٤i;

    /* renamed from: j, reason: collision with root package name */
    private final List f١٠٣٠٥j;

    /* renamed from: k, reason: collision with root package name */
    private final int f١٠٣٠٦k;

    /* renamed from: l, reason: collision with root package name */
    private final float f١٠٣٠٧l;

    /* renamed from: m, reason: collision with root package name */
    private final Paint f١٠٣٠٨m;

    /* renamed from: n, reason: collision with root package name */
    private final RectF f١٠٣٠٩n;

    /* renamed from: o, reason: collision with root package name */
    private final int f١٠٣١٠o;

    /* renamed from: p, reason: collision with root package name */
    private float f١٠٣١١p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٠٣١٢q;

    /* renamed from: r, reason: collision with root package name */
    private double f١٠٣١٣r;

    /* renamed from: s, reason: collision with root package name */
    private int f١٠٣١٤s;

    /* renamed from: t, reason: collision with root package name */
    private int f١٠٣١٥t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c {
        void b(float f10, boolean z10);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    private void b(float f10, float f11) {
        int i10 = 2;
        if (z7.a.b(getWidth() / 2, getHeight() / 2, f10, f11) > e(2) + k0.g(getContext(), 12)) {
            i10 = 1;
        }
        this.f١٠٣١٥t = i10;
    }

    private void c(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f10 = width;
        float e10 = e(this.f١٠٣١٥t);
        float cos = (((float) Math.cos(this.f١٠٣١٣r)) * e10) + f10;
        float f11 = height;
        float sin = (e10 * ((float) Math.sin(this.f١٠٣١٣r))) + f11;
        this.f١٠٣٠٨m.setStrokeWidth(DownloadProgress.UNKNOWN_PROGRESS);
        canvas.drawCircle(cos, sin, this.f١٠٣٠٦k, this.f١٠٣٠٨m);
        double sin2 = Math.sin(this.f١٠٣١٣r);
        double cos2 = Math.cos(this.f١٠٣١٣r);
        this.f١٠٣٠٨m.setStrokeWidth(this.f١٠٣١٠o);
        canvas.drawLine(f10, f11, width + ((int) (cos2 * r7)), height + ((int) (r7 * sin2)), this.f١٠٣٠٨m);
        canvas.drawCircle(f10, f11, this.f١٠٣٠٧l, this.f١٠٣٠٨m);
    }

    private int d(float f10, float f11) {
        int degrees = (int) Math.toDegrees(Math.atan2(f11 - (getHeight() / 2), f10 - (getWidth() / 2)));
        int i10 = degrees + 90;
        if (i10 < 0) {
            return degrees + 450;
        }
        return i10;
    }

    private int e(int i10) {
        if (i10 == 2) {
            return Math.round(this.f١٠٣١٤s * 0.66f);
        }
        return this.f١٠٣١٤s;
    }

    private Pair f(float f10) {
        float handRotation = getHandRotation();
        if (Math.abs(handRotation - f10) > 180.0f) {
            if (handRotation > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (handRotation < 180.0f && f10 > 180.0f) {
                handRotation += 360.0f;
            }
        }
        return new Pair(Float.valueOf(handRotation), Float.valueOf(f10));
    }

    private boolean g(float f10, float f11, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        float d10 = d(f10, f11);
        boolean z14 = false;
        if (getHandRotation() != d10) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z11 && z13) {
            return true;
        }
        if (!z13 && !z10) {
            return false;
        }
        if (z12 && this.f١٠٢٩٩d) {
            z14 = true;
        }
        j(d10, z14);
        return true;
    }

    private void h() {
        this.f١٠٢٩٨c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClockHandView.this.i(valueAnimator);
            }
        });
        this.f١٠٢٩٨c.addListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        k(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void k(float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.f١٠٣١١p = f11;
        this.f١٠٣١٣r = Math.toRadians(f11 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float e10 = e(this.f١٠٣١٥t);
        float cos = width + (((float) Math.cos(this.f١٠٣١٣r)) * e10);
        float sin = height + (e10 * ((float) Math.sin(this.f١٠٣١٣r)));
        RectF rectF = this.f١٠٣٠٩n;
        int i10 = this.f١٠٣٠٦k;
        rectF.set(cos - i10, sin - i10, cos + i10, sin + i10);
        Iterator it = this.f١٠٣٠٥j.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(f11, z10);
        }
        invalidate();
    }

    public void addOnRotateListener(c cVar) {
        this.f١٠٣٠٥j.add(cVar);
    }

    public RectF getCurrentSelectorBox() {
        return this.f١٠٣٠٩n;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 360.0d)
    public float getHandRotation() {
        return this.f١٠٣١١p;
    }

    public int getSelectorRadius() {
        return this.f١٠٣٠٦k;
    }

    public void j(float f10, boolean z10) {
        this.f١٠٢٩٨c.cancel();
        if (!z10) {
            k(f10, false);
            return;
        }
        Pair f11 = f(f10);
        this.f١٠٢٩٨c.setFloatValues(((Float) f11.first).floatValue(), ((Float) f11.second).floatValue());
        this.f١٠٢٩٨c.setDuration(this.f١٠٢٩٦a);
        this.f١٠٢٩٨c.setInterpolator(this.f١٠٢٩٧b);
        this.f١٠٢٩٨c.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(boolean z10) {
        if (this.f١٠٣٠٤i && !z10) {
            this.f١٠٣١٥t = 1;
        }
        this.f١٠٣٠٤i = z10;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!this.f١٠٢٩٨c.isRunning()) {
            setHandRotation(getHandRotation());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                z10 = false;
                z11 = false;
            } else {
                int i10 = (int) (x10 - this.f١٠٣٠٠e);
                int i11 = (int) (y10 - this.f١٠٣٠١f);
                if ((i10 * i10) + (i11 * i11) > this.f١٠٣٠٣h) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                this.f١٠٣٠٢g = z13;
                z10 = this.f١٠٣١٢q;
                if (actionMasked == 1) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (this.f١٠٣٠٤i) {
                    b(x10, y10);
                }
                z12 = z14;
                z11 = false;
                this.f١٠٣١٢q |= g(x10, y10, z10, z11, z12);
                return true;
            }
        } else {
            this.f١٠٣٠٠e = x10;
            this.f١٠٣٠١f = y10;
            this.f١٠٣٠٢g = true;
            this.f١٠٣١٢q = false;
            z10 = false;
            z11 = true;
        }
        z12 = false;
        this.f١٠٣١٢q |= g(x10, y10, z10, z11, z12);
        return true;
    }

    public void setAnimateOnTouchUp(boolean z10) {
        this.f١٠٢٩٩d = z10;
    }

    public void setCircleRadius(@Dimension int i10) {
        this.f١٠٣١٤s = i10;
        invalidate();
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float f10) {
        j(f10, false);
    }

    public void setOnActionUpListener(b bVar) {
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٠٢٩٨c = new ValueAnimator();
        this.f١٠٣٠٥j = new ArrayList();
        Paint paint = new Paint();
        this.f١٠٣٠٨m = paint;
        this.f١٠٣٠٩n = new RectF();
        this.f١٠٣١٥t = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i10, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f١٠٢٩٦a = k.f(context, R.attr.motionDurationLong2, 200);
        this.f١٠٢٩٧b = k.g(context, R.attr.motionEasingEmphasizedInterpolator, p7.a.f١٦٩٤٨b);
        this.f١٠٣١٤s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f١٠٣٠٦k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        this.f١٠٣١٠o = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f١٠٣٠٧l = r7.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        setHandRotation(DownloadProgress.UNKNOWN_PROGRESS);
        this.f١٠٣٠٣h = ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        obtainStyledAttributes.recycle();
        h();
    }
}
