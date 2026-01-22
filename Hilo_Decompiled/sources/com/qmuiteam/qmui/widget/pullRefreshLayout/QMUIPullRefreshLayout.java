package com.qmuiteam.qmui.widget.pullRefreshLayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.d1;
import androidx.core.view.h0;
import androidx.core.view.i0;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout;
import ic.i;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIPullRefreshLayout extends ViewGroup implements h0 {
    private float A;

    /* renamed from: B, reason: collision with root package name */
    private float f١٣٢٤٦B;
    private f C;
    private VelocityTracker D;
    private float E;
    private float F;
    private Scroller G;
    private int H;
    private boolean I;
    private Runnable J;
    private boolean K;

    /* renamed from: a, reason: collision with root package name */
    private final i0 f١٣٢٤٧a;

    /* renamed from: b, reason: collision with root package name */
    boolean f١٣٢٤٨b;

    /* renamed from: c, reason: collision with root package name */
    private View f١٣٢٤٩c;

    /* renamed from: d, reason: collision with root package name */
    private c f١٣٢٥٠d;

    /* renamed from: e, reason: collision with root package name */
    private View f١٣٢٥١e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣٢٥٢f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٣٢٥٣g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٣٢٥٤h;

    /* renamed from: i, reason: collision with root package name */
    private int f١٣٢٥٥i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٣٢٥٦j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٣٢٥٧k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f١٣٢٥٨l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١٣٢٥٩m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٣٢٦٠n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٣٢٦١o;

    /* renamed from: p, reason: collision with root package name */
    private int f١٣٢٦٢p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٣٢٦٣q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٣٢٦٤r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f١٣٢٦٥s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f١٣٢٦٦t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f١٣٢٦٧u;

    /* renamed from: v, reason: collision with root package name */
    private int f١٣٢٦٨v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f١٣٢٦٩w;

    /* renamed from: x, reason: collision with root package name */
    private float f١٣٢٧٠x;

    /* renamed from: y, reason: collision with root package name */
    private float f١٣٢٧١y;

    /* renamed from: z, reason: collision with root package name */
    private float f١٣٢٧٢z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class RefreshView extends AppCompatImageView implements c, fc.a {

        /* renamed from: c, reason: collision with root package name */
        private static SimpleArrayMap f١٣٢٧٣c;

        /* renamed from: a, reason: collision with root package name */
        private androidx.swiperefreshlayout.widget.a f١٣٢٧٤a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٣٢٧٥b;

        static {
            SimpleArrayMap simpleArrayMap = new SimpleArrayMap(4);
            f١٣٢٧٣c = simpleArrayMap;
            simpleArrayMap.put("tintColor", Integer.valueOf(R.attr.qmui_skin_support_pull_refresh_view_color));
        }

        public RefreshView(Context context) {
            super(context);
            this.f١٣٢٧٤a = new androidx.swiperefreshlayout.widget.a(context);
            setColorSchemeColors(i.b(context, R.attr.qmui_skin_support_pull_refresh_view_color));
            this.f١٣٢٧٤a.l(0);
            this.f١٣٢٧٤a.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
            this.f١٣٢٧٤a.e(0.8f);
            setImageDrawable(this.f١٣٢٧٤a);
            this.f١٣٢٧٥b = (int) (getResources().getDisplayMetrics().density * 40.0f);
        }

        @Override // com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.c
        public void b() {
            this.f١٣٢٧٤a.start();
        }

        @Override // com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.c
        public void g(int i10, int i11, int i12) {
            if (this.f١٣٢٧٤a.isRunning()) {
                return;
            }
            float f10 = i10;
            float f11 = i11;
            float f12 = (0.85f * f10) / f11;
            float f13 = (f10 * 0.4f) / f11;
            if (i12 > 0) {
                f13 += (i12 * 0.4f) / f11;
            }
            this.f١٣٢٧٤a.d(true);
            this.f١٣٢٧٤a.j(DownloadProgress.UNKNOWN_PROGRESS, f12);
            this.f١٣٢٧٤a.g(f13);
        }

        @Override // fc.a
        public SimpleArrayMap<String, Integer> getDefaultSkinAttrs() {
            return f١٣٢٧٣c;
        }

        @Override // android.widget.ImageView, android.view.View
        protected void onMeasure(int i10, int i11) {
            int i12 = this.f١٣٢٧٥b;
            setMeasuredDimension(i12, i12);
        }

        public void setColorSchemeColors(int... iArr) {
            this.f١٣٢٧٤a.f(iArr);
        }

        public void setColorSchemeResources(int... iArr) {
            Context context = getContext();
            int[] iArr2 = new int[iArr.length];
            for (int i10 = 0; i10 < iArr.length; i10++) {
                iArr2[i10] = androidx.core.content.a.getColor(context, iArr[i10]);
            }
            setColorSchemeColors(iArr2);
        }

        public void setSize(int i10) {
            if (i10 != 0 && i10 != 1) {
                return;
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i10 == 0) {
                this.f١٣٢٧٥b = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f١٣٢٧٥b = (int) (displayMetrics.density * 40.0f);
            }
            setImageDrawable(null);
            this.f١٣٢٧٤a.l(i10);
            setImageDrawable(this.f١٣٢٧٤a);
        }

        @Override // com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout.c
        public void stop() {
            this.f١٣٢٧٤a.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f١٣٢٧٦a;

        a(boolean z10) {
            this.f١٣٢٧٦a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUIPullRefreshLayout qMUIPullRefreshLayout = QMUIPullRefreshLayout.this;
            qMUIPullRefreshLayout.setTargetViewToTop(qMUIPullRefreshLayout.f١٣٢٤٩c);
            if (this.f١٣٢٧٦a) {
                QMUIPullRefreshLayout.this.H = 2;
                QMUIPullRefreshLayout.this.invalidate();
            } else {
                QMUIPullRefreshLayout qMUIPullRefreshLayout2 = QMUIPullRefreshLayout.this;
                qMUIPullRefreshLayout2.s(qMUIPullRefreshLayout2.f١٣٢٦٤r, true);
            }
            QMUIPullRefreshLayout.this.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f١٣٢٧٨a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f١٣٢٧٩b;

        b(long j10, boolean z10) {
            this.f١٣٢٧٨a = j10;
            this.f١٣٢٧٩b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            QMUIPullRefreshLayout.this.D(this.f١٣٢٧٨a, this.f١٣٢٧٩b);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface c {
        void b();

        void g(int i10, int i11, int i12);

        void stop();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface d {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface e {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface f {
        int a(int i10, int i11, int i12, int i13, int i14, int i15);
    }

    public QMUIPullRefreshLayout(Context context) {
        this(context, null);
    }

    private void A() {
        VelocityTracker velocityTracker = this.D;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.D.recycle();
            this.D = null;
        }
    }

    private void B(int i10) {
        this.H = (~i10) & this.H;
    }

    private void e(MotionEvent motionEvent) {
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        if (this.f١٣٢٥١e == null) {
            this.f١٣٢٥١e = i();
        }
        View view = this.f١٣٢٥١e;
        if (view instanceof c) {
            this.f١٣٢٥٠d = (c) view;
            if (view.getLayoutParams() == null) {
                this.f١٣٢٥١e.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            addView(this.f١٣٢٥١e);
            return;
        }
        throw new RuntimeException("refreshView must be a instance of IRefreshView");
    }

    public static boolean j(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof QMUIContinuousNestedScrollLayout) {
            if (((QMUIContinuousNestedScrollLayout) view).getCurrentScroll() <= 0) {
                return false;
            }
            return true;
        }
        if (view instanceof QMUIStickySectionLayout) {
            return j(((QMUIStickySectionLayout) view).getRecyclerView());
        }
        return d1.f(view, -1);
    }

    private void k() {
        if (n(8)) {
            B(8);
            if (this.G.getCurrVelocity() > this.F) {
                o("deliver velocity: " + this.G.getCurrVelocity());
                View view = this.f١٣٢٤٩c;
                if (view instanceof RecyclerView) {
                    ((RecyclerView) view).fling(0, (int) this.G.getCurrVelocity());
                } else if (view instanceof AbsListView) {
                    ((AbsListView) view).fling((int) this.G.getCurrVelocity());
                }
            }
        }
    }

    private void l() {
        Runnable runnable;
        if (this.f١٣٢٤٩c == null) {
            int i10 = 0;
            while (true) {
                if (i10 >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i10);
                if (!childAt.equals(this.f١٣٢٥١e)) {
                    y(childAt);
                    this.f١٣٢٤٩c = childAt;
                    break;
                }
                i10++;
            }
        }
        if (this.f١٣٢٤٩c != null && (runnable = this.J) != null) {
            this.J = null;
            runnable.run();
        }
    }

    private void m(int i10) {
        o("finishPull: vy = " + i10 + " ; mTargetCurrentOffset = " + this.f١٣٢٦٣q + " ; mTargetRefreshOffset = " + this.f١٣٢٦٤r + " ; mTargetInitOffset = " + this.f١٣٢٦٢p + " ; mScroller.isFinished() = " + this.G.isFinished());
        int i11 = i10 / 1000;
        t(i11, this.f١٣٢٥٥i, this.f١٣٢٥٦j, this.f١٣٢٥١e.getMeasuredHeight(), this.f١٣٢٦٣q, this.f١٣٢٦٢p, this.f١٣٢٦٤r);
        int i12 = this.f١٣٢٦٣q;
        int i13 = this.f١٣٢٦٤r;
        if (i12 >= i13) {
            if (i11 > 0) {
                this.H = 6;
                this.G.fling(0, i12, 0, i11, 0, 0, this.f١٣٢٦٢p, Integer.MAX_VALUE);
                invalidate();
                return;
            }
            if (i11 < 0) {
                this.G.fling(0, i12, 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
                if (this.G.getFinalY() < this.f١٣٢٦٢p) {
                    this.H = 8;
                } else if (this.G.getFinalY() < this.f١٣٢٦٤r) {
                    int i14 = this.f١٣٢٦٢p;
                    int i15 = this.f١٣٢٦٣q;
                    this.G.startScroll(0, i15, 0, i14 - i15);
                } else {
                    int finalY = this.G.getFinalY();
                    int i16 = this.f١٣٢٦٤r;
                    if (finalY == i16) {
                        this.H = 4;
                    } else {
                        Scroller scroller = this.G;
                        int i17 = this.f١٣٢٦٣q;
                        scroller.startScroll(0, i17, 0, i16 - i17);
                        this.H = 4;
                    }
                }
                invalidate();
                return;
            }
            if (i12 > i13) {
                this.G.startScroll(0, i12, 0, i13 - i12);
            }
            this.H = 4;
            invalidate();
            return;
        }
        if (i11 > 0) {
            this.G.fling(0, i12, 0, i11, 0, 0, this.f١٣٢٦٢p, Integer.MAX_VALUE);
            if (this.G.getFinalY() > this.f١٣٢٦٤r) {
                this.H = 6;
            } else if (this.f١٣٢٦١o >= 0 && this.G.getFinalY() > this.f١٣٢٦١o) {
                Scroller scroller2 = this.G;
                int i18 = this.f١٣٢٦٣q;
                scroller2.startScroll(0, i18, 0, this.f١٣٢٦٤r - i18);
                this.H = 4;
            } else {
                this.H = 1;
            }
            invalidate();
            return;
        }
        if (i11 < 0) {
            this.H = 0;
            this.G.fling(0, i12, 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int finalY2 = this.G.getFinalY();
            int i19 = this.f١٣٢٦٢p;
            if (finalY2 < i19) {
                this.H = 8;
            } else {
                Scroller scroller3 = this.G;
                int i20 = this.f١٣٢٦٣q;
                scroller3.startScroll(0, i20, 0, i19 - i20);
                this.H = 0;
            }
            invalidate();
            return;
        }
        int i21 = this.f١٣٢٦٢p;
        if (i12 == i21) {
            return;
        }
        int i22 = this.f١٣٢٦١o;
        if (i22 >= 0 && i12 >= i22) {
            this.G.startScroll(0, i12, 0, i13 - i12);
            this.H = 4;
        } else {
            this.G.startScroll(0, i12, 0, i21 - i12);
            this.H = 0;
        }
        invalidate();
    }

    private boolean n(int i10) {
        if ((this.H & i10) == i10) {
            return true;
        }
        return false;
    }

    private void o(String str) {
    }

    private int q(float f10) {
        return r((int) (this.f١٣٢٦٣q + f10));
    }

    private int r(int i10) {
        return s(i10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s(int i10, boolean z10) {
        int g10 = g(i10, this.f١٣٢٦٢p, this.f١٣٢٦٤r, this.f١٣٢٦٦t);
        int i11 = this.f١٣٢٦٣q;
        if (g10 == i11 && !z10) {
            return 0;
        }
        int i12 = g10 - i11;
        d1.b0(this.f١٣٢٤٩c, i12);
        this.f١٣٢٦٣q = g10;
        int i13 = this.f١٣٢٦٤r;
        int i14 = this.f١٣٢٦٢p;
        int i15 = i13 - i14;
        if (!this.f١٣٢٤٨b) {
            this.f١٣٢٥٠d.g(Math.min(g10 - i14, i15), i15, this.f١٣٢٦٣q - this.f١٣٢٦٤r);
        }
        v(this.f١٣٢٦٣q);
        if (this.C == null) {
            this.C = new com.qmuiteam.qmui.widget.pullRefreshLayout.a();
        }
        int a10 = this.C.a(this.f١٣٢٥٥i, this.f١٣٢٥٦j, this.f١٣٢٥١e.getMeasuredHeight(), this.f١٣٢٦٣q, this.f١٣٢٦٢p, this.f١٣٢٦٤r);
        int i16 = this.f١٣٢٥٧k;
        if (a10 != i16) {
            d1.b0(this.f١٣٢٥١e, a10 - i16);
            this.f١٣٢٥٧k = a10;
            u(a10);
        }
        return i12;
    }

    private void x(MotionEvent motionEvent) {
        int i10;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f١٣٢٦٨v) {
            if (actionIndex == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.f١٣٢٦٨v = motionEvent.getPointerId(i10);
        }
    }

    public void C() {
        this.f١٣٢٥٠d.stop();
        this.f١٣٢٤٨b = false;
        this.G.forceFinished(true);
        this.H = 0;
        r(this.f١٣٢٦٢p);
    }

    public void D(long j10, boolean z10) {
        if (this.f١٣٢٤٩c != null) {
            a aVar = new a(z10);
            if (j10 == 0) {
                aVar.run();
                return;
            } else {
                postDelayed(aVar, j10);
                return;
            }
        }
        this.J = new b(j10, z10);
    }

    protected void E(float f10, float f11) {
        float f12 = f10 - this.f١٣٢٧١y;
        float f13 = f11 - this.f١٣٢٧٠x;
        if (p(f12, f13)) {
            int i10 = this.f١٣٢٥٤h;
            if ((f13 > i10 || (f13 < (-i10) && this.f١٣٢٦٣q > this.f١٣٢٦٢p)) && !this.f١٣٢٦٩w) {
                float f14 = this.f١٣٢٧٠x + i10;
                this.f١٣٢٧٢z = f14;
                this.A = f14;
                this.f١٣٢٦٩w = true;
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.G.computeScrollOffset()) {
            int currY = this.G.getCurrY();
            r(currY);
            if (currY <= 0 && n(8)) {
                k();
                this.G.forceFinished(true);
            }
            invalidate();
            return;
        }
        if (n(1)) {
            B(1);
            int i10 = this.f١٣٢٦٣q;
            int i11 = this.f١٣٢٦٢p;
            if (i10 != i11) {
                this.G.startScroll(0, i10, 0, i11 - i10);
            }
            invalidate();
            return;
        }
        if (n(2)) {
            B(2);
            int i12 = this.f١٣٢٦٣q;
            int i13 = this.f١٣٢٦٤r;
            if (i12 != i13) {
                this.G.startScroll(0, i12, 0, i13 - i12);
            } else {
                s(i13, true);
            }
            invalidate();
            return;
        }
        if (n(4)) {
            B(4);
            w();
            s(this.f١٣٢٦٤r, true);
            return;
        }
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action == 0) {
            if (!this.f١٣٢٤٨b && (this.H & 4) == 0) {
                z10 = false;
            }
            this.I = z10;
        } else if (this.I) {
            if (action == 2) {
                if (!this.f١٣٢٤٨b && this.G.isFinished() && this.H == 0) {
                    motionEvent.offsetLocation(DownloadProgress.UNKNOWN_PROGRESS, (-this.f١٣٢٥٣g) - 1);
                    motionEvent.setAction(0);
                    super.dispatchTouchEvent(motionEvent);
                    this.I = false;
                    motionEvent.setAction(action);
                    motionEvent.offsetLocation(DownloadProgress.UNKNOWN_PROGRESS, this.f١٣٢٥٣g + 1);
                }
            } else {
                this.I = false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected int g(int i10, int i11, int i12, boolean z10) {
        int max = Math.max(i10, i11);
        if (!z10) {
            return Math.min(max, i12);
        }
        return max;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        int i12 = this.f١٣٢٥٢f;
        if (i12 < 0) {
            return i11;
        }
        if (i11 == i12) {
            return i10 - 1;
        }
        if (i11 > i12) {
            return i11 - 1;
        }
        return i11;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f١٣٢٤٧a.a();
    }

    public int getRefreshEndOffset() {
        return this.f١٣٢٥٦j;
    }

    public int getRefreshInitOffset() {
        return this.f١٣٢٥٥i;
    }

    protected float getScrollerFriction() {
        return ViewConfiguration.getScrollFriction();
    }

    public int getTargetInitOffset() {
        return this.f١٣٢٦٢p;
    }

    public int getTargetRefreshOffset() {
        return this.f١٣٢٦٤r;
    }

    public View getTargetView() {
        return this.f١٣٢٤٩c;
    }

    public boolean h() {
        return j(this.f١٣٢٤٩c);
    }

    protected View i() {
        return new RefreshView(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        l();
        int action = motionEvent.getAction();
        if (!isEnabled() || h() || this.f١٣٢٦٧u) {
            return false;
        }
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            x(motionEvent);
                        }
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f١٣٢٦٨v);
                    if (findPointerIndex < 0) {
                        Log.e("QMUIPullRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    E(motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex));
                }
            }
            this.f١٣٢٦٩w = false;
            this.f١٣٢٦٨v = -1;
        } else {
            this.f١٣٢٦٩w = false;
            int pointerId = motionEvent.getPointerId(0);
            this.f١٣٢٦٨v = pointerId;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f١٣٢٧١y = motionEvent.getX(findPointerIndex2);
            this.f١٣٢٧٠x = motionEvent.getY(findPointerIndex2);
        }
        return this.f١٣٢٦٩w;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        l();
        if (this.f١٣٢٤٩c == null) {
            Log.d("QMUIPullRefreshLayout", "onLayout: mTargetView == null");
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingLeft2 = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int paddingTop2 = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        View view = this.f١٣٢٤٩c;
        int i14 = this.f١٣٢٦٣q;
        view.layout(paddingLeft, paddingTop + i14, paddingLeft2 + paddingLeft, paddingTop + paddingTop2 + i14);
        int measuredWidth2 = this.f١٣٢٥١e.getMeasuredWidth();
        int measuredHeight2 = this.f١٣٢٥١e.getMeasuredHeight();
        int i15 = measuredWidth / 2;
        int i16 = measuredWidth2 / 2;
        int i17 = this.f١٣٢٥٧k;
        this.f١٣٢٥١e.layout(i15 - i16, i17, i15 + i16, measuredHeight2 + i17);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((size - getPaddingLeft()) - getPaddingRight(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((size2 - getPaddingTop()) - getPaddingBottom(), 1073741824);
        measureChild(this.f١٣٢٥١e, i10, i11);
        int measuredHeight = this.f١٣٢٥١e.getMeasuredHeight();
        if (this.f١٣٢٥٨l && this.f١٣٢٥٥i != (i12 = -measuredHeight)) {
            this.f١٣٢٥٥i = i12;
            this.f١٣٢٥٧k = i12;
        }
        if (this.f١٣٢٦٠n) {
            this.f١٣٢٦٤r = measuredHeight;
        }
        if (this.f١٣٢٥٩m) {
            this.f١٣٢٥٦j = (this.f١٣٢٦٤r - measuredHeight) / 2;
        }
        this.f١٣٢٥٢f = -1;
        int i13 = 0;
        while (true) {
            if (i13 >= getChildCount()) {
                break;
            }
            if (getChildAt(i13) == this.f١٣٢٥١e) {
                this.f١٣٢٥٢f = i13;
                break;
            }
            i13++;
        }
        l();
        View view = this.f١٣٢٤٩c;
        if (view == null) {
            Log.d("QMUIPullRefreshLayout", "onMeasure: mTargetView == null");
            setMeasuredDimension(size, size2);
        } else {
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        try {
            return super.onNestedFling(view, f10, f11, z10);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        o("onNestedPreFling: mTargetCurrentOffset = " + this.f١٣٢٦٣q + " ; velocityX = " + f10 + " ; velocityY = " + f11);
        if (this.f١٣٢٦٣q <= this.f١٣٢٦٢p) {
            return false;
        }
        this.f١٣٢٦٧u = false;
        this.f١٣٢٦٩w = false;
        if (!this.I) {
            m((int) (-f11));
            return true;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        o("onNestedPreScroll: dx = " + i10 + " ; dy = " + i11);
        int i12 = this.f١٣٢٦٣q;
        int i13 = this.f١٣٢٦٢p;
        int i14 = i12 - i13;
        if (i11 > 0 && i14 > 0) {
            if (i11 >= i14) {
                iArr[1] = i14;
                r(i13);
            } else {
                iArr[1] = i11;
                q(-i11);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        o("onNestedScroll: dxConsumed = " + i10 + " ; dyConsumed = " + i11 + " ; dxUnconsumed = " + i12 + " ; dyUnconsumed = " + i13);
        if (i13 < 0 && !h() && this.G.isFinished() && this.H == 0) {
            q(-i13);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        o("onNestedScrollAccepted: axes = " + i10);
        this.G.abortAnimation();
        this.f١٣٢٤٧a.b(view, view2, i10);
        this.f١٣٢٦٧u = true;
        this.f١٣٢٦٩w = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        o("onStartNestedScroll: nestedScrollAxes = " + i10);
        if (!this.f١٣٢٦٥s && isEnabled() && (i10 & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        o("onStopNestedScroll: mNestedScrollInProgress = " + this.f١٣٢٦٧u);
        this.f١٣٢٤٧a.d(view);
        if (this.f١٣٢٦٧u) {
            this.f١٣٢٦٧u = false;
            this.f١٣٢٦٩w = false;
            if (!this.I) {
                m(0);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (isEnabled() && !h() && !this.f١٣٢٦٧u) {
            e(motionEvent);
            if (action != 0) {
                float f10 = DownloadProgress.UNKNOWN_PROGRESS;
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            if (action != 5) {
                                if (action == 6) {
                                    x(motionEvent);
                                }
                            } else {
                                int actionIndex = motionEvent.getActionIndex();
                                if (actionIndex < 0) {
                                    Log.e("QMUIPullRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                                    return false;
                                }
                                this.f١٣٢٦٨v = motionEvent.getPointerId(actionIndex);
                            }
                        } else {
                            A();
                            return false;
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f١٣٢٦٨v);
                        if (findPointerIndex < 0) {
                            Log.e("QMUIPullRefreshLayout", "onTouchEvent Got ACTION_MOVE event but have an invalid active pointer id.");
                            return false;
                        }
                        float x10 = motionEvent.getX(findPointerIndex);
                        float y10 = motionEvent.getY(findPointerIndex);
                        E(x10, y10);
                        if (this.f١٣٢٦٩w) {
                            float f11 = (y10 - this.A) * this.f١٣٢٤٦B;
                            if (f11 >= DownloadProgress.UNKNOWN_PROGRESS) {
                                q(f11);
                            } else {
                                float abs = Math.abs(f11) - Math.abs(q(f11));
                                if (abs > DownloadProgress.UNKNOWN_PROGRESS) {
                                    motionEvent.setAction(0);
                                    float f12 = this.f١٣٢٥٣g + 1;
                                    if (abs <= f12) {
                                        abs = f12;
                                    }
                                    motionEvent.offsetLocation(DownloadProgress.UNKNOWN_PROGRESS, abs);
                                    super.dispatchTouchEvent(motionEvent);
                                    motionEvent.setAction(action);
                                    motionEvent.offsetLocation(DownloadProgress.UNKNOWN_PROGRESS, -abs);
                                    super.dispatchTouchEvent(motionEvent);
                                }
                            }
                            this.A = y10;
                        }
                    }
                } else {
                    if (motionEvent.findPointerIndex(this.f١٣٢٦٨v) < 0) {
                        Log.e("QMUIPullRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
                        return false;
                    }
                    if (this.f١٣٢٦٩w) {
                        this.f١٣٢٦٩w = false;
                        this.D.computeCurrentVelocity(1000, this.E);
                        float yVelocity = this.D.getYVelocity(this.f١٣٢٦٨v);
                        if (Math.abs(yVelocity) >= this.F) {
                            f10 = yVelocity;
                        }
                        m((int) f10);
                    }
                    this.f١٣٢٦٨v = -1;
                    A();
                    return false;
                }
            } else {
                this.f١٣٢٦٩w = false;
                this.H = 0;
                if (!this.G.isFinished()) {
                    this.G.abortAnimation();
                }
                this.f١٣٢٦٨v = motionEvent.getPointerId(0);
            }
            return true;
        }
        Log.d("QMUIPullRefreshLayout", "fast end onTouchEvent: isEnabled = " + isEnabled() + "; canChildScrollUp = " + h() + " ; mNestedScrollInProgress = " + this.f١٣٢٦٧u);
        return false;
    }

    protected boolean p(float f10, float f11) {
        if (Math.abs(f11) > Math.abs(f10)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (this.K) {
            super.requestDisallowInterceptTouchEvent(z10);
            this.K = false;
        }
        View view = this.f١٣٢٤٩c;
        if (view == null || d1.W(view)) {
            super.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public void setAutoScrollToRefreshMinOffset(int i10) {
        this.f١٣٢٦١o = i10;
    }

    public void setChildScrollUpCallback(d dVar) {
    }

    public void setDisableNestScrollImpl(boolean z10) {
        this.f١٣٢٦٥s = z10;
    }

    public void setDragRate(float f10) {
        this.f١٣٢٦٥s = true;
        this.f١٣٢٤٦B = f10;
    }

    public void setEnableOverPull(boolean z10) {
        this.f١٣٢٦٦t = z10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!z10) {
            C();
            invalidate();
        }
    }

    public void setOnPullListener(e eVar) {
    }

    public void setRefreshOffsetCalculator(f fVar) {
        this.C = fVar;
    }

    public void setTargetRefreshOffset(int i10) {
        this.f١٣٢٦٠n = false;
        this.f١٣٢٦٤r = i10;
    }

    protected void setTargetViewToTop(View view) {
        if (view instanceof RecyclerView) {
            ((RecyclerView) view).scrollToPosition(0);
        } else if (view instanceof AbsListView) {
            ((AbsListView) view).setSelectionFromTop(0, 0);
        } else {
            view.scrollTo(0, 0);
        }
    }

    public void setToRefreshDirectly(long j10) {
        D(j10, true);
    }

    protected void t(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
    }

    protected void u(int i10) {
    }

    protected void v(int i10) {
    }

    protected void w() {
        if (this.f١٣٢٤٨b) {
            return;
        }
        this.f١٣٢٤٨b = true;
        this.f١٣٢٥٠d.b();
    }

    protected void y(View view) {
    }

    public void z() {
        this.K = true;
    }

    public QMUIPullRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIPullRefreshLayoutStyle);
    }

    public QMUIPullRefreshLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        boolean z10;
        this.f١٣٢٤٨b = false;
        this.f١٣٢٥٢f = -1;
        boolean z11 = true;
        this.f١٣٢٥٨l = true;
        this.f١٣٢٥٩m = true;
        this.f١٣٢٦٠n = false;
        this.f١٣٢٦١o = -1;
        this.f١٣٢٦٥s = false;
        this.f١٣٢٦٦t = true;
        this.f١٣٢٦٨v = -1;
        this.f١٣٢٤٦B = 0.65f;
        this.H = 0;
        this.I = false;
        this.J = null;
        this.K = false;
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.E = viewConfiguration.getScaledMaximumFlingVelocity();
        this.F = viewConfiguration.getScaledMinimumFlingVelocity();
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.f١٣٢٥٣g = scaledTouchSlop;
        this.f١٣٢٥٤h = ic.e.j(context, scaledTouchSlop);
        Scroller scroller = new Scroller(getContext());
        this.G = scroller;
        scroller.setFriction(getScrollerFriction());
        f();
        d1.w0(this, true);
        this.f١٣٢٤٧a = new i0(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPullRefreshLayout, i10, 0);
        try {
            this.f١٣٢٥٥i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullRefreshLayout_qmui_refresh_init_offset, Integer.MIN_VALUE);
            this.f١٣٢٥٦j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullRefreshLayout_qmui_refresh_end_offset, Integer.MIN_VALUE);
            this.f١٣٢٦٢p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullRefreshLayout_qmui_target_init_offset, 0);
            this.f١٣٢٦٤r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullRefreshLayout_qmui_target_refresh_offset, ic.e.a(getContext(), 72));
            if (this.f١٣٢٥٥i != Integer.MIN_VALUE && !obtainStyledAttributes.getBoolean(R.styleable.QMUIPullRefreshLayout_qmui_auto_calculate_refresh_init_offset, false)) {
                z10 = false;
                this.f١٣٢٥٨l = z10;
                if (this.f١٣٢٥٦j != Integer.MIN_VALUE && !obtainStyledAttributes.getBoolean(R.styleable.QMUIPullRefreshLayout_qmui_auto_calculate_refresh_end_offset, false)) {
                    z11 = false;
                }
                this.f١٣٢٥٩m = z11;
                this.f١٣٢٦٠n = obtainStyledAttributes.getBoolean(R.styleable.QMUIPullRefreshLayout_qmui_equal_target_refresh_offset_to_refresh_view_height, false);
                obtainStyledAttributes.recycle();
                this.f١٣٢٥٧k = this.f١٣٢٥٥i;
                this.f١٣٢٦٣q = this.f١٣٢٦٢p;
            }
            z10 = true;
            this.f١٣٢٥٨l = z10;
            if (this.f١٣٢٥٦j != Integer.MIN_VALUE) {
                z11 = false;
            }
            this.f١٣٢٥٩m = z11;
            this.f١٣٢٦٠n = obtainStyledAttributes.getBoolean(R.styleable.QMUIPullRefreshLayout_qmui_equal_target_refresh_offset_to_refresh_view_height, false);
            obtainStyledAttributes.recycle();
            this.f١٣٢٥٧k = this.f١٣٢٥٥i;
            this.f١٣٢٦٣q = this.f١٣٢٦٢p;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
