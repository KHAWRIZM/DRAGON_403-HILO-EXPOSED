package tech.sud.runtime.component.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.taobao.accs.utl.UtilityImpl;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class f {
    private static final String[] a = {"none", UtilityImpl.NET_TYPE_WIFI, UtilityImpl.NET_TYPE_MOBILE, "ethernet", UtilityImpl.NET_TYPE_UNKNOWN};
    private a b;
    private b c = null;
    private final tech.sud.runtime.core.g d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public static class a extends BroadcastReceiver {
        public WeakReference<b> a;

        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int b = f.b(context);
            tech.sud.runtime.component.h.f.c("SudNative", "J: Network state changed to " + f.b(b));
            WeakReference<b> weakReference = this.a;
            if (weakReference != null && weakReference.get() != null) {
                this.a.get().a(b);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    public class b {
        public b() {
        }

        public void a(int i) {
            f.this.d.b(2, i);
        }
    }

    public f(tech.sud.runtime.core.g gVar, Context context) {
        this.d = gVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        a aVar = new a();
        this.b = aVar;
        context.registerReceiver(aVar, intentFilter);
    }

    public static int b(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (SecurityException e) {
            tech.sud.runtime.component.h.f.e("SudNative", "J: NetworkState: " + e.toString());
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return 0;
        }
        int type = networkInfo.getType();
        if (type != 0) {
            if (type != 1) {
                return type != 9 ? 4 : 3;
            }
            return 1;
        }
        switch (a((TelephonyManager) context.getApplicationContext().getSystemService("phone"), connectivityManager)) {
            case 0:
                return 2;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 514;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 770;
            case 13:
            case 18:
            case 19:
                return 1026;
            case 16:
            case 17:
            default:
                return 1538;
            case 20:
                return 1282;
        }
    }

    public void a(Context context) {
        this.c = null;
        a aVar = this.b;
        if (aVar != null) {
            aVar.a = null;
            try {
                context.unregisterReceiver(aVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i) {
        int i2;
        int i3 = i & 255;
        if (i3 > 4) {
            i3 = 4;
        }
        String str = a[i3];
        if (i3 != 2 || (i2 = (i >> 8) & 255) == 0) {
            return str;
        }
        return str + "_" + i2 + "g";
    }

    private static int a(TelephonyManager telephonyManager, ConnectivityManager connectivityManager) {
        if (telephonyManager != null) {
            try {
                return telephonyManager.getNetworkType();
            } catch (Exception unused) {
            }
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo == null) {
                return 0;
            }
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
                return networkInfo.getSubtype();
            }
            return 0;
        } catch (Exception unused2) {
            return 0;
        }
    }

    public void a() {
        this.c = new b();
        this.b.a = new WeakReference<>(this.c);
    }
}
