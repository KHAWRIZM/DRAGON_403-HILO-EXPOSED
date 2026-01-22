package e0;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import okio.Okio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class s extends j0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f١٣٨٢٣a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f١٣٨٢٤b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public AssetManager f١٣٨٢٥c;

    public s(Context context) {
        this.f١٣٨٢٣a = context;
    }

    @Override // e0.j0
    public final j b(e0 e0Var, int i10) {
        if (this.f١٣٨٢٥c == null) {
            synchronized (this.f١٣٨٢٤b) {
                try {
                    if (this.f١٣٨٢٥c == null) {
                        this.f١٣٨٢٥c = this.f١٣٨٢٣a.getAssets();
                    }
                } finally {
                }
            }
        }
        return new j(Okio.source(this.f١٣٨٢٥c.open(e0Var.f١٣٧٨٣a.toString().substring(22))), 2);
    }

    @Override // e0.j0
    public final boolean d(e0 e0Var) {
        Uri uri = e0Var.f١٣٧٨٣a;
        if (!"file".equals(uri.getScheme()) || uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
            return false;
        }
        return true;
    }
}
