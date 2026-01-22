package i8;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import f8.o;
import f8.p;
import i8.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class h {

    /* renamed from: a, reason: collision with root package name */
    private final Path f١٤٧٠١a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Path f١٤٧٠٢b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f١٤٧٠٣c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final p f١٤٧٠٤d = p.l();

    /* renamed from: e, reason: collision with root package name */
    private o f١٤٧٠٥e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f١٤٧٠١a);
        } else {
            canvas.clipPath(this.f١٤٧٠٢b);
            canvas.clipPath(this.f١٤٧٠٣c, Region.Op.UNION);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f10, o oVar, o oVar2, RectF rectF, RectF rectF2, RectF rectF3, j.c cVar) {
        o q10 = n.q(oVar, oVar2, rectF, rectF3, cVar.d(), cVar.c(), f10);
        this.f١٤٧٠٥e = q10;
        this.f١٤٧٠٤d.d(q10, 1.0f, rectF2, this.f١٤٧٠٢b);
        this.f١٤٧٠٤d.d(this.f١٤٧٠٥e, 1.0f, rectF3, this.f١٤٧٠٣c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f١٤٧٠١a.op(this.f١٤٧٠٢b, this.f١٤٧٠٣c, Path.Op.UNION);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o c() {
        return this.f١٤٧٠٥e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path d() {
        return this.f١٤٧٠١a;
    }
}
