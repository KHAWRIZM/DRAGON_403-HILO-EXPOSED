package ga;

import android.content.Context;
import com.hjq.permissions.permission.base.IPermission;
import java.util.List;
import ka.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract /* synthetic */ class c {
    public static List a(IPermission iPermission, Context context) {
        return null;
    }

    public static int b(IPermission iPermission, Context context) {
        return iPermission.h(context);
    }

    public static List c(IPermission iPermission, Context context) {
        return null;
    }

    public static String d(IPermission iPermission, Context context) {
        return null;
    }

    public static int e(IPermission iPermission, Context context) {
        return 0;
    }

    public static String f(IPermission iPermission, Context context) {
        return iPermission.x();
    }

    public static int g(IPermission iPermission, Context context) {
        return 0;
    }

    public static boolean h(IPermission iPermission, Context context) {
        if (iPermission.G(context) == null) {
            return false;
        }
        return !r0.isEmpty();
    }

    public static boolean i(IPermission iPermission, Context context) {
        return iPermission.T(context, true);
    }

    public static boolean j(IPermission iPermission, Context context) {
        if (iPermission.h(context) <= h.a()) {
            return true;
        }
        return false;
    }
}
