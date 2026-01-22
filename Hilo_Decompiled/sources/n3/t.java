package n3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.j0;
import com.airbnb.lottie.n0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class t extends a {

    /* renamed from: r, reason: collision with root package name */
    private final t3.b f١٦٣٠٣r;

    /* renamed from: s, reason: collision with root package name */
    private final String f١٦٣٠٤s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f١٦٣٠٥t;

    /* renamed from: u, reason: collision with root package name */
    private final o3.a f١٦٣٠٦u;

    /* renamed from: v, reason: collision with root package name */
    private o3.a f١٦٣٠٧v;

    public t(j0 j0Var, t3.b bVar, s3.s sVar) {
        super(j0Var, bVar, sVar.b().c(), sVar.e().c(), sVar.g(), sVar.i(), sVar.j(), sVar.f(), sVar.d());
        this.f١٦٣٠٣r = bVar;
        this.f١٦٣٠٤s = sVar.h();
        this.f١٦٣٠٥t = sVar.k();
        o3.a a10 = sVar.c().a();
        this.f١٦٣٠٦u = a10;
        a10.a(this);
        bVar.i(a10);
    }

    @Override // n3.a, q3.f
    public void c(Object obj, y3.c cVar) {
        super.c(obj, cVar);
        if (obj == n0.f٦٢٤٦b) {
            this.f١٦٣٠٦u.o(cVar);
            return;
        }
        if (obj == n0.K) {
            o3.a aVar = this.f١٦٣٠٧v;
            if (aVar != null) {
                this.f١٦٣٠٣r.H(aVar);
            }
            if (cVar == null) {
                this.f١٦٣٠٧v = null;
                return;
            }
            o3.q qVar = new o3.q(cVar);
            this.f١٦٣٠٧v = qVar;
            qVar.a(this);
            this.f١٦٣٠٣r.i(this.f١٦٣٠٦u);
        }
    }

    @Override // n3.c
    public String getName() {
        return this.f١٦٣٠٤s;
    }

    @Override // n3.a, n3.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        if (this.f١٦٣٠٥t) {
            return;
        }
        this.f١٦١٧٠i.setColor(((o3.b) this.f١٦٣٠٦u).q());
        o3.a aVar = this.f١٦٣٠٧v;
        if (aVar != null) {
            this.f١٦١٧٠i.setColorFilter((ColorFilter) aVar.h());
        }
        super.h(canvas, matrix, i10);
    }
}
