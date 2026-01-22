package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import com.google.android.material.progressindicator.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class k extends h {

    /* renamed from: f, reason: collision with root package name */
    private float f٩٧٠٤f;

    /* renamed from: g, reason: collision with root package name */
    private float f٩٧٠٥g;

    /* renamed from: h, reason: collision with root package name */
    private float f٩٧٠٦h;

    /* renamed from: i, reason: collision with root package name */
    private float f٩٧٠٧i;

    /* renamed from: j, reason: collision with root package name */
    private float f٩٧٠٨j;

    /* renamed from: k, reason: collision with root package name */
    private float f٩٧٠٩k;

    /* renamed from: l, reason: collision with root package name */
    private int f٩٧١٠l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٩٧١١m;

    /* renamed from: n, reason: collision with root package name */
    private float f٩٧١٢n;

    /* renamed from: o, reason: collision with root package name */
    Pair f٩٧١٣o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(n nVar) {
        super(nVar);
        this.f٩٧٠٤f = 300.0f;
        this.f٩٧١٣o = new Pair(new h.b(), new h.b());
    }

    private void j(PathMeasure pathMeasure, Path path, Pair pair, float f10, float f11, float f12, float f13) {
        int i10;
        if (this.f٩٧١١m) {
            i10 = ((n) this.f٩٦٨٢a).f٩٦٠١j;
        } else {
            i10 = ((n) this.f٩٦٨٢a).f٩٦٠٢k;
        }
        if (pathMeasure == this.f٩٦٨٥d && i10 != this.f٩٧١٠l) {
            this.f٩٧١٠l = i10;
            g();
        }
        path.rewind();
        float f14 = (-this.f٩٧٠٤f) / 2.0f;
        boolean b10 = ((n) this.f٩٦٨٢a).b(this.f٩٧١١m);
        if (b10) {
            float f15 = this.f٩٧٠٤f;
            float f16 = this.f٩٧٠٩k;
            float f17 = f15 / f16;
            float f18 = f13 / f17;
            float f19 = f17 / (f17 + 1.0f);
            f10 = (f10 + f18) * f19;
            f11 = (f11 + f18) * f19;
            f14 -= f13 * f16;
        }
        float length = f10 * pathMeasure.getLength();
        float length2 = f11 * pathMeasure.getLength();
        pathMeasure.getSegment(length, length2, path, true);
        h.b bVar = (h.b) pair.first;
        bVar.c();
        pathMeasure.getPosTan(length, bVar.f٩٦٩٥a, bVar.f٩٦٩٦b);
        h.b bVar2 = (h.b) pair.second;
        bVar2.c();
        pathMeasure.getPosTan(length2, bVar2.f٩٦٩٥a, bVar2.f٩٦٩٦b);
        this.f٩٦٨٦e.reset();
        this.f٩٦٨٦e.setTranslate(f14, DownloadProgress.UNKNOWN_PROGRESS);
        bVar.f(f14, DownloadProgress.UNKNOWN_PROGRESS);
        bVar2.f(f14, DownloadProgress.UNKNOWN_PROGRESS);
        if (b10) {
            float f20 = this.f٩٧٠٨j * f12;
            this.f٩٦٨٦e.postScale(1.0f, f20);
            bVar.e(1.0f, f20);
            bVar2.e(1.0f, f20);
        }
        path.transform(this.f٩٦٨٦e);
    }

    private void k(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12, float f12, float f13, boolean z10) {
        float f14;
        float f15;
        boolean z11;
        Paint.Cap cap;
        float a10 = j2.a.a(f10, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        float a11 = j2.a.a(f11, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        float f16 = z7.a.f(1.0f - this.f٩٧١٢n, 1.0f, a10);
        float f17 = z7.a.f(1.0f - this.f٩٧١٢n, 1.0f, a11);
        int a12 = (int) ((i11 * j2.a.a(f16, DownloadProgress.UNKNOWN_PROGRESS, 0.01f)) / 0.01f);
        int a13 = (int) ((i12 * (1.0f - j2.a.a(f17, 0.99f, 1.0f))) / 0.01f);
        float f18 = this.f٩٧٠٤f;
        int i13 = (int) ((f16 * f18) + a12);
        int i14 = (int) ((f17 * f18) - a13);
        float f19 = this.f٩٧٠٦h;
        float f20 = this.f٩٧٠٧i;
        if (f19 != f20) {
            float max = Math.max(f19, f20);
            float f21 = this.f٩٧٠٤f;
            float f22 = max / f21;
            float f23 = z7.a.f(this.f٩٧٠٦h, this.f٩٧٠٧i, j2.a.a(i13 / f21, DownloadProgress.UNKNOWN_PROGRESS, f22) / f22);
            float f24 = this.f٩٧٠٦h;
            float f25 = this.f٩٧٠٧i;
            float f26 = this.f٩٧٠٤f;
            f15 = z7.a.f(f24, f25, j2.a.a((f26 - i14) / f26, DownloadProgress.UNKNOWN_PROGRESS, f22) / f22);
            f14 = f23;
        } else {
            f14 = f19;
            f15 = f14;
        }
        float f27 = (-this.f٩٧٠٤f) / 2.0f;
        if (((n) this.f٩٦٨٢a).b(this.f٩٧١١m) && z10 && f12 > DownloadProgress.UNKNOWN_PROGRESS) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i13 <= i14) {
            float f28 = i13 + f14;
            float f29 = i14 - f15;
            float f30 = f14 * 2.0f;
            float f31 = f15 * 2.0f;
            paint.setColor(i10);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.f٩٧٠٥g);
            ((h.b) this.f٩٧١٣o.first).c();
            ((h.b) this.f٩٧١٣o.second).c();
            ((h.b) this.f٩٧١٣o.first).f(f28 + f27, DownloadProgress.UNKNOWN_PROGRESS);
            ((h.b) this.f٩٧١٣o.second).f(f27 + f29, DownloadProgress.UNKNOWN_PROGRESS);
            if (i13 == 0 && f29 + f15 < f28 + f14) {
                Pair pair = this.f٩٧١٣o;
                h.b bVar = (h.b) pair.first;
                float f32 = this.f٩٧٠٥g;
                m(canvas, paint, bVar, f30, f32, f14, (h.b) pair.second, f31, f32, f15, true);
                return;
            }
            if (f28 - f14 > f29 - f15) {
                Pair pair2 = this.f٩٧١٣o;
                h.b bVar2 = (h.b) pair2.second;
                float f33 = this.f٩٧٠٥g;
                m(canvas, paint, bVar2, f31, f33, f15, (h.b) pair2.first, f30, f33, f14, false);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            if (((n) this.f٩٦٨٢a).g()) {
                cap = Paint.Cap.ROUND;
            } else {
                cap = Paint.Cap.BUTT;
            }
            paint.setStrokeCap(cap);
            if (!z11) {
                Pair pair3 = this.f٩٧١٣o;
                Object obj = pair3.first;
                float f34 = ((h.b) obj).f٩٦٩٥a[0];
                float f35 = ((h.b) obj).f٩٦٩٥a[1];
                Object obj2 = pair3.second;
                canvas.drawLine(f34, f35, ((h.b) obj2).f٩٦٩٥a[0], ((h.b) obj2).f٩٦٩٥a[1], paint);
            } else {
                PathMeasure pathMeasure = this.f٩٦٨٥d;
                Path path = this.f٩٦٨٤c;
                Pair pair4 = this.f٩٧١٣o;
                float f36 = this.f٩٧٠٤f;
                j(pathMeasure, path, pair4, f28 / f36, f29 / f36, f12, f13);
                canvas.drawPath(this.f٩٦٨٤c, paint);
            }
            if (!((n) this.f٩٦٨٢a).g()) {
                if (f28 > DownloadProgress.UNKNOWN_PROGRESS && f14 > DownloadProgress.UNKNOWN_PROGRESS) {
                    l(canvas, paint, (h.b) this.f٩٧١٣o.first, f30, this.f٩٧٠٥g, f14);
                }
                if (f29 < this.f٩٧٠٤f && f15 > DownloadProgress.UNKNOWN_PROGRESS) {
                    l(canvas, paint, (h.b) this.f٩٧١٣o.second, f31, this.f٩٧٠٥g, f15);
                }
            }
        }
    }

    private void l(Canvas canvas, Paint paint, h.b bVar, float f10, float f11, float f12) {
        m(canvas, paint, bVar, f10, f11, f12, null, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, false);
    }

    private void m(Canvas canvas, Paint paint, h.b bVar, float f10, float f11, float f12, h.b bVar2, float f13, float f14, float f15, boolean z10) {
        float f16;
        float f17;
        float f18;
        float min = Math.min(f11, this.f٩٧٠٥g);
        float f19 = (-f10) / 2.0f;
        float f20 = (-min) / 2.0f;
        float f21 = f10 / 2.0f;
        float f22 = min / 2.0f;
        RectF rectF = new RectF(f19, f20, f21, f22);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (bVar2 != null) {
            float min2 = Math.min(f14, this.f٩٧٠٥g);
            float min3 = Math.min(f13 / 2.0f, (f15 * min2) / this.f٩٧٠٥g);
            RectF rectF2 = new RectF();
            if (z10) {
                float f23 = (bVar2.f٩٦٩٥a[0] - min3) - (bVar.f٩٦٩٥a[0] - f12);
                if (f23 > DownloadProgress.UNKNOWN_PROGRESS) {
                    bVar2.f((-f23) / 2.0f, DownloadProgress.UNKNOWN_PROGRESS);
                    f18 = f13 + f23;
                } else {
                    f18 = f13;
                }
                rectF2.set(DownloadProgress.UNKNOWN_PROGRESS, f20, f21, f22);
                f16 = 2.0f;
            } else {
                float f24 = (bVar2.f٩٦٩٥a[0] + min3) - (bVar.f٩٦٩٥a[0] + f12);
                if (f24 < DownloadProgress.UNKNOWN_PROGRESS) {
                    f16 = 2.0f;
                    bVar2.f((-f24) / 2.0f, DownloadProgress.UNKNOWN_PROGRESS);
                    f17 = f13 - f24;
                } else {
                    f16 = 2.0f;
                    f17 = f13;
                }
                rectF2.set(f19, f20, DownloadProgress.UNKNOWN_PROGRESS, f22);
                f18 = f17;
            }
            RectF rectF3 = new RectF((-f18) / f16, (-min2) / f16, f18 / f16, min2 / f16);
            float[] fArr = bVar2.f٩٦٩٥a;
            canvas.translate(fArr[0], fArr[1]);
            canvas.rotate(i(bVar2.f٩٦٩٦b));
            Path path = new Path();
            path.addRoundRect(rectF3, min3, min3, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.rotate(-i(bVar2.f٩٦٩٦b));
            float[] fArr2 = bVar2.f٩٦٩٥a;
            canvas.translate(-fArr2[0], -fArr2[1]);
            float[] fArr3 = bVar.f٩٦٩٥a;
            canvas.translate(fArr3[0], fArr3[1]);
            canvas.rotate(i(bVar.f٩٦٩٦b));
            canvas.drawRect(rectF2, paint);
            canvas.drawRoundRect(rectF, f12, f12, paint);
        } else {
            float[] fArr4 = bVar.f٩٦٩٥a;
            canvas.translate(fArr4[0], fArr4[1]);
            canvas.rotate(i(bVar.f٩٦٩٦b));
            canvas.drawRoundRect(rectF, f12, f12, paint);
        }
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.h
    void a(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11) {
        if (this.f٩٧٠٤f != rect.width()) {
            this.f٩٧٠٤f = rect.width();
            g();
        }
        float e10 = e();
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(DownloadProgress.UNKNOWN_PROGRESS, (rect.height() - e10) / 2.0f));
        if (((n) this.f٩٦٨٢a).f٩٧٣٧q) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f11 = this.f٩٧٠٤f / 2.0f;
        float f12 = e10 / 2.0f;
        canvas.clipRect(-f11, -f12, f11, f12);
        a aVar = this.f٩٦٨٢a;
        this.f٩٧٠٥g = ((n) aVar).f٩٥٩٢a * f10;
        this.f٩٧٠٦h = Math.min(((n) aVar).f٩٥٩٢a / 2, ((n) aVar).a()) * f10;
        a aVar2 = this.f٩٦٨٢a;
        this.f٩٧٠٨j = ((n) aVar2).f٩٦٠٣l * f10;
        this.f٩٧٠٧i = Math.min(((n) aVar2).f٩٥٩٢a / 2.0f, ((n) aVar2).i()) * f10;
        if (z10 || z11) {
            if ((z10 && ((n) this.f٩٦٨٢a).f٩٥٩٨g == 2) || (z11 && ((n) this.f٩٦٨٢a).f٩٥٩٩h == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z10 || (z11 && ((n) this.f٩٦٨٢a).f٩٥٩٩h != 3)) {
                canvas.translate(DownloadProgress.UNKNOWN_PROGRESS, (((n) this.f٩٦٨٢a).f٩٥٩٢a * (1.0f - f10)) / 2.0f);
            }
        }
        if (z11 && ((n) this.f٩٦٨٢a).f٩٥٩٩h == 3) {
            this.f٩٧١٢n = f10;
        } else {
            this.f٩٧١٢n = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void b(Canvas canvas, Paint paint, int i10, int i11) {
        float f10;
        int a10 = v7.a.a(i10, i11);
        this.f٩٧١١m = false;
        if (((n) this.f٩٦٨٢a).f٩٧٣٨r > 0 && a10 != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(a10);
            a aVar = this.f٩٦٨٢a;
            if (((n) aVar).f٩٧٣٩s != null) {
                f10 = ((n) aVar).f٩٧٣٩s.floatValue() + (((n) this.f٩٦٨٢a).f٩٧٣٨r / 2.0f);
            } else {
                f10 = this.f٩٧٠٥g / 2.0f;
            }
            h.b bVar = new h.b(new float[]{(this.f٩٧٠٤f / 2.0f) - f10, DownloadProgress.UNKNOWN_PROGRESS}, new float[]{1.0f, DownloadProgress.UNKNOWN_PROGRESS});
            a aVar2 = this.f٩٦٨٢a;
            l(canvas, paint, bVar, ((n) aVar2).f٩٧٣٨r, ((n) aVar2).f٩٧٣٨r, (this.f٩٧٠٦h * ((n) aVar2).f٩٧٣٨r) / this.f٩٧٠٥g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void c(Canvas canvas, Paint paint, h.a aVar, int i10) {
        int a10 = v7.a.a(aVar.f٩٦٨٩c, i10);
        this.f٩٧١١m = aVar.f٩٦٩٤h;
        float f10 = aVar.f٩٦٨٧a;
        float f11 = aVar.f٩٦٨٨b;
        int i11 = aVar.f٩٦٩٠d;
        k(canvas, paint, f10, f11, a10, i11, i11, aVar.f٩٦٩١e, aVar.f٩٦٩٢f, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void d(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12) {
        int a10 = v7.a.a(i10, i11);
        this.f٩٧١١m = false;
        k(canvas, paint, f10, f11, a10, i12, i12, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public int e() {
        a aVar = this.f٩٦٨٢a;
        return ((n) aVar).f٩٥٩٢a + (((n) aVar).f٩٦٠٣l * 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public int f() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void g() {
        int i10;
        this.f٩٦٨٣b.rewind();
        if (((n) this.f٩٦٨٢a).b(this.f٩٧١١m)) {
            if (this.f٩٧١١m) {
                i10 = ((n) this.f٩٦٨٢a).f٩٦٠١j;
            } else {
                i10 = ((n) this.f٩٦٨٢a).f٩٦٠٢k;
            }
            float f10 = this.f٩٧٠٤f;
            int i11 = (int) (f10 / i10);
            this.f٩٧٠٩k = f10 / i11;
            for (int i12 = 0; i12 <= i11; i12++) {
                int i13 = i12 * 2;
                float f11 = i13 + 1;
                this.f٩٦٨٣b.cubicTo(i13 + 0.48f, DownloadProgress.UNKNOWN_PROGRESS, f11 - 0.48f, 1.0f, f11, 1.0f);
                float f12 = i13 + 2;
                this.f٩٦٨٣b.cubicTo(f11 + 0.48f, 1.0f, f12 - 0.48f, DownloadProgress.UNKNOWN_PROGRESS, f12, DownloadProgress.UNKNOWN_PROGRESS);
            }
            this.f٩٦٨٦e.reset();
            this.f٩٦٨٦e.setScale(this.f٩٧٠٩k / 2.0f, -2.0f);
            this.f٩٦٨٦e.postTranslate(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٦٨٣b.transform(this.f٩٦٨٦e);
        } else {
            this.f٩٦٨٣b.lineTo(this.f٩٧٠٤f, DownloadProgress.UNKNOWN_PROGRESS);
        }
        this.f٩٦٨٥d.setPath(this.f٩٦٨٣b, false);
    }
}
