package anetwork.channel.entity;

import android.os.RemoteException;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.ParcelableNetworkListener;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ParcelableNetworkListener f٥٢١٢a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f٥٢١٣b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Map f٥٢١٤c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ c f٥٢١٥d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, ParcelableNetworkListener parcelableNetworkListener, int i10, Map map) {
        this.f٥٢١٥d = cVar;
        this.f٥٢١٢a = parcelableNetworkListener;
        this.f٥٢١٣b = i10;
        this.f٥٢١٤c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f٥٢١٢a.onResponseCode(this.f٥٢١٣b, new ParcelableHeader(this.f٥٢١٣b, this.f٥٢١٤c));
        } catch (RemoteException unused) {
        }
    }
}
