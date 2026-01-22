package anetwork.channel.cookie;

import anet.channel.util.ALog;
import anetwork.channel.cookie.CookieManager;
import java.net.HttpCookie;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٥١٧٣a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) {
        this.f٥١٧٣a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        CookieManager.a aVar;
        CookieManager.a aVar2;
        CookieManager.a aVar3;
        CookieManager.a aVar4;
        CookieManager.a aVar5;
        CookieManager.a aVar6;
        aVar = CookieManager.f٥١٦٦d;
        if (aVar == null) {
            return;
        }
        try {
            for (HttpCookie httpCookie : HttpCookie.parse(this.f٥١٧٣a)) {
                String name = httpCookie.getName();
                aVar2 = CookieManager.f٥١٦٦d;
                if (name.equals(aVar2.f٥١٦٨a)) {
                    aVar3 = CookieManager.f٥١٦٦d;
                    aVar3.f٥١٦٩b = httpCookie.toString();
                    aVar4 = CookieManager.f٥١٦٦d;
                    aVar4.f٥١٧١d = httpCookie.getDomain();
                    aVar5 = CookieManager.f٥١٦٦d;
                    aVar5.f٥١٧٠c = this.f٥١٧٣a;
                    aVar6 = CookieManager.f٥١٦٦d;
                    aVar6.a();
                    return;
                }
            }
        } catch (Exception e10) {
            ALog.e(CookieManager.TAG, "cookieMonitorSave error.", null, e10, new Object[0]);
        }
    }
}
