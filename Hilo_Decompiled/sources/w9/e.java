package w9;

import android.app.Activity;
import java.util.List;
import x9.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract /* synthetic */ class e {
    public static void a(f fVar, Activity activity, List list, z9.a aVar, d dVar, c cVar) {
        new n(activity, list, aVar, fVar, dVar, cVar).l();
    }

    public static void b(f fVar, Activity activity, boolean z10, List list, List list2, List list3, c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.onResult(list2, list3);
    }

    public static void c(f fVar, Activity activity, List list, z9.a aVar, d dVar, c cVar) {
        fVar.dispatchPermissionRequest(activity, list, aVar, dVar, cVar);
    }
}
