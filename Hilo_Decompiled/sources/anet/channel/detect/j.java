package anet.channel.detect;

import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class j implements IConnStrategy {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l.e f٤٧٣١a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ConnProtocol f٤٧٣٢b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(l.e eVar, ConnProtocol connProtocol) {
        this.f٤٧٣١a = eVar;
        this.f٤٧٣٢b = connProtocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.f٤٧٣١a.f٥٠٤٧b.f٥٠١٨c;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return 0;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.f٤٧٣١a.f٥٠٤٦a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return 2;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return 1;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.f٤٧٣١a.f٥٠٤٧b.f٥٠١٦a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.f٤٧٣٢b;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.f٤٧٣١a.f٥٠٤٧b.f٥٠١٩d;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return 0;
    }
}
