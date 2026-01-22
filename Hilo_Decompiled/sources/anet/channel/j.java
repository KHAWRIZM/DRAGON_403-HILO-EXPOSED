package anet.channel;

import anetwork.channel.cache.CacheManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        try {
            anet.channel.b.a aVar = new anet.channel.b.a();
            aVar.a();
            CacheManager.addCache(aVar, new k(this), 1);
        } catch (Exception unused) {
        }
    }
}
