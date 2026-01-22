package anetwork.channel.unified;

import android.support.v4.media.session.PlaybackStateCompat;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ConnType;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.HttpUrl;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.config.NetworkConfigCenter;
import anetwork.channel.cookie.CookieManager;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.unified.e;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Request f٥٢٧٨a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ RequestStatistic f٥٢٧٩b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f٥٢٨٠c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar, Request request, RequestStatistic requestStatistic) {
        this.f٥٢٨٠c = eVar;
        this.f٥٢٧٨a = request;
        this.f٥٢٧٩b = requestStatistic;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z10) {
        boolean z11;
        if (this.f٥٢٨٠c.f٥٢٥٥h.get()) {
            return;
        }
        e eVar = this.f٥٢٨٠c;
        if (eVar.f٥٢٥٧j == 0) {
            ALog.i(e.TAG, "[onDataReceive] receive first data chunk!", eVar.f٥٢٤٨a.f٥٢٨٣c, new Object[0]);
        }
        if (z10) {
            ALog.i(e.TAG, "[onDataReceive] receive last data chunk!", this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٣c, new Object[0]);
        }
        e eVar2 = this.f٥٢٨٠c;
        int i10 = eVar2.f٥٢٥٧j + 1;
        eVar2.f٥٢٥٧j = i10;
        try {
            e.a aVar = eVar2.f٥٢٦٠m;
            if (aVar != null) {
                aVar.f٥٢٦٣c.add(byteArray);
                if (this.f٥٢٧٩b.recDataSize > PlaybackStateCompat.ACTION_PREPARE_FROM_URI || z10) {
                    e eVar3 = this.f٥٢٨٠c;
                    eVar3.f٥٢٥٧j = eVar3.f٥٢٦٠m.a(eVar3.f٥٢٤٨a.f٥٢٨٢b, eVar3.f٥٢٥٦i);
                    e eVar4 = this.f٥٢٨٠c;
                    eVar4.f٥٢٥٨k = true;
                    if (eVar4.f٥٢٥٧j > 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    eVar4.f٥٢٥٩l = z11;
                    eVar4.f٥٢٦٠m = null;
                }
            } else {
                eVar2.f٥٢٤٨a.f٥٢٨٢b.onDataReceiveSize(i10, eVar2.f٥٢٥٦i, byteArray);
                this.f٥٢٨٠c.f٥٢٥٩l = true;
            }
            ByteArrayOutputStream byteArrayOutputStream = this.f٥٢٨٠c.f٥٢٥١d;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.write(byteArray.getBuffer(), 0, byteArray.getDataLength());
                if (z10) {
                    String g10 = this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨١a.g();
                    e eVar5 = this.f٥٢٨٠c;
                    eVar5.f٥٢٥٠c.data = eVar5.f٥٢٥١d.toByteArray();
                    long currentTimeMillis = System.currentTimeMillis();
                    e eVar6 = this.f٥٢٨٠c;
                    eVar6.f٥٢٤٩b.put(g10, eVar6.f٥٢٥٠c);
                    ALog.i(e.TAG, "write cache", this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٣c, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "size", Integer.valueOf(this.f٥٢٨٠c.f٥٢٥٠c.data.length), TransferTable.COLUMN_KEY, g10);
                }
            }
        } catch (Exception e10) {
            ALog.w(e.TAG, "[onDataReceive] error.", this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٣c, e10, new Object[0]);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        String valueOf;
        int i11;
        DefaultFinishEvent defaultFinishEvent;
        int i12 = 3;
        if (this.f٥٢٨٠c.f٥٢٥٥h.getAndSet(true)) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i(e.TAG, "[onFinish]", this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٣c, "code", Integer.valueOf(i10), "msg", str);
        }
        if (i10 < 0) {
            try {
                if (this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨١a.d()) {
                    e eVar = this.f٥٢٨٠c;
                    if (!eVar.f٥٢٥٨k && !eVar.f٥٢٥٩l) {
                        ALog.e(e.TAG, "clear response buffer and retry", eVar.f٥٢٤٨a.f٥٢٨٣c, new Object[0]);
                        e.a aVar = this.f٥٢٨٠c.f٥٢٦٠m;
                        if (aVar != null) {
                            if (!aVar.f٥٢٦٣c.isEmpty()) {
                                i12 = 4;
                            }
                            requestStatistic.roaming = i12;
                            this.f٥٢٨٠c.f٥٢٦٠m.a();
                            this.f٥٢٨٠c.f٥٢٦٠m = null;
                        }
                        if (this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨١a.f٥٢٢٤a == 0) {
                            requestStatistic.firstProtocol = requestStatistic.protocolType;
                            if (requestStatistic.tnetErrorCode != 0) {
                                i11 = requestStatistic.tnetErrorCode;
                            } else {
                                i11 = i10;
                            }
                            requestStatistic.firstErrorCode = i11;
                        }
                        this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨١a.k();
                        this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٤d = new AtomicBoolean();
                        e eVar2 = this.f٥٢٨٠c;
                        j jVar = eVar2.f٥٢٤٨a;
                        jVar.f٥٢٨٥e = new e(jVar, eVar2.f٥٢٤٩b, eVar2.f٥٢٥٠c);
                        if (requestStatistic.tnetErrorCode != 0) {
                            valueOf = i10 + "|" + requestStatistic.protocolType + "|" + requestStatistic.tnetErrorCode;
                            requestStatistic.tnetErrorCode = 0;
                        } else {
                            valueOf = String.valueOf(i10);
                        }
                        requestStatistic.appendErrorTrace(valueOf);
                        long currentTimeMillis = System.currentTimeMillis();
                        requestStatistic.retryCostTime += currentTimeMillis - requestStatistic.start;
                        requestStatistic.start = currentTimeMillis;
                        ThreadPoolExecutorFactory.submitPriorityTask(this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٥e, ThreadPoolExecutorFactory.Priority.HIGH);
                        return;
                    }
                    requestStatistic.msg += ":回调后触发重试";
                    e eVar3 = this.f٥٢٨٠c;
                    if (eVar3.f٥٢٥٩l) {
                        requestStatistic.roaming = 2;
                    } else if (eVar3.f٥٢٥٨k) {
                        requestStatistic.roaming = 1;
                    }
                    ALog.e(e.TAG, "Cannot retry request after onHeader/onDataReceived callback!", eVar3.f٥٢٤٨a.f٥٢٨٣c, new Object[0]);
                }
            } catch (Exception unused) {
                return;
            }
        }
        e eVar4 = this.f٥٢٨٠c;
        e.a aVar2 = eVar4.f٥٢٦٠m;
        if (aVar2 != null) {
            aVar2.a(eVar4.f٥٢٤٨a.f٥٢٨٢b, eVar4.f٥٢٥٦i);
        }
        this.f٥٢٨٠c.f٥٢٤٨a.a();
        requestStatistic.isDone.set(true);
        if (this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨١a.j() && requestStatistic.contentLength != 0 && requestStatistic.contentLength != requestStatistic.rspBodyDeflateSize) {
            requestStatistic.ret = 0;
            i10 = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
            requestStatistic.statusCode = ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH;
            str = ErrorConstant.getErrMsg(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH);
            requestStatistic.msg = str;
            e eVar5 = this.f٥٢٨٠c;
            ALog.e(e.TAG, "received data length not match with content-length", eVar5.f٥٢٤٨a.f٥٢٨٣c, "content-length", Integer.valueOf(eVar5.f٥٢٥٦i), "recDataLength", Long.valueOf(requestStatistic.rspBodyDeflateSize));
            ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_DATA_LENGTH_NOT_MATCH, str, "rt");
            exceptionStatistic.url = this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨١a.g();
            AppMonitor.getInstance().commitStat(exceptionStatistic);
        }
        if (i10 == 304 && this.f٥٢٨٠c.f٥٢٥٠c != null) {
            requestStatistic.protocolType = "cache";
            defaultFinishEvent = new DefaultFinishEvent(200, str, this.f٥٢٧٨a);
        } else {
            defaultFinishEvent = new DefaultFinishEvent(i10, str, this.f٥٢٧٨a);
        }
        this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٢b.onFinish(defaultFinishEvent);
        if (i10 >= 0) {
            anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.rspHeadDeflateSize + requestStatistic.rspBodyDeflateSize);
        } else {
            requestStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        }
        NetworkAnalysis.getInstance().commitFlow(new FlowStat(this.f٥٢٨٠c.f٥٢٥٢e, requestStatistic));
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i10, Map<String, List<String>> map) {
        String singleHeaderFieldByKey;
        if (this.f٥٢٨٠c.f٥٢٥٥h.get()) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i(e.TAG, "onResponseCode", this.f٥٢٧٨a.getSeq(), "code", Integer.valueOf(i10));
            ALog.i(e.TAG, "onResponseCode", this.f٥٢٧٨a.getSeq(), "headers", map);
        }
        if (HttpHelper.checkRedirect(this.f٥٢٧٨a, i10) && (singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, "Location")) != null) {
            HttpUrl parse = HttpUrl.parse(singleHeaderFieldByKey);
            if (parse != null) {
                if (this.f٥٢٨٠c.f٥٢٥٥h.compareAndSet(false, true)) {
                    parse.lockScheme();
                    this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨١a.a(parse);
                    this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٤d = new AtomicBoolean();
                    j jVar = this.f٥٢٨٠c.f٥٢٤٨a;
                    jVar.f٥٢٨٥e = new e(jVar, null, null);
                    this.f٥٢٧٩b.recordRedirect(i10, parse.simpleUrlString());
                    this.f٥٢٧٩b.locationUrl = singleHeaderFieldByKey;
                    ThreadPoolExecutorFactory.submitPriorityTask(this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٥e, ThreadPoolExecutorFactory.Priority.HIGH);
                    return;
                }
                return;
            }
            ALog.e(e.TAG, "redirect url is invalid!", this.f٥٢٧٨a.getSeq(), "redirect url", singleHeaderFieldByKey);
        }
        try {
            this.f٥٢٨٠c.f٥٢٤٨a.a();
            CookieManager.setCookie(this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨١a.g(), map);
            this.f٥٢٨٠c.f٥٢٥٦i = HttpHelper.parseContentLength(map);
            String g10 = this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨١a.g();
            e eVar = this.f٥٢٨٠c;
            Cache.Entry entry = eVar.f٥٢٥٠c;
            if (entry != null && i10 == 304) {
                entry.responseHeaders.putAll(map);
                Cache.Entry a10 = anetwork.channel.cache.a.a(map);
                if (a10 != null) {
                    long j10 = a10.ttl;
                    Cache.Entry entry2 = this.f٥٢٨٠c.f٥٢٥٠c;
                    if (j10 > entry2.ttl) {
                        entry2.ttl = j10;
                    }
                }
                e eVar2 = this.f٥٢٨٠c;
                eVar2.f٥٢٤٨a.f٥٢٨٢b.onResponseCode(200, eVar2.f٥٢٥٠c.responseHeaders);
                e eVar3 = this.f٥٢٨٠c;
                Callback callback = eVar3.f٥٢٤٨a.f٥٢٨٢b;
                byte[] bArr = eVar3.f٥٢٥٠c.data;
                callback.onDataReceiveSize(1, bArr.length, ByteArray.wrap(bArr));
                long currentTimeMillis = System.currentTimeMillis();
                e eVar4 = this.f٥٢٨٠c;
                eVar4.f٥٢٤٩b.put(g10, eVar4.f٥٢٥٠c);
                ALog.i(e.TAG, "update cache", this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٣c, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), TransferTable.COLUMN_KEY, g10);
                return;
            }
            if (eVar.f٥٢٤٩b != null) {
                if ("no-store".equals(HttpHelper.getSingleHeaderFieldByKey(map, "Cache-Control"))) {
                    this.f٥٢٨٠c.f٥٢٤٩b.remove(g10);
                } else {
                    e eVar5 = this.f٥٢٨٠c;
                    Cache.Entry a11 = anetwork.channel.cache.a.a(map);
                    eVar5.f٥٢٥٠c = a11;
                    if (a11 != null) {
                        HttpHelper.removeHeaderFiledByKey(map, "Cache-Control");
                        map.put("Cache-Control", Arrays.asList("no-store"));
                        e eVar6 = this.f٥٢٨٠c;
                        int i11 = this.f٥٢٨٠c.f٥٢٥٦i;
                        if (i11 == 0) {
                            i11 = 5120;
                        }
                        eVar6.f٥٢٥١d = new ByteArrayOutputStream(i11);
                    }
                }
            }
            map.put(HttpConstant.X_PROTOCOL, Arrays.asList(this.f٥٢٧٩b.protocolType));
            if (!ConnType.PK_OPEN.equalsIgnoreCase(HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.STREAMING_PARSER)) && NetworkConfigCenter.isResponseBufferEnable()) {
                e eVar7 = this.f٥٢٨٠c;
                if (eVar7.f٥٢٥٦i <= 131072) {
                    eVar7.f٥٢٦٠m = new e.a(i10, map);
                    return;
                }
            }
            this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٢b.onResponseCode(i10, map);
            this.f٥٢٨٠c.f٥٢٥٨k = true;
        } catch (Exception e10) {
            ALog.w(e.TAG, "[onResponseCode] error.", this.f٥٢٨٠c.f٥٢٤٨a.f٥٢٨٣c, e10, new Object[0]);
        }
    }
}
