package t0;

import l1.d;
import n0.f;
import okhttp3.Request;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements m0.b {
    @Override // m0.b
    public final l1.a b(x.b bVar) {
        f.a().f١٦١٤٣g.c(bVar.f١٨٨٠٩b);
        f.a().f١٦١٤٣g.b();
        d dVar = (d) bVar.a();
        Request build = dVar.f١٥٦٨٩b.build();
        dVar.f١٥٦٩٠c = build;
        dVar.f١٥٦٩١d = dVar.f١٥٦٨٨a.newCall(build).execute();
        return dVar;
    }
}
