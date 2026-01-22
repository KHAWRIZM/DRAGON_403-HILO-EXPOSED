package ja;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;
import ka.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {
    public static void a(Activity activity, List list) {
        b(activity, new c(activity), list);
    }

    public static void b(Context context, a aVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!g.a(context, (Intent) it.next())) {
                it.remove();
            }
        }
        if (list.isEmpty()) {
            list.add(ka.c.a());
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Intent intent = (Intent) it2.next();
            if (intent != null) {
                try {
                    aVar.startActivity(intent);
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public static void c(Context context, a aVar, List list, int i10, Runnable runnable) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!g.a(context, (Intent) it.next())) {
                it.remove();
            }
        }
        if (list.isEmpty()) {
            list.add(ka.c.a());
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Intent intent = (Intent) it2.next();
            if (intent != null) {
                try {
                    aVar.startActivityForResult(intent, i10);
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    if (it2.hasNext() && runnable != null) {
                        runnable.run();
                    }
                }
            }
        }
    }
}
