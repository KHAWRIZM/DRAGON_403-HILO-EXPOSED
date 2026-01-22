package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableNetworkListener;
import anetwork.channel.aidl.adapter.ParcelableInputStreamImpl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f٥٢١٦a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ByteArray f٥٢١٧b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f٥٢١٨c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ParcelableNetworkListener f٥٢١٩d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ c f٥٢٢٠e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i10, ByteArray byteArray, int i11, ParcelableNetworkListener parcelableNetworkListener) {
        this.f٥٢٢٠e = cVar;
        this.f٥٢١٦a = i10;
        this.f٥٢١٧b = byteArray;
        this.f٥٢١٨c = i11;
        this.f٥٢١٩d = parcelableNetworkListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z10;
        ParcelableInputStreamImpl parcelableInputStreamImpl;
        ParcelableInputStreamImpl parcelableInputStreamImpl2;
        ParcelableInputStreamImpl parcelableInputStreamImpl3;
        ParcelableInputStreamImpl parcelableInputStreamImpl4;
        ParcelableInputStreamImpl parcelableInputStreamImpl5;
        g gVar;
        ParcelableInputStreamImpl parcelableInputStreamImpl6;
        ParcelableInputStreamImpl parcelableInputStreamImpl7;
        z10 = this.f٥٢٢٠e.f٥٢١٠d;
        try {
            if (z10) {
                try {
                    parcelableInputStreamImpl3 = this.f٥٢٢٠e.f٥٢٠٩c;
                    if (parcelableInputStreamImpl3 != null) {
                        parcelableInputStreamImpl4 = this.f٥٢٢٠e.f٥٢٠٩c;
                        parcelableInputStreamImpl4.write(this.f٥٢١٧b);
                    } else {
                        this.f٥٢٢٠e.f٥٢٠٩c = new ParcelableInputStreamImpl();
                        parcelableInputStreamImpl5 = this.f٥٢٢٠e.f٥٢٠٩c;
                        gVar = this.f٥٢٢٠e.f٥٢١١e;
                        parcelableInputStreamImpl5.init(gVar, this.f٥٢١٨c);
                        parcelableInputStreamImpl6 = this.f٥٢٢٠e.f٥٢٠٩c;
                        parcelableInputStreamImpl6.write(this.f٥٢١٧b);
                        ParcelableNetworkListener parcelableNetworkListener = this.f٥٢١٩d;
                        parcelableInputStreamImpl7 = this.f٥٢٢٠e.f٥٢٠٩c;
                        parcelableNetworkListener.onInputStreamGet(parcelableInputStreamImpl7);
                    }
                } catch (Exception unused) {
                    parcelableInputStreamImpl = this.f٥٢٢٠e.f٥٢٠٩c;
                    if (parcelableInputStreamImpl != null) {
                        parcelableInputStreamImpl2 = this.f٥٢٢٠e.f٥٢٠٩c;
                        parcelableInputStreamImpl2.close();
                    }
                }
            } else {
                this.f٥٢١٩d.onDataReceived(new DefaultProgressEvent(this.f٥٢١٦a, this.f٥٢١٧b.getDataLength(), this.f٥٢١٨c, this.f٥٢١٧b.getBuffer()));
            }
        } catch (RemoteException unused2) {
        }
    }
}
