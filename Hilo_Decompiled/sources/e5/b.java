package e5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import m4.f;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap f١٣٨٨٥a = new ConcurrentHashMap();

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e10);
            return null;
        }
    }

    private static String b(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    public static f c(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap concurrentMap = f١٣٨٨٥a;
        f fVar = (f) concurrentMap.get(packageName);
        if (fVar == null) {
            f d10 = d(context);
            f fVar2 = (f) concurrentMap.putIfAbsent(packageName, d10);
            if (fVar2 != null) {
                return fVar2;
            }
            return d10;
        }
        return fVar;
    }

    private static f d(Context context) {
        return new d(b(a(context)));
    }
}
