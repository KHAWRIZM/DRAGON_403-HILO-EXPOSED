package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.k0;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class p<S> extends DialogFragment {
    static final Object E = "CONFIRM_BUTTON_TAG";
    static final Object F = "CANCEL_BUTTON_TAG";
    static final Object G = "TOGGLE_BUTTON_TAG";
    private Button A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f٨٩٤٠B;
    private CharSequence C;
    private CharSequence D;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f٨٩٤١a = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashSet f٨٩٤٢b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private final LinkedHashSet f٨٩٤٣c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    private final LinkedHashSet f٨٩٤٤d = new LinkedHashSet();

    /* renamed from: e, reason: collision with root package name */
    private int f٨٩٤٥e;

    /* renamed from: f, reason: collision with root package name */
    private DateSelector f٨٩٤٦f;

    /* renamed from: g, reason: collision with root package name */
    private u f٨٩٤٧g;

    /* renamed from: h, reason: collision with root package name */
    private CalendarConstraints f٨٩٤٨h;

    /* renamed from: i, reason: collision with root package name */
    private DayViewDecorator f٨٩٤٩i;

    /* renamed from: j, reason: collision with root package name */
    private l f٨٩٥٠j;

    /* renamed from: k, reason: collision with root package name */
    private int f٨٩٥١k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f٨٩٥٢l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٨٩٥٣m;

    /* renamed from: n, reason: collision with root package name */
    private int f٨٩٥٤n;

    /* renamed from: o, reason: collision with root package name */
    private int f٨٩٥٥o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f٨٩٥٦p;

    /* renamed from: q, reason: collision with root package name */
    private int f٨٩٥٧q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f٨٩٥٨r;

    /* renamed from: s, reason: collision with root package name */
    private int f٨٩٥٩s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f٨٩٦٠t;

    /* renamed from: u, reason: collision with root package name */
    private int f٨٩٦١u;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f٨٩٦٢v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f٨٩٦٣w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f٨٩٦٤x;

    /* renamed from: y, reason: collision with root package name */
    private CheckableImageButton f٨٩٦٥y;

    /* renamed from: z, reason: collision with root package name */
    private f8.i f٨٩٦٦z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f٨٩٦٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f٨٩٦٨b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f٨٩٦٩c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f٨٩٧٠d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f٨٩٧١e;

        a(int i10, View view, int i11, int i12, int i13) {
            this.f٨٩٦٧a = i10;
            this.f٨٩٦٨b = view;
            this.f٨٩٦٩c = i11;
            this.f٨٩٧٠d = i12;
            this.f٨٩٧١e = i13;
        }

        @Override // androidx.core.view.j0
        public d2 onApplyWindowInsets(View view, d2 d2Var) {
            androidx.core.graphics.b0 f10 = d2Var.f(d2.m.g());
            if (this.f٨٩٦٧a >= 0) {
                this.f٨٩٦٨b.getLayoutParams().height = this.f٨٩٦٧a + f10.f٢٧٩٤b;
                View view2 = this.f٨٩٦٨b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f٨٩٦٨b;
            view3.setPadding(this.f٨٩٦٩c + f10.f٢٧٩٣a, this.f٨٩٧٠d + f10.f٢٧٩٤b, this.f٨٩٧١e + f10.f٢٧٩٥c, view3.getPaddingBottom());
            return d2Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends t {
        b() {
        }

        @Override // com.google.android.material.datepicker.t
        public void a() {
            p.this.A.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.t
        public void b(Object obj) {
            p pVar = p.this;
            pVar.B(pVar.o());
            p.this.A.setEnabled(p.this.l().N());
        }
    }

    private void A() {
        int r10 = r(requireContext());
        l A = l.A(l(), r10, this.f٨٩٤٨h, this.f٨٩٤٩i);
        this.f٨٩٥٠j = A;
        u uVar = A;
        if (this.f٨٩٥٤n == 1) {
            uVar = q.i(l(), r10, this.f٨٩٤٨h);
        }
        this.f٨٩٤٧g = uVar;
        C();
        B(o());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.mtrl_calendar_frame, this.f٨٩٤٧g);
        beginTransaction.commitNow();
        this.f٨٩٤٧g.g(new b());
    }

    private void C() {
        CharSequence charSequence;
        TextView textView = this.f٨٩٦٣w;
        if (this.f٨٩٥٤n == 1 && u()) {
            charSequence = this.D;
        } else {
            charSequence = this.C;
        }
        textView.setText(charSequence);
    }

    private void D(CheckableImageButton checkableImageButton) {
        String string;
        if (this.f٨٩٥٤n == 1) {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            string = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.f٨٩٦٥y.setContentDescription(string);
    }

    private static Drawable j(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, r1.a.b(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], r1.a.b(context, R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private void k(Window window) {
        if (this.f٨٩٤٠B) {
            return;
        }
        View findViewById = requireView().findViewById(R.id.fullscreen_header);
        com.google.android.material.internal.e.a(window, true, k0.h(findViewById), null);
        int paddingTop = findViewById.getPaddingTop();
        d1.E0(findViewById, new a(findViewById.getLayoutParams().height, findViewById, findViewById.getPaddingLeft(), paddingTop, findViewById.getPaddingRight()));
        this.f٨٩٤٠B = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector l() {
        if (this.f٨٩٤٦f == null) {
            this.f٨٩٤٦f = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f٨٩٤٦f;
    }

    private static CharSequence m(CharSequence charSequence) {
        if (charSequence != null) {
            String[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                return split[0];
            }
            return charSequence;
        }
        return null;
    }

    private String n() {
        return l().t(requireContext());
    }

    private static int p(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i10 = Month.e().f٨٨٣٤d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int r(Context context) {
        int i10 = this.f٨٩٤٥e;
        if (i10 != 0) {
            return i10;
        }
        return l().u(context);
    }

    private void s(Context context) {
        boolean z10;
        this.f٨٩٦٥y.setTag(G);
        this.f٨٩٦٥y.setImageDrawable(j(context));
        CheckableImageButton checkableImageButton = this.f٨٩٦٥y;
        if (this.f٨٩٥٤n != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        checkableImageButton.setChecked(z10);
        d1.q0(this.f٨٩٦٥y, null);
        D(this.f٨٩٦٥y);
        this.f٨٩٦٥y.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.this.w(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(Context context) {
        return z(context, android.R.attr.windowFullscreen);
    }

    private boolean u() {
        if (getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v(Context context) {
        return z(context, R.attr.nestedScrollable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        this.A.setEnabled(l().N());
        this.f٨٩٦٥y.toggle();
        int i10 = 1;
        if (this.f٨٩٥٤n == 1) {
            i10 = 0;
        }
        this.f٨٩٥٤n = i10;
        D(this.f٨٩٦٥y);
        A();
    }

    static boolean z(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c8.b.f(context, R.attr.materialCalendarStyle, l.class.getCanonicalName()), new int[]{i10});
        boolean z10 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z10;
    }

    void B(String str) {
        this.f٨٩٦٤x.setContentDescription(n());
        this.f٨٩٦٤x.setText(str);
    }

    public String o() {
        return l().A(getContext());
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f٨٩٤٣c.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f٨٩٤٥e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f٨٩٤٦f = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f٨٩٤٨h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f٨٩٤٩i = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f٨٩٥١k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f٨٩٥٢l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f٨٩٥٤n = bundle.getInt("INPUT_MODE_KEY");
        this.f٨٩٥٥o = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f٨٩٥٦p = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f٨٩٥٧q = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f٨٩٥٨r = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f٨٩٥٩s = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f٨٩٦٠t = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f٨٩٦١u = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f٨٩٦٢v = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence = this.f٨٩٥٢l;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.f٨٩٥١k);
        }
        this.C = charSequence;
        this.D = m(charSequence);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), r(requireContext()));
        Context context = dialog.getContext();
        this.f٨٩٥٣m = t(context);
        int i10 = R.attr.materialCalendarStyle;
        int i11 = R.style.Widget_MaterialComponents_MaterialCalendar;
        this.f٨٩٦٦z = new f8.i(context, null, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialCalendar, i10, i11);
        int color = obtainStyledAttributes.getColor(R.styleable.MaterialCalendar_backgroundTint, 0);
        obtainStyledAttributes.recycle();
        this.f٨٩٦٦z.V(context);
        this.f٨٩٦٦z.h0(ColorStateList.valueOf(color));
        this.f٨٩٦٦z.g0(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i10;
        if (this.f٨٩٥٣m) {
            i10 = R.layout.mtrl_picker_fullscreen;
        } else {
            i10 = R.layout.mtrl_picker_dialog;
        }
        View inflate = layoutInflater.inflate(i10, viewGroup);
        Context context = inflate.getContext();
        DayViewDecorator dayViewDecorator = this.f٨٩٤٩i;
        if (dayViewDecorator != null) {
            dayViewDecorator.i(context);
        }
        if (this.f٨٩٥٣m) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(p(context), -2));
        } else {
            inflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(p(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.f٨٩٦٤x = textView;
        textView.setAccessibilityLiveRegion(1);
        this.f٨٩٦٥y = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.f٨٩٦٣w = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        s(context);
        this.A = (Button) inflate.findViewById(R.id.confirm_button);
        if (l().N()) {
            this.A.setEnabled(true);
        } else {
            this.A.setEnabled(false);
        }
        this.A.setTag(E);
        CharSequence charSequence = this.f٨٩٥٦p;
        if (charSequence != null) {
            this.A.setText(charSequence);
        } else {
            int i11 = this.f٨٩٥٥o;
            if (i11 != 0) {
                this.A.setText(i11);
            }
        }
        CharSequence charSequence2 = this.f٨٩٥٨r;
        if (charSequence2 != null) {
            this.A.setContentDescription(charSequence2);
        } else if (this.f٨٩٥٧q != 0) {
            this.A.setContentDescription(getContext().getResources().getText(this.f٨٩٥٧q));
        }
        this.A.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.this.y(view);
            }
        });
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag(F);
        CharSequence charSequence3 = this.f٨٩٦٠t;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i12 = this.f٨٩٥٩s;
            if (i12 != 0) {
                button.setText(i12);
            }
        }
        CharSequence charSequence4 = this.f٨٩٦٢v;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.f٨٩٦١u != 0) {
            button.setContentDescription(getContext().getResources().getText(this.f٨٩٦١u));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.this.x(view);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f٨٩٤٤d.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Month v10;
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f٨٩٤٥e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f٨٩٤٦f);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f٨٩٤٨h);
        l lVar = this.f٨٩٥٠j;
        if (lVar == null) {
            v10 = null;
        } else {
            v10 = lVar.v();
        }
        if (v10 != null) {
            bVar.b(v10.f٨٨٣٦f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f٨٩٤٩i);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f٨٩٥١k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f٨٩٥٢l);
        bundle.putInt("INPUT_MODE_KEY", this.f٨٩٥٤n);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f٨٩٥٥o);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f٨٩٥٦p);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f٨٩٥٧q);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f٨٩٥٨r);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f٨٩٥٩s);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f٨٩٦٠t);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f٨٩٦١u);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f٨٩٦٢v);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f٨٩٥٣m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f٨٩٦٦z);
            k(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f٨٩٦٦z, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new w7.a(requireDialog(), rect));
        }
        A();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.f٨٩٤٧g.h();
        super.onStop();
    }

    public final Object q() {
        return l().getSelection();
    }

    public void x(View view) {
        Iterator it = this.f٨٩٤٢b.iterator();
        while (it.hasNext()) {
            ((View.OnClickListener) it.next()).onClick(view);
        }
        dismiss();
    }

    public void y(View view) {
        Iterator it = this.f٨٩٤١a.iterator();
        if (!it.hasNext()) {
            dismiss();
        } else {
            androidx.appcompat.app.a0.a(it.next());
            q();
            throw null;
        }
    }
}
