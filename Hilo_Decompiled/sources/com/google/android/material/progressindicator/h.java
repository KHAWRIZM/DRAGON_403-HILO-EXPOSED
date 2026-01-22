package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class h {

    /* renamed from: a, reason: collision with root package name */
    com.google.android.material.progressindicator.a f٩٦٨٢a;

    /* renamed from: b, reason: collision with root package name */
    final Path f٩٦٨٣b;

    /* renamed from: c, reason: collision with root package name */
    final Path f٩٦٨٤c;

    /* renamed from: d, reason: collision with root package name */
    final PathMeasure f٩٦٨٥d;

    /* renamed from: e, reason: collision with root package name */
    final Matrix f٩٦٨٦e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    protected static class a {

        /* renamed from: a, reason: collision with root package name */
        float f٩٦٨٧a;

        /* renamed from: b, reason: collision with root package name */
        float f٩٦٨٨b;

        /* renamed from: c, reason: collision with root package name */
        int f٩٦٨٩c;

        /* renamed from: d, reason: collision with root package name */
        int f٩٦٩٠d;

        /* renamed from: e, reason: collision with root package name */
        float f٩٦٩١e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        float f٩٦٩٢f;

        /* renamed from: g, reason: collision with root package name */
        float f٩٦٩٣g;

        /* renamed from: h, reason: collision with root package name */
        boolean f٩٦٩٤h;
    }

    public h(com.google.android.material.progressindicator.a aVar) {
        Path path = new Path();
        this.f٩٦٨٣b = path;
        this.f٩٦٨٤c = new Path();
        this.f٩٦٨٥d = new PathMeasure(path, false);
        this.f٩٦٨٢a = aVar;
        this.f٩٦٨٦e = new Matrix();
    }

    abstract void a(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Canvas canvas, Paint paint, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Canvas canvas, Paint paint, a aVar, int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11) {
        this.f٩٦٨٢a.h();
        a(canvas, rect, f10, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i(float[] fArr) {
        return (float) Math.toDegrees(Math.atan2(fArr[1], fArr[0]));
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    protected class b {

        /* renamed from: a, reason: collision with root package name */
        float[] f٩٦٩٥a;

        /* renamed from: b, reason: collision with root package name */
        float[] f٩٦٩٦b;

        /* renamed from: c, reason: collision with root package name */
        final Matrix f٩٦٩٧c;

        public b() {
            this.f٩٦٩٥a = new float[2];
            this.f٩٦٩٦b = r3;
            float[] fArr = {1.0f};
            this.f٩٦٩٧c = new Matrix();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(float f10) {
            float[] fArr = this.f٩٦٩٦b;
            float atan2 = (float) (Math.atan2(fArr[1], fArr[0]) + 1.5707963267948966d);
            double d10 = f10;
            double d11 = atan2;
            this.f٩٦٩٥a[0] = (float) (r2[0] + (Math.cos(d11) * d10));
            this.f٩٦٩٥a[1] = (float) (r14[1] + (d10 * Math.sin(d11)));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(float f10) {
            float[] fArr = this.f٩٦٩٦b;
            float atan2 = (float) Math.atan2(fArr[1], fArr[0]);
            double d10 = f10;
            double d11 = atan2;
            this.f٩٦٩٥a[0] = (float) (r2[0] + (Math.cos(d11) * d10));
            this.f٩٦٩٥a[1] = (float) (r14[1] + (d10 * Math.sin(d11)));
        }

        public void c() {
            Arrays.fill(this.f٩٦٩٥a, DownloadProgress.UNKNOWN_PROGRESS);
            Arrays.fill(this.f٩٦٩٦b, DownloadProgress.UNKNOWN_PROGRESS);
            this.f٩٦٩٦b[0] = 1.0f;
            this.f٩٦٩٧c.reset();
        }

        public void d(float f10) {
            this.f٩٦٩٧c.reset();
            this.f٩٦٩٧c.setRotate(f10);
            this.f٩٦٩٧c.mapPoints(this.f٩٦٩٥a);
            this.f٩٦٩٧c.mapPoints(this.f٩٦٩٦b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(float f10, float f11) {
            float[] fArr = this.f٩٦٩٥a;
            fArr[0] = fArr[0] * f10;
            fArr[1] = fArr[1] * f11;
            float[] fArr2 = this.f٩٦٩٦b;
            fArr2[0] = fArr2[0] * f10;
            fArr2[1] = fArr2[1] * f11;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(float f10, float f11) {
            float[] fArr = this.f٩٦٩٥a;
            fArr[0] = fArr[0] + f10;
            fArr[1] = fArr[1] + f11;
        }

        public b(h hVar, b bVar) {
            this(bVar.f٩٦٩٥a, bVar.f٩٦٩٦b);
        }

        public b(float[] fArr, float[] fArr2) {
            float[] fArr3 = new float[2];
            this.f٩٦٩٥a = fArr3;
            this.f٩٦٩٦b = new float[2];
            System.arraycopy(fArr, 0, fArr3, 0, 2);
            System.arraycopy(fArr2, 0, this.f٩٦٩٦b, 0, 2);
            this.f٩٦٩٧c = new Matrix();
        }
    }
}
