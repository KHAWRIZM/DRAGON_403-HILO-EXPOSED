package o3;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class o extends g {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends y3.c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y3.b f١٦٥١٨d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ y3.c f١٦٥١٩e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ q3.b f١٦٥٢٠f;

        a(y3.b bVar, y3.c cVar, q3.b bVar2) {
            this.f١٦٥١٨d = bVar;
            this.f١٦٥١٩e = cVar;
            this.f١٦٥٢٠f = bVar2;
        }

        @Override // y3.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public q3.b a(y3.b bVar) {
            Object g10;
            this.f١٦٥١٨d.h(bVar.f(), bVar.a(), ((q3.b) bVar.g()).f١٧٠٨٧a, ((q3.b) bVar.b()).f١٧٠٨٧a, bVar.d(), bVar.c(), bVar.e());
            String str = (String) this.f١٦٥١٩e.a(this.f١٦٥١٨d);
            if (bVar.c() == 1.0f) {
                g10 = bVar.b();
            } else {
                g10 = bVar.g();
            }
            q3.b bVar2 = (q3.b) g10;
            this.f١٦٥٢٠f.a(str, bVar2.f١٧٠٨٨b, bVar2.f١٧٠٨٩c, bVar2.f١٧٠٩٠d, bVar2.f١٧٠٩١e, bVar2.f١٧٠٩٢f, bVar2.f١٧٠٩٣g, bVar2.f١٧٠٩٤h, bVar2.f١٧٠٩٥i, bVar2.f١٧٠٩٦j, bVar2.f١٧٠٩٧k, bVar2.f١٧٠٩٨l, bVar2.f١٧٠٩٩m);
            return this.f١٦٥٢٠f;
        }
    }

    public o(List list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // o3.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public q3.b i(y3.a aVar, float f10) {
        Object obj;
        float floatValue;
        q3.b bVar;
        y3.c cVar = this.f١٦٤٧٥e;
        if (cVar != null) {
            float f11 = aVar.f١٩١٢٢g;
            Float f12 = aVar.f١٩١٢٣h;
            if (f12 == null) {
                floatValue = Float.MAX_VALUE;
            } else {
                floatValue = f12.floatValue();
            }
            Object obj2 = aVar.f١٩١١٧b;
            q3.b bVar2 = (q3.b) obj2;
            Object obj3 = aVar.f١٩١١٨c;
            if (obj3 == null) {
                bVar = (q3.b) obj2;
            } else {
                bVar = (q3.b) obj3;
            }
            return (q3.b) cVar.b(f11, floatValue, bVar2, bVar, f10, d(), f());
        }
        if (f10 == 1.0f && (obj = aVar.f١٩١١٨c) != null) {
            return (q3.b) obj;
        }
        return (q3.b) aVar.f١٩١١٧b;
    }

    public void r(y3.c cVar) {
        super.o(new a(new y3.b(), cVar, new q3.b()));
    }
}
