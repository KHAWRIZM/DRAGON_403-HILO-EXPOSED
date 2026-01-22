package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f٤٨٢٤a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f٤٨٢٤a = bVar;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        e eVar;
        eVar = this.f٤٨٢٤a.f٤٨٢٢n;
        eVar.a();
        b.f٤٨١٤f = 0L;
        this.f٤٨٢٤a.d();
    }
}
