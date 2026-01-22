package e;

import com.amazonaws.services.s3.internal.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import u.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {
    public static String a(String str, String str2) {
        byte[] bArr;
        try {
            Mac mac = Mac.getInstance(Constants.HMAC_SHA1_ALGORITHM);
            Charset charset = StandardCharsets.UTF_8;
            mac.init(new SecretKeySpec(str.getBytes(charset), Constants.HMAC_SHA1_ALGORITHM));
            bArr = mac.doFinal(str2.getBytes(charset));
        } catch (Exception e10) {
            e10.printStackTrace();
            bArr = null;
        }
        return j.c(bArr, false);
    }
}
