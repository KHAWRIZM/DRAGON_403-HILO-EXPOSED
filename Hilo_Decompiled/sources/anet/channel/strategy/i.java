package anet.channel.strategy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f٥٠١٠a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f٥٠١٠a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a10;
        a10 = this.f٥٠١٠a.a();
        if (!a10) {
            this.f٥٠١٠a.f٥٠٠٥b.c();
        }
    }
}
