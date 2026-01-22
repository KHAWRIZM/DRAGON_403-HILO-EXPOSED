package anet.channel.strategy;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f٥٠٠٠a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrategyInfoHolder f٥٠٠١b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f٥٠٠١b = strategyInfoHolder;
        this.f٥٠٠٠a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f٥٠٠١b.a(this.f٥٠٠٠a, true);
    }
}
