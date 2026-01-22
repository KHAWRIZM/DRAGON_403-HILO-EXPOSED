package com.qmuiteam.qmui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.appcompat.app.a0;
import androidx.core.graphics.b0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import com.google.android.material.appbar.AppBarLayout;
import com.qmuiteam.qmui.R;
import ic.g;
import ic.i;
import ic.k;
import ic.l;
import ic.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUICollapsingTopBarLayout extends FrameLayout implements dc.a {
    private int A;

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٢٩٢٨a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٢٩٢٩b;

    /* renamed from: c, reason: collision with root package name */
    private QMUITopBar f١٢٩٣٠c;

    /* renamed from: d, reason: collision with root package name */
    private View f١٢٩٣١d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٢٩٣٢e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٢٩٣٣f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٩٣٤g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٢٩٣٥h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f١٢٩٣٦i;

    /* renamed from: j, reason: collision with root package name */
    final ic.b f١٢٩٣٧j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f١٢٩٣٨k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f١٢٩٣٩l;

    /* renamed from: m, reason: collision with root package name */
    Drawable f١٢٩٤٠m;

    /* renamed from: n, reason: collision with root package name */
    private int f١٢٩٤١n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f١٢٩٤٢o;

    /* renamed from: p, reason: collision with root package name */
    private ValueAnimator f١٢٩٤٣p;

    /* renamed from: q, reason: collision with root package name */
    private long f١٢٩٤٤q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٢٩٤٥r;

    /* renamed from: s, reason: collision with root package name */
    private AppBarLayout.h f١٢٩٤٦s;

    /* renamed from: t, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f١٢٩٤٧t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList f١٢٩٤٨u;

    /* renamed from: v, reason: collision with root package name */
    int f١٢٩٤٩v;

    /* renamed from: w, reason: collision with root package name */
    b0 f١٢٩٥٠w;

    /* renamed from: x, reason: collision with root package name */
    private int f١٢٩٥١x;

    /* renamed from: y, reason: collision with root package name */
    private int f١٢٩٥٢y;

    /* renamed from: z, reason: collision with root package name */
    private int f١٢٩٥٣z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements n.i {
        a() {
        }

        @Override // ic.n.i
        public void a(View view, b0 b0Var) {
            b0 b0Var2;
            if (d1.A(view)) {
                b0Var2 = b0Var;
            } else {
                b0Var2 = null;
            }
            if (!Objects.equals(QMUICollapsingTopBarLayout.this.f١٢٩٥٠w, b0Var)) {
                QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout = QMUICollapsingTopBarLayout.this;
                qMUICollapsingTopBarLayout.f١٢٩٥٠w = b0Var2;
                qMUICollapsingTopBarLayout.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QMUICollapsingTopBarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private class d implements AppBarLayout.h {
        d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.b
        public void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
            QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout = QMUICollapsingTopBarLayout.this;
            qMUICollapsingTopBarLayout.f١٢٩٤٩v = i10;
            int windowInsetTop = qMUICollapsingTopBarLayout.getWindowInsetTop();
            int childCount = QMUICollapsingTopBarLayout.this.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = QMUICollapsingTopBarLayout.this.getChildAt(i11);
                c cVar = (c) childAt.getLayoutParams();
                l l10 = QMUICollapsingTopBarLayout.l(childAt);
                int i12 = cVar.f١٢٩٥٦a;
                if (i12 != 1) {
                    if (i12 == 2) {
                        l10.h(Math.round((-i10) * cVar.f١٢٩٥٧b));
                    }
                } else {
                    l10.h(g.c(-i10, 0, QMUICollapsingTopBarLayout.this.k(childAt)));
                }
            }
            QMUICollapsingTopBarLayout.this.o();
            QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout2 = QMUICollapsingTopBarLayout.this;
            if (qMUICollapsingTopBarLayout2.f١٢٩٤٠m != null && windowInsetTop > 0) {
                d1.h0(qMUICollapsingTopBarLayout2);
            }
            QMUICollapsingTopBarLayout.this.f١٢٩٣٧j.M(Math.abs(i10) / ((QMUICollapsingTopBarLayout.this.getHeight() - d1.E(QMUICollapsingTopBarLayout.this)) - windowInsetTop));
            Iterator it = QMUICollapsingTopBarLayout.this.f١٢٩٤٨u.iterator();
            if (!it.hasNext()) {
                return;
            }
            a0.a(it.next());
            throw null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface e {
    }

    public QMUICollapsingTopBarLayout(Context context) {
        this(context, null);
    }

    private void d(int i10) {
        Interpolator interpolator;
        e();
        ValueAnimator valueAnimator = this.f١٢٩٤٣p;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f١٢٩٤٣p = valueAnimator2;
            valueAnimator2.setDuration(this.f١٢٩٤٤q);
            ValueAnimator valueAnimator3 = this.f١٢٩٤٣p;
            if (i10 > this.f١٢٩٤١n) {
                interpolator = yb.a.f١٩٢٣٣c;
            } else {
                interpolator = yb.a.f١٩٢٣٤d;
            }
            valueAnimator3.setInterpolator(interpolator);
            this.f١٢٩٤٣p.addUpdateListener(new b());
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f١٢٩٤٧t;
            if (animatorUpdateListener != null) {
                this.f١٢٩٤٣p.addUpdateListener(animatorUpdateListener);
            }
        } else if (valueAnimator.isRunning()) {
            this.f١٢٩٤٣p.cancel();
        }
        this.f١٢٩٤٣p.setIntValues(this.f١٢٩٤١n, i10);
        this.f١٢٩٤٣p.start();
    }

    private void e() {
        if (!this.f١٢٩٢٨a) {
            return;
        }
        QMUITopBar qMUITopBar = null;
        this.f١٢٩٣٠c = null;
        this.f١٢٩٣١d = null;
        int i10 = this.f١٢٩٢٩b;
        if (i10 != -1) {
            QMUITopBar qMUITopBar2 = (QMUITopBar) findViewById(i10);
            this.f١٢٩٣٠c = qMUITopBar2;
            if (qMUITopBar2 != null) {
                this.f١٢٩٣١d = f(qMUITopBar2);
            }
        }
        if (this.f١٢٩٣٠c == null) {
            int childCount = getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i11);
                if (childAt instanceof QMUITopBar) {
                    qMUITopBar = (QMUITopBar) childAt;
                    break;
                }
                i11++;
            }
            this.f١٢٩٣٠c = qMUITopBar;
        }
        this.f١٢٩٢٨a = false;
    }

    private View f(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWindowInsetTop() {
        b0 b0Var = this.f١٢٩٥٠w;
        if (b0Var != null) {
            return b0Var.f٢٧٩٤b;
        }
        return 0;
    }

    private static int j(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return view.getHeight();
    }

    static l l(View view) {
        int i10 = R.id.qmui_view_offset_helper;
        l lVar = (l) view.getTag(i10);
        if (lVar == null) {
            l lVar2 = new l(view);
            view.setTag(i10, lVar2);
            return lVar2;
        }
        return lVar;
    }

    private boolean m(View view) {
        View view2 = this.f١٢٩٣١d;
        if (view2 != null && view2 != this) {
            if (view != view2) {
                return false;
            }
        } else if (view != this.f١٢٩٣٠c) {
            return false;
        }
        return true;
    }

    private void setContentScrimInner(Drawable drawable) {
        Drawable drawable2 = this.f١٢٩٣٩l;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f١٢٩٣٩l = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.f١٢٩٣٩l.setCallback(this);
                this.f١٢٩٣٩l.setAlpha(this.f١٢٩٤١n);
            }
            d1.h0(this);
        }
    }

    private void setStatusBarScrimInner(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f١٢٩٤٠m;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f١٢٩٤٠m = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f١٢٩٤٠m.setState(getDrawableState());
                }
                h2.b.m(this.f١٢٩٤٠m, d1.D(this));
                Drawable drawable4 = this.f١٢٩٤٠m;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable4.setVisible(z10, false);
                this.f١٢٩٤٠m.setCallback(this);
                this.f١٢٩٤٠m.setAlpha(this.f١٢٩٤١n);
            }
            d1.h0(this);
        }
    }

    @Override // dc.a
    public boolean a(int i10, Resources.Theme theme) {
        if (this.f١٢٩٥١x != 0) {
            setContentScrimInner(i.g(getContext(), theme, this.f١٢٩٥١x));
        }
        if (this.f١٢٩٥٢y != 0) {
            setStatusBarScrimInner(i.g(getContext(), theme, this.f١٢٩٥٢y));
        }
        int i11 = this.f١٢٩٥٣z;
        if (i11 != 0) {
            this.f١٢٩٣٧j.E(dc.d.b(this, i11));
        }
        int i12 = this.A;
        if (i12 != 0) {
            this.f١٢٩٣٧j.J(dc.d.b(this, i12));
            return false;
        }
        return false;
    }

    public void addOnOffsetUpdateListener(e eVar) {
        this.f١٢٩٤٨u.add(eVar);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        super.dispatchApplyWindowInsets(windowInsets);
        return windowInsets;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int windowInsetTop;
        Drawable drawable;
        super.draw(canvas);
        e();
        if (this.f١٢٩٣٠c == null && (drawable = this.f١٢٩٣٩l) != null && this.f١٢٩٤١n > 0) {
            drawable.mutate().setAlpha(this.f١٢٩٤١n);
            this.f١٢٩٣٩l.draw(canvas);
        }
        if (this.f١٢٩٣٨k) {
            this.f١٢٩٣٧j.g(canvas);
        }
        if (this.f١٢٩٤٠m != null && this.f١٢٩٤١n > 0 && (windowInsetTop = getWindowInsetTop()) > 0) {
            this.f١٢٩٤٠m.setBounds(0, -this.f١٢٩٤٩v, getWidth(), windowInsetTop - this.f١٢٩٤٩v);
            this.f١٢٩٤٠m.mutate().setAlpha(this.f١٢٩٤١n);
            this.f١٢٩٤٠m.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z10;
        if (this.f١٢٩٣٩l != null && this.f١٢٩٤١n > 0 && m(view)) {
            this.f١٢٩٣٩l.mutate().setAlpha(this.f١٢٩٤١n);
            this.f١٢٩٣٩l.draw(canvas);
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
        Drawable drawable = this.f١٢٩٤٠m;
        if (drawable != null && drawable.isStateful()) {
            z10 = drawable.setState(drawableState);
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f١٢٩٣٩l;
        if (drawable2 != null && drawable2.isStateful()) {
            z10 |= drawable2.setState(drawableState);
        }
        ic.b bVar = this.f١٢٩٣٧j;
        if (bVar != null) {
            z10 |= bVar.Q(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    public void g() {
        int i10 = R.attr.qmui_skin_support_topbar_title_color;
        setCollapsedTextColorSkinAttr(i10);
        setExpandedTextColorSkinAttr(i10);
        int i11 = R.attr.qmui_skin_support_topbar_bg;
        setContentScrimSkinAttr(i11);
        setStatusBarScrimSkinAttr(i11);
    }

    public int getCollapsedTitleGravity() {
        return this.f١٢٩٣٧j.i();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f١٢٩٣٧j.l();
    }

    public Drawable getContentScrim() {
        return this.f١٢٩٣٩l;
    }

    public int getExpandedTitleGravity() {
        return this.f١٢٩٣٧j.o();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f١٢٩٣٥h;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f١٢٩٣٤g;
    }

    public int getExpandedTitleMarginStart() {
        return this.f١٢٩٣٢e;
    }

    public int getExpandedTitleMarginTop() {
        return this.f١٢٩٣٣f;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f١٢٩٣٧j.r();
    }

    int getScrimAlpha() {
        return this.f١٢٩٤١n;
    }

    public long getScrimAnimationDuration() {
        return this.f١٢٩٤٤q;
    }

    public int getScrimVisibleHeightTrigger() {
        int i10 = this.f١٢٩٤٥r;
        if (i10 >= 0) {
            return i10;
        }
        int windowInsetTop = getWindowInsetTop();
        int E = d1.E(this);
        if (E > 0) {
            return Math.min((E * 2) + windowInsetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f١٢٩٤٠m;
    }

    public CharSequence getTitle() {
        if (this.f١٢٩٣٨k) {
            return this.f١٢٩٣٧j.t();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    final int k(View view) {
        return ((getHeight() - l(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    public void n(boolean z10, boolean z11) {
        if (this.f١٢٩٤٢o != z10) {
            int i10 = 0;
            if (z11) {
                if (z10) {
                    i10 = KotlinVersion.MAX_COMPONENT_VALUE;
                }
                d(i10);
            } else {
                if (z10) {
                    i10 = KotlinVersion.MAX_COMPONENT_VALUE;
                }
                setScrimAlpha(i10);
            }
            this.f١٢٩٤٢o = z10;
        }
    }

    final void o() {
        boolean z10;
        if (this.f١٢٩٣٩l != null || this.f١٢٩٤٠m != null) {
            if (getHeight() + this.f١٢٩٤٩v < getScrimVisibleHeightTrigger()) {
                z10 = true;
            } else {
                z10 = false;
            }
            setScrimsShown(z10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            d1.y0(this, d1.A((View) parent));
            if (this.f١٢٩٤٦s == null) {
                this.f١٢٩٤٦s = new d();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.f١٢٩٤٦s);
            d1.n0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.h hVar = this.f١٢٩٤٦s;
        if (hVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(hVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f١٢٩٥٠w != null) {
            int windowInsetTop = getWindowInsetTop();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (d1.A(childAt) && childAt.getTop() < windowInsetTop) {
                    d1.b0(childAt, windowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            l(getChildAt(i15)).f(false);
        }
        if (this.f١٢٩٣٨k) {
            View view = this.f١٢٩٣١d;
            if (view == null) {
                view = this.f١٢٩٣٠c;
            }
            int k10 = k(view);
            k.c(this, this.f١٢٩٣٠c, this.f١٢٩٣٦i);
            Rect titleContainerRect = this.f١٢٩٣٠c.getTitleContainerRect();
            ic.b bVar = this.f١٢٩٣٧j;
            Rect rect = this.f١٢٩٣٦i;
            int i16 = rect.left;
            int i17 = titleContainerRect.left + i16;
            int i18 = rect.top;
            bVar.C(i17, i18 + k10 + titleContainerRect.top, i16 + titleContainerRect.right, i18 + k10 + titleContainerRect.bottom);
            this.f١٢٩٣٧j.H(this.f١٢٩٣٢e, this.f١٢٩٣٦i.top + this.f١٢٩٣٣f, (i12 - i10) - this.f١٢٩٣٤g, (i13 - i11) - this.f١٢٩٣٥h);
            this.f١٢٩٣٧j.A();
        }
        if (this.f١٢٩٣٠c != null) {
            if (this.f١٢٩٣٨k && TextUtils.isEmpty(this.f١٢٩٣٧j.t())) {
                this.f١٢٩٣٧j.R(this.f١٢٩٣٠c.getTitle());
            }
            View view2 = this.f١٢٩٣١d;
            if (view2 != null && view2 != this) {
                setMinimumHeight(j(view2));
            } else {
                setMinimumHeight(j(this.f١٢٩٣٠c));
            }
        }
        o();
        int childCount3 = getChildCount();
        for (int i19 = 0; i19 < childCount3; i19++) {
            l(getChildAt(i19)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        e();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f١٢٩٣٩l;
        if (drawable != null) {
            drawable.setBounds(0, 0, i10, i11);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof QMUITopBar) {
            ((QMUITopBar) view).e();
        }
    }

    public void removeOnOffsetUpdateListener(e eVar) {
        this.f١٢٩٤٨u.remove(eVar);
    }

    public void setCollapsedTextColorSkinAttr(int i10) {
        this.f١٢٩٥٣z = i10;
        if (i10 != 0) {
            this.f١٢٩٣٧j.E(dc.d.b(this, i10));
        }
    }

    public void setCollapsedTitleGravity(int i10) {
        this.f١٢٩٣٧j.F(i10);
    }

    public void setCollapsedTitleTextAppearance(int i10) {
        this.f١٢٩٣٧j.D(i10);
    }

    public void setCollapsedTitleTextColor(int i10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f١٢٩٣٧j.G(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        this.f١٢٩٥١x = 0;
        setContentScrimInner(drawable);
    }

    public void setContentScrimColor(int i10) {
        setContentScrim(new ColorDrawable(i10));
    }

    public void setContentScrimResource(int i10) {
        setContentScrim(androidx.core.content.a.getDrawable(getContext(), i10));
    }

    public void setContentScrimSkinAttr(int i10) {
        this.f١٢٩٥١x = i10;
        if (i10 != 0) {
            setStatusBarScrimInner(dc.d.c(this, i10));
        }
    }

    public void setExpandedTextColorSkinAttr(int i10) {
        this.A = i10;
        if (i10 != 0) {
            this.f١٢٩٣٧j.J(dc.d.b(this, i10));
        }
    }

    public void setExpandedTitleColor(int i10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedTitleGravity(int i10) {
        this.f١٢٩٣٧j.K(i10);
    }

    public void setExpandedTitleMarginBottom(int i10) {
        this.f١٢٩٣٥h = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i10) {
        this.f١٢٩٣٤g = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i10) {
        this.f١٢٩٣٢e = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i10) {
        this.f١٢٩٣٣f = i10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i10) {
        this.f١٢٩٣٧j.I(i10);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.A = 0;
        this.f١٢٩٣٧j.J(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f١٢٩٣٧j.L(typeface);
    }

    void setScrimAlpha(int i10) {
        QMUITopBar qMUITopBar;
        if (i10 != this.f١٢٩٤١n) {
            if (this.f١٢٩٣٩l != null && (qMUITopBar = this.f١٢٩٣٠c) != null) {
                d1.h0(qMUITopBar);
            }
            this.f١٢٩٤١n = i10;
            d1.h0(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j10) {
        this.f١٢٩٤٤q = j10;
    }

    public void setScrimUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = this.f١٢٩٤٧t;
        if (animatorUpdateListener2 != animatorUpdateListener) {
            ValueAnimator valueAnimator = this.f١٢٩٤٣p;
            if (valueAnimator == null) {
                this.f١٢٩٤٧t = animatorUpdateListener;
                return;
            }
            if (animatorUpdateListener2 != null) {
                valueAnimator.removeUpdateListener(animatorUpdateListener2);
            }
            this.f١٢٩٤٧t = animatorUpdateListener;
            if (animatorUpdateListener != null) {
                this.f١٢٩٤٣p.addUpdateListener(animatorUpdateListener);
            }
        }
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i10) {
        if (this.f١٢٩٤٥r != i10) {
            this.f١٢٩٤٥r = i10;
            o();
        }
    }

    public void setScrimsShown(boolean z10) {
        boolean z11;
        if (d1.V(this) && !isInEditMode()) {
            z11 = true;
        } else {
            z11 = false;
        }
        n(z10, z11);
    }

    public void setStatusBarScrim(Drawable drawable) {
        this.f١٢٩٥٢y = 0;
        setStatusBarScrimInner(drawable);
    }

    public void setStatusBarScrimColor(int i10) {
        setStatusBarScrim(new ColorDrawable(i10));
    }

    public void setStatusBarScrimResource(int i10) {
        setStatusBarScrim(androidx.core.content.a.getDrawable(getContext(), i10));
    }

    public void setStatusBarScrimSkinAttr(int i10) {
        this.f١٢٩٥٢y = i10;
        if (i10 != 0) {
            setStatusBarScrimInner(dc.d.c(this, i10));
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f١٢٩٣٧j.R(charSequence);
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.f١٢٩٣٨k) {
            this.f١٢٩٣٨k = z10;
            requestLayout();
        }
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
        Drawable drawable = this.f١٢٩٤٠m;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f١٢٩٤٠m.setVisible(z10, false);
        }
        Drawable drawable2 = this.f١٢٩٣٩l;
        if (drawable2 != null && drawable2.isVisible() != z10) {
            this.f١٢٩٣٩l.setVisible(z10, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.f١٢٩٣٩l && drawable != this.f١٢٩٤٠m) {
            return false;
        }
        return true;
    }

    public QMUICollapsingTopBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f١٢٩٥٣z = 0;
        this.f١٢٩٣٧j.E(colorStateList);
    }

    public QMUICollapsingTopBarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٩٢٨a = true;
        this.f١٢٩٣٦i = new Rect();
        this.f١٢٩٤٥r = -1;
        this.f١٢٩٤٨u = new ArrayList();
        this.f١٢٩٥١x = 0;
        this.f١٢٩٥٢y = 0;
        this.f١٢٩٥٣z = 0;
        this.A = 0;
        ic.b bVar = new ic.b(this);
        this.f١٢٩٣٧j = bVar;
        bVar.U(yb.a.f١٩٢٣٥e);
        k.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUICollapsingTopBarLayout, i10, 0);
        bVar.K(obtainStyledAttributes.getInt(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleGravity, 81));
        bVar.F(obtainStyledAttributes.getInt(R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMargin, 0);
        this.f١٢٩٣٥h = dimensionPixelSize;
        this.f١٢٩٣٤g = dimensionPixelSize;
        this.f١٢٩٣٣f = dimensionPixelSize;
        this.f١٢٩٣٢e = dimensionPixelSize;
        int i11 = R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginStart;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f١٢٩٣٢e = obtainStyledAttributes.getDimensionPixelSize(i11, 0);
        }
        int i12 = R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginEnd;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.f١٢٩٣٤g = obtainStyledAttributes.getDimensionPixelSize(i12, 0);
        }
        int i13 = R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginTop;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.f١٢٩٣٣f = obtainStyledAttributes.getDimensionPixelSize(i13, 0);
        }
        int i14 = R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginBottom;
        if (obtainStyledAttributes.hasValue(i14)) {
            this.f١٢٩٣٥h = obtainStyledAttributes.getDimensionPixelSize(i14, 0);
        }
        this.f١٢٩٣٨k = obtainStyledAttributes.getBoolean(R.styleable.QMUICollapsingTopBarLayout_qmui_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(R.styleable.QMUICollapsingTopBarLayout_qmui_title));
        bVar.I(R.style.QMUI_CollapsingTopBarLayoutExpanded);
        bVar.D(R.style.QMUI_CollapsingTopBarLayoutCollapsed);
        int i15 = R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleTextAppearance;
        if (obtainStyledAttributes.hasValue(i15)) {
            bVar.I(obtainStyledAttributes.getResourceId(i15, 0));
        }
        int i16 = R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleTextAppearance;
        if (obtainStyledAttributes.hasValue(i16)) {
            bVar.D(obtainStyledAttributes.getResourceId(i16, 0));
        }
        this.f١٢٩٤٥r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_scrimVisibleHeightTrigger, -1);
        this.f١٢٩٤٤q = obtainStyledAttributes.getInt(R.styleable.QMUICollapsingTopBarLayout_qmui_scrimAnimationDuration, 600);
        this.f١٢٩٢٩b = obtainStyledAttributes.getResourceId(R.styleable.QMUICollapsingTopBarLayout_qmui_topBarId, -1);
        if (obtainStyledAttributes.getBoolean(R.styleable.QMUICollapsingTopBarLayout_qmui_followTopBarCommonSkin, false)) {
            g();
        } else {
            setContentScrimInner(obtainStyledAttributes.getDrawable(R.styleable.QMUICollapsingTopBarLayout_qmui_contentScrim));
            setStatusBarScrimInner(obtainStyledAttributes.getDrawable(R.styleable.QMUICollapsingTopBarLayout_qmui_statusBarScrim));
        }
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        n.e(this, d2.m.f() | d2.m.a(), new a(), true, false, true);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class c extends FrameLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f١٢٩٥٦a;

        /* renamed from: b, reason: collision with root package name */
        float f١٢٩٥٧b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f١٢٩٥٦a = 0;
            this.f١٢٩٥٧b = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUICollapsingTopBarLayout_Layout);
            this.f١٢٩٥٦a = obtainStyledAttributes.getInt(R.styleable.QMUICollapsingTopBarLayout_Layout_qmui_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(R.styleable.QMUICollapsingTopBarLayout_Layout_qmui_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f10) {
            this.f١٢٩٥٧b = f10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f١٢٩٥٦a = 0;
            this.f١٢٩٥٧b = 0.5f;
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f١٢٩٥٦a = 0;
            this.f١٢٩٥٧b = 0.5f;
        }
    }
}
