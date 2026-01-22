package anetwork.channel.aidl.adapter;

import anet.channel.util.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class f implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        if (d.f٥١٢٦c) {
            d.f٥١٢٦c = false;
            ALog.e("anet.RemoteGetter", "binding service timeout. reset status!", null, new Object[0]);
        }
    }
}
