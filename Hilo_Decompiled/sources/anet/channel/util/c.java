package anet.channel.util;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.NetTypeStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.android.netutil.UdpConnectType;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {
    public static final int IPV4_ONLY = 1;
    public static final int IPV6_ONLY = 2;
    public static final int IP_DUAL_STACK = 3;
    public static final int IP_STACK_UNKNOWN = 0;

    /* renamed from: b, reason: collision with root package name */
    static volatile String f٥٠٧٥b;

    /* renamed from: c, reason: collision with root package name */
    static f f٥٠٧٦c;

    /* renamed from: a, reason: collision with root package name */
    static final byte[][] f٥٠٧٤a = {new byte[]{-64, 0, 0, -86}, new byte[]{-64, 0, 0, -85}};

    /* renamed from: d, reason: collision with root package name */
    static ConcurrentHashMap<String, f> f٥٠٧٧d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    static ConcurrentHashMap<String, Integer> f٥٠٧٨e = new ConcurrentHashMap<>();

    static {
        f٥٠٧٥b = null;
        f٥٠٧٦c = null;
        try {
            f٥٠٧٦c = new f((Inet6Address) InetAddress.getAllByName("64:ff9b::")[0], 96);
            f٥٠٧٥b = b(NetworkStatusHelper.getStatus());
        } catch (Exception unused) {
        }
    }

    public static boolean a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String wifiBSSID = NetworkStatusHelper.getWifiBSSID();
            if (TextUtils.isEmpty(wifiBSSID)) {
                wifiBSSID = "";
            }
            return "WIFI$" + wifiBSSID;
        }
        if (networkStatus.isMobile()) {
            return networkStatus.getType() + "$" + NetworkStatusHelper.getApn();
        }
        return "UnknownNetwork";
    }

    public static int c() {
        Integer num = f٥٠٧٨e.get(f٥٠٧٥b);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static f d() {
        f fVar = f٥٠٧٧d.get(f٥٠٧٥b);
        if (fVar == null) {
            return f٥٠٧٦c;
        }
        return fVar;
    }

    public static void e() {
        if (!AwcnConfig.isIpv6Enable()) {
            ALog.e("awcn.Inet64Util", "[startIpStackDetect]ipv6Enable=false", null, new Object[0]);
            return;
        }
        f٥٠٧٥b = b(NetworkStatusHelper.getStatus());
        if (f٥٠٧٨e.putIfAbsent(f٥٠٧٥b, 0) != null) {
            return;
        }
        int j10 = j();
        f٥٠٧٨e.put(f٥٠٧٥b, Integer.valueOf(j10));
        NetTypeStat netTypeStat = new NetTypeStat();
        netTypeStat.ipStackType = j10;
        String str = f٥٠٧٥b;
        if (j10 != 2 && j10 != 3) {
            if (GlobalAppRuntimeInfo.isTargetProcess()) {
                AppMonitor.getInstance().commitStat(netTypeStat);
                return;
            }
            return;
        }
        ThreadPoolExecutorFactory.submitScheduledTask(new d(str, netTypeStat), 1500L, TimeUnit.MILLISECONDS);
    }

    private static int h() throws SocketException {
        String str;
        int i10;
        TreeMap treeMap = new TreeMap();
        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (true) {
            str = null;
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            NetworkInterface networkInterface = (NetworkInterface) it.next();
            if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                String displayName = networkInterface.getDisplayName();
                ALog.i("awcn.Inet64Util", "find NetworkInterface:" + displayName, null, new Object[0]);
                Iterator<InterfaceAddress> it2 = networkInterface.getInterfaceAddresses().iterator();
                int i11 = 0;
                while (it2.hasNext()) {
                    InetAddress address = it2.next().getAddress();
                    if (address instanceof Inet6Address) {
                        Inet6Address inet6Address = (Inet6Address) address;
                        if (!a(inet6Address)) {
                            ALog.e("awcn.Inet64Util", "Found IPv6 address:" + inet6Address.toString(), null, new Object[0]);
                            i11 |= 2;
                        }
                    } else if (address instanceof Inet4Address) {
                        Inet4Address inet4Address = (Inet4Address) address;
                        if (!a((InetAddress) inet4Address) && !inet4Address.getHostAddress().startsWith("192.168.43.")) {
                            ALog.e("awcn.Inet64Util", "Found IPv4 address:" + inet4Address.toString(), null, new Object[0]);
                            i11 |= 1;
                        }
                    }
                }
                if (i11 != 0) {
                    treeMap.put(displayName.toLowerCase(), Integer.valueOf(i11));
                }
            }
        }
        if (treeMap.isEmpty()) {
            return 0;
        }
        if (treeMap.size() == 1) {
            return ((Integer) treeMap.firstEntry().getValue()).intValue();
        }
        if (NetworkStatusHelper.getStatus().isWifi()) {
            str = "wlan";
        } else if (NetworkStatusHelper.getStatus().isMobile()) {
            str = "rmnet";
        }
        if (str != null) {
            Iterator it3 = treeMap.entrySet().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it3.next();
                if (((String) entry.getKey()).startsWith(str)) {
                    i10 = ((Integer) entry.getValue()).intValue();
                    break;
                }
            }
        }
        if (i10 == 2 && treeMap.containsKey("v4-wlan0")) {
            return i10 | ((Integer) treeMap.remove("v4-wlan0")).intValue();
        }
        return i10;
    }

    private static int i() {
        SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        boolean a10 = UdpConnectType.a();
        if (UdpConnectType.b()) {
            return (a10 ? 1 : 0) | 2;
        }
        return a10 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object[]] */
    public static int j() {
        ?? r32;
        int i10;
        try {
            r32 = AwcnConfig.isIpStackDetectByUdpConnect();
            try {
                if (r32 != 0) {
                    String str = "udp_connect";
                    i10 = i();
                    r32 = str;
                } else {
                    String str2 = "interfaces";
                    i10 = h();
                    r32 = str2;
                }
            } catch (Throwable th) {
                th = th;
                ALog.e("awcn.Inet64Util", "[detectIpStack]error.", null, th, new Object[0]);
                i10 = 0;
                ALog.e("awcn.Inet64Util", "startIpStackDetect", null, new Object[]{"ip stack", Integer.valueOf(i10), "detectType", r32});
                return i10;
            }
        } catch (Throwable th2) {
            th = th2;
            r32 = 0;
        }
        ALog.e("awcn.Inet64Util", "startIpStackDetect", null, new Object[]{"ip stack", Integer.valueOf(i10), "detectType", r32});
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static f k() throws UnknownHostException {
        InetAddress inetAddress;
        byte b10;
        try {
            inetAddress = InetAddress.getByName("ipv4only.arpa");
        } catch (Exception unused) {
            inetAddress = null;
        }
        if (inetAddress instanceof Inet6Address) {
            ALog.i("awcn.Inet64Util", "Resolved AAAA: " + inetAddress.toString(), null, new Object[0]);
            byte[] address = inetAddress.getAddress();
            if (address.length != 16) {
                return null;
            }
            for (int i10 = 12; i10 >= 0; i10--) {
                byte b11 = address[i10];
                byte[][] bArr = f٥٠٧٤a;
                byte[] bArr2 = bArr[0];
                if ((b11 & bArr2[0]) != 0 && address[i10 + 1] == 0 && address[i10 + 2] == 0 && ((b10 = address[i10 + 3]) == bArr2[3] || b10 == bArr[1][3])) {
                    address[i10 + 3] = 0;
                    address[i10 + 2] = 0;
                    address[i10 + 1] = 0;
                    address[i10] = 0;
                    return new f(Inet6Address.getByAddress("ipv4only.arpa", address, 0), i10 * 8);
                }
            }
        } else if (inetAddress instanceof Inet4Address) {
            ALog.i("awcn.Inet64Util", "Resolved A: " + inetAddress.toString(), null, new Object[0]);
        }
        return null;
    }

    public static String a(Inet4Address inet4Address) throws Exception {
        if (inet4Address != null) {
            f d10 = d();
            if (d10 != null) {
                byte[] address = inet4Address.getAddress();
                byte[] address2 = d10.f٥٠٨٣b.getAddress();
                int i10 = d10.f٥٠٨٢a / 8;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    int i13 = i11 + i10;
                    if (i13 > 15 || i12 >= 4) {
                        break;
                    }
                    if (i13 != 8) {
                        address2[i13] = (byte) (address[i12] | address2[i13]);
                        i12++;
                    }
                    i11++;
                }
                return InetAddress.getByAddress(address2).getHostAddress();
            }
            throw new Exception("cannot get nat64 prefix");
        }
        throw new InvalidParameterException("address in null");
    }

    public static boolean b() {
        Integer num = f٥٠٧٨e.get(f٥٠٧٥b);
        return num != null && num.intValue() == 1;
    }

    public static String a(String str) throws Exception {
        return a((Inet4Address) InetAddress.getByName(str));
    }

    private static boolean a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }
}
