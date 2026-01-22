package s9;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {
    public static String a(String str, String str2) {
        String[] split = str2.split("%IV1%");
        byte[] l10 = b.l(split[0]);
        byte[] l11 = b.l(split[1]);
        SecretKeySpec secretKeySpec = new SecretKeySpec(b.l(str), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(l11));
        return new String(cipher.doFinal(l10));
    }
}
