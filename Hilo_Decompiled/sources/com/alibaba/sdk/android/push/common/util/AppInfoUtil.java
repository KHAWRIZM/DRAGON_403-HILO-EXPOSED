package com.alibaba.sdk.android.push.common.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AppInfoUtil {
    private static final String TAG = "MPS:AppInfoUtil";
    private static AmsLogger sLogger = AmsLogger.getLogger(TAG);

    public static String getAppVersionName(Context context) {
        if (context == null) {
            sLogger.e("Get app version name failed: context null");
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            sLogger.e("version name not found!", e10);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[Catch: NameNotFoundException -> 0x005c, TRY_LEAVE, TryCatch #0 {NameNotFoundException -> 0x005c, blocks: (B:5:0x0010, B:20:0x004f, B:22:0x0053, B:23:0x0057, B:24:0x0026, B:27:0x0030, B:30:0x003a), top: B:4:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isComponentExists(Context context, String str, String str2) {
        char c10;
        if (context == null) {
            sLogger.e("Get component info failed: context null");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context.getPackageName(), str);
        try {
            int hashCode = str2.hashCode();
            if (hashCode == -1655966961) {
                if (str2.equals("activity")) {
                    c10 = 1;
                    if (c10 != 0) {
                    }
                    return true;
                }
                c10 = 65535;
                if (c10 != 0) {
                }
                return true;
            }
            if (hashCode == -808719889) {
                if (str2.equals("receiver")) {
                    c10 = 2;
                    if (c10 != 0) {
                    }
                    return true;
                }
                c10 = 65535;
                if (c10 != 0) {
                }
                return true;
            }
            if (hashCode == 1984153269 && str2.equals("service")) {
                c10 = 0;
                if (c10 != 0) {
                    packageManager.getServiceInfo(componentName, 131584);
                } else if (c10 == 1) {
                    packageManager.getActivityInfo(componentName, 131584);
                } else {
                    if (c10 != 2) {
                        return false;
                    }
                    packageManager.getReceiverInfo(componentName, 131584);
                }
                return true;
            }
            c10 = 65535;
            if (c10 != 0) {
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            sLogger.e("component:" + str + " not found!");
            return false;
        }
    }
}
