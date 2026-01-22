package com.qiahao.base_common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static String f١٢٥٧٤a = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: b, reason: collision with root package name */
    public static String f١٢٥٧٥b = "yyyy-MM-dd";

    /* renamed from: c, reason: collision with root package name */
    public static String f١٢٥٧٦c = "HH:mm";

    /* renamed from: d, reason: collision with root package name */
    public static String f١٢٥٧٧d = "yyyy-M-d HH:mm";

    /* renamed from: e, reason: collision with root package name */
    public static String f١٢٥٧٨e = "yyyy-MM-dd HH:mm";

    /* renamed from: f, reason: collision with root package name */
    public static String f١٢٥٧٩f = "MM-dd HH:mm";

    /* renamed from: g, reason: collision with root package name */
    public static String f١٢٥٨٠g = "yyyy_MM_dd";

    /* renamed from: h, reason: collision with root package name */
    public static String f١٢٥٨١h = "yyyyMMdd";

    /* renamed from: i, reason: collision with root package name */
    public static String f١٢٥٨٢i = "yyyy/MM/dd HH:mm";

    public static String a(Date date, String str) {
        return new SimpleDateFormat(str, Locale.US).format(date);
    }

    public static Long b() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public static String c(int i10) {
        if (i10 <= 0) {
            return "00:00";
        }
        if (i10 < 60) {
            return String.format(Locale.ENGLISH, "00:%02d", Integer.valueOf(i10 % 60));
        }
        if (i10 < 3600) {
            return String.format(Locale.ENGLISH, "%02d:%02d", Integer.valueOf(i10 / 60), Integer.valueOf(i10 % 60));
        }
        return String.format(Locale.ENGLISH, "%02d:%02d:%02d", Integer.valueOf(i10 / 3600), Integer.valueOf((i10 % 3600) / 60), Integer.valueOf(i10 % 60));
    }

    public static double d(Long l10, Long l11) {
        return (l11.longValue() - l10.longValue()) / 8.64E7d;
    }

    public static long e() {
        return new Date().getTime();
    }

    public static String f(long j10, String str) {
        Date date = new Date();
        date.setTime(j10);
        return new SimpleDateFormat(str).format(date);
    }

    public static boolean g(long j10, long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j11);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            return true;
        }
        return false;
    }

    public static String h(long j10, String str) {
        return a(new Date(j10), str);
    }
}
