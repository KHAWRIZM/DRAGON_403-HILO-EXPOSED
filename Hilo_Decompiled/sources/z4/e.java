package z4;

import android.content.Context;
import android.util.Log;
import z4.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e implements c {
    @Override // z4.c
    public b a(Context context, b.a aVar) {
        boolean z10;
        String str;
        if (androidx.core.content.a.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            if (z10) {
                str = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
            } else {
                str = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            }
            Log.d("ConnectivityMonitor", str);
        }
        if (z10) {
            return new d(context, aVar);
        }
        return new n();
    }
}
