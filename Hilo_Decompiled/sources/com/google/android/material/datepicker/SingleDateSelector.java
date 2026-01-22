package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f٨٨٥٤a;

    /* renamed from: b, reason: collision with root package name */
    private Long f٨٨٥٥b;

    /* renamed from: c, reason: collision with root package name */
    private SimpleDateFormat f٨٨٥٦c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends e {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ t f٨٨٥٧i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ TextInputLayout f٨٨٥٨j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, t tVar, TextInputLayout textInputLayout2) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f٨٨٥٧i = tVar;
            this.f٨٨٥٨j = textInputLayout2;
        }

        @Override // com.google.android.material.datepicker.e
        void f() {
            SingleDateSelector.this.f٨٨٥٤a = this.f٨٨٥٨j.getError();
            this.f٨٨٥٧i.a();
        }

        @Override // com.google.android.material.datepicker.e
        void g(Long l10) {
            if (l10 == null) {
                SingleDateSelector.this.d();
            } else {
                SingleDateSelector.this.U(l10.longValue());
            }
            SingleDateSelector.this.f٨٨٥٤a = null;
            this.f٨٨٥٧i.b(SingleDateSelector.this.getSelection());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements Parcelable.Creator {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.f٨٨٥٥b = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SingleDateSelector[] newArray(int i10) {
            return new SingleDateSelector[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f٨٨٥٥b = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String A(Context context) {
        Resources resources = context.getResources();
        Long l10 = this.f٨٨٥٥b;
        if (l10 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, j.m(l10.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection C() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View K(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, t tVar) {
        boolean z10;
        String h10;
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        Integer f10 = v7.a.f(inflate.getContext(), R.attr.colorOnSurfaceVariant);
        if (f10 != null) {
            editText.setHintTextColor(f10.intValue());
        }
        if (com.google.android.material.internal.i.b()) {
            editText.setInputType(17);
        }
        SimpleDateFormat simpleDateFormat = this.f٨٨٥٦c;
        if (simpleDateFormat != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            simpleDateFormat = c0.g();
        }
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        if (z10) {
            h10 = simpleDateFormat2.toPattern();
        } else {
            h10 = c0.h(inflate.getResources(), simpleDateFormat2);
        }
        String str = h10;
        textInputLayout.setPlaceholderText(str);
        Long l10 = this.f٨٨٥٥b;
        if (l10 != null) {
            editText.setText(simpleDateFormat2.format(l10));
        }
        editText.addTextChangedListener(new a(str, simpleDateFormat2, textInputLayout, calendarConstraints, tVar, textInputLayout));
        if (!h.a(inflate.getContext())) {
            h.d(editText);
        }
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean N() {
        if (this.f٨٨٥٥b != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection Q() {
        ArrayList arrayList = new ArrayList();
        Long l10 = this.f٨٨٥٥b;
        if (l10 != null) {
            arrayList.add(l10);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void U(long j10) {
        this.f٨٨٥٥b = Long.valueOf(j10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Long getSelection() {
        return this.f٨٨٥٥b;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String t(Context context) {
        String m10;
        Resources resources = context.getResources();
        Long l10 = this.f٨٨٥٥b;
        if (l10 == null) {
            m10 = resources.getString(R.string.mtrl_picker_announce_current_selection_none);
        } else {
            m10 = j.m(l10.longValue());
        }
        return resources.getString(R.string.mtrl_picker_announce_current_selection, m10);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int u(Context context) {
        return c8.b.f(context, R.attr.materialCalendarTheme, p.class.getCanonicalName());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeValue(this.f٨٨٥٥b);
    }
}
