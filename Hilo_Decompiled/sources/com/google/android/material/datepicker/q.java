package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class q<S> extends u {

    /* renamed from: b, reason: collision with root package name */
    private int f٨٩٧٤b;

    /* renamed from: c, reason: collision with root package name */
    private DateSelector f٨٩٧٥c;

    /* renamed from: d, reason: collision with root package name */
    private CalendarConstraints f٨٩٧٦d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends t {
        a() {
        }

        @Override // com.google.android.material.datepicker.t
        public void a() {
            Iterator it = q.this.f٨٩٩٥a.iterator();
            while (it.hasNext()) {
                ((t) it.next()).a();
            }
        }

        @Override // com.google.android.material.datepicker.t
        public void b(Object obj) {
            Iterator it = q.this.f٨٩٩٥a.iterator();
            while (it.hasNext()) {
                ((t) it.next()).b(obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q i(DateSelector dateSelector, int i10, CalendarConstraints calendarConstraints) {
        q qVar = new q();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        qVar.setArguments(bundle);
        return qVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f٨٩٧٤b = bundle.getInt("THEME_RES_ID_KEY");
        this.f٨٩٧٥c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f٨٩٧٦d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f٨٩٧٥c.K(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f٨٩٧٤b)), viewGroup, bundle, this.f٨٩٧٦d, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f٨٩٧٤b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f٨٩٧٥c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f٨٩٧٦d);
    }
}
