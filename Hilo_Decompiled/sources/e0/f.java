package e0;

import android.content.Context;
import okio.Okio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f extends n {
    public f(Context context) {
        super(context);
    }

    @Override // e0.n, e0.j0
    public final j b(e0 e0Var, int i10) {
        return new j(null, Okio.source(this.f١٣٨٠٢a.getContentResolver().openInputStream(e0Var.f١٣٧٨٣a)), 2, new androidx.exifinterface.media.a(e0Var.f١٣٧٨٣a.getPath()).e("Orientation", 1));
    }

    @Override // e0.n, e0.j0
    public final boolean d(e0 e0Var) {
        return "file".equals(e0Var.f١٣٧٨٣a.getScheme());
    }
}
