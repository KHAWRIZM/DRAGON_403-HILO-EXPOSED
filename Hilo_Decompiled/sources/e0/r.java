package e0;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class r implements e {

    /* renamed from: a, reason: collision with root package name */
    public final i f١٣٨٢١a;

    public r(Context context) {
        this.f١٣٨٢١a = new i(u0.a(context));
    }

    public final int a() {
        return this.f١٣٨٢١a.maxSize();
    }

    public final Bitmap b(String str) {
        p pVar = (p) this.f١٣٨٢١a.get(str);
        if (pVar != null) {
            return pVar.f١٣٨٠٦a;
        }
        return null;
    }

    public final void c(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            int b10 = u0.b(bitmap);
            if (b10 > this.f١٣٨٢١a.maxSize()) {
                this.f١٣٨٢١a.remove(str);
                return;
            } else {
                this.f١٣٨٢١a.put(str, new p(bitmap, b10));
                return;
            }
        }
        throw new NullPointerException("key == null || bitmap == null");
    }

    public final int d() {
        return this.f١٣٨٢١a.size();
    }
}
