package u;

import android.app.Application;
import android.os.Process;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b {
    public static boolean a(Application application) {
        if (application.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }
}
