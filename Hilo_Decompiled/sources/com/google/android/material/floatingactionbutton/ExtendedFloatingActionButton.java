package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.h0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    /* renamed from: c0, reason: collision with root package name */
    private static final int f٩٠١٥c0 = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;

    /* renamed from: d0, reason: collision with root package name */
    static final Property f٩٠١٦d0 = new f(Float.class, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);

    /* renamed from: e0, reason: collision with root package name */
    static final Property f٩٠١٧e0 = new g(Float.class, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);

    /* renamed from: f0, reason: collision with root package name */
    static final Property f٩٠١٨f0 = new h(Float.class, "paddingStart");

    /* renamed from: g0, reason: collision with root package name */
    static final Property f٩٠١٩g0 = new i(Float.class, "paddingEnd");
    private int H;
    private boolean I;
    private final com.google.android.material.floatingactionbutton.a J;
    private final com.google.android.material.floatingactionbutton.f K;
    private final com.google.android.material.floatingactionbutton.f L;
    private final com.google.android.material.floatingactionbutton.f M;
    private final com.google.android.material.floatingactionbutton.f N;
    private final int O;
    private int P;
    private int Q;
    private final CoordinatorLayout.c R;
    private boolean S;
    private boolean T;
    private boolean U;
    protected ColorStateList V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f٩٠٢٠a0;

    /* renamed from: b0, reason: collision with root package name */
    private final int f٩٠٢١b0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements n {
        a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams b() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int c() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements n {
        b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return ExtendedFloatingActionButton.this.Q;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams b() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int c() {
            return ExtendedFloatingActionButton.this.P;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            return ((ExtendedFloatingActionButton.this.getMeasuredWidth() - ExtendedFloatingActionButton.this.getPaddingStart()) - ExtendedFloatingActionButton.this.getPaddingEnd()) + ExtendedFloatingActionButton.this.P + ExtendedFloatingActionButton.this.Q;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f٩٠٢٧a;

        c(n nVar) {
            this.f٩٠٢٧a = nVar;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return ExtendedFloatingActionButton.this.Q;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams b() {
            int i10;
            if (ExtendedFloatingActionButton.this.f٩٠٢٠a0 != 0) {
                i10 = ExtendedFloatingActionButton.this.f٩٠٢٠a0;
            } else {
                i10 = -2;
            }
            return new ViewGroup.LayoutParams(-1, i10);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int c() {
            return ExtendedFloatingActionButton.this.P;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            int i10;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (ExtendedFloatingActionButton.this.f٩٠٢٠a0 == -1) {
                if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                    return this.f٩٠٢٧a.getHeight();
                }
                View view = (View) ExtendedFloatingActionButton.this.getParent();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null && layoutParams.height == -2) {
                    return this.f٩٠٢٧a.getHeight();
                }
                int paddingTop = view.getPaddingTop() + view.getPaddingBottom();
                if ((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) != null) {
                    i10 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    i10 = 0;
                }
                return (view.getHeight() - i10) - paddingTop;
            }
            if (ExtendedFloatingActionButton.this.f٩٠٢٠a0 != 0 && ExtendedFloatingActionButton.this.f٩٠٢٠a0 != -2) {
                return ExtendedFloatingActionButton.this.f٩٠٢٠a0;
            }
            return this.f٩٠٢٧a.getHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            int i10;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.f٩٠٢٧a.getWidth();
            }
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && layoutParams.width == -2) {
                return this.f٩٠٢٧a.getWidth();
            }
            int paddingLeft = view.getPaddingLeft() + view.getPaddingRight();
            if ((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) != null) {
                i10 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            } else {
                i10 = 0;
            }
            return (view.getWidth() - i10) - paddingLeft;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f٩٠٢٩a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f٩٠٣٠b;

        d(n nVar, n nVar2) {
            this.f٩٠٢٩a = nVar;
            this.f٩٠٣٠b = nVar2;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return ExtendedFloatingActionButton.this.Q;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams b() {
            int i10;
            int i11 = -2;
            if (ExtendedFloatingActionButton.this.W != 0) {
                i10 = ExtendedFloatingActionButton.this.W;
            } else {
                i10 = -2;
            }
            if (ExtendedFloatingActionButton.this.f٩٠٢٠a0 != 0) {
                i11 = ExtendedFloatingActionButton.this.f٩٠٢٠a0;
            }
            return new ViewGroup.LayoutParams(i10, i11);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int c() {
            return ExtendedFloatingActionButton.this.P;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            if (ExtendedFloatingActionButton.this.f٩٠٢٠a0 == -1) {
                return this.f٩٠٢٩a.getHeight();
            }
            if (ExtendedFloatingActionButton.this.f٩٠٢٠a0 != 0 && ExtendedFloatingActionButton.this.f٩٠٢٠a0 != -2) {
                return ExtendedFloatingActionButton.this.f٩٠٢٠a0;
            }
            return this.f٩٠٣٠b.getHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getWidth() {
            if (ExtendedFloatingActionButton.this.W == -1) {
                return this.f٩٠٢٩a.getWidth();
            }
            if (ExtendedFloatingActionButton.this.W != 0 && ExtendedFloatingActionButton.this.W != -2) {
                return ExtendedFloatingActionButton.this.W;
            }
            return this.f٩٠٣٠b.getWidth();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f٩٠٣٢a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.f f٩٠٣٣b;

        e(com.google.android.material.floatingactionbutton.f fVar, l lVar) {
            this.f٩٠٣٣b = fVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f٩٠٣٢a = true;
            this.f٩٠٣٣b.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f٩٠٣٣b.g();
            if (!this.f٩٠٣٢a) {
                this.f٩٠٣٣b.i(null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f٩٠٣٣b.onAnimationStart(animator);
            this.f٩٠٣٢a = false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            view.getLayoutParams().width = f10.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            view.getLayoutParams().height = f10.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class h extends Property {
        h(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getPaddingStart());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            view.setPaddingRelative(f10.intValue(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class i extends Property {
        i(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getPaddingEnd());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class j extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g, reason: collision with root package name */
        private final n f٩٠٣٥g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f٩٠٣٦h;

        j(com.google.android.material.floatingactionbutton.a aVar, n nVar, boolean z10) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f٩٠٣٥g = nVar;
            this.f٩٠٣٦h = z10;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.S = this.f٩٠٣٦h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (!this.f٩٠٣٦h) {
                ExtendedFloatingActionButton.this.W = layoutParams.width;
                ExtendedFloatingActionButton.this.f٩٠٢٠a0 = layoutParams.height;
            }
            layoutParams.width = this.f٩٠٣٥g.b().width;
            layoutParams.height = this.f٩٠٣٥g.b().height;
            if (this.f٩٠٣٦h) {
                ExtendedFloatingActionButton extendedFloatingActionButton = ExtendedFloatingActionButton.this;
                extendedFloatingActionButton.S(extendedFloatingActionButton.V);
            } else if (ExtendedFloatingActionButton.this.getText() != null && ExtendedFloatingActionButton.this.getText() != "") {
                ExtendedFloatingActionButton.this.S(ColorStateList.valueOf(0));
            }
            ExtendedFloatingActionButton.this.setPaddingRelative(this.f٩٠٣٥g.c(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f٩٠٣٥g.a(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean d() {
            if (this.f٩٠٣٦h != ExtendedFloatingActionButton.this.S && ExtendedFloatingActionButton.this.getIcon() != null && !TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText())) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int f() {
            if (this.f٩٠٣٦h) {
                return R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
            }
            return R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void g() {
            super.g();
            ExtendedFloatingActionButton.this.T = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f٩٠٣٥g.b().width;
            layoutParams.height = this.f٩٠٣٥g.b().height;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public AnimatorSet h() {
            float f10;
            p7.h l10 = l();
            if (l10.j(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                PropertyValuesHolder[] g10 = l10.g(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                g10[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f٩٠٣٥g.getWidth());
                l10.l(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, g10);
            }
            if (l10.j(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                PropertyValuesHolder[] g11 = l10.g(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                g11[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f٩٠٣٥g.getHeight());
                l10.l(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, g11);
            }
            if (l10.j("paddingStart")) {
                PropertyValuesHolder[] g12 = l10.g("paddingStart");
                g12[0].setFloatValues(ExtendedFloatingActionButton.this.getPaddingStart(), this.f٩٠٣٥g.c());
                l10.l("paddingStart", g12);
            }
            if (l10.j("paddingEnd")) {
                PropertyValuesHolder[] g13 = l10.g("paddingEnd");
                g13[0].setFloatValues(ExtendedFloatingActionButton.this.getPaddingEnd(), this.f٩٠٣٥g.a());
                l10.l("paddingEnd", g13);
            }
            if (l10.j("labelOpacity")) {
                PropertyValuesHolder[] g14 = l10.g("labelOpacity");
                boolean z10 = this.f٩٠٣٦h;
                float f11 = 1.0f;
                if (z10) {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    f10 = 1.0f;
                }
                if (!z10) {
                    f11 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                g14[0].setFloatValues(f10, f11);
                l10.l("labelOpacity", g14);
            }
            return super.k(l10);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void i(l lVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.S = this.f٩٠٣٦h;
            ExtendedFloatingActionButton.this.T = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class k extends com.google.android.material.floatingactionbutton.b {

        /* renamed from: g, reason: collision with root package name */
        private boolean f٩٠٣٨g;

        public k(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean d() {
            return ExtendedFloatingActionButton.this.N();
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void e() {
            super.e();
            this.f٩٠٣٨g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int f() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void g() {
            super.g();
            ExtendedFloatingActionButton.this.H = 0;
            if (!this.f٩٠٣٨g) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void i(l lVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f٩٠٣٨g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.H = 1;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class l {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class m extends com.google.android.material.floatingactionbutton.b {
        public m(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void b() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean d() {
            return ExtendedFloatingActionButton.this.O();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int f() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void g() {
            super.g();
            ExtendedFloatingActionButton.this.H = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void i(l lVar) {
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.H = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface n {
        int a();

        ViewGroup.LayoutParams b();

        int c();

        int getHeight();

        int getWidth();
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }

    private n M(int i10) {
        b bVar = new b();
        c cVar = new c(bVar);
        d dVar = new d(cVar, bVar);
        if (i10 != 1) {
            if (i10 != 2) {
                return dVar;
            }
            return cVar;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N() {
        if (getVisibility() == 0) {
            if (this.H != 1) {
                return false;
            }
            return true;
        }
        if (this.H == 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean O() {
        if (getVisibility() != 0) {
            if (this.H != 2) {
                return false;
            }
            return true;
        }
        if (this.H == 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i10, l lVar) {
        com.google.android.material.floatingactionbutton.f fVar;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        fVar = this.L;
                    } else {
                        throw new IllegalStateException("Unknown strategy type: " + i10);
                    }
                } else {
                    fVar = this.K;
                }
            } else {
                fVar = this.N;
            }
        } else {
            fVar = this.M;
        }
        if (fVar.d()) {
            return;
        }
        if (!R()) {
            fVar.b();
            fVar.i(lVar);
            return;
        }
        if (i10 == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                this.W = layoutParams.width;
                this.f٩٠٢٠a0 = layoutParams.height;
            } else {
                this.W = getWidth();
                this.f٩٠٢٠a0 = getHeight();
            }
        }
        measure(0, 0);
        AnimatorSet h10 = fVar.h();
        h10.addListener(new e(fVar, lVar));
        Iterator it = fVar.getListeners().iterator();
        while (it.hasNext()) {
            h10.addListener((Animator.AnimatorListener) it.next());
        }
        h10.start();
    }

    private void Q() {
        this.V = getTextColors();
    }

    private boolean R() {
        if (this.I && ((isLaidOut() || (!O() && this.U)) && !isInEditMode())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        return this.R;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    int getCollapsedSize() {
        int i10 = this.O;
        if (i10 < 0) {
            return (Math.min(getPaddingStart(), getPaddingEnd()) * 2) + getIconSize();
        }
        return i10;
    }

    public p7.h getExtendMotionSpec() {
        return this.L.c();
    }

    public p7.h getHideMotionSpec() {
        return this.N.c();
    }

    public p7.h getShowMotionSpec() {
        return this.M.c();
    }

    public p7.h getShrinkMotionSpec() {
        return this.K.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.S && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.S = false;
            this.K.b();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
        this.U = z10;
    }

    public void setAnimationEnabled(boolean z10) {
        this.I = z10;
    }

    public void setExtendMotionSpec(p7.h hVar) {
        this.L.a(hVar);
    }

    public void setExtendMotionSpecResource(int i10) {
        setExtendMotionSpec(p7.h.d(getContext(), i10));
    }

    public void setExtended(boolean z10) {
        com.google.android.material.floatingactionbutton.f fVar;
        if (this.S == z10) {
            return;
        }
        if (z10) {
            fVar = this.L;
        } else {
            fVar = this.K;
        }
        if (fVar.d()) {
            return;
        }
        fVar.b();
    }

    public void setHideMotionSpec(p7.h hVar) {
        this.N.a(hVar);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(p7.h.d(getContext(), i10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        if (this.S && !this.T) {
            this.P = getPaddingStart();
            this.Q = getPaddingEnd();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
        if (this.S && !this.T) {
            this.P = i10;
            this.Q = i12;
        }
    }

    public void setShowMotionSpec(p7.h hVar) {
        this.M.a(hVar);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(p7.h.d(getContext(), i10));
    }

    public void setShrinkMotionSpec(p7.h hVar) {
        this.K.a(hVar);
    }

    public void setShrinkMotionSpecResource(int i10) {
        setShrinkMotionSpec(p7.h.d(getContext(), i10));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        super.setTextColor(i10);
        Q();
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c {

        /* renamed from: a, reason: collision with root package name */
        private Rect f٩٠٢٢a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f٩٠٢٣b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f٩٠٢٤c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f٩٠٢٣b = false;
            this.f٩٠٢٤c = true;
        }

        private static boolean M(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean P(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f٩٠٢٣b && !this.f٩٠٢٤c) || fVar.e() != view.getId()) {
                return false;
            }
            return true;
        }

        private boolean R(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!P(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f٩٠٢٢a == null) {
                this.f٩٠٢٢a = new Rect();
            }
            Rect rect = this.f٩٠٢٢a;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                Q(extendedFloatingActionButton);
                return true;
            }
            K(extendedFloatingActionButton);
            return true;
        }

        private boolean S(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!P(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                Q(extendedFloatingActionButton);
                return true;
            }
            K(extendedFloatingActionButton);
            return true;
        }

        protected void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i10;
            if (this.f٩٠٢٤c) {
                i10 = 3;
            } else {
                i10 = 0;
            }
            extendedFloatingActionButton.P(i10, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.h(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: N, reason: merged with bridge method [inline-methods] */
        public boolean n(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                R(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (M(view)) {
                S(view, extendedFloatingActionButton);
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: O, reason: merged with bridge method [inline-methods] */
        public boolean r(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
            List x10 = coordinatorLayout.x(extendedFloatingActionButton);
            int size = x10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = (View) x10.get(i11);
                if (view instanceof AppBarLayout) {
                    if (R(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (M(view) && S(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.O(extendedFloatingActionButton, i10);
            return true;
        }

        protected void Q(ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i10;
            if (this.f٩٠٢٤c) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            extendedFloatingActionButton.P(i10, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void m(CoordinatorLayout.f fVar) {
            if (fVar.f٢٥٦٧h == 0) {
                fVar.f٢٥٦٧h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f٩٠٢٣b = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f٩٠٢٤c = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r9), attributeSet, i10);
        int i11 = f٩٠١٥c0;
        this.H = 0;
        this.I = true;
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a();
        this.J = aVar;
        m mVar = new m(aVar);
        this.M = mVar;
        k kVar = new k(aVar);
        this.N = kVar;
        this.S = true;
        this.T = false;
        this.U = false;
        Context context2 = getContext();
        this.R = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray i12 = h0.i(context2, attributeSet, R.styleable.ExtendedFloatingActionButton, i10, i11, new int[0]);
        p7.h c10 = p7.h.c(context2, i12, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        p7.h c11 = p7.h.c(context2, i12, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        p7.h c12 = p7.h.c(context2, i12, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        p7.h c13 = p7.h.c(context2, i12, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.O = i12.getDimensionPixelSize(R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        int i13 = i12.getInt(R.styleable.ExtendedFloatingActionButton_extendStrategy, 1);
        this.f٩٠٢١b0 = i13;
        this.P = getPaddingStart();
        this.Q = getPaddingEnd();
        com.google.android.material.floatingactionbutton.a aVar2 = new com.google.android.material.floatingactionbutton.a();
        j jVar = new j(aVar2, M(i13), true);
        this.L = jVar;
        j jVar2 = new j(aVar2, new a(), false);
        this.K = jVar2;
        mVar.a(c10);
        kVar.a(c11);
        jVar.a(c12);
        jVar2.a(c13);
        i12.recycle();
        setShapeAppearanceModel(o.g(context2, attributeSet, i10, i11, o.f١٤١٧٨m).m());
        Q();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        Q();
    }
}
