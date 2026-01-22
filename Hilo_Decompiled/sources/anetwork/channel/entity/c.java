package anetwork.channel.entity;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.ParcelableNetworkListener;
import anetwork.channel.aidl.adapter.ParcelableInputStreamImpl;
import anetwork.channel.interceptor.Callback;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements Callback {

    /* renamed from: a, reason: collision with root package name */
    private ParcelableNetworkListener f٥٢٠٧a;

    /* renamed from: b, reason: collision with root package name */
    private String f٥٢٠٨b;

    /* renamed from: c, reason: collision with root package name */
    private ParcelableInputStreamImpl f٥٢٠٩c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٥٢١٠d;

    /* renamed from: e, reason: collision with root package name */
    private g f٥٢١١e;

    public c(ParcelableNetworkListener parcelableNetworkListener, g gVar) {
        this.f٥٢١٠d = false;
        this.f٥٢٠٧a = parcelableNetworkListener;
        this.f٥٢١١e = gVar;
        if (parcelableNetworkListener != null) {
            try {
                if ((parcelableNetworkListener.getListenerState() & 8) != 0) {
                    this.f٥٢١٠d = true;
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // anetwork.channel.interceptor.Callback
    public void onDataReceiveSize(int i10, int i11, ByteArray byteArray) {
        ParcelableNetworkListener parcelableNetworkListener = this.f٥٢٠٧a;
        if (parcelableNetworkListener != null) {
            a(new e(this, i10, byteArray, i11, parcelableNetworkListener));
        }
    }

    @Override // anetwork.channel.interceptor.Callback
    public void onFinish(DefaultFinishEvent defaultFinishEvent) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onFinish] ", this.f٥٢٠٨b, new Object[0]);
        }
        ParcelableNetworkListener parcelableNetworkListener = this.f٥٢٠٧a;
        if (parcelableNetworkListener != null) {
            f fVar = new f(this, defaultFinishEvent, parcelableNetworkListener);
            RequestStatistic requestStatistic = defaultFinishEvent.rs;
            if (requestStatistic != null) {
                requestStatistic.rspCbDispatch = System.currentTimeMillis();
            }
            a(fVar);
        }
        this.f٥٢٠٧a = null;
    }

    @Override // anetwork.channel.interceptor.Callback
    public void onResponseCode(int i10, Map<String, List<String>> map) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onResponseCode]", this.f٥٢٠٨b, new Object[0]);
        }
        ParcelableNetworkListener parcelableNetworkListener = this.f٥٢٠٧a;
        if (parcelableNetworkListener != null) {
            a(new d(this, parcelableNetworkListener, i10, map));
        }
    }

    private void a(Runnable runnable) {
        if (this.f٥٢١١e.c()) {
            runnable.run();
        } else {
            String str = this.f٥٢٠٨b;
            a.a(str != null ? str.hashCode() : hashCode(), runnable);
        }
    }

    public void a(String str) {
        this.f٥٢٠٨b = str;
    }
}
