package com.ta.a.c;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class b {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String a(String str, String str2) {
        try {
            byte[] a2 = a(str.getBytes(), str2.getBytes());
            if (a2 != null) {
                return a(a2);
            }
            return "0000000000000000";
        } catch (Exception e) {
            f.m١٢٧a("", e);
            return "0000000000000000";
        }
    }

    public static String d(String str) {
        return a(f(), str);
    }

    private static String f() {
        byte[] bytes = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn".getBytes();
        for (byte b = 0; b < 32; b = (byte) (b + 1)) {
            try {
                bytes[b] = (byte) (bytes[b] + b);
            } catch (Exception unused) {
                return null;
            }
        }
        return a(bytes);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static byte[] m١٢٦a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            f.a("", e, new Object[0]);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            char[] cArr = a;
            sb2.append(cArr[(bArr[i] & 240) >>> 4]);
            sb2.append(cArr[bArr[i] & 15]);
        }
        return sb2.toString();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        byte[] bArr3 = new byte[64];
        byte[] bArr4 = new byte[64];
        for (int i = 0; i < 64; i++) {
            bArr3[i] = 54;
            bArr4[i] = 92;
        }
        byte[] bArr5 = new byte[64];
        if (bArr.length > 64) {
            bArr = m١٢٦a(bArr);
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr5[i2] = bArr[i2];
        }
        if (bArr.length < 64) {
            for (int length = bArr.length; length < 64; length++) {
                bArr5[length] = 0;
            }
        }
        byte[] bArr6 = new byte[64];
        for (int i3 = 0; i3 < 64; i3++) {
            bArr6[i3] = (byte) (bArr5[i3] ^ bArr3[i3]);
        }
        byte[] bArr7 = new byte[bArr2.length + 64];
        for (int i4 = 0; i4 < 64; i4++) {
            bArr7[i4] = bArr6[i4];
        }
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            bArr7[i5 + 64] = bArr2[i5];
        }
        byte[] bArr8 = m١٢٦a(bArr7);
        byte[] bArr9 = new byte[64];
        for (int i6 = 0; i6 < 64; i6++) {
            bArr9[i6] = (byte) (bArr5[i6] ^ bArr4[i6]);
        }
        byte[] bArr10 = new byte[bArr8.length + 64];
        for (int i7 = 0; i7 < 64; i7++) {
            bArr10[i7] = bArr9[i7];
        }
        for (int i8 = 0; i8 < bArr8.length; i8++) {
            bArr10[i8 + 64] = bArr8[i8];
        }
        return m١٢٦a(bArr10);
    }
}
