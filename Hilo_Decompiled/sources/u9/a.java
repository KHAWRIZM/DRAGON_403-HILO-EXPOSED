package u9;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p9.f;
import t9.b;
import t9.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {
    public static boolean a(Context context, Map map) {
        if (map == null) {
            return false;
        }
        String packageName = context.getPackageName();
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            List<b> list = (List) map.get(str);
            if (list != null) {
                for (b bVar : list) {
                    arrayList.add(new c(bVar.g(), packageName, bVar.f(), bVar.k(), str, null, bVar.j(), bVar.c()));
                }
            } else {
                arrayList.add(new c(packageName, str));
            }
        }
        return f.b(context, arrayList);
    }
}
