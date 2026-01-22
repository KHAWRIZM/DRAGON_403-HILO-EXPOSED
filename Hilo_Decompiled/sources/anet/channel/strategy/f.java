package anet.channel.strategy;

import anet.channel.statist.StrategyStatObject;
import anet.channel.strategy.StrategyInfoHolder;
import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f٥٠٠٢a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder.LruStrategyMap f٥٠٠٣b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(StrategyInfoHolder.LruStrategyMap lruStrategyMap, Map.Entry entry) {
        this.f٥٠٠٣b = lruStrategyMap;
        this.f٥٠٠٢a = entry;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyTable strategyTable = (StrategyTable) this.f٥٠٠٢a.getValue();
        if (strategyTable.f٤٩٧٢d) {
            StrategyStatObject strategyStatObject = new StrategyStatObject(1);
            strategyStatObject.writeStrategyFileId = strategyTable.f٤٩٦٩a;
            m.a((Serializable) this.f٥٠٠٢a.getValue(), strategyTable.f٤٩٦٩a, strategyStatObject);
            strategyTable.f٤٩٧٢d = false;
        }
    }
}
