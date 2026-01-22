package o4;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Map f١٦٧٢٥a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f١٦٧٢٦b = new HashMap();

    private Map b(boolean z10) {
        if (z10) {
            return this.f١٦٧٢٦b;
        }
        return this.f١٦٧٢٥a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l a(m4.f fVar, boolean z10) {
        return (l) b(z10).get(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(m4.f fVar, l lVar) {
        b(lVar.p()).put(fVar, lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(m4.f fVar, l lVar) {
        Map b10 = b(lVar.p());
        if (lVar.equals(b10.get(fVar))) {
            b10.remove(fVar);
        }
    }
}
