package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.l;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final l f٨٨٧٩a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f٨٨٨٠a;

        a(int i10) {
            this.f٨٨٨٠a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0.this.f٨٨٧٩a.D(d0.this.f٨٨٧٩a.t().f(Month.c(this.f٨٨٨٠a, d0.this.f٨٨٧٩a.v().f٨٨٣٢b)));
            d0.this.f٨٨٧٩a.E(l.EnumC٠١١٢l.DAY);
            d0.this.f٨٨٧٩a.C();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        final TextView f٨٨٨٢a;

        b(TextView textView) {
            super(textView);
            this.f٨٨٨٢a = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(l lVar) {
        this.f٨٨٧٩a = lVar;
    }

    private View.OnClickListener b(int i10) {
        return new a(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i10) {
        return i10 - this.f٨٨٧٩a.t().p().f٨٨٣٣c;
    }

    int d(int i10) {
        return this.f٨٨٧٩a.t().p().f٨٨٣٣c + i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i10) {
        com.google.android.material.datepicker.a aVar;
        int d10 = d(i10);
        boolean z10 = true;
        bVar.f٨٨٨٢a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(d10)));
        TextView textView = bVar.f٨٨٨٢a;
        textView.setContentDescription(j.k(textView.getContext(), d10));
        com.google.android.material.datepicker.b u10 = this.f٨٨٧٩a.u();
        Calendar p10 = c0.p();
        if (p10.get(1) == d10) {
            aVar = u10.f٨٨٧١f;
        } else {
            aVar = u10.f٨٨٦٩d;
        }
        Iterator it = this.f٨٨٧٩a.w().Q().iterator();
        while (it.hasNext()) {
            p10.setTimeInMillis(((Long) it.next()).longValue());
            if (p10.get(1) == d10) {
                aVar = u10.f٨٨٧٠e;
            }
        }
        aVar.d(bVar.f٨٨٨٢a);
        TextView textView2 = bVar.f٨٨٨٢a;
        if (aVar != u10.f٨٨٧٠e) {
            z10 = false;
        }
        textView2.setSelected(z10);
        bVar.f٨٨٨٢a.setOnClickListener(b(d10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f٨٨٧٩a.t().r();
    }
}
