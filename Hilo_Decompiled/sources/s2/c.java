package s2;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {

    /* renamed from: x, reason: collision with root package name */
    private static final Interpolator f١٧٦٩٣x = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f١٧٦٩٤a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٧٦٩٥b;

    /* renamed from: d, reason: collision with root package name */
    private float[] f١٧٦٩٧d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f١٧٦٩٨e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f١٧٦٩٩f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f١٧٧٠٠g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f١٧٧٠١h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f١٧٧٠٢i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f١٧٧٠٣j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٧٧٠٤k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f١٧٧٠٥l;

    /* renamed from: m, reason: collision with root package name */
    private float f١٧٧٠٦m;

    /* renamed from: n, reason: collision with root package name */
    private float f١٧٧٠٧n;

    /* renamed from: o, reason: collision with root package name */
    private int f١٧٧٠٨o;

    /* renamed from: p, reason: collision with root package name */
    private final int f١٧٧٠٩p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٧٧١٠q;

    /* renamed from: r, reason: collision with root package name */
    private OverScroller f١٧٧١١r;

    /* renamed from: s, reason: collision with root package name */
    private final AbstractC٠٢٢٦c f١٧٧١٢s;

    /* renamed from: t, reason: collision with root package name */
    private View f١٧٧١٣t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f١٧٧١٤u;

    /* renamed from: v, reason: collision with root package name */
    private final ViewGroup f١٧٧١٥v;

    /* renamed from: c, reason: collision with root package name */
    private int f١٧٦٩٦c = -1;

    /* renamed from: w, reason: collision with root package name */
    private final Runnable f١٧٧١٦w = new b();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.L(0);
        }
    }

    private c(Context context, ViewGroup viewGroup, AbstractC٠٢٢٦c r42) {
        if (viewGroup != null) {
            if (r42 != null) {
                this.f١٧٧١٥v = viewGroup;
                this.f١٧٧١٢s = r42;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.f١٧٧٠٩p = i10;
                this.f١٧٧٠٨o = i10;
                this.f١٧٦٩٥b = viewConfiguration.getScaledTouchSlop();
                this.f١٧٧٠٦m = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f١٧٧٠٧n = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f١٧٧١١r = new OverScroller(context, f١٧٦٩٣x);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean E(int i10) {
        if (!D(i10)) {
            Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return true;
    }

    private void H() {
        this.f١٧٧٠٥l.computeCurrentVelocity(1000, this.f١٧٧٠٦m);
        q(h(this.f١٧٧٠٥l.getXVelocity(this.f١٧٦٩٦c), this.f١٧٧٠٧n, this.f١٧٧٠٦m), h(this.f١٧٧٠٥l.getYVelocity(this.f١٧٦٩٦c), this.f١٧٧٠٧n, this.f١٧٧٠٦m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [s2.c$c] */
    private void I(float f10, float f11, int i10) {
        boolean d10 = d(f10, f11, i10, 1);
        boolean z10 = d10;
        if (d(f11, f10, i10, 4)) {
            z10 = (d10 ? 1 : 0) | 4;
        }
        boolean z11 = z10;
        if (d(f10, f11, i10, 2)) {
            z11 = (z10 ? 1 : 0) | 2;
        }
        ?? r02 = z11;
        if (d(f11, f10, i10, 8)) {
            r02 = (z11 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f١٧٧٠٢i;
            iArr[i10] = iArr[i10] | r02;
            this.f١٧٧١٢s.onEdgeDragStarted(r02, i10);
        }
    }

    private void J(float f10, float f11, int i10) {
        t(i10);
        float[] fArr = this.f١٧٦٩٧d;
        this.f١٧٦٩٩f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f١٧٦٩٨e;
        this.f١٧٧٠٠g[i10] = f11;
        fArr2[i10] = f11;
        this.f١٧٧٠١h[i10] = z((int) f10, (int) f11);
        this.f١٧٧٠٤k |= 1 << i10;
    }

    private void K(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (E(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f١٧٦٩٩f[pointerId] = x10;
                this.f١٧٧٠٠g[pointerId] = y10;
            }
        }
    }

    private boolean d(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f١٧٧٠١h[i10] & i11) != i11 || (this.f١٧٧١٠q & i11) == 0 || (this.f١٧٧٠٣j[i10] & i11) == i11 || (this.f١٧٧٠٢i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f١٧٦٩٥b;
        if (abs <= i12 && abs2 <= i12) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f١٧٧١٢s.onEdgeLock(i11)) {
            int[] iArr = this.f١٧٧٠٣j;
            iArr[i10] = iArr[i10] | i11;
            return false;
        }
        if ((this.f١٧٧٠٢i[i10] & i11) != 0 || abs <= this.f١٧٦٩٥b) {
            return false;
        }
        return true;
    }

    private boolean g(View view, float f10, float f11) {
        boolean z10;
        boolean z11;
        if (view == null) {
            return false;
        }
        if (this.f١٧٧١٢s.getViewHorizontalDragRange(view) > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f١٧٧١٢s.getViewVerticalDragRange(view) > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && z11) {
            float f12 = (f10 * f10) + (f11 * f11);
            int i10 = this.f١٧٦٩٥b;
            if (f12 <= i10 * i10) {
                return false;
            }
            return true;
        }
        if (z10) {
            if (Math.abs(f10) <= this.f١٧٦٩٥b) {
                return false;
            }
            return true;
        }
        if (!z11 || Math.abs(f11) <= this.f١٧٦٩٥b) {
            return false;
        }
        return true;
    }

    private float h(float f10, float f11, float f12) {
        float abs = Math.abs(f10);
        if (abs < f11) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (abs > f12) {
            if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
                return -f12;
            }
            return f12;
        }
        return f10;
    }

    private int i(int i10, int i11, int i12) {
        int abs = Math.abs(i10);
        if (abs < i11) {
            return 0;
        }
        if (abs > i12) {
            if (i10 <= 0) {
                return -i12;
            }
            return i12;
        }
        return i10;
    }

    private void j() {
        float[] fArr = this.f١٧٦٩٧d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, DownloadProgress.UNKNOWN_PROGRESS);
        Arrays.fill(this.f١٧٦٩٨e, DownloadProgress.UNKNOWN_PROGRESS);
        Arrays.fill(this.f١٧٦٩٩f, DownloadProgress.UNKNOWN_PROGRESS);
        Arrays.fill(this.f١٧٧٠٠g, DownloadProgress.UNKNOWN_PROGRESS);
        Arrays.fill(this.f١٧٧٠١h, 0);
        Arrays.fill(this.f١٧٧٠٢i, 0);
        Arrays.fill(this.f١٧٧٠٣j, 0);
        this.f١٧٧٠٤k = 0;
    }

    private void k(int i10) {
        if (this.f١٧٦٩٧d != null && D(i10)) {
            this.f١٧٦٩٧d[i10] = 0.0f;
            this.f١٧٦٩٨e[i10] = 0.0f;
            this.f١٧٦٩٩f[i10] = 0.0f;
            this.f١٧٧٠٠g[i10] = 0.0f;
            this.f١٧٧٠١h[i10] = 0;
            this.f١٧٧٠٢i[i10] = 0;
            this.f١٧٧٠٣j[i10] = 0;
            this.f١٧٧٠٤k = (~(1 << i10)) & this.f١٧٧٠٤k;
        }
    }

    private int l(int i10, int i11, int i12) {
        int abs;
        if (i10 == 0) {
            return 0;
        }
        int width = this.f١٧٧١٥v.getWidth();
        float f10 = width / 2;
        float r10 = f10 + (r(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int abs2 = Math.abs(i11);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(r10 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int m(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int i14 = i(i12, (int) this.f١٧٧٠٧n, (int) this.f١٧٧٠٦m);
        int i15 = i(i13, (int) this.f١٧٧٠٧n, (int) this.f١٧٧٠٦m);
        int abs = Math.abs(i10);
        int abs2 = Math.abs(i11);
        int abs3 = Math.abs(i14);
        int abs4 = Math.abs(i15);
        int i16 = abs3 + abs4;
        int i17 = abs + abs2;
        if (i14 != 0) {
            f10 = abs3;
            f11 = i16;
        } else {
            f10 = abs;
            f11 = i17;
        }
        float f14 = f10 / f11;
        if (i15 != 0) {
            f12 = abs4;
            f13 = i16;
        } else {
            f12 = abs2;
            f13 = i17;
        }
        return (int) ((l(i10, i14, this.f١٧٧١٢s.getViewHorizontalDragRange(view)) * f14) + (l(i11, i15, this.f١٧٧١٢s.getViewVerticalDragRange(view)) * (f12 / f13)));
    }

    public static c o(ViewGroup viewGroup, float f10, AbstractC٠٢٢٦c r32) {
        c p10 = p(viewGroup, r32);
        p10.f١٧٦٩٥b = (int) (p10.f١٧٦٩٥b * (1.0f / f10));
        return p10;
    }

    public static c p(ViewGroup viewGroup, AbstractC٠٢٢٦c r32) {
        return new c(viewGroup.getContext(), viewGroup, r32);
    }

    private void q(float f10, float f11) {
        this.f١٧٧١٤u = true;
        this.f١٧٧١٢s.onViewReleased(this.f١٧٧١٣t, f10, f11);
        this.f١٧٧١٤u = false;
        if (this.f١٧٦٩٤a == 1) {
            L(0);
        }
    }

    private float r(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    private void s(int i10, int i11, int i12, int i13) {
        int left = this.f١٧٧١٣t.getLeft();
        int top = this.f١٧٧١٣t.getTop();
        if (i12 != 0) {
            i10 = this.f١٧٧١٢s.clampViewPositionHorizontal(this.f١٧٧١٣t, i10, i12);
            d1.a0(this.f١٧٧١٣t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f١٧٧١٢s.clampViewPositionVertical(this.f١٧٧١٣t, i11, i13);
            d1.b0(this.f١٧٧١٣t, i11 - top);
        }
        int i15 = i11;
        if (i12 != 0 || i13 != 0) {
            this.f١٧٧١٢s.onViewPositionChanged(this.f١٧٧١٣t, i14, i15, i14 - left, i15 - top);
        }
    }

    private void t(int i10) {
        float[] fArr = this.f١٧٦٩٧d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f١٧٦٩٨e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f١٧٦٩٩f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f١٧٧٠٠g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f١٧٧٠١h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f١٧٧٠٢i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f١٧٧٠٣j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f١٧٦٩٧d = fArr2;
            this.f١٧٦٩٨e = fArr3;
            this.f١٧٦٩٩f = fArr4;
            this.f١٧٧٠٠g = fArr5;
            this.f١٧٧٠١h = iArr;
            this.f١٧٧٠٢i = iArr2;
            this.f١٧٧٠٣j = iArr3;
        }
    }

    private boolean v(int i10, int i11, int i12, int i13) {
        int left = this.f١٧٧١٣t.getLeft();
        int top = this.f١٧٧١٣t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f١٧٧١١r.abortAnimation();
            L(0);
            return false;
        }
        this.f١٧٧١١r.startScroll(left, top, i14, i15, m(this.f١٧٧١٣t, i14, i15, i12, i13));
        L(2);
        return true;
    }

    private int z(int i10, int i11) {
        int i12;
        if (i10 < this.f١٧٧١٥v.getLeft() + this.f١٧٧٠٨o) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        if (i11 < this.f١٧٧١٥v.getTop() + this.f١٧٧٠٨o) {
            i12 |= 4;
        }
        if (i10 > this.f١٧٧١٥v.getRight() - this.f١٧٧٠٨o) {
            i12 |= 2;
        }
        if (i11 > this.f١٧٧١٥v.getBottom() - this.f١٧٧٠٨o) {
            return i12 | 8;
        }
        return i12;
    }

    public int A() {
        return this.f١٧٦٩٥b;
    }

    public int B() {
        return this.f١٧٦٩٤a;
    }

    public boolean C(int i10, int i11) {
        return F(this.f١٧٧١٣t, i10, i11);
    }

    public boolean D(int i10) {
        if (((1 << i10) & this.f١٧٧٠٤k) != 0) {
            return true;
        }
        return false;
    }

    public boolean F(View view, int i10, int i11) {
        if (view == null || i10 < view.getLeft() || i10 >= view.getRight() || i11 < view.getTop() || i11 >= view.getBottom()) {
            return false;
        }
        return true;
    }

    public void G(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f١٧٧٠٥l == null) {
            this.f١٧٧٠٥l = VelocityTracker.obtain();
        }
        this.f١٧٧٠٥l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                if (this.f١٧٦٩٤a == 1 && pointerId == this.f١٧٦٩٦c) {
                                    int pointerCount = motionEvent.getPointerCount();
                                    while (true) {
                                        if (i11 < pointerCount) {
                                            int pointerId2 = motionEvent.getPointerId(i11);
                                            if (pointerId2 != this.f١٧٦٩٦c) {
                                                View u10 = u((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                                                View view = this.f١٧٧١٣t;
                                                if (u10 == view && S(view, pointerId2)) {
                                                    i10 = this.f١٧٦٩٦c;
                                                    break;
                                                }
                                            }
                                            i11++;
                                        } else {
                                            i10 = -1;
                                            break;
                                        }
                                    }
                                    if (i10 == -1) {
                                        H();
                                    }
                                }
                                k(pointerId);
                                return;
                            }
                            return;
                        }
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        float x10 = motionEvent.getX(actionIndex);
                        float y10 = motionEvent.getY(actionIndex);
                        J(x10, y10, pointerId3);
                        if (this.f١٧٦٩٤a == 0) {
                            S(u((int) x10, (int) y10), pointerId3);
                            int i12 = this.f١٧٧٠١h[pointerId3];
                            int i13 = this.f١٧٧١٠q;
                            if ((i12 & i13) != 0) {
                                this.f١٧٧١٢s.onEdgeTouched(i12 & i13, pointerId3);
                                return;
                            }
                            return;
                        }
                        if (C((int) x10, (int) y10)) {
                            S(this.f١٧٧١٣t, pointerId3);
                            return;
                        }
                        return;
                    }
                    if (this.f١٧٦٩٤a == 1) {
                        q(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
                    }
                    b();
                    return;
                }
                if (this.f١٧٦٩٤a == 1) {
                    if (E(this.f١٧٦٩٦c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f١٧٦٩٦c);
                        float x11 = motionEvent.getX(findPointerIndex);
                        float y11 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f١٧٦٩٩f;
                        int i14 = this.f١٧٦٩٦c;
                        int i15 = (int) (x11 - fArr[i14]);
                        int i16 = (int) (y11 - this.f١٧٧٠٠g[i14]);
                        s(this.f١٧٧١٣t.getLeft() + i15, this.f١٧٧١٣t.getTop() + i16, i15, i16);
                        K(motionEvent);
                        return;
                    }
                    return;
                }
                int pointerCount2 = motionEvent.getPointerCount();
                while (i11 < pointerCount2) {
                    int pointerId4 = motionEvent.getPointerId(i11);
                    if (E(pointerId4)) {
                        float x12 = motionEvent.getX(i11);
                        float y12 = motionEvent.getY(i11);
                        float f10 = x12 - this.f١٧٦٩٧d[pointerId4];
                        float f11 = y12 - this.f١٧٦٩٨e[pointerId4];
                        I(f10, f11, pointerId4);
                        if (this.f١٧٦٩٤a != 1) {
                            View u11 = u((int) x12, (int) y12);
                            if (g(u11, f10, f11) && S(u11, pointerId4)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i11++;
                }
                K(motionEvent);
                return;
            }
            if (this.f١٧٦٩٤a == 1) {
                H();
            }
            b();
            return;
        }
        float x13 = motionEvent.getX();
        float y13 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View u12 = u((int) x13, (int) y13);
        J(x13, y13, pointerId5);
        S(u12, pointerId5);
        int i17 = this.f١٧٧٠١h[pointerId5];
        int i18 = this.f١٧٧١٠q;
        if ((i17 & i18) != 0) {
            this.f١٧٧١٢s.onEdgeTouched(i17 & i18, pointerId5);
        }
    }

    void L(int i10) {
        this.f١٧٧١٥v.removeCallbacks(this.f١٧٧١٦w);
        if (this.f١٧٦٩٤a != i10) {
            this.f١٧٦٩٤a = i10;
            this.f١٧٧١٢s.onViewDragStateChanged(i10);
            if (this.f١٧٦٩٤a == 0) {
                this.f١٧٧١٣t = null;
            }
        }
    }

    public void M(int i10) {
        this.f١٧٧٠٨o = i10;
    }

    public void N(int i10) {
        this.f١٧٧١٠q = i10;
    }

    public void O(float f10) {
        this.f١٧٧٠٧n = f10;
    }

    public boolean P(int i10, int i11) {
        if (this.f١٧٧١٤u) {
            return v(i10, i11, (int) this.f١٧٧٠٥l.getXVelocity(this.f١٧٦٩٦c), (int) this.f١٧٧٠٥l.getYVelocity(this.f١٧٦٩٦c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:
    
        if (r12 != r11) goto L٥٤;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Q(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        View u10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f١٧٧٠٥l == null) {
            this.f١٧٧٠٥l = VelocityTracker.obtain();
        }
        this.f١٧٧٠٥l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                k(motionEvent.getPointerId(actionIndex));
                            }
                        } else {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x10 = motionEvent.getX(actionIndex);
                            float y10 = motionEvent.getY(actionIndex);
                            J(x10, y10, pointerId);
                            int i10 = this.f١٧٦٩٤a;
                            if (i10 == 0) {
                                int i11 = this.f١٧٧٠١h[pointerId];
                                int i12 = this.f١٧٧١٠q;
                                if ((i11 & i12) != 0) {
                                    this.f١٧٧١٢s.onEdgeTouched(i11 & i12, pointerId);
                                }
                            } else if (i10 == 2 && (u10 = u((int) x10, (int) y10)) == this.f١٧٧١٣t) {
                                S(u10, pointerId);
                            }
                        }
                    }
                } else if (this.f١٧٦٩٧d != null && this.f١٧٦٩٨e != null) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i13 = 0; i13 < pointerCount; i13++) {
                        int pointerId2 = motionEvent.getPointerId(i13);
                        if (E(pointerId2)) {
                            float x11 = motionEvent.getX(i13);
                            float y11 = motionEvent.getY(i13);
                            float f10 = x11 - this.f١٧٦٩٧d[pointerId2];
                            float f11 = y11 - this.f١٧٦٩٨e[pointerId2];
                            View u11 = u((int) x11, (int) y11);
                            if (u11 != null && g(u11, f10, f11)) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z11) {
                                int left = u11.getLeft();
                                int i14 = (int) f10;
                                int clampViewPositionHorizontal = this.f١٧٧١٢s.clampViewPositionHorizontal(u11, left + i14, i14);
                                int top = u11.getTop();
                                int i15 = (int) f11;
                                int clampViewPositionVertical = this.f١٧٧١٢s.clampViewPositionVertical(u11, top + i15, i15);
                                int viewHorizontalDragRange = this.f١٧٧١٢s.getViewHorizontalDragRange(u11);
                                int viewVerticalDragRange = this.f١٧٧١٢s.getViewVerticalDragRange(u11);
                                if (viewHorizontalDragRange != 0) {
                                    if (viewHorizontalDragRange > 0) {
                                    }
                                }
                                if (viewVerticalDragRange == 0) {
                                    break;
                                }
                                if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                    break;
                                }
                            }
                            I(f10, f11, pointerId2);
                            if (this.f١٧٦٩٤a == 1) {
                                break;
                            }
                            if (z11 && S(u11, pointerId2)) {
                                break;
                            }
                        }
                    }
                    K(motionEvent);
                }
                z10 = false;
            }
            b();
            z10 = false;
        } else {
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            z10 = false;
            int pointerId3 = motionEvent.getPointerId(0);
            J(x12, y12, pointerId3);
            View u12 = u((int) x12, (int) y12);
            if (u12 == this.f١٧٧١٣t && this.f١٧٦٩٤a == 2) {
                S(u12, pointerId3);
            }
            int i16 = this.f١٧٧٠١h[pointerId3];
            int i17 = this.f١٧٧١٠q;
            if ((i16 & i17) != 0) {
                this.f١٧٧١٢s.onEdgeTouched(i16 & i17, pointerId3);
            }
        }
        if (this.f١٧٦٩٤a == 1) {
            return true;
        }
        return z10;
    }

    public boolean R(View view, int i10, int i11) {
        this.f١٧٧١٣t = view;
        this.f١٧٦٩٦c = -1;
        boolean v10 = v(i10, i11, 0, 0);
        if (!v10 && this.f١٧٦٩٤a == 0 && this.f١٧٧١٣t != null) {
            this.f١٧٧١٣t = null;
        }
        return v10;
    }

    boolean S(View view, int i10) {
        if (view == this.f١٧٧١٣t && this.f١٧٦٩٦c == i10) {
            return true;
        }
        if (view != null && this.f١٧٧١٢s.tryCaptureView(view, i10)) {
            this.f١٧٦٩٦c = i10;
            c(view, i10);
            return true;
        }
        return false;
    }

    public void a() {
        b();
        if (this.f١٧٦٩٤a == 2) {
            int currX = this.f١٧٧١١r.getCurrX();
            int currY = this.f١٧٧١١r.getCurrY();
            this.f١٧٧١١r.abortAnimation();
            int currX2 = this.f١٧٧١١r.getCurrX();
            int currY2 = this.f١٧٧١١r.getCurrY();
            this.f١٧٧١٢s.onViewPositionChanged(this.f١٧٧١٣t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        L(0);
    }

    public void b() {
        this.f١٧٦٩٦c = -1;
        j();
        VelocityTracker velocityTracker = this.f١٧٧٠٥l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f١٧٧٠٥l = null;
        }
    }

    public void c(View view, int i10) {
        if (view.getParent() == this.f١٧٧١٥v) {
            this.f١٧٧١٣t = view;
            this.f١٧٦٩٦c = i10;
            this.f١٧٧١٢s.onViewCaptured(view, i10);
            L(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f١٧٧١٥v + ")");
    }

    public boolean e(int i10) {
        int length = this.f١٧٦٩٧d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (f(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i10, int i11) {
        boolean z10;
        boolean z11;
        if (!D(i11)) {
            return false;
        }
        if ((i10 & 1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((i10 & 2) == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        float f10 = this.f١٧٦٩٩f[i11] - this.f١٧٦٩٧d[i11];
        float f11 = this.f١٧٧٠٠g[i11] - this.f١٧٦٩٨e[i11];
        if (z10 && z11) {
            float f12 = (f10 * f10) + (f11 * f11);
            int i12 = this.f١٧٦٩٥b;
            if (f12 <= i12 * i12) {
                return false;
            }
            return true;
        }
        if (z10) {
            if (Math.abs(f10) <= this.f١٧٦٩٥b) {
                return false;
            }
            return true;
        }
        if (!z11 || Math.abs(f11) <= this.f١٧٦٩٥b) {
            return false;
        }
        return true;
    }

    public boolean n(boolean z10) {
        if (this.f١٧٦٩٤a == 2) {
            boolean computeScrollOffset = this.f١٧٧١١r.computeScrollOffset();
            int currX = this.f١٧٧١١r.getCurrX();
            int currY = this.f١٧٧١١r.getCurrY();
            int left = currX - this.f١٧٧١٣t.getLeft();
            int top = currY - this.f١٧٧١٣t.getTop();
            if (left != 0) {
                d1.a0(this.f١٧٧١٣t, left);
            }
            if (top != 0) {
                d1.b0(this.f١٧٧١٣t, top);
            }
            if (left != 0 || top != 0) {
                this.f١٧٧١٢s.onViewPositionChanged(this.f١٧٧١٣t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f١٧٧١١r.getFinalX() && currY == this.f١٧٧١١r.getFinalY()) {
                this.f١٧٧١١r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z10) {
                    this.f١٧٧١٥v.post(this.f١٧٧١٦w);
                } else {
                    L(0);
                }
            }
        }
        if (this.f١٧٦٩٤a != 2) {
            return false;
        }
        return true;
    }

    public View u(int i10, int i11) {
        for (int childCount = this.f١٧٧١٥v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f١٧٧١٥v.getChildAt(this.f١٧٧١٢s.getOrderedChildIndex(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View w() {
        return this.f١٧٧١٣t;
    }

    public int x() {
        return this.f١٧٧٠٩p;
    }

    public int y() {
        return this.f١٧٧٠٨o;
    }

    /* renamed from: s2.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class AbstractC٠٢٢٦c {
        public abstract int clampViewPositionHorizontal(View view, int i10, int i11);

        public abstract int clampViewPositionVertical(View view, int i10, int i11);

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public boolean onEdgeLock(int i10) {
            return false;
        }

        public abstract void onViewPositionChanged(View view, int i10, int i11, int i12, int i13);

        public abstract boolean tryCaptureView(View view, int i10);

        public int getOrderedChildIndex(int i10) {
            return i10;
        }

        public void onViewDragStateChanged(int i10) {
        }

        public void onEdgeDragStarted(int i10, int i11) {
        }

        public void onEdgeTouched(int i10, int i11) {
        }

        public void onViewCaptured(View view, int i10) {
        }

        public void onViewReleased(View view, float f10, float f11) {
        }
    }
}
