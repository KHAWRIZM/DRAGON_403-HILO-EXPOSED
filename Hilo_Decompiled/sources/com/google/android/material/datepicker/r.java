package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class r extends BaseAdapter {

    /* renamed from: g, reason: collision with root package name */
    static final int f٨٩٧٨g = c0.r().getMaximum(4);

    /* renamed from: h, reason: collision with root package name */
    private static final int f٨٩٧٩h = (c0.r().getMaximum(5) + c0.r().getMaximum(7)) - 1;

    /* renamed from: a, reason: collision with root package name */
    final Month f٨٩٨٠a;

    /* renamed from: b, reason: collision with root package name */
    final DateSelector f٨٩٨١b;

    /* renamed from: c, reason: collision with root package name */
    private Collection f٨٩٨٢c;

    /* renamed from: d, reason: collision with root package name */
    b f٨٩٨٣d;

    /* renamed from: e, reason: collision with root package name */
    final CalendarConstraints f٨٩٨٤e;

    /* renamed from: f, reason: collision with root package name */
    final DayViewDecorator f٨٩٨٥f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f٨٩٨٠a = month;
        this.f٨٩٨١b = dateSelector;
        this.f٨٩٨٤e = calendarConstraints;
        this.f٨٩٨٥f = dayViewDecorator;
        this.f٨٩٨٢c = dateSelector.Q();
    }

    private String c(Context context, long j10) {
        return j.e(context, j10, l(j10), k(j10), g(j10));
    }

    private void f(Context context) {
        if (this.f٨٩٨٣d == null) {
            this.f٨٩٨٣d = new b(context);
        }
    }

    private boolean j(long j10) {
        Iterator it = this.f٨٩٨١b.Q().iterator();
        while (it.hasNext()) {
            if (c0.a(j10) == c0.a(((Long) it.next()).longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(long j10) {
        if (c0.p().getTimeInMillis() == j10) {
            return true;
        }
        return false;
    }

    private void o(TextView textView, long j10, int i10) {
        a aVar;
        boolean z10;
        a aVar2;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String c10 = c(context, j10);
        textView.setContentDescription(c10);
        boolean w10 = this.f٨٩٨٤e.g().w(j10);
        if (w10) {
            textView.setEnabled(true);
            boolean j11 = j(j10);
            textView.setSelected(j11);
            if (j11) {
                aVar2 = this.f٨٩٨٣d.f٨٨٦٧b;
            } else if (l(j10)) {
                aVar2 = this.f٨٩٨٣d.f٨٨٦٨c;
            } else {
                aVar2 = this.f٨٩٨٣d.f٨٨٦٦a;
            }
            aVar = aVar2;
            z10 = j11;
        } else {
            textView.setEnabled(false);
            aVar = this.f٨٩٨٣d.f٨٨٧٢g;
            z10 = false;
        }
        DayViewDecorator dayViewDecorator = this.f٨٩٨٥f;
        if (dayViewDecorator != null && i10 != -1) {
            Month month = this.f٨٩٨٠a;
            int i11 = month.f٨٨٣٣c;
            int i12 = month.f٨٨٣٢b;
            ColorStateList a10 = dayViewDecorator.a(context, i11, i12, i10, w10, z10);
            boolean z11 = z10;
            aVar.e(textView, a10, this.f٨٩٨٥f.g(context, i11, i12, i10, w10, z11));
            Drawable c11 = this.f٨٩٨٥f.c(context, i11, i12, i10, w10, z11);
            Drawable e10 = this.f٨٩٨٥f.e(context, i11, i12, i10, w10, z11);
            Drawable d10 = this.f٨٩٨٥f.d(context, i11, i12, i10, w10, z11);
            boolean z12 = z10;
            textView.setCompoundDrawables(c11, e10, d10, this.f٨٩٨٥f.b(context, i11, i12, i10, w10, z12));
            textView.setContentDescription(this.f٨٩٨٥f.f(context, i11, i12, i10, w10, z12, c10));
            return;
        }
        aVar.d(textView);
    }

    private void p(MaterialCalendarGridView materialCalendarGridView, long j10) {
        if (Month.d(j10).equals(this.f٨٩٨٠a)) {
            int i10 = this.f٨٩٨٠a.i(j10);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(i10) - materialCalendarGridView.getFirstVisiblePosition()), j10, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i10) {
        return b() + (i10 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f٨٩٨٠a.f(this.f٨٩٨٤e.j());
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i10) {
        if (i10 >= b() && i10 <= m()) {
            return Long.valueOf(this.f٨٩٨٠a.g(n(i10)));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i10, View view, ViewGroup viewGroup) {
        int i11;
        Long item;
        f(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int b10 = i10 - b();
        if (b10 >= 0) {
            Month month = this.f٨٩٨٠a;
            if (b10 < month.f٨٨٣٥e) {
                i11 = b10 + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i11)));
                textView.setVisibility(0);
                textView.setEnabled(true);
                item = getItem(i10);
                if (item != null) {
                    return textView;
                }
                o(textView, item.longValue(), i11);
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        i11 = -1;
        item = getItem(i10);
        if (item != null) {
        }
    }

    boolean g(long j10) {
        Iterator it = this.f٨٩٨١b.C().iterator();
        while (it.hasNext()) {
            Object obj = ((androidx.core.util.g) it.next()).f٢٨٨٩b;
            if (obj != null && ((Long) obj).longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f٨٩٧٩h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10 / this.f٨٩٨٠a.f٨٨٣٤d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(int i10) {
        if (i10 % this.f٨٩٨٠a.f٨٨٣٤d == 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i10) {
        if ((i10 + 1) % this.f٨٩٨٠a.f٨٨٣٤d == 0) {
            return true;
        }
        return false;
    }

    boolean k(long j10) {
        Iterator it = this.f٨٩٨١b.C().iterator();
        while (it.hasNext()) {
            Object obj = ((androidx.core.util.g) it.next()).f٢٨٨٨a;
            if (obj != null && ((Long) obj).longValue() == j10) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return (b() + this.f٨٩٨٠a.f٨٨٣٥e) - 1;
    }

    int n(int i10) {
        return (i10 - b()) + 1;
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.f٨٩٨٢c.iterator();
        while (it.hasNext()) {
            p(materialCalendarGridView, ((Long) it.next()).longValue());
        }
        DateSelector dateSelector = this.f٨٩٨١b;
        if (dateSelector != null) {
            Iterator it2 = dateSelector.Q().iterator();
            while (it2.hasNext()) {
                p(materialCalendarGridView, ((Long) it2.next()).longValue());
            }
            this.f٨٩٨٢c = this.f٨٩٨١b.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(int i10) {
        if (i10 >= b() && i10 <= m()) {
            return true;
        }
        return false;
    }
}
