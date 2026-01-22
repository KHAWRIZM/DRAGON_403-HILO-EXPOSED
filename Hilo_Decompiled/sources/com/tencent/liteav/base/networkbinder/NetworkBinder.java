package com.tencent.liteav.base.networkbinder;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;

@JNINamespace("liteav")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NetworkBinder {
    public static final int CELLULAR = 2;
    public static final int DEFAULT = 0;
    private static final String TAG = "NetworkBinder";
    public static final int WIFI = 1;
    private static boolean isPrint = true;
    private long mNativeNetworkBinderJni;
    private final Object mLocker = new Object();
    private boolean mIsActivatingNetwork = false;
    private boolean mIsNetworkAvailable = false;
    private int mNetworkType = 0;
    private ConnectivityManager.NetworkCallback mNetworkCallback = null;
    private final Runnable mTimeoutRunnable = new Runnable() { // from class: com.tencent.liteav.base.networkbinder.NetworkBinder.1
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (NetworkBinder.this.mLocker) {
                try {
                    if (NetworkBinder.this.mIsActivatingNetwork && NetworkBinder.this.checkNativeValid()) {
                        NetworkBinder.nativeOnNetworkAvailable(NetworkBinder.this.mNativeNetworkBinderJni, "", false);
                        LiteavLog.e(NetworkBinder.TAG, "[BindSocket]:activate network timeout");
                        NetworkBinder.this.mIsActivatingNetwork = false;
                        NetworkBinder.this.mIsNetworkAvailable = false;
                        NetworkBinder.this.deactivateNetworkAdapter();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public NetworkBinder(long j) {
        this.mNativeNetworkBinderJni = j;
    }

    public static boolean bindSocket(String str, int i) {
        if (str != null && !str.isEmpty() && i != -1) {
            try {
                if (!checkSystemVersionValid()) {
                    return false;
                }
                Network findNetwork = findNetwork(str);
                if (findNetwork != null) {
                    findNetwork.bindSocket(ParcelFileDescriptor.fromFd(i).getFileDescriptor());
                    LiteavLog.i(TAG, "[BindSocket]:NetworkBinder bindSocket succ, name:" + str + " socket:" + i);
                    return true;
                }
                LiteavLog.e(TAG, "[BindSocket]:NetworkBinder bindSocket can not find network:".concat(str));
                return false;
            } catch (Exception unused) {
                LiteavLog.e(TAG, "[BindSocket]:bindSocket in java encountered an exception, name:" + str + " socket:" + i);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancleTimeoutRunnable() {
        if (this.mHandler != null) {
            Log.i(TAG, "[BindSocket]:remove cancel last request network runnable", new Object[0]);
            this.mHandler.removeCallbacks(this.mTimeoutRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNativeValid() {
        boolean z;
        synchronized (this.mLocker) {
            if (this.mNativeNetworkBinderJni != -1) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private static boolean checkSystemVersionValid() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 23) {
            if (isPrint) {
                LiteavLog.e(TAG, "[BindSocket]:The android version is too low and does not support network binding");
                isPrint = false;
            }
            return false;
        }
        return true;
    }

    private ConnectivityManager.NetworkCallback createNetworkCallback() {
        final ConnectivityManager connectivityManager;
        synchronized (this.mLocker) {
            try {
                ConnectivityManager.NetworkCallback networkCallback = this.mNetworkCallback;
                if (networkCallback != null) {
                    return networkCallback;
                }
                if (!checkSystemVersionValid() || (connectivityManager = getConnectivityManager()) == null) {
                    return null;
                }
                ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.tencent.liteav.base.networkbinder.NetworkBinder.2
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onAvailable(Network network) {
                        super.onAvailable(network);
                        if (network == null) {
                            Log.e(NetworkBinder.TAG, "[BindSocket]:onAvailable, network is null", new Object[0]);
                            return;
                        }
                        LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
                        synchronized (NetworkBinder.this.mLocker) {
                            try {
                                if (NetworkBinder.this.mIsActivatingNetwork) {
                                    NetworkBinder.this.mIsActivatingNetwork = false;
                                    NetworkBinder.this.mIsNetworkAvailable = true;
                                    if (linkProperties != null && NetworkBinder.this.checkNativeValid()) {
                                        String interfaceName = linkProperties.getInterfaceName();
                                        NetworkBinder.nativeOnNetworkAvailable(NetworkBinder.this.mNativeNetworkBinderJni, interfaceName, true);
                                        Log.i(NetworkBinder.TAG, "[BindSocket]:start network succ, network name=".concat(String.valueOf(interfaceName)), new Object[0]);
                                    }
                                    NetworkBinder.this.cancleTimeoutRunnable();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public final void onLost(Network network) {
                        super.onLost(network);
                        synchronized (NetworkBinder.this.mLocker) {
                            try {
                                if (NetworkBinder.this.mIsNetworkAvailable && !NetworkBinder.this.mIsActivatingNetwork) {
                                    NetworkBinder.this.mIsNetworkAvailable = false;
                                    if (NetworkBinder.this.checkNativeValid()) {
                                        NetworkBinder.nativeOnNetworkAvailable(NetworkBinder.this.mNativeNetworkBinderJni, "", false);
                                        Log.i(NetworkBinder.TAG, "[BindSocket]:network onLost", new Object[0]);
                                    }
                                    NetworkBinder.this.deactivateNetworkAdapter();
                                }
                            } finally {
                            }
                        }
                    }
                };
                synchronized (this.mLocker) {
                    this.mNetworkCallback = networkCallback2;
                }
                return networkCallback2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deactivateNetworkAdapter() {
        ConnectivityManager connectivityManager;
        try {
            if (!checkSystemVersionValid() || (connectivityManager = getConnectivityManager()) == null) {
                return;
            }
            synchronized (this.mLocker) {
                try {
                    if (this.mNetworkCallback != null) {
                        Log.i(TAG, "[BindSocket]:deactivat network adapter", new Object[0]);
                        connectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
                    }
                } finally {
                }
            }
        } catch (Exception unused) {
            LiteavLog.e(TAG, "[BindSocket]:deactivateNetworkAdapter in java encountered an exception");
        }
    }

    public static Network findNetwork(String str) {
        ConnectivityManager connectivityManager;
        if (!checkSystemVersionValid() || (connectivityManager = getConnectivityManager()) == null) {
            return null;
        }
        for (Network network : connectivityManager.getAllNetworks()) {
            LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
            if (linkProperties != null && linkProperties.getInterfaceName().equals(str)) {
                return network;
            }
        }
        return null;
    }

    private static ConnectivityManager getConnectivityManager() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return (ConnectivityManager) applicationContext.getSystemService("connectivity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnNetworkAvailable(long j, String str, boolean z);

    public boolean activateNetworkAdapter(int i) {
        if (i != 1 && i != 2) {
            return false;
        }
        try {
        } catch (Exception unused) {
            LiteavLog.e(TAG, "[BindSocket]:activateNetworkAdapter in java encountered an exception, networkType:".concat(String.valueOf(i)));
        }
        synchronized (this.mLocker) {
            try {
                if (this.mIsActivatingNetwork) {
                    LiteavLog.e(TAG, "[BindSocket]:mIsActivatingNetwork is true");
                    return false;
                }
                this.mIsActivatingNetwork = true;
                this.mIsNetworkAvailable = false;
                if (this.mNetworkType != i) {
                    deactivateNetworkAdapter();
                }
                this.mNetworkType = i;
                if (doActivateNetworkAdapter(i)) {
                    synchronized (this.mLocker) {
                        try {
                            Handler handler = this.mHandler;
                            if (handler != null) {
                                handler.postDelayed(this.mTimeoutRunnable, 2000L);
                            }
                        } finally {
                        }
                    }
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public void destroy() {
        synchronized (this.mLocker) {
            this.mIsActivatingNetwork = false;
            this.mIsNetworkAvailable = false;
            deactivateNetworkAdapter();
            cancleTimeoutRunnable();
            this.mNativeNetworkBinderJni = -1L;
        }
    }

    public boolean doActivateNetworkAdapter(int i) {
        int i2;
        ConnectivityManager connectivityManager;
        ConnectivityManager.NetworkCallback createNetworkCallback;
        if (i == 1) {
            i2 = 1;
        } else {
            if (i == 2) {
                i2 = 0;
            }
            return false;
        }
        try {
            if (!checkSystemVersionValid() || (connectivityManager = getConnectivityManager()) == null || (createNetworkCallback = createNetworkCallback()) == null) {
                return false;
            }
            connectivityManager.requestNetwork(new NetworkRequest.Builder().addCapability(12).addTransportType(i2).build(), createNetworkCallback);
            return true;
        } catch (Exception unused) {
            LiteavLog.e(TAG, "[BindSocket]:requestNetwork in java encountered an exception, networkType:".concat(String.valueOf(i)));
        }
    }

    public void resumeDefaultNetworkAdapter() {
        this.mNetworkType = 0;
        deactivateNetworkAdapter();
    }
}
