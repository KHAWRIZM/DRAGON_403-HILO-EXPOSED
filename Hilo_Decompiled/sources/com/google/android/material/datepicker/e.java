package com.google.android.material.datepicker;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.g0;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class e extends g0 {

    /* renamed from: a, reason: collision with root package name */
    private final TextInputLayout f٨٨٨٣a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٨٨٨٤b;

    /* renamed from: c, reason: collision with root package name */
    private final DateFormat f٨٨٨٥c;

    /* renamed from: d, reason: collision with root package name */
    private final CalendarConstraints f٨٨٨٦d;

    /* renamed from: e, reason: collision with root package name */
    private final String f٨٨٨٧e;

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f٨٨٨٨f;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f٨٨٨٩g;

    /* renamed from: h, reason: collision with root package name */
    private int f٨٨٩٠h = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(final String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f٨٨٨٤b = str;
        this.f٨٨٨٥c = dateFormat;
        this.f٨٨٨٣a = textInputLayout;
        this.f٨٨٨٦d = calendarConstraints;
        this.f٨٨٨٧e = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f٨٨٨٨f = new Runnable() { // from class: com.google.android.material.datepicker.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.e(str);
            }
        };
    }

    private Runnable c(final long j10) {
        return new Runnable() { // from class: com.google.android.material.datepicker.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.d(j10);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(long j10) {
        this.f٨٨٨٣a.setError(String.format(this.f٨٨٨٧e, i(j.c(j10))));
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        TextInputLayout textInputLayout = this.f٨٨٨٣a;
        DateFormat dateFormat = this.f٨٨٨٥c;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_use), i(str)) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_example), i(dateFormat.format(new Date(c0.p().getTimeInMillis())))));
        f();
    }

    private String i(String str) {
        return str.replace(' ', Typography.nbsp);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (!Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) && editable.length() != 0 && editable.length() < this.f٨٨٨٤b.length() && editable.length() >= this.f٨٨٩٠h) {
            char charAt = this.f٨٨٨٤b.charAt(editable.length());
            if (!Character.isLetterOrDigit(charAt)) {
                editable.append(charAt);
            }
        }
    }

    @Override // com.google.android.material.internal.g0, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f٨٨٩٠h = charSequence.length();
    }

    abstract void f();

    abstract void g(Long l10);

    public void h(View view, Runnable runnable) {
        view.post(runnable);
    }

    @Override // com.google.android.material.internal.g0, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f٨٨٨٣a.removeCallbacks(this.f٨٨٨٨f);
        this.f٨٨٨٣a.removeCallbacks(this.f٨٨٨٩g);
        this.f٨٨٨٣a.setError(null);
        g(null);
        if (!TextUtils.isEmpty(charSequence) && charSequence.length() >= this.f٨٨٨٤b.length()) {
            try {
                Date parse = this.f٨٨٨٥c.parse(charSequence.toString());
                this.f٨٨٨٣a.setError(null);
                long time = parse.getTime();
                if (this.f٨٨٨٦d.g().w(time) && this.f٨٨٨٦d.v(time)) {
                    g(Long.valueOf(parse.getTime()));
                    return;
                }
                Runnable c10 = c(time);
                this.f٨٨٨٩g = c10;
                h(this.f٨٨٨٣a, c10);
            } catch (ParseException unused) {
                h(this.f٨٨٨٣a, this.f٨٨٨٨f);
            }
        }
    }
}
