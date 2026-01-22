package anetwork.channel.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.IRemoteNetworkGetter;
import anetwork.channel.aidl.RemoteNetwork;
import anetwork.channel.degrade.DegradableNetworkDelegate;
import anetwork.channel.http.HttpNetworkDelegate;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NetworkService extends Service {

    /* renamed from: b, reason: collision with root package name */
    private Context f٥١١١b;

    /* renamed from: c, reason: collision with root package name */
    private RemoteNetwork.Stub f٥١١٢c = null;

    /* renamed from: d, reason: collision with root package name */
    private RemoteNetwork.Stub f٥١١٣d = null;

    /* renamed from: a, reason: collision with root package name */
    IRemoteNetworkGetter.Stub f٥١١٠a = new IRemoteNetworkGetter.Stub() { // from class: anetwork.channel.aidl.NetworkService.1
        @Override // anetwork.channel.aidl.IRemoteNetworkGetter
        public RemoteNetwork get(int i10) throws RemoteException {
            return i10 == 1 ? NetworkService.this.f٥١١٢c : NetworkService.this.f٥١١٣d;
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f٥١١١b = getApplicationContext();
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkService", "onBind:" + intent.getAction(), null, new Object[0]);
        }
        this.f٥١١٢c = new DegradableNetworkDelegate(this.f٥١١١b);
        this.f٥١١٣d = new HttpNetworkDelegate(this.f٥١١١b);
        if (!IRemoteNetworkGetter.class.getName().equals(intent.getAction())) {
            return null;
        }
        return this.f٥١١٠a;
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 2;
    }
}
