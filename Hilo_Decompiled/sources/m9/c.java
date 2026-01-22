package m9;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c implements d {
    public static List b(Context context, Intent intent) {
        int i10;
        t9.a a10;
        if (intent == null) {
            return null;
        }
        try {
            i10 = Integer.parseInt(p9.b.e(intent.getStringExtra("type")));
        } catch (Exception e10) {
            p9.d.b("MessageParser--getMessageByIntent--Exception:" + e10.getMessage());
            i10 = 4096;
        }
        p9.d.a("MessageParser--getMessageByIntent--type:" + i10);
        ArrayList arrayList = new ArrayList();
        for (d dVar : i9.d.h().l()) {
            if (dVar != null && (a10 = dVar.a(context, i10, intent)) != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }
}
