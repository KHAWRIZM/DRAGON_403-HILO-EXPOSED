package w9;

import android.app.Activity;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class b implements f {
    @Override // w9.f
    public /* synthetic */ void dispatchPermissionRequest(Activity activity, List list, z9.a aVar, d dVar, c cVar) {
        e.a(this, activity, list, aVar, dVar, cVar);
    }

    @Override // w9.f
    public /* synthetic */ void onRequestPermissionEnd(Activity activity, boolean z10, List list, List list2, List list3, c cVar) {
        e.b(this, activity, z10, list, list2, list3, cVar);
    }

    @Override // w9.f
    public /* synthetic */ void onRequestPermissionStart(Activity activity, List list, z9.a aVar, d dVar, c cVar) {
        e.c(this, activity, list, aVar, dVar, cVar);
    }
}
