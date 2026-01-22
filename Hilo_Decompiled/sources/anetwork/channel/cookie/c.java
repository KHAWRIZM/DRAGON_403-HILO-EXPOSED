package anetwork.channel.cookie;

import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.CookieMonitorStat;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import anetwork.channel.cookie.CookieManager;
import java.net.HttpCookie;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٥١٧٤a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f٥١٧٥b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, String str2) {
        this.f٥١٧٤a = str;
        this.f٥١٧٥b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        CookieManager.a aVar;
        CookieManager.a aVar2;
        CookieManager.a aVar3;
        CookieManager.a aVar4;
        CookieManager.a aVar5;
        CookieManager.a aVar6;
        CookieManager.a aVar7;
        aVar = CookieManager.f٥١٦٦d;
        if (aVar != null) {
            try {
                aVar2 = CookieManager.f٥١٦٦d;
                if (!TextUtils.isEmpty(aVar2.f٥١٦٨a)) {
                    aVar3 = CookieManager.f٥١٦٦d;
                    if (HttpCookie.domainMatches(aVar3.f٥١٧١d, HttpUrl.parse(this.f٥١٧٤a).host()) && !TextUtils.isEmpty(this.f٥١٧٥b)) {
                        String str = this.f٥١٧٥b;
                        StringBuilder sb = new StringBuilder();
                        aVar4 = CookieManager.f٥١٦٦d;
                        sb.append(aVar4.f٥١٦٨a);
                        sb.append("=");
                        if (!str.contains(sb.toString())) {
                            CookieMonitorStat cookieMonitorStat = new CookieMonitorStat(this.f٥١٧٤a);
                            aVar5 = CookieManager.f٥١٦٦d;
                            cookieMonitorStat.cookieName = aVar5.f٥١٦٨a;
                            aVar6 = CookieManager.f٥١٦٦d;
                            cookieMonitorStat.cookieText = aVar6.f٥١٦٩b;
                            aVar7 = CookieManager.f٥١٦٦d;
                            cookieMonitorStat.setCookie = aVar7.f٥١٧٠c;
                            cookieMonitorStat.missType = 1;
                            AppMonitor.getInstance().commitStat(cookieMonitorStat);
                        }
                    }
                }
            } catch (Exception e10) {
                ALog.e(CookieManager.TAG, "cookieMonitorReport error.", null, e10, new Object[0]);
            }
        }
    }
}
