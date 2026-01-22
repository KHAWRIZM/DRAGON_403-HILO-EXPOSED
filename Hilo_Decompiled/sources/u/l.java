package u;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.ProxyInfo;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class l {
    public static int a(Application application) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager;
        ConnectivityManager connectivityManager2;
        NetworkInfo networkInfo2;
        NetworkInfo.State state;
        if (b.a(application) && (connectivityManager2 = (ConnectivityManager) application.getApplicationContext().getSystemService("connectivity")) != null && (networkInfo2 = connectivityManager2.getNetworkInfo(9)) != null && (state = networkInfo2.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return 1;
        }
        if (b.a(application) && (connectivityManager = (ConnectivityManager) application.getApplicationContext().getSystemService("connectivity")) != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isAvailable()) {
            if (networkInfo.getType() == 1) {
                return 100;
            }
            if (networkInfo.getType() != 0) {
                return 0;
            }
            switch (networkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return 3;
                case 13:
                case 18:
                    return 4;
                case 19:
                default:
                    String subtypeName = networkInfo.getSubtypeName();
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                        return 0;
                    }
                    return 3;
                case 20:
                    return 5;
            }
        }
        return 999;
    }

    public static boolean b(Application application) {
        ConnectivityManager connectivityManager;
        if (b.a(application) && (connectivityManager = (ConnectivityManager) application.getSystemService("connectivity")) != null) {
            for (Network network : connectivityManager.getAllNetworks()) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        r6 = r0.getDefaultProxy();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Application application) {
        int i10;
        Network activeNetwork;
        ProxyInfo defaultProxy;
        String str;
        ConnectivityManager connectivityManager = (ConnectivityManager) application.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && b.a(application)) {
            activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null && defaultProxy != null) {
                String host = defaultProxy.getHost();
                int port = defaultProxy.getPort();
                if (defaultProxy.getPacFileUrl() != null) {
                    str = defaultProxy.getPacFileUrl().toString();
                } else {
                    str = null;
                }
                if ((!TextUtils.isEmpty(host) && port != -1) || !TextUtils.isEmpty(str)) {
                    return true;
                }
            }
            return false;
        }
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        String str2 = "-1";
        if (property2 == null) {
            property2 = "-1";
        }
        try {
            i10 = Integer.parseInt(property2);
        } catch (NumberFormatException unused) {
            i10 = -1;
        }
        if (TextUtils.isEmpty(property)) {
            property = System.getProperty("https.proxyHost");
            String property3 = System.getProperty("https.proxyPort");
            if (property3 != null) {
                str2 = property3;
            }
            try {
                i10 = Integer.parseInt(str2);
            } catch (NumberFormatException unused2) {
                i10 = -1;
            }
        }
        if (TextUtils.isEmpty(property) || i10 == -1) {
            return false;
        }
        return true;
    }
}
