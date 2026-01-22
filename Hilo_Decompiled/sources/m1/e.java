package m1;

import android.util.SparseArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e extends b {

    /* renamed from: e, reason: collision with root package name */
    public n0.a f١٥٩١٥e;

    /* renamed from: f, reason: collision with root package name */
    public SparseArray f١٥٩١٦f;

    public e(int i10) {
        super(i10);
    }

    public final void a(r0.g gVar) {
        this.f١٥٩٠٩b = gVar;
        this.f١٥٩١٠c = gVar.e();
        SparseArray sparseArray = new SparseArray();
        int size = gVar.f١٧٢٨٨g.size();
        for (int i10 = 0; i10 < size; i10++) {
            sparseArray.put(i10, Long.valueOf(((r0.e) gVar.f١٧٢٨٨g.get(i10)).f١٧٢٧٩c.get()));
        }
        this.f١٥٩١١d = sparseArray;
        this.f١٥٩١٥e = new n0.a();
        this.f١٥٩١٦f = new SparseArray();
        int size2 = gVar.f١٧٢٨٨g.size();
        for (int i11 = 0; i11 < size2; i11++) {
            this.f١٥٩١٦f.put(i11, new n0.a());
        }
    }
}
