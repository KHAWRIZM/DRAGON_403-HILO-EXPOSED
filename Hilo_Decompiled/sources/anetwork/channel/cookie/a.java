package anetwork.channel.cookie;

import android.text.TextUtils;
import anet.channel.util.ALog;
import anetwork.channel.cookie.CookieManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        String f10;
        String f11;
        try {
            f10 = CookieManager.f();
            if (!TextUtils.isEmpty(f10)) {
                f11 = CookieManager.f();
                CookieManager.a unused = CookieManager.f٥١٦٦d = new CookieManager.a(f11);
            }
        } catch (Exception e10) {
            ALog.e(CookieManager.TAG, "", null, e10, new Object[0]);
        }
    }
}
