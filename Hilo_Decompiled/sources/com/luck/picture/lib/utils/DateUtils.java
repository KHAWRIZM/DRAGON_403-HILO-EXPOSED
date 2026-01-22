package com.luck.picture.lib.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import com.luck.picture.lib.R;
import com.oudi.utils.date.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DateUtils {

    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat SF = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM");

    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat SDF_YEAR = new SimpleDateFormat(DateFormat.YMD_HMS);

    public static String cdTime(long j10, long j11) {
        long j12 = j11 - j10;
        if (j12 > 1000) {
            return (j12 / 1000) + "秒";
        }
        return j12 + "毫秒";
    }

    public static int dateDiffer(long j10) {
        try {
            return (int) Math.abs(getCurrentTimeMillis() - j10);
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static String formatDurationTime(long j10) {
        String str;
        if (j10 < 0) {
            str = "-";
        } else {
            str = "";
        }
        long abs = Math.abs(j10) / 1000;
        long j11 = abs % 60;
        long j12 = (abs / 60) % 60;
        long j13 = abs / 3600;
        if (j13 > 0) {
            return String.format(Locale.getDefault(), "%s%d:%02d:%02d", str, Long.valueOf(j13), Long.valueOf(j12), Long.valueOf(j11));
        }
        return String.format(Locale.getDefault(), "%s%02d:%02d", str, Long.valueOf(j12), Long.valueOf(j11));
    }

    public static String getCreateFileName(String str) {
        return str + SF.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static long getCurrentTimeMillis() {
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        if (valueOf.length() > 10) {
            valueOf = valueOf.substring(0, 10);
        }
        return ValueOf.toLong(valueOf);
    }

    public static String getDataFormat(Context context, long j10) {
        if (String.valueOf(j10).length() <= 10) {
            j10 *= 1000;
        }
        if (isThisWeek(j10)) {
            return context.getString(R.string.ps_current_week);
        }
        if (isThisMonth(j10)) {
            return context.getString(R.string.ps_current_month);
        }
        return SDF.format(Long.valueOf(j10));
    }

    public static String getYearDataFormat(long j10) {
        if (String.valueOf(j10).length() <= 10) {
            j10 *= 1000;
        }
        return SDF_YEAR.format(Long.valueOf(j10));
    }

    public static boolean isThisMonth(long j10) {
        Date date = new Date(j10);
        SimpleDateFormat simpleDateFormat = SDF;
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date()));
    }

    private static boolean isThisWeek(long j10) {
        Calendar calendar = Calendar.getInstance();
        int i10 = calendar.get(3);
        calendar.setTime(new Date(j10));
        if (calendar.get(3) == i10) {
            return true;
        }
        return false;
    }

    public static long millisecondToSecond(long j10) {
        return (j10 / 1000) * 1000;
    }

    public static String getCreateFileName() {
        return SF.format(Long.valueOf(System.currentTimeMillis()));
    }
}
