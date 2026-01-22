package com.tencent.qcloud.tuicore.util;

import android.content.Context;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.android.agoo.message.MessageService;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class DateTimeUtil {
    private static final long day = 86400000;
    private static final long hour = 3600000;
    private static final long minute = 60000;
    private static final long month = 2678400000L;
    private static final long week = 604800000;
    private static final long year = 32140800000L;

    public static String formatSeconds(long j) {
        Context appContext = TUIConfig.getAppContext();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j);
        int i = R.string.date_second_short;
        sb2.append(appContext.getString(i));
        String sb3 = sb2.toString();
        if (j > 60) {
            long j2 = j % 60;
            long j3 = j / 60;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(j3);
            int i2 = R.string.date_minute_short;
            sb4.append(appContext.getString(i2));
            sb4.append(j2);
            sb4.append(appContext.getString(i));
            String sb5 = sb4.toString();
            if (j3 > 60) {
                long j4 = j3 % 60;
                long j5 = j3 / 60;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(j5);
                int i3 = R.string.date_hour_short;
                sb6.append(appContext.getString(i3));
                sb6.append(j4);
                sb6.append(appContext.getString(i2));
                sb6.append(j2);
                sb6.append(appContext.getString(i));
                String sb7 = sb6.toString();
                long j6 = j5 % 24;
                if (j6 == 0) {
                    return (j5 / 24) + appContext.getString(R.string.date_day_short);
                }
                if (j5 > 24) {
                    return (j5 / 24) + appContext.getString(R.string.date_day_short) + j6 + appContext.getString(i3) + j4 + appContext.getString(i2) + j2 + appContext.getString(i);
                }
                return sb7;
            }
            return sb5;
        }
        return sb3;
    }

    public static String formatSecondsTo00(int i) {
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        int i2 = i % 60;
        int i3 = i / 60;
        if (i3 > 0) {
            int i4 = i3 % 60;
            int i5 = i3 / 60;
            if (i5 > 0) {
                StringBuilder sb6 = new StringBuilder();
                if (i5 >= 10) {
                    sb3 = new StringBuilder();
                    sb3.append(i5);
                    sb3.append("");
                } else {
                    sb3 = new StringBuilder();
                    sb3.append(MessageService.MSG_DB_READY_REPORT);
                    sb3.append(i5);
                }
                sb6.append(sb3.toString());
                sb6.append(":");
                if (i4 >= 10) {
                    sb4 = new StringBuilder();
                    sb4.append(i4);
                    sb4.append("");
                } else {
                    sb4 = new StringBuilder();
                    sb4.append(MessageService.MSG_DB_READY_REPORT);
                    sb4.append(i4);
                }
                sb6.append(sb4.toString());
                sb6.append(":");
                if (i2 >= 10) {
                    sb5 = new StringBuilder();
                    sb5.append(i2);
                    sb5.append("");
                } else {
                    sb5 = new StringBuilder();
                    sb5.append(MessageService.MSG_DB_READY_REPORT);
                    sb5.append(i2);
                }
                sb6.append(sb5.toString());
                return sb6.toString();
            }
            StringBuilder sb7 = new StringBuilder();
            if (i4 >= 10) {
                sb2 = new StringBuilder();
                sb2.append(i4);
                sb2.append("");
            } else {
                sb2 = new StringBuilder();
                sb2.append(MessageService.MSG_DB_READY_REPORT);
                sb2.append(i4);
            }
            sb7.append(sb2.toString());
            sb7.append(":");
            if (i2 >= 10) {
                str2 = i2 + "";
            } else {
                str2 = MessageService.MSG_DB_READY_REPORT + i2;
            }
            sb7.append(str2);
            return sb7.toString();
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("00:");
        if (i2 >= 10) {
            str = i2 + "";
        } else {
            str = MessageService.MSG_DB_READY_REPORT + i2;
        }
        sb8.append(str);
        return sb8.toString();
    }

    public static String getHMTimeString(Date date) {
        Locale locale;
        if (date == null) {
            return "";
        }
        Context appContext = TUIConfig.getAppContext();
        if (appContext == null) {
            locale = Locale.getDefault();
        } else {
            locale = TUIThemeManager.getInstance().getLocale(appContext);
        }
        return String.format(locale, "%tR", date);
    }

    public static long getStringToDate(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        Date date = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static String getTimeFormatText(Date date) {
        Locale locale;
        if (date == null) {
            return "";
        }
        Context appContext = TUIConfig.getAppContext();
        if (appContext == null) {
            locale = Locale.getDefault();
        } else {
            locale = TUIThemeManager.getInstance().getLocale(appContext);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(7, 1);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        long timeInMillis2 = calendar2.getTimeInMillis();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(6, 1);
        calendar3.set(11, 0);
        calendar3.set(12, 0);
        calendar3.set(13, 0);
        calendar3.set(14, 0);
        long timeInMillis3 = calendar3.getTimeInMillis();
        long time = date.getTime();
        if (time < timeInMillis3) {
            return String.format(locale, "%tD", date);
        }
        if (time < timeInMillis2) {
            return String.format(locale, "%1$tm/%1$td", date);
        }
        if (time < timeInMillis) {
            return String.format(locale, "%tA", date);
        }
        return String.format(locale, "%tR", date);
    }
}
