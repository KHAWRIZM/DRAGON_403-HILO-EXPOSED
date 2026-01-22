package com.qhqc.core.basic.utils;

import android.os.Build;
import android.os.LocaleList;
import com.qhqc.core.basic.ktx.StringToNumKtxKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\tJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\tJ$\u0010\u0003\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\tJ\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000e\u001a\u00020\u000b¨\u0006\u000f"}, d2 = {"Lcom/qhqc/core/basic/utils/TimeUtils;", "", "()V", "dateFormat", "", "date", "Ljava/util/Date;", "format", "locale", "Ljava/util/Locale;", "time", "", "getLocal", "getNowDateWithLocale", "getNowUnixTime", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TimeUtils {

    @NotNull
    public static final TimeUtils INSTANCE = new TimeUtils();

    private TimeUtils() {
    }

    public static /* synthetic */ String dateFormat$default(TimeUtils timeUtils, Date date, String str, Locale locale, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            locale = timeUtils.getLocal();
        }
        return timeUtils.dateFormat(date, str, locale);
    }

    private final Locale getLocal() {
        LocaleList localeList;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
            Intrinsics.checkNotNull(locale);
            return locale;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNull(locale2);
        return locale2;
    }

    @NotNull
    public final String dateFormat(@NotNull Date date, @Nullable String format, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(locale, "locale");
        try {
            String format2 = new SimpleDateFormat(format, locale).format(date);
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        } catch (Exception unused) {
            return "";
        }
    }

    @NotNull
    public final String getNowDateWithLocale(@Nullable String format) {
        String format2 = new SimpleDateFormat(format, Locale.CHINA).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    public final long getNowUnixTime() {
        return new Date().getTime();
    }

    public static /* synthetic */ String dateFormat$default(TimeUtils timeUtils, String str, String str2, Locale locale, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            locale = timeUtils.getLocal();
        }
        return timeUtils.dateFormat(str, str2, locale);
    }

    public static /* synthetic */ String dateFormat$default(TimeUtils timeUtils, long j10, String str, Locale locale, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            locale = timeUtils.getLocal();
        }
        return timeUtils.dateFormat(j10, str, locale);
    }

    @NotNull
    public final String dateFormat(@Nullable String time, @Nullable String format, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return dateFormat(StringToNumKtxKt.toParseLong(time), format, locale);
    }

    @NotNull
    public final String dateFormat(long time, @Nullable String format, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        try {
            String format2 = new SimpleDateFormat(format, locale).format(new Date(time * 1000));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        } catch (Exception unused) {
            return "";
        }
    }
}
