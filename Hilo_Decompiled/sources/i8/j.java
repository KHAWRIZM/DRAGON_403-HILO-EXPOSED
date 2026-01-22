package i8;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import f8.r;
import s7.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class j extends Transition {
    private static final d C;
    private static final d E;

    /* renamed from: z, reason: collision with root package name */
    private static final String f١٤٧٠٧z = "j";

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٤٧٠٨a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٤٧٠٩b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٤٧١٠c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f١٤٧١١d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f١٤٧١٢e = R.id.content;

    /* renamed from: f, reason: collision with root package name */
    private int f١٤٧١٣f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f١٤٧١٤g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f١٤٧١٥h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f١٤٧١٦i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f١٤٧١٧j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f١٤٧١٨k = 1375731712;

    /* renamed from: l, reason: collision with root package name */
    private int f١٤٧١٩l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f١٤٧٢٠m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f١٤٧٢١n = 0;

    /* renamed from: o, reason: collision with root package name */
    private View f١٤٧٢٢o;

    /* renamed from: p, reason: collision with root package name */
    private View f١٤٧٢٣p;

    /* renamed from: q, reason: collision with root package name */
    private o f١٤٧٢٤q;

    /* renamed from: r, reason: collision with root package name */
    private o f١٤٧٢٥r;

    /* renamed from: s, reason: collision with root package name */
    private c f١٤٧٢٦s;

    /* renamed from: t, reason: collision with root package name */
    private c f١٤٧٢٧t;

    /* renamed from: u, reason: collision with root package name */
    private c f١٤٧٢٨u;

    /* renamed from: v, reason: collision with root package name */
    private c f١٤٧٢٩v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f١٤٧٣٠w;

    /* renamed from: x, reason: collision with root package name */
    private float f١٤٧٣١x;

    /* renamed from: y, reason: collision with root package name */
    private float f١٤٧٣٢y;
    private static final String[] A = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};

    /* renamed from: B, reason: collision with root package name */
    private static final d f١٤٧٠٦B = new d(new c(DownloadProgress.UNKNOWN_PROGRESS, 0.25f), new c(DownloadProgress.UNKNOWN_PROGRESS, 1.0f), new c(DownloadProgress.UNKNOWN_PROGRESS, 1.0f), new c(DownloadProgress.UNKNOWN_PROGRESS, 0.75f), null);
    private static final d D = new d(new c(0.1f, 0.4f), new c(0.1f, 1.0f), new c(0.1f, 1.0f), new c(0.1f, 0.9f), null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f١٤٧٣٣a;

        a(e eVar) {
            this.f١٤٧٣٣a = eVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f١٤٧٣٣a.o(valueAnimator.getAnimatedFraction());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f١٤٧٣٥a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f١٤٧٣٦b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f١٤٧٣٧c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f١٤٧٣٨d;

        b(View view, e eVar, View view2, View view3) {
            this.f١٤٧٣٥a = view;
            this.f١٤٧٣٦b = eVar;
            this.f١٤٧٣٧c = view2;
            this.f١٤٧٣٨d = view3;
        }

        @Override // i8.l, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            j.this.removeListener(this);
            if (j.this.f١٤٧٠٩b) {
                return;
            }
            this.f١٤٧٣٧c.setAlpha(1.0f);
            this.f١٤٧٣٨d.setAlpha(1.0f);
            this.f١٤٧٣٥a.getOverlay().remove(this.f١٤٧٣٦b);
        }

        @Override // i8.l, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            this.f١٤٧٣٥a.getOverlay().add(this.f١٤٧٣٦b);
            this.f١٤٧٣٧c.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٤٧٣٨d.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final float f١٤٧٤٠a;

        /* renamed from: b, reason: collision with root package name */
        private final float f١٤٧٤١b;

        public c(float f10, float f11) {
            this.f١٤٧٤٠a = f10;
            this.f١٤٧٤١b = f11;
        }

        public float c() {
            return this.f١٤٧٤١b;
        }

        public float d() {
            return this.f١٤٧٤٠a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final c f١٤٧٤٢a;

        /* renamed from: b, reason: collision with root package name */
        private final c f١٤٧٤٣b;

        /* renamed from: c, reason: collision with root package name */
        private final c f١٤٧٤٤c;

        /* renamed from: d, reason: collision with root package name */
        private final c f١٤٧٤٥d;

        /* synthetic */ d(c cVar, c cVar2, c cVar3, c cVar4, a aVar) {
            this(cVar, cVar2, cVar3, cVar4);
        }

        private d(c cVar, c cVar2, c cVar3, c cVar4) {
            this.f١٤٧٤٢a = cVar;
            this.f١٤٧٤٣b = cVar2;
            this.f١٤٧٤٤c = cVar3;
            this.f١٤٧٤٥d = cVar4;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class e extends Drawable {
        private final d A;

        /* renamed from: B, reason: collision with root package name */
        private final i8.a f١٤٧٤٦B;
        private final i8.d C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private i8.c G;
        private f H;
        private RectF I;
        private float J;
        private float K;
        private float L;

        /* renamed from: a, reason: collision with root package name */
        private final View f١٤٧٤٧a;

        /* renamed from: b, reason: collision with root package name */
        private final RectF f١٤٧٤٨b;

        /* renamed from: c, reason: collision with root package name */
        private final o f١٤٧٤٩c;

        /* renamed from: d, reason: collision with root package name */
        private final float f١٤٧٥٠d;

        /* renamed from: e, reason: collision with root package name */
        private final View f١٤٧٥١e;

        /* renamed from: f, reason: collision with root package name */
        private final RectF f١٤٧٥٢f;

        /* renamed from: g, reason: collision with root package name */
        private final o f١٤٧٥٣g;

        /* renamed from: h, reason: collision with root package name */
        private final float f١٤٧٥٤h;

        /* renamed from: i, reason: collision with root package name */
        private final Paint f١٤٧٥٥i;

        /* renamed from: j, reason: collision with root package name */
        private final Paint f١٤٧٥٦j;

        /* renamed from: k, reason: collision with root package name */
        private final Paint f١٤٧٥٧k;

        /* renamed from: l, reason: collision with root package name */
        private final Paint f١٤٧٥٨l;

        /* renamed from: m, reason: collision with root package name */
        private final Paint f١٤٧٥٩m;

        /* renamed from: n, reason: collision with root package name */
        private final h f١٤٧٦٠n;

        /* renamed from: o, reason: collision with root package name */
        private final PathMeasure f١٤٧٦١o;

        /* renamed from: p, reason: collision with root package name */
        private final float f١٤٧٦٢p;

        /* renamed from: q, reason: collision with root package name */
        private final float[] f١٤٧٦٣q;

        /* renamed from: r, reason: collision with root package name */
        private final boolean f١٤٧٦٤r;

        /* renamed from: s, reason: collision with root package name */
        private final float f١٤٧٦٥s;

        /* renamed from: t, reason: collision with root package name */
        private final float f١٤٧٦٦t;

        /* renamed from: u, reason: collision with root package name */
        private final boolean f١٤٧٦٧u;

        /* renamed from: v, reason: collision with root package name */
        private final f8.i f١٤٧٦٨v;

        /* renamed from: w, reason: collision with root package name */
        private final RectF f١٤٧٦٩w;

        /* renamed from: x, reason: collision with root package name */
        private final RectF f١٤٧٧٠x;

        /* renamed from: y, reason: collision with root package name */
        private final RectF f١٤٧٧١y;

        /* renamed from: z, reason: collision with root package name */
        private final RectF f١٤٧٧٢z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class a implements a.InterfaceC٠٢٢٨a {
            a() {
            }

            @Override // s7.a.InterfaceC٠٢٢٨a
            public void a(Canvas canvas) {
                e.this.f١٤٧٤٧a.draw(canvas);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class b implements a.InterfaceC٠٢٢٨a {
            b() {
            }

            @Override // s7.a.InterfaceC٠٢٢٨a
            public void a(Canvas canvas) {
                e.this.f١٤٧٥١e.draw(canvas);
            }
        }

        /* synthetic */ e(PathMotion pathMotion, View view, RectF rectF, o oVar, float f10, View view2, RectF rectF2, o oVar2, float f11, int i10, int i11, int i12, int i13, boolean z10, boolean z11, i8.a aVar, i8.d dVar, d dVar2, boolean z12, a aVar2) {
            this(pathMotion, view, rectF, oVar, f10, view2, rectF2, oVar2, f11, i10, i11, i12, i13, z10, z11, aVar, dVar, dVar2, z12);
        }

        private static float d(RectF rectF, float f10) {
            return ((rectF.centerX() / (f10 / 2.0f)) - 1.0f) * 0.3f;
        }

        private static float e(RectF rectF, float f10) {
            return (rectF.centerY() / f10) * 1.5f;
        }

        private void f(Canvas canvas, RectF rectF, Path path, int i10) {
            PointF m10 = m(rectF);
            if (this.L == DownloadProgress.UNKNOWN_PROGRESS) {
                path.reset();
                path.moveTo(m10.x, m10.y);
            } else {
                path.lineTo(m10.x, m10.y);
                this.E.setColor(i10);
                canvas.drawPath(path, this.E);
            }
        }

        private void g(Canvas canvas, RectF rectF, int i10) {
            this.E.setColor(i10);
            canvas.drawRect(rectF, this.E);
        }

        private void h(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.f١٤٧٦٠n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            f8.i iVar = this.f١٤٧٦٨v;
            RectF rectF = this.I;
            iVar.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f١٤٧٦٨v.g0(this.J);
            this.f١٤٧٦٨v.p0((int) this.K);
            this.f١٤٧٦٨v.setShapeAppearanceModel(this.f١٤٧٦٠n.c());
            this.f١٤٧٦٨v.draw(canvas);
        }

        private void j(Canvas canvas) {
            o c10 = this.f١٤٧٦٠n.c();
            if (c10.v(this.I)) {
                float a10 = c10.r().a(this.I);
                canvas.drawRoundRect(this.I, a10, a10, this.f١٤٧٥٨l);
            } else {
                canvas.drawPath(this.f١٤٧٦٠n.d(), this.f١٤٧٥٨l);
            }
        }

        private void k(Canvas canvas) {
            n(canvas, this.f١٤٧٥٧k);
            Rect bounds = getBounds();
            RectF rectF = this.f١٤٧٧١y;
            n.w(canvas, bounds, rectF.left, rectF.top, this.H.f١٤٦٩٦b, this.G.f١٤٦٩١b, new b());
        }

        private void l(Canvas canvas) {
            n(canvas, this.f١٤٧٥٦j);
            Rect bounds = getBounds();
            RectF rectF = this.f١٤٧٦٩w;
            n.w(canvas, bounds, rectF.left, rectF.top, this.H.f١٤٦٩٥a, this.G.f١٤٦٩٠a, new a());
        }

        private static PointF m(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private void n(Canvas canvas, Paint paint) {
            if (paint.getColor() != 0 && paint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), paint);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(float f10) {
            if (this.L != f10) {
                p(f10);
            }
        }

        private void p(float f10) {
            float m10;
            float f11;
            float f12;
            RectF rectF;
            this.L = f10;
            Paint paint = this.f١٤٧٥٩m;
            if (this.f١٤٧٦٤r) {
                m10 = n.m(DownloadProgress.UNKNOWN_PROGRESS, 255.0f, f10);
            } else {
                m10 = n.m(255.0f, DownloadProgress.UNKNOWN_PROGRESS, f10);
            }
            paint.setAlpha((int) m10);
            this.f١٤٧٦١o.getPosTan(this.f١٤٧٦٢p * f10, this.f١٤٧٦٣q, null);
            float[] fArr = this.f١٤٧٦٣q;
            float f13 = fArr[0];
            float f14 = fArr[1];
            if (f10 > 1.0f || f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                if (f10 > 1.0f) {
                    f12 = (f10 - 1.0f) / 0.00999999f;
                    f11 = 0.99f;
                } else {
                    f11 = 0.01f;
                    f12 = (f10 / 0.01f) * (-1.0f);
                }
                this.f١٤٧٦١o.getPosTan(this.f١٤٧٦٢p * f11, fArr, null);
                float[] fArr2 = this.f١٤٧٦٣q;
                f13 += (f13 - fArr2[0]) * f12;
                f14 += (f14 - fArr2[1]) * f12;
            }
            float f15 = f13;
            float f16 = f14;
            f c10 = this.C.c(f10, ((Float) androidx.core.util.h.g(Float.valueOf(this.A.f١٤٧٤٣b.f١٤٧٤٠a))).floatValue(), ((Float) androidx.core.util.h.g(Float.valueOf(this.A.f١٤٧٤٣b.f١٤٧٤١b))).floatValue(), this.f١٤٧٤٨b.width(), this.f١٤٧٤٨b.height(), this.f١٤٧٥٢f.width(), this.f١٤٧٥٢f.height());
            this.H = c10;
            RectF rectF2 = this.f١٤٧٦٩w;
            float f17 = c10.f١٤٦٩٧c;
            rectF2.set(f15 - (f17 / 2.0f), f16, (f17 / 2.0f) + f15, c10.f١٤٦٩٨d + f16);
            RectF rectF3 = this.f١٤٧٧١y;
            f fVar = this.H;
            float f18 = fVar.f١٤٦٩٩e;
            rectF3.set(f15 - (f18 / 2.0f), f16, f15 + (f18 / 2.0f), fVar.f١٤٧٠٠f + f16);
            this.f١٤٧٧٠x.set(this.f١٤٧٦٩w);
            this.f١٤٧٧٢z.set(this.f١٤٧٧١y);
            float floatValue = ((Float) androidx.core.util.h.g(Float.valueOf(this.A.f١٤٧٤٤c.f١٤٧٤٠a))).floatValue();
            float floatValue2 = ((Float) androidx.core.util.h.g(Float.valueOf(this.A.f١٤٧٤٤c.f١٤٧٤١b))).floatValue();
            boolean b10 = this.C.b(this.H);
            if (b10) {
                rectF = this.f١٤٧٧٠x;
            } else {
                rectF = this.f١٤٧٧٢z;
            }
            float n10 = n.n(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, floatValue, floatValue2, f10);
            if (!b10) {
                n10 = 1.0f - n10;
            }
            this.C.a(rectF, n10, this.H);
            this.I = new RectF(Math.min(this.f١٤٧٧٠x.left, this.f١٤٧٧٢z.left), Math.min(this.f١٤٧٧٠x.top, this.f١٤٧٧٢z.top), Math.max(this.f١٤٧٧٠x.right, this.f١٤٧٧٢z.right), Math.max(this.f١٤٧٧٠x.bottom, this.f١٤٧٧٢z.bottom));
            this.f١٤٧٦٠n.b(f10, this.f١٤٧٤٩c, this.f١٤٧٥٣g, this.f١٤٧٦٩w, this.f١٤٧٧٠x, this.f١٤٧٧٢z, this.A.f١٤٧٤٥d);
            this.J = n.m(this.f١٤٧٥٠d, this.f١٤٧٥٤h, f10);
            float d10 = d(this.I, this.f١٤٧٦٥s);
            float e10 = e(this.I, this.f١٤٧٦٦t);
            float f19 = this.J;
            float f20 = (int) (e10 * f19);
            this.K = f20;
            this.f١٤٧٥٨l.setShadowLayer(f19, (int) (d10 * f19), f20, 754974720);
            this.G = this.f١٤٧٤٦B.a(f10, ((Float) androidx.core.util.h.g(Float.valueOf(this.A.f١٤٧٤٢a.f١٤٧٤٠a))).floatValue(), ((Float) androidx.core.util.h.g(Float.valueOf(this.A.f١٤٧٤٢a.f١٤٧٤١b))).floatValue(), 0.35f);
            if (this.f١٤٧٥٦j.getColor() != 0) {
                this.f١٤٧٥٦j.setAlpha(this.G.f١٤٦٩٠a);
            }
            if (this.f١٤٧٥٧k.getColor() != 0) {
                this.f١٤٧٥٧k.setAlpha(this.G.f١٤٦٩١b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int i10;
            if (this.f١٤٧٥٩m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f١٤٧٥٩m);
            }
            if (this.D) {
                i10 = canvas.save();
            } else {
                i10 = -1;
            }
            if (this.f١٤٧٦٧u && this.J > DownloadProgress.UNKNOWN_PROGRESS) {
                h(canvas);
            }
            this.f١٤٧٦٠n.a(canvas);
            n(canvas, this.f١٤٧٥٥i);
            if (this.G.f١٤٦٩٢c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(i10);
                f(canvas, this.f١٤٧٦٩w, this.F, -65281);
                g(canvas, this.f١٤٧٧٠x, -256);
                g(canvas, this.f١٤٧٦٩w, -16711936);
                g(canvas, this.f١٤٧٧٢z, -16711681);
                g(canvas, this.f١٤٧٧١y, -16776961);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private e(PathMotion pathMotion, View view, RectF rectF, o oVar, float f10, View view2, RectF rectF2, o oVar2, float f11, int i10, int i11, int i12, int i13, boolean z10, boolean z11, i8.a aVar, i8.d dVar, d dVar2, boolean z12) {
            Paint paint = new Paint();
            this.f١٤٧٥٥i = paint;
            Paint paint2 = new Paint();
            this.f١٤٧٥٦j = paint2;
            Paint paint3 = new Paint();
            this.f١٤٧٥٧k = paint3;
            this.f١٤٧٥٨l = new Paint();
            Paint paint4 = new Paint();
            this.f١٤٧٥٩m = paint4;
            this.f١٤٧٦٠n = new h();
            this.f١٤٧٦٣q = r7;
            f8.i iVar = new f8.i();
            this.f١٤٧٦٨v = iVar;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f١٤٧٤٧a = view;
            this.f١٤٧٤٨b = rectF;
            this.f١٤٧٤٩c = oVar;
            this.f١٤٧٥٠d = f10;
            this.f١٤٧٥١e = view2;
            this.f١٤٧٥٢f = rectF2;
            this.f١٤٧٥٣g = oVar2;
            this.f١٤٧٥٤h = f11;
            this.f١٤٧٦٤r = z10;
            this.f١٤٧٦٧u = z11;
            this.f١٤٧٤٦B = aVar;
            this.C = dVar;
            this.A = dVar2;
            this.D = z12;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            this.f١٤٧٦٥s = r12.widthPixels;
            this.f١٤٧٦٦t = r12.heightPixels;
            paint.setColor(i10);
            paint2.setColor(i11);
            paint3.setColor(i12);
            iVar.h0(ColorStateList.valueOf(0));
            iVar.o0(2);
            iVar.m0(false);
            iVar.n0(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.f١٤٧٦٩w = rectF3;
            this.f١٤٧٧٠x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f١٤٧٧١y = rectF4;
            this.f١٤٧٧٢z = new RectF(rectF4);
            PointF m10 = m(rectF);
            PointF m11 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(m10.x, m10.y, m11.x, m11.y), false);
            this.f١٤٧٦١o = pathMeasure;
            this.f١٤٧٦٢p = pathMeasure.getLength();
            float[] fArr = {rectF.centerX(), rectF.top};
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(n.d(i13));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(DownloadProgress.UNKNOWN_PROGRESS);
        }
    }

    static {
        a aVar = null;
        C = new d(new c(0.6f, 0.9f), new c(DownloadProgress.UNKNOWN_PROGRESS, 1.0f), new c(DownloadProgress.UNKNOWN_PROGRESS, 0.9f), new c(0.3f, 0.9f), aVar);
        E = new d(new c(0.6f, 0.9f), new c(DownloadProgress.UNKNOWN_PROGRESS, 0.9f), new c(DownloadProgress.UNKNOWN_PROGRESS, 0.9f), new c(0.2f, 0.9f), aVar);
    }

    public j() {
        this.f١٤٧٣٠w = Build.VERSION.SDK_INT >= 28;
        this.f١٤٧٣١x = -1.0f;
        this.f١٤٧٣٢y = -1.0f;
    }

    private d b(boolean z10) {
        PathMotion pathMotion = getPathMotion();
        if (!(pathMotion instanceof ArcMotion) && !(pathMotion instanceof i)) {
            return h(z10, f١٤٧٠٦B, C);
        }
        return h(z10, D, E);
    }

    private static RectF c(View view, View view2, float f10, float f11) {
        if (view2 != null) {
            RectF h10 = n.h(view2);
            h10.offset(f10, f11);
            return h10;
        }
        return new RectF(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, view.getWidth(), view.getHeight());
    }

    private static o d(View view, RectF rectF, o oVar) {
        return n.c(g(view, oVar), rectF);
    }

    private static void e(TransitionValues transitionValues, View view, int i10, o oVar) {
        RectF h10;
        if (i10 != -1) {
            transitionValues.view = n.g(transitionValues.view, i10);
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view2 = transitionValues.view;
            int i11 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
            if (view2.getTag(i11) instanceof View) {
                View view3 = (View) transitionValues.view.getTag(i11);
                transitionValues.view.setTag(i11, null);
                transitionValues.view = view3;
            }
        }
        View view4 = transitionValues.view;
        if (view4.isLaidOut() || view4.getWidth() != 0 || view4.getHeight() != 0) {
            if (view4.getParent() == null) {
                h10 = n.i(view4);
            } else {
                h10 = n.h(view4);
            }
            transitionValues.values.put("materialContainerTransition:bounds", h10);
            transitionValues.values.put("materialContainerTransition:shapeAppearance", d(view4, h10, oVar));
        }
    }

    private static float f(float f10, View view) {
        if (f10 == -1.0f) {
            return view.getElevation();
        }
        return f10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static o g(View view, o oVar) {
        if (oVar != null) {
            return oVar;
        }
        int i10 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if (view.getTag(i10) instanceof o) {
            return (o) view.getTag(i10);
        }
        Context context = view.getContext();
        int i11 = i(context);
        if (i11 != -1) {
            return o.b(context, i11, 0).m();
        }
        if (view instanceof r) {
            return ((r) view).getShapeAppearanceModel();
        }
        return o.a().m();
    }

    private d h(boolean z10, d dVar, d dVar2) {
        if (!z10) {
            dVar = dVar2;
        }
        return new d((c) n.e(this.f١٤٧٢٦s, dVar.f١٤٧٤٢a), (c) n.e(this.f١٤٧٢٧t, dVar.f١٤٧٤٣b), (c) n.e(this.f١٤٧٢٨u, dVar.f١٤٧٤٤c), (c) n.e(this.f١٤٧٢٩v, dVar.f١٤٧٤٥d), null);
    }

    private static int i(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean j(RectF rectF, RectF rectF2) {
        int i10 = this.f١٤٧١٩l;
        if (i10 != 0) {
            if (i10 == 1) {
                return true;
            }
            if (i10 == 2) {
                return false;
            }
            throw new IllegalArgumentException("Invalid transition direction: " + this.f١٤٧١٩l);
        }
        if (n.b(rectF2) <= n.b(rectF)) {
            return false;
        }
        return true;
    }

    private void k(Context context, boolean z10) {
        int i10;
        n.s(this, context, com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, p7.a.f١٦٩٤٨b);
        if (z10) {
            i10 = com.google.android.material.R.attr.motionDurationLong2;
        } else {
            i10 = com.google.android.material.R.attr.motionDurationMedium4;
        }
        n.r(this, context, i10);
        if (!this.f١٤٧١٠c) {
            n.t(this, context, com.google.android.material.R.attr.motionPath);
        }
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        e(transitionValues, this.f١٤٧٢٣p, this.f١٤٧١٤g, this.f١٤٧٢٥r);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        e(transitionValues, this.f١٤٧٢٢o, this.f١٤٧١٣f, this.f١٤٧٢٤q);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view;
        View f10;
        View view2;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.values.get("materialContainerTransition:bounds");
            o oVar = (o) transitionValues.values.get("materialContainerTransition:shapeAppearance");
            if (rectF != null && oVar != null) {
                RectF rectF2 = (RectF) transitionValues2.values.get("materialContainerTransition:bounds");
                o oVar2 = (o) transitionValues2.values.get("materialContainerTransition:shapeAppearance");
                if (rectF2 != null && oVar2 != null) {
                    View view3 = transitionValues.view;
                    View view4 = transitionValues2.view;
                    if (view4.getParent() != null) {
                        view = view4;
                    } else {
                        view = view3;
                    }
                    if (this.f١٤٧١٢e == view.getId()) {
                        f10 = (View) view.getParent();
                        view2 = view;
                    } else {
                        f10 = n.f(view, this.f١٤٧١٢e);
                        view2 = null;
                    }
                    RectF h10 = n.h(f10);
                    float f11 = -h10.left;
                    float f12 = -h10.top;
                    RectF c10 = c(f10, view2, f11, f12);
                    rectF.offset(f11, f12);
                    rectF2.offset(f11, f12);
                    boolean j10 = j(rectF, rectF2);
                    if (!this.f١٤٧١١d) {
                        k(view.getContext(), j10);
                    }
                    e eVar = new e(getPathMotion(), view3, rectF, oVar, f(this.f١٤٧٣١x, view3), view4, rectF2, oVar2, f(this.f١٤٧٣٢y, view4), this.f١٤٧١٥h, this.f١٤٧١٦i, this.f١٤٧١٧j, this.f١٤٧١٨k, j10, this.f١٤٧٣٠w, i8.b.a(this.f١٤٧٢٠m, j10), i8.e.a(this.f١٤٧٢١n, j10, rectF, rectF2), b(j10), this.f١٤٧٠٨a, null);
                    eVar.setBounds(Math.round(c10.left), Math.round(c10.top), Math.round(c10.right), Math.round(c10.bottom));
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
                    ofFloat.addUpdateListener(new a(eVar));
                    addListener(new b(f10, eVar, view3, view4));
                    return ofFloat;
                }
                Log.w(f١٤٧٠٧z, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                return null;
            }
            Log.w(f١٤٧٠٧z, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    @Override // android.transition.Transition
    public String[] getTransitionProperties() {
        return A;
    }

    public void l(int i10) {
        this.f١٤٧١٥h = i10;
        this.f١٤٧١٦i = i10;
        this.f١٤٧١٧j = i10;
    }

    public void m(int i10) {
        this.f١٤٧١٥h = i10;
    }

    public void n(int i10) {
        this.f١٤٧١٢e = i10;
    }

    public void o(boolean z10) {
        this.f١٤٧٣٠w = z10;
    }

    public void p(float f10) {
        this.f١٤٧٣٢y = f10;
    }

    public void q(View view) {
        this.f١٤٧٢٣p = view;
    }

    public void r(int i10) {
        this.f١٤٧٢٠m = i10;
    }

    public void s(int i10) {
        this.f١٤٧٢١n = i10;
    }

    @Override // android.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f١٤٧١٠c = true;
    }

    public void t(boolean z10) {
        this.f١٤٧٠٩b = z10;
    }

    public void u(int i10) {
        this.f١٤٧١٨k = i10;
    }

    public void v(float f10) {
        this.f١٤٧٣١x = f10;
    }

    public void w(View view) {
        this.f١٤٧٢٢o = view;
    }

    public void x(int i10) {
        this.f١٤٧١٩l = i10;
    }
}
