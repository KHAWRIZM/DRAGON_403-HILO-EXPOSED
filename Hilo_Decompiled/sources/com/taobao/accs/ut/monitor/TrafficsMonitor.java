package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class TrafficsMonitor {
    private Context d;
    private Map<String, List<a>> a = new HashMap();
    private Map<String, String> b = new HashMap<String, String>() { // from class: com.taobao.accs.ut.monitor.TrafficsMonitor.1
        {
            put("im", "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", "1000");
        }
    };
    private int c = 0;
    private String e = "";

    @Monitor(module = "NetworkSDK", monitorPoint = "TrafficStats")
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class StatTrafficMonitor extends BaseMonitor {

        @Dimension
        public String bizId;

        @Dimension
        public String date;

        @Dimension
        public String host;

        @Dimension
        public boolean isBackground;

        @Dimension
        public String serviceId;

        @Measure
        public long size;
    }

    public TrafficsMonitor(Context context) {
        this.d = context;
    }

    private void b() {
        String str;
        boolean z;
        synchronized (this.a) {
            try {
                String a2 = UtilityImpl.a(System.currentTimeMillis());
                if (!TextUtils.isEmpty(this.e) && !this.e.equals(a2)) {
                    str = this.e;
                    z = true;
                } else {
                    str = a2;
                    z = false;
                }
                Iterator<String> it = this.a.keySet().iterator();
                while (it.hasNext()) {
                    for (a aVar : this.a.get(it.next())) {
                        if (aVar != null) {
                            com.taobao.accs.a.a a3 = com.taobao.accs.a.a.a(this.d);
                            String str2 = aVar.e;
                            String str3 = aVar.c;
                            a3.a(str2, str3, this.b.get(str3), aVar.d, aVar.f, str);
                        }
                    }
                }
                ALog.Level level = ALog.Level.D;
                if (ALog.isPrintLog(level)) {
                    ALog.d("TrafficsMonitor", "savetoDay:" + str + " saveTraffics" + this.a.toString(), new Object[0]);
                }
                if (z) {
                    this.a.clear();
                    c();
                } else if (ALog.isPrintLog(level)) {
                    ALog.d("TrafficsMonitor", "no need commit lastsaveDay:" + this.e + " currday:" + a2, new Object[0]);
                }
                this.e = a2;
                this.c = 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void c() {
        List<a> a2 = com.taobao.accs.a.a.a(this.d).a(false);
        if (a2 == null) {
            return;
        }
        try {
            for (a aVar : a2) {
                if (aVar != null) {
                    StatTrafficMonitor statTrafficMonitor = new StatTrafficMonitor();
                    statTrafficMonitor.bizId = aVar.b;
                    statTrafficMonitor.date = aVar.a;
                    statTrafficMonitor.host = aVar.e;
                    statTrafficMonitor.isBackground = aVar.d;
                    statTrafficMonitor.size = aVar.f;
                    AppMonitor.getInstance().commitStat(statTrafficMonitor);
                }
            }
            com.taobao.accs.a.a.a(this.d).a();
        } catch (Throwable th) {
            ALog.e("", th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
        String str;
        if (aVar == null || aVar.e == null || aVar.f <= 0) {
            return;
        }
        aVar.c = TextUtils.isEmpty(aVar.c) ? "accsSelf" : aVar.c;
        synchronized (this.a) {
            try {
                String str2 = this.b.get(aVar.c);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                aVar.b = str2;
                ALog.isPrintLog(ALog.Level.D);
                List<a> list = this.a.get(str2);
                if (list != null) {
                    Iterator<a> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            a next = it.next();
                            if (next.d == aVar.d && (str = next.e) != null && str.equals(aVar.e)) {
                                next.f += aVar.f;
                                break;
                            }
                        } else {
                            list.add(aVar);
                            break;
                        }
                    }
                } else {
                    list = new ArrayList<>();
                    list.add(aVar);
                }
                this.a.put(str2, list);
                int i = this.c + 1;
                this.c = i;
                if (i >= 10) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class a {
        String a;
        String b;
        String c;
        boolean d;
        String e;
        long f;

        public a(String str, boolean z, String str2, long j) {
            this.c = str;
            this.d = z;
            this.e = str2;
            this.f = j;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("date:" + this.a);
            sb2.append(" ");
            sb2.append("bizId:" + this.b);
            sb2.append(" ");
            sb2.append("serviceId:" + this.c);
            sb2.append(" ");
            sb2.append("host:" + this.e);
            sb2.append(" ");
            sb2.append("isBackground:" + this.d);
            sb2.append(" ");
            sb2.append("size:" + this.f);
            return sb2.toString();
        }

        public a(String str, String str2, String str3, boolean z, String str4, long j) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = str4;
            this.f = j;
        }
    }

    public void a() {
        try {
            synchronized (this.a) {
                this.a.clear();
            }
            List<a> a2 = com.taobao.accs.a.a.a(this.d).a(true);
            if (a2 == null) {
                return;
            }
            Iterator<a> it = a2.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Exception e) {
            ALog.w("TrafficsMonitor", e.toString(), new Object[0]);
        }
    }
}
