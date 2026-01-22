package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetworkStatusHelper.NetworkStatus f٤٧٣٥a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f٤٧٣٦b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f٤٧٣٦b = lVar;
        this.f٤٧٣٥a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            NetworkStatusHelper.NetworkStatus networkStatus = this.f٤٧٣٥a;
            if (networkStatus != NetworkStatusHelper.NetworkStatus.NO && networkStatus != NetworkStatusHelper.NetworkStatus.NONE) {
                this.f٤٧٣٦b.f٤٧٣٤a.a(NetworkStatusHelper.getUniqueId(networkStatus));
            }
        } catch (Throwable th) {
            ALog.e("anet.MTUDetector", "MTU detecet fail.", null, th, new Object[0]);
        }
    }
}
