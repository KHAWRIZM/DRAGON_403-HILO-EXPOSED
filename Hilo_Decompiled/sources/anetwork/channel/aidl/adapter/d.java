package anetwork.channel.aidl.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import anet.channel.util.ALog;
import anetwork.channel.aidl.IRemoteNetworkGetter;
import anetwork.channel.aidl.NetworkService;
import anetwork.channel.config.NetworkConfigCenter;
import com.qiahao.base_common.network.BaseServer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    static volatile IRemoteNetworkGetter f٥١٢٤a;

    /* renamed from: b, reason: collision with root package name */
    static volatile boolean f٥١٢٥b;

    /* renamed from: c, reason: collision with root package name */
    static volatile boolean f٥١٢٦c;

    /* renamed from: d, reason: collision with root package name */
    static volatile CountDownLatch f٥١٢٧d;

    /* renamed from: e, reason: collision with root package name */
    static Handler f٥١٢٨e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    private static ServiceConnection f٥١٢٩f = new e();

    public static void a(Context context, boolean z10) {
        if (f٥١٢٤a == null && !f٥١٢٥b) {
            a(context);
            if (f٥١٢٥b || !z10) {
                return;
            }
            try {
                synchronized (d.class) {
                    try {
                        if (f٥١٢٤a != null) {
                            return;
                        }
                        if (f٥١٢٧d == null) {
                            f٥١٢٧d = new CountDownLatch(1);
                        }
                        ALog.i("anet.RemoteGetter", "[initRemoteGetterAndWait]begin to wait", null, new Object[0]);
                        if (f٥١٢٧d.await(NetworkConfigCenter.getServiceBindWaitTime(), TimeUnit.SECONDS)) {
                            ALog.i("anet.RemoteGetter", "mServiceBindLock count down to 0", null, new Object[0]);
                        } else {
                            ALog.i("anet.RemoteGetter", "mServiceBindLock wait timeout", null, new Object[0]);
                        }
                    } finally {
                    }
                }
            } catch (InterruptedException unused) {
                ALog.e("anet.RemoteGetter", "mServiceBindLock wait interrupt", null, new Object[0]);
            }
        }
    }

    public static IRemoteNetworkGetter a() {
        return f٥١٢٤a;
    }

    private static void a(Context context) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.RemoteGetter", "[asyncBindService] mContext:" + context + " bBindFailed:" + f٥١٢٥b + " bBinding:" + f٥١٢٦c, null, new Object[0]);
        }
        if (context == null || f٥١٢٥b || f٥١٢٦c) {
            return;
        }
        f٥١٢٦c = true;
        Intent intent = new Intent(context, (Class<?>) NetworkService.class);
        intent.setAction(IRemoteNetworkGetter.class.getName());
        intent.addCategory("android.intent.category.DEFAULT");
        f٥١٢٥b = !context.bindService(intent, f٥١٢٩f, 1);
        if (f٥١٢٥b) {
            f٥١٢٦c = false;
            ALog.e("anet.RemoteGetter", "[asyncBindService]ANet_Service start not success. ANet run with local mode!", null, new Object[0]);
        }
        f٥١٢٨e.postDelayed(new f(), BaseServer.TIMEOUT_DEBUG);
    }
}
