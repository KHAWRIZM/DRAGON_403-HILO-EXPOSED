package anetwork.channel.aidl.adapter;

import android.os.RemoteException;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.Response;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ParcelableFutureResponse extends ParcelableFuture.Stub {
    private static final String TAG = "anet.ParcelableFutureResponse";
    Future<Response> future;
    NetworkResponse response;

    public ParcelableFutureResponse(Future<Response> future) {
        this.future = future;
    }

    @Override // anetwork.channel.aidl.ParcelableFuture
    public boolean cancel(boolean z10) throws RemoteException {
        Future<Response> future = this.future;
        if (future == null) {
            return true;
        }
        return future.cancel(z10);
    }

    @Override // anetwork.channel.aidl.ParcelableFuture
    public NetworkResponse get(long j10) throws RemoteException {
        Future<Response> future = this.future;
        if (future == null) {
            NetworkResponse networkResponse = this.response;
            if (networkResponse != null) {
                return networkResponse;
            }
            return new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
        try {
            return (NetworkResponse) future.get(j10, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            if ("NO SUPPORT".equalsIgnoreCase(e10.getMessage())) {
                ALog.e(TAG, "[get]有listener将不支持future.get()方法，如有需要请listener传入null", null, e10, new Object[0]);
            }
            return new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
    }

    @Override // anetwork.channel.aidl.ParcelableFuture
    public boolean isCancelled() throws RemoteException {
        Future<Response> future = this.future;
        if (future == null) {
            return true;
        }
        return future.isCancelled();
    }

    @Override // anetwork.channel.aidl.ParcelableFuture
    public boolean isDone() throws RemoteException {
        Future<Response> future = this.future;
        if (future == null) {
            return true;
        }
        return future.isDone();
    }
}
