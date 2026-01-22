package com.github.gzuliyujiang.wheelpicker;

import java.util.Calendar;
import s6.b;
import t6.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BirthdayPicker extends DatePicker {

    /* renamed from: l, reason: collision with root package name */
    private b f٧٩٥٥l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٧٩٥٦m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.dialog.BaseDialog
    public void f() {
        super.f();
        this.f٧٩٥٦m = true;
        Calendar calendar = Calendar.getInstance();
        int i10 = calendar.get(1);
        this.f٧٩٥٩k.q(b.g(i10 - 100, 1, 1), b.g(i10, calendar.get(2) + 1, calendar.get(5)), this.f٧٩٥٥l);
        this.f٧٩٥٩k.setDateMode(0);
        this.f٧٩٥٩k.setDateFormatter(new a());
    }
}
