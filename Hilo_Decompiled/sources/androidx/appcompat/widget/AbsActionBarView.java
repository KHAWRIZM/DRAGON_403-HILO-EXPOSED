package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.view.d1;
import androidx.core.view.l1;
import androidx.core.view.m1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class AbsActionBarView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    protected final a f١١١٣a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f١١١٤b;

    /* renamed from: c, reason: collision with root package name */
    protected ActionMenuView f١١١٥c;

    /* renamed from: d, reason: collision with root package name */
    protected ActionMenuPresenter f١١١٦d;

    /* renamed from: e, reason: collision with root package name */
    protected int f١١١٧e;

    /* renamed from: f, reason: collision with root package name */
    protected l1 f١١١٨f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١١١٩g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f١١٢٠h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    protected class a implements m1 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f١١٢١a = false;

        /* renamed from: b, reason: collision with root package name */
        int f١١٢٢b;

        protected a() {
        }

        public a a(l1 l1Var, int i10) {
            AbsActionBarView.this.f١١١٨f = l1Var;
            this.f١١٢٢b = i10;
            return this;
        }

        @Override // androidx.core.view.m1
        public void onAnimationCancel(View view) {
            this.f١١٢١a = true;
        }

        @Override // androidx.core.view.m1
        public void onAnimationEnd(View view) {
            if (this.f١١٢١a) {
                return;
            }
            AbsActionBarView absActionBarView = AbsActionBarView.this;
            absActionBarView.f١١١٨f = null;
            AbsActionBarView.super.setVisibility(this.f١١٢٢b);
        }

        @Override // androidx.core.view.m1
        public void onAnimationStart(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.f١١٢١a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsActionBarView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١١١٣a = new a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f١١١٤b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f١١١٤b = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        if (z10) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public l1 f(int i10, long j10) {
        l1 l1Var = this.f١١١٨f;
        if (l1Var != null) {
            l1Var.c();
        }
        if (i10 == 0) {
            if (getVisibility() != 0) {
                setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
            }
            l1 b10 = d1.e(this).b(1.0f);
            b10.f(j10);
            b10.h(this.f١١١٣a.a(b10, i10));
            return b10;
        }
        l1 b11 = d1.e(this).b(DownloadProgress.UNKNOWN_PROGRESS);
        b11.f(j10);
        b11.h(this.f١١١٣a.a(b11, i10));
        return b11;
    }

    public int getAnimatedVisibility() {
        if (this.f١١١٨f != null) {
            return this.f١١١٣a.f١١٢٢b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f١١١٧e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f١١١٦d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.I(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f١١٢٠h = false;
        }
        if (!this.f١١٢٠h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f١١٢٠h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f١١٢٠h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f١١١٩g = false;
        }
        if (!this.f١١١٩g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f١١١٩g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f١١١٩g = false;
        }
        return true;
    }

    public void setContentHeight(int i10) {
        this.f١١١٧e = i10;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            l1 l1Var = this.f١١١٨f;
            if (l1Var != null) {
                l1Var.c();
            }
            super.setVisibility(i10);
        }
    }
}
