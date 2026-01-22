package p9;

import android.text.TextUtils;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f١٦٩٦٩a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f١٦٩٧٠b = "";

    public static String a(String str) {
        boolean z10;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        boolean z11 = false;
        try {
            str2 = s9.a.a("isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=", str);
            d.a("sdkDecrypt aesDecrypt aes data " + str2);
            z10 = true;
        } catch (Exception e10) {
            d.a("sdkDecrypt AES excepiton " + e10.toString());
            z10 = false;
        }
        if (!TextUtils.isEmpty(str2)) {
            z11 = z10;
        }
        if (!z11) {
            try {
                str2 = c.a(str, c());
                f١٦٩٦٩a = "DES";
                e.b().f(f١٦٩٦٩a);
                d.a("sdkDecrypt aesDecrypt des data " + str2);
                return str2;
            } catch (Exception e11) {
                d.a("sdkDecrypt DES excepiton " + e11.toString());
                return str2;
            }
        }
        return str2;
    }

    public static String b(String str) {
        boolean z10;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        boolean z11 = false;
        try {
            str2 = c.a(str, c());
            d.a("sdkDecrypt desDecrypt des data " + str2);
            z10 = true;
        } catch (Exception e10) {
            d.a("sdkDecrypt DES excepiton " + e10.toString());
            z10 = false;
        }
        if (!TextUtils.isEmpty(str2)) {
            z11 = z10;
        }
        if (!z11) {
            try {
                str2 = s9.a.a("isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=", str);
                f١٦٩٦٩a = JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM;
                e.b().f(f١٦٩٦٩a);
                d.a("sdkDecrypt desDecrypt aes data " + str2);
                return str2;
            } catch (Exception e11) {
                d.a("sdkDecrypt AES excepiton " + e11.toString());
                return str2;
            }
        }
        return str2;
    }

    private static String c() {
        if (TextUtils.isEmpty(f١٦٩٧٠b)) {
            f١٦٩٧٠b = new String(j9.a.l("Y29tLm5lYXJtZS5tY3M="));
        }
        byte[] f10 = f(d(f١٦٩٧٠b));
        if (f10 != null) {
            return new String(f10, Charset.forName("UTF-8"));
        }
        return "";
    }

    public static byte[] d(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static String e(String str) {
        d.a("sdkDecrypt start data " + str);
        if (TextUtils.isEmpty(f١٦٩٦٩a)) {
            f١٦٩٦٩a = e.b().a();
        }
        if ("DES".equals(f١٦٩٦٩a)) {
            d.a("sdkDecrypt start DES");
            return b(str);
        }
        d.a("sdkDecrypt start AES");
        return a(str);
    }

    public static byte[] f(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i10 = 0; i10 < length; i10 += 2) {
            byte b10 = bArr[i10];
            int i11 = i10 + 1;
            bArr[i10] = bArr[i11];
            bArr[i11] = b10;
        }
        return bArr;
    }
}
