package qf;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Dns;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class z implements Dns {
    public final String a;

    public z() {
        this.a = "Ipv4PreferredDns";
    }

    @Override // okhttp3.Dns
    public final List lookup(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        InetAddress[] allByName = InetAddress.getAllByName(str);
        if (allByName != null) {
            for (int i = 0; i < allByName.length; i++) {
                InetAddress inetAddress = allByName[i];
                if (i == 0) {
                    LogUtils.file(this.a, "okhttp dns 原本应该连的地址:" + inetAddress.toString());
                }
                if (inetAddress instanceof Inet4Address) {
                    arrayList2.add(inetAddress);
                } else {
                    arrayList3.add(inetAddress);
                }
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        if (!arrayList.isEmpty()) {
            LogUtils.file(this.a, "okhttp dns 调整后要连接的地址:" + ((InetAddress) arrayList.get(0)).toString());
            return arrayList;
        }
        throw new UnknownHostException("No IP addresses found for " + str);
    }

    public z(String str) {
        this.a = str;
    }
}
