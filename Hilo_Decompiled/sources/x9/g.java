package x9;

import android.app.Activity;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class g extends e {
    public g(y9.c cVar) {
        super(cVar);
    }

    @Override // x9.e
    public void m(int i10, String[] strArr, int[] iArr) {
        if (i10 != e()) {
            return;
        }
        ca.d.b(i10);
        j();
    }

    @Override // x9.e
    protected void s(Activity activity, List list, int i10) {
        if (!ka.h.n()) {
            p(new Runnable() { // from class: x9.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.h();
                }
            }, 0L);
        } else {
            o(ka.g.f(activity, list), i10);
            ca.c.a(list);
        }
    }
}
