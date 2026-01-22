package com.oudi.utils.date;

import com.facebook.internal.security.CertificateUtil;
import com.oudi.utils.R;
import com.oudi.utils.ktx.ResourcesKtxKt;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\bQ\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\tJ\u001f\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ0\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\tJ5\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\t¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0017\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010%\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010'\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010(\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010,\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\tJ\u0010\u0010.\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\tJ\u0010\u0010/\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\tJ\u0010\u00100\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\tJ\u0010\u00101\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\tJ\u0010\u00102\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\tJ\u0010\u00103\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\tJ\u0010\u00104\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\tJ\u0017\u00105\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u00106J\u0017\u00107\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u00106J\u0017\u00108\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u00106J\u0017\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u00106J\u0010\u0010:\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010:\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010;\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010;\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010<\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0015\u0010<\u001a\u00020\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010=J\u001a\u0010>\u001a\u00020\u001e2\b\u0010?\u001a\u0004\u0018\u00010\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010>\u001a\u00020\u001e2\b\u0010A\u001a\u0004\u0018\u00010\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010CJ\u001a\u0010D\u001a\u00020\u001e2\b\u0010?\u001a\u0004\u0018\u00010\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010D\u001a\u00020\u001e2\b\u0010A\u001a\u0004\u0018\u00010\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010CJ\u001a\u0010E\u001a\u00020\u001e2\b\u0010?\u001a\u0004\u0018\u00010\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010E\u001a\u00020\u001e2\b\u0010A\u001a\u0004\u0018\u00010\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010CJ\u0010\u0010F\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u0005J\u0010\u0010H\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0015\u0010H\u001a\u00020\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010=J\u0010\u0010I\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0015\u0010I\u001a\u00020\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010=J\u0012\u0010J\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0017\u0010J\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010#J\u0017\u0010K\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u00106J\u0017\u0010K\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010LJ\u0012\u0010M\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0017\u0010M\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010#J\u0018\u0010M\u001a\u0004\u0018\u00010\t2\u0006\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005J\u0017\u0010P\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u00106J\u0017\u0010P\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010LJ!\u0010P\u001a\u0004\u0018\u00010\u00052\b\u0010N\u001a\u0004\u0018\u00010\u00052\b\u0010O\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010QJ\u0017\u0010R\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010SJ!\u0010T\u001a\u0004\u0018\u00010\u00112\b\u0010?\u001a\u0004\u0018\u00010\u000f2\b\u0010@\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010UJ!\u0010T\u001a\u0004\u0018\u00010\u00112\b\u0010A\u001a\u0004\u0018\u00010\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010VJ\u001f\u0010W\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010XJ!\u0010Y\u001a\u0004\u0018\u00010\u00112\b\u0010A\u001a\u0004\u0018\u00010\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010VJ!\u0010Z\u001a\u0004\u0018\u00010\u00112\b\u0010A\u001a\u0004\u0018\u00010\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010VJ!\u0010[\u001a\u0004\u0018\u00010\u00112\b\u0010A\u001a\u0004\u0018\u00010\u00112\b\u0010B\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010VJ\u001a\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010^\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010^\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010_J\u001a\u0010`\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010`\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010_J\u001a\u0010a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010_J\u001a\u0010b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010_J\u001a\u0010c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010]\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010_J\u0017\u0010d\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010SJ\u0017\u0010e\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010SJ\b\u0010f\u001a\u0004\u0018\u00010\tJ\u000e\u0010g\u001a\u00020\u00112\u0006\u0010h\u001a\u00020\u0011J\u0016\u0010i\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\tJ\u000e\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020\u0011J\u0010\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/oudi/utils/date/DateUtils;", "", "<init>", "()V", "DAY", "", "HOUR", "MINUTE", "FORMAT_DATE", "", "FORMAT_DATE_TWO", "FORMAT_MONTH_DATE", "FORMAT_HOUR_MINUTE", "FORMAT_HOUR_MINUTE_MILLISECOND", "getDate", "Ljava/util/Date;", "millis", "", "(Ljava/lang/Long;)Ljava/util/Date;", "getCalendar", "Ljava/util/Calendar;", "date", "(Ljava/lang/Long;)Ljava/util/Calendar;", "getYMDCalendar", "formatCurrentTime", "format", "formatDate", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/String;", "formatDateOfShort", "isAppendTime", "", "yesterday", "yesterday2", "(Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "formatDateOfShort2", "(Ljava/lang/Long;)Ljava/lang/String;", "formatDateOfYear", "formatDateOfMonth", "formatDateOfDay", "formatDateOfHM", "formatDateOfHMS", "formatDateOfYMD", "formatDateOfYMDHM", "formatDateOfYMDHMS", "parseData", "dateStr", "parseDataOfYear", "parseDataOfMonth", "parseDataOfDay", "parseDataOfHM", "parseDataOfHMS", "parseDataOfYMD", "parseDataOfYMDHMS", "getYear", "(Ljava/util/Date;)Ljava/lang/Integer;", "getMonth", "getDay", "getWeek", "isThisYear", "isThisMonth", "isToDay", "(Ljava/lang/Long;)Z", "isSameYear", "dateA", "dateB", "millisA", "millisB", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "isSameMonth", "isSameDay", "isLeapYear", "year", "isAm", "isPm", "getChineseZodiac", "getChineseZodiacIndex", "(Ljava/lang/Long;)Ljava/lang/Integer;", "getZodiac", "month", "day", "getZodiacIndex", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;", "getTimeSpanWithToDay", "(Ljava/util/Date;)Ljava/lang/Long;", "getTimeSpan", "(Ljava/util/Date;Ljava/util/Date;)Ljava/lang/Long;", "(Ljava/lang/Long;Ljava/lang/Long;)Ljava/lang/Long;", "getTimeSpanOfYear", "(Ljava/lang/Long;Ljava/lang/Long;)I", "getTimeSpanOfDay", "getTimeSpanOfHour", "getTimeSpanOfMinute", "addYear", "add", "addMonth", "(ILjava/lang/Long;)Ljava/util/Date;", "addDay", "addHour", "addMinute", "addSecond", "getWeeByDate", "getLastWeeByDate", "getFirstDayOfTheMonth", "getTodayLongTime", "time", "formatZoneTime", "zone", "format123Time", "total", "formatTime", "timeInSeconds", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DateUtils {
    public static final int DAY = 86400000;
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_DATE_TWO = "yyyy/MM/dd";
    public static final String FORMAT_HOUR_MINUTE = "HH:mm";
    public static final String FORMAT_HOUR_MINUTE_MILLISECOND = "HH:mm:ss";
    public static final String FORMAT_MONTH_DATE = "MM-dd";
    public static final int HOUR = 3600000;
    public static final DateUtils INSTANCE = new DateUtils();
    public static final int MINUTE = 60000;

    private DateUtils() {
    }

    public static /* synthetic */ String formatDateOfShort$default(DateUtils dateUtils, Date date, boolean z10, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            str = ResourcesKtxKt.getStringById(dateUtils, R.string.utils_yesterday);
        }
        if ((i10 & 8) != 0) {
            str2 = ResourcesKtxKt.getStringById(dateUtils, R.string.utils_the_day_before_yesterday);
        }
        return dateUtils.formatDateOfShort(date, z10, str, str2);
    }

    @JvmStatic
    public static final String formatTime(int timeInSeconds) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(timeInSeconds / 60), Integer.valueOf(timeInSeconds % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final Date addDay(int add, Date date) {
        Calendar calendar = getCalendar(date);
        if (calendar == null) {
            return null;
        }
        calendar.add(5, add);
        return calendar.getTime();
    }

    public final Date addHour(int add, Date date) {
        Calendar calendar = getCalendar(date);
        if (calendar == null) {
            return null;
        }
        calendar.add(10, add);
        return calendar.getTime();
    }

    public final Date addMinute(int add, Date date) {
        Calendar calendar = getCalendar(date);
        if (calendar == null) {
            return null;
        }
        calendar.add(12, add);
        return calendar.getTime();
    }

    public final Date addMonth(int add, Date date) {
        Calendar calendar = getCalendar(date);
        if (calendar == null) {
            return null;
        }
        calendar.add(2, add);
        return calendar.getTime();
    }

    public final Date addSecond(int add, Date date) {
        Calendar calendar = getCalendar(date);
        if (calendar == null) {
            return null;
        }
        calendar.add(13, add);
        return calendar.getTime();
    }

    public final Date addYear(int add, Date date) {
        Calendar calendar = getCalendar(date);
        if (calendar == null) {
            return null;
        }
        calendar.add(1, add);
        return calendar.getTime();
    }

    public final String format123Time(long total) {
        String valueOf;
        String valueOf2;
        String valueOf3;
        long j10 = (total / 3600) % 24;
        long j11 = 60;
        long j12 = (total / j11) % j11;
        long j13 = total % j11;
        if (j10 < 10) {
            valueOf = "0" + j10;
        } else {
            valueOf = String.valueOf(j10);
        }
        if (j12 < 10) {
            valueOf2 = "0" + j12;
        } else {
            valueOf2 = String.valueOf(j12);
        }
        if (j13 < 10) {
            valueOf3 = "0" + j13;
        } else {
            valueOf3 = String.valueOf(j13);
        }
        return valueOf + CertificateUtil.DELIMITER + valueOf2 + CertificateUtil.DELIMITER + valueOf3;
    }

    public final String formatCurrentTime(String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return DateFormat.INSTANCE.format(format, new Date());
    }

    public final String formatDate(String format, Long millis) {
        Intrinsics.checkNotNullParameter(format, "format");
        Date date = getDate(millis);
        if (date == null) {
            return null;
        }
        return DateFormat.INSTANCE.format(format, date);
    }

    public final String formatDateOfDay(Date date) {
        return DateFormat.INSTANCE.format(DateFormat.DAY, date);
    }

    public final String formatDateOfHM(Date date) {
        return DateFormat.INSTANCE.format("HH:mm", date);
    }

    public final String formatDateOfHMS(Date date) {
        return DateFormat.INSTANCE.format("HH:mm:ss", date);
    }

    public final String formatDateOfMonth(Date date) {
        return DateFormat.INSTANCE.format(DateFormat.MONTH, date);
    }

    public final String formatDateOfShort(Date date, boolean isAppendTime, String yesterday, String yesterday2) {
        String str;
        Intrinsics.checkNotNullParameter(yesterday, "yesterday");
        Intrinsics.checkNotNullParameter(yesterday2, "yesterday2");
        if (date == null) {
            return null;
        }
        Long timeSpanOfDay = getTimeSpanOfDay(Long.valueOf(date.getTime()), Long.valueOf(System.currentTimeMillis()));
        if (timeSpanOfDay != null && timeSpanOfDay.longValue() == 0) {
            String formatDateOfHM = formatDateOfHM(date);
            return formatDateOfHM == null ? "" : formatDateOfHM;
        }
        if (timeSpanOfDay != null && timeSpanOfDay.longValue() == -1) {
            return yesterday;
        }
        if (timeSpanOfDay != null && timeSpanOfDay.longValue() == -2) {
            return yesterday2;
        }
        if (isSameYear(date, new Date())) {
            str = FORMAT_MONTH_DATE;
        } else {
            str = "yyyy-MM-dd";
        }
        if (isAppendTime) {
            return formatDate(str + " HH:mm", date);
        }
        return formatDate(str, date);
    }

    public final String formatDateOfShort2(Date date) {
        if (date == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long timeSpanOfMinute = getTimeSpanOfMinute(Long.valueOf(currentTimeMillis), Long.valueOf(date.getTime()));
        if (timeSpanOfMinute == null) {
            return null;
        }
        long longValue = timeSpanOfMinute.longValue();
        if (longValue < 0) {
            return formatDateOfYMDHMS(date);
        }
        if (longValue < 5) {
            return ResourcesKtxKt.getStringById(this, R.string.utils_just);
        }
        if (longValue < 60) {
            return longValue + ResourcesKtxKt.getStringById(this, R.string.utils_minutes_ago);
        }
        Long timeSpanOfDay = getTimeSpanOfDay(Long.valueOf(currentTimeMillis), Long.valueOf(date.getTime()));
        if (timeSpanOfDay != null && timeSpanOfDay.longValue() == 0) {
            return getTimeSpanOfHour(Long.valueOf(currentTimeMillis), Long.valueOf(date.getTime())) + ResourcesKtxKt.getStringById(this, R.string.utils_hour_ago);
        }
        if (timeSpanOfDay != null && timeSpanOfDay.longValue() == 1) {
            return ResourcesKtxKt.getStringById(this, R.string.utils_yesterday) + " " + formatDateOfHMS(date);
        }
        return formatDateOfYMDHMS(date);
    }

    public final String formatDateOfYMD(Date date) {
        return DateFormat.INSTANCE.format("yyyy-MM-dd", date);
    }

    public final String formatDateOfYMDHM(Date date) {
        return DateFormat.INSTANCE.format(DateFormat.YMD_HM, date);
    }

    public final String formatDateOfYMDHMS(Date date) {
        return DateFormat.INSTANCE.format(DateFormat.YMD_HMS, date);
    }

    public final String formatDateOfYear(Date date) {
        return DateFormat.INSTANCE.format(DateFormat.YEAR, date);
    }

    public final String formatZoneTime(long time, String zone) {
        Intrinsics.checkNotNullParameter(zone, "zone");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(zone));
            String format = simpleDateFormat.format(new Date(time));
            Intrinsics.checkNotNull(format);
            return format;
        } catch (Exception unused) {
            return "";
        }
    }

    public final Calendar getCalendar(Date date) {
        if (date == null) {
            return null;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getChineseZodiac(Date date) {
        return getChineseZodiac(date != null ? Long.valueOf(date.getTime()) : null);
    }

    public final Integer getChineseZodiacIndex(Date date) {
        return getChineseZodiacIndex(date != null ? Long.valueOf(date.getTime()) : null);
    }

    public final Date getDate(Long millis) {
        if (millis == null) {
            return null;
        }
        return new Date(millis.longValue());
    }

    public final Integer getDay(Date date) {
        String format = DateFormat.INSTANCE.format(DateFormat.DAY, date);
        if (format != null) {
            return Integer.valueOf(Integer.parseInt(format));
        }
        return null;
    }

    public final String getFirstDayOfTheMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, 0);
        calendar.set(5, 1);
        return DateFormat.INSTANCE.format("yyyy-MM-dd", calendar.getTime());
    }

    public final Long getLastWeeByDate(Date date) {
        Calendar calendar = getCalendar(date);
        if (calendar == null) {
            return null;
        }
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public final Integer getMonth(Date date) {
        String format = DateFormat.INSTANCE.format(DateFormat.MONTH, date);
        if (format != null) {
            return Integer.valueOf(Integer.parseInt(format));
        }
        return null;
    }

    public final Long getTimeSpan(Date dateA, Date dateB) {
        return getTimeSpan(dateA != null ? Long.valueOf(dateA.getTime()) : null, dateB != null ? Long.valueOf(dateB.getTime()) : null);
    }

    public final Long getTimeSpanOfDay(Long millisA, Long millisB) {
        try {
            Calendar yMDCalendar = getYMDCalendar(millisA);
            Calendar yMDCalendar2 = getYMDCalendar(millisB);
            if (yMDCalendar != null && yMDCalendar2 != null) {
                return Long.valueOf((yMDCalendar.getTimeInMillis() - yMDCalendar2.getTimeInMillis()) / DAY);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final Long getTimeSpanOfHour(Long millisA, Long millisB) {
        Long timeSpan = getTimeSpan(millisA, millisB);
        if (timeSpan != null) {
            return Long.valueOf(timeSpan.longValue() / TimeConstants.INSTANCE.getHOUR());
        }
        return null;
    }

    public final Long getTimeSpanOfMinute(Long millisA, Long millisB) {
        Long timeSpan = getTimeSpan(millisA, millisB);
        if (timeSpan != null) {
            return Long.valueOf(timeSpan.longValue() / TimeConstants.INSTANCE.getMIN());
        }
        return null;
    }

    public final int getTimeSpanOfYear(Long millisA, Long millisB) {
        int i10;
        Calendar calendar = getCalendar(millisA);
        Calendar calendar2 = getCalendar(millisB);
        int i11 = 0;
        if (calendar != null) {
            i10 = calendar.get(1);
        } else {
            i10 = 0;
        }
        if (calendar2 != null) {
            i11 = calendar2.get(1);
        }
        return i10 - i11;
    }

    public final Long getTimeSpanWithToDay(Date date) {
        Long l10;
        Long valueOf = Long.valueOf(new Date().getTime());
        if (date != null) {
            l10 = Long.valueOf(date.getTime());
        } else {
            l10 = null;
        }
        return getTimeSpan(valueOf, l10);
    }

    public final long getTodayLongTime(long time) {
        long j10;
        Long weeByDate = getWeeByDate(new Date(time));
        if (weeByDate != null) {
            j10 = weeByDate.longValue();
        } else {
            j10 = 0;
        }
        if (time <= j10) {
            return 0L;
        }
        return time - j10;
    }

    public final Long getWeeByDate(Date date) {
        Calendar calendar = getCalendar(date);
        if (calendar == null) {
            return null;
        }
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public final Integer getWeek(Date date) {
        int i10;
        Calendar calendar = getCalendar(date);
        if (calendar == null) {
            return null;
        }
        if (calendar.get(7) - 1 < 0) {
            i10 = 0;
        } else {
            i10 = calendar.get(7) - 1;
        }
        return Integer.valueOf(i10);
    }

    public final Calendar getYMDCalendar(Long millis) {
        Calendar calendar;
        if (millis == null || (calendar = getCalendar(millis)) == null) {
            return null;
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public final Integer getYear(Date date) {
        String format = DateFormat.INSTANCE.format(DateFormat.YEAR, date);
        if (format != null) {
            return Integer.valueOf(Integer.parseInt(format));
        }
        return null;
    }

    public final String getZodiac(Date date) {
        return getZodiac(date != null ? Long.valueOf(date.getTime()) : null);
    }

    public final Integer getZodiacIndex(Date date) {
        return getZodiacIndex(date != null ? Long.valueOf(date.getTime()) : null);
    }

    public final boolean isAm(Date date) {
        Calendar calendar = getCalendar(date);
        return calendar != null && calendar.get(9) == 0;
    }

    public final boolean isLeapYear(Date date) {
        Integer year = getYear(date);
        if (year != null) {
            return isLeapYear(year.intValue());
        }
        return false;
    }

    public final boolean isPm(Date date) {
        return !isAm(date);
    }

    public final boolean isSameDay(Date dateA, Date dateB) {
        if (dateA == null || dateB == null) {
            return false;
        }
        return isSameDay(Long.valueOf(dateA.getTime()), Long.valueOf(dateB.getTime()));
    }

    public final boolean isSameMonth(Date dateA, Date dateB) {
        if (dateA == null || dateB == null) {
            return false;
        }
        return isSameMonth(Long.valueOf(dateA.getTime()), Long.valueOf(dateB.getTime()));
    }

    public final boolean isSameYear(Date dateA, Date dateB) {
        if (dateA == null || dateB == null) {
            return false;
        }
        return isSameYear(Long.valueOf(dateA.getTime()), Long.valueOf(dateB.getTime()));
    }

    public final boolean isThisMonth(Date date) {
        if (date == null) {
            return false;
        }
        return isSameMonth(date, new Date());
    }

    public final boolean isThisYear(Date date) {
        if (date == null) {
            return false;
        }
        return isSameDay(date, new Date());
    }

    public final boolean isToDay(Date date) {
        if (date == null) {
            return false;
        }
        return isSameDay(date, new Date());
    }

    public final Date parseData(String format, String dateStr) {
        Intrinsics.checkNotNullParameter(format, "format");
        return DateFormat.INSTANCE.parse(format, dateStr);
    }

    public final Date parseDataOfDay(String dateStr) {
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        return DateFormat.INSTANCE.parse(DateFormat.DAY, dateStr);
    }

    public final Date parseDataOfHM(String dateStr) {
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        return DateFormat.INSTANCE.parse("HH:mm", dateStr);
    }

    public final Date parseDataOfHMS(String dateStr) {
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        return DateFormat.INSTANCE.parse("HH:mm:ss", dateStr);
    }

    public final Date parseDataOfMonth(String dateStr) {
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        return DateFormat.INSTANCE.parse(DateFormat.MONTH, dateStr);
    }

    public final Date parseDataOfYMD(String dateStr) {
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        return DateFormat.INSTANCE.parse("yyyy-MM-dd", dateStr);
    }

    public final Date parseDataOfYMDHMS(String dateStr) {
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        return DateFormat.INSTANCE.parse(DateFormat.YMD_HMS, dateStr);
    }

    public final Date parseDataOfYear(String dateStr) {
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        return DateFormat.INSTANCE.parse(DateFormat.YEAR, dateStr);
    }

    public final String getChineseZodiac(Long millis) {
        Integer chineseZodiacIndex = getChineseZodiacIndex(millis);
        if (chineseZodiacIndex == null) {
            return null;
        }
        return TimeConstants.INSTANCE.getCHINESE_ZODIAC()[chineseZodiacIndex.intValue()];
    }

    public final Integer getChineseZodiacIndex(Long millis) {
        Calendar calendar = getCalendar(millis);
        if (calendar == null) {
            return null;
        }
        return Integer.valueOf(calendar.get(1) % 12);
    }

    public final Long getTimeSpan(Long millisA, Long millisB) {
        if (millisA == null || millisB == null) {
            return null;
        }
        return Long.valueOf(millisA.longValue() - millisB.longValue());
    }

    public final String getZodiac(Long millis) {
        Integer zodiacIndex = getZodiacIndex(millis);
        if (zodiacIndex == null) {
            return null;
        }
        return TimeConstants.INSTANCE.getZODIAC()[zodiacIndex.intValue()];
    }

    public final Integer getZodiacIndex(Long millis) {
        Calendar calendar = getCalendar(millis);
        if (calendar == null) {
            return null;
        }
        return getZodiacIndex(Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    public final boolean isAm(Long millis) {
        Calendar calendar = getCalendar(millis);
        return calendar != null && calendar.get(9) == 0;
    }

    public final boolean isPm(Long millis) {
        return !isAm(millis);
    }

    public final boolean isSameDay(Long millisA, Long millisB) {
        Calendar calendar = getCalendar(millisA);
        Calendar calendar2 = getCalendar(millisB);
        return calendar != null && calendar2 != null && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public final boolean isSameMonth(Long millisA, Long millisB) {
        Calendar calendar = getCalendar(millisA);
        Calendar calendar2 = getCalendar(millisB);
        return calendar != null && calendar2 != null && calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2);
    }

    public final boolean isSameYear(Long millisA, Long millisB) {
        Calendar calendar = getCalendar(millisA);
        Calendar calendar2 = getCalendar(millisB);
        return (calendar == null || calendar2 == null || calendar.get(1) != calendar2.get(1)) ? false : true;
    }

    public final boolean isThisMonth(long millis) {
        return isSameMonth(Long.valueOf(millis), Long.valueOf(new Date().getTime()));
    }

    public final boolean isThisYear(long millis) {
        return isSameDay(Long.valueOf(millis), Long.valueOf(new Date().getTime()));
    }

    public final boolean isToDay(Long millis) {
        return isSameDay(millis, Long.valueOf(new Date().getTime()));
    }

    public final String formatDate(String format, Date date) {
        Intrinsics.checkNotNullParameter(format, "format");
        return DateFormat.INSTANCE.format(format, date);
    }

    public final Calendar getCalendar(Long millis) {
        if (millis == null) {
            return null;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(millis.longValue());
            return calendar;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static /* synthetic */ String formatDateOfShort$default(DateUtils dateUtils, Long l10, boolean z10, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            str = ResourcesKtxKt.getStringById(dateUtils, R.string.utils_yesterday);
        }
        if ((i10 & 8) != 0) {
            str2 = ResourcesKtxKt.getStringById(dateUtils, R.string.utils_the_day_before_yesterday);
        }
        return dateUtils.formatDateOfShort(l10, z10, str, str2);
    }

    public final Date addDay(int add, Long millis) {
        Calendar calendar = getCalendar(millis);
        if (calendar == null) {
            return null;
        }
        calendar.add(5, add);
        return calendar.getTime();
    }

    public final Date addHour(int add, Long millis) {
        Calendar calendar = getCalendar(millis);
        if (calendar == null) {
            return null;
        }
        calendar.add(10, add);
        return calendar.getTime();
    }

    public final Date addMinute(int add, Long millis) {
        Calendar calendar = getCalendar(millis);
        if (calendar == null) {
            return null;
        }
        calendar.add(12, add);
        return calendar.getTime();
    }

    public final Date addMonth(int add, Long millis) {
        Calendar calendar = getCalendar(millis);
        if (calendar == null) {
            return null;
        }
        calendar.add(2, add);
        return calendar.getTime();
    }

    public final Date addSecond(int add, Long millis) {
        Calendar calendar = getCalendar(millis);
        if (calendar == null) {
            return null;
        }
        calendar.add(13, add);
        return calendar.getTime();
    }

    public final String getZodiac(int month, int day) {
        Integer zodiacIndex = getZodiacIndex(Integer.valueOf(month), Integer.valueOf(day));
        if (zodiacIndex == null) {
            return null;
        }
        return TimeConstants.INSTANCE.getZODIAC()[zodiacIndex.intValue()];
    }

    public final Integer getZodiacIndex(Integer month, Integer day) {
        if (day == null || month == null || month.intValue() < 0 || month.intValue() > 12) {
            return null;
        }
        if (day.intValue() >= TimeConstants.INSTANCE.getZODIAC_FLAGS()[month.intValue() - 1]) {
            return Integer.valueOf(month.intValue() - 1);
        }
        return Integer.valueOf((month.intValue() + 10) % 12);
    }

    public final String formatDateOfShort(Long millis, boolean isAppendTime, String yesterday, String yesterday2) {
        Intrinsics.checkNotNullParameter(yesterday, "yesterday");
        Intrinsics.checkNotNullParameter(yesterday2, "yesterday2");
        Date date = getDate(millis);
        if (date == null) {
            return null;
        }
        return formatDateOfShort(date, isAppendTime, yesterday, yesterday2);
    }

    public final String formatDateOfShort2(Long millis) {
        Date date = getDate(millis);
        if (date == null) {
            return null;
        }
        return formatDateOfShort2(date);
    }
}
