package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.core.view.d1;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;
import m2.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class ClockFaceView extends RadialViewGroup implements ClockHandView.c {

    /* renamed from: d, reason: collision with root package name */
    private final ClockHandView f١٠٢٧٩d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f١٠٢٨٠e;

    /* renamed from: f, reason: collision with root package name */
    private final RectF f١٠٢٨١f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f١٠٢٨٢g;

    /* renamed from: h, reason: collision with root package name */
    private final SparseArray f١٠٢٨٣h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.core.view.a f١٠٢٨٤i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f١٠٢٨٥j;

    /* renamed from: k, reason: collision with root package name */
    private final float[] f١٠٢٨٦k;

    /* renamed from: l, reason: collision with root package name */
    private final int f١٠٢٨٧l;

    /* renamed from: m, reason: collision with root package name */
    private final int f١٠٢٨٨m;

    /* renamed from: n, reason: collision with root package name */
    private final int f١٠٢٨٩n;

    /* renamed from: o, reason: collision with root package name */
    private final int f١٠٢٩٠o;

    /* renamed from: p, reason: collision with root package name */
    private String[] f١٠٢٩١p;

    /* renamed from: q, reason: collision with root package name */
    private float f١٠٢٩٢q;

    /* renamed from: r, reason: collision with root package name */
    private final ColorStateList f١٠٢٩٣r;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.setRadius(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f١٠٢٧٩d.getSelectorRadius()) - ClockFaceView.this.f١٠٢٨٧l);
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends androidx.core.view.a {
        b() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
            if (intValue > 0) {
                g0Var.S0((View) ClockFaceView.this.f١٠٢٨٣h.get(intValue - 1));
            }
            g0Var.r0(g0.f.a(0, 1, intValue, 1, false, view.isSelected()));
            g0Var.p0(true);
            g0Var.b(g0.a.f١٥٩٣٠i);
        }

        @Override // androidx.core.view.a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (i10 == 16) {
                long uptimeMillis = SystemClock.uptimeMillis();
                view.getHitRect(ClockFaceView.this.f١٠٢٨٠e);
                float centerX = ClockFaceView.this.f١٠٢٨٠e.centerX();
                float centerY = ClockFaceView.this.f١٠٢٨٠e.centerY();
                ClockFaceView.this.f١٠٢٧٩d.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, centerX, centerY, 0));
                ClockFaceView.this.f١٠٢٧٩d.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, centerX, centerY, 0));
                return true;
            }
            return super.performAccessibilityAction(view, i10, bundle);
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    private static float A(float f10, float f11, float f12) {
        return Math.max(Math.max(f10, f11), f12);
    }

    private void C(int i10) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f١٠٢٨٣h.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < Math.max(this.f١٠٢٩١p.length, size); i11++) {
            TextView textView = (TextView) this.f١٠٢٨٣h.get(i11);
            if (i11 >= this.f١٠٢٩١p.length) {
                removeView(textView);
                this.f١٠٢٨٣h.remove(i11);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f١٠٢٨٣h.put(i11, textView);
                    addView(textView);
                }
                textView.setText(this.f١٠٢٩١p[i11]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i11));
                int i12 = (i11 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i12));
                if (i12 > 1) {
                    z10 = true;
                }
                d1.q0(textView, this.f١٠٢٨٤i);
                textView.setTextColor(this.f١٠٢٩٣r);
                if (i10 != 0) {
                    textView.setContentDescription(getResources().getString(i10, this.f١٠٢٩١p[i11]));
                }
            }
        }
        this.f١٠٢٧٩d.l(z10);
    }

    private void x() {
        boolean z10;
        RectF currentSelectorBox = this.f١٠٢٧٩d.getCurrentSelectorBox();
        TextView z11 = z(currentSelectorBox);
        for (int i10 = 0; i10 < this.f١٠٢٨٣h.size(); i10++) {
            TextView textView = (TextView) this.f١٠٢٨٣h.get(i10);
            if (textView != null) {
                if (textView == z11) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                textView.setSelected(z10);
                textView.getPaint().setShader(y(currentSelectorBox, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient y(RectF rectF, TextView textView) {
        textView.getHitRect(this.f١٠٢٨٠e);
        this.f١٠٢٨١f.set(this.f١٠٢٨٠e);
        textView.getLineBounds(0, this.f١٠٢٨٢g);
        RectF rectF2 = this.f١٠٢٨١f;
        Rect rect = this.f١٠٢٨٢g;
        rectF2.inset(rect.left, rect.top);
        if (!RectF.intersects(rectF, this.f١٠٢٨١f)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.f١٠٢٨١f.left, rectF.centerY() - this.f١٠٢٨١f.top, rectF.width() * 0.5f, this.f١٠٢٨٥j, this.f١٠٢٨٦k, Shader.TileMode.CLAMP);
    }

    private TextView z(RectF rectF) {
        float f10 = Float.MAX_VALUE;
        TextView textView = null;
        for (int i10 = 0; i10 < this.f١٠٢٨٣h.size(); i10++) {
            TextView textView2 = (TextView) this.f١٠٢٨٣h.get(i10);
            if (textView2 != null) {
                textView2.getHitRect(this.f١٠٢٨٠e);
                this.f١٠٢٨١f.set(this.f١٠٢٨٠e);
                this.f١٠٢٨١f.union(rectF);
                float width = this.f١٠٢٨١f.width() * this.f١٠٢٨١f.height();
                if (width < f10) {
                    textView = textView2;
                    f10 = width;
                }
            }
        }
        return textView;
    }

    public void B(String[] strArr, int i10) {
        this.f١٠٢٩١p = strArr;
        C(i10);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void b(float f10, boolean z10) {
        if (Math.abs(this.f١٠٢٩٢q - f10) > 0.001f) {
            this.f١٠٢٩٢q = f10;
            x();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        g0.V0(accessibilityNodeInfo).q0(g0.e.b(1, this.f١٠٢٩١p.length, false, 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int A = (int) (this.f١٠٢٩٠o / A(this.f١٠٢٨٨m / displayMetrics.heightPixels, this.f١٠٢٨٩n / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(A, 1073741824);
        setMeasuredDimension(A, A);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void r() {
        super.r();
        for (int i10 = 0; i10 < this.f١٠٢٨٣h.size(); i10++) {
            ((TextView) this.f١٠٢٨٣h.get(i10)).setVisibility(0);
        }
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float f10) {
        this.f١٠٢٧٩d.setHandRotation(f10);
        x();
    }

    @Override // com.google.android.material.timepicker.RadialViewGroup
    public void setRadius(int i10) {
        if (i10 != getRadius()) {
            super.setRadius(i10);
            this.f١٠٢٧٩d.setCircleRadius(getRadius());
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٠٢٨٠e = new Rect();
        this.f١٠٢٨١f = new RectF();
        this.f١٠٢٨٢g = new Rect();
        this.f١٠٢٨٣h = new SparseArray();
        this.f١٠٢٨٦k = new float[]{DownloadProgress.UNKNOWN_PROGRESS, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i10, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList a10 = c8.c.a(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.f١٠٢٩٣r = a10;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f١٠٢٧٩d = clockHandView;
        this.f١٠٢٨٧l = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = a10.getColorForState(new int[]{android.R.attr.state_selected}, a10.getDefaultColor());
        this.f١٠٢٨٥j = new int[]{colorForState, colorForState, a10.getDefaultColor()};
        clockHandView.addOnRotateListener(this);
        int defaultColor = r1.a.a(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList a11 = c8.c.a(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(a11 != null ? a11.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(false);
        obtainStyledAttributes.recycle();
        this.f١٠٢٨٤i = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        B(strArr, 0);
        this.f١٠٢٨٨m = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.f١٠٢٨٩n = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.f١٠٢٩٠o = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }
}
