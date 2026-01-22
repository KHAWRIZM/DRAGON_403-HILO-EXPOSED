package ca;

import com.hjq.permissions.permission.base.IPermission;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ka.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static final List f٦٠١٧a = new ArrayList();

    public static void a(List list) {
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String x10 = ((IPermission) it.next()).x();
                List list2 = f٦٠١٧a;
                if (!g.e(list2, x10)) {
                    list2.add(x10);
                }
            }
        }
    }

    public static boolean b(IPermission iPermission) {
        if (iPermission == null) {
            return false;
        }
        return g.e(f٦٠١٧a, iPermission.x());
    }
}
