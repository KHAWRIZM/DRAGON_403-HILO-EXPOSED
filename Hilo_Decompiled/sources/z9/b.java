package z9;

import android.app.Activity;
import android.app.FragmentManager;
import ca.d;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class b extends a {
    public b(Activity activity, FragmentManager fragmentManager) {
        super(activity, fragmentManager);
    }

    @Override // z9.a
    public void a(List list, fa.a aVar, x9.b bVar) {
        y9.c cVar;
        if (aVar == fa.a.REQUEST_PERMISSIONS) {
            cVar = new aa.b();
        } else {
            cVar = new aa.c();
        }
        cVar.setArguments(b(list, d.a(65535)));
        cVar.setRetainInstance(true);
        cVar.b(true);
        cVar.c(bVar);
        cVar.a((FragmentManager) d());
    }
}
