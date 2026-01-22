package com.amazonaws.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StringUtils {
    private static final String DEFAULT_ENCODING = "UTF-8";
    public static final Charset UTF8 = Charset.forName("UTF-8");

    public static String fromBigDecimal(BigDecimal bigDecimal) {
        return bigDecimal.toString();
    }

    public static String fromBigInteger(BigInteger bigInteger) {
        return bigInteger.toString();
    }

    public static String fromBoolean(Boolean bool) {
        return Boolean.toString(bool.booleanValue());
    }

    public static String fromByte(Byte b10) {
        return Byte.toString(b10.byteValue());
    }

    public static String fromByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return Base64.encodeAsString(byteBuffer.array());
        }
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        return Base64.encodeAsString(bArr);
    }

    public static String fromDate(Date date) {
        return DateUtils.formatISO8601Date(date);
    }

    public static String fromDouble(Double d10) {
        return Double.toString(d10.doubleValue());
    }

    public static String fromFloat(Float f10) {
        return Float.toString(f10.floatValue());
    }

    public static String fromInteger(Integer num) {
        return Integer.toString(num.intValue());
    }

    public static String fromLong(Long l10) {
        return Long.toString(l10.longValue());
    }

    public static String fromString(String str) {
        return str;
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

    public static String join(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < strArr.length; i10++) {
            sb.append(strArr[i10]);
            if (i10 < strArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }
        return str.toLowerCase(Locale.ENGLISH);
    }

    public static String replace(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        stringBuffer.append(str);
        int indexOf = stringBuffer.indexOf(str2);
        while (indexOf != -1) {
            stringBuffer = stringBuffer.replace(indexOf, str2.length() + indexOf, str3);
            indexOf = stringBuffer.indexOf(str2);
        }
        return stringBuffer.toString();
    }

    public static BigDecimal toBigDecimal(String str) {
        return new BigDecimal(str);
    }

    public static BigInteger toBigInteger(String str) {
        return new BigInteger(str);
    }

    public static Boolean toBoolean(StringBuilder sb) {
        return Boolean.valueOf(Boolean.getBoolean(sb.toString()));
    }

    public static Integer toInteger(StringBuilder sb) {
        return Integer.valueOf(Integer.parseInt(sb.toString()));
    }

    public static String toString(StringBuilder sb) {
        return sb.toString();
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }
        return str.toUpperCase(Locale.ENGLISH);
    }
}
