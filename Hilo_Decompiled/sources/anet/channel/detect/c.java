package anet.channel.detect;

import android.text.TextUtils;
import android.util.Pair;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f٤٧١٧a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ExceptionDetector f٤٧١٨b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ExceptionDetector exceptionDetector, RequestStatistic requestStatistic) {
        this.f٤٧١٨b = exceptionDetector;
        this.f٤٧١٧a = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            RequestStatistic requestStatistic = this.f٤٧١٧a;
            if (requestStatistic == null) {
                return;
            }
            if (!TextUtils.isEmpty(requestStatistic.ip) && this.f٤٧١٧a.ret == 0) {
                if ("guide-acs.m.taobao.com".equalsIgnoreCase(this.f٤٧١٧a.host)) {
                    this.f٤٧١٨b.f٤٧٠٢b = this.f٤٧١٧a.ip;
                } else if ("msgacs.m.taobao.com".equalsIgnoreCase(this.f٤٧١٧a.host)) {
                    this.f٤٧١٨b.f٤٧٠٣c = this.f٤٧١٧a.ip;
                } else if ("gw.alicdn.com".equalsIgnoreCase(this.f٤٧١٧a.host)) {
                    this.f٤٧١٨b.f٤٧٠٤d = this.f٤٧١٧a.ip;
                }
            }
            if (!TextUtils.isEmpty(this.f٤٧١٧a.url)) {
                this.f٤٧١٨b.f٤٧٠٥e.add(Pair.create(this.f٤٧١٧a.url, Integer.valueOf(this.f٤٧١٧a.statusCode)));
            }
            if (!this.f٤٧١٨b.c()) {
                return;
            }
            this.f٤٧١٨b.b();
        } catch (Throwable th) {
            ALog.e("anet.ExceptionDetector", "network detect fail.", null, th, new Object[0]);
        }
    }
}
