package com.alibaba.sdk.android.tbrest.utils;

import kotlin.KotlinVersion;
import kotlin.UByte;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ByteUtils {
    public static String bytes2UTF8String(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String bytes2UTF8string(byte[] bArr, int i10, int i11) {
        if (bArr != null && i10 >= 0 && i11 >= 0 && bArr.length >= i10 + i11) {
            byte[] bArr2 = new byte[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                bArr2[i12] = bArr[i10];
                i10++;
            }
            return bytes2UTF8String(bArr2);
        }
        return "";
    }

    public static int bytesToInt(byte[] bArr, int i10, int i11) {
        if (bArr == null || i10 < 0 || i11 < 0 || bArr.length < i10 + i11) {
            return 0;
        }
        byte[] bArr2 = new byte[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            bArr2[i12] = bArr[i10];
            i10++;
        }
        return bytesToInt(bArr2);
    }

    public static byte[] intToBytes(int i10, int i11) {
        if (i11 <= 4 && i11 >= 1) {
            byte[] bArr = new byte[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                bArr[i12] = (byte) ((i10 >> (((i11 - i12) - 1) * 8)) & KotlinVersion.MAX_COMPONENT_VALUE);
            }
            return bArr;
        }
        return null;
    }

    public static byte[] intToBytes1(int i10) {
        return new byte[]{(byte) (i10 & KotlinVersion.MAX_COMPONENT_VALUE)};
    }

    public static byte[] intToBytes2(int i10) {
        return new byte[]{(byte) ((i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) (i10 & KotlinVersion.MAX_COMPONENT_VALUE)};
    }

    public static byte[] intToBytes3(int i10) {
        return new byte[]{(byte) ((i10 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) ((i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) (i10 & KotlinVersion.MAX_COMPONENT_VALUE)};
    }

    public static byte[] intToBytes4(int i10) {
        return new byte[]{(byte) ((i10 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) ((i10 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) ((i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) (i10 & KotlinVersion.MAX_COMPONENT_VALUE)};
    }

    public static byte[] subBytes(byte[] bArr, int i10, int i11) {
        int i12;
        if (bArr != null && i10 >= 0 && i11 >= 0 && bArr.length >= (i12 = i10 + i11)) {
            byte[] bArr2 = new byte[i11];
            for (int i13 = i10; i13 < i12; i13++) {
                bArr2[i13 - i10] = bArr[i13];
            }
            return bArr2;
        }
        return null;
    }

    public static int bytesToInt(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            i10 |= (bArr[i11] & UByte.MAX_VALUE) << (((bArr.length - i11) - 1) * 8);
        }
        return i10;
    }
}
