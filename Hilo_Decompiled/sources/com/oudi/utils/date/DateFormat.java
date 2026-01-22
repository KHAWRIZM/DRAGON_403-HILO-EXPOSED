package com.oudi.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0005J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"J\u001a\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R0\u0010\u0019\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c0\u001bj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c`\u001d0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/oudi/utils/date/DateFormat;", "", "<init>", "()V", "YEAR", "", "MONTH", "DAY", "HOUR", "MINUTE", "SECONDES", "MILLISECOND", "YMD", "HM", "hm_12", "HMS", "hms_12", "ms", "YMD_HM", "YMD_HMS", "YMD_hms_12", "YMD_HMS_SS", "YMD_hms_SS_12", "YMD_HMS_SSS", "YMD_hms_SSS_12", "format", "Ljava/lang/ThreadLocal;", "Ljava/util/HashMap;", "Ljava/text/SimpleDateFormat;", "Lkotlin/collections/HashMap;", "ofPattern", "pattern", "ofPatternNotNull", "date", "Ljava/util/Date;", "parse", "source", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DateFormat {
    public static final String DAY = "dd";
    public static final String HM = "HH:mm";
    public static final String HMS = "HH:mm:ss";
    public static final String HOUR = "HH";
    public static final String MILLISECOND = "SSS";
    public static final String MINUTE = "mm";
    public static final String MONTH = "MM";
    public static final String SECONDES = "ss";
    public static final String YEAR = "yyyy";
    public static final String YMD = "yyyy-MM-dd";
    public static final String YMD_HM = "yyyy-MM-dd HH:mm";
    public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD_HMS_SS = "yyyy-MM-dd HH:mm:ss|SS";
    public static final String YMD_HMS_SSS = "yyyy-MM-dd HH:mm:ss|SSS";
    public static final String YMD_hms_12 = "yyyy-MM-dd hh:mm:ss";
    public static final String YMD_hms_SSS_12 = "yyyy-MM-dd hh:mm:ss|SSS";
    public static final String YMD_hms_SS_12 = "yyyy-MM-dd HH:mm:ss|SS";
    public static final String hm_12 = "hh:mm";
    public static final String hms_12 = "hh:mm:ss";
    public static final String ms = "mm:ss";
    public static final DateFormat INSTANCE = new DateFormat();
    private static final ThreadLocal<HashMap<String, SimpleDateFormat>> format = new ThreadLocal<>();

    private DateFormat() {
    }

    public final String format(String pattern, Date date) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (date == null) {
            return null;
        }
        try {
            return ofPatternNotNull(pattern).format(date);
        } catch (Exception unused) {
            return null;
        }
    }

    public final SimpleDateFormat ofPattern(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        try {
            return ofPatternNotNull(pattern);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final SimpleDateFormat ofPatternNotNull(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        ThreadLocal<HashMap<String, SimpleDateFormat>> threadLocal = format;
        HashMap<String, SimpleDateFormat> hashMap = threadLocal.get();
        if (hashMap == null) {
            hashMap = new HashMap<>();
            threadLocal.set(hashMap);
        }
        SimpleDateFormat simpleDateFormat = hashMap.get(pattern);
        if (simpleDateFormat == null) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern);
            hashMap.put(pattern, simpleDateFormat2);
            return simpleDateFormat2;
        }
        return simpleDateFormat;
    }

    public final Date parse(String pattern, String source) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (source == null) {
            return null;
        }
        try {
            return ofPatternNotNull(pattern).parse(source);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
