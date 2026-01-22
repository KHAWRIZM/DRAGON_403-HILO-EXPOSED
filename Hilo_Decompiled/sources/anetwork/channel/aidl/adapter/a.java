package anetwork.channel.aidl.adapter;

import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.Response;
import anetwork.channel.aidl.ParcelableFuture;
import com.qiahao.base_common.network.BaseServer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements Future<Response> {

    /* renamed from: a, reason: collision with root package name */
    private ParcelableFuture f٥١١٩a;

    /* renamed from: b, reason: collision with root package name */
    private Response f٥١٢٠b;

    public a(ParcelableFuture parcelableFuture) {
        this.f٥١١٩a = parcelableFuture;
    }

    @Override // java.util.concurrent.Future
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Response get() throws InterruptedException, ExecutionException {
        Response response = this.f٥١٢٠b;
        if (response != null) {
            return response;
        }
        ParcelableFuture parcelableFuture = this.f٥١١٩a;
        if (parcelableFuture != null) {
            try {
                return parcelableFuture.get(BaseServer.TIMEOUT_PROD);
            } catch (RemoteException e10) {
                ALog.w("anet.FutureResponse", "[get]", null, e10, new Object[0]);
            }
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        ParcelableFuture parcelableFuture = this.f٥١١٩a;
        if (parcelableFuture == null) {
            return false;
        }
        try {
            return parcelableFuture.cancel(z10);
        } catch (RemoteException e10) {
            ALog.w("anet.FutureResponse", "[cancel]", null, e10, new Object[0]);
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        try {
            return this.f٥١١٩a.isCancelled();
        } catch (RemoteException e10) {
            ALog.w("anet.FutureResponse", "[isCancelled]", null, e10, new Object[0]);
            return false;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        try {
            return this.f٥١١٩a.isDone();
        } catch (RemoteException e10) {
            ALog.w("anet.FutureResponse", "[isDone]", null, e10, new Object[0]);
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ Response get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(j10);
    }

    public a(Response response) {
        this.f٥١٢٠b = response;
    }

    public Response a(long j10) throws InterruptedException, ExecutionException, TimeoutException {
        Response response = this.f٥١٢٠b;
        if (response != null) {
            return response;
        }
        ParcelableFuture parcelableFuture = this.f٥١١٩a;
        if (parcelableFuture != null) {
            try {
                return parcelableFuture.get(j10);
            } catch (RemoteException e10) {
                ALog.w("anet.FutureResponse", "[get(long timeout, TimeUnit unit)]", null, e10, new Object[0]);
            }
        }
        return null;
    }
}
