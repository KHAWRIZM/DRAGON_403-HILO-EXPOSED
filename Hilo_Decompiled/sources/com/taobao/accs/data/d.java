package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsState;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class d {
    public int b;
    protected TrafficsMonitor c;
    public FlowControl d;
    private Context h;
    private com.taobao.accs.ut.a.d i;
    private Message j;
    private com.taobao.accs.net.b k;
    private String l;
    private ConcurrentMap<Message.a, Message> f = new ConcurrentHashMap();
    public ConcurrentMap<String, ScheduledFuture<?>> a = new ConcurrentHashMap();
    private boolean g = false;
    public String e = "";
    private LinkedHashMap<String, String> m = new LinkedHashMap<String, String>() { // from class: com.taobao.accs.data.MessageHandler$1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, String> entry) {
            if (size() > 50) {
                return true;
            }
            return false;
        }
    };
    private Map<String, a> n = new HashMap();
    private Runnable o = new f(this);

    public d(Context context, com.taobao.accs.net.b bVar) {
        String str;
        this.l = "MsgRecv_";
        this.h = context;
        this.k = bVar;
        this.c = new TrafficsMonitor(context);
        this.d = new FlowControl(this.h);
        if (bVar == null) {
            str = this.l;
        } else {
            str = this.l + bVar.m;
        }
        this.l = str;
        i();
        h();
    }

    private boolean b(ErrorCode errorCode) {
        return errorCode.getCodeInt() == AccsErrorCode.SPDY_CONNECTION_DISCONNECTED_WHEN_SEND_DATA.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.REQ_TIME_OUT.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.SPDY_CON_DISCONNECTED.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.INAPP_CON_DISCONNECTED.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.SPDY_PING_TIME_OUT.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NO_NETWORK.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORKSDK_SPDY_CLOSE_ERROR.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORK_INAPP_TIMEOUT.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORK_INAPP_CONNECT_FAIL.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORK_INAPP_NO_STRATEGY.getCodeInt() || errorCode.getCodeInt() == AccsErrorCode.NETWORK_INAPP_EXCEPTION.getCodeInt();
    }

    private void i() {
        try {
            File file = new File(this.h.getDir(Constants.SHARED_FOLDER, 0), Constants.SHARED_MESSAGE_ID_FILE + this.k.i());
            if (!file.exists()) {
                ALog.d(this.l, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    this.m.put(readLine, readLine);
                } else {
                    bufferedReader.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void j() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.h.getDir(Constants.SHARED_FOLDER, 0), Constants.SHARED_MESSAGE_ID_FILE + this.k.i()));
            fileWriter.write("");
            Iterator<String> it = this.m.keySet().iterator();
            while (it.hasNext()) {
                fileWriter.append((CharSequence) it.next()).append((CharSequence) "\r\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, (String) null);
    }

    public boolean c() {
        return this.g;
    }

    public int d() {
        return this.f.size();
    }

    public Collection<Message> e() {
        return this.f.values();
    }

    public Set<Message.a> f() {
        return this.f.keySet();
    }

    public com.taobao.accs.ut.a.d g() {
        return this.i;
    }

    public void h() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.o);
        } catch (Throwable th) {
            ALog.e(this.l, "restoreTraffics", th, new Object[0]);
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.m.containsKey(str);
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str) || this.m.containsKey(str)) {
            return;
        }
        this.m.put(str, str);
        j();
    }

    public void a(byte[] bArr, String str) throws IOException {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(this.l, "onMessage", Constants.KEY_HOST, str);
        }
        com.taobao.accs.utl.h hVar = new com.taobao.accs.utl.h(bArr);
        try {
            int a = hVar.a();
            int i = (a & 240) >> 4;
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                ALog.d(this.l, "version:" + i, new Object[0]);
            }
            int i2 = a & 15;
            if (ALog.isPrintLog(level)) {
                ALog.d(this.l, "compress:" + i2, new Object[0]);
            }
            hVar.a();
            int b = hVar.b();
            if (ALog.isPrintLog(level)) {
                ALog.d(this.l, "totalLen:" + b, new Object[0]);
            }
            int i3 = 0;
            while (i3 < b) {
                int b2 = hVar.b();
                int i4 = i3 + 2;
                if (b2 > 0) {
                    byte[] bArr2 = new byte[b2];
                    hVar.read(bArr2);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        ALog.d(this.l, "buf len:" + b2, new Object[0]);
                    }
                    i3 = i4 + b2;
                    a(i2, bArr2, str, i);
                } else {
                    throw new IOException("data format error");
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private Intent c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.s);
        intent.putExtra("command", message.t);
        intent.putExtra(Constants.KEY_SERVICE_ID, message.H);
        intent.putExtra(Constants.KEY_USER_ID, message.G);
        Integer num = message.t;
        if (num != null && num.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.O);
        }
        return intent;
    }

    public void b() {
        ALog.d(this.l, "onRcvPing", new Object[0]);
        synchronized (d.class) {
            this.g = false;
        }
    }

    public void b(Message message) {
        if (this.f.keySet().size() > 0) {
            Iterator<Message.a> it = this.f.keySet().iterator();
            while (it.hasNext()) {
                Message message2 = this.f.get(it.next());
                if (message2 != null && message2.t != null && message2.f().equals(message.f())) {
                    switch (message.t.intValue()) {
                        case 1:
                        case 2:
                            if (message2.t.intValue() == 1 || message2.t.intValue() == 2) {
                                message2.e = true;
                                break;
                            }
                            break;
                        case 3:
                        case 4:
                            if (message2.t.intValue() == 3 || message2.t.intValue() == 4) {
                                message2.e = true;
                                break;
                            }
                            break;
                        case 5:
                        case 6:
                            if (message2.t.intValue() == 5 || message2.t.intValue() == 6) {
                                message2.e = true;
                                break;
                            }
                            break;
                    }
                }
                if (message2 != null && message2.e) {
                    ALog.e(this.l, "cancelControlMessage", "command", message2.t);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(3:(1:115)(2:152|(25:154|155|156|157|158|159|160|117|118|119|120|(1:122)(1:148)|123|(1:125)(1:147)|126|(2:128|129)(1:145)|130|(1:132)(1:144)|133|134|135|136|137|138|139))|138|139)|119|120|(0)(0)|123|(0)(0)|126|(0)(0)|130|(0)(0)|133|134|135|136|137) */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x07da, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x07db, code lost:
    
        r3 = r49;
        r6 = r4;
        r2 = r10;
        r1 = r15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0644 A[Catch: Exception -> 0x064d, TryCatch #18 {Exception -> 0x064d, blocks: (B:120:0x0634, B:122:0x0644, B:123:0x0655, B:125:0x0659, B:126:0x0664), top: B:119:0x0634 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0659 A[Catch: Exception -> 0x064d, TryCatch #18 {Exception -> 0x064d, blocks: (B:120:0x0634, B:122:0x0644, B:123:0x0655, B:125:0x0659, B:126:0x0664), top: B:119:0x0634 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x072a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x072c A[Catch: Exception -> 0x05f4, TryCatch #5 {Exception -> 0x05f4, blocks: (B:112:0x05ca, B:115:0x05d2, B:117:0x062c, B:129:0x06bd, B:130:0x06c8, B:133:0x072d, B:144:0x072c, B:152:0x05fb, B:160:0x061c), top: B:111:0x05ca }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:212:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:277:0x02ec A[Catch: Exception -> 0x0144, TRY_ENTER, TRY_LEAVE, TryCatch #28 {Exception -> 0x0144, blocks: (B:36:0x0135, B:37:0x018f, B:40:0x01c9, B:42:0x01d1, B:237:0x0222, B:269:0x0259, B:315:0x02ce, B:277:0x02ec, B:337:0x0154, B:341:0x0176, B:343:0x0164, B:340:0x015e), top: B:34:0x0133, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x048d A[Catch: Exception -> 0x0410, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x0410, blocks: (B:219:0x040c, B:52:0x048d, B:69:0x050f), top: B:47:0x03f1 }] */
    /* JADX WARN: Type inference failed for: r0v91, types: [com.taobao.accs.net.b] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r1v40, types: [com.taobao.accs.utl.ALog$Level] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v49, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r1v95 */
    /* JADX WARN: Type inference failed for: r1v96 */
    /* JADX WARN: Type inference failed for: r2v37, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r45v0, types: [com.taobao.accs.data.d] */
    /* JADX WARN: Type inference failed for: r4v30, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v47, types: [com.taobao.accs.ut.monitor.NetPerformanceMonitor, java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v69 */
    /* JADX WARN: Type inference failed for: r4v71 */
    /* JADX WARN: Type inference failed for: r4v76 */
    /* JADX WARN: Type inference failed for: r4v77 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v24, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v57 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, byte[] bArr, String str, int i2) throws IOException {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Map<Integer, String> map;
        byte[] bArr2;
        boolean z;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        boolean z2;
        int i3;
        String str13;
        String str14;
        String str15;
        Map<Integer, String> map2;
        String str16;
        String str17;
        int i4;
        String str18;
        String str19;
        int i5;
        boolean z3;
        String str20;
        String str21;
        String str22;
        ErrorCode errorCode;
        Object[] objArr;
        Message.ReqType reqType;
        int i6;
        String str23;
        String str24;
        String str25;
        Map<Integer, String> map3;
        byte[] bArr3;
        byte[] bArr4;
        Map<Integer, String> map4;
        String str26;
        int i7;
        int i8;
        boolean z4;
        int i9;
        com.taobao.accs.net.b bVar;
        String str27;
        String str28;
        String str29;
        String str30;
        boolean z5;
        Message.ReqType reqType2;
        boolean z6;
        long j;
        String str31;
        ?? r5;
        String str32;
        ?? r4;
        byte[] bArr5;
        String str33;
        String str34;
        String str35;
        Object[] objArr2;
        String str36;
        boolean z7;
        Object obj;
        String str37;
        long j2;
        String str38;
        Map<Integer, String> map5;
        String str39;
        int i10;
        int i11;
        byte[] bArr6;
        boolean z8;
        Map<Integer, String> map6;
        boolean z9;
        com.taobao.accs.utl.h hVar = new com.taobao.accs.utl.h(bArr);
        long b = hVar.b();
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            String str40 = this.l;
            StringBuilder sb2 = new StringBuilder();
            str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
            sb2.append("flag:");
            sb2.append(Integer.toHexString((int) b));
            String sb3 = sb2.toString();
            str3 = MessageService.MSG_DB_NOTIFY_REACHED;
            ALog.d(str40, sb3, new Object[0]);
        } else {
            str2 = BaseMonitor.ALARM_POINT_REQ_ERROR;
            str3 = MessageService.MSG_DB_NOTIFY_REACHED;
        }
        String a = hVar.a(hVar.a());
        if (ALog.isPrintLog(level)) {
            str4 = "";
            ALog.d(this.l, "target:" + a, new Object[0]);
        } else {
            str4 = "";
        }
        String a2 = hVar.a(hVar.a());
        if (!ALog.isPrintLog(level)) {
            str5 = Constants.KEY_SERVICE_ID;
        } else {
            str5 = Constants.KEY_SERVICE_ID;
            ALog.d(this.l, "source:" + a2, new Object[0]);
        }
        try {
            String a3 = hVar.a(hVar.a());
            if (ALog.isPrintLog(level)) {
                str6 = "accs";
                ALog.d(this.l, "dataId:" + a3, new Object[0]);
            } else {
                str6 = "accs";
            }
            String str41 = a2 + a3;
            if (hVar.available() > 0) {
                if (i2 == 2) {
                    map6 = a(hVar);
                    if (map6 != null && map6.containsKey(16) && map6.containsKey(17)) {
                        z9 = true;
                        if (i != 0 || z9) {
                            bArr2 = hVar.c();
                        } else if (i == 1) {
                            bArr2 = a(hVar);
                        } else {
                            z = z9;
                            bArr2 = null;
                            map = map6;
                        }
                        z = z9;
                        map = map6;
                    }
                } else {
                    map6 = null;
                }
                z9 = false;
                if (i != 0) {
                }
                bArr2 = hVar.c();
                z = z9;
                map = map6;
            } else {
                map = null;
                bArr2 = null;
                z = false;
            }
            hVar.close();
            try {
                if (bArr2 == null) {
                    map2 = map;
                    str16 = a2;
                    ALog.d(this.l, "oriData is null", new Object[0]);
                } else {
                    map2 = map;
                    str16 = a2;
                    if (ALog.isPrintLog(level)) {
                        try {
                            str17 = new String(bArr2);
                        } catch (Exception unused) {
                            str17 = "binary " + bArr2.length;
                        }
                        ALog.d(this.l, "oriData:" + str17, new Object[0]);
                    }
                }
                int a4 = Message.c.a((int) ((b >> 15) & 1));
                Message.ReqType valueOf = Message.ReqType.valueOf((int) ((b >> 13) & 3));
                int i12 = (int) ((b >> 12) & 1);
                int a5 = Message.b.a((int) ((b >> 11) & 1));
                ?? r14 = ((int) ((b >> 6) & 1)) == 1 ? 1 : 0;
                if (ALog.isPrintLog(ALog.Level.I)) {
                    i4 = a5;
                    ALog.i(this.l, "handleMessage", Constants.KEY_DATA_ID, a3, "type", Message.c.b(a4), "reqType", valueOf.name(), "resType", Message.b.b(a5), Constants.KEY_TARGET, a);
                } else {
                    i4 = a5;
                }
                try {
                    if (a4 != 1) {
                        bArr4 = bArr;
                        map4 = map2;
                        reqType = valueOf;
                        str26 = a;
                        str7 = "handleMessage";
                        i9 = a4;
                        str18 = str2;
                        str10 = str3;
                        str19 = str4;
                        str24 = str16;
                        i8 = 0;
                        z8 = true;
                        bArr3 = bArr2;
                    } else {
                        try {
                            if (valueOf != Message.ReqType.ACK && valueOf != Message.ReqType.RES) {
                                bArr4 = bArr;
                                map4 = map2;
                                reqType = valueOf;
                                str26 = a;
                                str7 = "handleMessage";
                                i7 = a4;
                                str18 = str2;
                                str10 = str3;
                                str19 = str4;
                                str24 = str16;
                                i8 = 0;
                                z4 = true;
                                bArr3 = bArr2;
                            } else {
                                Message remove = this.f.remove(new Message.a(0, a3));
                                if (remove == null) {
                                    bArr4 = bArr;
                                    map4 = map2;
                                    reqType = valueOf;
                                    str7 = "handleMessage";
                                    i9 = a4;
                                    str18 = str2;
                                    str10 = str3;
                                    str19 = str4;
                                    str24 = str16;
                                    bArr3 = bArr2;
                                    try {
                                        bVar = this.k;
                                        a3 = a3;
                                        str26 = a;
                                    } catch (Exception e) {
                                        e = e;
                                        a3 = a3;
                                    }
                                    try {
                                        z3 = true;
                                        z8 = true;
                                        z3 = true;
                                        try {
                                            bVar.b(Message.a(a3, str26, bVar.b((String) null), 5), true);
                                            String str42 = this.l;
                                            Object[] objArr3 = new Object[2];
                                            i5 = 0;
                                            i8 = 0;
                                            try {
                                                objArr3[0] = Constants.KEY_DATA_ID;
                                                objArr3[1] = a3;
                                                ALog.e(str42, "handleMessage data ack/res reqMessage is null", objArr3);
                                            } catch (Exception e2) {
                                                e = e2;
                                                str9 = str18;
                                                str13 = a3;
                                                str14 = str6;
                                                str11 = str19;
                                                i3 = i5;
                                                z2 = z3;
                                                ALog.e(this.l, str7, e, new Object[i3]);
                                                com.taobao.accs.net.b bVar2 = this.k;
                                                bVar2.b(Message.a(str13, str11, bVar2.b((String) null), 5), z2);
                                                AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            i5 = 0;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        i5 = 0;
                                        z3 = true;
                                        str9 = str18;
                                        str13 = a3;
                                        str14 = str6;
                                        str11 = str19;
                                        i3 = i5;
                                        z2 = z3;
                                        ALog.e(this.l, str7, e, new Object[i3]);
                                        com.taobao.accs.net.b bVar22 = this.k;
                                        bVar22.b(Message.a(str13, str11, bVar22.b((String) null), 5), z2);
                                        AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                    }
                                } else {
                                    try {
                                        if (ALog.isPrintLog(ALog.Level.D)) {
                                            str22 = a;
                                            ALog.d(this.l, "handleMessage reqMessage not null", new Object[0]);
                                        } else {
                                            str22 = a;
                                        }
                                        errorCode = AccsErrorCode.SUCCESS;
                                        try {
                                        } catch (Exception e5) {
                                            e = e5;
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        str7 = "handleMessage";
                                        str20 = a3;
                                        str18 = str2;
                                        str10 = str3;
                                        str19 = str4;
                                    }
                                    try {
                                        if (i12 == 1) {
                                            try {
                                                errorCode = AccsErrorCode.parseHttpCode(new JSONObject(new String(bArr2)).getInt(Constants.KEY_HTTP_CODE));
                                            } catch (Throwable th) {
                                                errorCode = AccsErrorCode.RESPONSE_PARSE_ERROR.copy().detail("data:" + new String(bArr2) + ", tr:" + th.getMessage()).build();
                                            }
                                            if (errorCode.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
                                                String str43 = this.l;
                                                try {
                                                    objArr = new Object[2];
                                                } catch (Exception e7) {
                                                    e = e7;
                                                }
                                                try {
                                                    objArr[0] = Integer.valueOf(i12);
                                                    objArr[1] = errorCode;
                                                    ALog.e(str43, "handleMessage", objArr);
                                                    if (remove.e() != null) {
                                                        remove.e().onRecAck();
                                                    }
                                                    if (valueOf != Message.ReqType.RES) {
                                                        str23 = str2;
                                                        reqType = valueOf;
                                                        bArr3 = bArr2;
                                                        str10 = str3;
                                                        str25 = str22;
                                                        str7 = "handleMessage";
                                                        i6 = a4;
                                                        str19 = str4;
                                                        str24 = str16;
                                                        try {
                                                            a(remove, errorCode, reqType, bArr3, map2);
                                                            map3 = map2;
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                            str21 = a3;
                                                            str9 = str23;
                                                            str27 = str6;
                                                            str28 = str21;
                                                            str11 = str19;
                                                            str12 = str27;
                                                            str15 = str28;
                                                            i3 = 0;
                                                            z2 = true;
                                                            str14 = str12;
                                                            str13 = str15;
                                                            ALog.e(this.l, str7, e, new Object[i3]);
                                                            com.taobao.accs.net.b bVar222 = this.k;
                                                            bVar222.b(Message.a(str13, str11, bVar222.b((String) null), 5), z2);
                                                            AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                                        }
                                                    } else {
                                                        reqType = valueOf;
                                                        str7 = "handleMessage";
                                                        i6 = a4;
                                                        str23 = str2;
                                                        str10 = str3;
                                                        str19 = str4;
                                                        str24 = str16;
                                                        str25 = str22;
                                                        map3 = map2;
                                                        bArr3 = bArr2;
                                                        try {
                                                            a(remove, errorCode, map3);
                                                        } catch (Exception e9) {
                                                            e = e9;
                                                            str20 = a3;
                                                            str18 = str23;
                                                            str9 = str18;
                                                            str21 = str20;
                                                            str27 = str6;
                                                            str28 = str21;
                                                            str11 = str19;
                                                            str12 = str27;
                                                            str15 = str28;
                                                            i3 = 0;
                                                            z2 = true;
                                                            str14 = str12;
                                                            str13 = str15;
                                                            ALog.e(this.l, str7, e, new Object[i3]);
                                                            com.taobao.accs.net.b bVar2222 = this.k;
                                                            bVar2222.b(Message.a(str13, str11, bVar2222.b((String) null), 5), z2);
                                                            AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                                        }
                                                    }
                                                    String str44 = remove.H;
                                                    bArr4 = bArr;
                                                    str20 = a3;
                                                    str18 = str23;
                                                    map4 = map3;
                                                    a(new TrafficsMonitor.a(str44, GlobalAppRuntimeInfo.isAppBackground(), str, bArr4.length));
                                                    a3 = str20;
                                                    str26 = str25;
                                                    i7 = i6;
                                                    i8 = 0;
                                                    z4 = true;
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    str7 = "handleMessage";
                                                    str8 = a3;
                                                    str9 = str2;
                                                    str10 = str3;
                                                    str11 = str4;
                                                    str12 = str6;
                                                    str15 = str8;
                                                    i3 = 0;
                                                    z2 = true;
                                                    str14 = str12;
                                                    str13 = str15;
                                                    ALog.e(this.l, str7, e, new Object[i3]);
                                                    com.taobao.accs.net.b bVar22222 = this.k;
                                                    bVar22222.b(Message.a(str13, str11, bVar22222.b((String) null), 5), z2);
                                                    AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                                }
                                            }
                                        }
                                        a(new TrafficsMonitor.a(str44, GlobalAppRuntimeInfo.isAppBackground(), str, bArr4.length));
                                        a3 = str20;
                                        str26 = str25;
                                        i7 = i6;
                                        i8 = 0;
                                        z4 = true;
                                    } catch (Exception e11) {
                                        e = e11;
                                        str9 = str18;
                                        str21 = str20;
                                        str27 = str6;
                                        str28 = str21;
                                        str11 = str19;
                                        str12 = str27;
                                        str15 = str28;
                                        i3 = 0;
                                        z2 = true;
                                        str14 = str12;
                                        str13 = str15;
                                        ALog.e(this.l, str7, e, new Object[i3]);
                                        com.taobao.accs.net.b bVar222222 = this.k;
                                        bVar222222.b(Message.a(str13, str11, bVar222222.b((String) null), 5), z2);
                                        AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                    }
                                    if (remove.e() != null) {
                                    }
                                    if (valueOf != Message.ReqType.RES) {
                                    }
                                    String str442 = remove.H;
                                    bArr4 = bArr;
                                    str20 = a3;
                                    str18 = str23;
                                    map4 = map3;
                                }
                            }
                            if (i7 != 0) {
                                try {
                                    reqType2 = reqType;
                                    if (reqType2 == Message.ReqType.RES) {
                                        Message remove2 = this.f.remove(new Message.a(i8, a3));
                                        if (remove2 != null) {
                                            a(remove2, bArr3, bArr4, str);
                                            return;
                                        }
                                        str9 = str;
                                        byte[] bArr7 = bArr3;
                                        j = b;
                                        String str45 = str24;
                                        if (!str45.contains(Constants.TARGET_SERVICE_ST)) {
                                            com.taobao.accs.net.b bVar3 = this.k;
                                            bVar3.b(Message.a(a3, str26, bVar3.b((String) null), 5), true);
                                        }
                                        str24 = str45;
                                        ALog.e(this.l, "handleMessage contorl ACK reqMessage is null", Constants.KEY_DATA_ID, a3);
                                        if (ALog.isPrintLog(ALog.Level.D)) {
                                            String str46 = this.l;
                                            z6 = r14;
                                            ?? r142 = {AgooConstants.MESSAGE_BODY, new String(bArr7)};
                                            ALog.d(str46, "handleMessage not handled", r142);
                                            str31 = r142;
                                        } else {
                                            z6 = r14;
                                            str31 = r14;
                                        }
                                        r5 = 1;
                                        r4 = bArr7;
                                        str32 = str31;
                                        if (i7 != r5 || reqType2 != Message.ReqType.DATA) {
                                            return;
                                        }
                                        try {
                                            if (str26 == null) {
                                                try {
                                                    ?? r0 = this.k;
                                                    r0.b(Message.a(a3, str19, r0.b(null), (int) r5), r5);
                                                    return;
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    str32 = str19;
                                                    str9 = str18;
                                                    str8 = a3;
                                                    str11 = str32;
                                                    str12 = str6;
                                                    str15 = str8;
                                                    i3 = 0;
                                                    z2 = true;
                                                    str14 = str12;
                                                    str13 = str15;
                                                    ALog.e(this.l, str7, e, new Object[i3]);
                                                    com.taobao.accs.net.b bVar2222222 = this.k;
                                                    bVar2222222.b(Message.a(str13, str11, bVar2222222.b((String) null), 5), z2);
                                                    AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                                }
                                            }
                                            String str47 = str19;
                                            String[] split = str26.split("\\|");
                                            if (split.length < 2) {
                                                com.taobao.accs.net.b bVar4 = this.k;
                                                bVar4.b(Message.a(a3, str47, bVar4.b((String) null), 1), true);
                                                return;
                                            }
                                            ?? r1 = ALog.Level.D;
                                            if (ALog.isPrintLog(r1)) {
                                                try {
                                                    str19 = str47;
                                                    ALog.d(this.l, "handleMessage onPush", "isBurstData", Boolean.valueOf(z));
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    str19 = str47;
                                                    str9 = str18;
                                                    str21 = a3;
                                                    str27 = str6;
                                                    str28 = str21;
                                                    str11 = str19;
                                                    str12 = str27;
                                                    str15 = str28;
                                                    i3 = 0;
                                                    z2 = true;
                                                    str14 = str12;
                                                    str13 = str15;
                                                    ALog.e(this.l, str7, e, new Object[i3]);
                                                    com.taobao.accs.net.b bVar22222222 = this.k;
                                                    bVar22222222.b(Message.a(str13, str11, bVar22222222.b((String) null), 5), z2);
                                                    AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                                }
                                            } else {
                                                str19 = str47;
                                            }
                                            com.taobao.accs.ut.a.d dVar = this.i;
                                            if (dVar != null) {
                                                dVar.a();
                                            }
                                            com.taobao.accs.ut.a.d dVar2 = new com.taobao.accs.ut.a.d();
                                            this.i = dVar2;
                                            dVar2.c = String.valueOf(System.currentTimeMillis());
                                            Context context = this.h;
                                            boolean z10 = true;
                                            str11 = split[1];
                                            ?? c = UtilityImpl.c(context, str11);
                                            try {
                                                if (c != 0) {
                                                    String str48 = split.length >= 3 ? split[2] : null;
                                                    this.i.e = str48;
                                                    if (c(str41)) {
                                                        com.taobao.accs.net.b bVar5 = this.k;
                                                        bVar5.b(Message.a(a3, str48, bVar5.b((String) null), 2), true);
                                                        ALog.e(this.l, "handleMessage msg duplicate", Constants.KEY_DATA_ID, a3);
                                                        this.i.h = true;
                                                        obj = Constants.KEY_DATA_ID;
                                                        map5 = map4;
                                                        str33 = str6;
                                                        i11 = i4;
                                                        str38 = str19;
                                                        str39 = str24;
                                                        j2 = j;
                                                        i10 = 1;
                                                    } else {
                                                        if (z) {
                                                            bArr5 = a(str41, map4, r4);
                                                            if (bArr5 == null) {
                                                                try {
                                                                    com.taobao.accs.net.b bVar6 = this.k;
                                                                    try {
                                                                        bVar6.b(Message.a(a3, str48, bVar6.b((String) null), 1), true);
                                                                        return;
                                                                    } catch (Exception e14) {
                                                                        e = e14;
                                                                        str9 = str18;
                                                                        str21 = a3;
                                                                        str27 = str6;
                                                                        str28 = str21;
                                                                        str11 = str19;
                                                                        str12 = str27;
                                                                        str15 = str28;
                                                                        i3 = 0;
                                                                        z2 = true;
                                                                        str14 = str12;
                                                                        str13 = str15;
                                                                        ALog.e(this.l, str7, e, new Object[i3]);
                                                                        com.taobao.accs.net.b bVar222222222 = this.k;
                                                                        bVar222222222.b(Message.a(str13, str11, bVar222222222.b((String) null), 5), z2);
                                                                        AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                                                    }
                                                                } catch (Exception e15) {
                                                                    e = e15;
                                                                }
                                                            } else if (i == 1) {
                                                                com.taobao.accs.utl.h hVar2 = new com.taobao.accs.utl.h(bArr5);
                                                                byte[] a6 = a(hVar2);
                                                                if (ALog.isPrintLog(r1)) {
                                                                    bArr6 = a6;
                                                                    ALog.d(this.l, "handleMessage gzip completeOriData", Constants.KEY_DATA_ID, str41, "length", Integer.valueOf(a6.length));
                                                                } else {
                                                                    bArr6 = a6;
                                                                }
                                                                hVar2.close();
                                                                bArr5 = bArr6;
                                                            }
                                                        } else {
                                                            bArr5 = r4;
                                                        }
                                                        d(str41);
                                                        str33 = str6;
                                                        try {
                                                        } catch (Exception e16) {
                                                            e = e16;
                                                        }
                                                        try {
                                                            try {
                                                                if (str33.equals(str48)) {
                                                                    ALog.e(this.l, "handleMessage try deliverMsg", Constants.KEY_DATA_ID, a3, Constants.KEY_TARGET, split[1], str5, str48);
                                                                } else if (ALog.isPrintLog(ALog.Level.I)) {
                                                                    try {
                                                                        str34 = this.l;
                                                                        str35 = split[1];
                                                                        objArr2 = new Object[6];
                                                                    } catch (Exception e17) {
                                                                        e = e17;
                                                                    }
                                                                    try {
                                                                        objArr2[0] = Constants.KEY_DATA_ID;
                                                                        objArr2[1] = a3;
                                                                        objArr2[2] = Constants.KEY_TARGET;
                                                                        objArr2[3] = str35;
                                                                        objArr2[4] = str5;
                                                                        objArr2[5] = str48;
                                                                        ALog.i(str34, "handleMessage try deliverMsg", objArr2);
                                                                        ?? intent = new Intent(Constants.ACTION_RECEIVE);
                                                                        z5 = true;
                                                                        intent.setPackage(split[1]);
                                                                        intent.putExtra("command", 101);
                                                                        if (split.length < 3) {
                                                                            intent.putExtra(str5, split[2]);
                                                                        }
                                                                        if (split.length < 4) {
                                                                            str36 = split[3];
                                                                            intent.putExtra(Constants.KEY_USER_ID, str36);
                                                                        } else {
                                                                            str36 = str19;
                                                                        }
                                                                        intent.putExtra("data", bArr5);
                                                                        intent.putExtra(Constants.KEY_DATA_ID, a3);
                                                                        intent.putExtra(Constants.KEY_PACKAGE_NAME, this.h.getPackageName());
                                                                        intent.putExtra(Constants.KEY_HOST, str9);
                                                                        intent.putExtra(Constants.KEY_CONN_TYPE, this.b);
                                                                        z7 = z6;
                                                                        intent.putExtra(Constants.KEY_NEED_BUSINESS_ACK, z7);
                                                                        intent.putExtra(Constants.KEY_APP_KEY, this.k.i());
                                                                        intent.putExtra(Constants.KEY_CONFIG_TAG, this.k.m);
                                                                        ?? netPerformanceMonitor = new NetPerformanceMonitor();
                                                                        netPerformanceMonitor.setMsgType(4);
                                                                        netPerformanceMonitor.onReceiveData();
                                                                        intent.putExtra(Constants.KEY_MONIROT, netPerformanceMonitor);
                                                                        a(map4, intent);
                                                                        if (z7) {
                                                                            z6 = z7;
                                                                            obj = Constants.KEY_DATA_ID;
                                                                            str37 = str24;
                                                                            j2 = j;
                                                                        } else {
                                                                            z6 = z7;
                                                                            obj = Constants.KEY_DATA_ID;
                                                                            j2 = j;
                                                                            str37 = str24;
                                                                            a(intent, str37, str26, (short) j2);
                                                                        }
                                                                        Log.d("ACCS_TEST", "start to MsgDistribute.distribMessage");
                                                                        g.a(this.h, this.k, intent);
                                                                        UTMini.getInstance().commitEvent(66001, "MsgToBussPush", "commandId=101", "serviceId=" + str48 + " dataId=" + a3, Integer.valueOf(Constants.SDK_VERSION_CODE));
                                                                        StringBuilder sb4 = new StringBuilder();
                                                                        sb4.append("1commandId=101serviceId=");
                                                                        sb4.append(str48);
                                                                        String str49 = str37;
                                                                        AppMonitorAdapter.commitCount(str33, BaseMonitor.COUNT_POINT_TO_BUSS, sb4.toString(), 0.0d);
                                                                        com.taobao.accs.ut.a.d dVar3 = this.i;
                                                                        dVar3.b = a3;
                                                                        dVar3.i = str36;
                                                                        StringBuilder sb5 = new StringBuilder();
                                                                        sb5.append(bArr5 != null ? 0 : bArr5.length);
                                                                        String str50 = str19;
                                                                        sb5.append(str50);
                                                                        dVar3.f = sb5.toString();
                                                                        this.i.a = UtilityImpl.getDeviceId(this.h);
                                                                        this.i.d = String.valueOf(System.currentTimeMillis());
                                                                        str38 = str50;
                                                                        map5 = map4;
                                                                        str39 = str49;
                                                                        i10 = 1;
                                                                        a(new TrafficsMonitor.a(str48, GlobalAppRuntimeInfo.isAppBackground(), str, bArr.length));
                                                                        i11 = i4;
                                                                    } catch (Exception e18) {
                                                                        e = e18;
                                                                        str9 = str18;
                                                                        str28 = a3;
                                                                        str27 = str33;
                                                                        str11 = str19;
                                                                        str12 = str27;
                                                                        str15 = str28;
                                                                        i3 = 0;
                                                                        z2 = true;
                                                                        str14 = str12;
                                                                        str13 = str15;
                                                                        ALog.e(this.l, str7, e, new Object[i3]);
                                                                        com.taobao.accs.net.b bVar2222222222 = this.k;
                                                                        bVar2222222222.b(Message.a(str13, str11, bVar2222222222.b((String) null), 5), z2);
                                                                        AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                                                    }
                                                                }
                                                                a(new TrafficsMonitor.a(str48, GlobalAppRuntimeInfo.isAppBackground(), str, bArr.length));
                                                                i11 = i4;
                                                            } catch (Exception e19) {
                                                                e = e19;
                                                                str9 = str18;
                                                                str15 = a3;
                                                                str12 = str33;
                                                                str11 = str38;
                                                                i3 = 0;
                                                                z2 = true;
                                                                str14 = str12;
                                                                str13 = str15;
                                                                ALog.e(this.l, str7, e, new Object[i3]);
                                                                com.taobao.accs.net.b bVar22222222222 = this.k;
                                                                bVar22222222222.b(Message.a(str13, str11, bVar22222222222.b((String) null), 5), z2);
                                                                AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                                            }
                                                            intent.setPackage(split[1]);
                                                            intent.putExtra("command", 101);
                                                            if (split.length < 3) {
                                                            }
                                                            if (split.length < 4) {
                                                            }
                                                            intent.putExtra("data", bArr5);
                                                            intent.putExtra(Constants.KEY_DATA_ID, a3);
                                                            intent.putExtra(Constants.KEY_PACKAGE_NAME, this.h.getPackageName());
                                                            intent.putExtra(Constants.KEY_HOST, str9);
                                                            intent.putExtra(Constants.KEY_CONN_TYPE, this.b);
                                                            z7 = z6;
                                                            intent.putExtra(Constants.KEY_NEED_BUSINESS_ACK, z7);
                                                            intent.putExtra(Constants.KEY_APP_KEY, this.k.i());
                                                            intent.putExtra(Constants.KEY_CONFIG_TAG, this.k.m);
                                                            ?? netPerformanceMonitor2 = new NetPerformanceMonitor();
                                                            netPerformanceMonitor2.setMsgType(4);
                                                            netPerformanceMonitor2.onReceiveData();
                                                            intent.putExtra(Constants.KEY_MONIROT, netPerformanceMonitor2);
                                                            a(map4, intent);
                                                            if (z7) {
                                                            }
                                                            Log.d("ACCS_TEST", "start to MsgDistribute.distribMessage");
                                                            g.a(this.h, this.k, intent);
                                                            UTMini.getInstance().commitEvent(66001, "MsgToBussPush", "commandId=101", "serviceId=" + str48 + " dataId=" + a3, Integer.valueOf(Constants.SDK_VERSION_CODE));
                                                            StringBuilder sb42 = new StringBuilder();
                                                            sb42.append("1commandId=101serviceId=");
                                                            sb42.append(str48);
                                                            String str492 = str37;
                                                            AppMonitorAdapter.commitCount(str33, BaseMonitor.COUNT_POINT_TO_BUSS, sb42.toString(), 0.0d);
                                                            com.taobao.accs.ut.a.d dVar32 = this.i;
                                                            dVar32.b = a3;
                                                            dVar32.i = str36;
                                                            StringBuilder sb52 = new StringBuilder();
                                                            sb52.append(bArr5 != null ? 0 : bArr5.length);
                                                            String str502 = str19;
                                                            sb52.append(str502);
                                                            dVar32.f = sb52.toString();
                                                            this.i.a = UtilityImpl.getDeviceId(this.h);
                                                            this.i.d = String.valueOf(System.currentTimeMillis());
                                                            str38 = str502;
                                                            map5 = map4;
                                                            str39 = str492;
                                                            i10 = 1;
                                                        } catch (Exception e20) {
                                                            e = e20;
                                                            str9 = str18;
                                                            str29 = a3;
                                                            str30 = str33;
                                                            str11 = str19;
                                                            i3 = 0;
                                                            str14 = str30;
                                                            str13 = str29;
                                                            z2 = z5;
                                                            ALog.e(this.l, str7, e, new Object[i3]);
                                                            com.taobao.accs.net.b bVar222222222222 = this.k;
                                                            bVar222222222222.b(Message.a(str13, str11, bVar222222222222.b((String) null), 5), z2);
                                                            AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                                        }
                                                        ?? intent2 = new Intent(Constants.ACTION_RECEIVE);
                                                        z5 = true;
                                                    }
                                                    if (i11 != i10) {
                                                        return;
                                                    }
                                                    if (str33.equals(str48)) {
                                                        String str51 = this.l;
                                                        Object[] objArr4 = new Object[2];
                                                        objArr4[0] = obj;
                                                        objArr4[i10] = a3;
                                                        ALog.e(str51, "handleMessage try sendAck dataId", objArr4);
                                                    } else {
                                                        String str52 = this.l;
                                                        Object[] objArr5 = new Object[2];
                                                        objArr5[0] = obj;
                                                        objArr5[i10] = a3;
                                                        ALog.i(str52, "handleMessage try sendAck dataId", objArr5);
                                                    }
                                                    String str53 = a3;
                                                    boolean z11 = z6;
                                                    str9 = str18;
                                                    r4 = 0;
                                                    r4 = 0;
                                                    z10 = true;
                                                    z10 = true;
                                                    String str54 = str48;
                                                    str11 = str38;
                                                    String str55 = str33;
                                                    Message a7 = Message.a(this.k, str26, str39, str53, false, (short) j2, str, map5);
                                                    this.k.b(a7, true);
                                                    a(a7.q, str54);
                                                    r1 = str55;
                                                    c = str53;
                                                    if (z11) {
                                                        AppMonitorAdapter.commitCount(str55, BaseMonitor.COUNT_ACK, str11, 0.0d);
                                                        r1 = str55;
                                                        c = str53;
                                                    }
                                                } else {
                                                    str9 = str18;
                                                    String str56 = a3;
                                                    r1 = str6;
                                                    str11 = str19;
                                                    r4 = 0;
                                                    z10 = true;
                                                    ALog.e(this.l, "handleMessage not exist, unbind it", "package", split[1]);
                                                    com.taobao.accs.net.b bVar7 = this.k;
                                                    bVar7.b(Message.a(str56, str11, bVar7.b((String) null), 4), true);
                                                    com.taobao.accs.net.b bVar8 = this.k;
                                                    bVar8.b(Message.a(bVar8, split[1]), true);
                                                    c = str56;
                                                }
                                                return;
                                            } catch (Exception e21) {
                                                e = e21;
                                                str14 = r1;
                                                str13 = c;
                                                i3 = r4;
                                                z2 = z10;
                                                ALog.e(this.l, str7, e, new Object[i3]);
                                                com.taobao.accs.net.b bVar2222222222222 = this.k;
                                                bVar2222222222222.b(Message.a(str13, str11, bVar2222222222222.b((String) null), 5), z2);
                                                AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                            }
                                        } catch (Exception e22) {
                                            e = e22;
                                        }
                                    } else {
                                        str9 = str;
                                        z6 = r14;
                                    }
                                } catch (Exception e23) {
                                    e = e23;
                                    str9 = str18;
                                    str21 = a3;
                                    str27 = str6;
                                    str28 = str21;
                                    str11 = str19;
                                    str12 = str27;
                                    str15 = str28;
                                    i3 = 0;
                                    z2 = true;
                                    str14 = str12;
                                    str13 = str15;
                                    ALog.e(this.l, str7, e, new Object[i3]);
                                    com.taobao.accs.net.b bVar22222222222222 = this.k;
                                    bVar22222222222222.b(Message.a(str13, str11, bVar22222222222222.b((String) null), 5), z2);
                                    AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
                                }
                            } else {
                                str9 = str;
                                z6 = r14;
                                reqType2 = reqType;
                            }
                            r4 = bArr3;
                            j = b;
                            r5 = z4;
                            str32 = r14;
                            if (i7 != r5) {
                                return;
                            } else {
                                return;
                            }
                        } catch (Exception e24) {
                            e = e24;
                            str7 = "handleMessage";
                            str18 = str2;
                            str10 = str3;
                            str19 = str4;
                        }
                    }
                    if (i7 != 0) {
                    }
                    r4 = bArr3;
                    j = b;
                    r5 = z4;
                    str32 = r14;
                    if (i7 != r5) {
                    }
                } catch (Exception e25) {
                    e = e25;
                    str9 = str18;
                    str29 = a3;
                    str30 = str6;
                    z5 = z4;
                }
                i7 = i9;
                z4 = z8;
            } catch (Exception e26) {
                e = e26;
                str7 = "handleMessage";
                str8 = a3;
                str9 = str2;
                str10 = str3;
                str11 = str4;
                str12 = str6;
                str15 = str8;
                i3 = 0;
                z2 = true;
                str14 = str12;
                str13 = str15;
                ALog.e(this.l, str7, e, new Object[i3]);
                com.taobao.accs.net.b bVar222222222222222 = this.k;
                bVar222222222222222.b(Message.a(str13, str11, bVar222222222222222.b((String) null), 5), z2);
                AppMonitorAdapter.commitAlarmFail(str14, str9, str11, str10, this.b + e.toString());
            }
        } catch (Exception e27) {
            ALog.e(this.l, "dataId read error " + e27.toString(), new Object[0]);
            hVar.close();
            AppMonitorAdapter.commitAlarmFail("accs", str2, str4, str3, this.b + "data id read error" + e27.toString());
        }
    }

    public Message b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f.remove(new Message.a(0, str));
    }

    private void b(Message message, ErrorCode errorCode) {
        if (message == null) {
            return;
        }
        String deviceId = UtilityImpl.getDeviceId(this.h);
        String str = System.currentTimeMillis() + "";
        boolean z = errorCode.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt();
        int intValue = message.t.intValue();
        if (intValue == 1) {
            com.taobao.accs.ut.a.a aVar = new com.taobao.accs.ut.a.a();
            aVar.a = deviceId;
            aVar.b = str;
            aVar.c = z;
            aVar.a(errorCode);
            aVar.a();
            return;
        }
        if (intValue != 3) {
            return;
        }
        com.taobao.accs.ut.a.b bVar = new com.taobao.accs.ut.a.b();
        bVar.a = deviceId;
        bVar.b = str;
        bVar.c = z;
        bVar.e = message.G;
        bVar.a(errorCode);
        bVar.a();
    }

    private byte[] a(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                return byteArray;
            } catch (Exception e) {
                ALog.e(this.l, "uncompress data error " + e.toString(), new Object[0]);
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", MessageService.MSG_DB_NOTIFY_REACHED, this.b + " uncompress data error " + e.toString());
                try {
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Exception unused2) {
                }
                return null;
            }
        } catch (Throwable th) {
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    private void a(Message message, byte[] bArr, byte[] bArr2, String str) {
        ErrorCode errorCode;
        JSONObject jSONObject;
        ErrorCode parseHttpCode;
        JSONArray optJSONArray;
        ErrorCode errorCode2 = AccsErrorCode.SUCCESS;
        try {
            try {
                jSONObject = new JSONObject(new String(bArr));
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.l, "handleControlMessage parse", "json", jSONObject.toString());
                }
                parseHttpCode = message.t.intValue() == 100 ? errorCode2 : AccsErrorCode.parseHttpCode(jSONObject.getInt(Constants.KEY_HTTP_CODE));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (parseHttpCode.getCodeInt() == errorCode2.getCodeInt()) {
                int intValue = message.t.intValue();
                if (intValue == 1) {
                    AccsState.getInstance().a(this.k.m, AccsState.BIND_APP_FROM_CACHE, Boolean.FALSE);
                    UtilityImpl.saveUtdid(Constants.SP_FILE_NAME, this.h);
                    try {
                        this.k.j().a(this.h.getPackageName());
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        this.e = JsonUtility.getString(jSONObject2, Constants.KEY_DEVICE_TOKEN, null);
                        if (jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray(Constants.KEY_PACKAGE_NAMES)) != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                String string = optJSONArray.getString(i);
                                if (UtilityImpl.c(this.h, string)) {
                                    this.k.j().a(message.s);
                                } else {
                                    ALog.i(this.l, "unbind app", "pkg", string);
                                    com.taobao.accs.net.b bVar = this.k;
                                    bVar.b(Message.a(bVar, string), true);
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        ALog.i(this.l, "no token/invalid app", th3);
                    }
                } else if (intValue != 2) {
                    if (intValue == 100 && (this.k instanceof com.taobao.accs.net.j) && !message.n.equals(Constants.TARGET_SERVICE_ST)) {
                        ((com.taobao.accs.net.j) this.k).a(jSONObject);
                    }
                } else {
                    this.k.j().b(message.s);
                }
            } else if (parseHttpCode.getCodeInt() == AccsErrorCode.APP_NOT_BIND.getCodeInt()) {
                this.k.j().b(message.s);
            }
            if (parseHttpCode.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) {
                ALog.e(this.l, "handleControlMessage parse", "json", jSONObject.toString());
            }
            errorCode = parseHttpCode;
        } catch (Throwable th4) {
            th = th4;
            errorCode2 = parseHttpCode;
            ALog.e(this.l, "handleControlMessage", th, new Object[0]);
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.b + th.toString());
            errorCode = errorCode2;
            a(message, errorCode, null, bArr, null);
            a(new TrafficsMonitor.a(message.H, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
        }
        a(message, errorCode, null, bArr, null);
        a(new TrafficsMonitor.a(message.H, GlobalAppRuntimeInfo.isAppBackground(), str, bArr2.length));
    }

    private Map<Integer, String> a(com.taobao.accs.utl.h hVar) {
        HashMap hashMap = null;
        if (hVar == null) {
            return null;
        }
        try {
            int b = hVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.l, "extHeaderLen:" + b, new Object[0]);
            }
            int i = 0;
            while (i < b) {
                int b2 = hVar.b();
                int i2 = (64512 & b2) >> 10;
                int i3 = b2 & Message.EXT_HEADER_VALUE_MAX_LEN;
                String a = hVar.a(i3);
                i = i + 2 + i3;
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(Integer.valueOf(i2), a);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.l, "", "extHeaderType", Integer.valueOf(i2), "value", a);
                }
            }
        } catch (Exception e) {
            ALog.e(this.l, "parseExtHeader", e, new Object[0]);
        }
        return hashMap;
    }

    public void a(Message message, ErrorCode errorCode) {
        a(message, errorCode, null, null, null);
    }

    public void a(Message message, ErrorCode errorCode, Map<Integer, String> map) {
        a(message, errorCode, null, null, map);
    }

    public void a(Message message, ErrorCode errorCode, Message.ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        ErrorCode errorCode2;
        byte[] bArr2;
        Map<Integer, String> map2;
        Message.ReqType reqType2;
        if (message.t != null && message.a() >= 0 && message.a() != 2) {
            String str = message.O;
            if (str != null) {
                this.a.remove(str);
            }
            int a = this.d.a(map, message.H);
            if (a != 0) {
                if (a == 2) {
                    errorCode2 = AccsErrorCode.SERVIER_HIGH_LIMIT;
                } else if (a == 3) {
                    errorCode2 = AccsErrorCode.SERVIER_HIGH_LIMIT_BRUSH;
                } else {
                    errorCode2 = AccsErrorCode.SERVIER_LOW_LIMIT;
                }
                reqType2 = null;
                bArr2 = null;
                map2 = null;
            } else {
                errorCode2 = errorCode;
                bArr2 = bArr;
                map2 = map;
                reqType2 = reqType;
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(this.l, "onResult", "command", message.t, "erorcode", errorCode2);
            }
            if (message.t.intValue() == 102) {
                return;
            }
            if ((message.t.intValue() == 1 && errorCode2.getCodeInt() != AccsErrorCode.SUCCESS.getCodeInt()) || errorCode2.getCodeInt() == AccsErrorCode.APP_NOT_BIND.getCodeInt()) {
                this.k.j().b(message.s);
            }
            if (!message.e) {
                if (b(errorCode2) && message.t.intValue() != 100 && message.R <= Message.a) {
                    message.T = System.currentTimeMillis();
                    int i = message.R + 1;
                    message.R = i;
                    ALog.d(this.l, "onResult", "retryTimes", Integer.valueOf(i));
                    this.k.b(message, true);
                } else {
                    Intent c = c(message);
                    c.putExtra(Constants.KEY_ERROR_OBJ, (Serializable) errorCode2);
                    Message.ReqType valueOf = Message.ReqType.valueOf(3 & (message.k >> 13));
                    if (reqType2 == Message.ReqType.RES || valueOf == Message.ReqType.REQ) {
                        c.putExtra(Constants.KEY_SEND_TYPE, Constants.SEND_TYPE_RES);
                    }
                    if (errorCode2.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt()) {
                        c.putExtra("data", bArr2);
                    }
                    c.putExtra(Constants.KEY_APP_KEY, this.k.b);
                    c.putExtra(Constants.KEY_CONFIG_TAG, this.k.m);
                    a(map2, c);
                    g.a(this.h, this.k, c);
                    if (!TextUtils.isEmpty(message.H)) {
                        UTMini.getInstance().commitEvent(66001, "MsgToBuss0", "commandId=" + message.t, "serviceId=" + message.H + " errorCode=" + errorCode2 + " dataId=" + message.q, Integer.valueOf(Constants.SDK_VERSION_CODE));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("1commandId=");
                        sb2.append(message.t);
                        sb2.append("serviceId=");
                        sb2.append(message.H);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb2.toString(), 0.0d);
                    }
                }
            } else {
                ALog.e(this.l, "onResult message is cancel", "command", message.t);
            }
            NetPerformanceMonitor e = message.e();
            if (e != null) {
                e.onToBizDate();
                URL url = message.f;
                String url2 = url == null ? null : url.toString();
                if (errorCode2.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt()) {
                    e.setRet(true);
                    if (message.R > 0) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.R, 0.0d);
                    } else {
                        AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_REQUEST, url2);
                    }
                } else {
                    if (message.R > 0) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "fail＿" + errorCode2, 0.0d);
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "fail", 0.0d);
                    } else if (errorCode2.getCodeInt() != AccsErrorCode.NO_NETWORK.getCodeInt()) {
                        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQUEST, url2, UtilityImpl.a(errorCode2.getCodeInt()), this.b + message.H + message.S);
                    }
                    e.setRet(false);
                    e.setFailReason(errorCode2);
                }
                AppMonitor.getInstance().commitStat(message.e());
            }
            b(message, errorCode2);
            return;
        }
        ALog.d(this.l, "onError, skip ping/ack", new Object[0]);
    }

    public void a() {
        ALog.d(this.l, "onSendPing", new Object[0]);
        synchronized (d.class) {
            this.g = true;
        }
    }

    public void a(Message message) {
        String str;
        Log.d("ACCS_TEST", "MessageHandler onSend");
        Message message2 = this.j;
        if (message2 != null && (str = message.O) != null && message.H != null && message2.O.equals(str) && this.j.H.equals(message.H)) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.H, message.O, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.a() == -1 || message.a() == 2 || message.c) {
            return;
        }
        this.f.put(message.d(), message);
    }

    public void a(ErrorCode errorCode) {
        this.g = false;
        Message.a[] aVarArr = (Message.a[]) this.f.keySet().toArray(new Message.a[0]);
        if (aVarArr.length > 0) {
            ALog.d(this.l, "onNetworkFail", new Object[0]);
            for (Message.a aVar : aVarArr) {
                Message remove = this.f.remove(aVar);
                if (remove != null) {
                    a(remove, errorCode);
                }
            }
        }
    }

    public Message a(String str) {
        return this.f.get(new Message.a(0, str));
    }

    private byte[] a(String str, Map<Integer, String> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    int parseInt = Integer.parseInt(map.get(17));
                    int parseInt2 = Integer.parseInt(map.get(16));
                    if (parseInt2 <= 1) {
                        throw new RuntimeException("burstNums <= 1");
                    }
                    if (parseInt >= 0 && parseInt < parseInt2) {
                        String str2 = map.get(18);
                        long j = 0;
                        try {
                            String str3 = map.get(15);
                            if (!TextUtils.isEmpty(str3)) {
                                j = Long.parseLong(str3);
                            }
                        } catch (Throwable th) {
                            ALog.w(this.l, "putBurstMessage", th, new Object[0]);
                        }
                        a aVar = this.n.get(str);
                        if (aVar == null) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(this.l, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(parseInt2));
                            }
                            aVar = new a(str, parseInt2, str2);
                            aVar.a(j);
                            this.n.put(str, aVar);
                        }
                        return aVar.a(parseInt, parseInt2, bArr);
                    }
                    throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", Integer.valueOf(parseInt2), Integer.valueOf(parseInt)));
                }
            } catch (Throwable th2) {
                ALog.w(this.l, "putBurstMessage", th2, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("burstLength == 0");
    }

    private void a(Map<Integer, String> map, Intent intent) {
        if (map == null || intent == null) {
            return;
        }
        intent.putExtra(TaoBaseService.ExtraInfo.EXT_HEADER, (HashMap) map);
    }

    private void a(Intent intent, String str, String str2, short s) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("source", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra(Constants.KEY_TARGET, str2);
            }
            intent.putExtra(Constants.KEY_FLAGS, s);
        }
    }

    private void a(String str, String str2) {
        com.taobao.accs.ut.a.e eVar = new com.taobao.accs.ut.a.e();
        eVar.a = UtilityImpl.getDeviceId(this.h);
        eVar.c = str;
        eVar.d = "" + System.currentTimeMillis();
        eVar.f = "";
        eVar.e = str2;
        eVar.b = "";
        eVar.a();
    }

    public void a(TrafficsMonitor.a aVar) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new e(this, aVar));
        } catch (Throwable th) {
            ALog.e(this.l, "addTrafficsInfo", th, new Object[0]);
        }
    }
}
