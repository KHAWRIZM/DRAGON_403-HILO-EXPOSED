package com.alibaba.sdk.android.emas;

import android.util.Base64;
import android.util.Log;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with other field name */
    private static final byte[] f٧a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    public static boolean f٦٣٩٨a = false;

    private static SecretKeySpec a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        messageDigest.update(bytes, 0, bytes.length);
        return new SecretKeySpec(messageDigest.digest(), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM);
    }

    public static String b(String str, String str2) throws GeneralSecurityException {
        try {
            return new String(b(a(str), f٧a, Base64.decode(str2, 2)), "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            if (!f٦٣٩٨a) {
                return null;
            }
            Log.e("AESCrypt", "UnsupportedEncodingException ", e10);
            return null;
        }
    }

    public static String a(String str, String str2) throws GeneralSecurityException {
        try {
            return Base64.encodeToString(a(a(str), f٧a, str2.getBytes("UTF-8")), 2);
        } catch (UnsupportedEncodingException e10) {
            if (!f٦٣٩٨a) {
                return null;
            }
            Log.e("AESCrypt", "UnsupportedEncodingException ", e10);
            return null;
        }
    }

    public static byte[] b(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr2);
    }

    public static byte[] a(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
        return cipher.doFinal(bArr2);
    }
}
