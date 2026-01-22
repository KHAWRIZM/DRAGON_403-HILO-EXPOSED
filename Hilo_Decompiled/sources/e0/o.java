package e0;

import java.util.concurrent.FutureTask;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class o extends FutureTask implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final d f١٣٨٠٣a;

    public o(d dVar) {
        super(dVar, null);
        this.f١٣٨٠٣a = dVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        d dVar = this.f١٣٨٠٣a;
        int i10 = dVar.f١٣٧٨٠s;
        d dVar2 = ((o) obj).f١٣٨٠٣a;
        int i11 = dVar2.f١٣٧٨٠s;
        if (i10 == i11) {
            return dVar.f١٣٧٦٢a - dVar2.f١٣٧٦٢a;
        }
        return h0.a(i11) - h0.a(i10);
    }
}
