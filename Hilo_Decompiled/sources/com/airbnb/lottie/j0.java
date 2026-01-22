package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j0 extends Drawable implements Drawable.Callback, Animatable {
    private static final boolean R;
    private static final List S;
    private static final Executor T;
    private Rect A;

    /* renamed from: B, reason: collision with root package name */
    private RectF f٦١٩٨B;
    private Paint C;
    private Rect D;
    private Rect E;
    private RectF F;
    private RectF G;
    private Matrix H;
    private Matrix I;
    private boolean J;
    private com.airbnb.lottie.a K;
    private final ValueAnimator.AnimatorUpdateListener L;
    private final Semaphore M;
    private Handler N;
    private Runnable O;
    private final Runnable P;
    private float Q;

    /* renamed from: a, reason: collision with root package name */
    private j f٦١٩٩a;

    /* renamed from: b, reason: collision with root package name */
    private final x3.i f٦٢٠٠b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f٦٢٠١c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٦٢٠٢d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٦٢٠٣e;

    /* renamed from: f, reason: collision with root package name */
    private b f٦٢٠٤f;

    /* renamed from: g, reason: collision with root package name */
    private final ArrayList f٦٢٠٥g;

    /* renamed from: h, reason: collision with root package name */
    private p3.b f٦٢٠٦h;

    /* renamed from: i, reason: collision with root package name */
    private String f٦٢٠٧i;

    /* renamed from: j, reason: collision with root package name */
    private p3.a f٦٢٠٨j;

    /* renamed from: k, reason: collision with root package name */
    private Map f٦٢٠٩k;

    /* renamed from: l, reason: collision with root package name */
    String f٦٢١٠l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٦٢١١m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f٦٢١٢n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٦٢١٣o;

    /* renamed from: p, reason: collision with root package name */
    private t3.c f٦٢١٤p;

    /* renamed from: q, reason: collision with root package name */
    private int f٦٢١٥q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٦٢١٦r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٦٢١٧s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f٦٢١٨t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f٦٢١٩u;

    /* renamed from: v, reason: collision with root package name */
    private s0 f٦٢٢٠v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f٦٢٢١w;

    /* renamed from: x, reason: collision with root package name */
    private final Matrix f٦٢٢٢x;

    /* renamed from: y, reason: collision with root package name */
    private Bitmap f٦٢٢٣y;

    /* renamed from: z, reason: collision with root package name */
    private Canvas f٦٢٢٤z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface a {
        void a(j jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum b {
        NONE,
        PLAY,
        RESUME
    }

    static {
        boolean z10;
        if (Build.VERSION.SDK_INT <= 25) {
            z10 = true;
        } else {
            z10 = false;
        }
        R = z10;
        S = Arrays.asList("reduced motion", "reduced_motion", "reduced-motion", "reducedmotion");
        T = new ThreadPoolExecutor(0, 2, 35L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new x3.g());
    }

    public j0() {
        x3.i iVar = new x3.i();
        this.f٦٢٠٠b = iVar;
        this.f٦٢٠١c = true;
        this.f٦٢٠٢d = false;
        this.f٦٢٠٣e = false;
        this.f٦٢٠٤f = b.NONE;
        this.f٦٢٠٥g = new ArrayList();
        this.f٦٢١٢n = false;
        this.f٦٢١٣o = true;
        this.f٦٢١٥q = KotlinVersion.MAX_COMPONENT_VALUE;
        this.f٦٢١٩u = false;
        this.f٦٢٢٠v = s0.AUTOMATIC;
        this.f٦٢٢١w = false;
        this.f٦٢٢٢x = new Matrix();
        this.J = false;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.d0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                j0.this.h0(valueAnimator);
            }
        };
        this.L = animatorUpdateListener;
        this.M = new Semaphore(1);
        this.P = new Runnable() { // from class: com.airbnb.lottie.e0
            @Override // java.lang.Runnable
            public final void run() {
                j0.this.j0();
            }
        };
        this.Q = -3.4028235E38f;
        iVar.addUpdateListener(animatorUpdateListener);
    }

    private void B0(RectF rectF, float f10, float f11) {
        rectF.set(rectF.left * f10, rectF.top * f11, rectF.right * f10, rectF.bottom * f11);
    }

    private void C(int i10, int i11) {
        Bitmap bitmap = this.f٦٢٢٣y;
        if (bitmap != null && bitmap.getWidth() >= i10 && this.f٦٢٢٣y.getHeight() >= i11) {
            if (this.f٦٢٢٣y.getWidth() > i10 || this.f٦٢٢٣y.getHeight() > i11) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f٦٢٢٣y, 0, 0, i10, i11);
                this.f٦٢٢٣y = createBitmap;
                this.f٦٢٢٤z.setBitmap(createBitmap);
                this.J = true;
                return;
            }
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        this.f٦٢٢٣y = createBitmap2;
        this.f٦٢٢٤z.setBitmap(createBitmap2);
        this.J = true;
    }

    private void D() {
        if (this.f٦٢٢٤z != null) {
            return;
        }
        this.f٦٢٢٤z = new Canvas();
        this.G = new RectF();
        this.H = new Matrix();
        this.I = new Matrix();
        this.A = new Rect();
        this.f٦١٩٨B = new RectF();
        this.C = new m3.a();
        this.D = new Rect();
        this.E = new Rect();
        this.F = new RectF();
    }

    private Context K() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    private p3.a L() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f٦٢٠٨j == null) {
            p3.a aVar = new p3.a(getCallback(), null);
            this.f٦٢٠٨j = aVar;
            String str = this.f٦٢١٠l;
            if (str != null) {
                aVar.c(str);
            }
        }
        return this.f٦٢٠٨j;
    }

    private p3.b N() {
        p3.b bVar = this.f٦٢٠٦h;
        if (bVar != null && !bVar.b(K())) {
            this.f٦٢٠٦h = null;
        }
        if (this.f٦٢٠٦h == null) {
            this.f٦٢٠٦h = new p3.b(getCallback(), this.f٦٢٠٧i, null, this.f٦١٩٩a.j());
        }
        return this.f٦٢٠٦h;
    }

    private q3.h R() {
        Iterator it = S.iterator();
        q3.h hVar = null;
        while (it.hasNext()) {
            hVar = this.f٦١٩٩a.l((String) it.next());
            if (hVar != null) {
                break;
            }
        }
        return hVar;
    }

    private boolean c0() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (!(((View) callback).getParent() instanceof ViewGroup)) {
            return false;
        }
        return !((ViewGroup) r0).getClipChildren();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(q3.e eVar, Object obj, y3.c cVar, j jVar) {
        q(eVar, obj, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(ValueAnimator valueAnimator) {
        if (F()) {
            invalidateSelf();
            return;
        }
        t3.c cVar = this.f٦٢١٤p;
        if (cVar != null) {
            cVar.M(this.f٦٢٠٠b.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0() {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    private boolean i1() {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            return false;
        }
        float f10 = this.Q;
        float j10 = this.f٦٢٠٠b.j();
        this.Q = j10;
        if (Math.abs(j10 - f10) * jVar.d() < 50.0f) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0() {
        t3.c cVar = this.f٦٢١٤p;
        if (cVar == null) {
            return;
        }
        try {
            this.M.acquire();
            cVar.M(this.f٦٢٠٠b.j());
            if (R && this.J) {
                if (this.N == null) {
                    this.N = new Handler(Looper.getMainLooper());
                    this.O = new Runnable() { // from class: com.airbnb.lottie.z
                        @Override // java.lang.Runnable
                        public final void run() {
                            j0.this.i0();
                        }
                    };
                }
                this.N.post(this.O);
            }
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            this.M.release();
            throw th;
        }
        this.M.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(j jVar) {
        x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(j jVar) {
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(int i10, j jVar) {
        K0(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(String str, j jVar) {
        Q0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(int i10, j jVar) {
        P0(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(float f10, j jVar) {
        R0(f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(String str, j jVar) {
        T0(str);
    }

    private boolean r() {
        if (!this.f٦٢٠١c && !this.f٦٢٠٢d) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(int i10, int i11, j jVar) {
        S0(i10, i11);
    }

    private void s() {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            return;
        }
        t3.c cVar = new t3.c(this, v3.v.a(jVar), jVar.k(), jVar);
        this.f٦٢١٤p = cVar;
        if (this.f٦٢١٧s) {
            cVar.K(true);
        }
        this.f٦٢١٤p.Q(this.f٦٢١٣o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(int i10, j jVar) {
        U0(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(String str, j jVar) {
        V0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(float f10, j jVar) {
        W0(f10);
    }

    private void v() {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            return;
        }
        this.f٦٢٢١w = this.f٦٢٢٠v.c(Build.VERSION.SDK_INT, jVar.q(), jVar.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(float f10, j jVar) {
        Z0(f10);
    }

    private void w(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void x(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void y(Canvas canvas) {
        t3.c cVar = this.f٦٢١٤p;
        j jVar = this.f٦١٩٩a;
        if (cVar != null && jVar != null) {
            this.f٦٢٢٢x.reset();
            if (!getBounds().isEmpty()) {
                this.f٦٢٢٢x.preScale(r2.width() / jVar.b().width(), r2.height() / jVar.b().height());
                this.f٦٢٢٢x.preTranslate(r2.left, r2.top);
            }
            cVar.h(canvas, this.f٦٢٢٢x, this.f٦٢١٥q);
        }
    }

    private void y0(Canvas canvas, t3.c cVar) {
        if (this.f٦١٩٩a != null && cVar != null) {
            D();
            canvas.getMatrix(this.H);
            canvas.getClipBounds(this.A);
            w(this.A, this.f٦١٩٨B);
            this.H.mapRect(this.f٦١٩٨B);
            x(this.f٦١٩٨B, this.A);
            if (this.f٦٢١٣o) {
                this.G.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getIntrinsicWidth(), getIntrinsicHeight());
            } else {
                cVar.f(this.G, null, false);
            }
            this.H.mapRect(this.G);
            Rect bounds = getBounds();
            float width = bounds.width() / getIntrinsicWidth();
            float height = bounds.height() / getIntrinsicHeight();
            B0(this.G, width, height);
            if (!c0()) {
                RectF rectF = this.G;
                Rect rect = this.A;
                rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
            }
            int ceil = (int) Math.ceil(this.G.width());
            int ceil2 = (int) Math.ceil(this.G.height());
            if (ceil > 0 && ceil2 > 0) {
                C(ceil, ceil2);
                if (this.J) {
                    this.f٦٢٢٢x.set(this.H);
                    this.f٦٢٢٢x.preScale(width, height);
                    Matrix matrix = this.f٦٢٢٢x;
                    RectF rectF2 = this.G;
                    matrix.postTranslate(-rectF2.left, -rectF2.top);
                    this.f٦٢٢٣y.eraseColor(0);
                    cVar.h(this.f٦٢٢٤z, this.f٦٢٢٢x, this.f٦٢١٥q);
                    this.H.invert(this.I);
                    this.I.mapRect(this.F, this.G);
                    x(this.F, this.E);
                }
                this.D.set(0, 0, ceil, ceil2);
                canvas.drawBitmap(this.f٦٢٢٣y, this.D, this.E, this.C);
            }
        }
    }

    public boolean A() {
        return this.f٦٢١١m;
    }

    public void A0() {
        float S2;
        if (this.f٦٢١٤p == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.a0
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar) {
                    j0.this.l0(jVar);
                }
            });
            return;
        }
        v();
        if (r() || X() == 0) {
            if (isVisible()) {
                this.f٦٢٠٠b.v();
                this.f٦٢٠٤f = b.NONE;
            } else {
                this.f٦٢٠٤f = b.RESUME;
            }
        }
        if (!r()) {
            if (Z() < DownloadProgress.UNKNOWN_PROGRESS) {
                S2 = T();
            } else {
                S2 = S();
            }
            K0((int) S2);
            this.f٦٢٠٠b.i();
            if (!isVisible()) {
                this.f٦٢٠٤f = b.NONE;
            }
        }
    }

    public void B() {
        this.f٦٢٠٥g.clear();
        this.f٦٢٠٠b.i();
        if (!isVisible()) {
            this.f٦٢٠٤f = b.NONE;
        }
    }

    public void C0(boolean z10) {
        this.f٦٢١٨t = z10;
    }

    public void D0(com.airbnb.lottie.a aVar) {
        this.K = aVar;
    }

    public com.airbnb.lottie.a E() {
        com.airbnb.lottie.a aVar = this.K;
        if (aVar != null) {
            return aVar;
        }
        return e.d();
    }

    public void E0(boolean z10) {
        if (z10 != this.f٦٢١٩u) {
            this.f٦٢١٩u = z10;
            invalidateSelf();
        }
    }

    public boolean F() {
        if (E() == com.airbnb.lottie.a.ENABLED) {
            return true;
        }
        return false;
    }

    public void F0(boolean z10) {
        if (z10 != this.f٦٢١٣o) {
            this.f٦٢١٣o = z10;
            t3.c cVar = this.f٦٢١٤p;
            if (cVar != null) {
                cVar.Q(z10);
            }
            invalidateSelf();
        }
    }

    public Bitmap G(String str) {
        p3.b N = N();
        if (N != null) {
            return N.a(str);
        }
        return null;
    }

    public boolean G0(j jVar) {
        if (this.f٦١٩٩a == jVar) {
            return false;
        }
        this.J = true;
        u();
        this.f٦١٩٩a = jVar;
        s();
        this.f٦٢٠٠b.x(jVar);
        Z0(this.f٦٢٠٠b.getAnimatedFraction());
        Iterator it = new ArrayList(this.f٦٢٠٥g).iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.a(jVar);
            }
            it.remove();
        }
        this.f٦٢٠٥g.clear();
        jVar.v(this.f٦٢١٦r);
        v();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public boolean H() {
        return this.f٦٢١٩u;
    }

    public void H0(String str) {
        this.f٦٢١٠l = str;
        p3.a L = L();
        if (L != null) {
            L.c(str);
        }
    }

    public boolean I() {
        return this.f٦٢١٣o;
    }

    public void I0(com.airbnb.lottie.b bVar) {
        p3.a aVar = this.f٦٢٠٨j;
        if (aVar != null) {
            aVar.d(bVar);
        }
    }

    public j J() {
        return this.f٦١٩٩a;
    }

    public void J0(Map map) {
        if (map == this.f٦٢٠٩k) {
            return;
        }
        this.f٦٢٠٩k = map;
        invalidateSelf();
    }

    public void K0(final int i10) {
        if (this.f٦١٩٩a == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.i0
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar) {
                    j0.this.m0(i10, jVar);
                }
            });
        } else {
            this.f٦٢٠٠b.y(i10);
        }
    }

    public void L0(boolean z10) {
        this.f٦٢٠٢d = z10;
    }

    public int M() {
        return (int) this.f٦٢٠٠b.k();
    }

    public void M0(c cVar) {
        p3.b bVar = this.f٦٢٠٦h;
        if (bVar != null) {
            bVar.d(cVar);
        }
    }

    public void N0(String str) {
        this.f٦٢٠٧i = str;
    }

    public String O() {
        return this.f٦٢٠٧i;
    }

    public void O0(boolean z10) {
        this.f٦٢١٢n = z10;
    }

    public k0 P(String str) {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            return null;
        }
        return (k0) jVar.j().get(str);
    }

    public void P0(final int i10) {
        if (this.f٦١٩٩a == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.u
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar) {
                    j0.this.o0(i10, jVar);
                }
            });
        } else {
            this.f٦٢٠٠b.z(i10 + 0.99f);
        }
    }

    public boolean Q() {
        return this.f٦٢١٢n;
    }

    public void Q0(final String str) {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.b0
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar2) {
                    j0.this.n0(str, jVar2);
                }
            });
            return;
        }
        q3.h l10 = jVar.l(str);
        if (l10 != null) {
            P0((int) (l10.f١٧١٢١b + l10.f١٧١٢٢c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    public void R0(final float f10) {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.x
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar2) {
                    j0.this.p0(f10, jVar2);
                }
            });
        } else {
            this.f٦٢٠٠b.z(x3.k.i(jVar.p(), this.f٦١٩٩a.f(), f10));
        }
    }

    public float S() {
        return this.f٦٢٠٠b.m();
    }

    public void S0(final int i10, final int i11) {
        if (this.f٦١٩٩a == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.y
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar) {
                    j0.this.r0(i10, i11, jVar);
                }
            });
        } else {
            this.f٦٢٠٠b.A(i10, i11 + 0.99f);
        }
    }

    public float T() {
        return this.f٦٢٠٠b.n();
    }

    public void T0(final String str) {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.t
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar2) {
                    j0.this.q0(str, jVar2);
                }
            });
            return;
        }
        q3.h l10 = jVar.l(str);
        if (l10 != null) {
            int i10 = (int) l10.f١٧١٢١b;
            S0(i10, ((int) l10.f١٧١٢٢c) + i10);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
        }
    }

    public r0 U() {
        j jVar = this.f٦١٩٩a;
        if (jVar != null) {
            return jVar.n();
        }
        return null;
    }

    public void U0(final int i10) {
        if (this.f٦١٩٩a == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.v
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar) {
                    j0.this.s0(i10, jVar);
                }
            });
        } else {
            this.f٦٢٠٠b.B(i10);
        }
    }

    public float V() {
        return this.f٦٢٠٠b.j();
    }

    public void V0(final String str) {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.c0
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar2) {
                    j0.this.t0(str, jVar2);
                }
            });
            return;
        }
        q3.h l10 = jVar.l(str);
        if (l10 != null) {
            U0((int) l10.f١٧١٢١b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    public s0 W() {
        if (this.f٦٢٢١w) {
            return s0.SOFTWARE;
        }
        return s0.HARDWARE;
    }

    public void W0(final float f10) {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.g0
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar2) {
                    j0.this.u0(f10, jVar2);
                }
            });
        } else {
            U0((int) x3.k.i(jVar.p(), this.f٦١٩٩a.f(), f10));
        }
    }

    public int X() {
        return this.f٦٢٠٠b.getRepeatCount();
    }

    public void X0(boolean z10) {
        if (this.f٦٢١٧s == z10) {
            return;
        }
        this.f٦٢١٧s = z10;
        t3.c cVar = this.f٦٢١٤p;
        if (cVar != null) {
            cVar.K(z10);
        }
    }

    public int Y() {
        return this.f٦٢٠٠b.getRepeatMode();
    }

    public void Y0(boolean z10) {
        this.f٦٢١٦r = z10;
        j jVar = this.f٦١٩٩a;
        if (jVar != null) {
            jVar.v(z10);
        }
    }

    public float Z() {
        return this.f٦٢٠٠b.o();
    }

    public void Z0(final float f10) {
        if (this.f٦١٩٩a == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.h0
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar) {
                    j0.this.v0(f10, jVar);
                }
            });
            return;
        }
        e.b("Drawable#setProgress");
        this.f٦٢٠٠b.y(this.f٦١٩٩a.h(f10));
        e.c("Drawable#setProgress");
    }

    public u0 a0() {
        return null;
    }

    public void a1(s0 s0Var) {
        this.f٦٢٢٠v = s0Var;
        v();
    }

    public Typeface b0(q3.c cVar) {
        Map map = this.f٦٢٠٩k;
        if (map != null) {
            String a10 = cVar.a();
            if (map.containsKey(a10)) {
                return (Typeface) map.get(a10);
            }
            String b10 = cVar.b();
            if (map.containsKey(b10)) {
                return (Typeface) map.get(b10);
            }
            String str = cVar.a() + "-" + cVar.c();
            if (map.containsKey(str)) {
                return (Typeface) map.get(str);
            }
        }
        p3.a L = L();
        if (L != null) {
            return L.b(cVar);
        }
        return null;
    }

    public void b1(int i10) {
        this.f٦٢٠٠b.setRepeatCount(i10);
    }

    public void c1(int i10) {
        this.f٦٢٠٠b.setRepeatMode(i10);
    }

    public boolean d0() {
        x3.i iVar = this.f٦٢٠٠b;
        if (iVar == null) {
            return false;
        }
        return iVar.isRunning();
    }

    public void d1(boolean z10) {
        this.f٦٢٠٣e = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        t3.c cVar = this.f٦٢١٤p;
        if (cVar == null) {
            return;
        }
        boolean F = F();
        if (F) {
            try {
                this.M.acquire();
            } catch (InterruptedException unused) {
                e.c("Drawable#draw");
                if (F) {
                    this.M.release();
                    if (cVar.P() == this.f٦٢٠٠b.j()) {
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                e.c("Drawable#draw");
                if (F) {
                    this.M.release();
                    if (cVar.P() != this.f٦٢٠٠b.j()) {
                        T.execute(this.P);
                    }
                }
                throw th;
            }
        }
        e.b("Drawable#draw");
        if (F && i1()) {
            Z0(this.f٦٢٠٠b.j());
        }
        if (this.f٦٢٠٣e) {
            try {
                if (this.f٦٢٢١w) {
                    y0(canvas, cVar);
                } else {
                    y(canvas);
                }
            } catch (Throwable th2) {
                x3.f.b("Lottie crashed in draw!", th2);
            }
        } else if (this.f٦٢٢١w) {
            y0(canvas, cVar);
        } else {
            y(canvas);
        }
        this.J = false;
        e.c("Drawable#draw");
        if (F) {
            this.M.release();
            if (cVar.P() == this.f٦٢٠٠b.j()) {
                return;
            }
            T.execute(this.P);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e0() {
        if (isVisible()) {
            return this.f٦٢٠٠b.isRunning();
        }
        b bVar = this.f٦٢٠٤f;
        if (bVar != b.PLAY && bVar != b.RESUME) {
            return false;
        }
        return true;
    }

    public void e1(float f10) {
        this.f٦٢٠٠b.C(f10);
    }

    public boolean f0() {
        return this.f٦٢١٨t;
    }

    public void f1(Boolean bool) {
        this.f٦٢٠١c = bool.booleanValue();
    }

    public void g1(u0 u0Var) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f٦٢١٥q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            return -1;
        }
        return jVar.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        j jVar = this.f٦١٩٩a;
        if (jVar == null) {
            return -1;
        }
        return jVar.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h1(boolean z10) {
        this.f٦٢٠٠b.D(z10);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable.Callback callback;
        if (this.J) {
            return;
        }
        this.J = true;
        if ((!R || Looper.getMainLooper() == Looper.myLooper()) && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return d0();
    }

    public boolean j1() {
        if (this.f٦٢٠٩k == null && this.f٦١٩٩a.c().size() > 0) {
            return true;
        }
        return false;
    }

    public void q(final q3.e eVar, final Object obj, final y3.c cVar) {
        t3.c cVar2 = this.f٦٢١٤p;
        if (cVar2 == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.w
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar) {
                    j0.this.g0(eVar, obj, cVar, jVar);
                }
            });
            return;
        }
        boolean z10 = true;
        if (eVar == q3.e.f١٧١١٥c) {
            cVar2.c(obj, cVar);
        } else if (eVar.d() != null) {
            eVar.d().c(obj, cVar);
        } else {
            List z02 = z0(eVar);
            for (int i10 = 0; i10 < z02.size(); i10++) {
                ((q3.e) z02.get(i10)).d().c(obj, cVar);
            }
            z10 = true ^ z02.isEmpty();
        }
        if (z10) {
            invalidateSelf();
            if (obj == n0.E) {
                Z0(V());
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f٦٢١٥q = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        x3.f.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z10, z11);
        if (z10) {
            b bVar = this.f٦٢٠٤f;
            if (bVar == b.PLAY) {
                x0();
            } else if (bVar == b.RESUME) {
                A0();
            }
        } else if (this.f٦٢٠٠b.isRunning()) {
            w0();
            this.f٦٢٠٤f = b.RESUME;
        } else if (isVisible) {
            this.f٦٢٠٤f = b.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        x0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        B();
    }

    public void t() {
        this.f٦٢٠٥g.clear();
        this.f٦٢٠٠b.cancel();
        if (!isVisible()) {
            this.f٦٢٠٤f = b.NONE;
        }
    }

    public void u() {
        if (this.f٦٢٠٠b.isRunning()) {
            this.f٦٢٠٠b.cancel();
            if (!isVisible()) {
                this.f٦٢٠٤f = b.NONE;
            }
        }
        this.f٦١٩٩a = null;
        this.f٦٢١٤p = null;
        this.f٦٢٠٦h = null;
        this.Q = -3.4028235E38f;
        this.f٦٢٠٠b.h();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void w0() {
        this.f٦٢٠٥g.clear();
        this.f٦٢٠٠b.q();
        if (!isVisible()) {
            this.f٦٢٠٤f = b.NONE;
        }
    }

    public void x0() {
        float S2;
        if (this.f٦٢١٤p == null) {
            this.f٦٢٠٥g.add(new a() { // from class: com.airbnb.lottie.f0
                @Override // com.airbnb.lottie.j0.a
                public final void a(j jVar) {
                    j0.this.k0(jVar);
                }
            });
            return;
        }
        v();
        if (r() || X() == 0) {
            if (isVisible()) {
                this.f٦٢٠٠b.r();
                this.f٦٢٠٤f = b.NONE;
            } else {
                this.f٦٢٠٤f = b.PLAY;
            }
        }
        if (!r()) {
            q3.h R2 = R();
            if (R2 != null) {
                K0((int) R2.f١٧١٢١b);
            } else {
                if (Z() < DownloadProgress.UNKNOWN_PROGRESS) {
                    S2 = T();
                } else {
                    S2 = S();
                }
                K0((int) S2);
            }
            this.f٦٢٠٠b.i();
            if (!isVisible()) {
                this.f٦٢٠٤f = b.NONE;
            }
        }
    }

    public void z(boolean z10) {
        if (this.f٦٢١١m == z10) {
            return;
        }
        this.f٦٢١١m = z10;
        if (this.f٦١٩٩a != null) {
            s();
        }
    }

    public List z0(q3.e eVar) {
        if (this.f٦٢١٤p == null) {
            x3.f.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f٦٢١٤p.d(eVar, 0, arrayList, new q3.e(new String[0]));
        return arrayList;
    }
}
