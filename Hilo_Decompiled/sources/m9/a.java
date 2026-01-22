package m9;

import android.content.Context;
import android.content.Intent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a extends c {
    @Override // m9.d
    public t9.a a(Context context, int i10, Intent intent) {
        if (4105 == i10) {
            return c(intent, i10);
        }
        return null;
    }

    protected t9.a c(Intent intent, int i10) {
        try {
            l9.b bVar = new l9.b();
            bVar.h(Integer.parseInt(p9.b.e(intent.getStringExtra("command"))));
            bVar.j(Integer.parseInt(p9.b.e(intent.getStringExtra("code"))));
            bVar.i(p9.b.e(intent.getStringExtra("content")));
            bVar.e(p9.b.e(intent.getStringExtra("appKey")));
            bVar.g(p9.b.e(intent.getStringExtra("appSecret")));
            bVar.f(p9.b.e(intent.getStringExtra("appPackage")));
            p9.d.a("OnHandleIntent-message:" + bVar.toString());
            return bVar;
        } catch (Exception e10) {
            p9.d.a("OnHandleIntent--" + e10.getMessage());
            return null;
        }
    }
}
