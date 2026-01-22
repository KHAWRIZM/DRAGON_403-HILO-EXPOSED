package org.android.netutil;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class UdpConnectType {
    public static boolean a() {
        if (nativeTestUdpConnectIpv4() != 0) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        if (nativeTestUdpConnectIpv6() != 0) {
            return true;
        }
        return false;
    }

    private static native int nativeTestUdpConnectIpv4();

    private static native int nativeTestUdpConnectIpv6();
}
