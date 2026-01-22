package anet.channel;

import anet.channel.util.HttpConstant;
import anetwork.channel.cache.CachePrediction;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class k implements CachePrediction {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f٤٨٠٣a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f٤٨٠٣a = jVar;
    }

    @Override // anetwork.channel.cache.CachePrediction
    public boolean handleCache(String str, Map<String, String> map) {
        return "weex".equals(map.get(HttpConstant.F_REFER));
    }
}
