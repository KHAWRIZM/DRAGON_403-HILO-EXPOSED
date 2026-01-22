package w9;

import android.app.Activity;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface f {
    void dispatchPermissionRequest(Activity activity, List list, z9.a aVar, d dVar, c cVar);

    void onRequestPermissionEnd(Activity activity, boolean z10, List list, List list2, List list3, c cVar);

    void onRequestPermissionStart(Activity activity, List list, z9.a aVar, d dVar, c cVar);
}
