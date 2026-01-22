package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.u0;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements m.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: a, reason: collision with root package name */
    i f٨٨٧a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f٨٨٨b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f٨٨٩c;

    /* renamed from: d, reason: collision with root package name */
    g.b f٨٩٠d;

    /* renamed from: e, reason: collision with root package name */
    private e0 f٨٩١e;

    /* renamed from: f, reason: collision with root package name */
    b f٨٩٢f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٨٩٣g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٨٩٤h;

    /* renamed from: i, reason: collision with root package name */
    private int f٨٩٥i;

    /* renamed from: j, reason: collision with root package name */
    private int f٨٩٦j;

    /* renamed from: k, reason: collision with root package name */
    private int f٨٩٧k;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class a extends e0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.e0
        public o b() {
            b bVar = ActionMenuItemView.this.f٨٩٢f;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.e0
        protected boolean c() {
            o b10;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f٨٩٠d;
            if (bVar == null || !bVar.c(actionMenuItemView.f٨٨٧a) || (b10 = b()) == null || !b10.isShowing()) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class b {
        public abstract o a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    private boolean l() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (i10 < 480 && ((i10 < 640 || i11 < 480) && configuration.orientation != 2)) {
            return false;
        }
        return true;
    }

    private void m() {
        CharSequence charSequence;
        CharSequence title;
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f٨٨٨b);
        if (this.f٨٨٩c != null && (!this.f٨٨٧a.B() || (!this.f٨٩٣g && !this.f٨٩٤h))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        CharSequence charSequence2 = null;
        if (z12) {
            charSequence = this.f٨٨٨b;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence contentDescription = this.f٨٨٧a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z12) {
                title = null;
            } else {
                title = this.f٨٨٧a.getTitle();
            }
            setContentDescription(title);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f٨٨٧a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z12) {
                charSequence2 = this.f٨٨٧a.getTitle();
            }
            u0.a(this, charSequence2);
            return;
        }
        u0.a(this, tooltipText);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean c() {
        return k();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean e() {
        if (k() && this.f٨٨٧a.getIcon() == null) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public void g(i iVar, int i10) {
        int i11;
        this.f٨٨٧a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.i(this));
        setId(iVar.getItemId());
        if (iVar.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f٨٩١e == null) {
            this.f٨٩١e = new a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.m.a
    public i getItemData() {
        return this.f٨٨٧a;
    }

    @Override // androidx.appcompat.view.menu.m.a
    public boolean h() {
        return true;
    }

    public boolean k() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.f٨٩٠d;
        if (bVar != null) {
            bVar.c(this.f٨٨٧a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f٨٩٣g = l();
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        boolean k10 = k();
        if (k10 && (i13 = this.f٨٩٦j) >= 0) {
            super.setPadding(i13, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i12 = Math.min(size, this.f٨٩٥i);
        } else {
            i12 = this.f٨٩٥i;
        }
        if (mode != 1073741824 && this.f٨٩٥i > 0 && measuredWidth < i12) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
        }
        if (!k10 && this.f٨٨٩c != null) {
            super.setPadding((getMeasuredWidth() - this.f٨٨٩c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e0 e0Var;
        if (this.f٨٨٧a.hasSubMenu() && (e0Var = this.f٨٩١e) != null && e0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f٨٩٤h != z10) {
            this.f٨٩٤h = z10;
            i iVar = this.f٨٨٧a;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f٨٨٩c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f٨٩٧k;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, null, null, null);
        m();
    }

    public void setItemInvoker(g.b bVar) {
        this.f٨٩٠d = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f٨٩٦j = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f٨٩٢f = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f٨٨٨b = charSequence;
        m();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f٨٩٣g = l();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i10, 0);
        this.f٨٩٥i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f٨٩٧k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f٨٩٦j = -1;
        setSaveEnabled(false);
    }
}
