package com.ta.utdid2.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.Random;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class c {
    public static String b(Context context) {
        String str = null;
        if (d.b(null)) {
            str = i();
        }
        if (d.b(str)) {
            return h();
        }
        return str;
    }

    public static String h() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] bytes = b.getBytes(currentTimeMillis);
        byte[] bytes2 = b.getBytes(nanoTime);
        byte[] bytes3 = b.getBytes(nextInt);
        byte[] bytes4 = b.getBytes(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return a.encodeToString(bArr, 2);
    }

    private static String i() {
        String str = e.get("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(str)) {
            str = e.get("ro.sys.aliyun.clouduuid", "");
        }
        if (TextUtils.isEmpty(str)) {
            return j();
        }
        return str;
    }

    private static String j() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", null).invoke(null, null);
        } catch (Exception unused) {
            return "";
        }
    }
}
