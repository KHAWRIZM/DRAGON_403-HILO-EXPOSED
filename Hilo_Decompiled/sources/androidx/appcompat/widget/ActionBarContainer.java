package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f١١٢٤a;

    /* renamed from: b, reason: collision with root package name */
    private View f١١٢٥b;

    /* renamed from: c, reason: collision with root package name */
    private View f١١٢٦c;

    /* renamed from: d, reason: collision with root package name */
    private View f١١٢٧d;

    /* renamed from: e, reason: collision with root package name */
    Drawable f١١٢٨e;

    /* renamed from: f, reason: collision with root package name */
    Drawable f١١٢٩f;

    /* renamed from: g, reason: collision with root package name */
    Drawable f١١٣٠g;

    /* renamed from: h, reason: collision with root package name */
    boolean f١١٣١h;

    /* renamed from: i, reason: collision with root package name */
    boolean f١١٣٢i;

    /* renamed from: j, reason: collision with root package name */
    private int f١١٣٣j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a {
        public static void a(ActionBarContainer actionBarContainer) {
            actionBarContainer.invalidateOutline();
        }
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    private int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        if (view != null && view.getVisibility() != 8 && view.getMeasuredHeight() != 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f١١٢٨e;
        if (drawable != null && drawable.isStateful()) {
            this.f١١٢٨e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f١١٢٩f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f١١٢٩f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f١١٣٠g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f١١٣٠g.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f١١٢٥b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f١١٢٨e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f١١٢٩f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f١١٣٠g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f١١٢٦c = findViewById(R.id.action_bar);
        this.f١١٢٧d = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f١١٢٤a && !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        Drawable drawable;
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f١١٢٥b;
        boolean z12 = true;
        boolean z13 = false;
        if (view != null && view.getVisibility() != 8) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i14 = layoutParams.bottomMargin;
            view.layout(i10, measuredHeight2 - i14, i12, measuredHeight - i14);
        }
        if (this.f١١٣١h) {
            Drawable drawable2 = this.f١١٣٠g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z12 = false;
            }
        } else {
            if (this.f١١٢٨e != null) {
                if (this.f١١٢٦c.getVisibility() == 0) {
                    this.f١١٢٨e.setBounds(this.f١١٢٦c.getLeft(), this.f١١٢٦c.getTop(), this.f١١٢٦c.getRight(), this.f١١٢٦c.getBottom());
                } else {
                    View view2 = this.f١١٢٧d;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.f١١٢٨e.setBounds(this.f١١٢٧d.getLeft(), this.f١١٢٧d.getTop(), this.f١١٢٧d.getRight(), this.f١١٢٧d.getBottom());
                    } else {
                        this.f١١٢٨e.setBounds(0, 0, 0, 0);
                    }
                }
                z13 = true;
            }
            this.f١١٣٢i = z11;
            if (z11 && (drawable = this.f١١٢٩f) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z12 = z13;
            }
        }
        if (z12) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        if (this.f١١٢٦c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i14 = this.f١١٣٣j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i14, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f١١٢٦c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        View view = this.f١١٢٥b;
        if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
            if (!b(this.f١١٢٦c)) {
                i12 = a(this.f١١٢٦c);
            } else if (!b(this.f١١٢٧d)) {
                i12 = a(this.f١١٢٧d);
            } else {
                i12 = 0;
            }
            if (mode == Integer.MIN_VALUE) {
                i13 = View.MeasureSpec.getSize(i11);
            } else {
                i13 = Integer.MAX_VALUE;
            }
            setMeasuredDimension(getMeasuredWidth(), Math.min(i12 + a(this.f١١٢٥b), i13));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f١١٢٨e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f١١٢٨e);
        }
        this.f١١٢٨e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f١١٢٦c;
            if (view != null) {
                this.f١١٢٨e.setBounds(view.getLeft(), this.f١١٢٦c.getTop(), this.f١١٢٦c.getRight(), this.f١١٢٦c.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f١١٣١h ? !(this.f١١٢٨e != null || this.f١١٢٩f != null) : this.f١١٣٠g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f١١٣٠g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f١١٣٠g);
        }
        this.f١١٣٠g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f١١٣١h && (drawable2 = this.f١١٣٠g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f١١٣١h ? !(this.f١١٢٨e != null || this.f١١٢٩f != null) : this.f١١٣٠g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f١١٢٩f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f١١٢٩f);
        }
        this.f١١٢٩f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f١١٣٢i && (drawable2 = this.f١١٢٩f) != null) {
                drawable2.setBounds(this.f١١٢٥b.getLeft(), this.f١١٢٥b.getTop(), this.f١١٢٥b.getRight(), this.f١١٢٥b.getBottom());
            }
        }
        boolean z10 = false;
        if (!this.f١١٣١h ? !(this.f١١٢٨e != null || this.f١١٢٩f != null) : this.f١١٣٠g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        a.a(this);
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f١١٢٥b;
        if (view != null) {
            removeView(view);
        }
        this.f١١٢٥b = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z10) {
        int i10;
        this.f١١٢٤a = z10;
        if (z10) {
            i10 = 393216;
        } else {
            i10 = 262144;
        }
        setDescendantFocusability(i10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        boolean z10;
        super.setVisibility(i10);
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable = this.f١١٢٨e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f١١٢٩f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f١١٣٠g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if ((drawable == this.f١١٢٨e && !this.f١١٣١h) || ((drawable == this.f١١٢٩f && this.f١١٣٢i) || ((drawable == this.f١١٣٠g && this.f١١٣١h) || super.verifyDrawable(drawable)))) {
            return true;
        }
        return false;
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new androidx.appcompat.widget.a(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f١١٢٨e = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f١١٢٩f = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f١١٣٣j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == R.id.split_action_bar) {
            this.f١١٣١h = true;
            this.f١١٣٠g = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f١١٣١h ? this.f١١٢٨e != null || this.f١١٢٩f != null : this.f١١٣٠g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
