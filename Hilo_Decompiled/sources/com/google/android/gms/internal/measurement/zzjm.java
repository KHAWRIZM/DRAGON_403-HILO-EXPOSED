package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzjm {

    @GuardedBy("DirectBootUtils.class")
    private static UserManager zza;
    private static volatile boolean zzb = !zza();

    private zzjm() {
    }

    @ChecksSdkIntAtLeast(api = 24)
    public static boolean zza() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean zzb(Context context) {
        if (zza() && !zzd(context)) {
            return true;
        }
        return false;
    }

    public static boolean zzc(Context context) {
        if (zza() && !zzd(context)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0039, code lost:
    
        if (r3.isUserRunning(android.os.Process.myUserHandle()) == false) goto L٢٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
    
        r5 = true;
     */
    @RequiresApi(24)
    @TargetApi(24)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean zzd(Context context) {
        boolean z10;
        boolean isUserUnlocked;
        Object systemService;
        if (zzb) {
            return true;
        }
        synchronized (zzjm.class) {
            try {
                if (zzb) {
                    return true;
                }
                int i10 = 1;
                while (true) {
                    z10 = false;
                    if (i10 > 2) {
                        break;
                    }
                    if (zza == null) {
                        systemService = context.getSystemService((Class<Object>) UserManager.class);
                        zza = (UserManager) systemService;
                    }
                    UserManager userManager = zza;
                    if (userManager != null) {
                        try {
                            isUserUnlocked = userManager.isUserUnlocked();
                            if (isUserUnlocked) {
                                break;
                            }
                        } catch (NullPointerException e10) {
                            Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e10);
                            zza = null;
                            i10++;
                        }
                    } else {
                        z10 = true;
                        break;
                    }
                }
                if (z10) {
                    zza = null;
                }
                if (z10) {
                    zzb = true;
                }
                return z10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
