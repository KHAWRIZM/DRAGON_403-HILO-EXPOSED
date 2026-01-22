package com.alibaba.sdk.android.tool;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StringUtils {
    public static String convertMaoToString(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                if (z10) {
                    sb.append(key + "=" + value);
                    z10 = false;
                } else {
                    sb.append(",");
                    sb.append(key + "=" + value);
                }
            }
        }
        return sb.toString();
    }

    public static String convertObjectToString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            return "" + ((Integer) obj);
        }
        if (obj instanceof Long) {
            return "" + ((Long) obj);
        }
        if (obj instanceof Double) {
            return "" + ((Double) obj);
        }
        if (obj instanceof Float) {
            return "" + ((Float) obj);
        }
        if (obj instanceof Short) {
            return "" + ((Short) obj);
        }
        if (!(obj instanceof Byte)) {
            return obj instanceof Boolean ? ((Boolean) obj).toString() : obj instanceof Character ? ((Character) obj).toString() : obj.toString();
        }
        return "" + ((Byte) obj);
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (charSequence != null && (length = charSequence.length()) != 0) {
            for (int i10 = 0; i10 < length; i10++) {
                if (!Character.isWhitespace(charSequence.charAt(i10))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() <= 0;
    }
}
