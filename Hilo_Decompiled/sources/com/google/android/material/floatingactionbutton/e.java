package com.google.android.material.floatingactionbutton;

import a8.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;
import f8.j;
import f8.o;
import f8.r;
import java.util.ArrayList;
import java.util.Iterator;
import p7.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e {
    static final TimeInterpolator C = p7.a.f١٦٩٤٩c;
    private static final int D = R.attr.motionDurationLong2;
    private static final int E = R.attr.motionEasingEmphasizedInterpolator;
    private static final int F = R.attr.motionDurationMedium1;
    private static final int G = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    static final int[] H = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    static final int[] I = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] J = {android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] K = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    static final int[] L = {android.R.attr.state_enabled};
    static final int[] M = new int[0];

    /* renamed from: B, reason: collision with root package name */
    private ViewTreeObserver.OnPreDrawListener f٩١٠٠B;

    /* renamed from: a, reason: collision with root package name */
    o f٩١٠١a;

    /* renamed from: b, reason: collision with root package name */
    i f٩١٠٢b;

    /* renamed from: c, reason: collision with root package name */
    Drawable f٩١٠٣c;

    /* renamed from: d, reason: collision with root package name */
    com.google.android.material.floatingactionbutton.c f٩١٠٤d;

    /* renamed from: e, reason: collision with root package name */
    Drawable f٩١٠٥e;

    /* renamed from: f, reason: collision with root package name */
    boolean f٩١٠٦f;

    /* renamed from: h, reason: collision with root package name */
    float f٩١٠٨h;

    /* renamed from: i, reason: collision with root package name */
    float f٩١٠٩i;

    /* renamed from: j, reason: collision with root package name */
    float f٩١١٠j;

    /* renamed from: k, reason: collision with root package name */
    int f٩١١١k;

    /* renamed from: l, reason: collision with root package name */
    private StateListAnimator f٩١١٢l;

    /* renamed from: m, reason: collision with root package name */
    private Animator f٩١١٣m;

    /* renamed from: n, reason: collision with root package name */
    private h f٩١١٤n;

    /* renamed from: o, reason: collision with root package name */
    private h f٩١١٥o;

    /* renamed from: q, reason: collision with root package name */
    private int f٩١١٧q;

    /* renamed from: s, reason: collision with root package name */
    private ArrayList f٩١١٩s;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList f٩١٢٠t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList f٩١٢١u;

    /* renamed from: v, reason: collision with root package name */
    final FloatingActionButton f٩١٢٢v;

    /* renamed from: w, reason: collision with root package name */
    final e8.b f٩١٢٣w;

    /* renamed from: g, reason: collision with root package name */
    boolean f٩١٠٧g = true;

    /* renamed from: p, reason: collision with root package name */
    private float f٩١١٦p = 1.0f;

    /* renamed from: r, reason: collision with root package name */
    private int f٩١١٨r = 0;

    /* renamed from: x, reason: collision with root package name */
    private final Rect f٩١٢٤x = new Rect();

    /* renamed from: y, reason: collision with root package name */
    private final RectF f٩١٢٥y = new RectF();

    /* renamed from: z, reason: collision with root package name */
    private final RectF f٩١٢٦z = new RectF();
    private final Matrix A = new Matrix();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f٩١٢٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f٩١٢٨b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ g f٩١٢٩c;

        a(boolean z10, g gVar) {
            this.f٩١٢٨b = z10;
            this.f٩١٢٩c = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f٩١٢٧a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i10;
            e.this.f٩١١٨r = 0;
            e.this.f٩١١٣m = null;
            if (!this.f٩١٢٧a) {
                FloatingActionButton floatingActionButton = e.this.f٩١٢٢v;
                boolean z10 = this.f٩١٢٨b;
                if (z10) {
                    i10 = 8;
                } else {
                    i10 = 4;
                }
                floatingActionButton.b(i10, z10);
                g gVar = this.f٩١٢٩c;
                if (gVar != null) {
                    gVar.b();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.f٩١٢٢v.b(0, this.f٩١٢٨b);
            e.this.f٩١١٨r = 1;
            e.this.f٩١١٣m = animator;
            this.f٩١٢٧a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f٩١٣١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f٩١٣٢b;

        b(boolean z10, g gVar) {
            this.f٩١٣١a = z10;
            this.f٩١٣٢b = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.this.f٩١١٨r = 0;
            e.this.f٩١١٣m = null;
            g gVar = this.f٩١٣٢b;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e.this.f٩١٢٢v.b(0, this.f٩١٣١a);
            e.this.f٩١١٨r = 2;
            e.this.f٩١١٣m = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c extends p7.g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            e.this.f٩١١٦p = f10;
            return super.evaluate(f10, matrix, matrix2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d implements TypeEvaluator {

        /* renamed from: a, reason: collision with root package name */
        final FloatEvaluator f٩١٣٥a = new FloatEvaluator();

        d() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f10, Float f11, Float f12) {
            float floatValue = this.f٩١٣٥a.evaluate(f10, (Number) f11, (Number) f12).floatValue();
            if (floatValue < 0.1f) {
                floatValue = DownloadProgress.UNKNOWN_PROGRESS;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.floatingactionbutton.e$e, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class C٠١١٣e extends i {
        C٠١١٣e(o oVar) {
            super(oVar);
        }

        @Override // f8.i, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface f {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface g {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FloatingActionButton floatingActionButton, e8.b bVar) {
        this.f٩١٢٢v = floatingActionButton;
        this.f٩١٢٣w = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f٩١٢٢v.setAlpha(p7.a.b(f10, f11, DownloadProgress.UNKNOWN_PROGRESS, 0.2f, floatValue));
        this.f٩١٢٢v.setScaleX(p7.a.a(f12, f13, floatValue));
        this.f٩١٢٢v.setScaleY(p7.a.a(f14, f13, floatValue));
        this.f٩١١٦p = p7.a.a(f15, f16, floatValue);
        h(p7.a.a(f15, f16, floatValue), matrix);
        this.f٩١٢٢v.setImageMatrix(matrix);
    }

    private boolean a0() {
        if (this.f٩١٢٢v.isLaidOut() && !this.f٩١٢٢v.isInEditMode()) {
            return true;
        }
        return false;
    }

    private void f0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new d());
    }

    private void h(float f10, Matrix matrix) {
        matrix.reset();
        if (this.f٩١٢٢v.getDrawable() != null && this.f٩١١٧q != 0) {
            RectF rectF = this.f٩١٢٥y;
            RectF rectF2 = this.f٩١٢٦z;
            rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            int i10 = this.f٩١١٧q;
            rectF2.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, i10, i10);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i11 = this.f٩١١٧q;
            matrix.postScale(f10, f10, i11 / 2.0f, i11 / 2.0f);
        }
    }

    private AnimatorSet i(h hVar, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f٩١٢٢v, (Property<FloatingActionButton, Float>) View.ALPHA, f10);
        hVar.h("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f٩١٢٢v, (Property<FloatingActionButton, Float>) View.SCALE_X, f11);
        hVar.h("scale").a(ofFloat2);
        f0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f٩١٢٢v, (Property<FloatingActionButton, Float>) View.SCALE_Y, f11);
        hVar.h("scale").a(ofFloat3);
        f0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f12, this.A);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f٩١٢٢v, new p7.f(), new c(), new Matrix(this.A));
        hVar.h("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        p7.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet k(final float f10, final float f11, final float f12, int i10, int i11) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        final float alpha = this.f٩١٢٢v.getAlpha();
        final float scaleX = this.f٩١٢٢v.getScaleX();
        final float scaleY = this.f٩١٢٢v.getScaleY();
        final float f13 = this.f٩١١٦p;
        final Matrix matrix = new Matrix(this.A);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.D(alpha, f10, scaleX, f11, scaleY, f13, f12, matrix, valueAnimator);
            }
        });
        arrayList.add(ofFloat);
        p7.b.a(animatorSet, arrayList);
        animatorSet.setDuration(k.f(this.f٩١٢٢v.getContext(), i10, this.f٩١٢٢v.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(k.g(this.f٩١٢٢v.getContext(), i11, p7.a.f١٦٩٤٨b));
        return animatorSet;
    }

    private StateListAnimator l(float f10, float f11, float f12) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(H, m(f10, f12));
        stateListAnimator.addState(I, m(f10, f11));
        stateListAnimator.addState(J, m(f10, f11));
        stateListAnimator.addState(K, m(f10, f11));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f٩١٢٢v, "elevation", f10).setDuration(0L));
        if (Build.VERSION.SDK_INT <= 24) {
            FloatingActionButton floatingActionButton = this.f٩١٢٢v;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f٩١٢٢v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, DownloadProgress.UNKNOWN_PROGRESS).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(C);
        stateListAnimator.addState(L, animatorSet);
        stateListAnimator.addState(M, m(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS));
        return stateListAnimator;
    }

    private Animator m(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f٩١٢٢v, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f٩١٢٢v, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(C);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        Drawable drawable;
        i n10 = n();
        this.f٩١٠٢b = n10;
        n10.setTintList(colorStateList);
        if (mode != null) {
            this.f٩١٠٢b.setTintMode(mode);
        }
        this.f٩١٠٢b.V(this.f٩١٢٢v.getContext());
        if (i10 > 0) {
            this.f٩١٠٤d = j(i10, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) androidx.core.util.h.g(this.f٩١٠٤d), (Drawable) androidx.core.util.h.g(this.f٩١٠٢b)});
        } else {
            this.f٩١٠٤d = null;
            drawable = this.f٩١٠٢b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(d8.a.e(colorStateList2), drawable, null);
        this.f٩١٠٣c = rippleDrawable;
        this.f٩١٠٥e = rippleDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        if (this.f٩١٢٢v.getVisibility() == 0) {
            if (this.f٩١١٨r != 1) {
                return false;
            }
            return true;
        }
        if (this.f٩١١٨r == 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        if (this.f٩١٢٢v.getVisibility() != 0) {
            if (this.f٩١١٨r != 2) {
                return false;
            }
            return true;
        }
        if (this.f٩١١٨r == 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        i iVar = this.f٩١٠٢b;
        if (iVar != null) {
            j.f(this.f٩١٢٢v, iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        d0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        ViewTreeObserver viewTreeObserver = this.f٩١٢٢v.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f٩١٠٠B;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.f٩١٠٠B = null;
        }
    }

    void H(float f10, float f11, float f12) {
        if (this.f٩١٢٢v.getStateListAnimator() == this.f٩١١٢l) {
            StateListAnimator l10 = l(f10, f11, f12);
            this.f٩١١٢l = l10;
            this.f٩١٢٢v.setStateListAnimator(l10);
        }
        if (Z()) {
            d0();
        }
    }

    void I(Rect rect) {
        androidx.core.util.h.h(this.f٩١٠٥e, "Didn't initialize content background");
        if (Z()) {
            this.f٩١٢٣w.b(new InsetDrawable(this.f٩١٠٥e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.f٩١٢٣w.b(this.f٩١٠٥e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        ArrayList arrayList = this.f٩١٢١u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        ArrayList arrayList = this.f٩١٢١u;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(ColorStateList colorStateList) {
        i iVar = this.f٩١٠٢b;
        if (iVar != null) {
            iVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f٩١٠٤d;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(PorterDuff.Mode mode) {
        i iVar = this.f٩١٠٢b;
        if (iVar != null) {
            iVar.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(float f10) {
        if (this.f٩١٠٨h != f10) {
            this.f٩١٠٨h = f10;
            H(f10, this.f٩١٠٩i, this.f٩١١٠j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(boolean z10) {
        this.f٩١٠٦f = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P(h hVar) {
        this.f٩١١٥o = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(float f10) {
        if (this.f٩١٠٩i != f10) {
            this.f٩١٠٩i = f10;
            H(this.f٩١٠٨h, f10, this.f٩١١٠j);
        }
    }

    final void R(float f10) {
        this.f٩١١٦p = f10;
        Matrix matrix = this.A;
        h(f10, matrix);
        this.f٩١٢٢v.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S(int i10) {
        if (this.f٩١١٧q != i10) {
            this.f٩١١٧q = i10;
            c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(int i10) {
        this.f٩١١١k = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void U(float f10) {
        if (this.f٩١١٠j != f10) {
            this.f٩١١٠j = f10;
            H(this.f٩١٠٨h, this.f٩١٠٩i, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(ColorStateList colorStateList) {
        Drawable drawable = this.f٩١٠٣c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(d8.a.e(colorStateList));
        } else if (drawable != null) {
            drawable.setTintList(d8.a.e(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(boolean z10) {
        this.f٩١٠٧g = z10;
        d0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void X(o oVar) {
        this.f٩١٠١a = oVar;
        i iVar = this.f٩١٠٢b;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(oVar);
        }
        Object obj = this.f٩١٠٣c;
        if (obj instanceof r) {
            ((r) obj).setShapeAppearanceModel(oVar);
        }
        com.google.android.material.floatingactionbutton.c cVar = this.f٩١٠٤d;
        if (cVar != null) {
            cVar.f(oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Y(h hVar) {
        this.f٩١١٤n = hVar;
    }

    boolean Z() {
        if (!this.f٩١٢٣w.c() && !z()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0(g gVar, boolean z10) {
        boolean z11;
        AnimatorSet k10;
        float f10;
        float f11;
        if (C()) {
            return;
        }
        Animator animator = this.f٩١١٣m;
        if (animator != null) {
            animator.cancel();
        }
        if (this.f٩١١٤n == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (a0()) {
            if (this.f٩١٢٢v.getVisibility() != 0) {
                FloatingActionButton floatingActionButton = this.f٩١٢٢v;
                float f12 = DownloadProgress.UNKNOWN_PROGRESS;
                floatingActionButton.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
                FloatingActionButton floatingActionButton2 = this.f٩١٢٢v;
                if (z11) {
                    f10 = 0.4f;
                } else {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                floatingActionButton2.setScaleY(f10);
                FloatingActionButton floatingActionButton3 = this.f٩١٢٢v;
                if (z11) {
                    f11 = 0.4f;
                } else {
                    f11 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                floatingActionButton3.setScaleX(f11);
                if (z11) {
                    f12 = 0.4f;
                }
                R(f12);
            }
            h hVar = this.f٩١١٤n;
            if (hVar != null) {
                k10 = i(hVar, 1.0f, 1.0f, 1.0f);
            } else {
                k10 = k(1.0f, 1.0f, 1.0f, D, E);
            }
            k10.addListener(new b(z10, gVar));
            ArrayList arrayList = this.f٩١١٩s;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    k10.addListener((Animator.AnimatorListener) it.next());
                }
            }
            k10.start();
            return;
        }
        this.f٩١٢٢v.b(0, z10);
        this.f٩١٢٢v.setAlpha(1.0f);
        this.f٩١٢٢v.setScaleY(1.0f);
        this.f٩١٢٢v.setScaleX(1.0f);
        R(1.0f);
        if (gVar != null) {
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c0() {
        R(this.f٩١١٦p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d0() {
        Rect rect = this.f٩١٢٤x;
        t(rect);
        I(rect);
        this.f٩١٢٣w.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f٩١٢٠t == null) {
            this.f٩١٢٠t = new ArrayList();
        }
        this.f٩١٢٠t.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(float f10) {
        i iVar = this.f٩١٠٢b;
        if (iVar != null) {
            iVar.g0(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Animator.AnimatorListener animatorListener) {
        if (this.f٩١١٩s == null) {
            this.f٩١١٩s = new ArrayList();
        }
        this.f٩١١٩s.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(f fVar) {
        if (this.f٩١٢١u == null) {
            this.f٩١٢١u = new ArrayList();
        }
        this.f٩١٢١u.add(fVar);
    }

    com.google.android.material.floatingactionbutton.c j(int i10, ColorStateList colorStateList) {
        Context context = this.f٩١٢٢v.getContext();
        com.google.android.material.floatingactionbutton.c cVar = new com.google.android.material.floatingactionbutton.c((o) androidx.core.util.h.g(this.f٩١٠١a));
        cVar.e(androidx.core.content.a.getColor(context, R.color.design_fab_stroke_top_outer_color), androidx.core.content.a.getColor(context, R.color.design_fab_stroke_top_inner_color), androidx.core.content.a.getColor(context, R.color.design_fab_stroke_end_inner_color), androidx.core.content.a.getColor(context, R.color.design_fab_stroke_end_outer_color));
        cVar.d(i10);
        cVar.c(colorStateList);
        return cVar;
    }

    i n() {
        return new C٠١١٣e((o) androidx.core.util.h.g(this.f٩١٠١a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable o() {
        return this.f٩١٠٥e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.f٩١٢٢v.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.f٩١٠٦f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h r() {
        return this.f٩١١٥o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float s() {
        return this.f٩١٠٩i;
    }

    void t(Rect rect) {
        float f10;
        if (this.f٩١٢٣w.c()) {
            int x10 = x();
            if (this.f٩١٠٧g) {
                f10 = p() + this.f٩١١٠j;
            } else {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            int max = Math.max(x10, (int) Math.ceil(f10));
            int max2 = Math.max(x10, (int) Math.ceil(f10 * 1.5f));
            rect.set(max, max2, max, max2);
            return;
        }
        if (z()) {
            int sizeDimension = (this.f٩١١١k - this.f٩١٢٢v.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float u() {
        return this.f٩١١٠j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o v() {
        return this.f٩١٠١a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h w() {
        return this.f٩١١٤n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x() {
        if (!this.f٩١٠٦f) {
            return 0;
        }
        return Math.max((this.f٩١١١k - this.f٩١٢٢v.getSizeDimension()) / 2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(g gVar, boolean z10) {
        int i10;
        AnimatorSet k10;
        if (B()) {
            return;
        }
        Animator animator = this.f٩١١٣m;
        if (animator != null) {
            animator.cancel();
        }
        if (a0()) {
            h hVar = this.f٩١١٥o;
            if (hVar != null) {
                k10 = i(hVar, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
            } else {
                k10 = k(DownloadProgress.UNKNOWN_PROGRESS, 0.4f, 0.4f, F, G);
            }
            k10.addListener(new a(z10, gVar));
            ArrayList arrayList = this.f٩١٢٠t;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    k10.addListener((Animator.AnimatorListener) it.next());
                }
            }
            k10.start();
            return;
        }
        FloatingActionButton floatingActionButton = this.f٩١٢٢v;
        if (z10) {
            i10 = 8;
        } else {
            i10 = 4;
        }
        floatingActionButton.b(i10, z10);
        if (gVar != null) {
            gVar.b();
        }
    }

    final boolean z() {
        if (this.f٩١٠٦f && this.f٩١٢٢v.getSizeDimension() < this.f٩١١١k) {
            return true;
        }
        return false;
    }
}
