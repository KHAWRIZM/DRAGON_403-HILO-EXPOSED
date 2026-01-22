package anet.channel.util;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.NetTypeStat;
import anet.channel.status.NetworkStatusHelper;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f٥٠٨١a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f٥٠٨١a = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        r0 = anet.channel.util.c.k();
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        String b10;
        int j10;
        f k10;
        try {
            b10 = c.b(NetworkStatusHelper.getStatus());
            if (!this.f٥٠٨١a.f٥٠٧٩a.equals(b10)) {
                return;
            }
            ALog.e("awcn.Inet64Util", "startIpStackDetect double check", null, new Object[0]);
            j10 = c.j();
            d dVar = this.f٥٠٨١a;
            if (dVar.f٥٠٨٠b.ipStackType != j10) {
                c.f٥٠٧٨e.put(dVar.f٥٠٧٩a, Integer.valueOf(j10));
                NetTypeStat netTypeStat = this.f٥٠٨١a.f٥٠٨٠b;
                netTypeStat.lastIpStackType = netTypeStat.ipStackType;
                netTypeStat.ipStackType = j10;
            }
            if ((j10 == 2 || j10 == 3) && k10 != null) {
                c.f٥٠٧٧d.put(this.f٥٠٨١a.f٥٠٧٩a, k10);
                this.f٥٠٨١a.f٥٠٨٠b.nat64Prefix = k10.toString();
            }
            if (GlobalAppRuntimeInfo.isTargetProcess()) {
                AppMonitor.getInstance().commitStat(this.f٥٠٨١a.f٥٠٨٠b);
            }
        } catch (Exception unused) {
        }
    }
}
