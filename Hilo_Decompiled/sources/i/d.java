package i;

import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f١٤٥٩٠a = new HashMap();

    public static String a(String str, String str2) {
        byte[] bArr;
        if (str2 != null && !"".equals(str2)) {
            b bVar = (b) f١٤٥٩٠a.get(str);
            byte[] bArr2 = null;
            SecretKeySpec secretKeySpec = null;
            bArr2 = null;
            if (bVar == null) {
                bArr = null;
            } else {
                bArr = bVar.f١٤٥٨٨a;
            }
            if (bArr == null || bArr.length == 0) {
                String string = h.a.a().f١٤٤٨٢a.getString("key_aes_key_prefix_" + str, null);
                if (string != null && !"".equals(string)) {
                    byte[] b10 = a.b(string);
                    for (int i10 = 0; i10 < b10.length; i10++) {
                        b10[i10] = (byte) (b10[i10] ^ 2);
                    }
                    bArr = b10;
                } else {
                    bArr = null;
                }
                if (bArr != null && bArr.length > 0) {
                    b bVar2 = new b();
                    bVar2.f١٤٥٨٨a = bArr;
                    f١٤٥٩٠a.put(str, bVar2);
                }
            }
            if (bArr != null && bArr.length != 0) {
                byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
                if (bytes != null && bytes.length != 0) {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(c.f١٤٥٨٩a);
                    Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
                    if (bArr.length != 0) {
                        secretKeySpec = new SecretKeySpec(bArr, JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
                    }
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    bArr2 = cipher.doFinal(bytes);
                }
                return a.a(bArr2);
            }
            throw new e();
        }
        return str2;
    }
}
