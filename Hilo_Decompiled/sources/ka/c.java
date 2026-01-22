package ka;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hjq.permissions.permission.base.IPermission;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c {
    public static Intent a() {
        return new Intent("android.settings.SETTINGS");
    }

    public static Intent b(Context context, IPermission... iPermissionArr) {
        ArrayList<String> arrayList;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(g.n(context));
        if (iPermissionArr != null && iPermissionArr.length > 0 && v9.a.i()) {
            Bundle bundle = new Bundle();
            List g10 = g.g(iPermissionArr);
            if (g10 instanceof ArrayList) {
                arrayList = (ArrayList) g10;
            } else {
                arrayList = new ArrayList<>(g10);
            }
            bundle.putStringArrayList("permissionList", arrayList);
            intent.putExtras(bundle);
            intent.putExtra("isGetPermission", true);
        }
        return intent;
    }

    public static Intent c() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    public static List d(Context context) {
        return e(context, null);
    }

    public static List e(Context context, IPermission... iPermissionArr) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(b(context, iPermissionArr));
        arrayList.add(g());
        arrayList.add(c());
        arrayList.add(a());
        return arrayList;
    }

    public static List f(Context context) {
        ArrayList arrayList = new ArrayList(1);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.huawei.systemmanager");
        if (launchIntentForPackage != null) {
            arrayList.add(launchIntentForPackage);
        }
        return arrayList;
    }

    public static Intent g() {
        return new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
    }

    public static Intent h(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$AppOpsDetailsActivity");
        Bundle bundle = new Bundle();
        bundle.putString("package", context.getPackageName());
        intent.putExtra(":settings:show_fragment_args", bundle);
        intent.setData(g.n(context));
        return intent;
    }

    public static List i(Context context) {
        ArrayList arrayList = new ArrayList(3);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.oppo.safe");
        if (launchIntentForPackage != null) {
            arrayList.add(launchIntentForPackage);
        }
        Intent launchIntentForPackage2 = context.getPackageManager().getLaunchIntentForPackage("com.color.safecenter");
        if (launchIntentForPackage2 != null) {
            arrayList.add(launchIntentForPackage2);
        }
        Intent launchIntentForPackage3 = context.getPackageManager().getLaunchIntentForPackage("com.oplus.safecenter");
        if (launchIntentForPackage3 != null) {
            arrayList.add(launchIntentForPackage3);
        }
        return arrayList;
    }

    public static List j() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new Intent("com.smartisanos.security.action.PACKAGE_OVERVIEW"));
        Intent intent = new Intent();
        intent.setClassName("com.smartisanos.security", "com.smartisanos.security.PackagesOverview");
        arrayList.add(intent);
        return arrayList;
    }

    public static List k(Context context) {
        ArrayList arrayList = new ArrayList(2);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.smartisanos.security");
        if (launchIntentForPackage != null) {
            arrayList.add(launchIntentForPackage);
        }
        Intent launchIntentForPackage2 = context.getPackageManager().getLaunchIntentForPackage("com.smartisanos.securitycenter");
        if (launchIntentForPackage2 != null) {
            arrayList.add(launchIntentForPackage2);
        }
        return arrayList;
    }

    public static List l(Context context) {
        ArrayList arrayList = new ArrayList(1);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.iqoo.secure");
        if (launchIntentForPackage != null) {
            arrayList.add(launchIntentForPackage);
        }
        return arrayList;
    }

    public static Intent m(Context context) {
        return new Intent("miui.intent.action.APP_PERM_EDITOR").putExtra("extra_pkgname", context.getPackageName());
    }

    public static List n(Context context) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new Intent("miui.intent.action.APP_MANAGER"));
        arrayList.add(new Intent("miui.intent.action.SECURITY_CENTER"));
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.miui.securitycenter");
        if (launchIntentForPackage != null) {
            arrayList.add(launchIntentForPackage);
        }
        return arrayList;
    }
}
