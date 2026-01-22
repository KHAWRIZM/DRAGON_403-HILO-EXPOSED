package gc;

import android.content.res.Resources;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class f implements a {
    @Override // gc.a
    public final void a(dc.e eVar, View view, Resources.Theme theme, String str, int i10) {
        b(view, str, ic.i.c(theme, i10));
    }

    protected abstract void b(View view, String str, int i10);
}
