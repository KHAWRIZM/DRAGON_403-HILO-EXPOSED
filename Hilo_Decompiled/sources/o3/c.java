package o3;

import android.graphics.Color;
import android.graphics.Paint;
import o3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private final a.b f١٦٤٨٥a;

    /* renamed from: b, reason: collision with root package name */
    private final o3.a f١٦٤٨٦b;

    /* renamed from: c, reason: collision with root package name */
    private final o3.a f١٦٤٨٧c;

    /* renamed from: d, reason: collision with root package name */
    private final o3.a f١٦٤٨٨d;

    /* renamed from: e, reason: collision with root package name */
    private final o3.a f١٦٤٨٩e;

    /* renamed from: f, reason: collision with root package name */
    private final o3.a f١٦٤٩٠f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٦٤٩١g = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends y3.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y3.c f١٦٤٩٢d;

        a(y3.c cVar) {
            this.f١٦٤٩٢d = cVar;
        }

        @Override // y3.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float a(y3.b bVar) {
            Float f10 = (Float) this.f١٦٤٩٢d.a(bVar);
            if (f10 == null) {
                return null;
            }
            return Float.valueOf(f10.floatValue() * 2.55f);
        }
    }

    public c(a.b bVar, t3.b bVar2, v3.j jVar) {
        this.f١٦٤٨٥a = bVar;
        o3.a a10 = jVar.a().a();
        this.f١٦٤٨٦b = a10;
        a10.a(this);
        bVar2.i(a10);
        o3.a a11 = jVar.d().a();
        this.f١٦٤٨٧c = a11;
        a11.a(this);
        bVar2.i(a11);
        o3.a a12 = jVar.b().a();
        this.f١٦٤٨٨d = a12;
        a12.a(this);
        bVar2.i(a12);
        o3.a a13 = jVar.c().a();
        this.f١٦٤٨٩e = a13;
        a13.a(this);
        bVar2.i(a13);
        o3.a a14 = jVar.e().a();
        this.f١٦٤٩٠f = a14;
        a14.a(this);
        bVar2.i(a14);
    }

    @Override // o3.a.b
    public void a() {
        this.f١٦٤٩١g = true;
        this.f١٦٤٨٥a.a();
    }

    public void b(Paint paint) {
        if (!this.f١٦٤٩١g) {
            return;
        }
        this.f١٦٤٩١g = false;
        double floatValue = ((Float) this.f١٦٤٨٨d.h()).floatValue() * 0.017453292519943295d;
        float floatValue2 = ((Float) this.f١٦٤٨٩e.h()).floatValue();
        float sin = ((float) Math.sin(floatValue)) * floatValue2;
        float cos = ((float) Math.cos(floatValue + 3.141592653589793d)) * floatValue2;
        int intValue = ((Integer) this.f١٦٤٨٦b.h()).intValue();
        paint.setShadowLayer(((Float) this.f١٦٤٩٠f.h()).floatValue(), sin, cos, Color.argb(Math.round(((Float) this.f١٦٤٨٧c.h()).floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
    }

    public void c(y3.c cVar) {
        this.f١٦٤٨٦b.o(cVar);
    }

    public void d(y3.c cVar) {
        this.f١٦٤٨٨d.o(cVar);
    }

    public void e(y3.c cVar) {
        this.f١٦٤٨٩e.o(cVar);
    }

    public void f(y3.c cVar) {
        if (cVar == null) {
            this.f١٦٤٨٧c.o(null);
        } else {
            this.f١٦٤٨٧c.o(new a(cVar));
        }
    }

    public void g(y3.c cVar) {
        this.f١٦٤٩٠f.o(cVar);
    }
}
