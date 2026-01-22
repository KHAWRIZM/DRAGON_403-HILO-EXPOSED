package ka;

import android.app.Activity;
import android.content.Context;
import com.hjq.permissions.permission.base.IPermission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {
    public static synchronized void a(Context context, List list) {
        List<IPermission> M;
        synchronized (a.class) {
            int i10 = -1;
            while (true) {
                i10++;
                if (i10 < list.size()) {
                    IPermission iPermission = (IPermission) list.get(i10);
                    if (h.a() < iPermission.h(context) && (M = iPermission.M(context)) != null && !M.isEmpty()) {
                        for (IPermission iPermission2 : M) {
                            if (!g.c(list, iPermission2)) {
                                i10++;
                                list.add(i10, iPermission2);
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean b(Context context, List list) {
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((IPermission) it.next()).q(context) == fa.a.START_ACTIVITY_FOR_RESULT) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List c(Context context, List list, boolean z10) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                IPermission iPermission = (IPermission) it.next();
                if (iPermission.h(context) > h.a()) {
                    arrayList.remove(iPermission);
                } else {
                    List M = iPermission.M(context);
                    if (M != null && !M.isEmpty() && (iPermission.q(context) == fa.a.START_ACTIVITY_FOR_RESULT || b(context, M))) {
                        arrayList.removeAll(M);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return c.d(context);
            }
            if (arrayList.size() == 1) {
                return ((IPermission) arrayList.get(0)).L(context, z10);
            }
            List L = ((IPermission) arrayList.get(0)).L(context, z10);
            int i10 = 1;
            while (i10 < arrayList.size()) {
                List L2 = ((IPermission) arrayList.get(i10)).L(context, z10);
                if (!g.h(L2, L)) {
                    break;
                }
                if (i10 == arrayList.size() - 1) {
                    return L2;
                }
                i10++;
                L = L2;
            }
            return c.d(context);
        }
        return c.d(context);
    }

    public static List d(Context context, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            IPermission iPermission = (IPermission) it.next();
            if (!iPermission.F(context)) {
                arrayList.add(iPermission);
            }
        }
        return arrayList;
    }

    public static int e(Context context, List list) {
        int i10 = 0;
        if (list == null) {
            return 0;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int o10 = ((IPermission) it.next()).o(context);
            if (o10 != 0) {
                i10 = Math.max(i10, o10);
            }
        }
        return i10;
    }

    public static int f(Context context, List list) {
        int i10 = 0;
        if (list == null) {
            return 0;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int H = ((IPermission) it.next()).H(context);
            if (H != 0) {
                i10 = Math.max(i10, H);
            }
        }
        return i10;
    }

    public static boolean g(Activity activity, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((IPermission) it.next()).R(activity)) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(Context context, List list) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((IPermission) it.next()).F(context)) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(IPermission iPermission) {
        return iPermission.x().startsWith("android.permission.health.");
    }
}
