package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class s {
    private static int a(boolean z10, int i10) {
        int i11;
        if (z10) {
            if (Build.VERSION.SDK_INT >= 31) {
                i11 = 33554432;
            } else {
                return i10;
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            i11 = 67108864;
        } else {
            return i10;
        }
        return i10 | i11;
    }

    public static PendingIntent b(Context context, int i10, Intent intent, int i11, boolean z10) {
        return PendingIntent.getActivity(context, i10, intent, a(z10, i11));
    }
}
