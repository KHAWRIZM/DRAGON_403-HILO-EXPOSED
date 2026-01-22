package o3;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f extends g {
    public f(List list) {
        super(list);
    }

    public int q() {
        return r(b(), d());
    }

    int r(y3.a aVar, float f10) {
        Integer num;
        if (aVar.f١٩١١٧b != null && aVar.f١٩١١٨c != null) {
            y3.c cVar = this.f١٦٤٧٥e;
            if (cVar != null && (num = (Integer) cVar.b(aVar.f١٩١٢٢g, aVar.f١٩١٢٣h.floatValue(), (Integer) aVar.f١٩١١٧b, (Integer) aVar.f١٩١١٨c, f10, e(), f())) != null) {
                return num.intValue();
            }
            return x3.k.j(aVar.h(), aVar.e(), f10);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // o3.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer i(y3.a aVar, float f10) {
        return Integer.valueOf(r(aVar, f10));
    }
}
