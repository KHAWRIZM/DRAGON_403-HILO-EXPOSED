package com.oudi.utils;

import android.graphics.Color;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ColorUtils {
    private ColorUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int getColor(int i10) {
        return androidx.core.content.a.getColor(AppUtils.getApp(), i10);
    }

    public static int getRandomColor() {
        return getRandomColor(true);
    }

    public static String int2ArgbString(int i10) {
        String hexString = Integer.toHexString(i10);
        while (hexString.length() < 6) {
            hexString = "0".concat(hexString);
        }
        while (hexString.length() < 8) {
            hexString = "f".concat(hexString);
        }
        return "#".concat(hexString);
    }

    public static String int2RgbString(int i10) {
        String hexString = Integer.toHexString(i10 & 16777215);
        while (hexString.length() < 6) {
            hexString = "0".concat(hexString);
        }
        return "#".concat(hexString);
    }

    public static int setAlphaComponent(int i10, float f10) {
        return (i10 & 16777215) | (((int) ((f10 * 255.0f) + 0.5f)) << 24);
    }

    public static int setBlueComponent(int i10, float f10) {
        return (i10 & (-256)) | ((int) ((f10 * 255.0f) + 0.5f));
    }

    public static int setGreenComponent(int i10, float f10) {
        return (i10 & (-65281)) | (((int) ((f10 * 255.0f) + 0.5f)) << 8);
    }

    public static int setRedComponent(int i10, float f10) {
        return (i10 & (-16711681)) | (((int) ((f10 * 255.0f) + 0.5f)) << 16);
    }

    public static int string2Int(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return Color.parseColor("#ffffff");
        }
    }

    public static int getRandomColor(boolean z10) {
        return (z10 ? ((int) (Math.random() * 256.0d)) << 24 : -16777216) | ((int) (Math.random() * 1.6777216E7d));
    }

    public static int setAlphaComponent(int i10, int i11) {
        return (i10 & 16777215) | (i11 << 24);
    }

    public static int setBlueComponent(int i10, int i11) {
        return (i10 & (-256)) | i11;
    }

    public static int setGreenComponent(int i10, int i11) {
        return (i10 & (-65281)) | (i11 << 8);
    }

    public static int setRedComponent(int i10, int i11) {
        return (i10 & (-16711681)) | (i11 << 16);
    }
}
