package com.luck.picture.lib.utils;

import android.content.Context;
import android.graphics.ColorFilter;
import android.text.TextUtils;
import androidx.core.graphics.d;
import androidx.core.graphics.e;
import java.util.regex.Pattern;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class StyleUtils {
    private static final int INVALID = 0;

    public static boolean checkArrayValidity(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            return true;
        }
        return false;
    }

    public static boolean checkSizeValidity(int i10) {
        return i10 > 0;
    }

    public static boolean checkStyleValidity(int i10) {
        return i10 != 0;
    }

    public static boolean checkTextValidity(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static ColorFilter getColorFilter(Context context, int i10) {
        return d.a(androidx.core.content.a.getColor(context, i10), e.SRC_ATOP);
    }

    public static int getFormatCount(String str) {
        int i10 = 0;
        while (Pattern.compile("%[^%]*\\d").matcher(str).find()) {
            i10++;
        }
        return i10;
    }
}
