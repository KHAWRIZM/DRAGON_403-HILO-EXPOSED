package anetwork.channel.unified;

import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.interceptor.Callback;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements IUnifiedTask {

    /* renamed from: a, reason: collision with root package name */
    private j f٥٢٣٦a;

    /* renamed from: b, reason: collision with root package name */
    private Cache f٥٢٣٧b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f٥٢٣٨c = false;

    public a(j jVar, Cache cache) {
        this.f٥٢٣٦a = null;
        this.f٥٢٣٧b = null;
        this.f٥٢٣٦a = jVar;
        this.f٥٢٣٧b = cache;
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f٥٢٣٨c = true;
        this.f٥٢٣٦a.f٥٢٨١a.f٥٢٢٥b.ret = 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean equals;
        Cache.Entry entry;
        boolean z10;
        int i10;
        Cache cache;
        if (this.f٥٢٣٨c) {
            return;
        }
        anetwork.channel.entity.g gVar = this.f٥٢٣٦a.f٥٢٨١a;
        RequestStatistic requestStatistic = gVar.f٥٢٢٥b;
        if (this.f٥٢٣٧b != null) {
            String g10 = gVar.g();
            Request a10 = this.f٥٢٣٦a.f٥٢٨١a.a();
            String str = a10.getHeaders().get("Cache-Control");
            boolean equals2 = "no-store".equals(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (equals2) {
                this.f٥٢٣٧b.remove(g10);
                equals = false;
                entry = null;
            } else {
                equals = "no-cache".equals(str);
                entry = this.f٥٢٣٧b.get(g10);
                if (ALog.isPrintLog(2)) {
                    String str2 = this.f٥٢٣٦a.f٥٢٨٣c;
                    if (entry != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z10);
                    Long valueOf2 = Long.valueOf(requestStatistic.cacheTime);
                    if (entry != null) {
                        i10 = entry.data.length;
                    } else {
                        i10 = 0;
                    }
                    ALog.i("anet.CacheTask", "read cache", str2, "hit", valueOf, "cost", valueOf2, "length", Integer.valueOf(i10), TransferTable.COLUMN_KEY, g10);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            requestStatistic.cacheTime = currentTimeMillis2 - currentTimeMillis;
            if (entry != null && !equals && entry.isFresh()) {
                if (this.f٥٢٣٦a.f٥٢٨٤d.compareAndSet(false, true)) {
                    this.f٥٢٣٦a.a();
                    requestStatistic.ret = 1;
                    requestStatistic.statusCode = 200;
                    requestStatistic.msg = HttpConstant.SUCCESS;
                    requestStatistic.protocolType = "cache";
                    requestStatistic.rspEnd = currentTimeMillis2;
                    requestStatistic.processTime = currentTimeMillis2 - requestStatistic.start;
                    if (ALog.isPrintLog(2)) {
                        j jVar = this.f٥٢٣٦a;
                        ALog.i("anet.CacheTask", "hit fresh cache", jVar.f٥٢٨٣c, "URL", jVar.f٥٢٨١a.f().urlString());
                    }
                    this.f٥٢٣٦a.f٥٢٨٢b.onResponseCode(200, entry.responseHeaders);
                    Callback callback = this.f٥٢٣٦a.f٥٢٨٢b;
                    byte[] bArr = entry.data;
                    callback.onDataReceiveSize(1, bArr.length, ByteArray.wrap(bArr));
                    this.f٥٢٣٦a.f٥٢٨٢b.onFinish(new DefaultFinishEvent(200, HttpConstant.SUCCESS, a10));
                    return;
                }
                return;
            }
            if (this.f٥٢٣٨c) {
                return;
            }
            j jVar2 = this.f٥٢٣٦a;
            if (equals2) {
                cache = null;
            } else {
                cache = this.f٥٢٣٧b;
            }
            e eVar = new e(jVar2, cache, entry);
            this.f٥٢٣٦a.f٥٢٨٥e = eVar;
            eVar.run();
        }
    }
}
