package com.google.android.material.slider;

import a8.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.a0;
import androidx.core.view.d1;
import com.google.android.material.R;
import com.google.android.material.internal.h0;
import com.google.android.material.internal.k0;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;
import f8.o;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import m2.g0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends com.google.android.material.slider.a, T extends com.google.android.material.slider.b> extends View {
    private static final String V0 = "BaseSlider";
    static final int W0 = R.style.Widget_MaterialComponents_Slider;
    private static final int X0 = R.attr.motionDurationMedium4;
    private static final int Y0 = R.attr.motionDurationShort3;
    private static final int Z0 = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: a1, reason: collision with root package name */
    private static final int f٩٩١٢a1 = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    private int A;
    private ColorStateList A0;

    /* renamed from: B, reason: collision with root package name */
    private int f٩٩١٣B;
    private ColorStateList B0;
    private int C;
    private final Path C0;
    private int D;
    private final RectF D0;
    private int E;
    private final RectF E0;
    private int F;
    private final RectF F0;
    private int G;
    private final RectF G0;
    private int H;
    private final Rect H0;
    private int I;
    private final RectF I0;
    private int J;
    private final Rect J0;
    private int K;
    private final Matrix K0;
    private int L;
    private final i L0;
    private int M;
    private Drawable M0;
    private int N;
    private List N0;
    private boolean O;
    private float O0;
    private Drawable P;
    private int P0;
    private boolean Q;
    private final int Q0;
    private Drawable R;
    private final ViewTreeObserver.OnScrollChangedListener R0;
    private boolean S;
    private final ViewTreeObserver.OnGlobalLayoutListener S0;
    private ColorStateList T;
    private final Runnable T0;
    private Drawable U;
    private boolean U0;
    private boolean V;
    private Drawable W;

    /* renamed from: a, reason: collision with root package name */
    private final Paint f٩٩١٤a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f٩٩١٥a0;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f٩٩١٦b;

    /* renamed from: b0, reason: collision with root package name */
    private ColorStateList f٩٩١٧b0;

    /* renamed from: c, reason: collision with root package name */
    private final Paint f٩٩١٨c;

    /* renamed from: c0, reason: collision with root package name */
    private int f٩٩١٩c0;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f٩٩٢٠d;

    /* renamed from: d0, reason: collision with root package name */
    private int f٩٩٢١d0;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f٩٩٢٢e;

    /* renamed from: e0, reason: collision with root package name */
    private int f٩٩٢٣e0;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f٩٩٢٤f;

    /* renamed from: f0, reason: collision with root package name */
    private float f٩٩٢٥f0;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f٩٩٢٦g;

    /* renamed from: g0, reason: collision with root package name */
    private float f٩٩٢٧g0;

    /* renamed from: h, reason: collision with root package name */
    private final c f٩٩٢٨h;

    /* renamed from: h0, reason: collision with root package name */
    private MotionEvent f٩٩٢٩h0;

    /* renamed from: i, reason: collision with root package name */
    private final AccessibilityManager f٩٩٣٠i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f٩٩٣١i0;

    /* renamed from: j, reason: collision with root package name */
    private b f٩٩٣٢j;

    /* renamed from: j0, reason: collision with root package name */
    private float f٩٩٣٣j0;

    /* renamed from: k, reason: collision with root package name */
    private int f٩٩٣٤k;

    /* renamed from: k0, reason: collision with root package name */
    private float f٩٩٣٥k0;

    /* renamed from: l, reason: collision with root package name */
    private final List f٩٩٣٦l;

    /* renamed from: l0, reason: collision with root package name */
    private ArrayList f٩٩٣٧l0;

    /* renamed from: m, reason: collision with root package name */
    private final List f٩٩٣٨m;

    /* renamed from: m0, reason: collision with root package name */
    private int f٩٩٣٩m0;

    /* renamed from: n, reason: collision with root package name */
    private final List f٩٩٤٠n;

    /* renamed from: n0, reason: collision with root package name */
    private int f٩٩٤١n0;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٩٩٤٢o;

    /* renamed from: o0, reason: collision with root package name */
    private float f٩٩٤٣o0;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f٩٩٤٤p;

    /* renamed from: p0, reason: collision with root package name */
    private float[] f٩٩٤٥p0;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator f٩٩٤٦q;

    /* renamed from: q0, reason: collision with root package name */
    private int f٩٩٤٧q0;

    /* renamed from: r, reason: collision with root package name */
    private final int f٩٩٤٨r;

    /* renamed from: r0, reason: collision with root package name */
    private int f٩٩٤٩r0;

    /* renamed from: s, reason: collision with root package name */
    private int f٩٩٥٠s;

    /* renamed from: s0, reason: collision with root package name */
    private int f٩٩٥١s0;

    /* renamed from: t, reason: collision with root package name */
    private int f٩٩٥٢t;

    /* renamed from: t0, reason: collision with root package name */
    private int f٩٩٥٣t0;

    /* renamed from: u, reason: collision with root package name */
    private int f٩٩٥٤u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f٩٩٥٥u0;

    /* renamed from: v, reason: collision with root package name */
    private int f٩٩٥٦v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f٩٩٥٧v0;

    /* renamed from: w, reason: collision with root package name */
    private int f٩٩٥٨w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f٩٩٥٩w0;

    /* renamed from: x, reason: collision with root package name */
    private int f٩٩٦٠x;

    /* renamed from: x0, reason: collision with root package name */
    private ColorStateList f٩٩٦١x0;

    /* renamed from: y, reason: collision with root package name */
    private int f٩٩٦٢y;

    /* renamed from: y0, reason: collision with root package name */
    private ColorStateList f٩٩٦٣y0;

    /* renamed from: z, reason: collision with root package name */
    private int f٩٩٦٤z;

    /* renamed from: z0, reason: collision with root package name */
    private ColorStateList f٩٩٦٥z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        float f٩٩٦٦a;

        /* renamed from: b, reason: collision with root package name */
        float f٩٩٦٧b;

        /* renamed from: c, reason: collision with root package name */
        ArrayList f٩٩٦٨c;

        /* renamed from: d, reason: collision with root package name */
        float f٩٩٦٩d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٩٩٧٠e;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SliderState[] newArray(int i10) {
                return new SliderState[i10];
            }
        }

        /* synthetic */ SliderState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeFloat(this.f٩٩٦٦a);
            parcel.writeFloat(this.f٩٩٦٧b);
            parcel.writeList(this.f٩٩٦٨c);
            parcel.writeFloat(this.f٩٩٦٩d);
            parcel.writeBooleanArray(new boolean[]{this.f٩٩٧٠e});
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.f٩٩٦٦a = parcel.readFloat();
            this.f٩٩٦٧b = parcel.readFloat();
            ArrayList arrayList = new ArrayList();
            this.f٩٩٦٨c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f٩٩٦٩d = parcel.readFloat();
            this.f٩٩٧٠e = parcel.createBooleanArray()[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ViewOverlay V = BaseSlider.this.V();
            if (V == null) {
                return;
            }
            Iterator it = BaseSlider.this.f٩٩٣٦l.iterator();
            while (it.hasNext()) {
                V.remove((h8.a) it.next());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c extends s2.a {

        /* renamed from: n, reason: collision with root package name */
        private final BaseSlider f٩٩٧٤n;

        /* renamed from: o, reason: collision with root package name */
        final Rect f٩٩٧٥o;

        c(BaseSlider baseSlider) {
            super(baseSlider);
            this.f٩٩٧٥o = new Rect();
            this.f٩٩٧٤n = baseSlider;
        }

        private String N(int i10) {
            if (i10 == this.f٩٩٧٤n.getValues().size() - 1) {
                return this.f٩٩٧٤n.getContext().getString(R.string.material_slider_range_end);
            }
            if (i10 == 0) {
                return this.f٩٩٧٤n.getContext().getString(R.string.material_slider_range_start);
            }
            return "";
        }

        @Override // s2.a
        protected boolean A(int i10, int i11, Bundle bundle) {
            if (!this.f٩٩٧٤n.isEnabled()) {
                return false;
            }
            if (i11 == 4096 || i11 == 8192) {
                float u10 = this.f٩٩٧٤n.u(20);
                if (i11 == 8192) {
                    u10 = -u10;
                }
                if (this.f٩٩٧٤n.p0()) {
                    u10 = -u10;
                }
                if (!this.f٩٩٧٤n.S0(i10, j2.a.a(this.f٩٩٧٤n.getValues().get(i10).floatValue() + u10, this.f٩٩٧٤n.getValueFrom(), this.f٩٩٧٤n.getValueTo()))) {
                    return false;
                }
                this.f٩٩٧٤n.setActiveThumbIndex(i10);
                this.f٩٩٧٤n.L0();
                this.f٩٩٧٤n.V0();
                this.f٩٩٧٤n.postInvalidate();
                t(i10);
                return true;
            }
            if (i11 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                if (this.f٩٩٧٤n.S0(i10, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                    this.f٩٩٧٤n.V0();
                    this.f٩٩٧٤n.postInvalidate();
                    t(i10);
                    return true;
                }
            }
            return false;
        }

        @Override // s2.a
        protected void E(int i10, g0 g0Var) {
            g0Var.b(g0.a.L);
            List<Float> values = this.f٩٩٧٤n.getValues();
            Float f10 = values.get(i10);
            float floatValue = f10.floatValue();
            float valueFrom = this.f٩٩٧٤n.getValueFrom();
            float valueTo = this.f٩٩٧٤n.getValueTo();
            if (this.f٩٩٧٤n.isEnabled()) {
                if (floatValue > valueFrom) {
                    g0Var.a(8192);
                }
                if (floatValue < valueTo) {
                    g0Var.a(4096);
                }
            }
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(2);
            try {
                valueFrom = numberInstance.parse(numberInstance.format(valueFrom)).floatValue();
                valueTo = numberInstance.parse(numberInstance.format(valueTo)).floatValue();
                floatValue = numberInstance.parse(numberInstance.format(floatValue)).floatValue();
            } catch (ParseException unused) {
                Log.w(BaseSlider.V0, String.format("Error parsing value(%s), valueFrom(%s), and valueTo(%s) into a float.", f10, Float.valueOf(valueFrom), Float.valueOf(valueTo)));
            }
            g0Var.I0(g0.g.a(1, valueFrom, valueTo, floatValue));
            g0Var.o0(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.f٩٩٧٤n.getContentDescription() != null) {
                sb.append(this.f٩٩٧٤n.getContentDescription());
                sb.append(",");
            }
            String Q = this.f٩٩٧٤n.Q(floatValue);
            String string = this.f٩٩٧٤n.getContext().getString(R.string.material_slider_value);
            if (values.size() > 1) {
                string = N(i10);
            }
            CharSequence L = d1.L(this.f٩٩٧٤n);
            if (!TextUtils.isEmpty(L)) {
                g0Var.Q0(L);
            } else {
                sb.append(String.format(Locale.getDefault(), "%s, %s", string, Q));
            }
            g0Var.s0(sb.toString());
            this.f٩٩٧٤n.U0(i10, this.f٩٩٧٥o);
            g0Var.j0(this.f٩٩٧٥o);
        }

        @Override // s2.a
        protected int q(float f10, float f11) {
            for (int i10 = 0; i10 < this.f٩٩٧٤n.getValues().size(); i10++) {
                this.f٩٩٧٤n.U0(i10, this.f٩٩٧٥o);
                if (this.f٩٩٧٥o.contains((int) f10, (int) f11)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // s2.a
        protected void r(List list) {
            for (int i10 = 0; i10 < this.f٩٩٧٤n.getValues().size(); i10++) {
                list.add(Integer.valueOf(i10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum d {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, W0), attributeSet, i10);
        int recommendedTimeoutMillis;
        this.f٩٩٣٦l = new ArrayList();
        this.f٩٩٣٨m = new ArrayList();
        this.f٩٩٤٠n = new ArrayList();
        this.f٩٩٤٢o = false;
        this.J = -1;
        this.K = -1;
        this.O = false;
        this.Q = false;
        this.S = false;
        this.V = false;
        this.f٩٩١٥a0 = false;
        this.f٩٩٣١i0 = false;
        this.f٩٩٣٧l0 = new ArrayList();
        this.f٩٩٣٩m0 = -1;
        this.f٩٩٤١n0 = -1;
        this.f٩٩٤٣o0 = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٩٩٥٧v0 = false;
        this.C0 = new Path();
        this.D0 = new RectF();
        this.E0 = new RectF();
        this.F0 = new RectF();
        this.G0 = new RectF();
        this.H0 = new Rect();
        this.I0 = new RectF();
        this.J0 = new Rect();
        this.K0 = new Matrix();
        i iVar = new i();
        this.L0 = iVar;
        this.N0 = Collections.emptyList();
        this.P0 = 0;
        this.R0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.slider.e
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                BaseSlider.this.X0();
            }
        };
        this.S0 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.slider.f
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                BaseSlider.this.X0();
            }
        };
        this.T0 = new Runnable() { // from class: com.google.android.material.slider.g
            @Override // java.lang.Runnable
            public final void run() {
                BaseSlider.this.u0();
            }
        };
        Context context2 = getContext();
        this.U0 = isShown();
        this.f٩٩١٤a = new Paint();
        this.f٩٩١٦b = new Paint();
        Paint paint = new Paint(1);
        this.f٩٩١٨c = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.f٩٩٢٠d = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f٩٩٢٢e = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.f٩٩٢٤f = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.f٩٩٢٦g = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        v0(context2.getResources());
        J0(context2, attributeSet, i10);
        setFocusable(true);
        setClickable(true);
        iVar.o0(2);
        this.f٩٩٤٨r = ViewConfiguration.get(context2).getScaledTouchSlop();
        c cVar = new c(this);
        this.f٩٩٢٨h = cVar;
        d1.q0(this, cVar);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f٩٩٣٠i = accessibilityManager;
        if (Build.VERSION.SDK_INT >= 29) {
            recommendedTimeoutMillis = accessibilityManager.getRecommendedTimeoutMillis(10000, 6);
            this.Q0 = recommendedTimeoutMillis;
        } else {
            this.Q0 = 120000;
        }
    }

    private void A(h8.a aVar) {
        ViewGroup i10 = k0.i(this);
        if (i10 == null) {
            return;
        }
        i10.getOverlay().remove(aVar);
        aVar.H0(i10);
    }

    private boolean A0() {
        int paddingTop;
        int paddingBottom;
        if (s0()) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i10 = paddingTop + paddingBottom;
        int max = Math.max(this.A, Math.max(this.D + i10, this.G + i10));
        if (max == this.f٩٩١٣B) {
            return false;
        }
        this.f٩٩١٣B = max;
        return true;
    }

    private float B(float f10) {
        if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        float f11 = (f10 - this.E) / this.f٩٩٥٣t0;
        float f12 = this.f٩٩٣٣j0;
        return (f11 * (f12 - this.f٩٩٣٥k0)) + f12;
    }

    private boolean B0(int i10) {
        int i11 = this.f٩٩٤١n0;
        int c10 = (int) j2.a.c(i11 + i10, 0L, this.f٩٩٣٧l0.size() - 1);
        this.f٩٩٤١n0 = c10;
        if (c10 == i11) {
            return false;
        }
        if (this.f٩٩٣٩m0 != -1) {
            this.f٩٩٣٩m0 = c10;
        }
        V0();
        postInvalidate();
        return true;
    }

    private void C(int i10) {
        Iterator it = this.f٩٩٣٨m.iterator();
        if (!it.hasNext()) {
            AccessibilityManager accessibilityManager = this.f٩٩٣٠i;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                K0(i10);
                return;
            }
            return;
        }
        a0.a(it.next());
        ((Float) this.f٩٩٣٧l0.get(i10)).floatValue();
        throw null;
    }

    private boolean C0(int i10) {
        if (p0() || s0()) {
            if (i10 == Integer.MIN_VALUE) {
                i10 = Integer.MAX_VALUE;
            } else {
                i10 = -i10;
            }
        }
        return B0(i10);
    }

    private void D() {
        Iterator it = this.f٩٩٣٨m.iterator();
        while (it.hasNext()) {
            a0.a(it.next());
            Iterator it2 = this.f٩٩٣٧l0.iterator();
            if (it2.hasNext()) {
                ((Float) it2.next()).floatValue();
                throw null;
            }
        }
    }

    private float D0(float f10) {
        float f11 = this.f٩٩٣٣j0;
        float f12 = (f10 - f11) / (this.f٩٩٣٥k0 - f11);
        if (!p0() && !s0()) {
            return f12;
        }
        return 1.0f - f12;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void E(Canvas canvas, int i10, int i11) {
        int i12;
        float f10;
        float f11;
        float[] R = R();
        int i13 = this.E;
        float f12 = i10;
        float f13 = i13 + (R[1] * f12);
        float f14 = i13 + (R[0] * f12);
        if (f14 >= f13) {
            this.D0.setEmpty();
            return;
        }
        d dVar = d.NONE;
        if (this.f٩٩٣٧l0.size() == 1 && !g0()) {
            dVar = (p0() || s0()) ? d.RIGHT : d.LEFT;
        }
        d dVar2 = dVar;
        int i14 = 0;
        while (i14 < this.f٩٩٣٧l0.size()) {
            if (this.f٩٩٣٧l0.size() > 1) {
                if (i14 > 0) {
                    f14 = o1(((Float) this.f٩٩٣٧l0.get(i14 - 1)).floatValue());
                }
                f13 = o1(((Float) this.f٩٩٣٧l0.get(i14)).floatValue());
                if (p0() || s0()) {
                    f13 = f14;
                    f14 = f13;
                }
            }
            int trackCornerSize = getTrackCornerSize();
            int ordinal = dVar2.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        if (!g0()) {
                            i12 = this.I;
                            f14 += i12;
                        } else if (R[1] == 0.5f) {
                            f14 += this.I;
                        } else if (R[0] == 0.5f) {
                            i12 = this.I;
                        }
                    }
                } else {
                    f14 += this.I;
                    f13 += trackCornerSize;
                }
                f10 = f14;
                f11 = f13;
                if (f10 < f11) {
                    this.D0.setEmpty();
                } else {
                    RectF rectF = this.D0;
                    float f15 = i11;
                    int i15 = this.D;
                    rectF.set(f10, f15 - (i15 / 2.0f), f11, f15 + (i15 / 2.0f));
                    c1(canvas, this.f٩٩١٦b, this.D0, trackCornerSize, dVar2);
                }
                i14++;
                f14 = f10;
                f13 = f11;
            } else {
                f14 -= trackCornerSize;
                i12 = this.I;
            }
            f13 -= i12;
            f10 = f14;
            f11 = f13;
            if (f10 < f11) {
            }
            i14++;
            f14 = f10;
            f13 = f11;
        }
    }

    private Boolean E0(int i10, KeyEvent keyEvent) {
        if (i10 != 61) {
            if (i10 != 66) {
                if (i10 != 81) {
                    if (i10 != 69) {
                        if (i10 != 70) {
                            switch (i10) {
                                case 21:
                                    C0(-1);
                                    return Boolean.TRUE;
                                case 22:
                                    C0(1);
                                    return Boolean.TRUE;
                                case 23:
                                    break;
                                default:
                                    return null;
                            }
                        }
                    } else {
                        B0(-1);
                        return Boolean.TRUE;
                    }
                }
                B0(1);
                return Boolean.TRUE;
            }
            this.f٩٩٣٩m0 = this.f٩٩٤١n0;
            postInvalidate();
            return Boolean.TRUE;
        }
        if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(B0(1));
        }
        if (keyEvent.isShiftPressed()) {
            return Boolean.valueOf(B0(-1));
        }
        return Boolean.FALSE;
    }

    private void F(float f10, float f11, float f12, float f13, Canvas canvas, RectF rectF, d dVar) {
        if (f11 - f10 > getTrackCornerSize() - this.I) {
            rectF.set(f10, f12, f11, f13);
        } else {
            rectF.setEmpty();
        }
        c1(canvas, this.f٩٩١٤a, rectF, getTrackCornerSize(), dVar);
    }

    private void F0() {
        Iterator it = this.f٩٩٤٠n.iterator();
        if (!it.hasNext()) {
            return;
        }
        a0.a(it.next());
        throw null;
    }

    private void G(Canvas canvas, int i10, int i11) {
        float[] R = R();
        float f10 = i11;
        int i12 = this.D;
        float f11 = f10 - (i12 / 2.0f);
        float f12 = f10 + (i12 / 2.0f);
        float f13 = i10;
        F(this.E - getTrackCornerSize(), (this.E + (R[0] * f13)) - this.I, f11, f12, canvas, this.E0, d.LEFT);
        F(this.E + (R[1] * f13) + this.I, r0 + i10 + getTrackCornerSize(), f11, f12, canvas, this.F0, d.RIGHT);
    }

    private void G0() {
        Iterator it = this.f٩٩٤٠n.iterator();
        if (!it.hasNext()) {
            return;
        }
        a0.a(it.next());
        throw null;
    }

    private void H(Canvas canvas, float f10, float f11) {
        Iterator it = this.f٩٩٣٧l0.iterator();
        while (it.hasNext()) {
            float o12 = o1(((Float) it.next()).floatValue());
            float f12 = this.I + (this.F / 2.0f);
            if (f10 >= o12 - f12 && f10 <= o12 + f12) {
                return;
            }
        }
        if (s0()) {
            canvas.drawPoint(f11, f10, this.f٩٩٢٦g);
        } else {
            canvas.drawPoint(f10, f11, this.f٩٩٢٦g);
        }
    }

    private void I(Canvas canvas, int i10, int i11, float f10, Drawable drawable) {
        canvas.save();
        if (s0()) {
            canvas.concat(this.K0);
        }
        canvas.translate((this.E + ((int) (D0(f10) * i10))) - (drawable.getBounds().width() / 2.0f), i11 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private void I0(h8.a aVar, float f10) {
        r(aVar, f10);
        if (s0()) {
            RectF rectF = new RectF(this.H0);
            this.K0.mapRect(rectF);
            rectF.round(this.H0);
        }
        com.google.android.material.internal.d.c(k0.i(this), this, this.H0);
        aVar.setBounds(this.H0);
    }

    private void J(Canvas canvas, int i10, int i11) {
        for (int i12 = 0; i12 < this.f٩٩٣٧l0.size(); i12++) {
            float floatValue = ((Float) this.f٩٩٣٧l0.get(i12)).floatValue();
            Drawable drawable = this.M0;
            if (drawable != null) {
                I(canvas, i10, i11, floatValue, drawable);
            } else if (i12 < this.N0.size()) {
                I(canvas, i10, i11, floatValue, (Drawable) this.N0.get(i12));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle(this.E + (D0(floatValue) * i10), i11, getThumbRadius(), this.f٩٩١٨c);
                }
                I(canvas, i10, i11, floatValue, this.L0);
            }
        }
    }

    private void J0(Context context, AttributeSet attributeSet, int i10) {
        int i11;
        int x10;
        int i12;
        TypedArray i13 = h0.i(context, attributeSet, R.styleable.Slider, i10, W0, new int[0]);
        setOrientation(i13.getInt(R.styleable.Slider_android_orientation, 0));
        this.f٩٩٣٤k = i13.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip);
        this.f٩٩٣٣j0 = i13.getFloat(R.styleable.Slider_android_valueFrom, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٩٩٣٥k0 = i13.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.f٩٩٣٣j0));
        setCentered(i13.getBoolean(R.styleable.Slider_centered, false));
        this.f٩٩٤٣o0 = i13.getFloat(R.styleable.Slider_android_stepSize, DownloadProgress.UNKNOWN_PROGRESS);
        this.f٩٩٦٢y = (int) Math.ceil(i13.getDimension(R.styleable.Slider_minTouchTargetSize, c8.b.e(context)));
        int i14 = R.styleable.Slider_trackColor;
        boolean hasValue = i13.hasValue(i14);
        if (hasValue) {
            i11 = i14;
        } else {
            i11 = R.styleable.Slider_trackColorInactive;
        }
        if (!hasValue) {
            i14 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList a10 = c8.c.a(context, i13, i11);
        if (a10 == null) {
            a10 = r1.a.a(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(a10);
        ColorStateList a11 = c8.c.a(context, i13, i14);
        if (a11 == null) {
            a11 = r1.a.a(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(a11);
        this.L0.h0(c8.c.a(context, i13, R.styleable.Slider_thumbColor));
        int i15 = R.styleable.Slider_thumbStrokeColor;
        if (i13.hasValue(i15)) {
            setThumbStrokeColor(c8.c.a(context, i13, i15));
        }
        setThumbStrokeWidth(i13.getDimension(R.styleable.Slider_thumbStrokeWidth, DownloadProgress.UNKNOWN_PROGRESS));
        ColorStateList a12 = c8.c.a(context, i13, R.styleable.Slider_haloColor);
        if (a12 == null) {
            a12 = r1.a.a(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(a12);
        int i16 = R.styleable.Slider_tickVisibilityMode;
        if (i13.hasValue(i16)) {
            x10 = i13.getInt(i16, -1);
        } else {
            x10 = x(i13.getBoolean(R.styleable.Slider_tickVisible, true));
        }
        this.f٩٩٤٧q0 = x10;
        int i17 = R.styleable.Slider_tickColor;
        boolean hasValue2 = i13.hasValue(i17);
        if (hasValue2) {
            i12 = i17;
        } else {
            i12 = R.styleable.Slider_tickColorInactive;
        }
        if (!hasValue2) {
            i17 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList a13 = c8.c.a(context, i13, i12);
        if (a13 == null) {
            a13 = r1.a.a(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(a13);
        ColorStateList a14 = c8.c.a(context, i13, i17);
        if (a14 == null) {
            a14 = r1.a.a(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(a14);
        setThumbTrackGapSize(i13.getDimensionPixelSize(R.styleable.Slider_thumbTrackGapSize, 0));
        setTrackStopIndicatorSize(i13.getDimensionPixelSize(R.styleable.Slider_trackStopIndicatorSize, 0));
        setTrackCornerSize(i13.getDimensionPixelSize(R.styleable.Slider_trackCornerSize, -1));
        setTrackInsideCornerSize(i13.getDimensionPixelSize(R.styleable.Slider_trackInsideCornerSize, 0));
        setTrackIconActiveStart(c8.c.e(context, i13, R.styleable.Slider_trackIconActiveStart));
        setTrackIconActiveEnd(c8.c.e(context, i13, R.styleable.Slider_trackIconActiveEnd));
        setTrackIconActiveColor(c8.c.a(context, i13, R.styleable.Slider_trackIconActiveColor));
        setTrackIconInactiveStart(c8.c.e(context, i13, R.styleable.Slider_trackIconInactiveStart));
        setTrackIconInactiveEnd(c8.c.e(context, i13, R.styleable.Slider_trackIconInactiveEnd));
        setTrackIconInactiveColor(c8.c.a(context, i13, R.styleable.Slider_trackIconInactiveColor));
        setTrackIconSize(i13.getDimensionPixelSize(R.styleable.Slider_trackIconSize, 0));
        int dimensionPixelSize = i13.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0) * 2;
        int dimensionPixelSize2 = i13.getDimensionPixelSize(R.styleable.Slider_thumbWidth, dimensionPixelSize);
        int dimensionPixelSize3 = i13.getDimensionPixelSize(R.styleable.Slider_thumbHeight, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(i13.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(i13.getDimension(R.styleable.Slider_thumbElevation, DownloadProgress.UNKNOWN_PROGRESS));
        setTrackHeight(i13.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        setTickActiveRadius(i13.getDimensionPixelSize(R.styleable.Slider_tickRadiusActive, this.L / 2));
        setTickInactiveRadius(i13.getDimensionPixelSize(R.styleable.Slider_tickRadiusInactive, this.L / 2));
        setLabelBehavior(i13.getInt(R.styleable.Slider_labelBehavior, 0));
        if (!i13.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        i13.recycle();
    }

    private void K(int i10, int i11, Canvas canvas, Paint paint) {
        float f10;
        while (i10 < i11) {
            if (s0()) {
                f10 = this.f٩٩٤٥p0[i10 + 1];
            } else {
                f10 = this.f٩٩٤٥p0[i10];
            }
            if (!m0(f10) && (!g0() || !l0(f10))) {
                float[] fArr = this.f٩٩٤٥p0;
                canvas.drawPoint(fArr[i10], fArr[i10 + 1], paint);
            }
            i10 += 2;
        }
    }

    private void K0(int i10) {
        b bVar = this.f٩٩٣٢j;
        if (bVar == null) {
            this.f٩٩٣٢j = new b(this, null);
        } else {
            removeCallbacks(bVar);
        }
        this.f٩٩٣٢j.a(i10);
        postDelayed(this.f٩٩٣٢j, 200L);
    }

    private void L(Canvas canvas, RectF rectF, Drawable drawable) {
        if (s0()) {
            this.K0.mapRect(rectF);
        }
        rectF.round(this.J0);
        drawable.setBounds(this.J0);
        drawable.draw(canvas);
    }

    private void M(Canvas canvas, RectF rectF, RectF rectF2) {
        if (!d0()) {
            return;
        }
        if (this.f٩٩٣٧l0.size() > 1) {
            Log.w(V0, "Track icons can only be used when only 1 thumb is present.");
        }
        o(canvas, rectF, this.P, true);
        o(canvas, rectF2, this.U, true);
        o(canvas, rectF, this.R, false);
        o(canvas, rectF2, this.W, false);
    }

    private void M0(h8.a aVar, float f10) {
        aVar.O0(Q(f10));
        I0(aVar, f10);
        ViewOverlay V = V();
        if (V == null) {
            return;
        }
        V.add(aVar);
    }

    private void N() {
        if (!this.f٩٩٤٢o) {
            this.f٩٩٤٢o = true;
            ValueAnimator y10 = y(true);
            this.f٩٩٤٤p = y10;
            this.f٩٩٤٦q = null;
            y10.start();
        }
        Iterator it = this.f٩٩٣٦l.iterator();
        for (int i10 = 0; i10 < this.f٩٩٣٧l0.size() && it.hasNext(); i10++) {
            if (i10 != this.f٩٩٤١n0) {
                M0((h8.a) it.next(), ((Float) this.f٩٩٣٧l0.get(i10)).floatValue());
            }
        }
        if (it.hasNext()) {
            M0((h8.a) it.next(), ((Float) this.f٩٩٣٧l0.get(this.f٩٩٤١n0)).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.f٩٩٣٦l.size()), Integer.valueOf(this.f٩٩٣٧l0.size())));
    }

    private void N0(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.f٩٩٣٧l0.size() == arrayList.size() && this.f٩٩٣٧l0.equals(arrayList)) {
                return;
            }
            this.f٩٩٣٧l0 = arrayList;
            this.f٩٩٥٩w0 = true;
            this.f٩٩٤١n0 = 0;
            V0();
            z();
            D();
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private void O() {
        if (this.f٩٩٤٢o) {
            this.f٩٩٤٢o = false;
            ValueAnimator y10 = y(false);
            this.f٩٩٤٦q = y10;
            this.f٩٩٤٤p = null;
            y10.addListener(new a());
            this.f٩٩٤٦q.start();
        }
    }

    private boolean O0() {
        if (this.C == 3) {
            return true;
        }
        return false;
    }

    private void P(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 == 66) {
                        C0(Integer.MIN_VALUE);
                        return;
                    }
                    return;
                }
                C0(Integer.MAX_VALUE);
                return;
            }
            B0(Integer.MIN_VALUE);
            return;
        }
        B0(Integer.MAX_VALUE);
    }

    private boolean P0() {
        if (!this.f٩٩٥٥u0 && (getBackground() instanceof RippleDrawable)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Q(float f10) {
        String str;
        if (!c0()) {
            if (((int) f10) == f10) {
                str = "%.0f";
            } else {
                str = "%.2f";
            }
            return String.format(str, Float.valueOf(f10));
        }
        throw null;
    }

    private boolean Q0(float f10) {
        return S0(this.f٩٩٣٩m0, f10);
    }

    private float[] R() {
        float floatValue = ((Float) this.f٩٩٣٧l0.get(0)).floatValue();
        ArrayList arrayList = this.f٩٩٣٧l0;
        float floatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (this.f٩٩٣٧l0.size() == 1) {
            floatValue = this.f٩٩٣٣j0;
        }
        float D0 = D0(floatValue);
        float D02 = D0(floatValue2);
        if (g0()) {
            float min = Math.min(0.5f, D02);
            D02 = Math.max(0.5f, D02);
            D0 = min;
        }
        if (!g0() && (p0() || s0())) {
            return new float[]{D02, D0};
        }
        return new float[]{D0, D02};
    }

    private double R0(float f10) {
        float f11 = this.f٩٩٤٣o0;
        if (f11 > DownloadProgress.UNKNOWN_PROGRESS) {
            return Math.round(f10 * r0) / ((int) ((this.f٩٩٣٥k0 - this.f٩٩٣٣j0) / f11));
        }
        return f10;
    }

    private static float S(ValueAnimator valueAnimator, float f10) {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
            return floatValue;
        }
        return f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S0(int i10, float f10) {
        this.f٩٩٤١n0 = i10;
        if (Math.abs(f10 - ((Float) this.f٩٩٣٧l0.get(i10)).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.f٩٩٣٧l0.set(i10, Float.valueOf(T(i10, f10)));
        C(i10);
        return true;
    }

    private float T(int i10, float f10) {
        float floatValue;
        float floatValue2;
        float minSeparation = getMinSeparation();
        if (this.P0 == 0) {
            minSeparation = B(minSeparation);
        }
        if (p0() || s0()) {
            minSeparation = -minSeparation;
        }
        int i11 = i10 + 1;
        if (i11 >= this.f٩٩٣٧l0.size()) {
            floatValue = this.f٩٩٣٥k0;
        } else {
            floatValue = ((Float) this.f٩٩٣٧l0.get(i11)).floatValue() - minSeparation;
        }
        int i12 = i10 - 1;
        if (i12 < 0) {
            floatValue2 = this.f٩٩٣٣j0;
        } else {
            floatValue2 = ((Float) this.f٩٩٣٧l0.get(i12)).floatValue() + minSeparation;
        }
        return j2.a.a(f10, floatValue2, floatValue);
    }

    private boolean T0() {
        return Q0(Z());
    }

    private int U(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewOverlay V() {
        ViewGroup i10 = k0.i(this);
        if (i10 == null) {
            return null;
        }
        return i10.getOverlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        if (!P0() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                float D0 = (D0(((Float) this.f٩٩٣٧l0.get(this.f٩٩٤١n0)).floatValue()) * this.f٩٩٥٣t0) + this.E;
                int v10 = v();
                int i10 = this.H;
                float[] fArr = {D0 - i10, v10 - i10, D0 + i10, v10 + i10};
                if (s0()) {
                    this.K0.mapPoints(fArr);
                }
                background.setHotspotBounds((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
            }
        }
    }

    private float[] W(float f10, float f11) {
        if (s0()) {
            return new float[]{f10, f10, f10, f10, f11, f11, f11, f11};
        }
        return new float[]{f10, f10, f11, f11, f11, f11, f10, f10};
    }

    private void W0() {
        float f10;
        boolean s02 = s0();
        boolean p02 = p0();
        float f11 = 0.5f;
        if (s02 && p02) {
            f10 = 0.5f;
            f11 = -0.2f;
        } else {
            f10 = 1.2f;
            if (s02) {
                f10 = 0.5f;
                f11 = 1.2f;
            }
        }
        Iterator it = this.f٩٩٣٦l.iterator();
        while (it.hasNext()) {
            ((h8.a) it.next()).L0(f11, f10);
        }
    }

    private int X() {
        return (int) (((this.f٩٩٣٥k0 - this.f٩٩٣٣j0) / this.f٩٩٤٣o0) + 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        W0();
        int i10 = this.C;
        if (i10 != 0 && i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    if (isEnabled() && q0()) {
                        N();
                        return;
                    } else {
                        O();
                        return;
                    }
                }
                throw new IllegalArgumentException("Unexpected labelBehavior: " + this.C);
            }
            O();
            return;
        }
        if (this.f٩٩٣٩m0 != -1 && isEnabled()) {
            N();
        } else {
            O();
        }
    }

    private int Y() {
        return (this.f٩٩٥٣t0 / this.f٩٩٦٠x) + 1;
    }

    private void Y0() {
        float v10 = v();
        this.K0.reset();
        this.K0.setRotate(90.0f, v10, v10);
    }

    private float Z() {
        double R0 = R0(this.O0);
        if (p0() || s0()) {
            R0 = 1.0d - R0;
        }
        float f10 = this.f٩٩٣٥k0;
        return (float) ((R0 * (f10 - r3)) + this.f٩٩٣٣j0);
    }

    private void Z0() {
        if (b0()) {
            int i10 = this.F;
            this.J = i10;
            this.K = this.I;
            int round = Math.round(i10 * 0.5f);
            int i11 = this.F - round;
            setThumbWidth(round);
            setThumbTrackGapSize(this.I - (i11 / 2));
        }
    }

    private float a0() {
        float f10 = this.O0;
        if (p0() || s0()) {
            f10 = 1.0f - f10;
        }
        float f11 = this.f٩٩٣٥k0;
        float f12 = this.f٩٩٣٣j0;
        return (f10 * (f11 - f12)) + f12;
    }

    private void a1() {
        j1();
        int i10 = 0;
        if (this.f٩٩٤٣o0 <= DownloadProgress.UNKNOWN_PROGRESS) {
            b1(0);
            return;
        }
        int i11 = this.f٩٩٤٧q0;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("Unexpected tickVisibilityMode: " + this.f٩٩٤٧q0);
                }
            } else {
                int X = X();
                if (X <= Y()) {
                    i10 = X;
                }
            }
        } else {
            i10 = Math.min(X(), Y());
        }
        b1(i10);
    }

    private boolean b0() {
        if (this.I > 0) {
            return true;
        }
        return false;
    }

    private void b1(int i10) {
        if (i10 == 0) {
            this.f٩٩٤٥p0 = null;
            return;
        }
        float[] fArr = this.f٩٩٤٥p0;
        if (fArr == null || fArr.length != i10 * 2) {
            this.f٩٩٤٥p0 = new float[i10 * 2];
        }
        float f10 = this.f٩٩٥٣t0 / (i10 - 1);
        float v10 = v();
        for (int i11 = 0; i11 < i10 * 2; i11 += 2) {
            float[] fArr2 = this.f٩٩٤٥p0;
            fArr2[i11] = this.E + ((i11 / 2.0f) * f10);
            fArr2[i11 + 1] = v10;
        }
        if (s0()) {
            this.K0.mapPoints(this.f٩٩٤٥p0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c1(Canvas canvas, Paint paint, RectF rectF, float f10, d dVar) {
        int i10;
        if (rectF.isEmpty()) {
            return;
        }
        float s10 = s(f10);
        float p10 = p(f10);
        int ordinal = dVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    i10 = this.N;
                    s10 = i10;
                }
            } else {
                s10 = this.N;
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeCap(Paint.Cap.BUTT);
            if (b0()) {
                paint.setAntiAlias(true);
            }
            RectF rectF2 = new RectF(rectF);
            if (s0()) {
                this.K0.mapRect(rectF2);
            }
            this.C0.reset();
            if (rectF.width() < s10 + p10) {
                this.C0.addRoundRect(rectF2, W(s10, p10), Path.Direction.CW);
                canvas.drawPath(this.C0, paint);
                return;
            }
            float min = Math.min(s10, p10);
            float max = Math.max(s10, p10);
            canvas.save();
            this.C0.addRoundRect(rectF2, min, min, Path.Direction.CW);
            canvas.clipPath(this.C0);
            int ordinal2 = dVar.ordinal();
            if (ordinal2 != 1) {
                if (ordinal2 != 2) {
                    this.G0.set(rectF.centerX() - max, rectF.top, rectF.centerX() + max, rectF.bottom);
                } else {
                    RectF rectF3 = this.G0;
                    float f11 = rectF.right;
                    rectF3.set(f11 - (2.0f * max), rectF.top, f11, rectF.bottom);
                }
            } else {
                RectF rectF4 = this.G0;
                float f12 = rectF.left;
                rectF4.set(f12, rectF.top, (2.0f * max) + f12, rectF.bottom);
            }
            if (s0()) {
                this.K0.mapRect(this.G0);
            }
            canvas.drawRoundRect(this.G0, max, max, paint);
            canvas.restore();
            return;
        }
        i10 = this.N;
        p10 = i10;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.BUTT);
        if (b0()) {
        }
        RectF rectF22 = new RectF(rectF);
        if (s0()) {
        }
        this.C0.reset();
        if (rectF.width() < s10 + p10) {
        }
    }

    private boolean d0() {
        if (this.P == null && this.R == null && this.U == null && this.W == null) {
            return false;
        }
        return true;
    }

    private void d1() {
        Drawable drawable = this.R;
        if (drawable != null) {
            if (!this.S && this.T != null) {
                this.R = h2.b.r(drawable).mutate();
                this.S = true;
            }
            if (this.S) {
                this.R.setTintList(this.T);
            }
        }
    }

    private Drawable e0(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        m(newDrawable);
        return newDrawable;
    }

    private void e1() {
        Drawable drawable = this.P;
        if (drawable != null) {
            if (!this.Q && this.T != null) {
                this.P = h2.b.r(drawable).mutate();
                this.Q = true;
            }
            if (this.Q) {
                this.P.setTintList(this.T);
            }
        }
    }

    private void f0() {
        this.f٩٩١٤a.setStrokeWidth(this.D);
        this.f٩٩١٦b.setStrokeWidth(this.D);
    }

    private void f1() {
        Drawable drawable = this.W;
        if (drawable != null) {
            if (!this.f٩٩١٥a0 && this.f٩٩١٧b0 != null) {
                this.W = h2.b.r(drawable).mutate();
                this.f٩٩١٥a0 = true;
            }
            if (this.f٩٩١٥a0) {
                this.W.setTintList(this.f٩٩١٧b0);
            }
        }
    }

    private void g1() {
        Drawable drawable = this.U;
        if (drawable != null) {
            if (!this.V && this.f٩٩١٧b0 != null) {
                this.U = h2.b.r(drawable).mutate();
                this.V = true;
            }
            if (this.V) {
                this.U.setTintList(this.f٩٩١٧b0);
            }
        }
    }

    private boolean h0() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollHorizontally(1) || viewGroup.canScrollHorizontally(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private void h1(int i10) {
        this.f٩٩٥٣t0 = Math.max(i10 - (this.E * 2), 0);
        a1();
    }

    private boolean i0() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private void i1(boolean z10) {
        boolean A0 = A0();
        boolean z02 = z0();
        if (s0()) {
            Y0();
        }
        if (!A0 && !z10) {
            if (z02) {
                postInvalidate();
                return;
            }
            return;
        }
        requestLayout();
    }

    private static boolean j0(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            return false;
        }
        return true;
    }

    private void j1() {
        if (this.f٩٩٥٩w0) {
            m1();
            l1();
            k1();
            p1();
            this.f٩٩٥٩w0 = false;
        }
    }

    private boolean k0(double d10) {
        if (Math.abs(Math.round(r4) - new BigDecimal(Double.toString(d10)).divide(new BigDecimal(Float.toString(this.f٩٩٤٣o0)), MathContext.DECIMAL64).doubleValue()) < 1.0E-4d) {
            return true;
        }
        return false;
    }

    private void k1() {
        float minSeparation = getMinSeparation();
        if (minSeparation >= DownloadProgress.UNKNOWN_PROGRESS) {
            float f10 = this.f٩٩٤٣o0;
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS && minSeparation > DownloadProgress.UNKNOWN_PROGRESS) {
                if (this.P0 == 1) {
                    if (minSeparation < f10 || !k0(minSeparation)) {
                        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.f٩٩٤٣o0), Float.valueOf(this.f٩٩٤٣o0)));
                    }
                    return;
                }
                throw new IllegalStateException(String.format("minSeparation(%s) cannot be set as a dimension when using stepSize(%s)", Float.valueOf(minSeparation), Float.valueOf(this.f٩٩٤٣o0)));
            }
            return;
        }
        throw new IllegalStateException(String.format("minSeparation(%s) must be greater or equal to 0", Float.valueOf(minSeparation)));
    }

    private boolean l0(float f10) {
        float f11 = this.I + (this.F / 2.0f);
        float f12 = (this.f٩٩٥٣t0 + (this.E * 2)) / 2.0f;
        if (f10 >= f12 - f11 && f10 <= f12 + f11) {
            return true;
        }
        return false;
    }

    private void l1() {
        if (this.f٩٩٤٣o0 > DownloadProgress.UNKNOWN_PROGRESS && !n1(this.f٩٩٣٥k0)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(this.f٩٩٤٣o0), Float.valueOf(this.f٩٩٣٣j0), Float.valueOf(this.f٩٩٣٥k0)));
        }
    }

    private void m(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.F, this.G);
        } else {
            float max = Math.max(this.F, this.G) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
        }
    }

    private boolean m0(float f10) {
        float f11 = this.I + (this.F / 2.0f);
        Iterator it = this.f٩٩٣٧l0.iterator();
        if (!it.hasNext()) {
            return false;
        }
        float o12 = o1(((Float) it.next()).floatValue());
        if (f10 < o12 - f11 || f10 > o12 + f11) {
            return false;
        }
        return true;
    }

    private void m1() {
        if (this.f٩٩٣٣j0 < this.f٩٩٣٥k0) {
            Iterator it = this.f٩٩٣٧l0.iterator();
            while (it.hasNext()) {
                Float f10 = (Float) it.next();
                if (f10.floatValue() >= this.f٩٩٣٣j0 && f10.floatValue() <= this.f٩٩٣٥k0) {
                    if (this.f٩٩٤٣o0 > DownloadProgress.UNKNOWN_PROGRESS && !n1(f10.floatValue())) {
                        throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", f10, Float.valueOf(this.f٩٩٣٣j0), Float.valueOf(this.f٩٩٤٣o0), Float.valueOf(this.f٩٩٤٣o0)));
                    }
                } else {
                    throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", f10, Float.valueOf(this.f٩٩٣٣j0), Float.valueOf(this.f٩٩٣٥k0)));
                }
            }
            return;
        }
        throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", Float.valueOf(this.f٩٩٣٣j0), Float.valueOf(this.f٩٩٣٥k0)));
    }

    private void n(h8.a aVar) {
        aVar.M0(k0.i(this));
    }

    private boolean n0(MotionEvent motionEvent) {
        if (!j0(motionEvent) && h0()) {
            return true;
        }
        return false;
    }

    private boolean n1(float f10) {
        return k0(new BigDecimal(Float.toString(f10)).subtract(new BigDecimal(Float.toString(this.f٩٩٣٣j0)), MathContext.DECIMAL64).doubleValue());
    }

    private void o(Canvas canvas, RectF rectF, Drawable drawable, boolean z10) {
        if (drawable != null) {
            w(rectF, this.I0, this.f٩٩١٩c0, this.f٩٩٢١d0, z10);
            if (!this.I0.isEmpty()) {
                L(canvas, this.I0, drawable);
            }
        }
    }

    private boolean o0(MotionEvent motionEvent) {
        if (!j0(motionEvent) && i0()) {
            return true;
        }
        return false;
    }

    private float o1(float f10) {
        return (D0(f10) * this.f٩٩٥٣t0) + this.E;
    }

    private float p(float f10) {
        int i10;
        if (!this.f٩٩٣٧l0.isEmpty() && b0()) {
            if (!p0() && !s0()) {
                i10 = this.f٩٩٣٧l0.size() - 1;
            } else {
                i10 = 0;
            }
            float o12 = o1(((Float) this.f٩٩٣٧l0.get(i10)).floatValue()) - this.E;
            int i11 = this.f٩٩٥٣t0;
            if (o12 > i11 - f10) {
                return Math.max(i11 - o12, this.N);
            }
            return f10;
        }
        return f10;
    }

    private void p1() {
        float f10 = this.f٩٩٤٣o0;
        if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        if (((int) f10) != f10) {
            Log.w(V0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "stepSize", Float.valueOf(f10)));
        }
        float f11 = this.f٩٩٣٣j0;
        if (((int) f11) != f11) {
            Log.w(V0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueFrom", Float.valueOf(f11)));
        }
        float f12 = this.f٩٩٣٥k0;
        if (((int) f12) != f12) {
            Log.w(V0, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.", "valueTo", Float.valueOf(f12)));
        }
    }

    private Float q(int i10) {
        float t10;
        if (this.f٩٩٥٧v0) {
            t10 = u(20);
        } else {
            t10 = t();
        }
        if (i10 != 69) {
            if (i10 != 70 && i10 != 81) {
                switch (i10) {
                    case 19:
                        if (!s0()) {
                            return null;
                        }
                        return Float.valueOf(t10);
                    case 20:
                        if (!s0()) {
                            return null;
                        }
                        return Float.valueOf(-t10);
                    case 21:
                        if (!p0()) {
                            t10 = -t10;
                        }
                        return Float.valueOf(t10);
                    case 22:
                        if (p0()) {
                            t10 = -t10;
                        }
                        return Float.valueOf(t10);
                    default:
                        return null;
                }
            }
            return Float.valueOf(t10);
        }
        return Float.valueOf(-t10);
    }

    private boolean q0() {
        Rect rect = new Rect();
        k0.i(this).getHitRect(rect);
        if (getLocalVisibleRect(rect) && r0()) {
            return true;
        }
        return false;
    }

    private void r(h8.a aVar, float f10) {
        int D0;
        int intrinsicWidth;
        int v10;
        int intrinsicHeight;
        int i10;
        if (s0()) {
            D0 = (this.E + ((int) (D0(f10) * this.f٩٩٥٣t0))) - (aVar.getIntrinsicHeight() / 2);
            intrinsicWidth = aVar.getIntrinsicHeight() + D0;
            if (p0()) {
                v10 = v() - (this.f٩٩٢٣e0 + (this.G / 2));
                intrinsicHeight = aVar.getIntrinsicWidth();
            } else {
                int v11 = v() + this.f٩٩٢٣e0 + (this.G / 2);
                v10 = aVar.getIntrinsicWidth() + v11;
                i10 = v11;
                this.H0.set(D0, i10, intrinsicWidth, v10);
            }
        } else {
            D0 = (this.E + ((int) (D0(f10) * this.f٩٩٥٣t0))) - (aVar.getIntrinsicWidth() / 2);
            intrinsicWidth = aVar.getIntrinsicWidth() + D0;
            v10 = v() - (this.f٩٩٢٣e0 + (this.G / 2));
            intrinsicHeight = aVar.getIntrinsicHeight();
        }
        i10 = v10 - intrinsicHeight;
        this.H0.set(D0, i10, intrinsicWidth, v10);
    }

    private boolean r0() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.U0;
        }
        return isShown();
    }

    private float s(float f10) {
        int size;
        if (!this.f٩٩٣٧l0.isEmpty() && b0()) {
            if (!p0() && !s0()) {
                size = 0;
            } else {
                size = this.f٩٩٣٧l0.size() - 1;
            }
            float o12 = o1(((Float) this.f٩٩٣٧l0.get(size)).floatValue()) - this.E;
            if (o12 < f10) {
                return Math.max(o12, this.N);
            }
            return f10;
        }
        return f10;
    }

    private float t() {
        float f10 = this.f٩٩٤٣o0;
        if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
            return 1.0f;
        }
        return f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator it = this.f٩٩٣٦l.iterator();
        while (it.hasNext()) {
            ((h8.a) it.next()).N0(floatValue);
        }
        postInvalidateOnAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float u(int i10) {
        float t10 = t();
        if ((this.f٩٩٣٥k0 - this.f٩٩٣٣j0) / t10 <= i10) {
            return t10;
        }
        return Math.round(r1 / r4) * t10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0() {
        setActiveThumbIndex(-1);
        invalidate();
    }

    private int v() {
        int i10 = this.f٩٩١٣B / 2;
        int i11 = 0;
        if (this.C == 1 || O0()) {
            i11 = ((h8.a) this.f٩٩٣٦l.get(0)).getIntrinsicHeight();
        }
        return i10 + i11;
    }

    private void v0(Resources resources) {
        this.A = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.f٩٩٥٠s = dimensionPixelOffset;
        this.E = dimensionPixelOffset;
        this.f٩٩٥٢t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.f٩٩٥٤u = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        int i10 = R.dimen.mtrl_slider_tick_radius;
        this.f٩٩٥٦v = resources.getDimensionPixelSize(i10);
        this.f٩٩٥٨w = resources.getDimensionPixelSize(i10);
        this.f٩٩٦٠x = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_min_spacing);
        this.f٩٩٢٣e0 = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        this.f٩٩٢١d0 = resources.getDimensionPixelOffset(R.dimen.m3_slider_track_icon_padding);
    }

    private void w(RectF rectF, RectF rectF2, int i10, int i11, boolean z10) {
        boolean z11;
        float f10;
        if (rectF.right - rectF.left >= (i11 * 2) + i10) {
            if (!p0() && !s0()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z10 ^ z11) {
                f10 = rectF.left + i11;
            } else {
                f10 = (rectF.right - i11) - i10;
            }
            float f11 = i10;
            float v10 = v() - (f11 / 2.0f);
            rectF2.set(f10, v10, f10 + f11, f11 + v10);
            return;
        }
        rectF2.setEmpty();
    }

    private void w0(Canvas canvas, int i10, int i11) {
        if (P0()) {
            float[] fArr = {this.E + (D0(((Float) this.f٩٩٣٧l0.get(this.f٩٩٤١n0)).floatValue()) * i10), i11};
            if (s0()) {
                this.K0.mapPoints(fArr);
            }
            if (Build.VERSION.SDK_INT < 28) {
                float f10 = fArr[0];
                int i12 = this.H;
                float f11 = fArr[1];
                canvas.clipRect(f10 - i12, f11 - i12, f10 + i12, f11 + i12, Region.Op.UNION);
            }
            canvas.drawCircle(fArr[0], fArr[1], this.H, this.f٩٩٢٠d);
        }
    }

    private int x(boolean z10) {
        return z10 ? 0 : 2;
    }

    private void x0(Canvas canvas, int i10) {
        if (this.L > 0 && !this.f٩٩٣٧l0.isEmpty()) {
            ArrayList arrayList = this.f٩٩٣٧l0;
            float floatValue = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
            float f10 = this.f٩٩٣٥k0;
            if (floatValue < f10) {
                H(canvas, o1(f10), i10);
            }
            if (g0() || (this.f٩٩٣٧l0.size() > 1 && ((Float) this.f٩٩٣٧l0.get(0)).floatValue() > this.f٩٩٣٣j0)) {
                H(canvas, o1(this.f٩٩٣٣j0), i10);
            }
        }
    }

    private ValueAnimator y(boolean z10) {
        float f10;
        ValueAnimator valueAnimator;
        int f11;
        TimeInterpolator g10;
        float f12 = 1.0f;
        if (z10) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f10 = 1.0f;
        }
        if (z10) {
            valueAnimator = this.f٩٩٤٦q;
        } else {
            valueAnimator = this.f٩٩٤٤p;
        }
        float S = S(valueAnimator, f10);
        if (!z10) {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(S, f12);
        if (z10) {
            f11 = k.f(getContext(), X0, 83);
            g10 = k.g(getContext(), Z0, p7.a.f١٦٩٥١e);
        } else {
            f11 = k.f(getContext(), Y0, 117);
            g10 = k.g(getContext(), f٩٩١٢a1, p7.a.f١٦٩٤٩c);
        }
        ofFloat.setDuration(f11);
        ofFloat.setInterpolator(g10);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.slider.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                BaseSlider.this.t0(valueAnimator2);
            }
        });
        return ofFloat;
    }

    private void y0(Canvas canvas) {
        float[] fArr = this.f٩٩٤٥p0;
        if (fArr != null && fArr.length != 0) {
            float[] R = R();
            int ceil = (int) Math.ceil(R[0] * ((this.f٩٩٤٥p0.length / 2.0f) - 1.0f));
            int floor = (int) Math.floor(R[1] * ((this.f٩٩٤٥p0.length / 2.0f) - 1.0f));
            if (ceil > 0) {
                K(0, ceil * 2, canvas, this.f٩٩٢٢e);
            }
            if (ceil <= floor) {
                K(ceil * 2, (floor + 1) * 2, canvas, this.f٩٩٢٤f);
            }
            int i10 = (floor + 1) * 2;
            float[] fArr2 = this.f٩٩٤٥p0;
            if (i10 < fArr2.length) {
                K(i10, fArr2.length, canvas, this.f٩٩٢٢e);
            }
        }
    }

    private void z() {
        int i10;
        if (this.f٩٩٣٦l.size() > this.f٩٩٣٧l0.size()) {
            List<h8.a> subList = this.f٩٩٣٦l.subList(this.f٩٩٣٧l0.size(), this.f٩٩٣٦l.size());
            for (h8.a aVar : subList) {
                if (isAttachedToWindow()) {
                    A(aVar);
                }
            }
            subList.clear();
        }
        while (true) {
            i10 = 0;
            if (this.f٩٩٣٦l.size() >= this.f٩٩٣٧l0.size()) {
                break;
            }
            h8.a F0 = h8.a.F0(getContext(), null, 0, this.f٩٩٣٤k);
            this.f٩٩٣٦l.add(F0);
            if (isAttachedToWindow()) {
                n(F0);
            }
        }
        if (this.f٩٩٣٦l.size() != 1) {
            i10 = 1;
        }
        Iterator it = this.f٩٩٣٦l.iterator();
        while (it.hasNext()) {
            ((h8.a) it.next()).u0(i10);
        }
    }

    private boolean z0() {
        int width;
        int max = this.f٩٩٥٠s + Math.max(Math.max(Math.max((this.F / 2) - this.f٩٩٥٢t, 0), Math.max((this.D - this.f٩٩٥٤u) / 2, 0)), Math.max(Math.max(this.f٩٩٤٩r0 - this.f٩٩٥٦v, 0), Math.max(this.f٩٩٥١s0 - this.f٩٩٥٨w, 0)));
        if (this.E == max) {
            return false;
        }
        this.E = max;
        if (isLaidOut()) {
            if (s0()) {
                width = getHeight();
            } else {
                width = getWidth();
            }
            h1(width);
            return true;
        }
        return true;
    }

    protected boolean H0() {
        boolean z10;
        if (this.f٩٩٣٩m0 != -1) {
            return true;
        }
        float a02 = a0();
        float o12 = o1(a02);
        this.f٩٩٣٩m0 = 0;
        float abs = Math.abs(((Float) this.f٩٩٣٧l0.get(0)).floatValue() - a02);
        for (int i10 = 1; i10 < this.f٩٩٣٧l0.size(); i10++) {
            float abs2 = Math.abs(((Float) this.f٩٩٣٧l0.get(i10)).floatValue() - a02);
            float o13 = o1(((Float) this.f٩٩٣٧l0.get(i10)).floatValue());
            if (Float.compare(abs2, abs) > 0) {
                break;
            }
            if (p0() || s0() ? o13 - o12 > DownloadProgress.UNKNOWN_PROGRESS : o13 - o12 < DownloadProgress.UNKNOWN_PROGRESS) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (Float.compare(abs2, abs) < 0) {
                this.f٩٩٣٩m0 = i10;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else {
                    if (Math.abs(o13 - o12) < this.f٩٩٤٨r) {
                        this.f٩٩٣٩m0 = -1;
                        return false;
                    }
                    if (z10) {
                        this.f٩٩٣٩m0 = i10;
                    }
                }
            }
            abs = abs2;
        }
        if (this.f٩٩٣٩m0 != -1) {
            return true;
        }
        return false;
    }

    public void L0() {
        removeCallbacks(this.T0);
        postDelayed(this.T0, this.Q0);
    }

    void U0(int i10, Rect rect) {
        int D0 = this.E + ((int) (D0(getValues().get(i10).floatValue()) * this.f٩٩٥٣t0));
        int v10 = v();
        int max = Math.max(this.F / 2, this.f٩٩٦٢y / 2);
        int max2 = Math.max(this.G / 2, this.f٩٩٦٢y / 2);
        RectF rectF = new RectF(D0 - max, v10 - max2, D0 + max, v10 + max2);
        if (s0()) {
            this.K0.mapRect(rectF);
        }
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public void addOnChangeListener(L l10) {
        this.f٩٩٣٨m.add(l10);
    }

    public void addOnSliderTouchListener(T t10) {
        this.f٩٩٤٠n.add(t10);
    }

    public boolean c0() {
        return false;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.f٩٩٢٨h.k(motionEvent) && !super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f٩٩١٤a.setColor(U(this.B0));
        this.f٩٩١٦b.setColor(U(this.A0));
        this.f٩٩٢٢e.setColor(U(this.f٩٩٦٥z0));
        this.f٩٩٢٤f.setColor(U(this.f٩٩٦٣y0));
        this.f٩٩٢٦g.setColor(U(this.f٩٩٦٥z0));
        for (h8.a aVar : this.f٩٩٣٦l) {
            if (aVar.isStateful()) {
                aVar.setState(getDrawableState());
            }
        }
        if (this.L0.isStateful()) {
            this.L0.setState(getDrawableState());
        }
        this.f٩٩٢٠d.setColor(U(this.f٩٩٦١x0));
        this.f٩٩٢٠d.setAlpha(63);
    }

    public boolean g0() {
        return this.O;
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    final int getAccessibilityFocusedVirtualViewId() {
        return this.f٩٩٢٨h.m();
    }

    public int getActiveThumbIndex() {
        return this.f٩٩٣٩m0;
    }

    public int getFocusedThumbIndex() {
        return this.f٩٩٤١n0;
    }

    public int getHaloRadius() {
        return this.H;
    }

    public ColorStateList getHaloTintList() {
        return this.f٩٩٦١x0;
    }

    public int getLabelBehavior() {
        return this.C;
    }

    protected float getMinSeparation() {
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public float getStepSize() {
        return this.f٩٩٤٣o0;
    }

    public float getThumbElevation() {
        return this.L0.C();
    }

    public int getThumbHeight() {
        return this.G;
    }

    public int getThumbRadius() {
        return this.F / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.L0.K();
    }

    public float getThumbStrokeWidth() {
        return this.L0.M();
    }

    public ColorStateList getThumbTintList() {
        return this.L0.D();
    }

    public int getThumbTrackGapSize() {
        return this.I;
    }

    public int getThumbWidth() {
        return this.F;
    }

    public int getTickActiveRadius() {
        return this.f٩٩٤٩r0;
    }

    public ColorStateList getTickActiveTintList() {
        return this.f٩٩٦٣y0;
    }

    public int getTickInactiveRadius() {
        return this.f٩٩٥١s0;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.f٩٩٦٥z0;
    }

    public ColorStateList getTickTintList() {
        if (this.f٩٩٦٥z0.equals(this.f٩٩٦٣y0)) {
            return this.f٩٩٦٣y0;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public int getTickVisibilityMode() {
        return this.f٩٩٤٧q0;
    }

    public ColorStateList getTrackActiveTintList() {
        return this.A0;
    }

    public int getTrackCornerSize() {
        int i10 = this.M;
        if (i10 == -1) {
            return this.D / 2;
        }
        return i10;
    }

    public int getTrackHeight() {
        return this.D;
    }

    public ColorStateList getTrackIconActiveColor() {
        return this.T;
    }

    public Drawable getTrackIconActiveEnd() {
        return this.R;
    }

    public Drawable getTrackIconActiveStart() {
        return this.P;
    }

    public ColorStateList getTrackIconInactiveColor() {
        return this.f٩٩١٧b0;
    }

    public Drawable getTrackIconInactiveEnd() {
        return this.W;
    }

    public Drawable getTrackIconInactiveStart() {
        return this.U;
    }

    public int getTrackIconSize() {
        return this.f٩٩١٩c0;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.B0;
    }

    public int getTrackInsideCornerSize() {
        return this.N;
    }

    public int getTrackSidePadding() {
        return this.E;
    }

    public int getTrackStopIndicatorSize() {
        return this.L;
    }

    public ColorStateList getTrackTintList() {
        if (this.B0.equals(this.A0)) {
            return this.A0;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.f٩٩٥٣t0;
    }

    public float getValueFrom() {
        return this.f٩٩٣٣j0;
    }

    public float getValueTo() {
        return this.f٩٩٣٥k0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Float> getValues() {
        return new ArrayList(this.f٩٩٣٧l0);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U0 = isShown();
        getViewTreeObserver().addOnScrollChangedListener(this.R0);
        getViewTreeObserver().addOnGlobalLayoutListener(this.S0);
        Iterator it = this.f٩٩٣٦l.iterator();
        while (it.hasNext()) {
            n((h8.a) it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        b bVar = this.f٩٩٣٢j;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        this.f٩٩٤٢o = false;
        Iterator it = this.f٩٩٣٦l.iterator();
        while (it.hasNext()) {
            A((h8.a) it.next());
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.R0);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.S0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f٩٩٥٩w0) {
            j1();
            a1();
        }
        super.onDraw(canvas);
        int v10 = v();
        G(canvas, this.f٩٩٥٣t0, v10);
        E(canvas, this.f٩٩٥٣t0, v10);
        if (!p0() && !s0()) {
            M(canvas, this.D0, this.F0);
        } else {
            M(canvas, this.D0, this.E0);
        }
        y0(canvas);
        x0(canvas, v10);
        if ((this.f٩٩٣١i0 || isFocused()) && isEnabled()) {
            w0(canvas, this.f٩٩٥٣t0, v10);
        }
        X0();
        J(canvas, this.f٩٩٥٣t0, v10);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (!z10) {
            this.f٩٩٣٩m0 = -1;
            this.f٩٩٢٨h.d(this.f٩٩٤١n0);
        } else {
            P(i10);
            this.f٩٩٢٨h.K(this.f٩٩٤١n0);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(false);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i10, keyEvent);
        }
        if (this.f٩٩٣٧l0.size() == 1) {
            this.f٩٩٣٩m0 = 0;
        }
        if (this.f٩٩٣٩m0 == -1) {
            Boolean E0 = E0(i10, keyEvent);
            if (E0 != null) {
                return E0.booleanValue();
            }
            return super.onKeyDown(i10, keyEvent);
        }
        this.f٩٩٥٧v0 |= keyEvent.isLongPress();
        Float q10 = q(i10);
        if (q10 != null) {
            if (Q0(((Float) this.f٩٩٣٧l0.get(this.f٩٩٣٩m0)).floatValue() + q10.floatValue())) {
                V0();
                postInvalidate();
            }
            return true;
        }
        if (i10 != 23) {
            if (i10 != 61) {
                if (i10 != 66) {
                    return super.onKeyDown(i10, keyEvent);
                }
            } else {
                if (keyEvent.hasNoModifiers()) {
                    return B0(1);
                }
                if (!keyEvent.isShiftPressed()) {
                    return false;
                }
                return B0(-1);
            }
        }
        this.f٩٩٣٩m0 = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        this.f٩٩٥٧v0 = false;
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12 = 0;
        if (this.C == 1 || O0()) {
            i12 = ((h8.a) this.f٩٩٣٦l.get(0)).getIntrinsicHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f٩٩١٣B + i12, 1073741824);
        if (s0()) {
            super.onMeasure(makeMeasureSpec, i11);
        } else {
            super.onMeasure(i10, makeMeasureSpec);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.f٩٩٣٣j0 = sliderState.f٩٩٦٦a;
        this.f٩٩٣٥k0 = sliderState.f٩٩٦٧b;
        N0(sliderState.f٩٩٦٨c);
        this.f٩٩٤٣o0 = sliderState.f٩٩٦٩d;
        if (sliderState.f٩٩٧٠e) {
            requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f٩٩٦٦a = this.f٩٩٣٣j0;
        sliderState.f٩٩٦٧b = this.f٩٩٣٥k0;
        sliderState.f٩٩٦٨c = new ArrayList(this.f٩٩٣٧l0);
        sliderState.f٩٩٦٩d = this.f٩٩٤٣o0;
        sliderState.f٩٩٧٠e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        if (s0()) {
            i10 = i11;
        }
        h1(i10);
        V0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        if (r3 != 3) goto L٧٨;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x10;
        float y10;
        int i10;
        if (!isEnabled()) {
            return false;
        }
        if (s0()) {
            x10 = motionEvent.getY();
        } else {
            x10 = motionEvent.getX();
        }
        if (s0()) {
            y10 = motionEvent.getX();
        } else {
            y10 = motionEvent.getY();
        }
        float f10 = (x10 - this.E) / this.f٩٩٥٣t0;
        this.O0 = f10;
        float max = Math.max(DownloadProgress.UNKNOWN_PROGRESS, f10);
        this.O0 = max;
        this.O0 = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (!this.f٩٩٣١i0) {
                        if (!s0() && o0(motionEvent) && Math.abs(x10 - this.f٩٩٢٥f0) < this.f٩٩٤٨r) {
                            return false;
                        }
                        if (s0() && n0(motionEvent) && Math.abs(y10 - this.f٩٩٢٧g0) < this.f٩٩٤٨r * 0.8f) {
                            return false;
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                        if (H0()) {
                            this.f٩٩٣١i0 = true;
                            Z0();
                            F0();
                        }
                    }
                    T0();
                    V0();
                    invalidate();
                }
            }
            this.f٩٩٣١i0 = false;
            MotionEvent motionEvent2 = this.f٩٩٢٩h0;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.f٩٩٢٩h0.getX() - motionEvent.getX()) <= this.f٩٩٤٨r && Math.abs(this.f٩٩٢٩h0.getY() - motionEvent.getY()) <= this.f٩٩٤٨r && H0()) {
                F0();
            }
            if (this.f٩٩٣٩m0 != -1) {
                T0();
                V0();
                if (b0() && (i10 = this.J) != -1 && this.K != -1) {
                    setThumbWidth(i10);
                    setThumbTrackGapSize(this.K);
                }
                this.f٩٩٣٩m0 = -1;
                G0();
            }
            invalidate();
        } else {
            this.f٩٩٢٥f0 = x10;
            this.f٩٩٢٧g0 = y10;
            if ((s0() || !o0(motionEvent)) && (!s0() || !n0(motionEvent))) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (H0()) {
                    requestFocus();
                    this.f٩٩٣١i0 = true;
                    Z0();
                    F0();
                    T0();
                    V0();
                    invalidate();
                }
            }
        }
        setPressed(this.f٩٩٣١i0);
        this.f٩٩٢٩h0 = MotionEvent.obtain(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        this.U0 = z10;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        ViewOverlay V;
        super.onVisibilityChanged(view, i10);
        if (i10 == 0 || (V = V()) == null) {
            return;
        }
        Iterator it = this.f٩٩٣٦l.iterator();
        while (it.hasNext()) {
            V.remove((h8.a) it.next());
        }
    }

    final boolean p0() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public void removeOnChangeListener(L l10) {
        this.f٩٩٣٨m.remove(l10);
    }

    public void removeOnSliderTouchListener(T t10) {
        this.f٩٩٤٠n.remove(t10);
    }

    public boolean s0() {
        if (this.f٩٩٦٤z == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActiveThumbIndex(int i10) {
        this.f٩٩٣٩m0 = i10;
    }

    public void setCentered(boolean z10) {
        if (this.O == z10) {
            return;
        }
        this.O = z10;
        if (z10) {
            setValues(Float.valueOf((this.f٩٩٣٣j0 + this.f٩٩٣٥k0) / 2.0f));
        } else {
            setValues(Float.valueOf(this.f٩٩٣٣j0));
        }
        i1(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawable(int i10) {
        setCustomThumbDrawable(getResources().getDrawable(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            drawableArr[i10] = getResources().getDrawable(iArr[i10]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        int i10;
        super.setEnabled(z10);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 2;
        }
        setLayerType(i10, null);
    }

    public void setFocusedThumbIndex(int i10) {
        if (i10 >= 0 && i10 < this.f٩٩٣٧l0.size()) {
            this.f٩٩٤١n0 = i10;
            this.f٩٩٢٨h.K(i10);
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("index out of range");
    }

    public void setHaloRadius(@IntRange(from = 0) int i10) {
        if (i10 == this.H) {
            return;
        }
        this.H = i10;
        Drawable background = getBackground();
        if (!P0() && (background instanceof RippleDrawable)) {
            com.google.android.material.drawable.g.m((RippleDrawable) background, this.H);
        } else {
            postInvalidate();
        }
    }

    public void setHaloRadiusResource(int i10) {
        setHaloRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f٩٩٦١x0)) {
            return;
        }
        this.f٩٩٦١x0 = colorStateList;
        Drawable background = getBackground();
        if (!P0() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.f٩٩٢٠d.setColor(U(colorStateList));
        this.f٩٩٢٠d.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i10) {
        if (this.C != i10) {
            this.C = i10;
            i1(true);
        }
    }

    public void setLabelFormatter(h hVar) {
    }

    public void setOrientation(int i10) {
        if (this.f٩٩٦٤z == i10) {
            return;
        }
        this.f٩٩٦٤z = i10;
        i1(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSeparationUnit(int i10) {
        this.P0 = i10;
        this.f٩٩٥٩w0 = true;
        postInvalidate();
    }

    public void setStepSize(float f10) {
        if (f10 >= DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f٩٩٤٣o0 != f10) {
                this.f٩٩٤٣o0 = f10;
                this.f٩٩٥٩w0 = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", Float.valueOf(f10), Float.valueOf(this.f٩٩٣٣j0), Float.valueOf(this.f٩٩٣٥k0)));
    }

    public void setThumbElevation(float f10) {
        this.L0.g0(f10);
    }

    public void setThumbElevationResource(int i10) {
        setThumbElevation(getResources().getDimension(i10));
    }

    public void setThumbHeight(@IntRange(from = 0) int i10) {
        if (i10 == this.G) {
            return;
        }
        this.G = i10;
        this.L0.setBounds(0, 0, this.F, i10);
        Drawable drawable = this.M0;
        if (drawable != null) {
            m(drawable);
        }
        Iterator it = this.N0.iterator();
        while (it.hasNext()) {
            m((Drawable) it.next());
        }
        i1(false);
    }

    public void setThumbHeightResource(int i10) {
        setThumbHeight(getResources().getDimensionPixelSize(i10));
    }

    public void setThumbRadius(@IntRange(from = 0) int i10) {
        int i11 = i10 * 2;
        setThumbWidth(i11);
        setThumbHeight(i11);
    }

    public void setThumbRadiusResource(int i10) {
        setThumbRadius(getResources().getDimensionPixelSize(i10));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.L0.t0(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i10) {
        if (i10 != 0) {
            setThumbStrokeColor(r1.a.a(getContext(), i10));
        }
    }

    public void setThumbStrokeWidth(float f10) {
        this.L0.u0(f10);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i10) {
        if (i10 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i10));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.L0.D())) {
            return;
        }
        this.L0.h0(colorStateList);
        invalidate();
    }

    public void setThumbTrackGapSize(int i10) {
        if (this.I == i10) {
            return;
        }
        this.I = i10;
        invalidate();
    }

    public void setThumbWidth(@IntRange(from = 0) int i10) {
        if (i10 == this.F) {
            return;
        }
        this.F = i10;
        this.L0.setShapeAppearanceModel(o.a().q(0, this.F / 2.0f).m());
        this.L0.setBounds(0, 0, this.F, this.G);
        Drawable drawable = this.M0;
        if (drawable != null) {
            m(drawable);
        }
        Iterator it = this.N0.iterator();
        while (it.hasNext()) {
            m((Drawable) it.next());
        }
        i1(false);
    }

    public void setThumbWidthResource(int i10) {
        setThumbWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setTickActiveRadius(@IntRange(from = 0) int i10) {
        if (this.f٩٩٤٩r0 != i10) {
            this.f٩٩٤٩r0 = i10;
            this.f٩٩٢٤f.setStrokeWidth(i10 * 2);
            i1(false);
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f٩٩٦٣y0)) {
            return;
        }
        this.f٩٩٦٣y0 = colorStateList;
        this.f٩٩٢٤f.setColor(U(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(@IntRange(from = 0) int i10) {
        if (this.f٩٩٥١s0 != i10) {
            this.f٩٩٥١s0 = i10;
            this.f٩٩٢٢e.setStrokeWidth(i10 * 2);
            i1(false);
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.f٩٩٦٥z0)) {
            return;
        }
        this.f٩٩٦٥z0 = colorStateList;
        this.f٩٩٢٢e.setColor(U(colorStateList));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisibilityMode(int i10) {
        if (this.f٩٩٤٧q0 != i10) {
            this.f٩٩٤٧q0 = i10;
            postInvalidate();
        }
    }

    @Deprecated
    public void setTickVisible(boolean z10) {
        setTickVisibilityMode(x(z10));
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.A0)) {
            return;
        }
        this.A0 = colorStateList;
        this.f٩٩١٦b.setColor(U(colorStateList));
        invalidate();
    }

    public void setTrackCornerSize(int i10) {
        if (this.M == i10) {
            return;
        }
        this.M = i10;
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) int i10) {
        if (this.D != i10) {
            this.D = i10;
            f0();
            i1(false);
        }
    }

    public void setTrackIconActiveColor(ColorStateList colorStateList) {
        if (colorStateList == this.T) {
            return;
        }
        this.T = colorStateList;
        e1();
        d1();
        invalidate();
    }

    public void setTrackIconActiveEnd(Drawable drawable) {
        if (drawable == this.R) {
            return;
        }
        this.R = drawable;
        this.S = false;
        d1();
        invalidate();
    }

    public void setTrackIconActiveStart(Drawable drawable) {
        if (drawable == this.P) {
            return;
        }
        this.P = drawable;
        this.Q = false;
        e1();
        invalidate();
    }

    public void setTrackIconInactiveColor(ColorStateList colorStateList) {
        if (colorStateList == this.f٩٩١٧b0) {
            return;
        }
        this.f٩٩١٧b0 = colorStateList;
        g1();
        f1();
        invalidate();
    }

    public void setTrackIconInactiveEnd(Drawable drawable) {
        if (drawable == this.W) {
            return;
        }
        this.W = drawable;
        this.f٩٩١٥a0 = false;
        f1();
        invalidate();
    }

    public void setTrackIconInactiveStart(Drawable drawable) {
        if (drawable == this.U) {
            return;
        }
        this.U = drawable;
        this.V = false;
        g1();
        invalidate();
    }

    public void setTrackIconSize(int i10) {
        if (this.f٩٩١٩c0 == i10) {
            return;
        }
        this.f٩٩١٩c0 = i10;
        invalidate();
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.B0)) {
            return;
        }
        this.B0 = colorStateList;
        this.f٩٩١٤a.setColor(U(colorStateList));
        invalidate();
    }

    public void setTrackInsideCornerSize(int i10) {
        if (this.N == i10) {
            return;
        }
        this.N = i10;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i10) {
        if (this.L == i10) {
            return;
        }
        this.L = i10;
        this.f٩٩٢٦g.setStrokeWidth(i10);
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f10) {
        this.f٩٩٣٣j0 = f10;
        this.f٩٩٥٩w0 = true;
        postInvalidate();
    }

    public void setValueTo(float f10) {
        this.f٩٩٣٥k0 = f10;
        this.f٩٩٥٩w0 = true;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        N0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        int f٩٩٧٢a;

        private b() {
            this.f٩٩٧٢a = -1;
        }

        void a(int i10) {
            this.f٩٩٧٢a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.f٩٩٢٨h.L(this.f٩٩٧٢a, 4);
        }

        /* synthetic */ b(BaseSlider baseSlider, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawable(Drawable drawable) {
        this.M0 = e0(drawable);
        this.N0.clear();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(List<Float> list) {
        N0(new ArrayList(list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.M0 = null;
        this.N0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.N0.add(e0(drawable));
        }
        postInvalidate();
    }

    public void setTrackIconActiveEnd(int i10) {
        setTrackIconActiveEnd(i10 != 0 ? r1.a.b(getContext(), i10) : null);
    }

    public void setTrackIconActiveStart(int i10) {
        setTrackIconActiveStart(i10 != 0 ? r1.a.b(getContext(), i10) : null);
    }

    public void setTrackIconInactiveEnd(int i10) {
        setTrackIconInactiveEnd(i10 != 0 ? r1.a.b(getContext(), i10) : null);
    }

    public void setTrackIconInactiveStart(int i10) {
        setTrackIconInactiveStart(i10 != 0 ? r1.a.b(getContext(), i10) : null);
    }
}
