package com.qiahao.base_common.utils;

import android.util.Base64;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class g {
    private static String a(byte[] bArr) {
        int i10;
        StringBuilder sb = new StringBuilder();
        for (byte b10 : bArr) {
            int i11 = (b10 >>> 4) & 15;
            int i12 = 0;
            while (true) {
                if (i11 >= 0 && i11 <= 9) {
                    i10 = i11 + 48;
                } else {
                    i10 = i11 + 87;
                }
                sb.append((char) i10);
                i11 = b10 & 15;
                int i13 = i12 + 1;
                if (i12 >= 1) {
                    break;
                }
                i12 = i13;
            }
        }
        return sb.toString();
    }

    public static byte[] b(String str) {
        return Base64.decode(str, 0);
    }

    public static String c(String str, String str2, String str3) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str3.getBytes(charset));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(charset), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(b(str)));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String d(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        messageDigest.update(bytes, 0, bytes.length);
        return a(messageDigest.digest());
    }
}
