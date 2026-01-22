package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.d0;
import com.google.android.material.internal.h0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int L = R.style.Widget_Design_CollapsingToolbar;
    private AppBarLayout.h A;

    /* renamed from: B, reason: collision with root package name */
    int f٨١٧٠B;
    private int C;
    private int D;
    d2 E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private boolean J;
    private int K;

    /* renamed from: a, reason: collision with root package name */
    private boolean f٨١٧١a;

    /* renamed from: b, reason: collision with root package name */
    private int f٨١٧٢b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f٨١٧٣c;

    /* renamed from: d, reason: collision with root package name */
    private View f٨١٧٤d;

    /* renamed from: e, reason: collision with root package name */
    private View f٨١٧٥e;

    /* renamed from: f, reason: collision with root package name */
    private int f٨١٧٦f;

    /* renamed from: g, reason: collision with root package name */
    private int f٨١٧٧g;

    /* renamed from: h, reason: collision with root package name */
    private int f٨١٧٨h;

    /* renamed from: i, reason: collision with root package name */
    private int f٨١٧٩i;

    /* renamed from: j, reason: collision with root package name */
    private int f٨١٨٠j;

    /* renamed from: k, reason: collision with root package name */
    private final Rect f٨١٨١k;

    /* renamed from: l, reason: collision with root package name */
    final com.google.android.material.internal.b f٨١٨٢l;

    /* renamed from: m, reason: collision with root package name */
    final com.google.android.material.internal.b f٨١٨٣m;

    /* renamed from: n, reason: collision with root package name */
    final x7.a f٨١٨٤n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٨١٨٥o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f٨١٨٦p;

    /* renamed from: q, reason: collision with root package name */
    private final int f٨١٨٧q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f٨١٨٨r;

    /* renamed from: s, reason: collision with root package name */
    Drawable f٨١٨٩s;

    /* renamed from: t, reason: collision with root package name */
    private int f٨١٩٠t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f٨١٩١u;

    /* renamed from: v, reason: collision with root package name */
    private ValueAnimator f٨١٩٢v;

    /* renamed from: w, reason: collision with root package name */
    private long f٨١٩٣w;

    /* renamed from: x, reason: collision with root package name */
    private final TimeInterpolator f٨١٩٤x;

    /* renamed from: y, reason: collision with root package name */
    private final TimeInterpolator f٨١٩٥y;

    /* renamed from: z, reason: collision with root package name */
    private int f٨١٩٦z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements j0 {
        a() {
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            return CollapsingToolbarLayout.this.p(d2Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class d implements AppBarLayout.h {
        d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
            int i11;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f٨١٧٠B = i10;
            d2 d2Var = collapsingToolbarLayout.E;
            if (d2Var != null) {
                i11 = d2Var.m();
            } else {
                i11 = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i12);
                c cVar = (c) childAt.getLayoutParams();
                l l10 = CollapsingToolbarLayout.l(childAt);
                int i13 = cVar.f٨١٩٩a;
                if (i13 != 1) {
                    if (i13 == 2) {
                        l10.f(Math.round((-i10) * cVar.f٨٢٠٠b));
                    }
                } else {
                    l10.f(j2.a.b(-i10, 0, CollapsingToolbarLayout.this.i(childAt)));
                }
            }
            CollapsingToolbarLayout.this.w();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f٨١٨٩s != null && i11 > 0) {
                collapsingToolbarLayout2.postInvalidateOnAnimation();
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int minimumHeight = (height - CollapsingToolbarLayout.this.getMinimumHeight()) - i11;
            int scrimVisibleHeightTrigger = height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger();
            int i14 = CollapsingToolbarLayout.this.f٨١٧٠B + minimumHeight;
            float f10 = minimumHeight;
            float abs = Math.abs(i10) / f10;
            float f11 = scrimVisibleHeightTrigger / f10;
            CollapsingToolbarLayout.this.f٨١٨٢l.F0(Math.min(1.0f, f11));
            CollapsingToolbarLayout.this.f٨١٨٢l.q0(i14);
            CollapsingToolbarLayout.this.f٨١٨٢l.D0(abs);
            CollapsingToolbarLayout.this.f٨١٨٣m.F0(Math.min(1.0f, f11));
            CollapsingToolbarLayout.this.f٨١٨٣m.q0(i14);
            CollapsingToolbarLayout.this.f٨١٨٣m.D0(abs);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface e extends d0 {
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    private void a(int i10) {
        TimeInterpolator timeInterpolator;
        d();
        ValueAnimator valueAnimator = this.f٨١٩٢v;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f٨١٩٢v = valueAnimator2;
            if (i10 > this.f٨١٩٠t) {
                timeInterpolator = this.f٨١٩٤x;
            } else {
                timeInterpolator = this.f٨١٩٥y;
            }
            valueAnimator2.setInterpolator(timeInterpolator);
            this.f٨١٩٢v.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.f٨١٩٢v.cancel();
        }
        this.f٨١٩٢v.setDuration(this.f٨١٩٣w);
        this.f٨١٩٢v.setIntValues(this.f٨١٩٠t, i10);
        this.f٨١٩٢v.start();
    }

    private TextUtils.TruncateAt b(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 3) {
                    return TextUtils.TruncateAt.END;
                }
                return TextUtils.TruncateAt.MARQUEE;
            }
            return TextUtils.TruncateAt.MIDDLE;
        }
        return TextUtils.TruncateAt.START;
    }

    private void c(AppBarLayout appBarLayout) {
        if (m()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void d() {
        if (!this.f٨١٧١a) {
            return;
        }
        ViewGroup viewGroup = null;
        this.f٨١٧٣c = null;
        this.f٨١٧٤d = null;
        int i10 = this.f٨١٧٢b;
        if (i10 != -1) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(i10);
            this.f٨١٧٣c = viewGroup2;
            if (viewGroup2 != null) {
                this.f٨١٧٤d = e(viewGroup2);
            }
        }
        if (this.f٨١٧٣c == null) {
            int childCount = getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i11);
                if (n(childAt)) {
                    viewGroup = (ViewGroup) childAt;
                    break;
                }
                i11++;
            }
            this.f٨١٧٣c = viewGroup;
        }
        v();
        this.f٨١٧١a = false;
    }

    private View e(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList h10 = v7.a.h(getContext(), R.attr.colorSurfaceContainer);
        if (h10 != null) {
            return h10.getDefaultColor();
        }
        return this.f٨١٨٤n.d(getResources().getDimension(R.dimen.design_appbar_elevation));
    }

    private static int h(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getMeasuredHeight();
    }

    private static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getSubtitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getSubtitle();
        }
        return null;
    }

    private static CharSequence k(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    static l l(View view) {
        int i10 = R.id.view_offset_helper;
        l lVar = (l) view.getTag(i10);
        if (lVar == null) {
            l lVar2 = new l(view);
            view.setTag(i10, lVar2);
            return lVar2;
        }
        return lVar;
    }

    private boolean m() {
        if (this.D == 1) {
            return true;
        }
        return false;
    }

    private static boolean n(View view) {
        if (!(view instanceof Toolbar) && !(view instanceof android.widget.Toolbar)) {
            return false;
        }
        return true;
    }

    private boolean o(View view) {
        View view2 = this.f٨١٧٤d;
        if (view2 != null && view2 != this) {
            if (view != view2) {
                return false;
            }
        } else if (view != this.f٨١٧٣c) {
            return false;
        }
        return true;
    }

    private void r(boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        View view = this.f٨١٧٤d;
        if (view == null) {
            view = this.f٨١٧٣c;
        }
        int i17 = i(view);
        com.google.android.material.internal.d.a(this, this.f٨١٧٥e, this.f٨١٨١k);
        ViewGroup viewGroup = this.f٨١٧٣c;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i10 = toolbar.getTitleMarginStart();
            i12 = toolbar.getTitleMarginEnd();
            i13 = toolbar.getTitleMarginTop();
            i11 = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT >= 24 && (viewGroup instanceof android.widget.Toolbar)) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i10 = toolbar2.getTitleMarginStart();
            i12 = toolbar2.getTitleMarginEnd();
            i13 = toolbar2.getTitleMarginTop();
            i11 = toolbar2.getTitleMarginBottom();
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        Rect rect = this.f٨١٨١k;
        int i18 = rect.left;
        if (z10) {
            i14 = i12;
        } else {
            i14 = i10;
        }
        int i19 = i18 + i14;
        int i20 = rect.right;
        if (z10) {
            i15 = i10;
        } else {
            i15 = i12;
        }
        int i21 = i20 - i15;
        int i22 = rect.top + i17 + i13;
        int i23 = (rect.bottom + i17) - i11;
        int m10 = (int) (i23 - this.f٨١٨٣m.m());
        int m11 = (int) (i22 + this.f٨١٨٢l.m());
        if (TextUtils.isEmpty(this.f٨١٨٣m.P())) {
            this.f٨١٨٢l.f0(i19, i22, i21, i23);
        } else {
            this.f٨١٨٢l.f0(i19, i22, i21, m10);
            this.f٨١٨٣m.f0(i19, m11, i21, i23);
        }
        if (this.f٨١٨٧q == 0) {
            com.google.android.material.internal.d.a(this, this, this.f٨١٨١k);
            Rect rect2 = this.f٨١٨١k;
            int i24 = rect2.left;
            if (z10) {
                i16 = i12;
            } else {
                i16 = i10;
            }
            int i25 = i24 + i16;
            int i26 = rect2.right;
            if (!z10) {
                i10 = i12;
            }
            int i27 = i26 - i10;
            if (TextUtils.isEmpty(this.f٨١٨٣m.P())) {
                this.f٨١٨٢l.h0(i25, i22, i27, i23);
            } else {
                this.f٨١٨٢l.h0(i25, i22, i27, m10);
                this.f٨١٨٣m.h0(i25, m11, i27, i23);
            }
        }
    }

    private void s() {
        setContentDescription(getTitle());
    }

    private void t(Drawable drawable, int i10, int i11) {
        u(drawable, this.f٨١٧٣c, i10, i11);
    }

    private void u(Drawable drawable, View view, int i10, int i11) {
        if (m() && view != null && this.f٨١٨٥o) {
            i11 = view.getBottom();
        }
        drawable.setBounds(0, 0, i10, i11);
    }

    private void v() {
        View view;
        if (!this.f٨١٨٥o && (view = this.f٨١٧٥e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f٨١٧٥e);
            }
        }
        if (this.f٨١٨٥o && this.f٨١٧٣c != null) {
            if (this.f٨١٧٥e == null) {
                this.f٨١٧٥e = new View(getContext());
            }
            if (this.f٨١٧٥e.getParent() == null) {
                this.f٨١٧٣c.addView(this.f٨١٧٥e, -1, -1);
            }
        }
    }

    private void x(int i10, int i11, int i12, int i13, boolean z10) {
        View view;
        boolean z11;
        int i14;
        int i15;
        if (this.f٨١٨٥o && (view = this.f٨١٧٥e) != null) {
            boolean z12 = false;
            if (view.isAttachedToWindow() && this.f٨١٧٥e.getVisibility() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f٨١٨٦p = z11;
            if (z11 || z10) {
                if (getLayoutDirection() == 1) {
                    z12 = true;
                }
                r(z12);
                if (z12) {
                    i14 = this.f٨١٧٨h;
                } else {
                    i14 = this.f٨١٧٦f;
                }
                int i16 = this.f٨١٨١k.top + this.f٨١٧٧g;
                int i17 = i12 - i10;
                if (z12) {
                    i15 = this.f٨١٧٦f;
                } else {
                    i15 = this.f٨١٧٨h;
                }
                int i18 = i17 - i15;
                int i19 = (i13 - i11) - this.f٨١٧٩i;
                if (TextUtils.isEmpty(this.f٨١٨٣m.P())) {
                    this.f٨١٨٢l.r0(i14, i16, i18, i19);
                    this.f٨١٨٢l.c0(z10);
                    return;
                }
                int i20 = i14;
                this.f٨١٨٢l.s0(i20, i16, i18, (int) ((i19 - (this.f٨١٨٣m.B() + this.I)) - this.f٨١٨٠j), false);
                this.f٨١٨٣m.s0(i20, (int) (i16 + this.f٨١٨٢l.B() + this.H + this.f٨١٨٠j), i18, i19, false);
                this.f٨١٨٢l.c0(z10);
                this.f٨١٨٣m.c0(z10);
            }
        }
    }

    private void y() {
        ViewGroup viewGroup = this.f٨١٧٣c;
        if (viewGroup != null && this.f٨١٨٥o) {
            CharSequence k10 = k(viewGroup);
            if (TextUtils.isEmpty(this.f٨١٨٢l.P()) && !TextUtils.isEmpty(k10)) {
                setTitle(k10);
            }
            CharSequence j10 = j(this.f٨١٧٣c);
            if (TextUtils.isEmpty(this.f٨١٨٣m.P()) && !TextUtils.isEmpty(j10)) {
                setSubtitle(j10);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.f٨١٧٣c == null && (drawable = this.f٨١٨٨r) != null && this.f٨١٩٠t > 0) {
            drawable.mutate().setAlpha(this.f٨١٩٠t);
            this.f٨١٨٨r.draw(canvas);
        }
        if (this.f٨١٨٥o && this.f٨١٨٦p) {
            if (this.f٨١٧٣c != null && this.f٨١٨٨r != null && this.f٨١٩٠t > 0 && m() && this.f٨١٨٢l.H() < this.f٨١٨٢l.I()) {
                int save = canvas.save();
                canvas.clipRect(this.f٨١٨٨r.getBounds(), Region.Op.DIFFERENCE);
                this.f٨١٨٢l.k(canvas);
                this.f٨١٨٣m.k(canvas);
                canvas.restoreToCount(save);
            } else {
                this.f٨١٨٢l.k(canvas);
                this.f٨١٨٣m.k(canvas);
            }
        }
        if (this.f٨١٨٩s != null && this.f٨١٩٠t > 0) {
            d2 d2Var = this.E;
            if (d2Var != null) {
                i10 = d2Var.m();
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                this.f٨١٨٩s.setBounds(0, -this.f٨١٧٠B, getWidth(), i10 - this.f٨١٧٠B);
                this.f٨١٨٩s.mutate().setAlpha(this.f٨١٩٠t);
                this.f٨١٨٩s.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z10;
        if (this.f٨١٨٨r != null && this.f٨١٩٠t > 0 && o(view)) {
            u(this.f٨١٨٨r, view, getWidth(), getHeight());
            this.f٨١٨٨r.mutate().setAlpha(this.f٨١٩٠t);
            this.f٨١٨٨r.draw(canvas);
            z10 = true;
        } else {
            z10 = false;
        }
        if (super.drawChild(canvas, view, j10) || z10) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        boolean z10;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f٨١٨٩s;
        if (drawable != null && drawable.isStateful()) {
            z10 = drawable.setState(drawableState);
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f٨١٨٨r;
        if (drawable2 != null && drawable2.isStateful()) {
            z10 |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.b bVar = this.f٨١٨٢l;
        if (bVar != null) {
            z10 |= bVar.M0(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public float getCollapsedSubtitleTextSize() {
        return this.f٨١٨٣m.u();
    }

    public Typeface getCollapsedSubtitleTypeface() {
        return this.f٨١٨٣m.v();
    }

    public int getCollapsedTitleGravity() {
        return this.f٨١٨٢l.q();
    }

    public float getCollapsedTitleTextSize() {
        return this.f٨١٨٢l.u();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f٨١٨٢l.v();
    }

    public Drawable getContentScrim() {
        return this.f٨١٨٨r;
    }

    public float getExpandedSubtitleTextSize() {
        return this.f٨١٨٣m.F();
    }

    public Typeface getExpandedSubtitleTypeface() {
        return this.f٨١٨٣m.G();
    }

    public int getExpandedTitleGravity() {
        return this.f٨١٨٢l.C();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f٨١٧٩i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f٨١٧٨h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f٨١٧٦f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f٨١٧٧g;
    }

    public int getExpandedTitleSpacing() {
        return this.f٨١٨٠j;
    }

    public float getExpandedTitleTextSize() {
        return this.f٨١٨٢l.F();
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f٨١٨٢l.G();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.f٨١٨٢l.J();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.f٨١٨٢l.K();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.f٨١٨٢l.L();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.f٨١٨٢l.M();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.f٨١٨٢l.A();
    }

    int getScrimAlpha() {
        return this.f٨١٩٠t;
    }

    public long getScrimAnimationDuration() {
        return this.f٨١٩٣w;
    }

    public int getScrimVisibleHeightTrigger() {
        int i10;
        int i11 = this.f٨١٩٦z;
        if (i11 >= 0) {
            return i11 + this.F + this.H + this.I + this.K;
        }
        d2 d2Var = this.E;
        if (d2Var != null) {
            i10 = d2Var.m();
        } else {
            i10 = 0;
        }
        int minimumHeight = getMinimumHeight();
        if (minimumHeight > 0) {
            return Math.min((minimumHeight * 2) + i10, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f٨١٨٩s;
    }

    public CharSequence getSubtitle() {
        if (this.f٨١٨٥o) {
            return this.f٨١٨٣m.P();
        }
        return null;
    }

    public CharSequence getTitle() {
        if (this.f٨١٨٥o) {
            return this.f٨١٨٢l.P();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.D;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f٨١٨٢l.O();
    }

    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f٨١٨٢l.S();
    }

    final int i(View view) {
        return ((getHeight() - l(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            setFitsSystemWindows(appBarLayout.getFitsSystemWindows());
            if (this.A == null) {
                this.A = new d();
            }
            appBarLayout.addOnOffsetChangedListener(this.A);
            requestApplyInsets();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f٨١٨٢l.Z(configuration);
        if (this.C != configuration.orientation && this.J && this.f٨١٨٢l.H() == 1.0f) {
            ViewParent parent = getParent();
            if (parent instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) parent;
                if (appBarLayout.getPendingAction() == 0) {
                    appBarLayout.setPendingAction(2);
                }
            }
        }
        this.C = configuration.orientation;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.h hVar = this.A;
        if (hVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(hVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        d2 d2Var = this.E;
        if (d2Var != null) {
            int m10 = d2Var.m();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < m10) {
                    d1.b0(childAt, m10);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            l(getChildAt(i15)).d();
        }
        x(i10, i11, i12, i13, false);
        y();
        w();
        int childCount3 = getChildCount();
        for (int i16 = 0; i16 < childCount3; i16++) {
            l(getChildAt(i16)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        float B2;
        d();
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        d2 d2Var = this.E;
        if (d2Var != null) {
            i12 = d2Var.m();
        } else {
            i12 = 0;
        }
        if ((mode == 0 || this.G) && i12 > 0) {
            this.F = i12;
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i12, 1073741824));
        }
        y();
        if (this.f٨١٨٥o && !TextUtils.isEmpty(this.f٨١٨٢l.P())) {
            int measuredHeight = getMeasuredHeight();
            x(0, 0, getMeasuredWidth(), measuredHeight, true);
            float B3 = this.F + this.f٨١٧٧g + this.f٨١٨٢l.B();
            if (TextUtils.isEmpty(this.f٨١٨٣m.P())) {
                B2 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                B2 = this.f٨١٨٠j + this.f٨١٨٣m.B();
            }
            int i13 = (int) (B3 + B2 + this.f٨١٧٩i);
            if (i13 > measuredHeight) {
                this.K = i13 - measuredHeight;
            } else {
                this.K = 0;
            }
            if (this.J) {
                if (this.f٨١٨٢l.A() > 1) {
                    int z10 = this.f٨١٨٢l.z();
                    if (z10 > 1) {
                        this.H = Math.round(this.f٨١٨٢l.B()) * (z10 - 1);
                    } else {
                        this.H = 0;
                    }
                }
                if (this.f٨١٨٣m.A() > 1) {
                    int z11 = this.f٨١٨٣m.z();
                    if (z11 > 1) {
                        this.I = Math.round(this.f٨١٨٣m.B()) * (z11 - 1);
                    } else {
                        this.I = 0;
                    }
                }
            }
            int i14 = this.K;
            int i15 = this.H;
            int i16 = this.I;
            if (i14 + i15 + i16 > 0) {
                super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(measuredHeight + i14 + i15 + i16, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f٨١٧٣c;
        if (viewGroup != null) {
            View view = this.f٨١٧٤d;
            if (view != null && view != this) {
                setMinimumHeight(h(view));
            } else {
                setMinimumHeight(h(viewGroup));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f٨١٨٨r;
        if (drawable != null) {
            t(drawable, i10, i11);
        }
    }

    d2 p(d2 d2Var) {
        d2 d2Var2;
        if (getFitsSystemWindows()) {
            d2Var2 = d2Var;
        } else {
            d2Var2 = null;
        }
        if (!androidx.core.util.f.a(this.E, d2Var2)) {
            this.E = d2Var2;
            requestLayout();
        }
        return d2Var.c();
    }

    public void q(boolean z10, boolean z11) {
        if (this.f٨١٩١u != z10) {
            int i10 = 0;
            if (z11) {
                if (z10) {
                    i10 = KotlinVersion.MAX_COMPONENT_VALUE;
                }
                a(i10);
            } else {
                if (z10) {
                    i10 = KotlinVersion.MAX_COMPONENT_VALUE;
                }
                setScrimAlpha(i10);
            }
            this.f٨١٩١u = z10;
        }
    }

    public void setCollapsedSubtitleTextAppearance(int i10) {
        this.f٨١٨٣m.j0(i10);
    }

    public void setCollapsedSubtitleTextColor(int i10) {
        setCollapsedSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setCollapsedSubtitleTextSize(float f10) {
        this.f٨١٨٣m.n0(f10);
    }

    public void setCollapsedSubtitleTypeface(Typeface typeface) {
        this.f٨١٨٣m.o0(typeface);
    }

    public void setCollapsedTitleGravity(int i10) {
        this.f٨١٨٢l.m0(i10);
        this.f٨١٨٣m.m0(i10);
    }

    public void setCollapsedTitleTextAppearance(int i10) {
        this.f٨١٨٢l.j0(i10);
    }

    public void setCollapsedTitleTextColor(int i10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setCollapsedTitleTextSize(float f10) {
        this.f٨١٨٢l.n0(f10);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f٨١٨٢l.o0(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f٨١٨٨r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f٨١٨٨r = drawable3;
            if (drawable3 != null) {
                t(drawable3, getWidth(), getHeight());
                this.f٨١٨٨r.setCallback(this);
                this.f٨١٨٨r.setAlpha(this.f٨١٩٠t);
            }
            postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(int i10) {
        setContentScrim(new ColorDrawable(i10));
    }

    public void setContentScrimResource(int i10) {
        setContentScrim(getContext().getDrawable(i10));
    }

    public void setExpandedSubtitleColor(int i10) {
        setExpandedSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedSubtitleTextAppearance(int i10) {
        this.f٨١٨٣m.w0(i10);
    }

    public void setExpandedSubtitleTextColor(ColorStateList colorStateList) {
        this.f٨١٨٣m.y0(colorStateList);
    }

    public void setExpandedSubtitleTextSize(float f10) {
        this.f٨١٨٣m.A0(f10);
    }

    public void setExpandedSubtitleTypeface(Typeface typeface) {
        this.f٨١٨٣m.B0(typeface);
    }

    public void setExpandedTitleColor(int i10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedTitleGravity(int i10) {
        this.f٨١٨٢l.z0(i10);
        this.f٨١٨٣m.z0(i10);
    }

    public void setExpandedTitleMarginBottom(int i10) {
        this.f٨١٧٩i = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i10) {
        this.f٨١٧٨h = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i10) {
        this.f٨١٧٦f = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i10) {
        this.f٨١٧٧g = i10;
        requestLayout();
    }

    public void setExpandedTitleSpacing(int i10) {
        this.f٨١٨٠j = i10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i10) {
        this.f٨١٨٢l.w0(i10);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f٨١٨٢l.y0(colorStateList);
    }

    public void setExpandedTitleTextSize(float f10) {
        this.f٨١٨٢l.A0(f10);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f٨١٨٢l.B0(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z10) {
        this.J = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z10) {
        this.G = z10;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i10) {
        this.f٨١٨٢l.G0(i10);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f10) {
        this.f٨١٨٢l.I0(f10);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f10) {
        this.f٨١٨٢l.J0(f10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i10) {
        this.f٨١٨٢l.v0(i10);
        this.f٨١٨٣m.v0(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z10) {
        this.f٨١٨٢l.L0(z10);
    }

    void setScrimAlpha(int i10) {
        ViewGroup viewGroup;
        if (i10 != this.f٨١٩٠t) {
            if (this.f٨١٨٨r != null && (viewGroup = this.f٨١٧٣c) != null) {
                viewGroup.postInvalidateOnAnimation();
            }
            this.f٨١٩٠t = i10;
            postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j10) {
        this.f٨١٩٣w = j10;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i10) {
        if (this.f٨١٩٦z != i10) {
            this.f٨١٩٦z = i10;
            w();
        }
    }

    public void setScrimsShown(boolean z10) {
        boolean z11;
        if (isLaidOut() && !isInEditMode()) {
            z11 = true;
        } else {
            z11 = false;
        }
        q(z10, z11);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStaticLayoutBuilderConfigurer(e eVar) {
        this.f٨١٨٢l.N0(eVar);
    }

    public void setStatusBarScrim(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f٨١٨٩s;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f٨١٨٩s = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f٨١٨٩s.setState(getDrawableState());
                }
                h2.b.m(this.f٨١٨٩s, getLayoutDirection());
                Drawable drawable4 = this.f٨١٨٩s;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable4.setVisible(z10, false);
                this.f٨١٨٩s.setCallback(this);
                this.f٨١٨٩s.setAlpha(this.f٨١٩٠t);
            }
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(int i10) {
        setStatusBarScrim(new ColorDrawable(i10));
    }

    public void setStatusBarScrimResource(int i10) {
        setStatusBarScrim(getContext().getDrawable(i10));
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f٨١٨٣m.O0(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.f٨١٨٢l.O0(charSequence);
        s();
    }

    public void setTitleCollapseMode(int i10) {
        this.D = i10;
        boolean m10 = m();
        this.f٨١٨٢l.E0(m10);
        this.f٨١٨٣m.E0(m10);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (m10 && this.f٨١٨٨r == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f٨١٨٢l.Q0(truncateAt);
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.f٨١٨٥o) {
            this.f٨١٨٥o = z10;
            s();
            v();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        this.f٨١٨٢l.K0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.f٨١٨٩s;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f٨١٨٩s.setVisible(z10, false);
        }
        Drawable drawable2 = this.f٨١٨٨r;
        if (drawable2 != null && drawable2.isVisible() != z10) {
            this.f٨١٨٨r.setVisible(z10, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f٨١٨٨r && drawable != this.f٨١٨٩s) {
            return false;
        }
        return true;
    }

    final void w() {
        boolean z10;
        if (this.f٨١٨٨r != null || this.f٨١٨٩s != null) {
            if (getHeight() + this.f٨١٧٠B < getScrimVisibleHeightTrigger()) {
                z10 = true;
            } else {
                z10 = false;
            }
            setScrimsShown(z10);
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedSubtitleTextColor(ColorStateList colorStateList) {
        this.f٨١٨٣m.l0(colorStateList);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f٨١٨٢l.l0(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = L;
        this.f٨١٧١a = true;
        this.f٨١٨١k = new Rect();
        this.f٨١٩٦z = -1;
        this.F = 0;
        this.H = 0;
        this.I = 0;
        this.K = 0;
        Context context2 = getContext();
        this.C = getResources().getConfiguration().orientation;
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.f٨١٨٢l = bVar;
        TimeInterpolator timeInterpolator = p7.a.f١٦٩٥١e;
        bVar.P0(timeInterpolator);
        bVar.L0(false);
        this.f٨١٨٤n = new x7.a(context2);
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.CollapsingToolbarLayout, i10, i11, new int[0]);
        int i13 = i12.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691);
        int i14 = i12.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627);
        this.f٨١٨٧q = i12.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravityMode, 1);
        bVar.z0(i13);
        bVar.m0(i14);
        int dimensionPixelSize = i12.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f٨١٧٩i = dimensionPixelSize;
        this.f٨١٧٨h = dimensionPixelSize;
        this.f٨١٧٧g = dimensionPixelSize;
        this.f٨١٧٦f = dimensionPixelSize;
        int i15 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (i12.hasValue(i15)) {
            this.f٨١٧٦f = i12.getDimensionPixelSize(i15, 0);
        }
        int i16 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (i12.hasValue(i16)) {
            this.f٨١٧٨h = i12.getDimensionPixelSize(i16, 0);
        }
        int i17 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (i12.hasValue(i17)) {
            this.f٨١٧٧g = i12.getDimensionPixelSize(i17, 0);
        }
        int i18 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (i12.hasValue(i18)) {
            this.f٨١٧٩i = i12.getDimensionPixelSize(i18, 0);
        }
        int i19 = R.styleable.CollapsingToolbarLayout_expandedTitleSpacing;
        if (i12.hasValue(i19)) {
            this.f٨١٨٠j = i12.getDimensionPixelSize(i19, 0);
        }
        this.f٨١٨٥o = i12.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(i12.getText(R.styleable.CollapsingToolbarLayout_title));
        bVar.w0(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        bVar.j0(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int i20 = R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (i12.hasValue(i20)) {
            bVar.w0(i12.getResourceId(i20, 0));
        }
        int i21 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (i12.hasValue(i21)) {
            bVar.j0(i12.getResourceId(i21, 0));
        }
        int i22 = R.styleable.CollapsingToolbarLayout_titleTextEllipsize;
        if (i12.hasValue(i22)) {
            setTitleEllipsize(b(i12.getInt(i22, -1)));
        }
        int i23 = R.styleable.CollapsingToolbarLayout_expandedTitleTextColor;
        if (i12.hasValue(i23)) {
            bVar.y0(c8.c.a(context2, i12, i23));
        }
        int i24 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor;
        if (i12.hasValue(i24)) {
            bVar.l0(c8.c.a(context2, i12, i24));
        }
        this.f٨١٩٦z = i12.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        int i25 = R.styleable.CollapsingToolbarLayout_titleMaxLines;
        if (i12.hasValue(i25)) {
            bVar.v0(i12.getInt(i25, 1));
        } else {
            int i26 = R.styleable.CollapsingToolbarLayout_maxLines;
            if (i12.hasValue(i26)) {
                bVar.v0(i12.getInt(i26, 1));
            }
        }
        int i27 = R.styleable.CollapsingToolbarLayout_titlePositionInterpolator;
        if (i12.hasValue(i27)) {
            bVar.K0(AnimationUtils.loadInterpolator(context2, i12.getResourceId(i27, 0)));
        }
        com.google.android.material.internal.b bVar2 = new com.google.android.material.internal.b(this);
        this.f٨١٨٣m = bVar2;
        bVar2.P0(timeInterpolator);
        bVar2.L0(false);
        int i28 = R.styleable.CollapsingToolbarLayout_subtitle;
        if (i12.hasValue(i28)) {
            setSubtitle(i12.getText(i28));
        }
        bVar2.z0(i13);
        bVar2.m0(i14);
        bVar2.w0(androidx.appcompat.R.style.TextAppearance_AppCompat_Headline);
        bVar2.j0(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Subtitle);
        int i29 = R.styleable.CollapsingToolbarLayout_expandedSubtitleTextAppearance;
        if (i12.hasValue(i29)) {
            bVar2.w0(i12.getResourceId(i29, 0));
        }
        int i30 = R.styleable.CollapsingToolbarLayout_collapsedSubtitleTextAppearance;
        if (i12.hasValue(i30)) {
            bVar2.j0(i12.getResourceId(i30, 0));
        }
        int i31 = R.styleable.CollapsingToolbarLayout_expandedSubtitleTextColor;
        if (i12.hasValue(i31)) {
            bVar2.y0(c8.c.a(context2, i12, i31));
        }
        int i32 = R.styleable.CollapsingToolbarLayout_collapsedSubtitleTextColor;
        if (i12.hasValue(i32)) {
            bVar2.l0(c8.c.a(context2, i12, i32));
        }
        int i33 = R.styleable.CollapsingToolbarLayout_subtitleMaxLines;
        if (i12.hasValue(i33)) {
            bVar2.v0(i12.getInt(i33, 1));
        }
        if (i12.hasValue(i27)) {
            bVar2.K0(AnimationUtils.loadInterpolator(context2, i12.getResourceId(i27, 0)));
        }
        this.f٨١٩٣w = i12.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        int i34 = R.attr.motionEasingStandardInterpolator;
        this.f٨١٩٤x = a8.k.g(context2, i34, p7.a.f١٦٩٤٩c);
        this.f٨١٩٥y = a8.k.g(context2, i34, p7.a.f١٦٩٥٠d);
        setContentScrim(i12.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(i12.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(i12.getInt(R.styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.f٨١٧٢b = i12.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.G = i12.getBoolean(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.J = i12.getBoolean(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        i12.recycle();
        setWillNotDraw(false);
        d1.E0(this, new a());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f٨١٩٩a;

        /* renamed from: b, reason: collision with root package name */
        float f٨٢٠٠b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٨١٩٩a = 0;
            this.f٨٢٠٠b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f٨١٩٩a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f10) {
            this.f٨٢٠٠b = f10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f٨١٩٩a = 0;
            this.f٨٢٠٠b = 0.5f;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f٨١٩٩a = 0;
            this.f٨٢٠٠b = 0.5f;
        }
    }
}
