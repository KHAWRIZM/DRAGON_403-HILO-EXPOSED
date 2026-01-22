package o9;

import android.content.Context;
import java.util.ArrayList;
import p9.f;
import t9.b;
import t9.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {
    public static boolean a(Context context, String str, b bVar) {
        c cVar;
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (bVar == null) {
            cVar = new c(packageName, str);
        } else {
            cVar = new c(bVar.g(), packageName, bVar.f(), bVar.k(), str, null, bVar.j(), bVar.c());
        }
        arrayList.add(cVar);
        return f.b(context, arrayList);
    }
}
