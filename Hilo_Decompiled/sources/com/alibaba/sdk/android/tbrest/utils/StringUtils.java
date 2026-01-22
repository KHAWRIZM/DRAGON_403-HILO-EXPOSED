package com.alibaba.sdk.android.tbrest.utils;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StringUtils {
    public static String convertMapToString(Map<String, String> map) {
        if (map != null) {
            StringBuffer stringBuffer = new StringBuffer();
            boolean z10 = true;
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (str2 != null && str != null) {
                    if (z10) {
                        if (!"--invalid--".equals(str2)) {
                            stringBuffer.append(str + "=" + str2);
                        } else {
                            stringBuffer.append(str);
                        }
                        z10 = false;
                    } else if (!"--invalid--".equals(str2)) {
                        stringBuffer.append(",");
                        stringBuffer.append(str + "=" + str2);
                    } else {
                        stringBuffer.append(",");
                        stringBuffer.append(str);
                    }
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static String convertObjectToString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return ((String) obj).toString();
        }
        if (obj instanceof Integer) {
            return "" + ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return "" + ((Long) obj).longValue();
        }
        if (obj instanceof Double) {
            return "" + ((Double) obj).doubleValue();
        }
        if (obj instanceof Float) {
            return "" + ((Float) obj).floatValue();
        }
        if (obj instanceof Short) {
            return "" + ((int) ((Short) obj).shortValue());
        }
        if (obj instanceof Byte) {
            return "" + ((int) ((Byte) obj).byteValue());
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        if (obj instanceof Character) {
            return ((Character) obj).toString();
        }
        return obj.toString();
    }

    public static String defaultString(String str, String str2) {
        if (isBlank(str)) {
            return str2;
        }
        return str;
    }

    public static int hashCode(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i10 = 0;
        for (char c10 : str.toCharArray()) {
            i10 = (i10 * 31) + c10;
        }
        return i10;
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
        if (str != null && str.length() > 0) {
            return false;
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }
}
