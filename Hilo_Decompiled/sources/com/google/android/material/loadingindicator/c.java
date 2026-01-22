package com.google.android.material.loadingindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.graphics.shapes.Morph;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.Shapes_androidKt;
import f8.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static final RoundedPolygon[] f٩٣٨٩d;

    /* renamed from: e, reason: collision with root package name */
    private static final Morph[] f٩٣٩٠e;

    /* renamed from: a, reason: collision with root package name */
    d f٩٣٩١a;

    /* renamed from: b, reason: collision with root package name */
    final Path f٩٣٩٢b = new Path();

    /* renamed from: c, reason: collision with root package name */
    final Matrix f٩٣٩٣c = new Matrix();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f٩٣٩٤a;

        /* renamed from: b, reason: collision with root package name */
        float f٩٣٩٥b;

        /* renamed from: c, reason: collision with root package name */
        float f٩٣٩٦c;
    }

    static {
        int i10 = 0;
        RoundedPolygon[] roundedPolygonArr = {k.Q(k.E, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), k.Q(k.f١٤١٧٠y, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), k.Q(k.f١٤١٦٣r, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), k.Q(k.f١٤١٥٩n, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), k.Q(k.f١٤١٦٥t, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), k.Q(k.f١٤١٦٧v, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), k.Q(k.f١٤١٥٨m, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f))};
        f٩٣٨٩d = roundedPolygonArr;
        f٩٣٩٠e = new Morph[roundedPolygonArr.length];
        while (true) {
            RoundedPolygon[] roundedPolygonArr2 = f٩٣٨٩d;
            if (i10 < roundedPolygonArr2.length) {
                int i11 = i10 + 1;
                f٩٣٩٠e[i10] = new Morph(roundedPolygonArr2[i10], roundedPolygonArr2[i11 % roundedPolygonArr2.length]);
                i10 = i11;
            } else {
                return;
            }
        }
    }

    public c(d dVar) {
        this.f٩٣٩١a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect) {
        canvas.translate(rect.centerX(), rect.centerY());
        if (this.f٩٣٩١a.f٩٣٩٧a) {
            float min = Math.min(rect.width() / e(), rect.height() / d());
            canvas.scale(min, min);
        }
        canvas.clipRect((-e()) / 2.0f, (-d()) / 2.0f, e() / 2.0f, d() / 2.0f);
        canvas.rotate(-90.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Canvas canvas, Paint paint, int i10, int i11) {
        d dVar = this.f٩٣٩١a;
        float min = Math.min(dVar.f٩٣٩٩c, dVar.f٩٤٠٠d) / 2.0f;
        paint.setColor(v7.a.a(i10, i11));
        paint.setStyle(Paint.Style.FILL);
        d dVar2 = this.f٩٣٩١a;
        canvas.drawRoundRect(new RectF((-r2) / 2.0f, (-r9) / 2.0f, dVar2.f٩٣٩٩c / 2.0f, dVar2.f٩٤٠٠d / 2.0f), min, min, paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Canvas canvas, Paint paint, a aVar, int i10) {
        paint.setColor(v7.a.a(aVar.f٩٣٩٤a, i10));
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        canvas.rotate(aVar.f٩٣٩٦c);
        this.f٩٣٩٢b.rewind();
        int floor = (int) Math.floor(aVar.f٩٣٩٥b);
        Morph[] morphArr = f٩٣٩٠e;
        Shapes_androidKt.toPath(morphArr[z7.a.d(floor, morphArr.length)], aVar.f٩٣٩٥b - floor, this.f٩٣٩٢b);
        Matrix matrix = this.f٩٣٩٣c;
        int i11 = this.f٩٣٩١a.f٩٣٩٨b;
        matrix.setScale(i11 / 2.0f, i11 / 2.0f);
        this.f٩٣٩٢b.transform(this.f٩٣٩٣c);
        canvas.drawPath(this.f٩٣٩٢b, paint);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        d dVar = this.f٩٣٩١a;
        return Math.max(dVar.f٩٣٩٩c, dVar.f٩٣٩٨b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        d dVar = this.f٩٣٩١a;
        return Math.max(dVar.f٩٤٠٠d, dVar.f٩٣٩٨b);
    }
}
