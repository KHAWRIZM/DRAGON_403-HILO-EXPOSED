package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class k extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private static final int f٨٨٩٣d;

    /* renamed from: a, reason: collision with root package name */
    private final Calendar f٨٨٩٤a;

    /* renamed from: b, reason: collision with root package name */
    private final int f٨٨٩٥b;

    /* renamed from: c, reason: collision with root package name */
    private final int f٨٨٩٦c;

    static {
        int i10;
        if (Build.VERSION.SDK_INT >= 26) {
            i10 = 4;
        } else {
            i10 = 1;
        }
        f٨٨٩٣d = i10;
    }

    public k() {
        Calendar r10 = c0.r();
        this.f٨٨٩٤a = r10;
        this.f٨٨٩٥b = r10.getMaximum(7);
        this.f٨٨٩٦c = r10.getFirstDayOfWeek();
    }

    private int b(int i10) {
        int i11 = i10 + this.f٨٨٩٦c;
        int i12 = this.f٨٨٩٥b;
        if (i11 > i12) {
            return i11 - i12;
        }
        return i11;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i10) {
        if (i10 >= this.f٨٨٩٥b) {
            return null;
        }
        return Integer.valueOf(b(i10));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f٨٨٩٥b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f٨٨٩٤a.set(7, b(i10));
        textView.setText(this.f٨٨٩٤a.getDisplayName(7, f٨٨٩٣d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.f٨٨٩٤a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public k(int i10) {
        Calendar r10 = c0.r();
        this.f٨٨٩٤a = r10;
        this.f٨٨٩٥b = r10.getMaximum(7);
        this.f٨٨٩٦c = i10;
    }
}
