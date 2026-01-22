package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.view.d0;
import androidx.core.view.d1;
import androidx.core.view.e0;
import androidx.core.view.f0;
import androidx.core.view.g0;
import androidx.core.view.h0;
import androidx.core.view.i0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements g0, f0, d0, h0 {
    private static final String O = "SwipeRefreshLayout";
    private static final int[] P = {R.attr.enabled};
    int A;

    /* renamed from: B, reason: collision with root package name */
    androidx.swiperefreshlayout.widget.a f٤١٤٨B;
    private Animation C;
    private Animation D;
    private Animation E;
    private Animation F;
    private Animation G;
    boolean H;
    private int I;
    boolean J;
    private boolean K;
    private Animation.AnimationListener L;
    private final Animation M;
    private final Animation N;

    /* renamed from: a, reason: collision with root package name */
    private View f٤١٤٩a;

    /* renamed from: b, reason: collision with root package name */
    boolean f٤١٥٠b;

    /* renamed from: c, reason: collision with root package name */
    private int f٤١٥١c;

    /* renamed from: d, reason: collision with root package name */
    private float f٤١٥٢d;

    /* renamed from: e, reason: collision with root package name */
    private float f٤١٥٣e;

    /* renamed from: f, reason: collision with root package name */
    private final i0 f٤١٥٤f;

    /* renamed from: g, reason: collision with root package name */
    private final e0 f٤١٥٥g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f٤١٥٦h;

    /* renamed from: i, reason: collision with root package name */
    private final int[] f٤١٥٧i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f٤١٥٨j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f٤١٥٩k;

    /* renamed from: l, reason: collision with root package name */
    private int f٤١٦٠l;

    /* renamed from: m, reason: collision with root package name */
    int f٤١٦١m;

    /* renamed from: n, reason: collision with root package name */
    private float f٤١٦٢n;

    /* renamed from: o, reason: collision with root package name */
    private float f٤١٦٣o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f٤١٦٤p;

    /* renamed from: q, reason: collision with root package name */
    private int f٤١٦٥q;

    /* renamed from: r, reason: collision with root package name */
    boolean f٤١٦٦r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٤١٦٧s;

    /* renamed from: t, reason: collision with root package name */
    private final DecelerateInterpolator f٤١٦٨t;

    /* renamed from: u, reason: collision with root package name */
    CircleImageView f٤١٦٩u;

    /* renamed from: v, reason: collision with root package name */
    private int f٤١٧٠v;

    /* renamed from: w, reason: collision with root package name */
    protected int f٤١٧١w;

    /* renamed from: x, reason: collision with root package name */
    float f٤١٧٢x;

    /* renamed from: y, reason: collision with root package name */
    protected int f٤١٧٣y;

    /* renamed from: z, reason: collision with root package name */
    int f٤١٧٤z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f٤١٥٠b) {
                swipeRefreshLayout.f٤١٤٨B.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
                SwipeRefreshLayout.this.f٤١٤٨B.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.H) {
                    swipeRefreshLayout2.getClass();
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.f٤١٦١m = swipeRefreshLayout3.f٤١٦٩u.getTop();
                return;
            }
            swipeRefreshLayout.l();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d extends Animation {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f٤١٧٩a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f٤١٨٠b;

        d(int i10, int i11) {
            this.f٤١٧٩a = i10;
            this.f٤١٨٠b = i11;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.f٤١٤٨B.setAlpha((int) (this.f٤١٧٩a + ((this.f٤١٨٠b - r0) * f10)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f٤١٦٦r) {
                swipeRefreshLayout.r(null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            int i10;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.J) {
                i10 = swipeRefreshLayout.f٤١٧٤z - Math.abs(swipeRefreshLayout.f٤١٧٣y);
            } else {
                i10 = swipeRefreshLayout.f٤١٧٤z;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.f٤١٧١w + ((int) ((i10 - r1) * f10))) - swipeRefreshLayout2.f٤١٦٩u.getTop());
            SwipeRefreshLayout.this.f٤١٤٨B.e(1.0f - f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.j(f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f11 = swipeRefreshLayout.f٤١٧٢x;
            swipeRefreshLayout.setAnimationProgress(f11 + ((-f11) * f10));
            SwipeRefreshLayout.this.j(f10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface i {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface j {
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void a(int i10, Animation.AnimationListener animationListener) {
        this.f٤١٧١w = i10;
        this.M.reset();
        this.M.setDuration(200L);
        this.M.setInterpolator(this.f٤١٦٨t);
        if (animationListener != null) {
            this.f٤١٦٩u.setAnimationListener(animationListener);
        }
        this.f٤١٦٩u.clearAnimation();
        this.f٤١٦٩u.startAnimation(this.M);
    }

    private void b(int i10, Animation.AnimationListener animationListener) {
        if (this.f٤١٦٦r) {
            s(i10, animationListener);
            return;
        }
        this.f٤١٧١w = i10;
        this.N.reset();
        this.N.setDuration(200L);
        this.N.setInterpolator(this.f٤١٦٨t);
        if (animationListener != null) {
            this.f٤١٦٩u.setAnimationListener(animationListener);
        }
        this.f٤١٦٩u.clearAnimation();
        this.f٤١٦٩u.startAnimation(this.N);
    }

    private void d() {
        this.f٤١٦٩u = new CircleImageView(getContext());
        androidx.swiperefreshlayout.widget.a aVar = new androidx.swiperefreshlayout.widget.a(getContext());
        this.f٤١٤٨B = aVar;
        aVar.l(1);
        this.f٤١٦٩u.setImageDrawable(this.f٤١٤٨B);
        this.f٤١٦٩u.setVisibility(8);
        addView(this.f٤١٦٩u);
    }

    private void f() {
        if (this.f٤١٤٩a == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (!childAt.equals(this.f٤١٦٩u)) {
                    this.f٤١٤٩a = childAt;
                    return;
                }
            }
        }
    }

    private void g(float f10) {
        e eVar;
        if (f10 > this.f٤١٥٢d) {
            m(true, true);
            return;
        }
        this.f٤١٥٠b = false;
        this.f٤١٤٨B.j(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        if (!this.f٤١٦٦r) {
            eVar = new e();
        } else {
            eVar = null;
        }
        b(this.f٤١٦١m, eVar);
        this.f٤١٤٨B.d(false);
    }

    private boolean h(Animation animation) {
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            return true;
        }
        return false;
    }

    private void i(float f10) {
        this.f٤١٤٨B.d(true);
        float min = Math.min(1.0f, Math.abs(f10 / this.f٤١٥٢d));
        float max = (((float) Math.max(min - 0.4d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) * 5.0f) / 3.0f;
        float abs = Math.abs(f10) - this.f٤١٥٢d;
        int i10 = this.A;
        if (i10 <= 0) {
            if (this.J) {
                i10 = this.f٤١٧٤z - this.f٤١٧٣y;
            } else {
                i10 = this.f٤١٧٤z;
            }
        }
        float f11 = i10;
        double max2 = Math.max(DownloadProgress.UNKNOWN_PROGRESS, Math.min(abs, f11 * 2.0f) / f11) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i11 = this.f٤١٧٣y + ((int) ((f11 * min) + (f11 * pow * 2.0f)));
        if (this.f٤١٦٩u.getVisibility() != 0) {
            this.f٤١٦٩u.setVisibility(0);
        }
        if (!this.f٤١٦٦r) {
            this.f٤١٦٩u.setScaleX(1.0f);
            this.f٤١٦٩u.setScaleY(1.0f);
        }
        if (this.f٤١٦٦r) {
            setAnimationProgress(Math.min(1.0f, f10 / this.f٤١٥٢d));
        }
        if (f10 < this.f٤١٥٢d) {
            if (this.f٤١٤٨B.getAlpha() > 76 && !h(this.E)) {
                q();
            }
        } else if (this.f٤١٤٨B.getAlpha() < 255 && !h(this.F)) {
            p();
        }
        this.f٤١٤٨B.j(DownloadProgress.UNKNOWN_PROGRESS, Math.min(0.8f, max * 0.8f));
        this.f٤١٤٨B.e(Math.min(1.0f, max));
        this.f٤١٤٨B.g((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i11 - this.f٤١٦١m);
    }

    private void k(MotionEvent motionEvent) {
        int i10;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f٤١٦٥q) {
            if (actionIndex == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.f٤١٦٥q = motionEvent.getPointerId(i10);
        }
    }

    private void m(boolean z10, boolean z11) {
        if (this.f٤١٥٠b != z10) {
            this.H = z11;
            f();
            this.f٤١٥٠b = z10;
            if (z10) {
                a(this.f٤١٦١m, this.L);
            } else {
                r(this.L);
            }
        }
    }

    private Animation n(int i10, int i11) {
        d dVar = new d(i10, i11);
        dVar.setDuration(300L);
        this.f٤١٦٩u.setAnimationListener(null);
        this.f٤١٦٩u.clearAnimation();
        this.f٤١٦٩u.startAnimation(dVar);
        return dVar;
    }

    private void o(float f10) {
        float f11 = this.f٤١٦٣o;
        float f12 = f10 - f11;
        int i10 = this.f٤١٥١c;
        if (f12 > i10 && !this.f٤١٦٤p) {
            this.f٤١٦٢n = f11 + i10;
            this.f٤١٦٤p = true;
            this.f٤١٤٨B.setAlpha(76);
        }
    }

    private void p() {
        this.F = n(this.f٤١٤٨B.getAlpha(), KotlinVersion.MAX_COMPONENT_VALUE);
    }

    private void q() {
        this.E = n(this.f٤١٤٨B.getAlpha(), 76);
    }

    private void s(int i10, Animation.AnimationListener animationListener) {
        this.f٤١٧١w = i10;
        this.f٤١٧٢x = this.f٤١٦٩u.getScaleX();
        h hVar = new h();
        this.G = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f٤١٦٩u.setAnimationListener(animationListener);
        }
        this.f٤١٦٩u.clearAnimation();
        this.f٤١٦٩u.startAnimation(this.G);
    }

    private void setColorViewAlpha(int i10) {
        this.f٤١٦٩u.getBackground().setAlpha(i10);
        this.f٤١٤٨B.setAlpha(i10);
    }

    private void t(Animation.AnimationListener animationListener) {
        this.f٤١٦٩u.setVisibility(0);
        this.f٤١٤٨B.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
        b bVar = new b();
        this.C = bVar;
        bVar.setDuration(this.f٤١٦٠l);
        if (animationListener != null) {
            this.f٤١٦٩u.setAnimationListener(animationListener);
        }
        this.f٤١٦٩u.clearAnimation();
        this.f٤١٦٩u.startAnimation(this.C);
    }

    public boolean c() {
        View view = this.f٤١٤٩a;
        if (view instanceof ListView) {
            return androidx.core.widget.i.a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f٤١٥٥g.a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f٤١٥٥g.b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.f٤١٥٥g.c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f٤١٥٥g.f(i10, i11, i12, i13, iArr);
    }

    public void e(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        if (i14 == 0) {
            this.f٤١٥٥g.e(i10, i11, i12, i13, iArr, i14, iArr2);
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        int i12 = this.f٤١٧٠v;
        if (i12 < 0) {
            return i11;
        }
        if (i11 == i10 - 1) {
            return i12;
        }
        if (i11 >= i12) {
            return i11 + 1;
        }
        return i11;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f٤١٥٤f.a();
    }

    public int getProgressCircleDiameter() {
        return this.I;
    }

    public int getProgressViewEndOffset() {
        return this.f٤١٧٤z;
    }

    public int getProgressViewStartOffset() {
        return this.f٤١٧٣y;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f٤١٥٥g.k();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f٤١٥٥g.m();
    }

    void j(float f10) {
        setTargetOffsetTopAndBottom((this.f٤١٧١w + ((int) ((this.f٤١٧٣y - r0) * f10))) - this.f٤١٦٩u.getTop());
    }

    void l() {
        this.f٤١٦٩u.clearAnimation();
        this.f٤١٤٨B.stop();
        this.f٤١٦٩u.setVisibility(8);
        setColorViewAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
        if (this.f٤١٦٦r) {
            setAnimationProgress(DownloadProgress.UNKNOWN_PROGRESS);
        } else {
            setTargetOffsetTopAndBottom(this.f٤١٧٣y - this.f٤١٦١m);
        }
        this.f٤١٦١m = this.f٤١٦٩u.getTop();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f٤١٦٧s && actionMasked == 0) {
            this.f٤١٦٧s = false;
        }
        if (!isEnabled() || this.f٤١٦٧s || c() || this.f٤١٥٠b || this.f٤١٥٩k) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 6) {
                            k(motionEvent);
                        }
                    }
                } else {
                    int i10 = this.f٤١٦٥q;
                    if (i10 == -1) {
                        Log.e(O, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i10);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    o(motionEvent.getY(findPointerIndex));
                }
            }
            this.f٤١٦٤p = false;
            this.f٤١٦٥q = -1;
        } else {
            setTargetOffsetTopAndBottom(this.f٤١٧٣y - this.f٤١٦٩u.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f٤١٦٥q = pointerId;
            this.f٤١٦٤p = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f٤١٦٣o = motionEvent.getY(findPointerIndex2);
        }
        return this.f٤١٦٤p;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f٤١٤٩a == null) {
            f();
        }
        View view = this.f٤١٤٩a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f٤١٦٩u.getMeasuredWidth();
        int measuredHeight2 = this.f٤١٦٩u.getMeasuredHeight();
        int i14 = measuredWidth / 2;
        int i15 = measuredWidth2 / 2;
        int i16 = this.f٤١٦١m;
        this.f٤١٦٩u.layout(i14 - i15, i16, i14 + i15, measuredHeight2 + i16);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f٤١٤٩a == null) {
            f();
        }
        View view = this.f٤١٤٩a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f٤١٦٩u.measure(View.MeasureSpec.makeMeasureSpec(this.I, 1073741824), View.MeasureSpec.makeMeasureSpec(this.I, 1073741824));
        this.f٤١٧٠v = -1;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) == this.f٤١٦٩u) {
                this.f٤١٧٠v = i12;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // androidx.core.view.f0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // androidx.core.view.g0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i14 != 0) {
            return;
        }
        int i15 = iArr[1];
        e(i10, i11, i12, i13, this.f٤١٥٧i, i14, iArr);
        int i16 = i13 - (iArr[1] - i15);
        if ((i16 == 0 ? i13 + this.f٤١٥٧i[1] : i16) >= 0 || c()) {
            return;
        }
        float abs = this.f٤١٥٣e + Math.abs(r1);
        this.f٤١٥٣e = abs;
        i(abs);
        iArr[1] = iArr[1] + i16;
    }

    @Override // androidx.core.view.f0
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f٤١٧٥a);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f٤١٥٠b);
    }

    @Override // androidx.core.view.f0
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            return onStartNestedScroll(view, view2, i10);
        }
        return false;
    }

    @Override // androidx.core.view.f0
    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f٤١٦٧s && actionMasked == 0) {
            this.f٤١٦٧s = false;
        }
        if (!isEnabled() || this.f٤١٦٧s || c() || this.f٤١٥٠b || this.f٤١٥٩k) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        return false;
                    }
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            k(motionEvent);
                        }
                    } else {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex < 0) {
                            Log.e(O, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                            return false;
                        }
                        this.f٤١٦٥q = motionEvent.getPointerId(actionIndex);
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f٤١٦٥q);
                    if (findPointerIndex < 0) {
                        Log.e(O, "Got ACTION_MOVE event but have an invalid active pointer id.");
                        return false;
                    }
                    float y10 = motionEvent.getY(findPointerIndex);
                    o(y10);
                    if (this.f٤١٦٤p) {
                        float f10 = (y10 - this.f٤١٦٢n) * 0.5f;
                        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
                            return false;
                        }
                        getParent().requestDisallowInterceptTouchEvent(true);
                        i(f10);
                    }
                }
            } else {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.f٤١٦٥q);
                if (findPointerIndex2 < 0) {
                    Log.e(O, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f٤١٦٤p) {
                    float y11 = (motionEvent.getY(findPointerIndex2) - this.f٤١٦٢n) * 0.5f;
                    this.f٤١٦٤p = false;
                    g(y11);
                }
                this.f٤١٦٥q = -1;
                return false;
            }
        } else {
            this.f٤١٦٥q = motionEvent.getPointerId(0);
            this.f٤١٦٤p = false;
        }
        return true;
    }

    void r(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.D = cVar;
        cVar.setDuration(150L);
        this.f٤١٦٩u.setAnimationListener(animationListener);
        this.f٤١٦٩u.clearAnimation();
        this.f٤١٦٩u.startAnimation(this.D);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent;
        View view = this.f٤١٤٩a;
        if (view != null && !d1.W(view)) {
            if (!this.K && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(z10);
                return;
            }
            return;
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    void setAnimationProgress(float f10) {
        this.f٤١٦٩u.setScaleX(f10);
        this.f٤١٦٩u.setScaleY(f10);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        f();
        this.f٤١٤٨B.f(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = androidx.core.content.a.getColor(context, iArr[i10]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i10) {
        this.f٤١٥٢d = i10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!z10) {
            l();
        }
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z10) {
        this.K = z10;
    }

    @Override // android.view.View, androidx.core.view.d0
    public void setNestedScrollingEnabled(boolean z10) {
        this.f٤١٥٥g.n(z10);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
    }

    @Deprecated
    public void setProgressBackgroundColor(int i10) {
        setProgressBackgroundColorSchemeResource(i10);
    }

    public void setProgressBackgroundColorSchemeColor(int i10) {
        this.f٤١٦٩u.setBackgroundColor(i10);
    }

    public void setProgressBackgroundColorSchemeResource(int i10) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.a.getColor(getContext(), i10));
    }

    public void setRefreshing(boolean z10) {
        int i10;
        if (z10 && this.f٤١٥٠b != z10) {
            this.f٤١٥٠b = z10;
            if (!this.J) {
                i10 = this.f٤١٧٤z + this.f٤١٧٣y;
            } else {
                i10 = this.f٤١٧٤z;
            }
            setTargetOffsetTopAndBottom(i10 - this.f٤١٦١m);
            this.H = false;
            t(this.L);
            return;
        }
        m(z10, false);
    }

    public void setSize(int i10) {
        if (i10 != 0 && i10 != 1) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i10 == 0) {
            this.I = (int) (displayMetrics.density * 56.0f);
        } else {
            this.I = (int) (displayMetrics.density * 40.0f);
        }
        this.f٤١٦٩u.setImageDrawable(null);
        this.f٤١٤٨B.l(i10);
        this.f٤١٦٩u.setImageDrawable(this.f٤١٤٨B);
    }

    public void setSlingshotDistance(int i10) {
        this.A = i10;
    }

    void setTargetOffsetTopAndBottom(int i10) {
        this.f٤١٦٩u.bringToFront();
        d1.b0(this.f٤١٦٩u, i10);
        this.f٤١٦١m = this.f٤١٦٩u.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return this.f٤١٥٥g.p(i10);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.f٤١٥٥g.r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        final boolean f٤١٧٥a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable, boolean z10) {
            super(parcelable);
            this.f٤١٧٥a = z10;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f٤١٧٥a ? (byte) 1 : (byte) 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f٤١٧٥a = parcel.readByte() != 0;
        }
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٤١٥٠b = false;
        this.f٤١٥٢d = -1.0f;
        this.f٤١٥٦h = new int[2];
        this.f٤١٥٧i = new int[2];
        this.f٤١٥٨j = new int[2];
        this.f٤١٦٥q = -1;
        this.f٤١٧٠v = -1;
        this.L = new a();
        this.M = new f();
        this.N = new g();
        this.f٤١٥١c = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f٤١٦٠l = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f٤١٦٨t = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.I = (int) (displayMetrics.density * 40.0f);
        d();
        setChildrenDrawingOrderEnabled(true);
        int i10 = (int) (displayMetrics.density * 64.0f);
        this.f٤١٧٤z = i10;
        this.f٤١٥٢d = i10;
        this.f٤١٥٤f = new i0(this);
        this.f٤١٥٥g = new e0(this);
        setNestedScrollingEnabled(true);
        int i11 = -this.I;
        this.f٤١٦١m = i11;
        this.f٤١٧٣y = i11;
        j(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        if (i11 > 0) {
            float f10 = this.f٤١٥٣e;
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                float f11 = i11;
                if (f11 > f10) {
                    iArr[1] = (int) f10;
                    this.f٤١٥٣e = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    this.f٤١٥٣e = f10 - f11;
                    iArr[1] = i11;
                }
                i(this.f٤١٥٣e);
            }
        }
        if (this.J && i11 > 0 && this.f٤١٥٣e == DownloadProgress.UNKNOWN_PROGRESS && Math.abs(i11 - iArr[1]) > 0) {
            this.f٤١٦٩u.setVisibility(8);
        }
        int[] iArr2 = this.f٤١٥٦h;
        if (dispatchNestedPreScroll(i10 - iArr[0], i11 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f٤١٥٤f.b(view, view2, i10);
        startNestedScroll(i10 & 2);
        this.f٤١٥٣e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٤١٥٩k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return (!isEnabled() || this.f٤١٦٧s || this.f٤١٥٠b || (i10 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.f٤١٥٤f.d(view);
        this.f٤١٥٩k = false;
        float f10 = this.f٤١٥٣e;
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            g(f10);
            this.f٤١٥٣e = DownloadProgress.UNKNOWN_PROGRESS;
        }
        stopNestedScroll();
    }

    @Override // androidx.core.view.f0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i10, i11, i12, i13, i14, this.f٤١٥٨j);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0, this.f٤١٥٨j);
    }
}
