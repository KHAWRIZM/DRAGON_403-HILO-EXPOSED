package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpHelper;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class g implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f٤٩١٤a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f٤٩١٤a = fVar;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z10) {
        this.f٤٩١٤a.f٤٩١١b.onDataReceive(byteArray, z10);
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        if (i10 <= 0 && i10 != -204) {
            this.f٤٩١٤a.f٤٩١٣d.handleCallbacks(2, new anet.channel.entity.b(2, 0, "Http connect fail"));
        }
        this.f٤٩١٤a.f٤٩١١b.onFinish(i10, str, requestStatistic);
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i10, Map<String, List<String>> map) {
        ALog.i("awcn.HttpSession", "", this.f٤٩١٤a.f٤٩١٠a.getSeq(), "httpStatusCode", Integer.valueOf(i10));
        ALog.i("awcn.HttpSession", "", this.f٤٩١٤a.f٤٩١٠a.getSeq(), "response headers", map);
        this.f٤٩١٤a.f٤٩١١b.onResponseCode(i10, map);
        this.f٤٩١٤a.f٤٩١٢c.serverRT = HttpHelper.parseServerRT(map);
        f fVar = this.f٤٩١٤a;
        fVar.f٤٩١٣d.handleResponseCode(fVar.f٤٩١٠a, i10);
        f fVar2 = this.f٤٩١٤a;
        fVar2.f٤٩١٣d.handleResponseHeaders(fVar2.f٤٩١٠a, map);
    }
}
