package anet.channel.strategy;

import anet.channel.AwcnConfig;
import anet.channel.entity.ConnType;
import anet.channel.util.ALog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h implements IStrategyFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f٥٠٠٩a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f٥٠٠٩a = gVar;
    }

    @Override // anet.channel.strategy.IStrategyFilter
    public boolean accept(IConnStrategy iConnStrategy) {
        String str = iConnStrategy.getProtocol().protocol;
        if (!ConnType.QUIC.equals(str) && !ConnType.QUIC_PLAIN.equals(str)) {
            boolean isHttp3Enable = AwcnConfig.isHttp3Enable();
            boolean b10 = anet.channel.e.a.b();
            if ((isHttp3Enable && b10) || (!ConnType.HTTP3.equals(str) && !ConnType.HTTP3_PLAIN.equals(str))) {
                return true;
            }
            ALog.i("awcn.StrategyCenter", "http3 strategy disabled", null, "strategy", iConnStrategy);
            return false;
        }
        ALog.i("awcn.StrategyCenter", "gquic strategy disabled", null, "strategy", iConnStrategy);
        return false;
    }
}
