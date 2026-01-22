package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static androidx.core.util.g a(Long l10, Long l11) {
        return b(l10, l11, null);
    }

    static androidx.core.util.g b(Long l10, Long l11, SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return androidx.core.util.g.a(null, null);
        }
        if (l10 == null) {
            return androidx.core.util.g.a(null, d(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return androidx.core.util.g.a(d(l10.longValue(), simpleDateFormat), null);
        }
        Calendar p10 = c0.p();
        Calendar r10 = c0.r();
        r10.setTimeInMillis(l10.longValue());
        Calendar r11 = c0.r();
        r11.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return androidx.core.util.g.a(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        }
        if (r10.get(1) == r11.get(1)) {
            if (r10.get(1) == p10.get(1)) {
                return androidx.core.util.g.a(g(l10.longValue(), Locale.getDefault()), g(l11.longValue(), Locale.getDefault()));
            }
            return androidx.core.util.g.a(g(l10.longValue(), Locale.getDefault()), n(l11.longValue(), Locale.getDefault()));
        }
        return androidx.core.util.g.a(n(l10.longValue(), Locale.getDefault()), n(l11.longValue(), Locale.getDefault()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(long j10) {
        return d(j10, null);
    }

    static String d(long j10, SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j10));
        }
        if (q(j10)) {
            return f(j10);
        }
        return m(j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(Context context, long j10, boolean z10, boolean z11, boolean z12) {
        String j11 = j(j10);
        if (z10) {
            j11 = String.format(context.getString(R.string.mtrl_picker_today_description), j11);
        }
        if (z11) {
            return String.format(context.getString(R.string.mtrl_picker_start_date_description), j11);
        }
        if (z12) {
            return String.format(context.getString(R.string.mtrl_picker_end_date_description), j11);
        }
        return j11;
    }

    static String f(long j10) {
        return g(j10, Locale.getDefault());
    }

    static String g(long j10, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = c0.c(locale).format(new Date(j10));
            return format;
        }
        return c0.l(locale).format(new Date(j10));
    }

    static String h(long j10) {
        return i(j10, Locale.getDefault());
    }

    static String i(long j10, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = c0.m(locale).format(new Date(j10));
            return format;
        }
        return c0.j(locale).format(new Date(j10));
    }

    static String j(long j10) {
        if (q(j10)) {
            return h(j10);
        }
        return o(j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k(Context context, int i10) {
        if (c0.p().get(1) == i10) {
            return String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i10));
        }
        return String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(long j10) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = c0.u(Locale.getDefault()).format(new Date(j10));
            return format;
        }
        return DateUtils.formatDateTime(null, j10, 8228);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m(long j10) {
        return n(j10, Locale.getDefault());
    }

    static String n(long j10, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = c0.t(locale).format(new Date(j10));
            return format;
        }
        return c0.k(locale).format(new Date(j10));
    }

    static String o(long j10) {
        return p(j10, Locale.getDefault());
    }

    static String p(long j10, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT >= 24) {
            format = c0.v(locale).format(new Date(j10));
            return format;
        }
        return c0.j(locale).format(new Date(j10));
    }

    private static boolean q(long j10) {
        Calendar p10 = c0.p();
        Calendar r10 = c0.r();
        r10.setTimeInMillis(j10);
        if (p10.get(1) == r10.get(1)) {
            return true;
        }
        return false;
    }
}
