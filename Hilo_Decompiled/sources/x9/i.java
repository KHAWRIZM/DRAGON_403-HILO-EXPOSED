package x9;

import android.app.Activity;
import android.content.Intent;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class i extends e {

    /* renamed from: g, reason: collision with root package name */
    private int f١٩٠٠٧g;

    public i(y9.c cVar) {
        super(cVar);
        this.f١٩٠٠٧g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.f١٩٠٠٧g++;
    }

    @Override // x9.e
    public void k(int i10, int i11, Intent intent) {
        if (i10 != e()) {
            return;
        }
        int i12 = this.f١٩٠٠٧g;
        if (i12 > 0) {
            this.f١٩٠٠٧g = i12 - 1;
        } else {
            ca.d.b(i10);
            j();
        }
    }

    @Override // x9.e
    protected void s(Activity activity, List list, int i10) {
        ja.b.c(activity, g(), ka.a.c(activity, list, false), i10, new Runnable() { // from class: x9.h
            @Override // java.lang.Runnable
            public final void run() {
                i.this.u();
            }
        });
    }
}
