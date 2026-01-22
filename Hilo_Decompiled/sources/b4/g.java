package b4;

import android.app.ActivityManager;
import android.content.Context;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class g {
    public static boolean a(Context context) {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance != 100) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
