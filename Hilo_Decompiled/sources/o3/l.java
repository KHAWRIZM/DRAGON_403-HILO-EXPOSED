package o3;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class l extends g {

    /* renamed from: i, reason: collision with root package name */
    private final y3.d f١٦٥٠٦i;

    public l(List list) {
        super(list);
        this.f١٦٥٠٦i = new y3.d();
    }

    @Override // o3.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public y3.d i(y3.a aVar, float f10) {
        Object obj;
        y3.d dVar;
        Object obj2 = aVar.f١٩١١٧b;
        if (obj2 != null && (obj = aVar.f١٩١١٨c) != null) {
            y3.d dVar2 = (y3.d) obj2;
            y3.d dVar3 = (y3.d) obj;
            y3.c cVar = this.f١٦٤٧٥e;
            if (cVar != null && (dVar = (y3.d) cVar.b(aVar.f١٩١٢٢g, aVar.f١٩١٢٣h.floatValue(), dVar2, dVar3, f10, e(), f())) != null) {
                return dVar;
            }
            this.f١٦٥٠٦i.d(x3.k.i(dVar2.b(), dVar3.b(), f10), x3.k.i(dVar2.c(), dVar3.c(), f10));
            return this.f١٦٥٠٦i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
