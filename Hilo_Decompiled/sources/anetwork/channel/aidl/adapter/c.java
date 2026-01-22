package anetwork.channel.aidl.adapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f٥١٢١a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f٥١٢٢b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ParcelableNetworkListenerWrapper f٥١٢٣c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ParcelableNetworkListenerWrapper parcelableNetworkListenerWrapper, byte b10, Object obj) {
        this.f٥١٢٣c = parcelableNetworkListenerWrapper;
        this.f٥١٢١a = b10;
        this.f٥١٢٢b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f٥١٢٣c.dispatchCallback(this.f٥١٢١a, this.f٥١٢٢b);
    }
}
