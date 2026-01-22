package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.i0;
import com.google.android.material.internal.k0;
import com.google.android.material.search.SearchView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    private final SearchView f٩٨١٨a;

    /* renamed from: b, reason: collision with root package name */
    private final View f٩٨١٩b;

    /* renamed from: c, reason: collision with root package name */
    private final ClippableRoundedCornerLayout f٩٨٢٠c;

    /* renamed from: d, reason: collision with root package name */
    private final FrameLayout f٩٨٢١d;

    /* renamed from: e, reason: collision with root package name */
    private final FrameLayout f٩٨٢٢e;

    /* renamed from: f, reason: collision with root package name */
    private final Toolbar f٩٨٢٣f;

    /* renamed from: g, reason: collision with root package name */
    private final Toolbar f٩٨٢٤g;

    /* renamed from: h, reason: collision with root package name */
    private final LinearLayout f٩٨٢٥h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f٩٨٢٦i;

    /* renamed from: j, reason: collision with root package name */
    private final EditText f٩٨٢٧j;

    /* renamed from: k, reason: collision with root package name */
    private final ImageButton f٩٨٢٨k;

    /* renamed from: l, reason: collision with root package name */
    private final View f٩٨٢٩l;

    /* renamed from: m, reason: collision with root package name */
    private final TouchObserverFrameLayout f٩٨٣٠m;

    /* renamed from: n, reason: collision with root package name */
    private final a8.i f٩٨٣١n;

    /* renamed from: o, reason: collision with root package name */
    private AnimatorSet f٩٨٣٢o;

    /* renamed from: p, reason: collision with root package name */
    private SearchBar f٩٨٣٣p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!b0.this.f٩٨١٨a.u()) {
                b0.this.f٩٨١٨a.L();
            }
            b0.this.f٩٨١٨a.setTransitionState(SearchView.b.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b0.this.f٩٨٢٠c.setVisibility(0);
            b0.this.f٩٨٣٣p.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b0.this.f٩٨٢٠c.setVisibility(8);
            if (!b0.this.f٩٨١٨a.u()) {
                b0.this.f٩٨١٨a.r();
            }
            b0.this.f٩٨١٨a.setTransitionState(SearchView.b.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b0.this.f٩٨١٨a.setTransitionState(SearchView.b.HIDING);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!b0.this.f٩٨١٨a.u()) {
                b0.this.f٩٨١٨a.L();
            }
            b0.this.f٩٨١٨a.setTransitionState(SearchView.b.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b0.this.f٩٨٢٠c.setVisibility(0);
            b0.this.f٩٨١٨a.setTransitionState(SearchView.b.SHOWING);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b0.this.f٩٨٢٠c.setVisibility(8);
            if (!b0.this.f٩٨١٨a.u()) {
                b0.this.f٩٨١٨a.r();
            }
            b0.this.f٩٨١٨a.setTransitionState(SearchView.b.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b0.this.f٩٨١٨a.setTransitionState(SearchView.b.HIDING);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f٩٨٣٨a;

        e(boolean z10) {
            this.f٩٨٣٨a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            float f10;
            b0 b0Var = b0.this;
            if (this.f٩٨٣٨a) {
                f10 = 1.0f;
            } else {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            b0Var.l0(f10);
            b0.this.f٩٨٢٧j.setAlpha(1.0f);
            if (b0.this.f٩٨٣٣p != null) {
                b0.this.f٩٨٣٣p.getTextView().setAlpha(1.0f);
            }
            b0.this.f٩٨٢٧j.setClipBounds(null);
            b0.this.f٩٨٢٠c.a();
            if (!this.f٩٨٣٨a) {
                b0.this.f٩٨٣١n.j();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            float f10;
            b0 b0Var = b0.this;
            if (this.f٩٨٣٨a) {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                f10 = 1.0f;
            }
            b0Var.l0(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(SearchView searchView) {
        this.f٩٨١٨a = searchView;
        this.f٩٨١٩b = searchView.f٩٧٧٦a;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.f٩٧٧٧b;
        this.f٩٨٢٠c = clippableRoundedCornerLayout;
        this.f٩٨٢١d = searchView.f٩٧٨٠e;
        this.f٩٨٢٢e = searchView.f٩٧٨١f;
        this.f٩٨٢٣f = searchView.f٩٧٨٢g;
        this.f٩٨٢٤g = searchView.f٩٧٨٣h;
        this.f٩٨٢٦i = searchView.f٩٧٨٤i;
        this.f٩٨٢٧j = searchView.f٩٧٨٦k;
        this.f٩٨٢٨k = searchView.f٩٧٨٧l;
        this.f٩٨٢٩l = searchView.f٩٧٨٨m;
        this.f٩٨٣٠m = searchView.f٩٧٨٩n;
        this.f٩٨٢٥h = searchView.f٩٧٨٥j;
        this.f٩٨٣١n = new a8.i(clippableRoundedCornerLayout);
    }

    private AnimatorSet A(boolean z10) {
        long j10;
        AnimatorSet animatorSet = new AnimatorSet();
        q(animatorSet);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٨b));
        return animatorSet;
    }

    private AnimatorSet B(boolean z10) {
        long j10;
        AnimatorSet animatorSet = new AnimatorSet();
        r(animatorSet);
        o(animatorSet);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٨b));
        return animatorSet;
    }

    private Animator C(boolean z10) {
        long j10;
        long j11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        if (z10) {
            j10 = 50;
        } else {
            j10 = 42;
        }
        ofFloat.setDuration(j10);
        if (z10) {
            j11 = 250;
        } else {
            j11 = 0;
        }
        ofFloat.setStartDelay(j11);
        ofFloat.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٧a));
        ofFloat.addUpdateListener(com.google.android.material.internal.o.e(this.f٩٨٢٨k));
        return ofFloat;
    }

    private Animator D(boolean z10) {
        long j10;
        long j11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        if (z10) {
            j10 = 150;
        } else {
            j10 = 83;
        }
        ofFloat.setDuration(j10);
        if (z10) {
            j11 = 75;
        } else {
            j11 = 0;
        }
        ofFloat.setStartDelay(j11);
        ofFloat.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٧a));
        ofFloat.addUpdateListener(com.google.android.material.internal.o.e(this.f٩٨٢٩l, this.f٩٨٣٠m));
        return ofFloat;
    }

    private Animator E(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(D(z10), G(z10), F(z10));
        return animatorSet;
    }

    private Animator F(boolean z10) {
        long j10;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.95f, 1.0f);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٨b));
        ofFloat.addUpdateListener(com.google.android.material.internal.o.f(this.f٩٨٣٠m));
        return ofFloat;
    }

    private Animator G(boolean z10) {
        long j10;
        ValueAnimator ofFloat = ValueAnimator.ofFloat((this.f٩٨٣٠m.getHeight() * 0.050000012f) / 2.0f, DownloadProgress.UNKNOWN_PROGRESS);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٨b));
        ofFloat.addUpdateListener(com.google.android.material.internal.o.l(this.f٩٨٢٩l));
        return ofFloat;
    }

    private Animator H(boolean z10) {
        Toolbar toolbar = this.f٩٨٢٤g;
        return S(z10, toolbar, K(toolbar), L());
    }

    private Animator I(boolean z10) {
        return T(z10, this.f٩٨٢٧j);
    }

    private AnimatorSet J(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f٩٨٣٢o == null) {
            animatorSet.playTogether(A(z10), B(z10));
        }
        animatorSet.playTogether(O(z10), N(z10), C(z10), E(z10), M(z10), H(z10), y(z10), I(z10), P(z10), Q(z10));
        animatorSet.addListener(new e(z10));
        return animatorSet;
    }

    private int K(View view) {
        int marginEnd = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).getMarginEnd();
        int W = W(this.f٩٨٣٣p);
        if (!k0.m(this.f٩٨٣٣p)) {
            W = W + this.f٩٨٣٣p.getWidth() + marginEnd;
            marginEnd = this.f٩٨١٨a.getWidth();
        }
        return W - marginEnd;
    }

    private int L() {
        return (X(this.f٩٨٣٣p) + (this.f٩٨٣٣p.getHeight() / 2)) - (this.f٩٨٢٢e.getTop() + (this.f٩٨٢٢e.getHeight() / 2));
    }

    private Animator M(boolean z10) {
        FrameLayout frameLayout = this.f٩٨٢١d;
        return S(z10, frameLayout, K(frameLayout), L());
    }

    private Animator N(boolean z10) {
        long j10;
        Rect p10 = this.f٩٨٣١n.p();
        Rect o10 = this.f٩٨٣١n.o();
        if (p10 == null) {
            p10 = k0.c(this.f٩٨١٨a);
        }
        if (o10 == null) {
            o10 = k0.b(this.f٩٨٢٠c, this.f٩٨٣٣p);
        }
        final Rect rect = new Rect(o10);
        final float cornerSize = this.f٩٨٣٣p.getCornerSize();
        final float[] i02 = i0(this.f٩٨٢٠c.getCornerRadii(), this.f٩٨٣١n.n());
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.google.android.material.internal.s(rect), o10, p10);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.x
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b0.this.e0(cornerSize, i02, rect, valueAnimator);
            }
        });
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofObject.setDuration(j10);
        ofObject.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٨b));
        return ofObject;
    }

    private Animator O(boolean z10) {
        TimeInterpolator timeInterpolator;
        long j10;
        long j11;
        if (z10) {
            timeInterpolator = p7.a.f١٦٩٤٧a;
        } else {
            timeInterpolator = p7.a.f١٦٩٤٨b;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofFloat.setDuration(j10);
        if (z10) {
            j11 = 100;
        } else {
            j11 = 0;
        }
        ofFloat.setStartDelay(j11);
        ofFloat.setInterpolator(com.google.android.material.internal.t.a(z10, timeInterpolator));
        ofFloat.addUpdateListener(com.google.android.material.internal.o.e(this.f٩٨١٩b));
        return ofFloat;
    }

    private Animator P(boolean z10) {
        return T(z10, this.f٩٨٢٦i);
    }

    private AnimatorSet Q(boolean z10) {
        long j10;
        AnimatorSet animatorSet = new AnimatorSet();
        v(animatorSet);
        t(animatorSet);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٧a));
        return animatorSet;
    }

    private AnimatorSet R(boolean z10) {
        long j10;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(V());
        q(animatorSet);
        animatorSet.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٨b));
        if (z10) {
            j10 = 350;
        } else {
            j10 = 300;
        }
        animatorSet.setDuration(j10);
        return animatorSet;
    }

    private Animator S(boolean z10, View view, int i10, int i11) {
        long j10;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i10, DownloadProgress.UNKNOWN_PROGRESS);
        ofFloat.addUpdateListener(com.google.android.material.internal.o.k(view));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(i11, DownloadProgress.UNKNOWN_PROGRESS);
        ofFloat2.addUpdateListener(com.google.android.material.internal.o.l(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٨b));
        return animatorSet;
    }

    private Animator T(boolean z10, View view) {
        TextView placeholderTextView = this.f٩٨٣٣p.getPlaceholderTextView();
        if (TextUtils.isEmpty(placeholderTextView.getText()) || z10) {
            placeholderTextView = this.f٩٨٣٣p.getTextView();
        }
        return S(z10, view, W(placeholderTextView) - (view.getLeft() + this.f٩٨٢٥h.getLeft()), L());
    }

    private int U(View view, View view2) {
        if (view == null) {
            int marginStart = ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).getMarginStart();
            int paddingStart = this.f٩٨٣٣p.getPaddingStart();
            int W = W(this.f٩٨٣٣p);
            if (k0.m(this.f٩٨٣٣p)) {
                return (((W + this.f٩٨٣٣p.getWidth()) + marginStart) - paddingStart) - this.f٩٨١٨a.getRight();
            }
            return (W - marginStart) + paddingStart;
        }
        return W(view) - W(view2);
    }

    private Animator V() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f٩٨٢٠c.getHeight(), DownloadProgress.UNKNOWN_PROGRESS);
        ofFloat.addUpdateListener(com.google.android.material.internal.o.l(this.f٩٨٢٠c));
        return ofFloat;
    }

    private int W(View view) {
        int left = view.getLeft();
        for (ViewParent parent = view.getParent(); (parent instanceof View) && parent != this.f٩٨١٨a.getParent(); parent = parent.getParent()) {
            left += ((View) parent).getLeft();
        }
        return left;
    }

    private int X(View view) {
        int top = view.getTop();
        for (ViewParent parent = view.getParent(); (parent instanceof View) && parent != this.f٩٨١٨a.getParent(); parent = parent.getParent()) {
            top += ((View) parent).getTop();
        }
        return top;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(ImageButton imageButton, ValueAnimator valueAnimator) {
        imageButton.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(s1.d dVar, ValueAnimator valueAnimator) {
        dVar.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Rect rect, ValueAnimator valueAnimator) {
        rect.right = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f٩٨٢٧j.setClipBounds(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(com.google.android.material.internal.f fVar, ValueAnimator valueAnimator) {
        fVar.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(ValueAnimator valueAnimator) {
        this.f٩٨٢٧j.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.f٩٨٣٣p.getTextView().setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(float f10, float[] fArr, Rect rect, ValueAnimator valueAnimator) {
        this.f٩٨٢٠c.c(rect, h0(f10, fArr, valueAnimator.getAnimatedFraction()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0() {
        AnimatorSet J = J(true);
        J.addListener(new a());
        J.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0() {
        this.f٩٨٢٠c.setTranslationY(r0.getHeight());
        AnimatorSet R = R(true);
        R.addListener(new c());
        R.start();
    }

    private static float[] h0(float f10, float[] fArr, float f11) {
        return new float[]{p7.a.a(f10, fArr[0], f11), p7.a.a(f10, fArr[1], f11), p7.a.a(f10, fArr[2], f11), p7.a.a(f10, fArr[3], f11), p7.a.a(f10, fArr[4], f11), p7.a.a(f10, fArr[5], f11), p7.a.a(f10, fArr[6], f11), p7.a.a(f10, fArr[7], f11)};
    }

    private static float[] i0(float[] fArr, float[] fArr2) {
        return new float[]{Math.max(fArr[0], fArr2[0]), Math.max(fArr[1], fArr2[1]), Math.max(fArr[2], fArr2[2]), Math.max(fArr[3], fArr2[3]), Math.max(fArr[4], fArr2[4]), Math.max(fArr[5], fArr2[5]), Math.max(fArr[6], fArr2[6]), Math.max(fArr[7], fArr2[7])};
    }

    private void k0(float f10) {
        ActionMenuView a10;
        if (this.f٩٨١٨a.x() && (a10 = i0.a(this.f٩٨٢٣f)) != null) {
            a10.setAlpha(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(float f10) {
        this.f٩٨٢٨k.setAlpha(f10);
        this.f٩٨٢٩l.setAlpha(f10);
        this.f٩٨٣٠m.setAlpha(f10);
        k0(f10);
    }

    private void m0(Drawable drawable) {
        if (drawable instanceof s1.d) {
            ((s1.d) drawable).e(1.0f);
        }
        if (drawable instanceof com.google.android.material.internal.f) {
            ((com.google.android.material.internal.f) drawable).a(1.0f);
        }
    }

    private void n0(Toolbar toolbar) {
        ActionMenuView a10 = i0.a(toolbar);
        if (a10 != null) {
            for (int i10 = 0; i10 < a10.getChildCount(); i10++) {
                View childAt = a10.getChildAt(i10);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    private void o(AnimatorSet animatorSet) {
        ActionMenuView a10 = i0.a(this.f٩٨٢٣f);
        if (a10 == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(U(i0.a(this.f٩٨٣٣p), a10), DownloadProgress.UNKNOWN_PROGRESS);
        ofFloat.addUpdateListener(com.google.android.material.internal.o.k(a10));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(L(), DownloadProgress.UNKNOWN_PROGRESS);
        ofFloat2.addUpdateListener(com.google.android.material.internal.o.l(a10));
        animatorSet.playTogether(ofFloat, ofFloat2);
    }

    private void p(AnimatorSet animatorSet, final ImageButton imageButton) {
        SearchBar searchBar = this.f٩٨٣٣p;
        if (searchBar != null && searchBar.getNavigationIcon() == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.s
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b0.Z(imageButton, valueAnimator);
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    private void p0() {
        Menu menu = this.f٩٨٢٤g.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (this.f٩٨٣٣p.getMenuResId() != -1 && this.f٩٨١٨a.x()) {
            this.f٩٨٢٤g.inflateMenu(this.f٩٨٣٣p.getMenuResId());
            n0(this.f٩٨٢٤g);
            this.f٩٨٢٤g.setVisibility(0);
            return;
        }
        this.f٩٨٢٤g.setVisibility(8);
    }

    private void q(AnimatorSet animatorSet) {
        ImageButton d10 = i0.d(this.f٩٨٢٣f);
        if (d10 == null) {
            return;
        }
        Drawable q10 = h2.b.q(d10.getDrawable());
        if (this.f٩٨١٨a.v()) {
            s(animatorSet, q10);
            u(animatorSet, q10);
            p(animatorSet, d10);
            return;
        }
        m0(q10);
    }

    private void r(AnimatorSet animatorSet) {
        ImageButton d10 = i0.d(this.f٩٨٢٣f);
        if (d10 == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(U(i0.d(this.f٩٨٣٣p), d10), DownloadProgress.UNKNOWN_PROGRESS);
        ofFloat.addUpdateListener(com.google.android.material.internal.o.k(d10));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(L(), DownloadProgress.UNKNOWN_PROGRESS);
        ofFloat2.addUpdateListener(com.google.android.material.internal.o.l(d10));
        animatorSet.playTogether(ofFloat, ofFloat2);
    }

    private void s(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof s1.d) {
            final s1.d dVar = (s1.d) drawable;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.y
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b0.a0(s1.d.this, valueAnimator);
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    private AnimatorSet s0() {
        if (this.f٩٨١٨a.u()) {
            this.f٩٨١٨a.r();
        }
        AnimatorSet J = J(false);
        J.addListener(new b());
        J.start();
        return J;
    }

    private void t(AnimatorSet animatorSet) {
        if (this.f٩٨٣٣p != null && TextUtils.equals(this.f٩٨٢٧j.getText(), this.f٩٨٣٣p.getText())) {
            final Rect rect = new Rect(0, 0, this.f٩٨٢٧j.getWidth(), this.f٩٨٢٧j.getHeight());
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f٩٨٣٣p.getTextView().getWidth(), this.f٩٨٢٧j.getWidth());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.w
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b0.this.b0(rect, valueAnimator);
                }
            });
            animatorSet.playTogether(ofInt);
        }
    }

    private AnimatorSet t0() {
        if (this.f٩٨١٨a.u()) {
            this.f٩٨١٨a.r();
        }
        AnimatorSet R = R(false);
        R.addListener(new d());
        R.start();
        return R;
    }

    private void u(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof com.google.android.material.internal.f) {
            final com.google.android.material.internal.f fVar = (com.google.android.material.internal.f) drawable;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.z
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b0.c0(com.google.android.material.internal.f.this, valueAnimator);
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    private void u0() {
        if (this.f٩٨١٨a.u()) {
            this.f٩٨١٨a.L();
        }
        this.f٩٨١٨a.setTransitionState(SearchView.b.SHOWING);
        p0();
        this.f٩٨٢٧j.setText(this.f٩٨٣٣p.getText());
        EditText editText = this.f٩٨٢٧j;
        editText.setSelection(editText.getText().length());
        this.f٩٨٢٠c.setVisibility(4);
        this.f٩٨٢٠c.post(new Runnable() { // from class: com.google.android.material.search.t
            @Override // java.lang.Runnable
            public final void run() {
                b0.this.f0();
            }
        });
    }

    private void v(AnimatorSet animatorSet) {
        if (this.f٩٨٣٣p != null && !TextUtils.equals(this.f٩٨٢٧j.getText(), this.f٩٨٣٣p.getText())) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.a0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    b0.this.d0(valueAnimator);
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    private void v0() {
        if (this.f٩٨١٨a.u()) {
            final SearchView searchView = this.f٩٨١٨a;
            Objects.requireNonNull(searchView);
            searchView.postDelayed(new Runnable() { // from class: com.google.android.material.search.u
                @Override // java.lang.Runnable
                public final void run() {
                    SearchView.this.L();
                }
            }, 150L);
        }
        this.f٩٨٢٠c.setVisibility(4);
        this.f٩٨٢٠c.post(new Runnable() { // from class: com.google.android.material.search.v
            @Override // java.lang.Runnable
            public final void run() {
                b0.this.g0();
            }
        });
    }

    private Animator y(boolean z10) {
        long j10;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(com.google.android.material.internal.t.a(z10, p7.a.f١٦٩٤٨b));
        if (this.f٩٨١٨a.x()) {
            ofFloat.addUpdateListener(new com.google.android.material.internal.g(i0.a(this.f٩٨٢٤g), i0.a(this.f٩٨٢٣f)));
        }
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatorSet Y() {
        if (this.f٩٨٣٣p != null) {
            return s0();
        }
        return t0();
    }

    public BackEventCompat j0() {
        return this.f٩٨٣١n.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0(SearchBar searchBar) {
        this.f٩٨٣٣p = searchBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0() {
        if (this.f٩٨٣٣p != null) {
            u0();
        } else {
            v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r0(BackEventCompat backEventCompat) {
        this.f٩٨٣١n.x(backEventCompat, this.f٩٨٣٣p);
    }

    public void w() {
        this.f٩٨٣١n.i(this.f٩٨٣٣p);
        AnimatorSet animatorSet = this.f٩٨٣٢o;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        this.f٩٨٣٢o = null;
    }

    public void w0(BackEventCompat backEventCompat) {
        if (backEventCompat.getProgress() <= DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        a8.i iVar = this.f٩٨٣١n;
        SearchBar searchBar = this.f٩٨٣٣p;
        iVar.z(backEventCompat, searchBar, searchBar.getCornerSize());
        AnimatorSet animatorSet = this.f٩٨٣٢o;
        if (animatorSet != null) {
            animatorSet.setCurrentPlayTime(backEventCompat.getProgress() * ((float) this.f٩٨٣٢o.getDuration()));
            return;
        }
        if (this.f٩٨١٨a.u()) {
            this.f٩٨١٨a.r();
        }
        if (!this.f٩٨١٨a.v()) {
            return;
        }
        AnimatorSet A = A(false);
        this.f٩٨٣٢o = A;
        A.start();
        this.f٩٨٣٢o.pause();
    }

    public void x() {
        long totalDuration;
        totalDuration = Y().getTotalDuration();
        this.f٩٨٣١n.m(totalDuration, this.f٩٨٣٣p);
        if (this.f٩٨٣٢o != null) {
            B(false).start();
            this.f٩٨٣٢o.resume();
        }
        this.f٩٨٣٢o = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a8.i z() {
        return this.f٩٨٣١n;
    }
}
