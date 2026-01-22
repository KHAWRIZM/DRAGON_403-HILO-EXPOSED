package com.qiahao.base_common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.oudi.utils.ACache;
import com.oudi.utils.date.DateFormat;
import com.oudi.utils.date.DateUtils;
import com.qiahao.base_common.R;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\n\u001a\u00020\u0007\u001a\"\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0001\u001a$\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0001H\u0007\u001a\"\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a\u0006\u0010\u0019\u001a\u00020\u0007\u001a\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007\u001a\u0016\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u0007\u001a\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007\u001a\u0016\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001\u001a\u000e\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0007\u001a\u000e\u0010+\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0007\"\u001b\u0010\u001a\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"convert", "", "startDate", "Ljava/util/Date;", "endDate", "timeQuantumFormat", "timeDifference", "", "changeSecondsToDay", "", "seconds", "timeQuantumFormat1", "getDurationInFormat", "Lkotlin/Pair;", "getDate", "timestampInMillis", "timeZone", "Ljava/util/Locale;", "inFormat", "getDateFormatWithLocale", HeaderInterceptor.TIMESTAMP, "format", "getDateInSecs", "timestampInSeconds", "getDateHmsInSecond", "currentTimeSecs", "constantTimeSecs", "getConstantTimeSecs", "()J", "constantTimeSecs$delegate", "Lkotlin/Lazy;", "findDifference", "", "getGroupDateString", "context", "Landroid/content/Context;", "isToday", "", "time", "isThisTime", "pattern", "changeLuckRankingTime", "secondsTime", "changeTaskTime", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DateTimeUtilityKt {

    @NotNull
    private static final Lazy constantTimeSecs$delegate = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.utils.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            long constantTimeSecs_delegate$lambda$0;
            constantTimeSecs_delegate$lambda$0 = DateTimeUtilityKt.constantTimeSecs_delegate$lambda$0();
            return Long.valueOf(constantTimeSecs_delegate$lambda$0);
        }
    });

    @NotNull
    public static final String changeLuckRankingTime(long j10) {
        int i10;
        int i11;
        int i12;
        StringBuilder sb = new StringBuilder();
        if (j10 > 0) {
            i10 = (int) (j10 % 60);
        } else {
            i10 = 0;
        }
        if (j10 > 60) {
            i11 = (int) (j10 / 60);
            if (i11 > 60) {
                i11 %= 60;
            }
        } else {
            i11 = 0;
        }
        if (j10 > 3600) {
            i12 = (int) (j10 / 3600);
        } else {
            i12 = 0;
        }
        if (i12 > 0) {
            if (i12 > 9) {
                sb.append(i12);
            } else {
                sb.append(0);
                sb.append(i12);
            }
            sb.append(CertificateUtil.DELIMITER);
        } else {
            sb.append("00:");
        }
        if (i11 > 0) {
            if (i11 > 9) {
                sb.append(i11);
            } else {
                sb.append(0);
                sb.append(i11);
            }
            sb.append(CertificateUtil.DELIMITER);
        } else {
            sb.append("00:");
        }
        if (i10 > 0) {
            if (i10 > 9) {
                sb.append(i10);
            } else {
                sb.append(0);
                sb.append(i10);
            }
        } else {
            sb.append("00");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final int changeSecondsToDay(long j10) {
        return (int) (j10 / ACache.TIME_DAY);
    }

    @NotNull
    public static final String changeTaskTime(long j10) {
        int i10;
        int i11;
        int i12;
        int i13;
        StringBuilder sb = new StringBuilder();
        if (j10 > 0) {
            i10 = (int) (j10 % 60);
        } else {
            i10 = 0;
        }
        if (j10 > 60) {
            i11 = (int) (j10 / 60);
            if (i11 > 60) {
                i11 %= 60;
            }
        } else {
            i11 = 0;
        }
        if (j10 > 3600) {
            i12 = (int) (j10 / 3600);
            if (i12 > 24) {
                i12 %= 24;
            }
        } else {
            i12 = 0;
        }
        if (j10 > 86400) {
            i13 = (int) (j10 / ACache.TIME_DAY);
        } else {
            i13 = 0;
        }
        if (i13 > 0) {
            sb.append(i13 + "Days ");
        }
        if (i12 > 0) {
            if (i12 > 9) {
                sb.append(i12);
            } else {
                sb.append(0);
                sb.append(i12);
            }
            sb.append(CertificateUtil.DELIMITER);
        } else {
            sb.append("00:");
        }
        if (i11 > 0) {
            if (i11 > 9) {
                sb.append(i11);
            } else {
                sb.append(0);
                sb.append(i11);
            }
            sb.append(CertificateUtil.DELIMITER);
        } else {
            sb.append("00:");
        }
        if (i10 > 0) {
            if (i10 > 9) {
                sb.append(i10);
            } else {
                sb.append(0);
                sb.append(i10);
            }
        } else {
            sb.append("00");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constantTimeSecs_delegate$lambda$0() {
        return System.currentTimeMillis() / 1000;
    }

    @NotNull
    public static final String convert(@NotNull Date startDate, @NotNull Date endDate) {
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        long j10 = 60;
        long time = ((endDate.getTime() - startDate.getTime()) / 1000) / j10;
        if (time < 60) {
            return time + "m";
        }
        long j11 = time / j10;
        if (j11 < 24) {
            return j11 + "h";
        }
        long j12 = j11 / 24;
        if (j12 < 30) {
            return j12 + "d";
        }
        long j13 = j12 / 30;
        if (j13 < 12) {
            return j13 + "M";
        }
        return (j13 / 12) + "Y";
    }

    public static final long currentTimeSecs() {
        return System.currentTimeMillis() / 1000;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static final void findDifference(@NotNull String startDate, @NotNull String endDate) {
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat.YMD_HMS);
        try {
            Date parse = simpleDateFormat.parse(startDate);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            Date parse2 = simpleDateFormat.parse(endDate);
            Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
            long time = parse2.getTime() - parse.getTime();
            long j10 = 60;
            long j11 = (time / 1000) % j10;
            long j12 = (time / DateUtils.MINUTE) % j10;
            long j13 = (time / DateUtils.HOUR) % 24;
            PrintStream printStream = System.out;
            printStream.println((Object) "Difference between two dates is: ");
            printStream.println((Object) ((time / 31536000000L) + " years, " + ((time / DateUtils.DAY) % 365) + " days, " + j13 + " hours, " + j12 + " minutes, " + j11 + " seconds"));
        } catch (ParseException e10) {
            e10.printStackTrace();
        }
    }

    public static final long getConstantTimeSecs() {
        return ((Number) constantTimeSecs$delegate.getValue()).longValue();
    }

    @NotNull
    public static final String getDate(long j10, @NotNull Locale timeZone, @NotNull String inFormat) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(inFormat, "inFormat");
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j10);
        return android.text.format.DateFormat.format(inFormat, calendar).toString();
    }

    public static /* synthetic */ String getDate$default(long j10, Locale locale, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            locale = Locale.getDefault();
        }
        if ((i10 & 4) != 0) {
            str = "yyyy-MM-dd";
        }
        return getDate(j10, locale, str);
    }

    @Nullable
    public static final String getDateFormatWithLocale(long j10, @NotNull String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return new SimpleDateFormat(format, Locale.CHINA).format(new Date(j10));
    }

    public static /* synthetic */ String getDateFormatWithLocale$default(long j10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "yyyy-MM-dd";
        }
        return getDateFormatWithLocale(j10, str);
    }

    @NotNull
    public static final String getDateHmsInSecond(long j10, @NotNull Locale timeZone, @NotNull String inFormat) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(inFormat, "inFormat");
        try {
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTimeInMillis(j10 * 1000);
            return android.text.format.DateFormat.format(inFormat, calendar).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static /* synthetic */ String getDateHmsInSecond$default(long j10, Locale locale, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            locale = Locale.getDefault();
        }
        if ((i10 & 4) != 0) {
            str = DateFormat.YMD_HM;
        }
        return getDateHmsInSecond(j10, locale, str);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @NotNull
    public static final String getDateInSecs(long j10, @NotNull Locale timeZone, @NotNull String inFormat) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(inFormat, "inFormat");
        if (j10 == 0) {
            return "";
        }
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j10 * 1000);
        return android.text.format.DateFormat.format(inFormat, calendar).toString();
    }

    public static /* synthetic */ String getDateInSecs$default(long j10, Locale locale, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            locale = Locale.getDefault();
        }
        if ((i10 & 4) != 0) {
            str = "yyyy-MM-dd";
        }
        return getDateInSecs(j10, locale, str);
    }

    @NotNull
    public static final Pair<Long, Long> getDurationInFormat(long j10) {
        return new Pair<>(Long.valueOf(TimeUnit.SECONDS.toMinutes(j10)), Long.valueOf((j10 % 3600) % 60));
    }

    @NotNull
    public static final String getGroupDateString(@NotNull Context context, long j10) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (j10 == 0) {
            return " ";
        }
        Log.d("DateTimeUtility", "getGroupDateString: " + j10);
        long j11 = j10 * ((long) 1000);
        long currentTimeMillis = System.currentTimeMillis() - j11;
        Log.d("DateTimeUtility", "getGroupDateString 当前时间" + System.currentTimeMillis() + " " + currentTimeMillis);
        if (currentTimeMillis < 60000) {
            String string = context.getResources().getString(R.string.just_now);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (currentTimeMillis > 60000 && currentTimeMillis < 3600000) {
            return (currentTimeMillis / 60000) + "m";
        }
        if (currentTimeMillis > 3600000 && currentTimeMillis < 86400000) {
            return (currentTimeMillis / 3600000) + "h";
        }
        if (currentTimeMillis > 86400000 && currentTimeMillis < 604800000) {
            return String.valueOf(currentTimeMillis / 86400000) + "d";
        }
        if (currentTimeMillis > 604800000) {
            String format = new SimpleDateFormat(DateUtils.FORMAT_DATE_TWO, Locale.getDefault()).format(new Date(j11));
            Intrinsics.checkNotNull(format);
            return format;
        }
        return "unKnow";
    }

    public static final boolean isThisTime(long j10, @NotNull String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Date date = new Date(j10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date()))) {
            return true;
        }
        return false;
    }

    public static final boolean isToday(long j10) {
        return isThisTime(j10, "yyyy-MM-dd");
    }

    @NotNull
    public static final String timeQuantumFormat(long j10) {
        long j11 = 60;
        long j12 = j10 / j11;
        StringBuilder sb = new StringBuilder();
        if (j12 < 60) {
            sb.append("1h");
        } else {
            long j13 = j12 / j11;
            long j14 = 24;
            long j15 = j13 / j14;
            if (j15 > 0) {
                sb.append(j15 + "d");
                long j16 = j13 - (j15 * j14);
                if (j16 > 0) {
                    sb.append(" " + j16 + "h");
                }
                Unit unit = Unit.INSTANCE;
            } else {
                sb.append(j13 + "h");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public static final String timeQuantumFormat1(long j10) {
        long j11 = 60;
        long j12 = j10 / j11;
        StringBuilder sb = new StringBuilder();
        if (j12 < 60) {
            sb.append("1h");
        } else {
            long j13 = (j12 / j11) / 24;
            if (j13 > 0) {
                sb.append(j13 + "d");
            } else {
                sb.append("0d");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
