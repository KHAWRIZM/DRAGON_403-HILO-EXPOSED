package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class w {

    /* renamed from: c, reason: collision with root package name */
    private static final w f٨٩٩٧c = new w(null, null);

    /* renamed from: a, reason: collision with root package name */
    private final Long f٨٩٩٨a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeZone f٨٩٩٩b;

    private w(Long l10, TimeZone timeZone) {
        this.f٨٩٩٨a = l10;
        this.f٨٩٩٩b = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w c() {
        return f٨٩٩٧c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f٨٩٩٩b);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar;
        if (timeZone == null) {
            calendar = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(timeZone);
        }
        Long l10 = this.f٨٩٩٨a;
        if (l10 != null) {
            calendar.setTimeInMillis(l10.longValue());
        }
        return calendar;
    }
}
