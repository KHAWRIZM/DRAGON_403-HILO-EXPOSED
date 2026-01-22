package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a0;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.core.view.g0;
import c2.e;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MotionLayout extends ConstraintLayout implements g0 {
    public static boolean E0;
    private e2.b A;
    private RectF A0;

    /* renamed from: B, reason: collision with root package name */
    private e f١٨٣٩B;
    private View B0;
    private androidx.constraintlayout.motion.widget.b C;
    private Matrix C0;
    boolean D;
    ArrayList D0;
    int E;
    int F;
    int G;
    int H;
    boolean I;
    float J;
    float K;
    long L;
    float M;
    private boolean N;
    private ArrayList O;
    private ArrayList P;
    private ArrayList Q;
    private CopyOnWriteArrayList R;
    private int S;
    private long T;
    private float U;
    private int V;
    private float W;

    /* renamed from: a, reason: collision with root package name */
    p f١٨٤٠a;

    /* renamed from: a0, reason: collision with root package name */
    boolean f١٨٤١a0;

    /* renamed from: b, reason: collision with root package name */
    Interpolator f١٨٤٢b;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f١٨٤٣b0;

    /* renamed from: c, reason: collision with root package name */
    Interpolator f١٨٤٤c;

    /* renamed from: c0, reason: collision with root package name */
    int f١٨٤٥c0;

    /* renamed from: d, reason: collision with root package name */
    float f١٨٤٦d;

    /* renamed from: d0, reason: collision with root package name */
    int f١٨٤٧d0;

    /* renamed from: e, reason: collision with root package name */
    private int f١٨٤٨e;

    /* renamed from: e0, reason: collision with root package name */
    int f١٨٤٩e0;

    /* renamed from: f, reason: collision with root package name */
    int f١٨٥٠f;

    /* renamed from: f0, reason: collision with root package name */
    int f١٨٥١f0;

    /* renamed from: g, reason: collision with root package name */
    private int f١٨٥٢g;

    /* renamed from: g0, reason: collision with root package name */
    int f١٨٥٣g0;

    /* renamed from: h, reason: collision with root package name */
    private int f١٨٥٤h;

    /* renamed from: h0, reason: collision with root package name */
    int f١٨٥٥h0;

    /* renamed from: i, reason: collision with root package name */
    private int f١٨٥٦i;

    /* renamed from: i0, reason: collision with root package name */
    float f١٨٥٧i0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f١٨٥٨j;

    /* renamed from: j0, reason: collision with root package name */
    private a2.d f١٨٥٩j0;

    /* renamed from: k, reason: collision with root package name */
    HashMap f١٨٦٠k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f١٨٦١k0;

    /* renamed from: l, reason: collision with root package name */
    private long f١٨٦٢l;

    /* renamed from: l0, reason: collision with root package name */
    private j f١٨٦٣l0;

    /* renamed from: m, reason: collision with root package name */
    private float f١٨٦٤m;

    /* renamed from: m0, reason: collision with root package name */
    private Runnable f١٨٦٥m0;

    /* renamed from: n, reason: collision with root package name */
    float f١٨٦٦n;

    /* renamed from: n0, reason: collision with root package name */
    private int[] f١٨٦٧n0;

    /* renamed from: o, reason: collision with root package name */
    float f١٨٦٨o;

    /* renamed from: o0, reason: collision with root package name */
    int f١٨٦٩o0;

    /* renamed from: p, reason: collision with root package name */
    private long f١٨٧٠p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f١٨٧١p0;

    /* renamed from: q, reason: collision with root package name */
    float f١٨٧٢q;

    /* renamed from: q0, reason: collision with root package name */
    int f١٨٧٣q0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f١٨٧٤r;

    /* renamed from: r0, reason: collision with root package name */
    HashMap f١٨٧٥r0;

    /* renamed from: s, reason: collision with root package name */
    boolean f١٨٧٦s;

    /* renamed from: s0, reason: collision with root package name */
    private int f١٨٧٧s0;

    /* renamed from: t, reason: collision with root package name */
    boolean f١٨٧٨t;

    /* renamed from: t0, reason: collision with root package name */
    private int f١٨٧٩t0;

    /* renamed from: u, reason: collision with root package name */
    private k f١٨٨٠u;

    /* renamed from: u0, reason: collision with root package name */
    private int f١٨٨١u0;

    /* renamed from: v, reason: collision with root package name */
    private float f١٨٨٢v;

    /* renamed from: v0, reason: collision with root package name */
    Rect f١٨٨٣v0;

    /* renamed from: w, reason: collision with root package name */
    private float f١٨٨٤w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f١٨٨٥w0;

    /* renamed from: x, reason: collision with root package name */
    int f١٨٨٦x;

    /* renamed from: x0, reason: collision with root package name */
    l f١٨٨٧x0;

    /* renamed from: y, reason: collision with root package name */
    f f١٨٨٨y;

    /* renamed from: y0, reason: collision with root package name */
    g f١٨٨٩y0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f١٨٩٠z;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f١٨٩١z0;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.f١٨٦٣l0.a();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f١٨٩٣a;

        b(MotionLayout motionLayout, View view) {
            this.f١٨٩٣a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f١٨٩٣a.setNestedScrollingEnabled(true);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.f١٨٦٣l0.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٨٩٥a;

        static {
            int[] iArr = new int[l.values().length];
            f١٨٩٥a = iArr;
            try {
                iArr[l.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٨٩٥a[l.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٨٩٥a[l.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٨٩٥a[l.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class e extends n {

        /* renamed from: a, reason: collision with root package name */
        float f١٨٩٦a = DownloadProgress.UNKNOWN_PROGRESS;

        /* renamed from: b, reason: collision with root package name */
        float f١٨٩٧b = DownloadProgress.UNKNOWN_PROGRESS;

        /* renamed from: c, reason: collision with root package name */
        float f١٨٩٨c;

        e() {
        }

        @Override // androidx.constraintlayout.motion.widget.n
        public float a() {
            return MotionLayout.this.f١٨٤٦d;
        }

        public void b(float f10, float f11, float f12) {
            this.f١٨٩٦a = f10;
            this.f١٨٩٧b = f11;
            this.f١٨٩٨c = f12;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11;
            float f12;
            float f13 = this.f١٨٩٦a;
            if (f13 > DownloadProgress.UNKNOWN_PROGRESS) {
                float f14 = this.f١٨٩٨c;
                if (f13 / f14 < f10) {
                    f10 = f13 / f14;
                }
                MotionLayout.this.f١٨٤٦d = f13 - (f14 * f10);
                f11 = (f13 * f10) - (((f14 * f10) * f10) / 2.0f);
                f12 = this.f١٨٩٧b;
            } else {
                float f15 = this.f١٨٩٨c;
                if ((-f13) / f15 < f10) {
                    f10 = (-f13) / f15;
                }
                MotionLayout.this.f١٨٤٦d = (f15 * f10) + f13;
                f11 = (f13 * f10) + (((f15 * f10) * f10) / 2.0f);
                f12 = this.f١٨٩٧b;
            }
            return f11 + f12;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class f {

        /* renamed from: a, reason: collision with root package name */
        float[] f١٩٠٠a;

        /* renamed from: b, reason: collision with root package name */
        int[] f١٩٠١b;

        /* renamed from: c, reason: collision with root package name */
        float[] f١٩٠٢c;

        /* renamed from: d, reason: collision with root package name */
        Path f١٩٠٣d;

        /* renamed from: e, reason: collision with root package name */
        Paint f١٩٠٤e;

        /* renamed from: f, reason: collision with root package name */
        Paint f١٩٠٥f;

        /* renamed from: g, reason: collision with root package name */
        Paint f١٩٠٦g;

        /* renamed from: h, reason: collision with root package name */
        Paint f١٩٠٧h;

        /* renamed from: i, reason: collision with root package name */
        Paint f١٩٠٨i;

        /* renamed from: j, reason: collision with root package name */
        private float[] f١٩٠٩j;

        /* renamed from: p, reason: collision with root package name */
        DashPathEffect f١٩١٥p;

        /* renamed from: q, reason: collision with root package name */
        int f١٩١٦q;

        /* renamed from: t, reason: collision with root package name */
        int f١٩١٩t;

        /* renamed from: k, reason: collision with root package name */
        final int f١٩١٠k = -21965;

        /* renamed from: l, reason: collision with root package name */
        final int f١٩١١l = -2067046;

        /* renamed from: m, reason: collision with root package name */
        final int f١٩١٢m = -13391360;

        /* renamed from: n, reason: collision with root package name */
        final int f١٩١٣n = 1996488704;

        /* renamed from: o, reason: collision with root package name */
        final int f١٩١٤o = 10;

        /* renamed from: r, reason: collision with root package name */
        Rect f١٩١٧r = new Rect();

        /* renamed from: s, reason: collision with root package name */
        boolean f١٩١٨s = false;

        public f() {
            this.f١٩١٩t = 1;
            Paint paint = new Paint();
            this.f١٩٠٤e = paint;
            paint.setAntiAlias(true);
            this.f١٩٠٤e.setColor(-21965);
            this.f١٩٠٤e.setStrokeWidth(2.0f);
            Paint paint2 = this.f١٩٠٤e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f١٩٠٥f = paint3;
            paint3.setAntiAlias(true);
            this.f١٩٠٥f.setColor(-2067046);
            this.f١٩٠٥f.setStrokeWidth(2.0f);
            this.f١٩٠٥f.setStyle(style);
            Paint paint4 = new Paint();
            this.f١٩٠٦g = paint4;
            paint4.setAntiAlias(true);
            this.f١٩٠٦g.setColor(-13391360);
            this.f١٩٠٦g.setStrokeWidth(2.0f);
            this.f١٩٠٦g.setStyle(style);
            Paint paint5 = new Paint();
            this.f١٩٠٧h = paint5;
            paint5.setAntiAlias(true);
            this.f١٩٠٧h.setColor(-13391360);
            this.f١٩٠٧h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f١٩٠٩j = new float[8];
            Paint paint6 = new Paint();
            this.f١٩٠٨i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٩١٥p = dashPathEffect;
            this.f١٩٠٦g.setPathEffect(dashPathEffect);
            this.f١٩٠٢c = new float[100];
            this.f١٩٠١b = new int[50];
            if (this.f١٩١٨s) {
                this.f١٩٠٤e.setStrokeWidth(8.0f);
                this.f١٩٠٨i.setStrokeWidth(8.0f);
                this.f١٩٠٥f.setStrokeWidth(8.0f);
                this.f١٩١٩t = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.f١٩٠٠a, this.f١٩٠٤e);
        }

        private void d(Canvas canvas) {
            boolean z10 = false;
            boolean z11 = false;
            for (int i10 = 0; i10 < this.f١٩١٦q; i10++) {
                int i11 = this.f١٩٠١b[i10];
                if (i11 == 1) {
                    z10 = true;
                }
                if (i11 == 0) {
                    z11 = true;
                }
            }
            if (z10) {
                g(canvas);
            }
            if (z11) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.f١٩٠٠a;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f10, f12), Math.max(f11, f13), Math.max(f10, f12), Math.max(f11, f13), this.f١٩٠٦g);
            canvas.drawLine(Math.min(f10, f12), Math.min(f11, f13), Math.min(f10, f12), Math.max(f11, f13), this.f١٩٠٦g);
        }

        private void f(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f١٩٠٠a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float min = Math.min(f12, f14);
            float max = Math.max(f13, f15);
            float min2 = f10 - Math.min(f12, f14);
            float max2 = Math.max(f13, f15) - f11;
            String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f14 - f12)) + 0.5d)) / 100.0f);
            l(str, this.f١٩٠٧h);
            canvas.drawText(str, ((min2 / 2.0f) - (this.f١٩١٧r.width() / 2)) + min, f11 - 20.0f, this.f١٩٠٧h);
            canvas.drawLine(f10, f11, Math.min(f12, f14), f11, this.f١٩٠٦g);
            String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f15 - f13)) + 0.5d)) / 100.0f);
            l(str2, this.f١٩٠٧h);
            canvas.drawText(str2, f10 + 5.0f, max - ((max2 / 2.0f) - (this.f١٩١٧r.height() / 2)), this.f١٩٠٧h);
            canvas.drawLine(f10, f11, f10, Math.max(f13, f15), this.f١٩٠٦g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.f١٩٠٠a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f١٩٠٦g);
        }

        private void h(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f١٩٠٠a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f12 - f14, f13 - f15);
            float f16 = f14 - f12;
            float f17 = f15 - f13;
            float f18 = (((f10 - f12) * f16) + ((f11 - f13) * f17)) / (hypot * hypot);
            float f19 = f12 + (f16 * f18);
            float f20 = f13 + (f18 * f17);
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f19, f20);
            float hypot2 = (float) Math.hypot(f19 - f10, f20 - f11);
            String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            l(str, this.f١٩٠٧h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.f١٩١٧r.width() / 2), -20.0f, this.f١٩٠٧h);
            canvas.drawLine(f10, f11, f19, f20, this.f١٩٠٦g);
        }

        private void i(Canvas canvas, float f10, float f11, int i10, int i11) {
            String str = "" + (((int) ((((f10 - (i10 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i10)) + 0.5d)) / 100.0f);
            l(str, this.f١٩٠٧h);
            canvas.drawText(str, ((f10 / 2.0f) - (this.f١٩١٧r.width() / 2)) + DownloadProgress.UNKNOWN_PROGRESS, f11 - 20.0f, this.f١٩٠٧h);
            canvas.drawLine(f10, f11, Math.min(DownloadProgress.UNKNOWN_PROGRESS, 1.0f), f11, this.f١٩٠٦g);
            String str2 = "" + (((int) ((((f11 - (i11 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i11)) + 0.5d)) / 100.0f);
            l(str2, this.f١٩٠٧h);
            canvas.drawText(str2, f10 + 5.0f, DownloadProgress.UNKNOWN_PROGRESS - ((f11 / 2.0f) - (this.f١٩١٧r.height() / 2)), this.f١٩٠٧h);
            canvas.drawLine(f10, f11, f10, Math.max(DownloadProgress.UNKNOWN_PROGRESS, 1.0f), this.f١٩٠٦g);
        }

        private void j(Canvas canvas, m mVar) {
            this.f١٩٠٣d.reset();
            for (int i10 = 0; i10 <= 50; i10++) {
                mVar.e(i10 / 50, this.f١٩٠٩j, 0);
                Path path = this.f١٩٠٣d;
                float[] fArr = this.f١٩٠٩j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f١٩٠٣d;
                float[] fArr2 = this.f١٩٠٩j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f١٩٠٣d;
                float[] fArr3 = this.f١٩٠٩j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f١٩٠٣d;
                float[] fArr4 = this.f١٩٠٩j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f١٩٠٣d.close();
            }
            this.f١٩٠٤e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f١٩٠٣d, this.f١٩٠٤e);
            canvas.translate(-2.0f, -2.0f);
            this.f١٩٠٤e.setColor(-65536);
            canvas.drawPath(this.f١٩٠٣d, this.f١٩٠٤e);
        }

        private void k(Canvas canvas, int i10, int i11, m mVar) {
            int i12;
            int i13;
            float f10;
            float f11;
            View view = mVar.f٢٠٢٠b;
            if (view != null) {
                i12 = view.getWidth();
                i13 = mVar.f٢٠٢٠b.getHeight();
            } else {
                i12 = 0;
                i13 = 0;
            }
            for (int i14 = 1; i14 < i11 - 1; i14++) {
                if (i10 != 4 || this.f١٩٠١b[i14 - 1] != 0) {
                    float[] fArr = this.f١٩٠٢c;
                    int i15 = i14 * 2;
                    float f12 = fArr[i15];
                    float f13 = fArr[i15 + 1];
                    this.f١٩٠٣d.reset();
                    this.f١٩٠٣d.moveTo(f12, f13 + 10.0f);
                    this.f١٩٠٣d.lineTo(f12 + 10.0f, f13);
                    this.f١٩٠٣d.lineTo(f12, f13 - 10.0f);
                    this.f١٩٠٣d.lineTo(f12 - 10.0f, f13);
                    this.f١٩٠٣d.close();
                    int i16 = i14 - 1;
                    mVar.q(i16);
                    if (i10 == 4) {
                        int i17 = this.f١٩٠١b[i16];
                        if (i17 == 1) {
                            h(canvas, f12 - DownloadProgress.UNKNOWN_PROGRESS, f13 - DownloadProgress.UNKNOWN_PROGRESS);
                        } else if (i17 == 0) {
                            f(canvas, f12 - DownloadProgress.UNKNOWN_PROGRESS, f13 - DownloadProgress.UNKNOWN_PROGRESS);
                        } else if (i17 == 2) {
                            f10 = f13;
                            f11 = f12;
                            i(canvas, f12 - DownloadProgress.UNKNOWN_PROGRESS, f13 - DownloadProgress.UNKNOWN_PROGRESS, i12, i13);
                            canvas.drawPath(this.f١٩٠٣d, this.f١٩٠٨i);
                        }
                        f10 = f13;
                        f11 = f12;
                        canvas.drawPath(this.f١٩٠٣d, this.f١٩٠٨i);
                    } else {
                        f10 = f13;
                        f11 = f12;
                    }
                    if (i10 == 2) {
                        h(canvas, f11 - DownloadProgress.UNKNOWN_PROGRESS, f10 - DownloadProgress.UNKNOWN_PROGRESS);
                    }
                    if (i10 == 3) {
                        f(canvas, f11 - DownloadProgress.UNKNOWN_PROGRESS, f10 - DownloadProgress.UNKNOWN_PROGRESS);
                    }
                    if (i10 == 6) {
                        i(canvas, f11 - DownloadProgress.UNKNOWN_PROGRESS, f10 - DownloadProgress.UNKNOWN_PROGRESS, i12, i13);
                    }
                    canvas.drawPath(this.f١٩٠٣d, this.f١٩٠٨i);
                }
            }
            float[] fArr2 = this.f١٩٠٠a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f١٩٠٥f);
                float[] fArr3 = this.f١٩٠٠a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f١٩٠٥f);
            }
        }

        public void a(Canvas canvas, HashMap hashMap, int i10, int i11) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i11 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.f١٨٥٢g) + CertificateUtil.DELIMITER + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f١٩٠٧h);
                    canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f١٩٠٤e);
                }
                for (m mVar : hashMap.values()) {
                    int m10 = mVar.m();
                    if (i11 > 0 && m10 == 0) {
                        m10 = 1;
                    }
                    if (m10 != 0) {
                        this.f١٩١٦q = mVar.c(this.f١٩٠٢c, this.f١٩٠١b);
                        if (m10 >= 1) {
                            int i12 = i10 / 16;
                            float[] fArr = this.f١٩٠٠a;
                            if (fArr == null || fArr.length != i12 * 2) {
                                this.f١٩٠٠a = new float[i12 * 2];
                                this.f١٩٠٣d = new Path();
                            }
                            int i13 = this.f١٩١٩t;
                            canvas.translate(i13, i13);
                            this.f١٩٠٤e.setColor(1996488704);
                            this.f١٩٠٨i.setColor(1996488704);
                            this.f١٩٠٥f.setColor(1996488704);
                            this.f١٩٠٦g.setColor(1996488704);
                            mVar.d(this.f١٩٠٠a, i12);
                            b(canvas, m10, this.f١٩١٦q, mVar);
                            this.f١٩٠٤e.setColor(-21965);
                            this.f١٩٠٥f.setColor(-2067046);
                            this.f١٩٠٨i.setColor(-2067046);
                            this.f١٩٠٦g.setColor(-13391360);
                            int i14 = this.f١٩١٩t;
                            canvas.translate(-i14, -i14);
                            b(canvas, m10, this.f١٩١٦q, mVar);
                            if (m10 == 5) {
                                j(canvas, mVar);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void b(Canvas canvas, int i10, int i11, m mVar) {
            if (i10 == 4) {
                d(canvas);
            }
            if (i10 == 2) {
                g(canvas);
            }
            if (i10 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i10, i11, mVar);
        }

        void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f١٩١٧r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        c2.f f١٩٢١a = new c2.f();

        /* renamed from: b, reason: collision with root package name */
        c2.f f١٩٢٢b = new c2.f();

        /* renamed from: c, reason: collision with root package name */
        androidx.constraintlayout.widget.c f١٩٢٣c = null;

        /* renamed from: d, reason: collision with root package name */
        androidx.constraintlayout.widget.c f١٩٢٤d = null;

        /* renamed from: e, reason: collision with root package name */
        int f١٩٢٥e;

        /* renamed from: f, reason: collision with root package name */
        int f١٩٢٦f;

        g() {
        }

        private void b(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.f١٨٥٠f == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                c2.f fVar = this.f١٩٢٢b;
                androidx.constraintlayout.widget.c cVar = this.f١٩٢٤d;
                if (cVar != null && cVar.f٢٤١١d != 0) {
                    i15 = i11;
                } else {
                    i15 = i10;
                }
                if (cVar != null && cVar.f٢٤١١d != 0) {
                    i16 = i10;
                } else {
                    i16 = i11;
                }
                motionLayout2.resolveSystem(fVar, optimizationLevel, i15, i16);
                androidx.constraintlayout.widget.c cVar2 = this.f١٩٢٣c;
                if (cVar2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    c2.f fVar2 = this.f١٩٢١a;
                    int i18 = cVar2.f٢٤١١d;
                    if (i18 == 0) {
                        i17 = i10;
                    } else {
                        i17 = i11;
                    }
                    if (i18 == 0) {
                        i10 = i11;
                    }
                    motionLayout3.resolveSystem(fVar2, optimizationLevel, i17, i10);
                    return;
                }
                return;
            }
            androidx.constraintlayout.widget.c cVar3 = this.f١٩٢٣c;
            if (cVar3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                c2.f fVar3 = this.f١٩٢١a;
                int i19 = cVar3.f٢٤١١d;
                if (i19 == 0) {
                    i13 = i10;
                } else {
                    i13 = i11;
                }
                if (i19 == 0) {
                    i14 = i11;
                } else {
                    i14 = i10;
                }
                motionLayout4.resolveSystem(fVar3, optimizationLevel, i13, i14);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            c2.f fVar4 = this.f١٩٢٢b;
            androidx.constraintlayout.widget.c cVar4 = this.f١٩٢٤d;
            if (cVar4 != null && cVar4.f٢٤١١d != 0) {
                i12 = i11;
            } else {
                i12 = i10;
            }
            if (cVar4 == null || cVar4.f٢٤١١d == 0) {
                i10 = i11;
            }
            motionLayout5.resolveSystem(fVar4, optimizationLevel, i12, i10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void j(c2.f fVar, androidx.constraintlayout.widget.c cVar) {
            SparseArray sparseArray = new SparseArray();
            Constraints.a aVar = new Constraints.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, fVar);
            sparseArray.put(MotionLayout.this.getId(), fVar);
            if (cVar != null && cVar.f٢٤١١d != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.f١٩٢٢b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator it = fVar.v1().iterator();
            while (it.hasNext()) {
                c2.e eVar = (c2.e) it.next();
                eVar.D0(true);
                sparseArray.put(((View) eVar.u()).getId(), eVar);
            }
            Iterator it2 = fVar.v1().iterator();
            while (it2.hasNext()) {
                c2.e eVar2 = (c2.e) it2.next();
                View view = (View) eVar2.u();
                cVar.l(view.getId(), aVar);
                eVar2.o1(cVar.C(view.getId()));
                eVar2.P0(cVar.x(view.getId()));
                if (view instanceof ConstraintHelper) {
                    cVar.j((ConstraintHelper) view, eVar2, aVar, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).v();
                    }
                }
                aVar.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, eVar2, aVar, sparseArray);
                if (cVar.B(view.getId()) == 1) {
                    eVar2.n1(view.getVisibility());
                } else {
                    eVar2.n1(cVar.A(view.getId()));
                }
            }
            Iterator it3 = fVar.v1().iterator();
            while (it3.hasNext()) {
                c2.e eVar3 = (c2.e) it3.next();
                if (eVar3 instanceof c2.m) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) eVar3.u();
                    c2.i iVar = (c2.i) eVar3;
                    constraintHelper.u(fVar, iVar, sparseArray);
                    ((c2.m) iVar).y1();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x013d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a() {
            String str;
            SparseArray sparseArray;
            String str2;
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.f١٨٦٠k.clear();
            SparseArray sparseArray2 = new SparseArray();
            int[] iArr = new int[childCount];
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = MotionLayout.this.getChildAt(i10);
                m mVar = new m(childAt);
                int id = childAt.getId();
                iArr[i10] = id;
                sparseArray2.put(id, mVar);
                MotionLayout.this.f١٨٦٠k.put(childAt, mVar);
            }
            int i11 = 0;
            while (i11 < childCount) {
                View childAt2 = MotionLayout.this.getChildAt(i11);
                m mVar2 = (m) MotionLayout.this.f١٨٦٠k.get(childAt2);
                if (mVar2 == null) {
                    sparseArray = sparseArray2;
                } else {
                    if (this.f١٩٢٣c != null) {
                        c2.e d10 = d(this.f١٩٢١a, childAt2);
                        if (d10 != null) {
                            mVar2.F(MotionLayout.this.l0(d10), this.f١٩٢٣c, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.f١٨٨٦x != 0) {
                            Log.e("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + "no widget for  " + androidx.constraintlayout.motion.widget.a.d(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    } else if (MotionLayout.this.f١٨٧١p0) {
                        a0.a(MotionLayout.this.f١٨٧٥r0.get(childAt2));
                        MotionLayout motionLayout = MotionLayout.this;
                        str = "MotionLayout";
                        sparseArray = sparseArray2;
                        str2 = "no widget for  ";
                        mVar2.G(null, childAt2, motionLayout.f١٨٧٣q0, motionLayout.f١٨٧٧s0, MotionLayout.this.f١٨٧٩t0);
                        if (this.f١٩٢٤d != null) {
                            c2.e d11 = d(this.f١٩٢٢b, childAt2);
                            if (d11 != null) {
                                mVar2.C(MotionLayout.this.l0(d11), this.f١٩٢٤d, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                            } else if (MotionLayout.this.f١٨٨٦x != 0) {
                                Log.e(str, androidx.constraintlayout.motion.widget.a.b() + str2 + androidx.constraintlayout.motion.widget.a.d(childAt2) + " (" + childAt2.getClass().getName() + ")");
                            }
                        }
                    }
                    sparseArray = sparseArray2;
                    str = "MotionLayout";
                    str2 = "no widget for  ";
                    if (this.f١٩٢٤d != null) {
                    }
                }
                i11++;
                sparseArray2 = sparseArray;
            }
            SparseArray sparseArray3 = sparseArray2;
            int i12 = 0;
            while (i12 < childCount) {
                SparseArray sparseArray4 = sparseArray3;
                m mVar3 = (m) sparseArray4.get(iArr[i12]);
                int h10 = mVar3.h();
                if (h10 != -1) {
                    mVar3.J((m) sparseArray4.get(h10));
                }
                i12++;
                sparseArray3 = sparseArray4;
            }
        }

        void c(c2.f fVar, c2.f fVar2) {
            c2.e eVar;
            ArrayList v12 = fVar.v1();
            HashMap hashMap = new HashMap();
            hashMap.put(fVar, fVar2);
            fVar2.v1().clear();
            fVar2.n(fVar, hashMap);
            Iterator it = v12.iterator();
            while (it.hasNext()) {
                c2.e eVar2 = (c2.e) it.next();
                if (eVar2 instanceof c2.a) {
                    eVar = new c2.a();
                } else if (eVar2 instanceof c2.h) {
                    eVar = new c2.h();
                } else if (eVar2 instanceof c2.g) {
                    eVar = new c2.g();
                } else if (eVar2 instanceof c2.l) {
                    eVar = new c2.l();
                } else if (eVar2 instanceof c2.i) {
                    eVar = new c2.j();
                } else {
                    eVar = new c2.e();
                }
                fVar2.a(eVar);
                hashMap.put(eVar2, eVar);
            }
            Iterator it2 = v12.iterator();
            while (it2.hasNext()) {
                c2.e eVar3 = (c2.e) it2.next();
                ((c2.e) hashMap.get(eVar3)).n(eVar3, hashMap);
            }
        }

        c2.e d(c2.f fVar, View view) {
            if (fVar.u() == view) {
                return fVar;
            }
            ArrayList v12 = fVar.v1();
            int size = v12.size();
            for (int i10 = 0; i10 < size; i10++) {
                c2.e eVar = (c2.e) v12.get(i10);
                if (eVar.u() == view) {
                    return eVar;
                }
            }
            return null;
        }

        void e(c2.f fVar, androidx.constraintlayout.widget.c cVar, androidx.constraintlayout.widget.c cVar2) {
            this.f١٩٢٣c = cVar;
            this.f١٩٢٤d = cVar2;
            this.f١٩٢١a = new c2.f();
            this.f١٩٢٢b = new c2.f();
            this.f١٩٢١a.a2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.N1());
            this.f١٩٢٢b.a2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.N1());
            this.f١٩٢١a.y1();
            this.f١٩٢٢b.y1();
            c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f١٩٢١a);
            c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f١٩٢٢b);
            if (MotionLayout.this.f١٨٦٨o > 0.5d) {
                if (cVar != null) {
                    j(this.f١٩٢١a, cVar);
                }
                j(this.f١٩٢٢b, cVar2);
            } else {
                j(this.f١٩٢٢b, cVar2);
                if (cVar != null) {
                    j(this.f١٩٢١a, cVar);
                }
            }
            this.f١٩٢١a.d2(MotionLayout.this.isRtl());
            this.f١٩٢١a.f2();
            this.f١٩٢٢b.d2(MotionLayout.this.isRtl());
            this.f١٩٢٢b.f2();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    c2.f fVar2 = this.f١٩٢١a;
                    e.b bVar = e.b.WRAP_CONTENT;
                    fVar2.T0(bVar);
                    this.f١٩٢٢b.T0(bVar);
                }
                if (layoutParams.height == -2) {
                    c2.f fVar3 = this.f١٩٢١a;
                    e.b bVar2 = e.b.WRAP_CONTENT;
                    fVar3.k1(bVar2);
                    this.f١٩٢٢b.k1(bVar2);
                }
            }
        }

        public boolean f(int i10, int i11) {
            if (i10 == this.f١٩٢٥e && i11 == this.f١٩٢٦f) {
                return false;
            }
            return true;
        }

        public void g(int i10, int i11) {
            boolean z10;
            boolean z11;
            boolean z12;
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.f١٨٥٣g0 = mode;
            motionLayout.f١٨٥٥h0 = mode2;
            motionLayout.getOptimizationLevel();
            b(i10, i11);
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                b(i10, i11);
                MotionLayout.this.f١٨٤٥c0 = this.f١٩٢١a.Y();
                MotionLayout.this.f١٨٤٧d0 = this.f١٩٢١a.z();
                MotionLayout.this.f١٨٤٩e0 = this.f١٩٢٢b.Y();
                MotionLayout.this.f١٨٥١f0 = this.f١٩٢٢b.z();
                MotionLayout motionLayout2 = MotionLayout.this;
                if (motionLayout2.f١٨٤٥c0 == motionLayout2.f١٨٤٩e0 && motionLayout2.f١٨٤٧d0 == motionLayout2.f١٨٥١f0) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                motionLayout2.f١٨٤٣b0 = z10;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i12 = motionLayout3.f١٨٤٥c0;
            int i13 = motionLayout3.f١٨٤٧d0;
            int i14 = motionLayout3.f١٨٥٣g0;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                i12 = (int) (i12 + (motionLayout3.f١٨٥٧i0 * (motionLayout3.f١٨٤٩e0 - i12)));
            }
            int i15 = i12;
            int i16 = motionLayout3.f١٨٥٥h0;
            if (i16 == Integer.MIN_VALUE || i16 == 0) {
                i13 = (int) (i13 + (motionLayout3.f١٨٥٧i0 * (motionLayout3.f١٨٥١f0 - i13)));
            }
            int i17 = i13;
            if (!this.f١٩٢١a.V1() && !this.f١٩٢٢b.V1()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!this.f١٩٢١a.T1() && !this.f١٩٢٢b.T1()) {
                z12 = false;
            } else {
                z12 = true;
            }
            MotionLayout.this.resolveMeasuredDimension(i10, i11, i15, i17, z11, z12);
        }

        public void h() {
            g(MotionLayout.this.f١٨٥٤h, MotionLayout.this.f١٨٥٦i);
            MotionLayout.this.k0();
        }

        public void i(int i10, int i11) {
            this.f١٩٢٥e = i10;
            this.f١٩٢٦f = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface h {
        void a(MotionEvent motionEvent);

        float b();

        float c();

        void d(int i10);

        void recycle();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class i implements h {

        /* renamed from: b, reason: collision with root package name */
        private static i f١٩٢٨b = new i();

        /* renamed from: a, reason: collision with root package name */
        VelocityTracker f١٩٢٩a;

        private i() {
        }

        public static i e() {
            f١٩٢٨b.f١٩٢٩a = VelocityTracker.obtain();
            return f١٩٢٨b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.h
        public void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f١٩٢٩a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.h
        public float b() {
            VelocityTracker velocityTracker = this.f١٩٢٩a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return DownloadProgress.UNKNOWN_PROGRESS;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.h
        public float c() {
            VelocityTracker velocityTracker = this.f١٩٢٩a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return DownloadProgress.UNKNOWN_PROGRESS;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.h
        public void d(int i10) {
            VelocityTracker velocityTracker = this.f١٩٢٩a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i10);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.h
        public void recycle() {
            VelocityTracker velocityTracker = this.f١٩٢٩a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f١٩٢٩a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class j {

        /* renamed from: a, reason: collision with root package name */
        float f١٩٣٠a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        float f١٩٣١b = Float.NaN;

        /* renamed from: c, reason: collision with root package name */
        int f١٩٣٢c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f١٩٣٣d = -1;

        /* renamed from: e, reason: collision with root package name */
        final String f١٩٣٤e = "motion.progress";

        /* renamed from: f, reason: collision with root package name */
        final String f١٩٣٥f = "motion.velocity";

        /* renamed from: g, reason: collision with root package name */
        final String f١٩٣٦g = "motion.StartState";

        /* renamed from: h, reason: collision with root package name */
        final String f١٩٣٧h = "motion.EndState";

        j() {
        }

        void a() {
            int i10 = this.f١٩٣٢c;
            if (i10 != -1 || this.f١٩٣٣d != -1) {
                if (i10 == -1) {
                    MotionLayout.this.q0(this.f١٩٣٣d);
                } else {
                    int i11 = this.f١٩٣٣d;
                    if (i11 == -1) {
                        MotionLayout.this.setState(i10, -1, -1);
                    } else {
                        MotionLayout.this.j0(i10, i11);
                    }
                }
                MotionLayout.this.setState(l.SETUP);
            }
            if (Float.isNaN(this.f١٩٣١b)) {
                if (Float.isNaN(this.f١٩٣٠a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f١٩٣٠a);
            } else {
                MotionLayout.this.i0(this.f١٩٣٠a, this.f١٩٣١b);
                this.f١٩٣٠a = Float.NaN;
                this.f١٩٣١b = Float.NaN;
                this.f١٩٣٢c = -1;
                this.f١٩٣٣d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f١٩٣٠a);
            bundle.putFloat("motion.velocity", this.f١٩٣١b);
            bundle.putInt("motion.StartState", this.f١٩٣٢c);
            bundle.putInt("motion.EndState", this.f١٩٣٣d);
            return bundle;
        }

        public void c() {
            this.f١٩٣٣d = MotionLayout.this.f١٨٥٢g;
            this.f١٩٣٢c = MotionLayout.this.f١٨٤٨e;
            this.f١٩٣١b = MotionLayout.this.getVelocity();
            this.f١٩٣٠a = MotionLayout.this.getProgress();
        }

        public void d(int i10) {
            this.f١٩٣٣d = i10;
        }

        public void e(float f10) {
            this.f١٩٣٠a = f10;
        }

        public void f(int i10) {
            this.f١٩٣٢c = i10;
        }

        public void g(Bundle bundle) {
            this.f١٩٣٠a = bundle.getFloat("motion.progress");
            this.f١٩٣١b = bundle.getFloat("motion.velocity");
            this.f١٩٣٢c = bundle.getInt("motion.StartState");
            this.f١٩٣٣d = bundle.getInt("motion.EndState");
        }

        public void h(float f10) {
            this.f١٩٣١b = f10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface k {
        void a(MotionLayout motionLayout, int i10, int i11, float f10);

        void b(MotionLayout motionLayout, int i10);

        void c(MotionLayout motionLayout, int i10, int i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum l {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context) {
        super(context);
        this.f١٨٤٤c = null;
        this.f١٨٤٦d = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٤٨e = -1;
        this.f١٨٥٠f = -1;
        this.f١٨٥٢g = -1;
        this.f١٨٥٤h = 0;
        this.f١٨٥٦i = 0;
        this.f١٨٥٨j = true;
        this.f١٨٦٠k = new HashMap();
        this.f١٨٦٢l = 0L;
        this.f١٨٦٤m = 1.0f;
        this.f١٨٦٦n = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٦٨o = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٧٢q = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٧٦s = false;
        this.f١٨٧٨t = false;
        this.f١٨٨٦x = 0;
        this.f١٨٩٠z = false;
        this.A = new e2.b();
        this.f١٨٣٩B = new e();
        this.D = true;
        this.I = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.T = -1L;
        this.U = DownloadProgress.UNKNOWN_PROGRESS;
        this.V = 0;
        this.W = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٤١a0 = false;
        this.f١٨٤٣b0 = false;
        this.f١٨٥٩j0 = new a2.d();
        this.f١٨٦١k0 = false;
        this.f١٨٦٥m0 = null;
        this.f١٨٦٧n0 = null;
        this.f١٨٦٩o0 = 0;
        this.f١٨٧١p0 = false;
        this.f١٨٧٣q0 = 0;
        this.f١٨٧٥r0 = new HashMap();
        this.f١٨٨٣v0 = new Rect();
        this.f١٨٨٥w0 = false;
        this.f١٨٨٧x0 = l.UNDEFINED;
        this.f١٨٨٩y0 = new g();
        this.f١٨٩١z0 = false;
        this.A0 = new RectF();
        this.B0 = null;
        this.C0 = null;
        this.D0 = new ArrayList();
        c0(null);
    }

    private boolean M(View view, MotionEvent motionEvent, float f10, float f11) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f10, f11);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f10, -f11);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f10, f11);
        if (this.C0 == null) {
            this.C0 = new Matrix();
        }
        matrix.invert(this.C0);
        obtain.transform(this.C0);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    private void N() {
        p pVar = this.f١٨٤٠a;
        if (pVar == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int F = pVar.F();
        p pVar2 = this.f١٨٤٠a;
        O(F, pVar2.l(pVar2.F()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator it = this.f١٨٤٠a.o().iterator();
        while (it.hasNext()) {
            p.b bVar = (p.b) it.next();
            if (bVar == this.f١٨٤٠a.f٢٠٦٨c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            P(bVar);
            int A = bVar.A();
            int y10 = bVar.y();
            String c10 = androidx.constraintlayout.motion.widget.a.c(getContext(), A);
            String c11 = androidx.constraintlayout.motion.widget.a.c(getContext(), y10);
            if (sparseIntArray.get(A) == y10) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + c10 + "->" + c11);
            }
            if (sparseIntArray2.get(y10) == A) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + c10 + "->" + c11);
            }
            sparseIntArray.put(A, y10);
            sparseIntArray2.put(y10, A);
            if (this.f١٨٤٠a.l(A) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + c10);
            }
            if (this.f١٨٤٠a.l(y10) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + c10);
            }
        }
    }

    private void O(int i10, androidx.constraintlayout.widget.c cVar) {
        String c10 = androidx.constraintlayout.motion.widget.a.c(getContext(), i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id = childAt.getId();
            if (id == -1) {
                Log.w("MotionLayout", "CHECK: " + c10 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (cVar.w(id) == null) {
                Log.w("MotionLayout", "CHECK: " + c10 + " NO CONSTRAINTS for " + androidx.constraintlayout.motion.widget.a.d(childAt));
            }
        }
        int[] y10 = cVar.y();
        for (int i12 = 0; i12 < y10.length; i12++) {
            int i13 = y10[i12];
            String c11 = androidx.constraintlayout.motion.widget.a.c(getContext(), i13);
            if (findViewById(y10[i12]) == null) {
                Log.w("MotionLayout", "CHECK: " + c10 + " NO View matches id " + c11);
            }
            if (cVar.x(i13) == -1) {
                Log.w("MotionLayout", "CHECK: " + c10 + "(" + c11 + ") no LAYOUT_HEIGHT");
            }
            if (cVar.C(i13) == -1) {
                Log.w("MotionLayout", "CHECK: " + c10 + "(" + c11 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    private void P(p.b bVar) {
        if (bVar.A() == bVar.y()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    private void Q() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            m mVar = (m) this.f١٨٦٠k.get(childAt);
            if (mVar != null) {
                mVar.E(childAt);
            }
        }
    }

    private void T() {
        float f10;
        boolean z10;
        float signum = Math.signum(this.f١٨٧٢q - this.f١٨٦٨o);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f١٨٤٢b;
        if (!(interpolator instanceof e2.b)) {
            f10 = ((((float) (nanoTime - this.f١٨٧٠p)) * signum) * 1.0E-9f) / this.f١٨٦٤m;
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        float f11 = this.f١٨٦٨o + f10;
        if (this.f١٨٧٤r) {
            f11 = this.f١٨٧٢q;
        }
        if ((signum > DownloadProgress.UNKNOWN_PROGRESS && f11 >= this.f١٨٧٢q) || (signum <= DownloadProgress.UNKNOWN_PROGRESS && f11 <= this.f١٨٧٢q)) {
            f11 = this.f١٨٧٢q;
            z10 = true;
        } else {
            z10 = false;
        }
        if (interpolator != null && !z10) {
            if (this.f١٨٩٠z) {
                f11 = interpolator.getInterpolation(((float) (nanoTime - this.f١٨٦٢l)) * 1.0E-9f);
            } else {
                f11 = interpolator.getInterpolation(f11);
            }
        }
        if ((signum > DownloadProgress.UNKNOWN_PROGRESS && f11 >= this.f١٨٧٢q) || (signum <= DownloadProgress.UNKNOWN_PROGRESS && f11 <= this.f١٨٧٢q)) {
            f11 = this.f١٨٧٢q;
        }
        this.f١٨٥٧i0 = f11;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.f١٨٤٤c;
        if (interpolator2 != null) {
            f11 = interpolator2.getInterpolation(f11);
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            m mVar = (m) this.f١٨٦٠k.get(childAt);
            if (mVar != null) {
                mVar.x(childAt, f11, nanoTime2, this.f١٨٥٩j0);
            }
        }
        if (this.f١٨٤٣b0) {
            requestLayout();
        }
    }

    private void U() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.f١٨٨٠u != null || ((copyOnWriteArrayList = this.R) != null && !copyOnWriteArrayList.isEmpty())) && this.W != this.f١٨٦٦n) {
            if (this.V != -1) {
                k kVar = this.f١٨٨٠u;
                if (kVar != null) {
                    kVar.c(this, this.f١٨٤٨e, this.f١٨٥٢g);
                }
                CopyOnWriteArrayList copyOnWriteArrayList2 = this.R;
                if (copyOnWriteArrayList2 != null) {
                    Iterator it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        ((k) it.next()).c(this, this.f١٨٤٨e, this.f١٨٥٢g);
                    }
                }
                this.f١٨٤١a0 = true;
            }
            this.V = -1;
            float f10 = this.f١٨٦٦n;
            this.W = f10;
            k kVar2 = this.f١٨٨٠u;
            if (kVar2 != null) {
                kVar2.a(this, this.f١٨٤٨e, this.f١٨٥٢g, f10);
            }
            CopyOnWriteArrayList copyOnWriteArrayList3 = this.R;
            if (copyOnWriteArrayList3 != null) {
                Iterator it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    ((k) it2.next()).a(this, this.f١٨٤٨e, this.f١٨٥٢g, this.f١٨٦٦n);
                }
            }
            this.f١٨٤١a0 = true;
        }
    }

    private boolean b0(float f10, float f11, View view, MotionEvent motionEvent) {
        boolean z10;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (b0((r3.getLeft() + f10) - view.getScrollX(), (r3.getTop() + f11) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        if (!z10) {
            this.A0.set(f10, f11, (view.getRight() + f10) - view.getLeft(), (view.getBottom() + f11) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.A0.contains(motionEvent.getX(), motionEvent.getY())) && M(view, motionEvent, -f10, -f11)) {
                return true;
            }
        }
        return z10;
    }

    private void c0(AttributeSet attributeSet) {
        p pVar;
        int i10;
        E0 = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z10 = true;
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.f١٨٤٠a = new p(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.f١٨٥٠f = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.f١٨٧٢q = obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS);
                    this.f١٨٧٦s = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z10 = obtainStyledAttributes.getBoolean(index, z10);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.f١٨٨٦x == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i10 = 2;
                        } else {
                            i10 = 0;
                        }
                        this.f١٨٨٦x = i10;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.f١٨٨٦x = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f١٨٤٠a == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z10) {
                this.f١٨٤٠a = null;
            }
        }
        if (this.f١٨٨٦x != 0) {
            N();
        }
        if (this.f١٨٥٠f == -1 && (pVar = this.f١٨٤٠a) != null) {
            this.f١٨٥٠f = pVar.F();
            this.f١٨٤٨e = this.f١٨٤٠a.F();
            this.f١٨٥٢g = this.f١٨٤٠a.q();
        }
    }

    private void g0() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.f١٨٨٠u == null && ((copyOnWriteArrayList = this.R) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.f١٨٤١a0 = false;
        Iterator it = this.D0.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            k kVar = this.f١٨٨٠u;
            if (kVar != null) {
                kVar.b(this, num.intValue());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.R;
            if (copyOnWriteArrayList2 != null) {
                Iterator it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    ((k) it2.next()).b(this, num.intValue());
                }
            }
        }
        this.D0.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        float f10;
        float f11;
        int childCount = getChildCount();
        this.f١٨٨٩y0.a();
        boolean z10 = true;
        this.f١٨٧٦s = true;
        SparseArray sparseArray = new SparseArray();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            sparseArray.put(childAt.getId(), (m) this.f١٨٦٠k.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int j10 = this.f١٨٤٠a.j();
        if (j10 != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                m mVar = (m) this.f١٨٦٠k.get(getChildAt(i12));
                if (mVar != null) {
                    mVar.D(j10);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.f١٨٦٠k.size()];
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            m mVar2 = (m) this.f١٨٦٠k.get(getChildAt(i14));
            if (mVar2.h() != -1) {
                sparseBooleanArray.put(mVar2.h(), true);
                iArr[i13] = mVar2.h();
                i13++;
            }
        }
        if (this.Q != null) {
            for (int i15 = 0; i15 < i13; i15++) {
                m mVar3 = (m) this.f١٨٦٠k.get(findViewById(iArr[i15]));
                if (mVar3 != null) {
                    this.f١٨٤٠a.t(mVar3);
                }
            }
            Iterator it = this.Q.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).C(this, this.f١٨٦٠k);
            }
            for (int i16 = 0; i16 < i13; i16++) {
                m mVar4 = (m) this.f١٨٦٠k.get(findViewById(iArr[i16]));
                if (mVar4 != null) {
                    mVar4.I(width, height, this.f١٨٦٤m, getNanoTime());
                }
            }
        } else {
            for (int i17 = 0; i17 < i13; i17++) {
                m mVar5 = (m) this.f١٨٦٠k.get(findViewById(iArr[i17]));
                if (mVar5 != null) {
                    this.f١٨٤٠a.t(mVar5);
                    mVar5.I(width, height, this.f١٨٦٤m, getNanoTime());
                }
            }
        }
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            m mVar6 = (m) this.f١٨٦٠k.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && mVar6 != null) {
                this.f١٨٤٠a.t(mVar6);
                mVar6.I(width, height, this.f١٨٦٤m, getNanoTime());
            }
        }
        float E = this.f١٨٤٠a.E();
        if (E != DownloadProgress.UNKNOWN_PROGRESS) {
            if (E >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                z10 = false;
            }
            float abs = Math.abs(E);
            float f12 = -3.4028235E38f;
            float f13 = Float.MAX_VALUE;
            float f14 = Float.MAX_VALUE;
            float f15 = -3.4028235E38f;
            for (int i19 = 0; i19 < childCount; i19++) {
                m mVar7 = (m) this.f١٨٦٠k.get(getChildAt(i19));
                if (!Float.isNaN(mVar7.f٢٠٣١m)) {
                    for (int i20 = 0; i20 < childCount; i20++) {
                        m mVar8 = (m) this.f١٨٦٠k.get(getChildAt(i20));
                        if (!Float.isNaN(mVar8.f٢٠٣١m)) {
                            f13 = Math.min(f13, mVar8.f٢٠٣١m);
                            f12 = Math.max(f12, mVar8.f٢٠٣١m);
                        }
                    }
                    while (i10 < childCount) {
                        m mVar9 = (m) this.f١٨٦٠k.get(getChildAt(i10));
                        if (!Float.isNaN(mVar9.f٢٠٣١m)) {
                            mVar9.f٢٠٣٣o = 1.0f / (1.0f - abs);
                            if (z10) {
                                mVar9.f٢٠٣٢n = abs - (((f12 - mVar9.f٢٠٣١m) / (f12 - f13)) * abs);
                            } else {
                                mVar9.f٢٠٣٢n = abs - (((mVar9.f٢٠٣١m - f13) * abs) / (f12 - f13));
                            }
                        }
                        i10++;
                    }
                    return;
                }
                float n10 = mVar7.n();
                float o10 = mVar7.o();
                if (z10) {
                    f11 = o10 - n10;
                } else {
                    f11 = o10 + n10;
                }
                f14 = Math.min(f14, f11);
                f15 = Math.max(f15, f11);
            }
            while (i10 < childCount) {
                m mVar10 = (m) this.f١٨٦٠k.get(getChildAt(i10));
                float n11 = mVar10.n();
                float o11 = mVar10.o();
                if (z10) {
                    f10 = o11 - n11;
                } else {
                    f10 = o11 + n11;
                }
                mVar10.f٢٠٣٣o = 1.0f / (1.0f - abs);
                mVar10.f٢٠٣٢n = abs - (((f10 - f14) * abs) / (f15 - f14));
                i10++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect l0(c2.e eVar) {
        this.f١٨٨٣v0.top = eVar.a0();
        this.f١٨٨٣v0.left = eVar.Z();
        Rect rect = this.f١٨٨٣v0;
        int Y = eVar.Y();
        Rect rect2 = this.f١٨٨٣v0;
        rect.right = Y + rect2.left;
        int z10 = eVar.z();
        Rect rect3 = this.f١٨٨٣v0;
        rect2.bottom = z10 + rect3.top;
        return rect3;
    }

    private static boolean v0(float f10, float f11, float f12) {
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            float f13 = f10 / f12;
            return f11 + ((f10 * f13) - (((f12 * f13) * f13) / 2.0f)) > 1.0f;
        }
        float f14 = (-f10) / f12;
        return f11 + ((f10 * f14) + (((f12 * f14) * f14) / 2.0f)) < DownloadProgress.UNKNOWN_PROGRESS;
    }

    void K(float f10) {
        if (this.f١٨٤٠a == null) {
            return;
        }
        float f11 = this.f١٨٦٨o;
        float f12 = this.f١٨٦٦n;
        if (f11 != f12 && this.f١٨٧٤r) {
            this.f١٨٦٨o = f12;
        }
        float f13 = this.f١٨٦٨o;
        if (f13 == f10) {
            return;
        }
        this.f١٨٩٠z = false;
        this.f١٨٧٢q = f10;
        this.f١٨٦٤m = r0.p() / 1000.0f;
        setProgress(this.f١٨٧٢q);
        this.f١٨٤٢b = null;
        this.f١٨٤٤c = this.f١٨٤٠a.s();
        this.f١٨٧٤r = false;
        this.f١٨٦٢l = getNanoTime();
        this.f١٨٧٦s = true;
        this.f١٨٦٦n = f13;
        this.f١٨٦٨o = f13;
        invalidate();
    }

    public boolean L(int i10, m mVar) {
        p pVar = this.f١٨٤٠a;
        if (pVar != null) {
            return pVar.g(i10, mVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            m mVar = (m) this.f١٨٦٠k.get(getChildAt(i10));
            if (mVar != null) {
                mVar.f(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void S(boolean z10) {
        float f10;
        boolean z11;
        char c10;
        int childCount;
        Interpolator interpolator;
        float interpolation;
        Interpolator interpolator2;
        int i10;
        boolean z12;
        int i11;
        if (this.f١٨٧٠p == -1) {
            this.f١٨٧٠p = getNanoTime();
        }
        float f11 = this.f١٨٦٨o;
        if (f11 > DownloadProgress.UNKNOWN_PROGRESS && f11 < 1.0f) {
            this.f١٨٥٠f = -1;
        }
        boolean z13 = true;
        boolean z14 = false;
        if (this.N || (this.f١٨٧٦s && (z10 || this.f١٨٧٢q != f11))) {
            float signum = Math.signum(this.f١٨٧٢q - f11);
            long nanoTime = getNanoTime();
            Interpolator interpolator3 = this.f١٨٤٢b;
            if (!(interpolator3 instanceof n)) {
                f10 = ((((float) (nanoTime - this.f١٨٧٠p)) * signum) * 1.0E-9f) / this.f١٨٦٤m;
            } else {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            float f12 = this.f١٨٦٨o + f10;
            if (this.f١٨٧٤r) {
                f12 = this.f١٨٧٢q;
            }
            if ((signum > DownloadProgress.UNKNOWN_PROGRESS && f12 >= this.f١٨٧٢q) || (signum <= DownloadProgress.UNKNOWN_PROGRESS && f12 <= this.f١٨٧٢q)) {
                f12 = this.f١٨٧٢q;
                this.f١٨٧٦s = false;
                z11 = true;
            } else {
                z11 = false;
            }
            this.f١٨٦٨o = f12;
            this.f١٨٦٦n = f12;
            this.f١٨٧٠p = nanoTime;
            if (interpolator3 != null && !z11) {
                if (this.f١٨٩٠z) {
                    float interpolation2 = interpolator3.getInterpolation(((float) (nanoTime - this.f١٨٦٢l)) * 1.0E-9f);
                    Interpolator interpolator4 = this.f١٨٤٢b;
                    e2.b bVar = this.A;
                    if (interpolator4 == bVar) {
                        if (bVar.c()) {
                            c10 = 2;
                        } else {
                            c10 = 1;
                        }
                    } else {
                        c10 = 0;
                    }
                    this.f١٨٦٨o = interpolation2;
                    this.f١٨٧٠p = nanoTime;
                    Interpolator interpolator5 = this.f١٨٤٢b;
                    if (interpolator5 instanceof n) {
                        float a10 = ((n) interpolator5).a();
                        this.f١٨٤٦d = a10;
                        if (Math.abs(a10) * this.f١٨٦٤m <= 1.0E-5f && c10 == 2) {
                            this.f١٨٧٦s = false;
                        }
                        if (a10 > DownloadProgress.UNKNOWN_PROGRESS && interpolation2 >= 1.0f) {
                            this.f١٨٦٨o = 1.0f;
                            this.f١٨٧٦s = false;
                            interpolation2 = 1.0f;
                        }
                        if (a10 < DownloadProgress.UNKNOWN_PROGRESS && interpolation2 <= DownloadProgress.UNKNOWN_PROGRESS) {
                            this.f١٨٦٨o = DownloadProgress.UNKNOWN_PROGRESS;
                            this.f١٨٧٦s = false;
                            f12 = DownloadProgress.UNKNOWN_PROGRESS;
                            if (Math.abs(this.f١٨٤٦d) > 1.0E-5f) {
                                setState(l.MOVING);
                            }
                            if (c10 != 1) {
                                if ((signum > DownloadProgress.UNKNOWN_PROGRESS && f12 >= this.f١٨٧٢q) || (signum <= DownloadProgress.UNKNOWN_PROGRESS && f12 <= this.f١٨٧٢q)) {
                                    f12 = this.f١٨٧٢q;
                                    this.f١٨٧٦s = false;
                                }
                                if (f12 >= 1.0f || f12 <= DownloadProgress.UNKNOWN_PROGRESS) {
                                    this.f١٨٧٦s = false;
                                    setState(l.FINISHED);
                                }
                            }
                            childCount = getChildCount();
                            this.N = false;
                            long nanoTime2 = getNanoTime();
                            this.f١٨٥٧i0 = f12;
                            interpolator = this.f١٨٤٤c;
                            if (interpolator == null) {
                                interpolation = f12;
                            } else {
                                interpolation = interpolator.getInterpolation(f12);
                            }
                            interpolator2 = this.f١٨٤٤c;
                            if (interpolator2 != null) {
                                float interpolation3 = interpolator2.getInterpolation((signum / this.f١٨٦٤m) + f12);
                                this.f١٨٤٦d = interpolation3;
                                this.f١٨٤٦d = interpolation3 - this.f١٨٤٤c.getInterpolation(f12);
                            }
                            for (i10 = 0; i10 < childCount; i10++) {
                                View childAt = getChildAt(i10);
                                m mVar = (m) this.f١٨٦٠k.get(childAt);
                                if (mVar != null) {
                                    this.N = mVar.x(childAt, interpolation, nanoTime2, this.f١٨٥٩j0) | this.N;
                                }
                            }
                            if ((signum <= DownloadProgress.UNKNOWN_PROGRESS && f12 >= this.f١٨٧٢q) || (signum <= DownloadProgress.UNKNOWN_PROGRESS && f12 <= this.f١٨٧٢q)) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (!this.N && !this.f١٨٧٦s && z12) {
                                setState(l.FINISHED);
                            }
                            if (this.f١٨٤٣b0) {
                                requestLayout();
                            }
                            this.N = (!z12) | this.N;
                            if (f12 <= DownloadProgress.UNKNOWN_PROGRESS && (i11 = this.f١٨٤٨e) != -1 && this.f١٨٥٠f != i11) {
                                this.f١٨٥٠f = i11;
                                this.f١٨٤٠a.l(i11).g(this);
                                setState(l.FINISHED);
                                z14 = true;
                            }
                            if (f12 >= 1.0d) {
                                int i12 = this.f١٨٥٠f;
                                int i13 = this.f١٨٥٢g;
                                if (i12 != i13) {
                                    this.f١٨٥٠f = i13;
                                    this.f١٨٤٠a.l(i13).g(this);
                                    setState(l.FINISHED);
                                    z14 = true;
                                }
                            }
                            if (this.N && !this.f١٨٧٦s) {
                                if ((signum > DownloadProgress.UNKNOWN_PROGRESS && f12 == 1.0f) || (signum < DownloadProgress.UNKNOWN_PROGRESS && f12 == DownloadProgress.UNKNOWN_PROGRESS)) {
                                    setState(l.FINISHED);
                                }
                            } else {
                                invalidate();
                            }
                            if (!this.N && !this.f١٨٧٦s && ((signum > DownloadProgress.UNKNOWN_PROGRESS && f12 == 1.0f) || (signum < DownloadProgress.UNKNOWN_PROGRESS && f12 == DownloadProgress.UNKNOWN_PROGRESS))) {
                                f0();
                            }
                        }
                    }
                    f12 = interpolation2;
                    if (Math.abs(this.f١٨٤٦d) > 1.0E-5f) {
                    }
                    if (c10 != 1) {
                    }
                    childCount = getChildCount();
                    this.N = false;
                    long nanoTime22 = getNanoTime();
                    this.f١٨٥٧i0 = f12;
                    interpolator = this.f١٨٤٤c;
                    if (interpolator == null) {
                    }
                    interpolator2 = this.f١٨٤٤c;
                    if (interpolator2 != null) {
                    }
                    while (i10 < childCount) {
                    }
                    if (signum <= DownloadProgress.UNKNOWN_PROGRESS) {
                    }
                    z12 = false;
                    if (!this.N) {
                        setState(l.FINISHED);
                    }
                    if (this.f١٨٤٣b0) {
                    }
                    this.N = (!z12) | this.N;
                    if (f12 <= DownloadProgress.UNKNOWN_PROGRESS) {
                        this.f١٨٥٠f = i11;
                        this.f١٨٤٠a.l(i11).g(this);
                        setState(l.FINISHED);
                        z14 = true;
                    }
                    if (f12 >= 1.0d) {
                    }
                    if (this.N) {
                    }
                    invalidate();
                    if (!this.N) {
                        f0();
                    }
                } else {
                    float interpolation4 = interpolator3.getInterpolation(f12);
                    Interpolator interpolator6 = this.f١٨٤٢b;
                    if (interpolator6 instanceof n) {
                        this.f١٨٤٦d = ((n) interpolator6).a();
                    } else {
                        this.f١٨٤٦d = ((interpolator6.getInterpolation(f12 + f10) - interpolation4) * signum) / f10;
                    }
                    f12 = interpolation4;
                }
            } else {
                this.f١٨٤٦d = f10;
            }
            c10 = 0;
            if (Math.abs(this.f١٨٤٦d) > 1.0E-5f) {
            }
            if (c10 != 1) {
            }
            childCount = getChildCount();
            this.N = false;
            long nanoTime222 = getNanoTime();
            this.f١٨٥٧i0 = f12;
            interpolator = this.f١٨٤٤c;
            if (interpolator == null) {
            }
            interpolator2 = this.f١٨٤٤c;
            if (interpolator2 != null) {
            }
            while (i10 < childCount) {
            }
            if (signum <= DownloadProgress.UNKNOWN_PROGRESS) {
            }
            z12 = false;
            if (!this.N) {
            }
            if (this.f١٨٤٣b0) {
            }
            this.N = (!z12) | this.N;
            if (f12 <= DownloadProgress.UNKNOWN_PROGRESS) {
            }
            if (f12 >= 1.0d) {
            }
            if (this.N) {
            }
            invalidate();
            if (!this.N) {
            }
        }
        float f13 = this.f١٨٦٨o;
        if (f13 >= 1.0f) {
            int i14 = this.f١٨٥٠f;
            int i15 = this.f١٨٥٢g;
            if (i14 == i15) {
                z13 = z14;
            }
            this.f١٨٥٠f = i15;
        } else {
            if (f13 <= DownloadProgress.UNKNOWN_PROGRESS) {
                int i16 = this.f١٨٥٠f;
                int i17 = this.f١٨٤٨e;
                if (i16 == i17) {
                    z13 = z14;
                }
                this.f١٨٥٠f = i17;
            }
            this.f١٨٩١z0 |= z14;
            if (z14 && !this.f١٨٦١k0) {
                requestLayout();
            }
            this.f١٨٦٦n = this.f١٨٦٨o;
        }
        z14 = z13;
        this.f١٨٩١z0 |= z14;
        if (z14) {
            requestLayout();
        }
        this.f١٨٦٦n = this.f١٨٦٨o;
    }

    protected void V() {
        int i10;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.f١٨٨٠u != null || ((copyOnWriteArrayList = this.R) != null && !copyOnWriteArrayList.isEmpty())) && this.V == -1) {
            this.V = this.f١٨٥٠f;
            if (!this.D0.isEmpty()) {
                ArrayList arrayList = this.D0;
                i10 = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            } else {
                i10 = -1;
            }
            int i11 = this.f١٨٥٠f;
            if (i10 != i11 && i11 != -1) {
                this.D0.add(Integer.valueOf(i11));
            }
        }
        g0();
        Runnable runnable = this.f١٨٦٥m0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f١٨٦٧n0;
        if (iArr != null && this.f١٨٦٩o0 > 0) {
            q0(iArr[0]);
            int[] iArr2 = this.f١٨٦٧n0;
            System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
            this.f١٨٦٩o0--;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(int i10, float f10, float f11, float f12, float[] fArr) {
        String resourceName;
        HashMap hashMap = this.f١٨٦٠k;
        View viewById = getViewById(i10);
        m mVar = (m) hashMap.get(viewById);
        if (mVar != null) {
            mVar.l(f10, f11, f12, fArr);
            float y10 = viewById.getY();
            this.f١٨٨٢v = f10;
            this.f١٨٨٤w = y10;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i10;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i10);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    public androidx.constraintlayout.widget.c X(int i10) {
        p pVar = this.f١٨٤٠a;
        if (pVar == null) {
            return null;
        }
        return pVar.l(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m Y(int i10) {
        return (m) this.f١٨٦٠k.get(findViewById(i10));
    }

    public p.b Z(int i10) {
        return this.f١٨٤٠a.G(i10);
    }

    public void a0(View view, float f10, float f11, float[] fArr, int i10) {
        float f12;
        float f13 = this.f١٨٤٦d;
        float f14 = this.f١٨٦٨o;
        if (this.f١٨٤٢b != null) {
            float signum = Math.signum(this.f١٨٧٢q - f14);
            float interpolation = this.f١٨٤٢b.getInterpolation(this.f١٨٦٨o + 1.0E-5f);
            f12 = this.f١٨٤٢b.getInterpolation(this.f١٨٦٨o);
            f13 = (signum * ((interpolation - f12) / 1.0E-5f)) / this.f١٨٦٤m;
        } else {
            f12 = f14;
        }
        Interpolator interpolator = this.f١٨٤٢b;
        if (interpolator instanceof n) {
            f13 = ((n) interpolator).a();
        }
        m mVar = (m) this.f١٨٦٠k.get(view);
        if ((i10 & 1) == 0) {
            mVar.r(f12, view.getWidth(), view.getHeight(), f10, f11, fArr);
        } else {
            mVar.l(f12, f10, f11, fArr);
        }
        if (i10 < 2) {
            fArr[0] = fArr[0] * f13;
            fArr[1] = fArr[1] * f13;
        }
    }

    public boolean d0() {
        return this.f١٨٥٨j;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        String e10;
        t tVar;
        ArrayList arrayList = this.Q;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).B(canvas);
            }
        }
        S(false);
        p pVar = this.f١٨٤٠a;
        if (pVar != null && (tVar = pVar.f٢٠٨٤s) != null) {
            tVar.c();
        }
        super.dispatchDraw(canvas);
        if (this.f١٨٤٠a == null) {
            return;
        }
        if ((this.f١٨٨٦x & 1) == 1 && !isInEditMode()) {
            this.S++;
            long nanoTime = getNanoTime();
            long j10 = this.T;
            if (j10 != -1) {
                if (nanoTime - j10 > 200000000) {
                    this.U = ((int) ((this.S / (((float) r5) * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.S = 0;
                    this.T = nanoTime;
                }
            } else {
                this.T = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            String str = this.U + " fps " + androidx.constraintlayout.motion.widget.a.e(this, this.f١٨٤٨e) + " -> ";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(androidx.constraintlayout.motion.widget.a.e(this, this.f١٨٥٢g));
            sb.append(" (progress: ");
            sb.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb.append(" ) state=");
            int i10 = this.f١٨٥٠f;
            if (i10 == -1) {
                e10 = "undefined";
            } else {
                e10 = androidx.constraintlayout.motion.widget.a.e(this, i10);
            }
            sb.append(e10);
            String sb2 = sb.toString();
            paint.setColor(-16777216);
            canvas.drawText(sb2, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb2, 10.0f, getHeight() - 30, paint);
        }
        if (this.f١٨٨٦x > 1) {
            if (this.f١٨٨٨y == null) {
                this.f١٨٨٨y = new f();
            }
            this.f١٨٨٨y.a(canvas, this.f١٨٦٠k, this.f١٨٤٠a.p(), this.f١٨٨٦x);
        }
        ArrayList arrayList2 = this.Q;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((MotionHelper) it2.next()).A(canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h e0() {
        return i.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f0() {
        p pVar = this.f١٨٤٠a;
        if (pVar == null) {
            return;
        }
        if (pVar.h(this, this.f١٨٥٠f)) {
            requestLayout();
            return;
        }
        int i10 = this.f١٨٥٠f;
        if (i10 != -1) {
            this.f١٨٤٠a.f(this, i10);
        }
        if (this.f١٨٤٠a.b0()) {
            this.f١٨٤٠a.Z();
        }
    }

    public int[] getConstraintSetIds() {
        p pVar = this.f١٨٤٠a;
        if (pVar == null) {
            return null;
        }
        return pVar.n();
    }

    public int getCurrentState() {
        return this.f١٨٥٠f;
    }

    public ArrayList<p.b> getDefinedTransitions() {
        p pVar = this.f١٨٤٠a;
        if (pVar == null) {
            return null;
        }
        return pVar.o();
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.C == null) {
            this.C = new androidx.constraintlayout.motion.widget.b(this);
        }
        return this.C;
    }

    public int getEndState() {
        return this.f١٨٥٢g;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f١٨٦٨o;
    }

    public p getScene() {
        return this.f١٨٤٠a;
    }

    public int getStartState() {
        return this.f١٨٤٨e;
    }

    public float getTargetPosition() {
        return this.f١٨٧٢q;
    }

    public Bundle getTransitionState() {
        if (this.f١٨٦٣l0 == null) {
            this.f١٨٦٣l0 = new j();
        }
        this.f١٨٦٣l0.c();
        return this.f١٨٦٣l0.b();
    }

    public long getTransitionTimeMs() {
        if (this.f١٨٤٠a != null) {
            this.f١٨٦٤m = r0.p() / 1000.0f;
        }
        return this.f١٨٦٤m * 1000.0f;
    }

    public float getVelocity() {
        return this.f١٨٤٦d;
    }

    public void h0() {
        this.f١٨٨٩y0.h();
        invalidate();
    }

    public void i0(float f10, float f11) {
        if (!isAttachedToWindow()) {
            if (this.f١٨٦٣l0 == null) {
                this.f١٨٦٣l0 = new j();
            }
            this.f١٨٦٣l0.e(f10);
            this.f١٨٦٣l0.h(f11);
            return;
        }
        setProgress(f10);
        setState(l.MOVING);
        this.f١٨٤٦d = f11;
        float f12 = 1.0f;
        if (f11 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (f11 <= DownloadProgress.UNKNOWN_PROGRESS) {
                f12 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            K(f12);
        } else if (f10 != DownloadProgress.UNKNOWN_PROGRESS && f10 != 1.0f) {
            if (f10 <= 0.5f) {
                f12 = DownloadProgress.UNKNOWN_PROGRESS;
            }
            K(f12);
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public void j0(int i10, int i11) {
        if (!isAttachedToWindow()) {
            if (this.f١٨٦٣l0 == null) {
                this.f١٨٦٣l0 = new j();
            }
            this.f١٨٦٣l0.f(i10);
            this.f١٨٦٣l0.d(i11);
            return;
        }
        p pVar = this.f١٨٤٠a;
        if (pVar != null) {
            this.f١٨٤٨e = i10;
            this.f١٨٥٢g = i11;
            pVar.X(i10, i11);
            this.f١٨٨٩y0.e(this.mLayoutWidget, this.f١٨٤٠a.l(i10), this.f١٨٤٠a.l(i11));
            h0();
            this.f١٨٦٨o = DownloadProgress.UNKNOWN_PROGRESS;
            p0();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i10) {
        int rotation;
        p.b bVar;
        if (i10 != 0) {
            try {
                p pVar = new p(getContext(), this, i10);
                this.f١٨٤٠a = pVar;
                if (this.f١٨٥٠f == -1) {
                    this.f١٨٥٠f = pVar.F();
                    this.f١٨٤٨e = this.f١٨٤٠a.F();
                    this.f١٨٥٢g = this.f١٨٤٠a.q();
                }
                if (isAttachedToWindow()) {
                    try {
                        Display display = getDisplay();
                        if (display == null) {
                            rotation = 0;
                        } else {
                            rotation = display.getRotation();
                        }
                        this.f١٨٨١u0 = rotation;
                        p pVar2 = this.f١٨٤٠a;
                        if (pVar2 != null) {
                            androidx.constraintlayout.widget.c l10 = pVar2.l(this.f١٨٥٠f);
                            this.f١٨٤٠a.T(this);
                            ArrayList arrayList = this.Q;
                            if (arrayList != null) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((MotionHelper) it.next()).z(this);
                                }
                            }
                            if (l10 != null) {
                                l10.i(this);
                            }
                            this.f١٨٤٨e = this.f١٨٥٠f;
                        }
                        f0();
                        j jVar = this.f١٨٦٣l0;
                        if (jVar != null) {
                            if (this.f١٨٨٥w0) {
                                post(new a());
                                return;
                            } else {
                                jVar.a();
                                return;
                            }
                        }
                        p pVar3 = this.f١٨٤٠a;
                        if (pVar3 != null && (bVar = pVar3.f٢٠٦٨c) != null && bVar.x() == 4) {
                            n0();
                            setState(l.SETUP);
                            setState(l.MOVING);
                            return;
                        }
                        return;
                    } catch (Exception e10) {
                        throw new IllegalArgumentException("unable to parse MotionScene file", e10);
                    }
                }
                this.f١٨٤٠a = null;
                return;
            } catch (Exception e11) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e11);
            }
        }
        this.f١٨٤٠a = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (r10 != 7) goto L٣٦;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m0(int i10, float f10, float f11) {
        if (this.f١٨٤٠a == null || this.f١٨٦٨o == f10) {
            return;
        }
        this.f١٨٩٠z = true;
        this.f١٨٦٢l = getNanoTime();
        this.f١٨٦٤m = this.f١٨٤٠a.p() / 1000.0f;
        this.f١٨٧٢q = f10;
        this.f١٨٧٦s = true;
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            if (i10 != 4) {
                if (i10 != 5) {
                    if (i10 != 6) {
                    }
                } else if (v0(f11, this.f١٨٦٨o, this.f١٨٤٠a.u())) {
                    this.f١٨٣٩B.b(f11, this.f١٨٦٨o, this.f١٨٤٠a.u());
                    this.f١٨٤٢b = this.f١٨٣٩B;
                } else {
                    this.A.b(this.f١٨٦٨o, f10, f11, this.f١٨٦٤m, this.f١٨٤٠a.u(), this.f١٨٤٠a.v());
                    this.f١٨٤٦d = DownloadProgress.UNKNOWN_PROGRESS;
                    int i11 = this.f١٨٥٠f;
                    this.f١٨٧٢q = f10;
                    this.f١٨٥٠f = i11;
                    this.f١٨٤٢b = this.A;
                }
            } else {
                this.f١٨٣٩B.b(f11, this.f١٨٦٨o, this.f١٨٤٠a.u());
                this.f١٨٤٢b = this.f١٨٣٩B;
            }
            this.f١٨٧٤r = false;
            this.f١٨٦٢l = getNanoTime();
            invalidate();
        }
        if (i10 != 1 && i10 != 7) {
            if (i10 == 2 || i10 == 6) {
                f10 = 1.0f;
            }
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (this.f١٨٤٠a.k() == 0) {
            this.A.b(this.f١٨٦٨o, f10, f11, this.f١٨٦٤m, this.f١٨٤٠a.u(), this.f١٨٤٠a.v());
        } else {
            this.A.d(this.f١٨٦٨o, f10, f11, this.f١٨٤٠a.B(), this.f١٨٤٠a.C(), this.f١٨٤٠a.A(), this.f١٨٤٠a.D(), this.f١٨٤٠a.z());
        }
        int i12 = this.f١٨٥٠f;
        this.f١٨٧٢q = f10;
        this.f١٨٥٠f = i12;
        this.f١٨٤٢b = this.A;
        this.f١٨٧٤r = false;
        this.f١٨٦٢l = getNanoTime();
        invalidate();
    }

    public void n0() {
        K(1.0f);
        this.f١٨٦٥m0 = null;
    }

    public void o0(Runnable runnable) {
        K(1.0f);
        this.f١٨٦٥m0 = runnable;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        p.b bVar;
        int i10;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.f١٨٨١u0 = display.getRotation();
        }
        p pVar = this.f١٨٤٠a;
        if (pVar != null && (i10 = this.f١٨٥٠f) != -1) {
            androidx.constraintlayout.widget.c l10 = pVar.l(i10);
            this.f١٨٤٠a.T(this);
            ArrayList arrayList = this.Q;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((MotionHelper) it.next()).z(this);
                }
            }
            if (l10 != null) {
                l10.i(this);
            }
            this.f١٨٤٨e = this.f١٨٥٠f;
        }
        f0();
        j jVar = this.f١٨٦٣l0;
        if (jVar != null) {
            if (this.f١٨٨٥w0) {
                post(new c());
                return;
            } else {
                jVar.a();
                return;
            }
        }
        p pVar2 = this.f١٨٤٠a;
        if (pVar2 != null && (bVar = pVar2.f٢٠٦٨c) != null && bVar.x() == 4) {
            n0();
            setState(l.SETUP);
            setState(l.MOVING);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        q B2;
        int q10;
        RectF p10;
        p pVar = this.f١٨٤٠a;
        if (pVar != null && this.f١٨٥٨j) {
            t tVar = pVar.f٢٠٨٤s;
            if (tVar != null) {
                tVar.h(motionEvent);
            }
            p.b bVar = this.f١٨٤٠a.f٢٠٦٨c;
            if (bVar != null && bVar.C() && (B2 = bVar.B()) != null && ((motionEvent.getAction() != 0 || (p10 = B2.p(this, new RectF())) == null || p10.contains(motionEvent.getX(), motionEvent.getY())) && (q10 = B2.q()) != -1)) {
                View view = this.B0;
                if (view == null || view.getId() != q10) {
                    this.B0 = findViewById(q10);
                }
                if (this.B0 != null) {
                    this.A0.set(r0.getLeft(), this.B0.getTop(), this.B0.getRight(), this.B0.getBottom());
                    if (this.A0.contains(motionEvent.getX(), motionEvent.getY()) && !b0(this.B0.getLeft(), this.B0.getTop(), this.B0, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f١٨٦١k0 = true;
        try {
            if (this.f١٨٤٠a == null) {
                super.onLayout(z10, i10, i11, i12, i13);
                return;
            }
            int i14 = i12 - i10;
            int i15 = i13 - i11;
            if (this.G != i14 || this.H != i15) {
                h0();
                S(true);
            }
            this.G = i14;
            this.H = i15;
            this.E = i14;
            this.F = i15;
        } finally {
            this.f١٨٦١k0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        boolean z10;
        if (this.f١٨٤٠a == null) {
            super.onMeasure(i10, i11);
            return;
        }
        boolean z11 = false;
        if (this.f١٨٥٤h == i10 && this.f١٨٥٦i == i11) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.f١٨٩١z0) {
            this.f١٨٩١z0 = false;
            f0();
            g0();
            z10 = true;
        }
        if (this.mDirtyHierarchy) {
            z10 = true;
        }
        this.f١٨٥٤h = i10;
        this.f١٨٥٦i = i11;
        int F = this.f١٨٤٠a.F();
        int q10 = this.f١٨٤٠a.q();
        if ((z10 || this.f١٨٨٩y0.f(F, q10)) && this.f١٨٤٨e != -1) {
            super.onMeasure(i10, i11);
            this.f١٨٨٩y0.e(this.mLayoutWidget, this.f١٨٤٠a.l(F), this.f١٨٤٠a.l(q10));
            this.f١٨٨٩y0.h();
            this.f١٨٨٩y0.i(F, q10);
        } else {
            if (z10) {
                super.onMeasure(i10, i11);
            }
            z11 = true;
        }
        if (this.f١٨٤٣b0 || z11) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int Y = this.mLayoutWidget.Y() + getPaddingLeft() + getPaddingRight();
            int z12 = this.mLayoutWidget.z() + paddingTop;
            int i12 = this.f١٨٥٣g0;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                Y = (int) (this.f١٨٤٥c0 + (this.f١٨٥٧i0 * (this.f١٨٤٩e0 - r8)));
                requestLayout();
            }
            int i13 = this.f١٨٥٥h0;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                z12 = (int) (this.f١٨٤٧d0 + (this.f١٨٥٧i0 * (this.f١٨٥١f0 - r8)));
                requestLayout();
            }
            setMeasuredDimension(Y, z12);
        }
        T();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // androidx.core.view.f0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        p.b bVar;
        q B2;
        int q10;
        p pVar = this.f١٨٤٠a;
        if (pVar != null && (bVar = pVar.f٢٠٦٨c) != null && bVar.C()) {
            int i13 = -1;
            if (bVar.C() && (B2 = bVar.B()) != null && (q10 = B2.q()) != -1 && view.getId() != q10) {
                return;
            }
            if (pVar.w()) {
                q B3 = bVar.B();
                if (B3 != null && (B3.e() & 4) != 0) {
                    i13 = i11;
                }
                float f10 = this.f١٨٦٦n;
                if ((f10 == 1.0f || f10 == DownloadProgress.UNKNOWN_PROGRESS) && view.canScrollVertically(i13)) {
                    return;
                }
            }
            if (bVar.B() != null && (bVar.B().e() & 1) != 0) {
                float x10 = pVar.x(i10, i11);
                float f11 = this.f١٨٦٨o;
                if ((f11 <= DownloadProgress.UNKNOWN_PROGRESS && x10 < DownloadProgress.UNKNOWN_PROGRESS) || (f11 >= 1.0f && x10 > DownloadProgress.UNKNOWN_PROGRESS)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new b(this, view));
                    return;
                }
            }
            float f12 = this.f١٨٦٦n;
            long nanoTime = getNanoTime();
            float f13 = i10;
            this.J = f13;
            float f14 = i11;
            this.K = f14;
            this.M = (float) ((nanoTime - this.L) * 1.0E-9d);
            this.L = nanoTime;
            pVar.P(f13, f14);
            if (f12 != this.f١٨٦٦n) {
                iArr[0] = i10;
                iArr[1] = i11;
            }
            S(false);
            if (iArr[0] != 0 || iArr[1] != 0) {
                this.I = true;
            }
        }
    }

    @Override // androidx.core.view.f0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    @Override // androidx.core.view.f0
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        this.L = getNanoTime();
        this.M = DownloadProgress.UNKNOWN_PROGRESS;
        this.J = DownloadProgress.UNKNOWN_PROGRESS;
        this.K = DownloadProgress.UNKNOWN_PROGRESS;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        p pVar = this.f١٨٤٠a;
        if (pVar != null) {
            pVar.W(isRtl());
        }
    }

    @Override // androidx.core.view.f0
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        p.b bVar;
        p pVar = this.f١٨٤٠a;
        if (pVar != null && (bVar = pVar.f٢٠٦٨c) != null && bVar.B() != null && (this.f١٨٤٠a.f٢٠٦٨c.B().e() & 2) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.f0
    public void onStopNestedScroll(View view, int i10) {
        p pVar = this.f١٨٤٠a;
        if (pVar != null) {
            float f10 = this.M;
            if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
                pVar.Q(this.J / f10, this.K / f10);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p pVar = this.f١٨٤٠a;
        if (pVar != null && this.f١٨٥٨j && pVar.b0()) {
            p.b bVar = this.f١٨٤٠a.f٢٠٦٨c;
            if (bVar != null && !bVar.C()) {
                return super.onTouchEvent(motionEvent);
            }
            this.f١٨٤٠a.R(motionEvent, getCurrentState(), this);
            if (this.f١٨٤٠a.f٢٠٦٨c.D(4)) {
                return this.f١٨٤٠a.f٢٠٦٨c.B().r();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.R == null) {
                this.R = new CopyOnWriteArrayList();
            }
            this.R.add(motionHelper);
            if (motionHelper.y()) {
                if (this.O == null) {
                    this.O = new ArrayList();
                }
                this.O.add(motionHelper);
            }
            if (motionHelper.x()) {
                if (this.P == null) {
                    this.P = new ArrayList();
                }
                this.P.add(motionHelper);
            }
            if (motionHelper.w()) {
                if (this.Q == null) {
                    this.Q = new ArrayList();
                }
                this.Q.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.P;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void p0() {
        K(DownloadProgress.UNKNOWN_PROGRESS);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void parseLayoutDescription(int i10) {
        this.mConstraintLayoutSpec = null;
    }

    public void q0(int i10) {
        if (!isAttachedToWindow()) {
            if (this.f١٨٦٣l0 == null) {
                this.f١٨٦٣l0 = new j();
            }
            this.f١٨٦٣l0.d(i10);
            return;
        }
        r0(i10, -1, -1);
    }

    public void r0(int i10, int i11, int i12) {
        s0(i10, i11, i12, -1);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        p pVar;
        p.b bVar;
        if (!this.f١٨٤٣b0 && this.f١٨٥٠f == -1 && (pVar = this.f١٨٤٠a) != null && (bVar = pVar.f٢٠٦٨c) != null) {
            int z10 = bVar.z();
            if (z10 == 0) {
                return;
            }
            if (z10 == 2) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    ((m) this.f١٨٦٠k.get(getChildAt(i10))).z();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public void s0(int i10, int i11, int i12, int i13) {
        androidx.constraintlayout.widget.f fVar;
        int a10;
        p pVar = this.f١٨٤٠a;
        if (pVar != null && (fVar = pVar.f٢٠٦٧b) != null && (a10 = fVar.a(this.f١٨٥٠f, i10, i11, i12)) != -1) {
            i10 = a10;
        }
        int i14 = this.f١٨٥٠f;
        if (i14 == i10) {
            return;
        }
        if (this.f١٨٤٨e == i10) {
            K(DownloadProgress.UNKNOWN_PROGRESS);
            if (i13 > 0) {
                this.f١٨٦٤m = i13 / 1000.0f;
                return;
            }
            return;
        }
        if (this.f١٨٥٢g == i10) {
            K(1.0f);
            if (i13 > 0) {
                this.f١٨٦٤m = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.f١٨٥٢g = i10;
        if (i14 != -1) {
            j0(i14, i10);
            K(1.0f);
            this.f١٨٦٨o = DownloadProgress.UNKNOWN_PROGRESS;
            n0();
            if (i13 > 0) {
                this.f١٨٦٤m = i13 / 1000.0f;
                return;
            }
            return;
        }
        this.f١٨٩٠z = false;
        this.f١٨٧٢q = 1.0f;
        this.f١٨٦٦n = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٦٨o = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٧٠p = getNanoTime();
        this.f١٨٦٢l = getNanoTime();
        this.f١٨٧٤r = false;
        this.f١٨٤٢b = null;
        if (i13 == -1) {
            this.f١٨٦٤m = this.f١٨٤٠a.p() / 1000.0f;
        }
        this.f١٨٤٨e = -1;
        this.f١٨٤٠a.X(-1, this.f١٨٥٢g);
        SparseArray sparseArray = new SparseArray();
        if (i13 == 0) {
            this.f١٨٦٤m = this.f١٨٤٠a.p() / 1000.0f;
        } else if (i13 > 0) {
            this.f١٨٦٤m = i13 / 1000.0f;
        }
        int childCount = getChildCount();
        this.f١٨٦٠k.clear();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            this.f١٨٦٠k.put(childAt, new m(childAt));
            sparseArray.put(childAt.getId(), (m) this.f١٨٦٠k.get(childAt));
        }
        this.f١٨٧٦s = true;
        this.f١٨٨٩y0.e(this.mLayoutWidget, null, this.f١٨٤٠a.l(i10));
        h0();
        this.f١٨٨٩y0.a();
        Q();
        int width = getWidth();
        int height = getHeight();
        if (this.Q != null) {
            for (int i16 = 0; i16 < childCount; i16++) {
                m mVar = (m) this.f١٨٦٠k.get(getChildAt(i16));
                if (mVar != null) {
                    this.f١٨٤٠a.t(mVar);
                }
            }
            Iterator it = this.Q.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).C(this, this.f١٨٦٠k);
            }
            for (int i17 = 0; i17 < childCount; i17++) {
                m mVar2 = (m) this.f١٨٦٠k.get(getChildAt(i17));
                if (mVar2 != null) {
                    mVar2.I(width, height, this.f١٨٦٤m, getNanoTime());
                }
            }
        } else {
            for (int i18 = 0; i18 < childCount; i18++) {
                m mVar3 = (m) this.f١٨٦٠k.get(getChildAt(i18));
                if (mVar3 != null) {
                    this.f١٨٤٠a.t(mVar3);
                    mVar3.I(width, height, this.f١٨٦٤m, getNanoTime());
                }
            }
        }
        float E = this.f١٨٤٠a.E();
        if (E != DownloadProgress.UNKNOWN_PROGRESS) {
            float f10 = Float.MAX_VALUE;
            float f11 = -3.4028235E38f;
            for (int i19 = 0; i19 < childCount; i19++) {
                m mVar4 = (m) this.f١٨٦٠k.get(getChildAt(i19));
                float o10 = mVar4.o() + mVar4.n();
                f10 = Math.min(f10, o10);
                f11 = Math.max(f11, o10);
            }
            for (int i20 = 0; i20 < childCount; i20++) {
                m mVar5 = (m) this.f١٨٦٠k.get(getChildAt(i20));
                float n10 = mVar5.n();
                float o11 = mVar5.o();
                mVar5.f٢٠٣٣o = 1.0f / (1.0f - E);
                mVar5.f٢٠٣٢n = E - ((((n10 + o11) - f10) * E) / (f11 - f10));
            }
        }
        this.f١٨٦٦n = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٦٨o = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٧٦s = true;
        invalidate();
    }

    public void setDebugMode(int i10) {
        this.f١٨٨٦x = i10;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z10) {
        this.f١٨٨٥w0 = z10;
    }

    public void setInteractionEnabled(boolean z10) {
        this.f١٨٥٨j = z10;
    }

    public void setInterpolatedProgress(float f10) {
        if (this.f١٨٤٠a != null) {
            setState(l.MOVING);
            Interpolator s10 = this.f١٨٤٠a.s();
            if (s10 != null) {
                setProgress(s10.getInterpolation(f10));
                return;
            }
        }
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList arrayList = this.P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((MotionHelper) this.P.get(i10)).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((MotionHelper) this.O.get(i10)).setProgress(f10);
            }
        }
    }

    public void setProgress(float f10) {
        if (f10 < DownloadProgress.UNKNOWN_PROGRESS || f10 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f١٨٦٣l0 == null) {
                this.f١٨٦٣l0 = new j();
            }
            this.f١٨٦٣l0.e(f10);
            return;
        }
        if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f١٨٦٨o == 1.0f && this.f١٨٥٠f == this.f١٨٥٢g) {
                setState(l.MOVING);
            }
            this.f١٨٥٠f = this.f١٨٤٨e;
            if (this.f١٨٦٨o == DownloadProgress.UNKNOWN_PROGRESS) {
                setState(l.FINISHED);
            }
        } else if (f10 >= 1.0f) {
            if (this.f١٨٦٨o == DownloadProgress.UNKNOWN_PROGRESS && this.f١٨٥٠f == this.f١٨٤٨e) {
                setState(l.MOVING);
            }
            this.f١٨٥٠f = this.f١٨٥٢g;
            if (this.f١٨٦٨o == 1.0f) {
                setState(l.FINISHED);
            }
        } else {
            this.f١٨٥٠f = -1;
            setState(l.MOVING);
        }
        if (this.f١٨٤٠a == null) {
            return;
        }
        this.f١٨٧٤r = true;
        this.f١٨٧٢q = f10;
        this.f١٨٦٦n = f10;
        this.f١٨٧٠p = -1L;
        this.f١٨٦٢l = -1L;
        this.f١٨٤٢b = null;
        this.f١٨٧٦s = true;
        invalidate();
    }

    public void setScene(p pVar) {
        this.f١٨٤٠a = pVar;
        pVar.W(isRtl());
        h0();
    }

    void setStartState(int i10) {
        if (!isAttachedToWindow()) {
            if (this.f١٨٦٣l0 == null) {
                this.f١٨٦٣l0 = new j();
            }
            this.f١٨٦٣l0.f(i10);
            this.f١٨٦٣l0.d(i10);
            return;
        }
        this.f١٨٥٠f = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(l lVar) {
        l lVar2 = l.FINISHED;
        if (lVar == lVar2 && this.f١٨٥٠f == -1) {
            return;
        }
        l lVar3 = this.f١٨٨٧x0;
        this.f١٨٨٧x0 = lVar;
        l lVar4 = l.MOVING;
        if (lVar3 == lVar4 && lVar == lVar4) {
            U();
        }
        int i10 = d.f١٨٩٥a[lVar3.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 == 3 && lVar == lVar2) {
                V();
                return;
            }
            return;
        }
        if (lVar == lVar4) {
            U();
        }
        if (lVar == lVar2) {
            V();
        }
    }

    public void setTransition(int i10) {
        float f10;
        if (this.f١٨٤٠a != null) {
            p.b Z = Z(i10);
            this.f١٨٤٨e = Z.A();
            this.f١٨٥٢g = Z.y();
            if (!isAttachedToWindow()) {
                if (this.f١٨٦٣l0 == null) {
                    this.f١٨٦٣l0 = new j();
                }
                this.f١٨٦٣l0.f(this.f١٨٤٨e);
                this.f١٨٦٣l0.d(this.f١٨٥٢g);
                return;
            }
            int i11 = this.f١٨٥٠f;
            int i12 = this.f١٨٤٨e;
            float f11 = DownloadProgress.UNKNOWN_PROGRESS;
            if (i11 == i12) {
                f10 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                f10 = i11 == this.f١٨٥٢g ? 1.0f : Float.NaN;
            }
            this.f١٨٤٠a.Y(Z);
            this.f١٨٨٩y0.e(this.mLayoutWidget, this.f١٨٤٠a.l(this.f١٨٤٨e), this.f١٨٤٠a.l(this.f١٨٥٢g));
            h0();
            if (this.f١٨٦٨o != f10) {
                if (f10 == DownloadProgress.UNKNOWN_PROGRESS) {
                    R(true);
                    this.f١٨٤٠a.l(this.f١٨٤٨e).i(this);
                } else if (f10 == 1.0f) {
                    R(false);
                    this.f١٨٤٠a.l(this.f١٨٥٢g).i(this);
                }
            }
            if (!Float.isNaN(f10)) {
                f11 = f10;
            }
            this.f١٨٦٨o = f11;
            if (Float.isNaN(f10)) {
                Log.v("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + " transitionToStart ");
                p0();
                return;
            }
            setProgress(f10);
        }
    }

    public void setTransitionDuration(int i10) {
        p pVar = this.f١٨٤٠a;
        if (pVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            pVar.V(i10);
        }
    }

    public void setTransitionListener(k kVar) {
        this.f١٨٨٠u = kVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f١٨٦٣l0 == null) {
            this.f١٨٦٣l0 = new j();
        }
        this.f١٨٦٣l0.g(bundle);
        if (isAttachedToWindow()) {
            this.f١٨٦٣l0.a();
        }
    }

    public void t0() {
        this.f١٨٨٩y0.e(this.mLayoutWidget, this.f١٨٤٠a.l(this.f١٨٤٨e), this.f١٨٤٠a.l(this.f١٨٥٢g));
        h0();
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.constraintlayout.motion.widget.a.c(context, this.f١٨٤٨e) + "->" + androidx.constraintlayout.motion.widget.a.c(context, this.f١٨٥٢g) + " (pos:" + this.f١٨٦٨o + " Dpos/Dt:" + this.f١٨٤٦d;
    }

    public void u0(int i10, androidx.constraintlayout.widget.c cVar) {
        p pVar = this.f١٨٤٠a;
        if (pVar != null) {
            pVar.U(i10, cVar);
        }
        t0();
        if (this.f١٨٥٠f == i10) {
            cVar.i(this);
        }
    }

    @Override // androidx.core.view.g0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (this.I || i10 != 0 || i11 != 0) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
        }
        this.I = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i10, int i11, int i12) {
        setState(l.SETUP);
        this.f١٨٥٠f = i10;
        this.f١٨٤٨e = -1;
        this.f١٨٥٢g = -1;
        androidx.constraintlayout.widget.b bVar = this.mConstraintLayoutSpec;
        if (bVar != null) {
            bVar.d(i10, i11, i12);
            return;
        }
        p pVar = this.f١٨٤٠a;
        if (pVar != null) {
            pVar.l(i10).i(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTransition(p.b bVar) {
        this.f١٨٤٠a.Y(bVar);
        setState(l.SETUP);
        if (this.f١٨٥٠f == this.f١٨٤٠a.q()) {
            this.f١٨٦٨o = 1.0f;
            this.f١٨٦٦n = 1.0f;
            this.f١٨٧٢q = 1.0f;
        } else {
            this.f١٨٦٨o = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٨٦٦n = DownloadProgress.UNKNOWN_PROGRESS;
            this.f١٨٧٢q = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f١٨٧٠p = bVar.D(1) ? -1L : getNanoTime();
        int F = this.f١٨٤٠a.F();
        int q10 = this.f١٨٤٠a.q();
        if (F == this.f١٨٤٨e && q10 == this.f١٨٥٢g) {
            return;
        }
        this.f١٨٤٨e = F;
        this.f١٨٥٢g = q10;
        this.f١٨٤٠a.X(F, q10);
        this.f١٨٨٩y0.e(this.mLayoutWidget, this.f١٨٤٠a.l(this.f١٨٤٨e), this.f١٨٤٠a.l(this.f١٨٥٢g));
        this.f١٨٨٩y0.i(this.f١٨٤٨e, this.f١٨٥٢g);
        this.f١٨٨٩y0.h();
        h0();
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٨٤٤c = null;
        this.f١٨٤٦d = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٤٨e = -1;
        this.f١٨٥٠f = -1;
        this.f١٨٥٢g = -1;
        this.f١٨٥٤h = 0;
        this.f١٨٥٦i = 0;
        this.f١٨٥٨j = true;
        this.f١٨٦٠k = new HashMap();
        this.f١٨٦٢l = 0L;
        this.f١٨٦٤m = 1.0f;
        this.f١٨٦٦n = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٦٨o = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٧٢q = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٧٦s = false;
        this.f١٨٧٨t = false;
        this.f١٨٨٦x = 0;
        this.f١٨٩٠z = false;
        this.A = new e2.b();
        this.f١٨٣٩B = new e();
        this.D = true;
        this.I = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.T = -1L;
        this.U = DownloadProgress.UNKNOWN_PROGRESS;
        this.V = 0;
        this.W = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٤١a0 = false;
        this.f١٨٤٣b0 = false;
        this.f١٨٥٩j0 = new a2.d();
        this.f١٨٦١k0 = false;
        this.f١٨٦٥m0 = null;
        this.f١٨٦٧n0 = null;
        this.f١٨٦٩o0 = 0;
        this.f١٨٧١p0 = false;
        this.f١٨٧٣q0 = 0;
        this.f١٨٧٥r0 = new HashMap();
        this.f١٨٨٣v0 = new Rect();
        this.f١٨٨٥w0 = false;
        this.f١٨٨٧x0 = l.UNDEFINED;
        this.f١٨٨٩y0 = new g();
        this.f١٨٩١z0 = false;
        this.A0 = new RectF();
        this.B0 = null;
        this.C0 = null;
        this.D0 = new ArrayList();
        c0(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٨٤٤c = null;
        this.f١٨٤٦d = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٤٨e = -1;
        this.f١٨٥٠f = -1;
        this.f١٨٥٢g = -1;
        this.f١٨٥٤h = 0;
        this.f١٨٥٦i = 0;
        this.f١٨٥٨j = true;
        this.f١٨٦٠k = new HashMap();
        this.f١٨٦٢l = 0L;
        this.f١٨٦٤m = 1.0f;
        this.f١٨٦٦n = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٦٨o = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٧٢q = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٧٦s = false;
        this.f١٨٧٨t = false;
        this.f١٨٨٦x = 0;
        this.f١٨٩٠z = false;
        this.A = new e2.b();
        this.f١٨٣٩B = new e();
        this.D = true;
        this.I = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.T = -1L;
        this.U = DownloadProgress.UNKNOWN_PROGRESS;
        this.V = 0;
        this.W = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٤١a0 = false;
        this.f١٨٤٣b0 = false;
        this.f١٨٥٩j0 = new a2.d();
        this.f١٨٦١k0 = false;
        this.f١٨٦٥m0 = null;
        this.f١٨٦٧n0 = null;
        this.f١٨٦٩o0 = 0;
        this.f١٨٧١p0 = false;
        this.f١٨٧٣q0 = 0;
        this.f١٨٧٥r0 = new HashMap();
        this.f١٨٨٣v0 = new Rect();
        this.f١٨٨٥w0 = false;
        this.f١٨٨٧x0 = l.UNDEFINED;
        this.f١٨٨٩y0 = new g();
        this.f١٨٩١z0 = false;
        this.A0 = new RectF();
        this.B0 = null;
        this.C0 = null;
        this.D0 = new ArrayList();
        c0(attributeSet);
    }
}
