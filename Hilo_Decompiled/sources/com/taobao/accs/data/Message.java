package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.RomInfoCollecter;
import com.taobao.accs.utl.UtilityImpl;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class Message {
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BINDAPP = "ctrl_bindapp";
    public static final String KEY_BINDSERVICE = "ctrl_bindservice";
    public static final String KEY_BINDUSER = "ctrl_binduser";
    public static final String KEY_UNBINDAPP = "ctrl_unbindapp";
    public static final String KEY_UNBINDSERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBINDUSER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;
    public static int a = 5;
    static long b = 1;
    byte[] N;
    public String O;
    int P;
    public long T;
    long U;
    transient NetPerformanceMonitor W;
    a Y;
    public URL f;
    short i;
    short j;
    short k;
    byte l;
    byte m;
    String n;
    String o;
    public String q;
    Map<Integer, String> r;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    byte g = 0;
    byte h = 0;
    int p = -1;
    String s = null;
    public Integer t = null;
    Integer u = 0;
    String v = null;
    public String w = null;
    Integer x = null;
    String y = null;
    String z = null;
    String A = null;
    String B = null;
    String C = null;
    Integer D = null;
    String E = null;
    String F = null;
    public String G = null;
    public String H = null;
    String I = null;
    String J = null;
    String K = null;
    String L = null;
    String M = null;
    public long Q = 0;
    public int R = 0;
    public int S = com.taobao.accs.net.b.ACCS_RECEIVE_TIMEOUT;
    public String V = null;
    String X = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i) {
            if (i == 0) {
                return DATA;
            }
            if (i == 1) {
                return ACK;
            }
            if (i == 2) {
                return REQ;
            }
            if (i != 3) {
                return DATA;
            }
            return RES;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class a {
        private int a;
        private String b;

        public a(int i, String str) {
            this.a = i;
            this.b = str;
        }

        public int a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a == aVar.a() || this.b.equals(aVar.b())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.b.hashCode();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class b {
        public static final int INVALID = -1;
        public static final int NEED_ACK = 1;
        public static final int NO_ACK = 0;

        public static int a(int i) {
            return i != 0 ? 1 : 0;
        }

        public static String b(int i) {
            if (i != 0) {
                if (i != 1) {
                    return "INVALID";
                }
                return "NEED_ACK";
            }
            return "NO_ACK";
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class c {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static int a(int i) {
            int i2 = 1;
            if (i != 1) {
                i2 = 2;
                if (i != 2) {
                    i2 = 3;
                    if (i != 3) {
                        return 0;
                    }
                }
            }
            return i2;
        }

        public static String b(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return "INVALID";
                        }
                        return "HANDSHAKE";
                    }
                    return "PING";
                }
                return "DATA";
            }
            return "CONTROL";
        }
    }

    private Message() {
        synchronized (Message.class) {
            this.T = System.currentTimeMillis();
            String str = String.valueOf(this.T) + "." + String.valueOf(b);
            this.q = str;
            long j = b;
            b = 1 + j;
            this.Y = new a((int) j, str);
        }
    }

    private String j() {
        return "Msg_" + this.X;
    }

    public int a() {
        return this.p;
    }

    public String b() {
        return this.q;
    }

    public boolean c() {
        return Constants.TARGET_CONTROL.equals(this.n);
    }

    public a d() {
        return this.Y;
    }

    public NetPerformanceMonitor e() {
        return this.W;
    }

    public String f() {
        String str = this.s;
        if (str == null) {
            return "";
        }
        return str;
    }

    public boolean g() {
        boolean z;
        if ((System.currentTimeMillis() - this.T) + this.Q >= this.S) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ALog.e(j(), "delay time:" + this.Q + " beforeSendTime:" + (System.currentTimeMillis() - this.T) + " timeout" + this.S, new Object[0]);
        }
        return z;
    }

    void h() {
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
            } catch (Exception unused) {
                return;
            }
        } catch (Throwable th2) {
            gZIPOutputStream = null;
            th = th2;
            byteArrayOutputStream = null;
        }
        if (this.N == null) {
            return;
        }
        byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        } catch (Throwable th3) {
            gZIPOutputStream = null;
            th = th3;
        }
        try {
            gZIPOutputStream.write(this.N);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray != null && byteArray.length < this.N.length) {
                this.N = byteArray;
                this.g = (byte) 1;
            }
            gZIPOutputStream.close();
        } catch (Throwable th4) {
            th = th4;
            try {
                ALog.w(j(), "compressData fail", th, new Object[0]);
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                if (byteArrayOutputStream == null) {
                    return;
                }
                byteArrayOutputStream.close();
            } catch (Throwable th5) {
                if (gZIPOutputStream != null) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused2) {
                        throw th5;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th5;
            }
        }
        byteArrayOutputStream.close();
    }

    void i() throws JSONException, UnsupportedEncodingException {
        Integer num;
        Integer num2 = this.t;
        if (num2 != null && num2.intValue() != 100 && this.t.intValue() != 102) {
            JsonUtility.JsonObjectBuilder jsonObjectBuilder = new JsonUtility.JsonObjectBuilder();
            if (this.t.intValue() == 100) {
                num = null;
            } else {
                num = this.t;
            }
            this.N = jsonObjectBuilder.put("command", num).put(Constants.KEY_APP_KEY, this.v).put(Constants.KEY_OS_TYPE, this.x).put(Constants.KEY_SECURITY_SIGN, this.w).put(Constants.KEY_SDK_VERSION, this.D).put(Constants.KEY_APP_VERSION, this.C).put(Constants.KEY_TTID, this.E).put(Constants.KEY_MODEL, this.I).put(Constants.KEY_BRAND, this.J).put(Constants.KEY_IMEI, this.K).put(Constants.KEY_IMSI, this.L).put(Constants.KEY_OS_VERSION, this.y).put(Constants.KEY_EXTS, this.B).build().toString().getBytes("utf-8");
        }
    }

    public static Message b(com.taobao.accs.net.b bVar, Intent intent) {
        Message message = null;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra(Constants.KEY_APP_KEY);
            intent.getStringExtra(Constants.KEY_SID);
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            message = a(stringExtra, stringExtra2);
            message.X = bVar.m;
            a(bVar, message);
            return message;
        } catch (Throwable th) {
            ALog.e("Msg", "buildBindService", th, new Object[0]);
            th.printStackTrace();
            return message;
        }
    }

    public static Message c(com.taobao.accs.net.b bVar, Intent intent) {
        Message message = null;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra(Constants.KEY_APP_KEY);
            intent.getStringExtra(Constants.KEY_SID);
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            message = b(stringExtra, stringExtra2);
            message.X = bVar.m;
            a(bVar, message);
            return message;
        } catch (Exception e) {
            ALog.e("Msg", "buildUnbindService", e, new Object[0]);
            e.printStackTrace();
            return message;
        }
    }

    public static Message d(com.taobao.accs.net.b bVar, Intent intent) {
        Message message = null;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra(Constants.KEY_APP_KEY);
            intent.getStringExtra(Constants.KEY_SID);
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            message = c(stringExtra, stringExtra2);
            if (message != null) {
                message.X = bVar.m;
                a(bVar, message);
            }
        } catch (Exception e) {
            ALog.e("Msg", "buildBindUser", e, new Object[0]);
            e.printStackTrace();
        }
        return message;
    }

    public static Message e(com.taobao.accs.net.b bVar, Intent intent) {
        Message message = null;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra(Constants.KEY_APP_KEY);
            intent.getStringExtra(Constants.KEY_SID);
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            message = a(stringExtra);
            message.X = bVar.m;
            a(bVar, message);
            return message;
        } catch (Exception e) {
            ALog.e("Msg", "buildUnbindUser", e, new Object[0]);
            e.printStackTrace();
            return message;
        }
    }

    public void a(long j) {
        this.U = j;
    }

    public byte[] a(Context context, int i) {
        byte[] bytes;
        try {
            i();
        } catch (UnsupportedEncodingException e) {
            ALog.e(j(), "build2", e, new Object[0]);
        } catch (JSONException e2) {
            ALog.e(j(), "build1", e2, new Object[0]);
        }
        byte[] bArr = this.N;
        String str = bArr != null ? new String(bArr) : "";
        h();
        if (!this.c) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(UtilityImpl.getDeviceId(context));
            sb2.append("|");
            sb2.append(this.s);
            sb2.append("|");
            String str2 = this.H;
            if (str2 == null) {
                str2 = "";
            }
            sb2.append(str2);
            sb2.append("|");
            String str3 = this.G;
            if (str3 == null) {
                str3 = "";
            }
            sb2.append(str3);
            this.o = sb2.toString();
        }
        try {
            bytes = (this.q + "").getBytes("utf-8");
            this.m = (byte) this.o.getBytes("utf-8").length;
            this.l = (byte) this.n.getBytes("utf-8").length;
        } catch (Exception e3) {
            e3.printStackTrace();
            ALog.e(j(), "build3", e3, new Object[0]);
            bytes = (this.q + "").getBytes();
            this.m = (byte) this.o.getBytes().length;
            this.l = (byte) this.n.getBytes().length;
        }
        short a2 = a(this.r);
        int length = this.l + 4 + this.m + 1 + bytes.length;
        byte[] bArr2 = this.N;
        short length2 = (short) (length + (bArr2 == null ? 0 : bArr2.length) + a2 + 2);
        this.j = length2;
        this.i = (short) (length2 + 2);
        com.taobao.accs.utl.g gVar = new com.taobao.accs.utl.g(this.i + 6);
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            ALog.d(j(), "Build Message", Constants.KEY_DATA_ID, new String(bytes));
        }
        try {
            gVar.a((byte) (this.g | 32));
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tversion:2 compress:" + ((int) this.g), new Object[0]);
            }
            if (i == 0) {
                gVar.a(Byte.MIN_VALUE);
                if (ALog.isPrintLog(level)) {
                    ALog.d(j(), "\tflag: 0x80", new Object[0]);
                }
            } else {
                gVar.a((byte) 64);
                if (ALog.isPrintLog(level)) {
                    ALog.d(j(), "\tflag: 0x40", new Object[0]);
                }
            }
            gVar.a(this.i);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\ttotalLength:" + ((int) this.i), new Object[0]);
            }
            gVar.a(this.j);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tdataLength:" + ((int) this.j), new Object[0]);
            }
            gVar.a(this.k);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tflags:" + Integer.toHexString(this.k), new Object[0]);
            }
            gVar.a(this.l);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\ttargetLength:" + ((int) this.l), new Object[0]);
            }
            gVar.write(this.n.getBytes("utf-8"));
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\ttarget:" + this.n, new Object[0]);
            }
            gVar.a(this.m);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tsourceLength:" + ((int) this.m), new Object[0]);
            }
            gVar.write(this.o.getBytes("utf-8"));
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tsource:" + this.o, new Object[0]);
            }
            gVar.a((byte) bytes.length);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tdataIdLength:" + bytes.length, new Object[0]);
            }
            gVar.write(bytes);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\tdataId:" + new String(bytes), new Object[0]);
            }
            gVar.a(a2);
            if (ALog.isPrintLog(level)) {
                ALog.d(j(), "\textHeader len:" + ((int) a2), new Object[0]);
            }
            Map<Integer, String> map = this.r;
            if (map != null) {
                for (Integer num : map.keySet()) {
                    int intValue = num.intValue();
                    String str4 = this.r.get(num);
                    if (!TextUtils.isEmpty(str4)) {
                        gVar.a((short) ((((short) intValue) << 10) | ((short) (str4.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN))));
                        gVar.write(str4.getBytes("utf-8"));
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            ALog.d(j(), "\textHeader key:" + intValue + " value:" + str4, new Object[0]);
                        }
                    }
                }
            }
            byte[] bArr3 = this.N;
            if (bArr3 != null) {
                gVar.write(bArr3);
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(j(), "\toriData:" + str, new Object[0]);
            }
            gVar.flush();
        } catch (IOException e4) {
            ALog.e(j(), "build4", e4, new Object[0]);
        }
        byte[] byteArray = gVar.toByteArray();
        try {
            gVar.close();
        } catch (IOException e5) {
            ALog.e(j(), "build5", e5, new Object[0]);
        }
        return byteArray;
    }

    public static Message b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.s = str;
        message.H = str2;
        message.n = Constants.TARGET_CONTROL;
        message.t = 6;
        message.s = str;
        message.H = str2;
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.O = KEY_UNBINDSERVICE;
        return message;
    }

    public static Message c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.s = str;
        message.G = str2;
        message.n = Constants.TARGET_CONTROL;
        message.t = 3;
        message.s = str;
        message.G = str2;
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.O = KEY_BINDUSER;
        return message;
    }

    short a(Map<Integer, String> map) {
        short s = 0;
        if (map != null) {
            try {
                for (Integer num : map.keySet()) {
                    num.intValue();
                    String str = map.get(num);
                    if (!TextUtils.isEmpty(str)) {
                        s = (short) (s + ((short) (str.getBytes("utf-8").length & EXT_HEADER_VALUE_MAX_LEN)) + 2);
                    }
                }
            } catch (Exception e) {
                e.toString();
            }
        }
        return s;
    }

    public static Message a(boolean z, int i) {
        Message message = new Message();
        message.p = 2;
        message.t = 201;
        message.d = z;
        message.Q = i;
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, Intent intent) {
        Message message = null;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            intent.getStringExtra(Constants.KEY_USER_ID);
            String stringExtra2 = intent.getStringExtra(Constants.KEY_APP_KEY);
            String stringExtra3 = intent.getStringExtra(Constants.KEY_TTID);
            intent.getStringExtra(Constants.KEY_SID);
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            message = a(context, bVar.m, stringExtra2, intent.getStringExtra("app_sercet"), stringExtra, stringExtra3, intent.getStringExtra(Constants.KEY_APP_VERSION));
            a(bVar, message);
            return message;
        } catch (Exception e) {
            ALog.e("Msg", "buildBindApp", e.getMessage());
            return message;
        }
    }

    public static Message a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.x = 1;
        message.y = Build.VERSION.SDK_INT + "";
        message.s = str4;
        message.n = Constants.TARGET_CONTROL;
        message.t = 1;
        message.v = str2;
        message.w = UtilityImpl.a(str2, str3, UtilityImpl.getDeviceId(context));
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.C = str6;
        message.s = str4;
        message.E = str5;
        message.I = Build.MODEL;
        message.J = Build.BRAND;
        message.O = KEY_BINDAPP;
        message.X = str;
        message.B = new JsonUtility.JsonObjectBuilder().put("notifyEnable", UtilityImpl.k(context)).put("romInfo", RomInfoCollecter.getCollecter().collect()).build().toString();
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Intent intent) {
        ALog.e("Msg", "buildUnbindApp1" + UtilityImpl.a(new Exception()), new Object[0]);
        Message message = null;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            intent.getStringExtra(Constants.KEY_USER_ID);
            intent.getStringExtra(Constants.KEY_SID);
            intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
            message = a(bVar, stringExtra);
            a(bVar, message);
            return message;
        } catch (Exception e) {
            ALog.e("Msg", "buildUnbindApp1", e.getMessage());
            return message;
        }
    }

    public static Message a(com.taobao.accs.net.b bVar, String str) {
        Message message = null;
        try {
            ALog.e("Msg", "buildUnbindApp" + UtilityImpl.a(new Exception()), new Object[0]);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Message message2 = new Message();
            try {
                message2.P = 1;
                message2.a(1, ReqType.DATA, 1);
                message2.s = str;
                message2.n = Constants.TARGET_CONTROL;
                message2.t = 2;
                message2.s = str;
                message2.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
                message2.O = KEY_UNBINDAPP;
                a(bVar, message2);
                return message2;
            } catch (Exception e) {
                e = e;
                message = message2;
                ALog.e("Msg", "buildUnbindApp", e.getMessage());
                return message;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static Message a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.s = str;
        message.H = str2;
        message.n = Constants.TARGET_CONTROL;
        message.t = 5;
        message.s = str;
        message.H = str2;
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.O = KEY_BINDSERVICE;
        return message;
    }

    public static Message a(String str, String str2, String str3, int i) {
        Message message = new Message();
        try {
            message.f = new URL(str3);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        message.n = Constants.TARGET_SERVICE_ST;
        message.a(1, ReqType.DATA, 0);
        message.t = 100;
        message.N = ("0|" + i + "|" + str + "|" + AdapterUtilityImpl.getDeviceId(GlobalClientInfo.getContext()) + "|" + str2).getBytes();
        return message;
    }

    public static Message a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.s = str;
        message.n = Constants.TARGET_CONTROL;
        message.t = 4;
        message.D = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.O = KEY_UNBINDUSER;
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, String str, ACCSManager.AccsRequest accsRequest) {
        return a(bVar, context, str, accsRequest, true);
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, String str, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.DATA, 1);
        message.t = 100;
        message.s = str;
        message.H = accsRequest.serviceId;
        message.G = accsRequest.userId;
        message.N = accsRequest.data;
        String str2 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Constants.TARGET_SERVICE_PRE);
        sb2.append(str2);
        sb2.append("|");
        String str3 = accsRequest.target;
        if (str3 == null) {
            str3 = "";
        }
        sb2.append(str3);
        message.n = sb2.toString();
        message.O = accsRequest.dataId;
        message.V = accsRequest.businessId;
        int i = accsRequest.timeout;
        if (i > 0) {
            message.S = i;
        }
        if (z) {
            a(bVar, message, accsRequest);
        } else {
            message.f = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(bVar.m), GlobalClientInfo.getInstance(context).getUserId(bVar.m), bVar.i.getStoreId(), GlobalClientInfo.b, accsRequest.businessId, accsRequest.tag);
        NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
        message.W = netPerformanceMonitor;
        netPerformanceMonitor.setMsgType(0);
        message.W.setDataId(accsRequest.dataId);
        message.W.setServiceId(accsRequest.serviceId);
        NetPerformanceMonitor netPerformanceMonitor2 = message.W;
        URL url = message.f;
        netPerformanceMonitor2.setHost(url != null ? url.toString() : "");
        message.X = bVar.m;
        return message;
    }

    public static Message a(com.taobao.accs.net.b bVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.P = 1;
        message.a(1, ReqType.REQ, 1);
        message.t = 100;
        message.s = str;
        message.H = accsRequest.serviceId;
        message.G = accsRequest.userId;
        message.N = accsRequest.data;
        String str3 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str3);
        sb2.append("|");
        String str4 = accsRequest.target;
        if (str4 == null) {
            str4 = "";
        }
        sb2.append(str4);
        message.n = sb2.toString();
        message.O = accsRequest.dataId;
        message.V = accsRequest.businessId;
        message.X = bVar.m;
        int i = accsRequest.timeout;
        if (i > 0) {
            message.S = i;
        }
        if (z) {
            a(bVar, message, accsRequest);
        } else {
            message.f = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(bVar.m), GlobalClientInfo.getInstance(context).getUserId(bVar.m), bVar.i.getStoreId(), GlobalClientInfo.b, accsRequest.businessId, accsRequest.tag);
        NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
        message.W = netPerformanceMonitor;
        netPerformanceMonitor.setDataId(accsRequest.dataId);
        message.W.setServiceId(accsRequest.serviceId);
        NetPerformanceMonitor netPerformanceMonitor2 = message.W;
        URL url = message.f;
        netPerformanceMonitor2.setHost(url != null ? url.toString() : "");
        message.X = bVar.m;
        return message;
    }

    private static void a(com.taobao.accs.net.b bVar, Message message, ACCSManager.AccsRequest accsRequest) {
        URL url = accsRequest.host;
        if (url == null) {
            try {
                message.f = new URL(bVar.b((String) null));
                return;
            } catch (MalformedURLException e) {
                ALog.e("Msg", "setUnit", e, new Object[0]);
                e.printStackTrace();
                return;
            }
        }
        message.f = url;
    }

    private static void a(com.taobao.accs.net.b bVar, Message message) {
        try {
            message.f = new URL(bVar.b((String) null));
        } catch (Exception e) {
            ALog.e("Msg", "setControlHost", e, new Object[0]);
        }
    }

    public static Message a(com.taobao.accs.net.b bVar, String str, String str2, String str3, boolean z, short s, String str4, Map<Integer, String> map) {
        Message message = new Message();
        message.P = 1;
        message.a(s, z);
        message.o = str;
        message.n = str2;
        message.q = str3;
        message.c = true;
        message.r = map;
        try {
            try {
                if (TextUtils.isEmpty(str4)) {
                    message.f = new URL(bVar.b((String) null));
                } else {
                    message.f = new URL(str4);
                }
                message.X = bVar.m;
                if (message.f == null) {
                    message.f = new URL(bVar.b((String) null));
                }
            } catch (Throwable th) {
                try {
                    ALog.e("Msg", "buildPushAck", th, new Object[0]);
                    if (message.f == null) {
                        message.f = new URL(bVar.b((String) null));
                    }
                } catch (Throwable th2) {
                    if (message.f == null) {
                        try {
                            message.f = new URL(bVar.b((String) null));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                    throw th2;
                }
            }
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        return message;
    }

    public static Message a(String str, int i) {
        Message message = new Message();
        message.a(1, ReqType.ACK, 0);
        message.t = Integer.valueOf(i);
        message.s = str;
        return message;
    }

    private static void a(Message message, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str5) && TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str6) && str4 == null) {
            return;
        }
        message.r = new HashMap();
        if (str5 != null && UtilityImpl.a(str5) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()), str5);
        }
        if (str != null && UtilityImpl.a(str) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_SID.ordinal()), str);
        }
        if (str2 != null && UtilityImpl.a(str2) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_USERID.ordinal()), str2);
        }
        if (str6 != null && UtilityImpl.a(str6) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_TAG.ordinal()), str6);
        }
        if (str4 != null && UtilityImpl.a(str4) <= 1023) {
            message.r.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_COOKIE.ordinal()), str4);
        }
        if (str3 == null || UtilityImpl.a(str3) > 1023) {
            return;
        }
        message.r.put(19, str3);
    }

    private void a(int i, ReqType reqType, int i2) {
        this.p = i;
        if (i != 2) {
            this.k = (short) (((((i & 1) << 4) | (reqType.ordinal() << 2)) | i2) << 11);
        }
    }

    private void a(short s, boolean z) {
        this.p = 1;
        short s2 = (short) (((short) (((short) (((short) (s & (-16385))) | 8192)) & (-2049))) & (-65));
        this.k = s2;
        if (z) {
            this.k = (short) (s2 | 32);
        }
    }
}
