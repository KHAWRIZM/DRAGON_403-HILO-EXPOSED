package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.p0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListMenuItemView extends LinearLayout implements m.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    private i f٩٠٢a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f٩٠٣b;

    /* renamed from: c, reason: collision with root package name */
    private RadioButton f٩٠٤c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f٩٠٥d;

    /* renamed from: e, reason: collision with root package name */
    private CheckBox f٩٠٦e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f٩٠٧f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f٩٠٨g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f٩٠٩h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f٩١٠i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f٩١١j;

    /* renamed from: k, reason: collision with root package name */
    private int f٩١٢k;

    /* renamed from: l, reason: collision with root package name */
    private Context f٩١٣l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٩١٤m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f٩١٥n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f٩١٦o;

    /* renamed from: p, reason: collision with root package name */
    private LayoutInflater f٩١٧p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٩١٨q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i10) {
        LinearLayout linearLayout = this.f٩١٠i;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f٩٠٦e = checkBox;
        a(checkBox);
    }

    private void d() {
        ImageView imageView = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f٩٠٣b = imageView;
        b(imageView, 0);
    }

    private void e() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f٩٠٤c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f٩١٧p == null) {
            this.f٩١٧p = LayoutInflater.from(getContext());
        }
        return this.f٩١٧p;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        int i10;
        ImageView imageView = this.f٩٠٨g;
        if (imageView != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f٩٠٩h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f٩٠٩h.getLayoutParams();
            rect.top += this.f٩٠٩h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public void f(boolean z10, char c10) {
        int i10;
        if (z10 && this.f٩٠٢a.A()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        if (i10 == 0) {
            this.f٩٠٧f.setText(this.f٩٠٢a.h());
        }
        if (this.f٩٠٧f.getVisibility() != i10) {
            this.f٩٠٧f.setVisibility(i10);
        }
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void g(i iVar, int i10) {
        int i11;
        this.f٩٠٢a = iVar;
        if (iVar.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        setTitle(iVar.i(this));
        setCheckable(iVar.isCheckable());
        f(iVar.A(), iVar.g());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.m.a
    public i getItemData() {
        return this.f٩٠٢a;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean h() {
        return false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f٩١١j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f٩٠٥d = textView;
        int i10 = this.f٩١٢k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f٩١٣l, i10);
        }
        this.f٩٠٧f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f٩٠٨g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f٩١٥n);
        }
        this.f٩٠٩h = (ImageView) findViewById(R.id.group_divider);
        this.f٩١٠i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f٩٠٣b != null && this.f٩١٤m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f٩٠٣b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f٩٠٤c == null && this.f٩٠٦e == null) {
            return;
        }
        if (this.f٩٠٢a.m()) {
            if (this.f٩٠٤c == null) {
                e();
            }
            compoundButton = this.f٩٠٤c;
            view = this.f٩٠٦e;
        } else {
            if (this.f٩٠٦e == null) {
                c();
            }
            compoundButton = this.f٩٠٦e;
            view = this.f٩٠٤c;
        }
        if (z10) {
            compoundButton.setChecked(this.f٩٠٢a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view != null && view.getVisibility() != 8) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        CheckBox checkBox = this.f٩٠٦e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f٩٠٤c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f٩٠٢a.m()) {
            if (this.f٩٠٤c == null) {
                e();
            }
            compoundButton = this.f٩٠٤c;
        } else {
            if (this.f٩٠٦e == null) {
                c();
            }
            compoundButton = this.f٩٠٦e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f٩١٨q = z10;
        this.f٩١٤m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        int i10;
        ImageView imageView = this.f٩٠٩h;
        if (imageView != null) {
            if (!this.f٩١٦o && z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10;
        if (!this.f٩٠٢a.z() && !this.f٩١٨q) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10 && !this.f٩١٤m) {
            return;
        }
        ImageView imageView = this.f٩٠٣b;
        if (imageView == null && drawable == null && !this.f٩١٤m) {
            return;
        }
        if (imageView == null) {
            d();
        }
        if (drawable == null && !this.f٩١٤m) {
            this.f٩٠٣b.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.f٩٠٣b;
        if (!z10) {
            drawable = null;
        }
        imageView2.setImageDrawable(drawable);
        if (this.f٩٠٣b.getVisibility() != 0) {
            this.f٩٠٣b.setVisibility(0);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f٩٠٥d.setText(charSequence);
            if (this.f٩٠٥d.getVisibility() != 0) {
                this.f٩٠٥d.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f٩٠٥d.getVisibility() != 8) {
            this.f٩٠٥d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        p0 v10 = p0.v(getContext(), attributeSet, R.styleable.MenuView, i10, 0);
        this.f٩١١j = v10.g(R.styleable.MenuView_android_itemBackground);
        this.f٩١٢k = v10.n(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f٩١٤m = v10.a(R.styleable.MenuView_preserveIconSpacing, false);
        this.f٩١٣l = context;
        this.f٩١٥n = v10.g(R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f٩١٦o = obtainStyledAttributes.hasValue(0);
        v10.x();
        obtainStyledAttributes.recycle();
    }
}
