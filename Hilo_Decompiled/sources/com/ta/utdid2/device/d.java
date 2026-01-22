package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ta.a.c.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class d {
    private static d a;

    /* renamed from: a, reason: collision with other field name */
    private com.ta.utdid2.b.a.a f٩a;
    private String d = null;
    private Context mContext;
    private static Pattern b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    /* renamed from: a, reason: collision with other field name */
    private static final Object f٨a = new Object();
    private static final String f = ".UTSystemConfig" + File.separator + "Global";
    private static int e = 0;
    private static String g = "";

    private d(Context context) {
        this.f٩a = null;
        this.mContext = context;
        com.ta.a.a.a().a(context);
        this.f٩a = new com.ta.utdid2.b.a.a(context, f, "Alvin2");
    }

    public static d a(Context context) {
        if (context != null && a == null) {
            synchronized (f٨a) {
                try {
                    if (a == null) {
                        a = new d(context);
                    }
                } finally {
                }
            }
        }
        return a;
    }

    private static String b(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(com.ta.a.c.e.b(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return com.ta.utdid2.a.a.a.encodeToString(mac.doFinal(bArr), 2);
    }

    private void c(String str) {
        if (m١٣٠c(str)) {
            e = 6;
            f.m١٢٧a("UTUtdid", "utdid type:", 6);
            this.f٩a.a(str, e);
        }
    }

    private String p() {
        String q = q();
        if (m١٣٠c(q)) {
            if (!TextUtils.isEmpty(q) && q.endsWith("\n")) {
                this.d = q.substring(0, q.length() - 1);
            } else {
                this.d = q;
            }
            return this.d;
        }
        try {
            byte[] a2 = a();
            if (a2 != null) {
                String encodeToString = com.ta.utdid2.a.a.a.encodeToString(a2, 2);
                this.d = encodeToString;
                e = 6;
                c(encodeToString);
                return this.d;
            }
            return null;
        } catch (Exception e2) {
            f.a("", e2, new Object[0]);
            return null;
        }
    }

    private String q() {
        String k = this.f٩a.k();
        if (m١٣٠c(k)) {
            int a2 = this.f٩a.a();
            if (a2 == 0) {
                e = 1;
            } else {
                e = a2;
            }
            f.m١٢٧a("UTUtdid", "get utdid from sp. type", Integer.valueOf(e));
            return k;
        }
        f.m١٢٧a("UTUtdid", "read utdid is null");
        Log.d("UTUtdid", "read utdid is null");
        return null;
    }

    public static void setExtendFactor(String str) {
        g = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setType(int i) {
        e = i;
    }

    public synchronized String getValue() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        return p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c, reason: collision with other method in class */
    public static boolean m١٣٠c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 == str.length()) {
            return !b.matcher(str).find();
        }
        return false;
    }

    private byte[] a() throws Exception {
        String str;
        f.m١٢٧a("UTUtdid", "generateUtdid");
        Log.d("UTUtdid", "generateUtdid");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = com.ta.utdid2.a.a.b.getBytes(currentTimeMillis);
        byte[] bytes2 = com.ta.utdid2.a.a.b.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = g + com.ta.utdid2.a.a.c.b(this.mContext);
        } catch (Exception unused) {
            str = g + new Random().nextInt();
        }
        byteArrayOutputStream.write(com.ta.utdid2.a.a.b.getBytes(com.ta.utdid2.a.a.d.a(str)), 0, 4);
        byteArrayOutputStream.write(com.ta.utdid2.a.a.b.getBytes(com.ta.utdid2.a.a.d.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }
}
