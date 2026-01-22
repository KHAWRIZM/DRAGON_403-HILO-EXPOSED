package c;

import android.net.ConnectivityManager;
import android.net.Network;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f٥٦٢٦a;

    public a(d dVar) {
        this.f٥٦٢٦a = dVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        d dVar = this.f٥٦٢٦a;
        d.a(dVar.f٥٦٢٩b);
        if (dVar.f٥٦٢٨a.size() <= 0) {
            return;
        }
        dVar.f٥٦٢٨a.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        super.onLost(network);
        d dVar = this.f٥٦٢٦a;
        d.a(dVar.f٥٦٢٩b);
        if (dVar.f٥٦٢٨a.size() <= 0) {
            return;
        }
        dVar.f٥٦٢٨a.get(0).getClass();
        throw new ClassCastException();
    }
}
