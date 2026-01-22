package anet.channel.strategy;

import anet.channel.strategy.StrategyList;
import anet.channel.strategy.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j implements StrategyList.Predicate<IPConnStrategy> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l.a f٥٠١١a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f٥٠١٢b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ConnProtocol f٥٠١٣c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrategyList f٥٠١٤d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(StrategyList strategyList, l.a aVar, String str, ConnProtocol connProtocol) {
        this.f٥٠١٤d = strategyList;
        this.f٥٠١١a = aVar;
        this.f٥٠١٢b = str;
        this.f٥٠١٣c = connProtocol;
    }

    @Override // anet.channel.strategy.StrategyList.Predicate
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(IPConnStrategy iPConnStrategy) {
        if (iPConnStrategy.getPort() == this.f٥٠١١a.f٥٠١٦a && iPConnStrategy.getIp().equals(this.f٥٠١٢b) && iPConnStrategy.protocol.equals(this.f٥٠١٣c)) {
            return true;
        }
        return false;
    }
}
