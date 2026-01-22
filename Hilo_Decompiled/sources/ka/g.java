package ka;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.hjq.permissions.permission.base.IPermission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class g {
    public static boolean a(Context context, Intent intent) {
        PackageManager packageManager;
        PackageManager.ResolveInfoFlags of;
        List queryIntentActivities;
        if (intent == null || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        if (h.f()) {
            of = PackageManager.ResolveInfoFlags.of(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
            queryIntentActivities = packageManager.queryIntentActivities(intent, of);
            return !queryIntentActivities.isEmpty();
        }
        return !packageManager.queryIntentActivities(intent, 65536).isEmpty();
    }

    public static ArrayList b(Object... objArr) {
        int i10;
        if (objArr != null) {
            i10 = objArr.length;
        } else {
            i10 = 0;
        }
        ArrayList arrayList = new ArrayList(i10);
        if (objArr != null && objArr.length != 0) {
            for (Object obj : objArr) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static boolean c(Collection collection, IPermission iPermission) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (j(iPermission, ((IPermission) it.next()).x())) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(Collection collection, String str) {
        if (collection.isEmpty()) {
            return false;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (k(((IPermission) it.next()).x(), str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(List list, String str) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (k(str, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String[] f(Context context, List list) {
        if (list != null && !list.isEmpty()) {
            String[] strArr = new String[list.size()];
            for (int i10 = 0; i10 < list.size(); i10++) {
                strArr[i10] = ((IPermission) list.get(i10)).D(context);
            }
            return strArr;
        }
        return new String[0];
    }

    public static List g(IPermission[] iPermissionArr) {
        ArrayList arrayList = new ArrayList();
        if (iPermissionArr == null) {
            return arrayList;
        }
        for (IPermission iPermission : iPermissionArr) {
            arrayList.add(iPermission.x());
        }
        return arrayList;
    }

    public static boolean h(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!((Intent) list.get(i10)).filterEquals((Intent) list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(IPermission iPermission, IPermission iPermission2) {
        return t(iPermission.x(), iPermission2.x());
    }

    public static boolean j(IPermission iPermission, String str) {
        return t(iPermission.x(), str);
    }

    public static boolean k(String str, String str2) {
        return t(str, str2);
    }

    public static boolean l(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.hashCode() == str2.hashCode()) {
            return true;
        }
        int length = str.length();
        if (length != str2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (str.charAt(i10) != str2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static Activity m(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper) || (context = ((ContextWrapper) context).getBaseContext()) == null) {
                return null;
            }
        }
        return (Activity) context;
    }

    public static Uri n(Context context) {
        return Uri.parse("package:" + context.getPackageName());
    }

    public static boolean o(Activity activity) {
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public static boolean p(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean q(Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean r(Fragment fragment) {
        if (fragment != null && fragment.isAdded() && !fragment.isRemoving()) {
            return false;
        }
        return true;
    }

    public static boolean s(androidx.fragment.app.Fragment fragment) {
        if (fragment != null && fragment.isAdded() && !fragment.isRemoving()) {
            return false;
        }
        return true;
    }

    public static boolean t(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.hashCode() == str2.hashCode()) {
            return true;
        }
        int length = str.length();
        if (length != str2.length()) {
            return false;
        }
        for (int i10 = length - 1; i10 >= 0; i10--) {
            if (str.charAt(i10) != str2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }
}
