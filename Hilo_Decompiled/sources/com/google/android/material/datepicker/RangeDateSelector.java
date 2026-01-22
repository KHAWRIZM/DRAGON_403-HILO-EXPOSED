package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class RangeDateSelector implements DateSelector<androidx.core.util.g> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f٨٨٣٨a;

    /* renamed from: b, reason: collision with root package name */
    private String f٨٨٣٩b;

    /* renamed from: c, reason: collision with root package name */
    private final String f٨٨٤٠c = " ";

    /* renamed from: d, reason: collision with root package name */
    private Long f٨٨٤١d = null;

    /* renamed from: e, reason: collision with root package name */
    private Long f٨٨٤٢e = null;

    /* renamed from: f, reason: collision with root package name */
    private Long f٨٨٤٣f = null;

    /* renamed from: g, reason: collision with root package name */
    private Long f٨٨٤٤g = null;

    /* renamed from: h, reason: collision with root package name */
    private SimpleDateFormat f٨٨٤٥h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends e {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f٨٨٤٦i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f٨٨٤٧j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ t f٨٨٤٨k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, t tVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f٨٨٤٦i = textInputLayout2;
            this.f٨٨٤٧j = textInputLayout3;
            this.f٨٨٤٨k = tVar;
        }

        @Override // com.google.android.material.datepicker.e
        void f() {
            RangeDateSelector.this.f٨٨٤٣f = null;
            RangeDateSelector.this.n(this.f٨٨٤٦i, this.f٨٨٤٧j, this.f٨٨٤٨k);
        }

        @Override // com.google.android.material.datepicker.e
        void g(Long l10) {
            RangeDateSelector.this.f٨٨٤٣f = l10;
            RangeDateSelector.this.n(this.f٨٨٤٦i, this.f٨٨٤٧j, this.f٨٨٤٨k);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends e {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f٨٨٥٠i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f٨٨٥١j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ t f٨٨٥٢k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, t tVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f٨٨٥٠i = textInputLayout2;
            this.f٨٨٥١j = textInputLayout3;
            this.f٨٨٥٢k = tVar;
        }

        @Override // com.google.android.material.datepicker.e
        void f() {
            RangeDateSelector.this.f٨٨٤٤g = null;
            RangeDateSelector.this.n(this.f٨٨٥٠i, this.f٨٨٥١j, this.f٨٨٥٢k);
        }

        @Override // com.google.android.material.datepicker.e
        void g(Long l10) {
            RangeDateSelector.this.f٨٨٤٤g = l10;
            RangeDateSelector.this.n(this.f٨٨٥٠i, this.f٨٨٥١j, this.f٨٨٥٢k);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c implements Parcelable.Creator {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f٨٨٤١d = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f٨٨٤٢e = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RangeDateSelector[] newArray(int i10) {
            return new RangeDateSelector[i10];
        }
    }

    private void f(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f٨٨٣٩b.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError(null);
        }
    }

    private boolean i(long j10, long j11) {
        return j10 <= j11;
    }

    private void j(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f٨٨٣٩b);
        textInputLayout2.setError(" ");
    }

    private void l(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.f٨٨٣٨a = textInputLayout.getError();
        } else if (!TextUtils.isEmpty(textInputLayout2.getError())) {
            this.f٨٨٣٨a = textInputLayout2.getError();
        } else {
            this.f٨٨٣٨a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, t tVar) {
        Long l10 = this.f٨٨٤٣f;
        if (l10 != null && this.f٨٨٤٤g != null) {
            if (i(l10.longValue(), this.f٨٨٤٤g.longValue())) {
                this.f٨٨٤١d = this.f٨٨٤٣f;
                this.f٨٨٤٢e = this.f٨٨٤٤g;
                tVar.b(getSelection());
            } else {
                j(textInputLayout, textInputLayout2);
                tVar.a();
            }
        } else {
            f(textInputLayout, textInputLayout2);
            tVar.a();
        }
        l(textInputLayout, textInputLayout2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String A(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f٨٨٤١d;
        if (l10 == null && this.f٨٨٤٢e == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l11 = this.f٨٨٤٢e;
        if (l11 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, j.c(l10.longValue()));
        }
        if (l10 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, j.c(l11.longValue()));
        }
        androidx.core.util.g a10 = j.a(l10, l11);
        return resources.getString(R.string.mtrl_picker_range_header_selected, a10.f٢٨٨٨a, a10.f٢٨٨٩b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection C() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new androidx.core.util.g(this.f٨٨٤١d, this.f٨٨٤٢e));
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View K(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, t tVar) {
        boolean z10;
        String h10;
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        Integer f10 = v7.a.f(inflate.getContext(), R.attr.colorOnSurfaceVariant);
        if (f10 != null) {
            editText.setHintTextColor(f10.intValue());
            editText2.setHintTextColor(f10.intValue());
        }
        if (com.google.android.material.internal.i.b()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f٨٨٣٩b = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat simpleDateFormat = this.f٨٨٤٥h;
        if (simpleDateFormat != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            simpleDateFormat = c0.g();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        Long l10 = this.f٨٨٤١d;
        if (l10 != null) {
            editText.setText(simpleDateFormat2.format(l10));
            this.f٨٨٤٣f = this.f٨٨٤١d;
        }
        Long l11 = this.f٨٨٤٢e;
        if (l11 != null) {
            editText2.setText(simpleDateFormat2.format(l11));
            this.f٨٨٤٤g = this.f٨٨٤٢e;
        }
        if (z10) {
            h10 = simpleDateFormat2.toPattern();
        } else {
            h10 = c0.h(inflate.getResources(), simpleDateFormat2);
        }
        String str = h10;
        textInputLayout.setPlaceholderText(str);
        textInputLayout2.setPlaceholderText(str);
        editText.addTextChangedListener(new a(str, simpleDateFormat2, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, tVar));
        editText2.addTextChangedListener(new b(str, simpleDateFormat2, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, tVar));
        if (!h.a(inflate.getContext())) {
            h.d(editText, editText2);
        }
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean N() {
        Long l10 = this.f٨٨٤١d;
        if (l10 != null && this.f٨٨٤٢e != null && i(l10.longValue(), this.f٨٨٤٢e.longValue())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection Q() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f٨٨٤١d;
        if (l10 != null) {
            arrayList.add(l10);
        }
        Long l11 = this.f٨٨٤٢e;
        if (l11 != null) {
            arrayList.add(l11);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void U(long j10) {
        Long l10 = this.f٨٨٤١d;
        if (l10 == null) {
            this.f٨٨٤١d = Long.valueOf(j10);
        } else if (this.f٨٨٤٢e == null && i(l10.longValue(), j10)) {
            this.f٨٨٤٢e = Long.valueOf(j10);
        } else {
            this.f٨٨٤٢e = null;
            this.f٨٨٤١d = Long.valueOf(j10);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public androidx.core.util.g getSelection() {
        return new androidx.core.util.g(this.f٨٨٤١d, this.f٨٨٤٢e);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String t(Context context) {
        String str;
        String str2;
        Resources resources = context.getResources();
        androidx.core.util.g a10 = j.a(this.f٨٨٤١d, this.f٨٨٤٢e);
        Object obj = a10.f٢٨٨٨a;
        if (obj == null) {
            str = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
        } else {
            str = (String) obj;
        }
        Object obj2 = a10.f٢٨٨٩b;
        if (obj2 == null) {
            str2 = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
        } else {
            str2 = (String) obj2;
        }
        return resources.getString(R.string.mtrl_picker_announce_current_range_selection, str, str2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int u(Context context) {
        int i10;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis)) {
            i10 = R.attr.materialCalendarTheme;
        } else {
            i10 = R.attr.materialCalendarFullscreenTheme;
        }
        return c8.b.f(context, i10, p.class.getCanonicalName());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.f٨٨٤١d);
        parcel.writeValue(this.f٨٨٤٢e);
    }
}
