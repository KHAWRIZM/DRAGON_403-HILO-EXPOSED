package anet.channel.status;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import anet.channel.util.g;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NetworkStatusHelper {
    private static final String TAG = "awcn.NetworkStatusHelper";
    static CopyOnWriteArraySet<INetworkStatusChangeListener> listeners = new CopyOnWriteArraySet<>();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface INetworkStatusChangeListener {
        void onNetworkStatusChanged(NetworkStatus networkStatus);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum NetworkStatus {
        NONE,
        NO,
        G2,
        G3,
        G4,
        WIFI,
        G5;

        public String getType() {
            if (this == G2) {
                return "2G";
            }
            if (this == G3) {
                return "3G";
            }
            if (this == G4) {
                return "4G";
            }
            if (this == G5) {
                return "5G";
            }
            return toString();
        }

        public boolean isMobile() {
            if (this != G2 && this != G3 && this != G4 && this != G5) {
                return false;
            }
            return true;
        }

        public boolean isWifi() {
            if (this == WIFI) {
                return true;
            }
            return false;
        }
    }

    public static void addStatusChangeListener(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        listeners.add(iNetworkStatusChangeListener);
    }

    public static String getApn() {
        return b.f٤٩٢٣e;
    }

    public static String getCarrier() {
        return b.f٤٩٢٦h;
    }

    public static String getDnsServerAddress() {
        if (!b.f٤٩٣٠l.isEmpty()) {
            return b.f٤٩٣٠l.get(0).getHostAddress();
        }
        return b.f();
    }

    public static String getNetworkSubType() {
        return b.f٤٩٢٢d;
    }

    public static String getProxyType() {
        NetworkStatus networkStatus = b.f٤٩٢١c;
        if (networkStatus == NetworkStatus.WIFI && getWifiProxy() != null) {
            return "proxy";
        }
        if (networkStatus.isMobile() && b.f٤٩٢٣e.contains("wap")) {
            return "wap";
        }
        if (networkStatus.isMobile() && g.a() != null) {
            return "auth";
        }
        return "";
    }

    public static int getRestrictBackgroundStatus() {
        return b.g();
    }

    public static String getSimOp() {
        return b.f٤٩٢٧i;
    }

    public static NetworkStatus getStatus() {
        return b.f٤٩٢١c;
    }

    public static String getUniqueId(NetworkStatus networkStatus) {
        String str = "";
        if (networkStatus.isWifi()) {
            String md5ToHex = StringUtils.md5ToHex(getWifiBSSID());
            if (!TextUtils.isEmpty(md5ToHex)) {
                str = md5ToHex;
            }
            return "WIFI$" + str;
        }
        if (!networkStatus.isMobile()) {
            return "";
        }
        return networkStatus.getType() + "$" + getApn();
    }

    public static String getWifiBSSID() {
        return b.f٤٩٢٥g;
    }

    public static Pair<String, Integer> getWifiProxy() {
        if (b.f٤٩٢١c != NetworkStatus.WIFI) {
            return null;
        }
        return b.f٤٩٢٨j;
    }

    public static String getWifiSSID() {
        return b.f٤٩٢٤f;
    }

    public static boolean isConnected() {
        if (Build.VERSION.SDK_INT >= 24) {
            if (b.f٤٩٢٠b) {
                return true;
            }
        } else if (b.f٤٩٢١c != NetworkStatus.NO) {
            return true;
        }
        try {
            NetworkInfo e10 = b.e();
            if (e10 != null) {
                if (e10.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isProxy() {
        NetworkStatus networkStatus = b.f٤٩٢١c;
        String str = b.f٤٩٢٣e;
        if (networkStatus != NetworkStatus.WIFI || getWifiProxy() == null) {
            if (networkStatus.isMobile()) {
                if (str.contains("wap") || g.a() != null) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean isRoaming() {
        return b.f٤٩٢٩k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void notifyStatusChanged(NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.submitScheduledTask(new a(networkStatus));
    }

    public static void printNetworkDetail() {
        try {
            NetworkStatus status = getStatus();
            StringBuilder sb = new StringBuilder(128);
            sb.append("\nNetwork detail*******************************\n");
            sb.append("Status: ");
            sb.append(status.getType());
            sb.append('\n');
            sb.append("Subtype: ");
            sb.append(getNetworkSubType());
            sb.append('\n');
            if (status != NetworkStatus.NO) {
                if (status.isMobile()) {
                    sb.append("Apn: ");
                    sb.append(getApn());
                    sb.append('\n');
                    sb.append("Carrier: ");
                    sb.append(getCarrier());
                    sb.append('\n');
                } else {
                    sb.append("BSSID: ");
                    sb.append(getWifiBSSID());
                    sb.append('\n');
                    sb.append("SSID: ");
                    sb.append(getWifiSSID());
                    sb.append('\n');
                }
            }
            if (isProxy()) {
                sb.append("Proxy: ");
                sb.append(getProxyType());
                sb.append('\n');
                Pair<String, Integer> wifiProxy = getWifiProxy();
                if (wifiProxy != null) {
                    sb.append("ProxyHost: ");
                    sb.append((String) wifiProxy.first);
                    sb.append('\n');
                    sb.append("ProxyPort: ");
                    sb.append(wifiProxy.second);
                    sb.append('\n');
                }
            }
            sb.append("*********************************************");
            ALog.i(TAG, sb.toString(), null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void removeStatusChangeListener(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        listeners.remove(iNetworkStatusChangeListener);
    }

    public static synchronized void startListener(Context context) {
        synchronized (NetworkStatusHelper.class) {
            if (context != null) {
                b.f٤٩١٩a = context;
                b.a();
                b.c();
            } else {
                throw new NullPointerException("context is null");
            }
        }
    }

    public void stopListener(Context context) {
        b.b();
    }
}
