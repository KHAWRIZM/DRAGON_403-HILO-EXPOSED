package x;

import java.util.Objects;
import okhttp3.Response;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f١٨٨٠٦a;

    public a(b bVar) {
        this.f١٨٨٠٦a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f١٨٨٠٦a;
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
    }
}
