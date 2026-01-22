package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.d1;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class s extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final CalendarConstraints f٨٩٨٦a;

    /* renamed from: b, reason: collision with root package name */
    private final DateSelector f٨٩٨٧b;

    /* renamed from: c, reason: collision with root package name */
    private final DayViewDecorator f٨٩٨٨c;

    /* renamed from: d, reason: collision with root package name */
    private final l.m f٨٩٨٩d;

    /* renamed from: e, reason: collision with root package name */
    private final int f٨٩٩٠e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f٨٩٩١a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f٨٩٩١a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            if (this.f٨٩٩١a.getAdapter().r(i10)) {
                s.this.f٨٩٨٩d.a(this.f٨٩٩١a.getAdapter().getItem(i10).longValue());
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        final TextView f٨٩٩٣a;

        /* renamed from: b, reason: collision with root package name */
        final MaterialCalendarGridView f٨٩٩٤b;

        b(LinearLayout linearLayout, boolean z10) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.f٨٩٩٣a = textView;
            d1.r0(textView, true);
            this.f٨٩٩٤b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z10) {
                textView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Context context, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, l.m mVar) {
        int i10;
        Month p10 = calendarConstraints.p();
        Month i11 = calendarConstraints.i();
        Month n10 = calendarConstraints.n();
        if (p10.compareTo(n10) <= 0) {
            if (n10.compareTo(i11) <= 0) {
                int x10 = r.f٨٩٧٨g * l.x(context);
                if (p.t(context)) {
                    i10 = l.x(context);
                } else {
                    i10 = 0;
                }
                this.f٨٩٩٠e = x10 + i10;
                this.f٨٩٨٦a = calendarConstraints;
                this.f٨٩٨٧b = dateSelector;
                this.f٨٩٨٨c = dayViewDecorator;
                this.f٨٩٨٩d = mVar;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month b(int i10) {
        return this.f٨٩٨٦a.p().n(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence c(int i10) {
        return b(i10).j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(Month month) {
        return this.f٨٩٨٦a.p().p(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i10) {
        Month n10 = this.f٨٩٨٦a.p().n(i10);
        bVar.f٨٩٩٣a.setText(n10.j());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f٨٩٩٤b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() != null && n10.equals(materialCalendarGridView.getAdapter().f٨٩٨٠a)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        } else {
            r rVar = new r(n10, this.f٨٩٨٧b, this.f٨٩٨٦a, this.f٨٩٨٨c);
            materialCalendarGridView.setNumColumns(n10.f٨٨٣٤d);
            materialCalendarGridView.setAdapter((ListAdapter) rVar);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (p.t(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f٨٩٩٠e));
            return new b(linearLayout, true);
        }
        return new b(linearLayout, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f٨٩٨٦a.l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return this.f٨٩٨٦a.p().n(i10).l();
    }
}
