package s4;

import f5.l;
import java.util.HashMap;
import q4.h;
import s4.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final h f١٧٨٧٢a;

    /* renamed from: b, reason: collision with root package name */
    private final p4.d f١٧٨٧٣b;

    /* renamed from: c, reason: collision with root package name */
    private final m4.b f١٧٨٧٤c;

    /* renamed from: d, reason: collision with root package name */
    private a f١٧٨٧٥d;

    public b(h hVar, p4.d dVar, m4.b bVar) {
        this.f١٧٨٧٢a = hVar;
        this.f١٧٨٧٣b = dVar;
        this.f١٧٨٧٤c = bVar;
    }

    c a(d... dVarArr) {
        this.f١٧٨٧٢a.e();
        this.f١٧٨٧٢a.d();
        this.f١٧٨٧٣b.e();
        if (dVarArr.length <= 0) {
            HashMap hashMap = new HashMap();
            if (dVarArr.length <= 0) {
                return new c(hashMap);
            }
            d dVar = dVarArr[0];
            throw null;
        }
        d dVar2 = dVarArr[0];
        throw null;
    }

    public void b(d.a... aVarArr) {
        a aVar = this.f١٧٨٧٥d;
        if (aVar != null) {
            aVar.b();
        }
        d[] dVarArr = new d[aVarArr.length];
        if (aVarArr.length <= 0) {
            a aVar2 = new a(this.f١٧٨٧٣b, this.f١٧٨٧٢a, a(dVarArr));
            this.f١٧٨٧٥d = aVar2;
            l.w(aVar2);
            return;
        }
        d.a aVar3 = aVarArr[0];
        throw null;
    }
}
