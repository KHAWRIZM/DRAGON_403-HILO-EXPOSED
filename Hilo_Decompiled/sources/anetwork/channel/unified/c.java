package anetwork.channel.unified;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cookie.CookieManager;
import anetwork.channel.interceptor.Callback;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class c implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f٥٢٤٥a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f٥٢٤٥a = bVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z10) {
        j jVar;
        j jVar2;
        j jVar3;
        int i10;
        int i11;
        jVar = this.f٥٢٤٥a.f٥٢٤١c;
        if (jVar.f٥٢٨٤d.get()) {
            return;
        }
        b.b(this.f٥٢٤٥a);
        jVar2 = this.f٥٢٤٥a.f٥٢٤١c;
        if (jVar2.f٥٢٨٢b != null) {
            jVar3 = this.f٥٢٤٥a.f٥٢٤١c;
            Callback callback = jVar3.f٥٢٨٢b;
            i10 = this.f٥٢٤٥a.f٥٢٤٣e;
            i11 = this.f٥٢٤٥a.f٥٢٤٢d;
            callback.onDataReceiveSize(i10, i11, byteArray);
        }
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        Request request;
        j jVar5;
        jVar = this.f٥٢٤٥a.f٥٢٤١c;
        if (jVar.f٥٢٨٤d.getAndSet(true)) {
            return;
        }
        if (ALog.isPrintLog(2)) {
            jVar5 = this.f٥٢٤٥a.f٥٢٤١c;
            ALog.i("anet.DegradeTask", "[onFinish]", jVar5.f٥٢٨٣c, "code", Integer.valueOf(i10), "msg", str);
        }
        jVar2 = this.f٥٢٤٥a.f٥٢٤١c;
        jVar2.a();
        requestStatistic.isDone.set(true);
        jVar3 = this.f٥٢٤٥a.f٥٢٤١c;
        if (jVar3.f٥٢٨٢b != null) {
            jVar4 = this.f٥٢٤٥a.f٥٢٤١c;
            Callback callback = jVar4.f٥٢٨٢b;
            request = this.f٥٢٤٥a.f٥٢٤٤f;
            callback.onFinish(new DefaultFinishEvent(i10, str, request));
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i10, Map<String, List<String>> map) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        jVar = this.f٥٢٤٥a.f٥٢٤١c;
        if (!jVar.f٥٢٨٤d.get()) {
            jVar2 = this.f٥٢٤٥a.f٥٢٤١c;
            jVar2.a();
            jVar3 = this.f٥٢٤٥a.f٥٢٤١c;
            CookieManager.setCookie(jVar3.f٥٢٨١a.g(), map);
            this.f٥٢٤٥a.f٥٢٤٢d = HttpHelper.parseContentLength(map);
            jVar4 = this.f٥٢٤٥a.f٥٢٤١c;
            if (jVar4.f٥٢٨٢b != null) {
                jVar5 = this.f٥٢٤٥a.f٥٢٤١c;
                jVar5.f٥٢٨٢b.onResponseCode(i10, map);
            }
        }
    }
}
