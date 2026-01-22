package m0;

import java.io.IOException;
import java.util.Objects;
import okhttp3.Response;
import x.i;
import z.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class e implements b, d {
    @Override // m0.d
    public final long a(x.b bVar) {
        try {
            return bVar.b();
        } catch (IOException e10) {
            bVar.f١٨٨١١d.b(e10);
            throw e10;
        }
    }

    @Override // m0.b
    public final l1.a b(x.b bVar) {
        i iVar = bVar.f١٨٨١١d;
        while (true) {
            try {
                if (!iVar.c()) {
                    return bVar.c();
                }
                throw z.d.f١٩٣٢٧a;
            } catch (IOException e10) {
                if (e10 instanceof h) {
                    bVar.f١٨٨١٤g = 1;
                    synchronized (bVar) {
                        try {
                            if (bVar.f١٨٨١٧j != null) {
                                l1.d dVar = bVar.f١٨٨١٧j;
                                dVar.f١٥٦٩٠c = null;
                                Response response = dVar.f١٥٦٩١d;
                                if (response != null) {
                                    response.close();
                                }
                                dVar.f١٥٦٩١d = null;
                                Objects.toString(bVar.f١٨٨١٧j);
                                int i10 = bVar.f١٨٨٠٩b.f١٦١١٣b;
                            }
                            bVar.f١٨٨١٧j = null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } else {
                    bVar.f١٨٨١١d.b(e10);
                    bVar.f١٨٨١١d.a().f١٤٣٦٠t.add(Integer.valueOf(bVar.f١٨٨٠٨a));
                    throw e10;
                }
            }
        }
    }
}
