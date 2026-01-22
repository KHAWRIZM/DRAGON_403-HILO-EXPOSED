package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.l;
import androidx.core.view.d1;
import androidx.core.view.d2;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements w, androidx.core.view.h0, androidx.core.view.f0, androidx.core.view.g0 {
    static final int[] G = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    private static final d2 H = new d2.b().d(androidx.core.graphics.b0.b(0, 1, 0, 1)).a();
    private static final Rect I = new Rect();
    ViewPropertyAnimator A;

    /* renamed from: B, reason: collision with root package name */
    final AnimatorListenerAdapter f١١٤٨B;
    private final Runnable C;
    private final Runnable D;
    private final androidx.core.view.i0 E;
    private final NoSystemUiLayoutFlagView F;

    /* renamed from: a, reason: collision with root package name */
    private int f١١٤٩a;

    /* renamed from: b, reason: collision with root package name */
    private int f١١٥٠b;

    /* renamed from: c, reason: collision with root package name */
    private ContentFrameLayout f١١٥١c;

    /* renamed from: d, reason: collision with root package name */
    ActionBarContainer f١١٥٢d;

    /* renamed from: e, reason: collision with root package name */
    private x f١١٥٣e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f١١٥٤f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١١٥٥g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١١٥٦h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١١٥٧i;

    /* renamed from: j, reason: collision with root package name */
    boolean f١١٥٨j;

    /* renamed from: k, reason: collision with root package name */
    private int f١١٥٩k;

    /* renamed from: l, reason: collision with root package name */
    private int f١١٦٠l;

    /* renamed from: m, reason: collision with root package name */
    private final Rect f١١٦١m;

    /* renamed from: n, reason: collision with root package name */
    private final Rect f١١٦٢n;

    /* renamed from: o, reason: collision with root package name */
    private final Rect f١١٦٣o;

    /* renamed from: p, reason: collision with root package name */
    private final Rect f١١٦٤p;

    /* renamed from: q, reason: collision with root package name */
    private final Rect f١١٦٥q;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f١١٦٦r;

    /* renamed from: s, reason: collision with root package name */
    private final Rect f١١٦٧s;

    /* renamed from: t, reason: collision with root package name */
    private final Rect f١١٦٨t;

    /* renamed from: u, reason: collision with root package name */
    private d2 f١١٦٩u;

    /* renamed from: v, reason: collision with root package name */
    private d2 f١١٧٠v;

    /* renamed from: w, reason: collision with root package name */
    private d2 f١١٧١w;

    /* renamed from: x, reason: collision with root package name */
    private d2 f١١٧٢x;

    /* renamed from: y, reason: collision with root package name */
    private d f١١٧٣y;

    /* renamed from: z, reason: collision with root package name */
    private OverScroller f١١٧٤z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class NoSystemUiLayoutFlagView extends View {
        NoSystemUiLayoutFlagView(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f١١٥٨j = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f١١٥٨j = false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.p();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f١١٥٢d.animate().translationY(DownloadProgress.UNKNOWN_PROGRESS).setListener(ActionBarOverlayLayout.this.f١١٤٨B);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.p();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f١١٥٢d.animate().translationY(-ActionBarOverlayLayout.this.f١١٥٢d.getHeight()).setListener(ActionBarOverlayLayout.this.f١١٤٨B);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface d {
        void a();

        void b(int i10);

        void c();

        void d(boolean z10);

        void e();

        void f();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    private void j() {
        p();
        this.D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean k(View view, Rect rect, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14;
        e eVar = (e) view.getLayoutParams();
        if (z10) {
            int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
            int i11 = rect.left;
            if (i10 != i11) {
                ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i11;
                z14 = true;
                if (z11) {
                    int i12 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                    int i13 = rect.top;
                    if (i12 != i13) {
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = i13;
                        z14 = true;
                    }
                }
                if (z13) {
                    int i14 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                    int i15 = rect.right;
                    if (i14 != i15) {
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i15;
                        z14 = true;
                    }
                }
                if (z12) {
                    int i16 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    int i17 = rect.bottom;
                    if (i16 != i17) {
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i17;
                        return true;
                    }
                }
                return z14;
            }
        }
        z14 = false;
        if (z11) {
        }
        if (z13) {
        }
        if (z12) {
        }
        return z14;
    }

    private boolean l() {
        d1.i(this.F, H, this.f١١٦٤p);
        return !this.f١١٦٤p.equals(I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private x o(View view) {
        if (view instanceof x) {
            return (x) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void q(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        boolean z10 = false;
        this.f١١٤٩a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f١١٥٤f = drawable;
        if (drawable == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        obtainStyledAttributes.recycle();
        this.f١١٧٤z = new OverScroller(context);
    }

    private void s() {
        p();
        postDelayed(this.D, 600L);
    }

    private void t() {
        p();
        postDelayed(this.C, 600L);
    }

    private void v() {
        p();
        this.C.run();
    }

    private boolean w(float f10) {
        this.f١١٧٤z.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f١١٧٤z.getFinalY() > this.f١١٥٢d.getHeight()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.widget.w
    public boolean a() {
        u();
        return this.f١١٥٣e.a();
    }

    @Override // androidx.appcompat.widget.w
    public boolean b() {
        u();
        return this.f١١٥٣e.b();
    }

    @Override // androidx.appcompat.widget.w
    public boolean c() {
        u();
        return this.f١١٥٣e.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.w
    public void d(Menu menu, l.a aVar) {
        u();
        this.f١١٥٣e.d(menu, aVar);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        super.draw(canvas);
        if (this.f١١٥٤f != null) {
            if (this.f١١٥٢d.getVisibility() == 0) {
                i10 = (int) (this.f١١٥٢d.getBottom() + this.f١١٥٢d.getTranslationY() + 0.5f);
            } else {
                i10 = 0;
            }
            this.f١١٥٤f.setBounds(0, i10, getWidth(), this.f١١٥٤f.getIntrinsicHeight() + i10);
            this.f١١٥٤f.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.w
    public boolean e() {
        u();
        return this.f١١٥٣e.e();
    }

    @Override // androidx.appcompat.widget.w
    public void f() {
        u();
        this.f١١٥٣e.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.w
    public boolean g() {
        u();
        return this.f١١٥٣e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f١١٥٢d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.E.a();
    }

    public CharSequence getTitle() {
        u();
        return this.f١١٥٣e.getTitle();
    }

    @Override // androidx.appcompat.widget.w
    public void h(int i10) {
        u();
        if (i10 != 2) {
            if (i10 != 5) {
                if (i10 == 109) {
                    setOverlayMode(true);
                    return;
                }
                return;
            }
            this.f١١٥٣e.w();
            return;
        }
        this.f١١٥٣e.o();
    }

    @Override // androidx.appcompat.widget.w
    public void i() {
        u();
        this.f١١٥٣e.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        u();
        d2 y10 = d2.y(windowInsets, this);
        boolean k10 = k(this.f١١٥٢d, new Rect(y10.k(), y10.m(), y10.l(), y10.j()), true, true, false, true);
        d1.i(this, y10, this.f١١٦١m);
        Rect rect = this.f١١٦١m;
        d2 o10 = y10.o(rect.left, rect.top, rect.right, rect.bottom);
        this.f١١٦٩u = o10;
        boolean z10 = true;
        if (!this.f١١٧٠v.equals(o10)) {
            this.f١١٧٠v = this.f١١٦٩u;
            k10 = true;
        }
        if (!this.f١١٦٢n.equals(this.f١١٦١m)) {
            this.f١١٦٢n.set(this.f١١٦١m);
        } else {
            z10 = k10;
        }
        if (z10) {
            requestLayout();
        }
        return y10.a().c().b().w();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        q(getContext());
        d1.n0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        boolean z10;
        int measuredHeight;
        u();
        measureChildWithMargins(this.f١١٥٢d, i10, 0, i11, 0);
        e eVar = (e) this.f١١٥٢d.getLayoutParams();
        int max = Math.max(0, this.f١١٥٢d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f١١٥٢d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f١١٥٢d.getMeasuredState());
        if ((d1.P(this) & 256) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            measuredHeight = this.f١١٤٩a;
            if (this.f١١٥٦h && this.f١١٥٢d.getTabContainer() != null) {
                measuredHeight += this.f١١٤٩a;
            }
        } else {
            measuredHeight = this.f١١٥٢d.getVisibility() != 8 ? this.f١١٥٢d.getMeasuredHeight() : 0;
        }
        this.f١١٦٣o.set(this.f١١٦١m);
        this.f١١٧١w = this.f١١٦٩u;
        if (!this.f١١٥٥g && !z10 && l()) {
            Rect rect = this.f١١٦٣o;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f١١٧١w = this.f١١٧١w.o(0, measuredHeight, 0, 0);
        } else {
            this.f١١٧١w = new d2.b(this.f١١٧١w).d(androidx.core.graphics.b0.b(this.f١١٧١w.k(), this.f١١٧١w.m() + measuredHeight, this.f١١٧١w.l(), this.f١١٧١w.j())).a();
        }
        k(this.f١١٥١c, this.f١١٦٣o, true, true, true, true);
        if (!this.f١١٧٢x.equals(this.f١١٧١w)) {
            d2 d2Var = this.f١١٧١w;
            this.f١١٧٢x = d2Var;
            d1.j(this.f١١٥١c, d2Var);
        }
        measureChildWithMargins(this.f١١٥١c, i10, 0, i11, 0);
        e eVar2 = (e) this.f١١٥١c.getLayoutParams();
        int max3 = Math.max(max, this.f١١٥١c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f١١٥١c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f١١٥١c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (this.f١١٥٧i && z10) {
            if (w(f11)) {
                j();
            } else {
                v();
            }
            this.f١١٥٨j = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // androidx.core.view.g0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        onNestedScroll(view, i10, i11, i12, i13, i14);
    }

    @Override // androidx.core.view.f0
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // androidx.core.view.f0
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // androidx.core.view.f0
    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i10) {
        boolean z10;
        super.onWindowSystemUiVisibilityChanged(i10);
        u();
        int i11 = this.f١١٦٠l ^ i10;
        this.f١١٦٠l = i10;
        boolean z11 = false;
        if ((i10 & 4) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((i10 & 256) != 0) {
            z11 = true;
        }
        d dVar = this.f١١٧٣y;
        if (dVar != null) {
            dVar.d(!z11);
            if (!z10 && z11) {
                this.f١١٧٣y.e();
            } else {
                this.f١١٧٣y.a();
            }
        }
        if ((i11 & 256) != 0 && this.f١١٧٣y != null) {
            d1.n0(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f١١٥٠b = i10;
        d dVar = this.f١١٧٣y;
        if (dVar != null) {
            dVar.b(i10);
        }
    }

    void p() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean r() {
        return this.f١١٥٥g;
    }

    public void setActionBarHideOffset(int i10) {
        p();
        this.f١١٥٢d.setTranslationY(-Math.max(0, Math.min(i10, this.f١١٥٢d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f١١٧٣y = dVar;
        if (getWindowToken() != null) {
            this.f١١٧٣y.b(this.f١١٥٠b);
            int i10 = this.f١١٦٠l;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                d1.n0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f١١٥٦h = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f١١٥٧i) {
            this.f١١٥٧i = z10;
            if (!z10) {
                p();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i10) {
        u();
        this.f١١٥٣e.setIcon(i10);
    }

    public void setLogo(int i10) {
        u();
        this.f١١٥٣e.s(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f١١٥٥g = z10;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    @Override // androidx.appcompat.widget.w
    public void setWindowCallback(Window.Callback callback) {
        u();
        this.f١١٥٣e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.w
    public void setWindowTitle(CharSequence charSequence) {
        u();
        this.f١١٥٣e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        if (this.f١١٥١c == null) {
            this.f١١٥١c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f١١٥٢d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.f١١٥٣e = o(findViewById(R.id.action_bar));
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١١٥٠b = 0;
        this.f١١٦١m = new Rect();
        this.f١١٦٢n = new Rect();
        this.f١١٦٣o = new Rect();
        this.f١١٦٤p = new Rect();
        this.f١١٦٥q = new Rect();
        this.f١١٦٦r = new Rect();
        this.f١١٦٧s = new Rect();
        this.f١١٦٨t = new Rect();
        d2 d2Var = d2.f٢٩٣٥b;
        this.f١١٦٩u = d2Var;
        this.f١١٧٠v = d2Var;
        this.f١١٧١w = d2Var;
        this.f١١٧٢x = d2Var;
        this.f١١٤٨B = new a();
        this.C = new b();
        this.D = new c();
        q(context);
        this.E = new androidx.core.view.i0(this);
        NoSystemUiLayoutFlagView noSystemUiLayoutFlagView = new NoSystemUiLayoutFlagView(context);
        this.F = noSystemUiLayoutFlagView;
        addView(noSystemUiLayoutFlagView);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    @Override // androidx.core.view.f0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // androidx.core.view.f0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.E.b(view, view2, i10);
        this.f١١٥٩k = getActionBarHideOffset();
        p();
        d dVar = this.f١١٧٣y;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f١١٥٢d.getVisibility() != 0) {
            return false;
        }
        return this.f١١٥٧i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f١١٥٧i && !this.f١١٥٨j) {
            if (this.f١١٥٩k <= this.f١١٥٢d.getHeight()) {
                t();
            } else {
                s();
            }
        }
        d dVar = this.f١١٧٣y;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f١١٥٩k + i11;
        this.f١١٥٩k = i14;
        setActionBarHideOffset(i14);
    }

    public void setIcon(Drawable drawable) {
        u();
        this.f١١٥٣e.setIcon(drawable);
    }
}
