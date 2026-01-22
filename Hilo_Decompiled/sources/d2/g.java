package d2;

import d2.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g extends f {

    /* renamed from: m, reason: collision with root package name */
    public int f١٣٥٨٩m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f١٣٥٧٢e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f١٣٥٧٢e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // d2.f
    public void d(int i10) {
        if (this.f١٣٥٧٧j) {
            return;
        }
        this.f١٣٥٧٧j = true;
        this.f١٣٥٧٤g = i10;
        for (d dVar : this.f١٣٥٧٨k) {
            dVar.a(dVar);
        }
    }
}
