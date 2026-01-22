package e0;

import android.content.Context;
import okio.Okio;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class n extends j0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f١٣٨٠٢a;

    public n(Context context) {
        this.f١٣٨٠٢a = context;
    }

    @Override // e0.j0
    public j b(e0 e0Var, int i10) {
        return new j(Okio.source(this.f١٣٨٠٢a.getContentResolver().openInputStream(e0Var.f١٣٧٨٣a)), 2);
    }

    @Override // e0.j0
    public boolean d(e0 e0Var) {
        return "content".equals(e0Var.f١٣٧٨٣a.getScheme());
    }
}
