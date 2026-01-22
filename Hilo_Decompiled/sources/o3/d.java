package o3;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d extends g {
    public d(List list) {
        super(list);
    }

    public float q() {
        return r(b(), d());
    }

    float r(y3.a aVar, float f10) {
        Float f11;
        if (aVar.f١٩١١٧b != null && aVar.f١٩١١٨c != null) {
            y3.c cVar = this.f١٦٤٧٥e;
            if (cVar != null && (f11 = (Float) cVar.b(aVar.f١٩١٢٢g, aVar.f١٩١٢٣h.floatValue(), (Float) aVar.f١٩١١٧b, (Float) aVar.f١٩١١٨c, f10, e(), f())) != null) {
                return f11.floatValue();
            }
            return x3.k.i(aVar.g(), aVar.d(), f10);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // o3.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Float i(y3.a aVar, float f10) {
        return Float.valueOf(r(aVar, f10));
    }
}
