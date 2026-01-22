package p6;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class k implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float A = 1.0f;

    /* renamed from: B, reason: collision with root package name */
    private static int f١٦٩٠٥B = 200;

    /* renamed from: y, reason: collision with root package name */
    private static float f١٦٩٠٦y = 3.0f;

    /* renamed from: z, reason: collision with root package name */
    private static float f١٦٩٠٧z = 1.75f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f١٦٩١٥h;

    /* renamed from: i, reason: collision with root package name */
    private GestureDetector f١٦٩١٦i;

    /* renamed from: j, reason: collision with root package name */
    private p6.b f١٦٩١٧j;

    /* renamed from: p, reason: collision with root package name */
    private View.OnClickListener f١٦٩٢٣p;

    /* renamed from: q, reason: collision with root package name */
    private View.OnLongClickListener f١٦٩٢٤q;

    /* renamed from: r, reason: collision with root package name */
    private f f١٦٩٢٥r;

    /* renamed from: u, reason: collision with root package name */
    private float f١٦٩٢٨u;

    /* renamed from: a, reason: collision with root package name */
    private Interpolator f١٦٩٠٨a = new AccelerateDecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    private int f١٦٩٠٩b = f١٦٩٠٥B;

    /* renamed from: c, reason: collision with root package name */
    private float f١٦٩١٠c = A;

    /* renamed from: d, reason: collision with root package name */
    private float f١٦٩١١d = f١٦٩٠٧z;

    /* renamed from: e, reason: collision with root package name */
    private float f١٦٩١٢e = f١٦٩٠٦y;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٦٩١٣f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٦٩١٤g = false;

    /* renamed from: k, reason: collision with root package name */
    private final Matrix f١٦٩١٨k = new Matrix();

    /* renamed from: l, reason: collision with root package name */
    private final Matrix f١٦٩١٩l = new Matrix();

    /* renamed from: m, reason: collision with root package name */
    private final Matrix f١٦٩٢٠m = new Matrix();

    /* renamed from: n, reason: collision with root package name */
    private final RectF f١٦٩٢١n = new RectF();

    /* renamed from: o, reason: collision with root package name */
    private final float[] f١٦٩٢٢o = new float[9];

    /* renamed from: s, reason: collision with root package name */
    private int f١٦٩٢٦s = 2;

    /* renamed from: t, reason: collision with root package name */
    private int f١٦٩٢٧t = 2;

    /* renamed from: v, reason: collision with root package name */
    private boolean f١٦٩٢٩v = true;

    /* renamed from: w, reason: collision with root package name */
    private ImageView.ScaleType f١٦٩٣٠w = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: x, reason: collision with root package name */
    private p6.c f١٦٩٣١x = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements p6.c {
        a() {
        }

        @Override // p6.c
        public void onDrag(float f10, float f11) {
            if (k.this.f١٦٩١٧j.e()) {
                return;
            }
            k.b(k.this);
            k.this.f١٦٩٢٠m.postTranslate(f10, f11);
            k.this.z();
            ViewParent parent = k.this.f١٦٩١٥h.getParent();
            if (k.this.f١٦٩١٣f && !k.this.f١٦٩١٧j.e() && !k.this.f١٦٩١٤g) {
                if ((k.this.f١٦٩٢٦s == 2 || ((k.this.f١٦٩٢٦s == 0 && f10 >= 1.0f) || ((k.this.f١٦٩٢٦s == 1 && f10 <= -1.0f) || ((k.this.f١٦٩٢٧t == 0 && f11 >= 1.0f) || (k.this.f١٦٩٢٧t == 1 && f11 <= -1.0f))))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                    return;
                }
                return;
            }
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // p6.c
        public void onFling(float f10, float f11, float f12, float f13) {
            k kVar = k.this;
            kVar.f١٦٩٢٥r = new f(kVar.f١٦٩١٥h.getContext());
            f fVar = k.this.f١٦٩٢٥r;
            k kVar2 = k.this;
            int G = kVar2.G(kVar2.f١٦٩١٥h);
            k kVar3 = k.this;
            fVar.b(G, kVar3.F(kVar3.f١٦٩١٥h), (int) f12, (int) f13);
            k.this.f١٦٩١٥h.post(k.this.f١٦٩٢٥r);
        }

        @Override // p6.c
        public void onScale(float f10, float f11, float f12) {
            if (k.this.K() < k.this.f١٦٩١٢e || f10 < 1.0f) {
                k.f(k.this);
                k.this.f١٦٩٢٠m.postScale(f10, f10, f11, f12);
                k.this.z();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            k.h(k.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (k.this.f١٦٩٢٤q != null) {
                k.this.f١٦٩٢٤q.onLongClick(k.this.f١٦٩١٥h);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float K = k.this.K();
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                if (K < k.this.I()) {
                    k kVar = k.this;
                    kVar.W(kVar.I(), x10, y10, true);
                } else if (K >= k.this.I() && K < k.this.H()) {
                    k kVar2 = k.this;
                    kVar2.W(kVar2.H(), x10, y10, true);
                } else {
                    k kVar3 = k.this;
                    kVar3.W(kVar3.J(), x10, y10, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (k.this.f١٦٩٢٣p != null) {
                k.this.f١٦٩٢٣p.onClick(k.this.f١٦٩١٥h);
            }
            RectF B2 = k.this.B();
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            k.j(k.this);
            if (B2 != null) {
                if (B2.contains(x10, y10)) {
                    B2.width();
                    B2.height();
                    k.l(k.this);
                    return true;
                }
                k.m(k.this);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٦٩٣٥a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f١٦٩٣٥a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٦٩٣٥a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٦٩٣٥a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٦٩٣٥a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final float f١٦٩٣٦a;

        /* renamed from: b, reason: collision with root package name */
        private final float f١٦٩٣٧b;

        /* renamed from: c, reason: collision with root package name */
        private final long f١٦٩٣٨c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        private final float f١٦٩٣٩d;

        /* renamed from: e, reason: collision with root package name */
        private final float f١٦٩٤٠e;

        public e(float f10, float f11, float f12, float f13) {
            this.f١٦٩٣٦a = f12;
            this.f١٦٩٣٧b = f13;
            this.f١٦٩٣٩d = f10;
            this.f١٦٩٤٠e = f11;
        }

        private float a() {
            return k.this.f١٦٩٠٨a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f١٦٩٣٨c)) * 1.0f) / k.this.f١٦٩٠٩b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float a10 = a();
            float f10 = this.f١٦٩٣٩d;
            k.this.f١٦٩٣١x.onScale((f10 + ((this.f١٦٩٤٠e - f10) * a10)) / k.this.K(), this.f١٦٩٣٦a, this.f١٦٩٣٧b);
            if (a10 < 1.0f) {
                p6.a.a(k.this.f١٦٩١٥h, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final OverScroller f١٦٩٤٢a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٦٩٤٣b;

        /* renamed from: c, reason: collision with root package name */
        private int f١٦٩٤٤c;

        public f(Context context) {
            this.f١٦٩٤٢a = new OverScroller(context);
        }

        public void a() {
            this.f١٦٩٤٢a.forceFinished(true);
        }

        public void b(int i10, int i11, int i12, int i13) {
            int i14;
            int i15;
            int i16;
            int i17;
            RectF B2 = k.this.B();
            if (B2 == null) {
                return;
            }
            int round = Math.round(-B2.left);
            float f10 = i10;
            if (f10 < B2.width()) {
                i15 = Math.round(B2.width() - f10);
                i14 = 0;
            } else {
                i14 = round;
                i15 = i14;
            }
            int round2 = Math.round(-B2.top);
            float f11 = i11;
            if (f11 < B2.height()) {
                i17 = Math.round(B2.height() - f11);
                i16 = 0;
            } else {
                i16 = round2;
                i17 = i16;
            }
            this.f١٦٩٤٣b = round;
            this.f١٦٩٤٤c = round2;
            if (round != i15 || round2 != i17) {
                this.f١٦٩٤٢a.fling(round, round2, i12, i13, i14, i15, i16, i17, 0, 0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f١٦٩٤٢a.isFinished() && this.f١٦٩٤٢a.computeScrollOffset()) {
                int currX = this.f١٦٩٤٢a.getCurrX();
                int currY = this.f١٦٩٤٢a.getCurrY();
                k.this.f١٦٩٢٠m.postTranslate(this.f١٦٩٤٣b - currX, this.f١٦٩٤٤c - currY);
                k.this.z();
                this.f١٦٩٤٣b = currX;
                this.f١٦٩٤٤c = currY;
                p6.a.a(k.this.f١٦٩١٥h, this);
            }
        }
    }

    public k(ImageView imageView) {
        this.f١٦٩١٥h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f١٦٩٢٨u = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٦٩١٧j = new p6.b(imageView.getContext(), this.f١٦٩٣١x);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f١٦٩١٦i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private boolean A() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        RectF C = C(D());
        if (C == null) {
            return false;
        }
        float height = C.height();
        float width = C.width();
        float F = F(this.f١٦٩١٥h);
        float f15 = DownloadProgress.UNKNOWN_PROGRESS;
        if (height <= F) {
            int i10 = d.f١٦٩٣٥a[this.f١٦٩٣٠w.ordinal()];
            if (i10 != 2) {
                if (i10 != 3) {
                    f13 = (F - height) / 2.0f;
                    f14 = C.top;
                } else {
                    f13 = F - height;
                    f14 = C.top;
                }
                f10 = f13 - f14;
            } else {
                f10 = -C.top;
            }
            this.f١٦٩٢٧t = 2;
        } else {
            float f16 = C.top;
            if (f16 > DownloadProgress.UNKNOWN_PROGRESS) {
                this.f١٦٩٢٧t = 0;
                f10 = -f16;
            } else {
                float f17 = C.bottom;
                if (f17 < F) {
                    this.f١٦٩٢٧t = 1;
                    f10 = F - f17;
                } else {
                    this.f١٦٩٢٧t = -1;
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                }
            }
        }
        float G = G(this.f١٦٩١٥h);
        if (width <= G) {
            int i11 = d.f١٦٩٣٥a[this.f١٦٩٣٠w.ordinal()];
            if (i11 != 2) {
                if (i11 != 3) {
                    f11 = (G - width) / 2.0f;
                    f12 = C.left;
                } else {
                    f11 = G - width;
                    f12 = C.left;
                }
                f15 = f11 - f12;
            } else {
                f15 = -C.left;
            }
            this.f١٦٩٢٦s = 2;
        } else {
            float f18 = C.left;
            if (f18 > DownloadProgress.UNKNOWN_PROGRESS) {
                this.f١٦٩٢٦s = 0;
                f15 = -f18;
            } else {
                float f19 = C.right;
                if (f19 < G) {
                    f15 = G - f19;
                    this.f١٦٩٢٦s = 1;
                } else {
                    this.f١٦٩٢٦s = -1;
                }
            }
        }
        this.f١٦٩٢٠m.postTranslate(f15, f10);
        return true;
    }

    private RectF C(Matrix matrix) {
        if (this.f١٦٩١٥h.getDrawable() != null) {
            this.f١٦٩٢١n.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            matrix.mapRect(this.f١٦٩٢١n);
            return this.f١٦٩٢١n;
        }
        return null;
    }

    private Matrix D() {
        this.f١٦٩١٩l.set(this.f١٦٩١٨k);
        this.f١٦٩١٩l.postConcat(this.f١٦٩٢٠m);
        return this.f١٦٩١٩l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float M(Matrix matrix, int i10) {
        matrix.getValues(this.f١٦٩٢٢o);
        return this.f١٦٩٢٢o[i10];
    }

    private void N() {
        this.f١٦٩٢٠m.reset();
        T(this.f١٦٩٢٨u);
        P(D());
        A();
    }

    private void P(Matrix matrix) {
        this.f١٦٩١٥h.setImageMatrix(matrix);
    }

    static /* synthetic */ i b(k kVar) {
        kVar.getClass();
        return null;
    }

    private void c0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float G = G(this.f١٦٩١٥h);
        float F = F(this.f١٦٩١٥h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f١٦٩١٨k.reset();
        float f10 = intrinsicWidth;
        float f11 = G / f10;
        float f12 = intrinsicHeight;
        float f13 = F / f12;
        ImageView.ScaleType scaleType = this.f١٦٩٣٠w;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f١٦٩١٨k.postTranslate((G - f10) / 2.0f, (F - f12) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f11, f13);
            this.f١٦٩١٨k.postScale(max, max);
            this.f١٦٩١٨k.postTranslate((G - (f10 * max)) / 2.0f, (F - (f12 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f11, f13));
            this.f١٦٩١٨k.postScale(min, min);
            this.f١٦٩١٨k.postTranslate((G - (f10 * min)) / 2.0f, (F - (f12 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f10, f12);
            RectF rectF2 = new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, G, F);
            if (((int) this.f١٦٩٢٨u) % 180 != 0) {
                rectF = new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f12, f10);
            }
            int i10 = d.f١٦٩٣٥a[this.f١٦٩٣٠w.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 4) {
                            this.f١٦٩١٨k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.f١٦٩١٨k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                    }
                } else {
                    this.f١٦٩١٨k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                }
            } else {
                this.f١٦٩١٨k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        N();
    }

    static /* synthetic */ g f(k kVar) {
        kVar.getClass();
        return null;
    }

    static /* synthetic */ h h(k kVar) {
        kVar.getClass();
        return null;
    }

    static /* synthetic */ j j(k kVar) {
        kVar.getClass();
        return null;
    }

    static /* synthetic */ p6.f l(k kVar) {
        kVar.getClass();
        return null;
    }

    static /* synthetic */ p6.e m(k kVar) {
        kVar.getClass();
        return null;
    }

    private void y() {
        f fVar = this.f١٦٩٢٥r;
        if (fVar != null) {
            fVar.a();
            this.f١٦٩٢٥r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (A()) {
            P(D());
        }
    }

    public RectF B() {
        A();
        return C(D());
    }

    public Matrix E() {
        return this.f١٦٩١٩l;
    }

    public float H() {
        return this.f١٦٩١٢e;
    }

    public float I() {
        return this.f١٦٩١١d;
    }

    public float J() {
        return this.f١٦٩١٠c;
    }

    public float K() {
        return (float) Math.sqrt(((float) Math.pow(M(this.f١٦٩٢٠m, 0), 2.0d)) + ((float) Math.pow(M(this.f١٦٩٢٠m, 3), 2.0d)));
    }

    public ImageView.ScaleType L() {
        return this.f١٦٩٣٠w;
    }

    public void O(boolean z10) {
        this.f١٦٩١٣f = z10;
    }

    public void Q(float f10) {
        l.a(this.f١٦٩١٠c, this.f١٦٩١١d, f10);
        this.f١٦٩١٢e = f10;
    }

    public void R(float f10) {
        l.a(this.f١٦٩١٠c, f10, this.f١٦٩١٢e);
        this.f١٦٩١١d = f10;
    }

    public void S(float f10) {
        l.a(f10, this.f١٦٩١١d, this.f١٦٩١٢e);
        this.f١٦٩١٠c = f10;
    }

    public void T(float f10) {
        this.f١٦٩٢٠m.postRotate(f10 % 360.0f);
        z();
    }

    public void U(float f10) {
        this.f١٦٩٢٠m.setRotate(f10 % 360.0f);
        z();
    }

    public void V(float f10) {
        X(f10, false);
    }

    public void W(float f10, float f11, float f12, boolean z10) {
        if (f10 >= this.f١٦٩١٠c && f10 <= this.f١٦٩١٢e) {
            if (z10) {
                this.f١٦٩١٥h.post(new e(K(), f10, f11, f12));
                return;
            } else {
                this.f١٦٩٢٠m.setScale(f10, f10, f11, f12);
                z();
                return;
            }
        }
        throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
    }

    public void X(float f10, boolean z10) {
        W(f10, this.f١٦٩١٥h.getRight() / 2, this.f١٦٩١٥h.getBottom() / 2, z10);
    }

    public void Y(ImageView.ScaleType scaleType) {
        if (l.d(scaleType) && scaleType != this.f١٦٩٣٠w) {
            this.f١٦٩٣٠w = scaleType;
            b0();
        }
    }

    public void Z(int i10) {
        this.f١٦٩٠٩b = i10;
    }

    public void a0(boolean z10) {
        this.f١٦٩٢٩v = z10;
        b0();
    }

    public void b0() {
        if (this.f١٦٩٢٩v) {
            c0(this.f١٦٩١٥h.getDrawable());
        } else {
            N();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 != i14 || i11 != i15 || i12 != i16 || i13 != i17) {
            c0(this.f١٦٩١٥h.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        p6.b bVar;
        boolean z11;
        GestureDetector gestureDetector;
        boolean z12;
        boolean z13;
        RectF B2;
        boolean z14 = false;
        if (!this.f١٦٩٢٩v || !l.c((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (K() < this.f١٦٩١٠c) {
                    RectF B3 = B();
                    if (B3 != null) {
                        view.post(new e(K(), this.f١٦٩١٠c, B3.centerX(), B3.centerY()));
                        z10 = true;
                    }
                } else if (K() > this.f١٦٩١٢e && (B2 = B()) != null) {
                    view.post(new e(K(), this.f١٦٩١٢e, B2.centerX(), B2.centerY()));
                    z10 = true;
                }
                bVar = this.f١٦٩١٧j;
                if (bVar == null) {
                    boolean e10 = bVar.e();
                    boolean d10 = this.f١٦٩١٧j.d();
                    boolean f10 = this.f١٦٩١٧j.f(motionEvent);
                    if (!e10 && !this.f١٦٩١٧j.e()) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!d10 && !this.f١٦٩١٧j.d()) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z12 && z13) {
                        z14 = true;
                    }
                    this.f١٦٩١٤g = z14;
                    z11 = f10;
                } else {
                    z11 = z10;
                }
                gestureDetector = this.f١٦٩١٦i;
                if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
        } else {
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            y();
        }
        z10 = false;
        bVar = this.f١٦٩١٧j;
        if (bVar == null) {
        }
        gestureDetector = this.f١٦٩١٦i;
        return gestureDetector == null ? z11 : z11;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f١٦٩٢٣p = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f١٦٩١٦i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f١٦٩٢٤q = onLongClickListener;
    }

    public void setOnMatrixChangeListener(p6.d dVar) {
    }

    public void setOnOutsidePhotoTapListener(p6.e eVar) {
    }

    public void setOnPhotoTapListener(p6.f fVar) {
    }

    public void setOnScaleChangeListener(g gVar) {
    }

    public void setOnSingleFlingListener(h hVar) {
    }

    public void setOnViewDragListener(i iVar) {
    }

    public void setOnViewTapListener(j jVar) {
    }
}
