package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.core.view.d1;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;
import m2.g0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l<S> extends u {

    /* renamed from: q, reason: collision with root package name */
    static final Object f٨٨٩٧q = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: r, reason: collision with root package name */
    static final Object f٨٨٩٨r = "NAVIGATION_PREV_TAG";

    /* renamed from: s, reason: collision with root package name */
    static final Object f٨٨٩٩s = "NAVIGATION_NEXT_TAG";

    /* renamed from: t, reason: collision with root package name */
    static final Object f٨٩٠٠t = "SELECTOR_TOGGLE_TAG";

    /* renamed from: b, reason: collision with root package name */
    private int f٨٩٠١b;

    /* renamed from: c, reason: collision with root package name */
    private DateSelector f٨٩٠٢c;

    /* renamed from: d, reason: collision with root package name */
    private CalendarConstraints f٨٩٠٣d;

    /* renamed from: e, reason: collision with root package name */
    private DayViewDecorator f٨٩٠٤e;

    /* renamed from: f, reason: collision with root package name */
    private Month f٨٩٠٥f;

    /* renamed from: g, reason: collision with root package name */
    private EnumC٠١١٢l f٨٩٠٦g;

    /* renamed from: h, reason: collision with root package name */
    private com.google.android.material.datepicker.b f٨٩٠٧h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f٨٩٠٨i;

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView f٨٩٠٩j;

    /* renamed from: k, reason: collision with root package name */
    private View f٨٩١٠k;

    /* renamed from: l, reason: collision with root package name */
    private View f٨٩١١l;

    /* renamed from: m, reason: collision with root package name */
    private View f٨٩١٢m;

    /* renamed from: n, reason: collision with root package name */
    private View f٨٩١٣n;

    /* renamed from: o, reason: collision with root package name */
    private MaterialButton f٨٩١٤o;

    /* renamed from: p, reason: collision with root package name */
    private AccessibilityManager f٨٩١٥p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f٨٩١٦a;

        a(s sVar) {
            this.f٨٩١٦a = sVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.D(this.f٨٩١٦a.b(l.this.z().findLastVisibleItemPosition() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f٨٩١٨a;

        b(int i10) {
            this.f٨٩١٨a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.f٨٩٠٩j.smoothScrollToPosition(this.f٨٩١٨a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c extends androidx.core.view.a {
        c() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.q0(null);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d extends v {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f٨٩٢١a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, int i10, boolean z10, int i11) {
            super(context, i10, z10);
            this.f٨٩٢١a = i11;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            if (this.f٨٩٢١a == 0) {
                iArr[0] = l.this.f٨٩٠٩j.getWidth();
                iArr[1] = l.this.f٨٩٠٩j.getWidth();
            } else {
                iArr[0] = l.this.f٨٩٠٩j.getHeight();
                iArr[1] = l.this.f٨٩٠٩j.getHeight();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class e implements m {
        e() {
        }

        @Override // com.google.android.material.datepicker.l.m
        public void a(long j10) {
            if (l.this.f٨٩٠٣d.g().w(j10)) {
                l.this.f٨٩٠٢c.U(j10);
                Iterator it = l.this.f٨٩٩٥a.iterator();
                while (it.hasNext()) {
                    ((t) it.next()).b(l.this.f٨٩٠٢c.getSelection());
                }
                l.this.f٨٩٠٩j.getAdapter().notifyDataSetChanged();
                if (l.this.f٨٩٠٨i != null) {
                    l.this.f٨٩٠٨i.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class f extends androidx.core.view.a {
        f() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.L0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class g extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        private final Calendar f٨٩٢٥a = c0.r();

        /* renamed from: b, reason: collision with root package name */
        private final Calendar f٨٩٢٦b = c0.r();

        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            int i10;
            int width;
            if ((recyclerView.getAdapter() instanceof d0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                d0 d0Var = (d0) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (androidx.core.util.g gVar : l.this.f٨٩٠٢c.C()) {
                    Object obj = gVar.f٢٨٨٨a;
                    if (obj != null && gVar.f٢٨٨٩b != null) {
                        this.f٨٩٢٥a.setTimeInMillis(((Long) obj).longValue());
                        this.f٨٩٢٦b.setTimeInMillis(((Long) gVar.f٢٨٨٩b).longValue());
                        int c10 = d0Var.c(this.f٨٩٢٥a.get(1));
                        int c11 = d0Var.c(this.f٨٩٢٦b.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(c10);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(c11);
                        int spanCount = c10 / gridLayoutManager.getSpanCount();
                        int spanCount2 = c11 / gridLayoutManager.getSpanCount();
                        for (int i11 = spanCount; i11 <= spanCount2; i11++) {
                            View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i11);
                            if (findViewByPosition3 != null) {
                                int top = findViewByPosition3.getTop() + l.this.f٨٩٠٧h.f٨٨٦٩d.c();
                                int bottom = findViewByPosition3.getBottom() - l.this.f٨٩٠٧h.f٨٨٦٩d.b();
                                if (i11 == spanCount && findViewByPosition != null) {
                                    i10 = findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2);
                                } else {
                                    i10 = 0;
                                }
                                if (i11 == spanCount2 && findViewByPosition2 != null) {
                                    width = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                } else {
                                    width = recyclerView.getWidth();
                                }
                                canvas.drawRect(i10, top, width, bottom, l.this.f٨٩٠٧h.f٨٨٧٣h);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class h extends androidx.core.view.a {
        h() {
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            String string;
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            if (l.this.f٨٩١٣n.getVisibility() == 0) {
                string = l.this.getString(R.string.mtrl_picker_toggle_to_year_selection);
            } else {
                string = l.this.getString(R.string.mtrl_picker_toggle_to_day_selection);
            }
            g0Var.b(new g0.a(16, string));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class i extends RecyclerView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f٨٩٢٩a;

        i(s sVar) {
            this.f٨٩٢٩a = sVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            int findLastVisibleItemPosition;
            if (i10 < 0) {
                findLastVisibleItemPosition = l.this.z().findFirstVisibleItemPosition();
            } else {
                findLastVisibleItemPosition = l.this.z().findLastVisibleItemPosition();
            }
            Month b10 = this.f٨٩٢٩a.b(findLastVisibleItemPosition);
            l.this.f٨٩٠٥f = b10;
            l.this.f٨٩١٤o.setText(this.f٨٩٢٩a.c(findLastVisibleItemPosition));
            l.this.H(this.f٨٩٢٩a.d(b10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f٨٩٣٢a;

        k(s sVar) {
            this.f٨٩٣٢a = sVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.D(this.f٨٩٣٢a.b(l.this.z().findFirstVisibleItemPosition() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.datepicker.l$l, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum EnumC٠١١٢l {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface m {
        void a(long j10);
    }

    public static l A(DateSelector dateSelector, int i10, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i10);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.n());
        lVar.setArguments(bundle);
        return lVar;
    }

    private void B(int i10) {
        this.f٨٩٠٩j.post(new b(i10));
    }

    private void F() {
        d1.q0(this.f٨٩٠٩j, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i10) {
        boolean z10;
        View view = this.f٨٩١١l;
        boolean z11 = false;
        if (i10 + 1 < this.f٨٩٠٩j.getAdapter().getItemCount()) {
            z10 = true;
        } else {
            z10 = false;
        }
        view.setEnabled(z10);
        View view2 = this.f٨٩١٠k;
        if (i10 - 1 >= 0) {
            z11 = true;
        }
        view2.setEnabled(z11);
    }

    private void r(View view, s sVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        this.f٨٩١٤o = materialButton;
        materialButton.setTag(f٨٩٠٠t);
        d1.q0(this.f٨٩١٤o, new h());
        View findViewById = view.findViewById(R.id.month_navigation_previous);
        this.f٨٩١٠k = findViewById;
        findViewById.setTag(f٨٨٩٨r);
        View findViewById2 = view.findViewById(R.id.month_navigation_next);
        this.f٨٩١١l = findViewById2;
        findViewById2.setTag(f٨٨٩٩s);
        this.f٨٩١٢m = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f٨٩١٣n = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        E(EnumC٠١١٢l.DAY);
        this.f٨٩١٤o.setText(this.f٨٩٠٥f.j());
        this.f٨٩٠٩j.addOnScrollListener(new i(sVar));
        this.f٨٩١٤o.setOnClickListener(new j());
        this.f٨٩١١l.setOnClickListener(new k(sVar));
        this.f٨٩١٠k.setOnClickListener(new a(sVar));
        H(sVar.d(this.f٨٩٠٥f));
    }

    private RecyclerView.ItemDecoration s() {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    private static int y(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i10 = r.f٨٩٧٨g;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        MaterialButton materialButton = this.f٨٩١٤o;
        if (materialButton != null) {
            materialButton.sendAccessibilityEvent(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(Month month) {
        boolean z10;
        s sVar = (s) this.f٨٩٠٩j.getAdapter();
        int d10 = sVar.d(month);
        AccessibilityManager accessibilityManager = this.f٨٩١٥p;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            this.f٨٩٠٥f = month;
            this.f٨٩٠٩j.scrollToPosition(d10);
        } else {
            int d11 = d10 - sVar.d(this.f٨٩٠٥f);
            boolean z11 = false;
            if (Math.abs(d11) > 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (d11 > 0) {
                z11 = true;
            }
            this.f٨٩٠٥f = month;
            if (z10 && z11) {
                this.f٨٩٠٩j.scrollToPosition(d10 - 3);
                B(d10);
            } else if (z10) {
                this.f٨٩٠٩j.scrollToPosition(d10 + 3);
                B(d10);
            } else {
                B(d10);
            }
        }
        H(d10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(EnumC٠١١٢l r52) {
        this.f٨٩٠٦g = r52;
        if (r52 == EnumC٠١١٢l.YEAR) {
            this.f٨٩٠٨i.getLayoutManager().scrollToPosition(((d0) this.f٨٩٠٨i.getAdapter()).c(this.f٨٩٠٥f.f٨٨٣٣c));
            this.f٨٩١٢m.setVisibility(0);
            this.f٨٩١٣n.setVisibility(8);
            this.f٨٩١٠k.setVisibility(8);
            this.f٨٩١١l.setVisibility(8);
            return;
        }
        if (r52 == EnumC٠١١٢l.DAY) {
            this.f٨٩١٢m.setVisibility(8);
            this.f٨٩١٣n.setVisibility(0);
            this.f٨٩١٠k.setVisibility(0);
            this.f٨٩١١l.setVisibility(0);
            D(this.f٨٩٠٥f);
        }
    }

    void G() {
        EnumC٠١١٢l r02 = this.f٨٩٠٦g;
        EnumC٠١١٢l r12 = EnumC٠١١٢l.YEAR;
        if (r02 == r12) {
            E(EnumC٠١١٢l.DAY);
            this.f٨٩٠٩j.announceForAccessibility(getString(R.string.mtrl_picker_toggled_to_day_selection));
        } else if (r02 == EnumC٠١١٢l.DAY) {
            E(r12);
            this.f٨٩٠٨i.announceForAccessibility(getString(R.string.mtrl_picker_toggled_to_year_selection));
        }
    }

    @Override // com.google.android.material.datepicker.u
    public boolean g(t tVar) {
        return super.g(tVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f٨٩٠١b = bundle.getInt("THEME_RES_ID_KEY");
        this.f٨٩٠٢c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f٨٩٠٣d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f٨٩٠٤e = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f٨٩٠٥f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        int i11;
        com.google.android.material.datepicker.k kVar;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f٨٩٠١b);
        this.f٨٩٠٧h = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.f٨٩١٥p = (AccessibilityManager) requireContext().getSystemService("accessibility");
        Month p10 = this.f٨٩٠٣d.p();
        if (p.t(contextThemeWrapper)) {
            i10 = R.layout.mtrl_calendar_vertical;
            i11 = 1;
        } else {
            i10 = R.layout.mtrl_calendar_horizontal;
            i11 = 0;
        }
        View inflate = cloneInContext.inflate(i10, viewGroup, false);
        inflate.setMinimumHeight(y(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        d1.q0(gridView, new c());
        int j10 = this.f٨٩٠٣d.j();
        if (j10 > 0) {
            kVar = new com.google.android.material.datepicker.k(j10);
        } else {
            kVar = new com.google.android.material.datepicker.k();
        }
        gridView.setAdapter((ListAdapter) kVar);
        gridView.setNumColumns(p10.f٨٨٣٤d);
        gridView.setEnabled(false);
        this.f٨٩٠٩j = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.f٨٩٠٩j.setLayoutManager(new d(getContext(), i11, false, i11));
        this.f٨٩٠٩j.setTag(f٨٨٩٧q);
        s sVar = new s(contextThemeWrapper, this.f٨٩٠٢c, this.f٨٩٠٣d, this.f٨٩٠٤e, new e());
        this.f٨٩٠٩j.setAdapter(sVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f٨٩٠٨i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f٨٩٠٨i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f٨٩٠٨i.setAdapter(new d0(this));
            this.f٨٩٠٨i.addItemDecoration(s());
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            r(inflate, sVar);
        }
        if (!p.t(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f٨٩٠٩j);
        }
        this.f٨٩٠٩j.scrollToPosition(sVar.d(this.f٨٩٠٥f));
        F();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f٨٩٠١b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f٨٩٠٢c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f٨٩٠٣d);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f٨٩٠٤e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f٨٩٠٥f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarConstraints t() {
        return this.f٨٩٠٣d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.b u() {
        return this.f٨٩٠٧h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month v() {
        return this.f٨٩٠٥f;
    }

    public DateSelector w() {
        return this.f٨٩٠٢c;
    }

    LinearLayoutManager z() {
        return (LinearLayoutManager) this.f٨٩٠٩j.getLayoutManager();
    }
}
