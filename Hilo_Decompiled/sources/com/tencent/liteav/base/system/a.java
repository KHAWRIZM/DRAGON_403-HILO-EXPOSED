package com.tencent.liteav.base.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.liteav.base.ContextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final class a {
    private static final com.tencent.liteav.base.util.p<PackageInfo> a = new com.tencent.liteav.base.util.p<>(b.a());

    public static String a() {
        PackageInfo a2 = a.a();
        if (a2 == null) {
            return "";
        }
        return a2.packageName;
    }

    public static String b() {
        PackageInfo a2;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || (a2 = a.a()) == null) {
            return "";
        }
        return applicationContext.getPackageManager().getApplicationLabel(a2.applicationInfo).toString();
    }

    public static String c() {
        PackageInfo a2 = a.a();
        if (a2 == null) {
            return "";
        }
        return a2.versionName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PackageInfo d() throws Exception {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
    }
}
