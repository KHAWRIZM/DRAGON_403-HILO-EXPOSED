package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Pair;
import com.google.android.material.progressindicator.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b extends h {

    /* renamed from: f, reason: collision with root package name */
    private float f٩٦٠٦f;

    /* renamed from: g, reason: collision with root package name */
    private float f٩٦٠٧g;

    /* renamed from: h, reason: collision with root package name */
    private float f٩٦٠٨h;

    /* renamed from: i, reason: collision with root package name */
    private float f٩٦٠٩i;

    /* renamed from: j, reason: collision with root package name */
    private float f٩٦١٠j;

    /* renamed from: k, reason: collision with root package name */
    private float f٩٦١١k;

    /* renamed from: l, reason: collision with root package name */
    private int f٩٦١٢l;

    /* renamed from: m, reason: collision with root package name */
    private float f٩٦١٣m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f٩٦١٤n;

    /* renamed from: o, reason: collision with root package name */
    private float f٩٦١٥o;

    /* renamed from: p, reason: collision with root package name */
    private final RectF f٩٦١٦p;

    /* renamed from: q, reason: collision with root package name */
    private final Pair f٩٦١٧q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e eVar) {
        super(eVar);
        this.f٩٦١٦p = new RectF();
        this.f٩٦١٧q = new Pair(new h.b(), new h.b());
    }

    private void j(Path path, h.b bVar, h.b bVar2) {
        float f10 = (this.f٩٦١٠j / 2.0f) * 0.48f;
        h.b bVar3 = new h.b(this, bVar);
        h.b bVar4 = new h.b(this, bVar2);
        bVar3.b(f10);
        bVar4.b(-f10);
        float[] fArr = bVar3.f٩٦٩٥a;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float[] fArr2 = bVar4.f٩٦٩٥a;
        float f13 = fArr2[0];
        float f14 = fArr2[1];
        float[] fArr3 = bVar2.f٩٦٩٥a;
        path.cubicTo(f11, f12, f13, f14, fArr3[0], fArr3[1]);
    }

    private void k(PathMeasure pathMeasure, Path path, Pair pair, float f10, float f11, float f12, float f13) {
        int i10;
        float f14 = this.f٩٦٠٨h * f12;
        if (this.f٩٦١٤n) {
            i10 = ((e) this.f٩٦٨٢a).f٩٦٠١j;
        } else {
            i10 = ((e) this.f٩٦٨٢a).f٩٦٠٢k;
        }
        float f15 = this.f٩٦٠٩i;
        if (f15 != this.f٩٦١٣m || (pathMeasure == this.f٩٦٨٥d && (f14 != this.f٩٦١١k || i10 != this.f٩٦١٢l))) {
            this.f٩٦١١k = f14;
            this.f٩٦١٢l = i10;
            this.f٩٦١٣m = f15;
            g();
        }
        path.rewind();
        float f16 = DownloadProgress.UNKNOWN_PROGRESS;
        float a10 = j2.a.a(f11, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        if (((e) this.f٩٦٨٢a).b(this.f٩٦١٤n)) {
            float f17 = f13 / ((float) ((this.f٩٦٠٩i * 6.283185307179586d) / this.f٩٦١٠j));
            f10 += f17;
            f16 = DownloadProgress.UNKNOWN_PROGRESS - (f17 * 360.0f);
        }
        float f18 = f10 % 1.0f;
        float length = (pathMeasure.getLength() * f18) / 2.0f;
        float length2 = ((f18 + a10) * pathMeasure.getLength()) / 2.0f;
        pathMeasure.getSegment(length, length2, path, true);
        h.b bVar = (h.b) pair.first;
        bVar.c();
        pathMeasure.getPosTan(length, bVar.f٩٦٩٥a, bVar.f٩٦٩٦b);
        h.b bVar2 = (h.b) pair.second;
        bVar2.c();
        pathMeasure.getPosTan(length2, bVar2.f٩٦٩٥a, bVar2.f٩٦٩٦b);
        this.f٩٦٨٦e.reset();
        this.f٩٦٨٦e.setRotate(f16);
        bVar.d(f16);
        bVar2.d(f16);
        path.transform(this.f٩٦٨٦e);
    }

    private void l(PathMeasure pathMeasure, Path path, float f10) {
        int i10;
        path.rewind();
        float length = pathMeasure.getLength();
        if (this.f٩٦١٤n) {
            i10 = ((e) this.f٩٦٨٢a).f٩٦٠١j;
        } else {
            i10 = ((e) this.f٩٦٨٢a).f٩٦٠٢k;
        }
        int max = Math.max(3, (int) ((length / i10) / 2.0f)) * 2;
        this.f٩٦١٠j = length / max;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < max; i11++) {
            h.b bVar = new h.b();
            float f11 = i11;
            pathMeasure.getPosTan(this.f٩٦١٠j * f11, bVar.f٩٦٩٥a, bVar.f٩٦٩٦b);
            h.b bVar2 = new h.b();
            float f12 = this.f٩٦١٠j;
            pathMeasure.getPosTan((f11 * f12) + (f12 / 2.0f), bVar2.f٩٦٩٥a, bVar2.f٩٦٩٦b);
            arrayList.add(bVar);
            bVar2.a(f10 * 2.0f);
            arrayList.add(bVar2);
        }
        arrayList.add((h.b) arrayList.get(0));
        h.b bVar3 = (h.b) arrayList.get(0);
        float[] fArr = bVar3.f٩٦٩٥a;
        int i12 = 1;
        path.moveTo(fArr[0], fArr[1]);
        while (i12 < arrayList.size()) {
            h.b bVar4 = (h.b) arrayList.get(i12);
            j(path, bVar3, bVar4);
            i12++;
            bVar3 = bVar4;
        }
    }

    private void m(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12, float f12, float f13, boolean z10) {
        float f14;
        boolean z11;
        Paint.Cap cap;
        if (f11 >= f10) {
            f14 = f11 - f10;
        } else {
            f14 = (f11 + 1.0f) - f10;
        }
        float f15 = f10 % 1.0f;
        if (f15 < DownloadProgress.UNKNOWN_PROGRESS) {
            f15 += 1.0f;
        }
        float f16 = f15;
        if (this.f٩٦١٥o < 1.0f) {
            float f17 = f16 + f14;
            if (f17 > 1.0f) {
                m(canvas, paint, f16, 1.0f, i10, i11, 0, f12, f13, z10);
                m(canvas, paint, 1.0f, f17, i10, 0, i12, f12, f13, z10);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.f٩٦٠٧g / this.f٩٦٠٩i);
        float f18 = f14 - 0.99f;
        if (f18 >= DownloadProgress.UNKNOWN_PROGRESS) {
            float f19 = ((f18 * degrees) / 180.0f) / 0.01f;
            f14 += f19;
            if (!z10) {
                f16 -= f19 / 2.0f;
            }
        }
        float f20 = z7.a.f(1.0f - this.f٩٦١٥o, 1.0f, f16);
        float f21 = z7.a.f(DownloadProgress.UNKNOWN_PROGRESS, this.f٩٦١٥o, f14);
        float degrees2 = (float) Math.toDegrees(i11 / this.f٩٦٠٩i);
        float degrees3 = ((f21 * 360.0f) - degrees2) - ((float) Math.toDegrees(i12 / this.f٩٦٠٩i));
        float f22 = (f20 * 360.0f) + degrees2;
        if (degrees3 <= DownloadProgress.UNKNOWN_PROGRESS) {
            return;
        }
        if (((e) this.f٩٦٨٢a).b(this.f٩٦١٤n) && z10 && f12 > DownloadProgress.UNKNOWN_PROGRESS) {
            z11 = true;
        } else {
            z11 = false;
        }
        paint.setAntiAlias(true);
        paint.setColor(i10);
        paint.setStrokeWidth(this.f٩٦٠٦f);
        float f23 = this.f٩٦٠٧g * 2.0f;
        float f24 = degrees * 2.0f;
        if (degrees3 < f24) {
            float f25 = degrees3 / f24;
            float f26 = f22 + (degrees * f25);
            h.b bVar = new h.b();
            if (!z11) {
                bVar.d(f26 + 90.0f);
                bVar.a(-this.f٩٦٠٩i);
            } else {
                float length = ((f26 / 360.0f) * this.f٩٦٨٥d.getLength()) / 2.0f;
                float f27 = this.f٩٦٠٨h * f12;
                float f28 = this.f٩٦٠٩i;
                if (f28 != this.f٩٦١٣m || f27 != this.f٩٦١١k) {
                    this.f٩٦١١k = f27;
                    this.f٩٦١٣m = f28;
                    g();
                }
                this.f٩٦٨٥d.getPosTan(length, bVar.f٩٦٩٥a, bVar.f٩٦٩٦b);
            }
            paint.setStyle(Paint.Style.FILL);
            o(canvas, paint, bVar, f23, this.f٩٦٠٦f, f25);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        if (((e) this.f٩٦٨٢a).g()) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
        float f29 = f22 + degrees;
        float f30 = degrees3 - f24;
        ((h.b) this.f٩٦١٧q.first).c();
        ((h.b) this.f٩٦١٧q.second).c();
        if (!z11) {
            ((h.b) this.f٩٦١٧q.first).d(f29 + 90.0f);
            ((h.b) this.f٩٦١٧q.first).a(-this.f٩٦٠٩i);
            ((h.b) this.f٩٦١٧q.second).d(f29 + f30 + 90.0f);
            ((h.b) this.f٩٦١٧q.second).a(-this.f٩٦٠٩i);
            RectF rectF = this.f٩٦١٦p;
            float f31 = this.f٩٦٠٩i;
            rectF.set(-f31, -f31, f31, f31);
            canvas.drawArc(this.f٩٦١٦p, f29, f30, false, paint);
        } else {
            k(this.f٩٦٨٥d, this.f٩٦٨٤c, this.f٩٦١٧q, f29 / 360.0f, f30 / 360.0f, f12, f13);
            canvas.drawPath(this.f٩٦٨٤c, paint);
        }
        if (!((e) this.f٩٦٨٢a).g() && this.f٩٦٠٧g > DownloadProgress.UNKNOWN_PROGRESS) {
            paint.setStyle(Paint.Style.FILL);
            n(canvas, paint, (h.b) this.f٩٦١٧q.first, f23, this.f٩٦٠٦f);
            n(canvas, paint, (h.b) this.f٩٦١٧q.second, f23, this.f٩٦٠٦f);
        }
    }

    private void n(Canvas canvas, Paint paint, h.b bVar, float f10, float f11) {
        o(canvas, paint, bVar, f10, f11, 1.0f);
    }

    private void o(Canvas canvas, Paint paint, h.b bVar, float f10, float f11, float f12) {
        float min = Math.min(f11, this.f٩٦٠٦f);
        float f13 = f10 / 2.0f;
        float min2 = Math.min(f13, (this.f٩٦٠٧g * min) / this.f٩٦٠٦f);
        RectF rectF = new RectF((-f10) / 2.0f, (-min) / 2.0f, f13, min / 2.0f);
        canvas.save();
        float[] fArr = bVar.f٩٦٩٥a;
        canvas.translate(fArr[0], fArr[1]);
        canvas.rotate(i(bVar.f٩٦٩٦b));
        canvas.scale(f12, f12);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }

    private int p() {
        a aVar = this.f٩٦٨٢a;
        return ((e) aVar).f٩٦٤٩p + (((e) aVar).f٩٦٥٠q * 2);
    }

    @Override // com.google.android.material.progressindicator.h
    void a(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11) {
        float width = rect.width() / f();
        float height = rect.height() / e();
        a aVar = this.f٩٦٨٢a;
        float f11 = (((e) aVar).f٩٦٤٩p / 2.0f) + ((e) aVar).f٩٦٥٠q;
        canvas.translate((f11 * width) + rect.left, (f11 * height) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(width, height);
        if (((e) this.f٩٦٨٢a).f٩٦٥١r != 0) {
            canvas.scale(1.0f, -1.0f);
            if (Build.VERSION.SDK_INT == 29) {
                canvas.rotate(0.1f);
            }
        }
        float f12 = -f11;
        canvas.clipRect(f12, f12, f11, f11);
        a aVar2 = this.f٩٦٨٢a;
        this.f٩٦٠٦f = ((e) aVar2).f٩٥٩٢a * f10;
        this.f٩٦٠٧g = Math.min(((e) aVar2).f٩٥٩٢a / 2, ((e) aVar2).a()) * f10;
        a aVar3 = this.f٩٦٨٢a;
        this.f٩٦٠٨h = ((e) aVar3).f٩٦٠٣l * f10;
        float f13 = (((e) aVar3).f٩٦٤٩p - ((e) aVar3).f٩٥٩٢a) / 2.0f;
        this.f٩٦٠٩i = f13;
        if (z10 || z11) {
            float f14 = ((1.0f - f10) * ((e) aVar3).f٩٥٩٢a) / 2.0f;
            if ((z10 && ((e) aVar3).f٩٥٩٨g == 2) || (z11 && ((e) aVar3).f٩٥٩٩h == 1)) {
                this.f٩٦٠٩i = f13 + f14;
            } else if ((z10 && ((e) aVar3).f٩٥٩٨g == 1) || (z11 && ((e) aVar3).f٩٥٩٩h == 2)) {
                this.f٩٦٠٩i = f13 - f14;
            }
        }
        if (z11 && ((e) aVar3).f٩٥٩٩h == 3) {
            this.f٩٦١٥o = f10;
        } else {
            this.f٩٦١٥o = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void b(Canvas canvas, Paint paint, int i10, int i11) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void c(Canvas canvas, Paint paint, h.a aVar, int i10) {
        int a10 = v7.a.a(aVar.f٩٦٨٩c, i10);
        canvas.save();
        canvas.rotate(aVar.f٩٦٩٣g);
        this.f٩٦١٤n = aVar.f٩٦٩٤h;
        float f10 = aVar.f٩٦٨٧a;
        float f11 = aVar.f٩٦٨٨b;
        int i11 = aVar.f٩٦٩٠d;
        m(canvas, paint, f10, f11, a10, i11, i11, aVar.f٩٦٩١e, aVar.f٩٦٩٢f, true);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void d(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12) {
        int a10 = v7.a.a(i10, i11);
        this.f٩٦١٤n = false;
        m(canvas, paint, f10, f11, a10, i12, i12, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public int e() {
        return p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public int f() {
        return p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.h
    public void g() {
        this.f٩٦٨٣b.rewind();
        this.f٩٦٨٣b.moveTo(1.0f, DownloadProgress.UNKNOWN_PROGRESS);
        for (int i10 = 0; i10 < 2; i10++) {
            this.f٩٦٨٣b.cubicTo(1.0f, 0.5522848f, 0.5522848f, 1.0f, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٦٨٣b.cubicTo(-0.5522848f, 1.0f, -1.0f, 0.5522848f, -1.0f, DownloadProgress.UNKNOWN_PROGRESS);
            this.f٩٦٨٣b.cubicTo(-1.0f, -0.5522848f, -0.5522848f, -1.0f, DownloadProgress.UNKNOWN_PROGRESS, -1.0f);
            this.f٩٦٨٣b.cubicTo(0.5522848f, -1.0f, 1.0f, -0.5522848f, 1.0f, DownloadProgress.UNKNOWN_PROGRESS);
        }
        this.f٩٦٨٦e.reset();
        Matrix matrix = this.f٩٦٨٦e;
        float f10 = this.f٩٦٠٩i;
        matrix.setScale(f10, f10);
        this.f٩٦٨٣b.transform(this.f٩٦٨٦e);
        if (((e) this.f٩٦٨٢a).b(this.f٩٦١٤n)) {
            this.f٩٦٨٥d.setPath(this.f٩٦٨٣b, false);
            l(this.f٩٦٨٥d, this.f٩٦٨٣b, this.f٩٦١١k);
        }
        this.f٩٦٨٥d.setPath(this.f٩٦٨٣b, false);
    }
}
