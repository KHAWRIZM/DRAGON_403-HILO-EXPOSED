package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.GuardedBy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzcc {

    @GuardedBy("DirectBootUtils.class")
    private static UserManager zza;
    private static volatile boolean zzb = !zzb();

    private zzcc() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        if (r4.isUserRunning(android.os.Process.myUserHandle()) == false) goto L٢٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zza(Context context) {
        int i10;
        boolean z10;
        boolean isUserUnlocked;
        Object systemService;
        if (zzb() && !zzb) {
            synchronized (zzcc.class) {
                try {
                    if (!zzb) {
                        i10 = 1;
                        while (true) {
                            if (i10 <= 2) {
                                if (zza == null) {
                                    systemService = context.getSystemService((Class<Object>) UserManager.class);
                                    zza = (UserManager) systemService;
                                }
                                UserManager userManager = zza;
                                if (userManager != null) {
                                    isUserUnlocked = userManager.isUserUnlocked();
                                    if (isUserUnlocked) {
                                        break;
                                    }
                                } else {
                                    z10 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        z10 = false;
                        if (z10) {
                            zza = null;
                        }
                        if (z10) {
                            zzb = true;
                        }
                        if (!z10) {
                            return true;
                        }
                    }
                } catch (NullPointerException e10) {
                    Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e10);
                    zza = null;
                    i10++;
                } finally {
                }
            }
        }
        return false;
    }

    @ChecksSdkIntAtLeast(api = 24)
    public static boolean zzb() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
