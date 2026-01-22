package com.google.android.material.textfield;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* renamed from: e, reason: collision with root package name */
    private final androidx.appcompat.widget.f0 f١٠١٠٥e;

    /* renamed from: f, reason: collision with root package name */
    private final AccessibilityManager f١٠١٠٦f;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f١٠١٠٧g;

    /* renamed from: h, reason: collision with root package name */
    private final int f١٠١٠٨h;

    /* renamed from: i, reason: collision with root package name */
    private final float f١٠١٠٩i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f١٠١١٠j;

    /* renamed from: k, reason: collision with root package name */
    private int f١٠١١١k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f١٠١١٢l;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            Object item;
            MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
            if (i10 < 0) {
                item = materialAutoCompleteTextView.f١٠١٠٥e.t();
            } else {
                item = materialAutoCompleteTextView.getAdapter().getItem(i10);
            }
            MaterialAutoCompleteTextView materialAutoCompleteTextView2 = MaterialAutoCompleteTextView.this;
            materialAutoCompleteTextView2.setText(materialAutoCompleteTextView2.convertSelectionToString(item), false);
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = MaterialAutoCompleteTextView.this.f١٠١٠٥e.w();
                    i10 = MaterialAutoCompleteTextView.this.f١٠١٠٥e.v();
                    j10 = MaterialAutoCompleteTextView.this.f١٠١٠٥e.u();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f١٠١٠٥e.n(), view, i10, j10);
            }
            MaterialAutoCompleteTextView.this.f١٠١٠٥e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends ArrayAdapter {

        /* renamed from: a, reason: collision with root package name */
        private ColorStateList f١٠١١٤a;

        /* renamed from: b, reason: collision with root package name */
        private ColorStateList f١٠١١٥b;

        b(Context context, int i10, String[] strArr) {
            super(context, i10, strArr);
            f();
        }

        private ColorStateList a() {
            if (c() && d()) {
                int[] iArr = {R.attr.state_hovered, -16842919};
                int[] iArr2 = {R.attr.state_selected, -16842919};
                return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{v7.a.j(MaterialAutoCompleteTextView.this.f١٠١١١k, MaterialAutoCompleteTextView.this.f١٠١١٢l.getColorForState(iArr2, 0)), v7.a.j(MaterialAutoCompleteTextView.this.f١٠١١١k, MaterialAutoCompleteTextView.this.f١٠١١٢l.getColorForState(iArr, 0)), MaterialAutoCompleteTextView.this.f١٠١١١k});
            }
            return null;
        }

        private Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.f١٠١١١k);
            if (this.f١٠١١٥b != null) {
                colorDrawable.setTintList(this.f١٠١١٤a);
                return new RippleDrawable(this.f١٠١١٥b, colorDrawable, null);
            }
            return colorDrawable;
        }

        private boolean c() {
            if (MaterialAutoCompleteTextView.this.f١٠١١١k != 0) {
                return true;
            }
            return false;
        }

        private boolean d() {
            if (MaterialAutoCompleteTextView.this.f١٠١١٢l != null) {
                return true;
            }
            return false;
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.f١٠١١٢l.getColorForState(iArr, 0), 0});
        }

        void f() {
            this.f١٠١١٥b = e();
            this.f١٠١١٤a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            Drawable drawable;
            View view2 = super.getView(i10, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                if (MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText())) {
                    drawable = b();
                } else {
                    drawable = null;
                }
                textView.setBackground(drawable);
            }
            return view2;
        }
    }

    public MaterialAutoCompleteTextView(Context context) {
        this(context, null);
    }

    private TextInputLayout f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean g() {
        if (!i() && !h()) {
            return false;
        }
        return true;
    }

    private boolean h() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f١٠١٠٦f;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = this.f١٠١٠٦f.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean i() {
        AccessibilityManager accessibilityManager = this.f١٠١٠٦f;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        return false;
    }

    private int j() {
        ListAdapter adapter = getAdapter();
        TextInputLayout f10 = f();
        int i10 = 0;
        if (adapter == null || f10 == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.f١٠١٠٥e.v()) + 15);
        View view = null;
        int i11 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(max, view, f10);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        Drawable f11 = this.f١٠١٠٥e.f();
        if (f11 != null) {
            f11.getPadding(this.f١٠١٠٧g);
            Rect rect = this.f١٠١٠٧g;
            i11 += rect.left + rect.right;
        }
        return i11 + f10.getEndIconView().getMeasuredWidth();
    }

    private void k() {
        TextInputLayout f10 = f();
        if (f10 != null) {
            f10.u0();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (g()) {
            this.f١٠١٠٥e.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f١٠١١٠j;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout f10 = f();
        if (f10 != null && f10.S()) {
            return f10.getHint();
        }
        return super.getHint();
    }

    public float getPopupElevation() {
        return this.f١٠١٠٩i;
    }

    public int getSimpleItemSelectedColor() {
        return this.f١٠١١١k;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f١٠١١٢l;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout f10 = f();
        if (f10 != null && f10.S() && super.getHint() == null && com.google.android.material.internal.i.d()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f١٠١٠٥e.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), j()), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        if (g()) {
            return;
        }
        super.onWindowFocusChanged(z10);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f١٠١٠٥e.l(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        androidx.appcompat.widget.f0 f0Var = this.f١٠١٠٥e;
        if (f0Var != null) {
            f0Var.b(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i10) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f١٠١١٠j = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof f8.i) {
            ((f8.i) dropDownBackground).h0(this.f١٠١١٠j);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f١٠١٠٥e.setOnItemSelectedListener(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        k();
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f١٠١١١k = i10;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f١٠١١٢l = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (g()) {
            this.f١٠١٠٥e.show();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new b(getContext(), this.f١٠١٠٨h, strArr));
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, 0), attributeSet, i10);
        this.f١٠١٠٧g = new Rect();
        Context context2 = getContext();
        TypedArray i11 = com.google.android.material.internal.h0.i(context2, attributeSet, com.google.android.material.R.styleable.MaterialAutoCompleteTextView, i10, androidx.appcompat.R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i12 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType;
        if (i11.hasValue(i12) && i11.getInt(i12, 0) == 0) {
            setKeyListener(null);
        }
        this.f١٠١٠٨h = i11.getResourceId(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, com.google.android.material.R.layout.mtrl_auto_complete_simple_item);
        this.f١٠١٠٩i = i11.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_popupElevation, com.google.android.material.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int i13 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint;
        if (i11.hasValue(i13)) {
            this.f١٠١١٠j = ColorStateList.valueOf(i11.getColor(i13, 0));
        }
        this.f١٠١١١k = i11.getColor(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.f١٠١١٢l = c8.c.a(context2, i11, com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.f١٠١٠٦f = (AccessibilityManager) context2.getSystemService("accessibility");
        androidx.appcompat.widget.f0 f0Var = new androidx.appcompat.widget.f0(context2);
        this.f١٠١٠٥e = f0Var;
        f0Var.H(true);
        f0Var.B(this);
        f0Var.G(2);
        f0Var.l(getAdapter());
        f0Var.setOnItemClickListener(new a());
        int i14 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItems;
        if (i11.hasValue(i14)) {
            setSimpleItems(i11.getResourceId(i14, 0));
        }
        i11.recycle();
    }
}
