package i;

import android.util.Base64;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {
    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return Base64.encodeToString(bArr, 2);
        }
        return null;
    }

    public static byte[] b(String str) {
        if (str != null && str.length() != 0) {
            return Base64.decode(str, 2);
        }
        return null;
    }
}
