package anet.channel.strategy;

import java.util.Comparator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class o implements Comparator<StrategyCollection> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(StrategyCollection strategyCollection, StrategyCollection strategyCollection2) {
        if (strategyCollection.f٤٩٤٨b != strategyCollection2.f٤٩٤٨b) {
            return (int) (strategyCollection.f٤٩٤٨b - strategyCollection2.f٤٩٤٨b);
        }
        return strategyCollection.f٤٩٤٧a.compareTo(strategyCollection2.f٤٩٤٧a);
    }
}
