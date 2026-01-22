package anetwork.channel.entity;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.detect.n;
import anet.channel.statist.RequestMonitor;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.ParcelableNetworkListener;
import anetwork.channel.aidl.adapter.ParcelableInputStreamImpl;
import anetwork.channel.config.NetworkConfigCenter;
import anetwork.channel.stat.INetworkStat;
import anetwork.channel.stat.NetworkStat;
import anetwork.channel.util.RequestConstant;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ DefaultFinishEvent f٥٢٢١a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ParcelableNetworkListener f٥٢٢٢b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f٥٢٢٣c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, DefaultFinishEvent defaultFinishEvent, ParcelableNetworkListener parcelableNetworkListener) {
        this.f٥٢٢٣c = cVar;
        this.f٥٢٢١a = defaultFinishEvent;
        this.f٥٢٢٢b = parcelableNetworkListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        ParcelableInputStreamImpl parcelableInputStreamImpl;
        String str;
        g gVar;
        g gVar2;
        String str2;
        ParcelableInputStreamImpl parcelableInputStreamImpl2;
        DefaultFinishEvent defaultFinishEvent = this.f٥٢٢١a;
        String str3 = null;
        if (defaultFinishEvent != null) {
            defaultFinishEvent.setContext(null);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            RequestStatistic requestStatistic = this.f٥٢٢١a.rs;
            if (requestStatistic != null) {
                requestStatistic.rspCbStart = currentTimeMillis;
                requestStatistic.lastProcessTime = currentTimeMillis - requestStatistic.rspEnd;
                requestStatistic.oneWayTime = requestStatistic.retryCostTime + (currentTimeMillis - requestStatistic.start);
                this.f٥٢٢١a.getStatisticData().filledBy(requestStatistic);
            }
            this.f٥٢٢٢b.onFinished(this.f٥٢٢١a);
            if (requestStatistic != null) {
                long currentTimeMillis2 = System.currentTimeMillis();
                requestStatistic.rspCbEnd = currentTimeMillis2;
                requestStatistic.callbackTime = currentTimeMillis2 - currentTimeMillis;
                anet.channel.fulltrace.a.a().commitRequest(requestStatistic.traceId, requestStatistic);
            }
            parcelableInputStreamImpl = this.f٥٢٢٣c.f٥٢٠٩c;
            if (parcelableInputStreamImpl != null) {
                parcelableInputStreamImpl2 = this.f٥٢٢٣c.f٥٢٠٩c;
                parcelableInputStreamImpl2.writeEnd();
            }
            if (requestStatistic != null) {
                String str4 = "[traceId:" + requestStatistic.traceId + "]end, " + requestStatistic.toString();
                str = this.f٥٢٢٣c.f٥٢٠٨b;
                ALog.e("anet.Repeater", str4, str, new Object[0]);
                CopyOnWriteArrayList<String> bucketInfo = GlobalAppRuntimeInfo.getBucketInfo();
                if (bucketInfo != null) {
                    int size = bucketInfo.size();
                    for (int i10 = 0; i10 < size - 1; i10 += 2) {
                        requestStatistic.putExtra(bucketInfo.get(i10), bucketInfo.get(i10 + 1));
                    }
                }
                if (GlobalAppRuntimeInfo.isAppBackground()) {
                    requestStatistic.putExtra("restrictBg", Integer.valueOf(NetworkStatusHelper.getRestrictBackgroundStatus()));
                }
                anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
                if (sceneInfo != null) {
                    String bVar = sceneInfo.toString();
                    str2 = this.f٥٢٢٣c.f٥٢٠٨b;
                    ALog.i("anet.Repeater", bVar, str2, new Object[0]);
                    long j10 = requestStatistic.start;
                    long j11 = sceneInfo.f٤٧٨٢c;
                    requestStatistic.sinceInitTime = j10 - j11;
                    int i11 = sceneInfo.f٤٧٨٠a;
                    requestStatistic.startType = i11;
                    if (i11 != 1) {
                        requestStatistic.sinceLastLaunchTime = j11 - sceneInfo.f٤٧٨٣d;
                    }
                    requestStatistic.deviceLevel = sceneInfo.f٤٧٨٤e;
                    requestStatistic.isFromExternal = sceneInfo.f٤٧٨١b ? 1 : 0;
                    requestStatistic.speedBucket = sceneInfo.f٤٧٨٥f;
                    requestStatistic.abTestBucket = sceneInfo.f٤٧٨٦g;
                }
                requestStatistic.serializeTransferTime = requestStatistic.reqServiceTransmissionEnd - requestStatistic.netReqStart;
                gVar = this.f٥٢٢٣c.f٥٢١١e;
                requestStatistic.userInfo = gVar.a(RequestConstant.REQUEST_USER_INFO);
                AppMonitor.getInstance().commitStat(requestStatistic);
                if (NetworkConfigCenter.isRequestInMonitorList(requestStatistic)) {
                    AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                }
                try {
                    String str5 = requestStatistic.ip;
                    JSONObject jSONObject = requestStatistic.extra;
                    if (jSONObject != null) {
                        str3 = jSONObject.optString("firstIp");
                    }
                    if (anet.channel.strategy.utils.c.b(str5) || anet.channel.strategy.utils.c.b(str3)) {
                        AppMonitor.getInstance().commitStat(new RequestMonitor(requestStatistic));
                    }
                } catch (Exception unused) {
                }
                INetworkStat networkStat = NetworkStat.getNetworkStat();
                gVar2 = this.f٥٢٢٣c.f٥٢١١e;
                networkStat.put(gVar2.g(), this.f٥٢٢١a.getStatisticData());
                n.a(requestStatistic);
            }
        } catch (Throwable unused2) {
        }
    }
}
