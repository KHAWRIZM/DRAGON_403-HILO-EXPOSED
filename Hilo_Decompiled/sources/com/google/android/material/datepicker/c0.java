package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    static AtomicReference f٨٨٧٦a = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(long j10) {
        Calendar r10 = r();
        r10.setTimeInMillis(j10);
        return f(r10).getTimeInMillis();
    }

    private static int b(String str, String str2, int i10, int i11) {
        while (i11 >= 0 && i11 < str.length() && str2.indexOf(str.charAt(i11)) == -1) {
            if (str.charAt(i11) != '\'') {
                i11 += i10;
            }
            do {
                i11 += i10;
                if (i11 >= 0 && i11 < str.length()) {
                }
                i11 += i10;
            } while (str.charAt(i11) != '\'');
            i11 += i10;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat c(Locale locale) {
        return d("MMMd", locale);
    }

    private static DateFormat d(String str, Locale locale) {
        DateFormat instanceForSkeleton;
        DisplayContext displayContext;
        instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(q());
        displayContext = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
        instanceForSkeleton.setContext(displayContext);
        return instanceForSkeleton;
    }

    static String e(String str) {
        return str.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", com.oudi.utils.date.DateFormat.DAY).replaceAll("M{1,2}", com.oudi.utils.date.DateFormat.MONTH).replaceAll("y{1,4}", com.oudi.utils.date.DateFormat.YEAR).replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar f(Calendar calendar) {
        Calendar s10 = s(calendar);
        Calendar r10 = r();
        r10.set(s10.get(1), s10.get(2), s10.get(5));
        return r10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SimpleDateFormat g() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(e(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern()), Locale.getDefault());
        simpleDateFormat.setTimeZone(o());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R.string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R.string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R.string.mtrl_picker_text_input_day_abbr);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
            pattern = pattern.replaceAll("d+", "d").replaceAll("M+", "M").replaceAll("y+", "y");
        }
        return pattern.replace("d", string3).replace("M", string2).replace("y", string);
    }

    private static java.text.DateFormat i(int i10, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i10, locale);
        dateInstance.setTimeZone(o());
        return dateInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat j(Locale locale) {
        return i(0, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat k(Locale locale) {
        return i(2, locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static java.text.DateFormat l(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) k(locale);
        simpleDateFormat.applyPattern(w(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat m(Locale locale) {
        return d("MMMMEEEEd", locale);
    }

    static w n() {
        w wVar = (w) f٨٨٧٦a.get();
        if (wVar == null) {
            return w.c();
        }
        return wVar;
    }

    private static TimeZone o() {
        return TimeZone.getTimeZone("UTC");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar p() {
        Calendar a10 = n().a();
        a10.set(11, 0);
        a10.set(12, 0);
        a10.set(13, 0);
        a10.set(14, 0);
        a10.setTimeZone(o());
        return a10;
    }

    private static android.icu.util.TimeZone q() {
        android.icu.util.TimeZone timeZone;
        timeZone = android.icu.util.TimeZone.getTimeZone("UTC");
        return timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Calendar r() {
        return s(null);
    }

    static Calendar s(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(o());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat t(Locale locale) {
        return d("yMMMd", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat u(Locale locale) {
        return d("yMMMM", locale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateFormat v(Locale locale) {
        return d("yMMMMEEEEd", locale);
    }

    private static String w(String str) {
        int b10 = b(str, "yY", 1, 0);
        if (b10 >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int b11 = b(str, "EMd", 1, b10);
        if (b11 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(b(str, str2, -1, b10) + 1, b11), " ").trim();
    }
}
