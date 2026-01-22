package com.alibaba.sdk.android.tbrest.a;

import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.MD5Utils;
import com.alibaba.sdk.android.tbrest.utils.RC4;
import com.amazonaws.services.s3.internal.Constants;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private String f٦٨١٢b;

    /* renamed from: b, reason: collision with other field name */
    private byte[] f١٩b = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٦٨١٣f;

    /* renamed from: l, reason: collision with root package name */
    private String f٦٨١٤l;

    public a(String str, String str2, boolean z10) {
        this.f٦٨١٢b = str;
        this.f٦٨١٤l = str2;
        this.f٦٨١٣f = z10;
    }

    public static String a(byte[] bArr, byte[] bArr2) throws Exception {
        Mac mac = Mac.getInstance(Constants.HMAC_SHA1_ALGORITHM);
        mac.init(new SecretKeySpec(bArr, mac.getAlgorithm()));
        return MD5Utils.toHexString(mac.doFinal(bArr2));
    }

    public String b(String str) {
        String str2;
        String a10;
        if (this.f٦٨١٢b != null && (str2 = this.f٦٨١٤l) != null) {
            if (str == null) {
                return null;
            }
            try {
                if (this.f٦٨١٣f) {
                    a10 = a(str2.getBytes(), str.getBytes());
                } else {
                    a10 = a(a(), str.getBytes());
                }
                return a10;
            } catch (Exception unused) {
                return "";
            }
        }
        LogUtil.e("There is no appkey,please check it!");
        return null;
    }

    private byte[] a() {
        if (this.f١٩b == null) {
            this.f١٩b = RC4.rc4(new byte[]{66, 37, 42, -119, 118, -104, -30, 4, -95, 15, -26, -12, -75, -102, 71, 23, -3, -120, -1, -57, 42, 99, -16, -101, 103, -74, 93, -114, 112, -26, -24, -24});
        }
        return this.f١٩b;
    }
}
