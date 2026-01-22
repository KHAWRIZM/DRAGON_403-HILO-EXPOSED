package com.alibaba.sdk.android.emas;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.tbrest.utils.Base64;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f٦٤١٤a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static byte[] a(String str, String str2) throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                byte[] a10 = b.a().a(str2.getBytes());
                if (a10 != null) {
                    return a10;
                }
            } catch (Exception unused) {
            }
        }
        return a.a(str, str2).getBytes();
    }

    public static String aesDecrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return a(Base64.decode(str2), str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String aesEncrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return Base64.encodeBase64String(a(str, str2));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String a(byte[] bArr, String str) throws Exception {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                byte[] b10 = b.a().b(bArr);
                if (b10 != null) {
                    return new String(b10);
                }
            } catch (Exception unused) {
            }
        }
        return a.b(str, new String(bArr));
    }
}
