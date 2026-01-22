package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.d1;
import androidx.core.view.l1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f١١٣٤i;

    /* renamed from: j, reason: collision with root package name */
    private CharSequence f١١٣٥j;

    /* renamed from: k, reason: collision with root package name */
    private View f١١٣٦k;

    /* renamed from: l, reason: collision with root package name */
    private View f١١٣٧l;

    /* renamed from: m, reason: collision with root package name */
    private View f١١٣٨m;

    /* renamed from: n, reason: collision with root package name */
    private LinearLayout f١١٣٩n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f١١٤٠o;

    /* renamed from: p, reason: collision with root package name */
    private TextView f١١٤١p;

    /* renamed from: q, reason: collision with root package name */
    private int f١١٤٢q;

    /* renamed from: r, reason: collision with root package name */
    private int f١١٤٣r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f١١٤٤s;

    /* renamed from: t, reason: collision with root package name */
    private int f١١٤٥t;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.view.b f١١٤٦a;

        a(androidx.appcompat.view.b bVar) {
            this.f١١٤٦a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f١١٤٦a.c();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    private void i() {
        int i10;
        if (this.f١١٣٩n == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f١١٣٩n = linearLayout;
            this.f١١٤٠o = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f١١٤١p = (TextView) this.f١١٣٩n.findViewById(R.id.action_bar_subtitle);
            if (this.f١١٤٢q != 0) {
                this.f١١٤٠o.setTextAppearance(getContext(), this.f١١٤٢q);
            }
            if (this.f١١٤٣r != 0) {
                this.f١١٤١p.setTextAppearance(getContext(), this.f١١٤٣r);
            }
        }
        this.f١١٤٠o.setText(this.f١١٣٤i);
        this.f١١٤١p.setText(this.f١١٣٥j);
        boolean isEmpty = TextUtils.isEmpty(this.f١١٣٤i);
        boolean isEmpty2 = TextUtils.isEmpty(this.f١١٣٥j);
        TextView textView = this.f١١٤١p;
        int i11 = 8;
        if (!isEmpty2) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        textView.setVisibility(i10);
        LinearLayout linearLayout2 = this.f١١٣٩n;
        if (!isEmpty || !isEmpty2) {
            i11 = 0;
        }
        linearLayout2.setVisibility(i11);
        if (this.f١١٣٩n.getParent() == null) {
            addView(this.f١١٣٩n);
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ l1 f(int i10, long j10) {
        return super.f(i10, j10);
    }

    public void g() {
        if (this.f١١٣٦k == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f١١٣٥j;
    }

    public CharSequence getTitle() {
        return this.f١١٣٤i;
    }

    public void h(androidx.appcompat.view.b bVar) {
        View view = this.f١١٣٦k;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f١١٤٥t, (ViewGroup) this, false);
            this.f١١٣٦k = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f١١٣٦k);
        }
        View findViewById = this.f١١٣٦k.findViewById(R.id.action_mode_close_button);
        this.f١١٣٧l = findViewById;
        findViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) bVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f١١١٦d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f١١١٦d = actionMenuPresenter2;
        actionMenuPresenter2.M(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.c(this.f١١١٦d, this.f١١١٤b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f١١١٦d.r(this);
        this.f١١١٥c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f١١١٥c, layoutParams);
    }

    public boolean j() {
        return this.f١١٤٤s;
    }

    public void k() {
        removeAllViews();
        this.f١١٣٨m = null;
        this.f١١١٥c = null;
        this.f١١١٦d = null;
        View view = this.f١١٣٧l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public boolean l() {
        ActionMenuPresenter actionMenuPresenter = this.f١١١٦d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.N();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f١١١٦d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.E();
            this.f١١١٦d.F();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingLeft;
        int paddingRight;
        int i14;
        int i15;
        boolean b10 = a1.b(this);
        if (b10) {
            paddingLeft = (i12 - i10) - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f١١٣٦k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f١١٣٦k.getLayoutParams();
            if (b10) {
                i14 = marginLayoutParams.rightMargin;
            } else {
                i14 = marginLayoutParams.leftMargin;
            }
            if (b10) {
                i15 = marginLayoutParams.leftMargin;
            } else {
                i15 = marginLayoutParams.rightMargin;
            }
            int d10 = AbsActionBarView.d(paddingLeft, i14, b10);
            paddingLeft = AbsActionBarView.d(d10 + e(this.f١١٣٦k, d10, paddingTop, paddingTop2, b10), i15, b10);
        }
        int i16 = paddingLeft;
        LinearLayout linearLayout = this.f١١٣٩n;
        if (linearLayout != null && this.f١١٣٨m == null && linearLayout.getVisibility() != 8) {
            i16 += e(this.f١١٣٩n, i16, paddingTop, paddingTop2, b10);
        }
        int i17 = i16;
        View view2 = this.f١١٣٨m;
        if (view2 != null) {
            e(view2, i17, paddingTop, paddingTop2, b10);
        }
        if (b10) {
            paddingRight = getPaddingLeft();
        } else {
            paddingRight = (i12 - i10) - getPaddingRight();
        }
        ActionMenuView actionMenuView = this.f١١١٥c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingRight, paddingTop, paddingTop2, !b10);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        boolean z10;
        int i13;
        int i14 = 1073741824;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            if (View.MeasureSpec.getMode(i11) != 0) {
                int size = View.MeasureSpec.getSize(i10);
                int i15 = this.f١١١٧e;
                if (i15 <= 0) {
                    i15 = View.MeasureSpec.getSize(i11);
                }
                int paddingTop = getPaddingTop() + getPaddingBottom();
                int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                int i16 = i15 - paddingTop;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE);
                View view = this.f١١٣٦k;
                if (view != null) {
                    int c10 = c(view, paddingLeft, makeMeasureSpec, 0);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f١١٣٦k.getLayoutParams();
                    paddingLeft = c10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                }
                ActionMenuView actionMenuView = this.f١١١٥c;
                if (actionMenuView != null && actionMenuView.getParent() == this) {
                    paddingLeft = c(this.f١١١٥c, paddingLeft, makeMeasureSpec, 0);
                }
                LinearLayout linearLayout = this.f١١٣٩n;
                if (linearLayout != null && this.f١١٣٨m == null) {
                    if (this.f١١٤٤s) {
                        this.f١١٣٩n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                        int measuredWidth = this.f١١٣٩n.getMeasuredWidth();
                        if (measuredWidth <= paddingLeft) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            paddingLeft -= measuredWidth;
                        }
                        LinearLayout linearLayout2 = this.f١١٣٩n;
                        if (z10) {
                            i13 = 0;
                        } else {
                            i13 = 8;
                        }
                        linearLayout2.setVisibility(i13);
                    } else {
                        paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
                    }
                }
                View view2 = this.f١١٣٨m;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    int i17 = layoutParams.width;
                    if (i17 != -2) {
                        i12 = 1073741824;
                    } else {
                        i12 = Integer.MIN_VALUE;
                    }
                    if (i17 >= 0) {
                        paddingLeft = Math.min(i17, paddingLeft);
                    }
                    int i18 = layoutParams.height;
                    if (i18 == -2) {
                        i14 = Integer.MIN_VALUE;
                    }
                    if (i18 >= 0) {
                        i16 = Math.min(i18, i16);
                    }
                    this.f١١٣٨m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i12), View.MeasureSpec.makeMeasureSpec(i16, i14));
                }
                if (this.f١١١٧e <= 0) {
                    int childCount = getChildCount();
                    int i19 = 0;
                    for (int i20 = 0; i20 < childCount; i20++) {
                        int measuredHeight = getChildAt(i20).getMeasuredHeight() + paddingTop;
                        if (measuredHeight > i19) {
                            i19 = measuredHeight;
                        }
                    }
                    setMeasuredDimension(size, i19);
                    return;
                }
                setMeasuredDimension(size, i15);
                return;
            }
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i10) {
        this.f١١١٧e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f١١٣٨m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f١١٣٨m = view;
        if (view != null && (linearLayout = this.f١١٣٩n) != null) {
            removeView(linearLayout);
            this.f١١٣٩n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f١١٣٥j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f١١٣٤i = charSequence;
        i();
        d1.s0(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f١١٤٤s) {
            requestLayout();
        }
        this.f١١٤٤s = z10;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p0 v10 = p0.v(context, attributeSet, R.styleable.ActionMode, i10, 0);
        setBackground(v10.g(R.styleable.ActionMode_background));
        this.f١١٤٢q = v10.n(R.styleable.ActionMode_titleTextStyle, 0);
        this.f١١٤٣r = v10.n(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f١١١٧e = v10.m(R.styleable.ActionMode_height, 0);
        this.f١١٤٥t = v10.n(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        v10.x();
    }
}
