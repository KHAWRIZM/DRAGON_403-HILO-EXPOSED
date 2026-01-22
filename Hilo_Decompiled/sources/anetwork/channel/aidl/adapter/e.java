package anetwork.channel.aidl.adapter;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import anet.channel.util.ALog;
import anetwork.channel.aidl.IRemoteNetworkGetter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class e implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.RemoteGetter", "[onServiceConnected]ANet_Service start success. ANet run with service mode", null, new Object[0]);
        }
        synchronized (d.class) {
            try {
                d.f٥١٢٤a = IRemoteNetworkGetter.Stub.asInterface(iBinder);
                if (d.f٥١٢٧d != null) {
                    d.f٥١٢٧d.countDown();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        d.f٥١٢٥b = false;
        d.f٥١٢٦c = false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.RemoteGetter", "ANet_Service Disconnected", null, new Object[0]);
        }
        d.f٥١٢٤a = null;
        d.f٥١٢٦c = false;
        if (d.f٥١٢٧d != null) {
            d.f٥١٢٧d.countDown();
        }
    }
}
