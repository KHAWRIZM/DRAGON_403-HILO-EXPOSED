package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class LinearProgressIndicator extends BaseProgressIndicator<n> {

    /* renamed from: q, reason: collision with root package name */
    public static final int f٩٥٩١q = R.style.Widget_MaterialComponents_LinearProgressIndicator;

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }

    private void t() {
        k kVar = new k((n) this.f٩٥٧١a);
        setIndeterminateDrawable(j.w(getContext(), (n) this.f٩٥٧١a, kVar));
        setProgressDrawable(f.B(getContext(), (n) this.f٩٥٧١a, kVar));
    }

    public int getIndeterminateAnimationType() {
        return ((n) this.f٩٥٧١a).f٩٧٣٥o;
    }

    public int getIndicatorDirection() {
        return ((n) this.f٩٥٧١a).f٩٧٣٦p;
    }

    public int getTrackInnerCornerRadius() {
        return ((n) this.f٩٥٧١a).f٩٧٤٠t;
    }

    public Integer getTrackStopIndicatorPadding() {
        return ((n) this.f٩٥٧١a).f٩٧٣٩s;
    }

    public int getTrackStopIndicatorSize() {
        return ((n) this.f٩٥٧١a).f٩٧٣٨r;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        a aVar = this.f٩٥٧١a;
        n nVar = (n) aVar;
        boolean z11 = true;
        if (((n) aVar).f٩٧٣٦p != 1 && ((getLayoutDirection() != 1 || ((n) this.f٩٥٧١a).f٩٧٣٦p != 2) && (getLayoutDirection() != 0 || ((n) this.f٩٥٧١a).f٩٧٣٦p != 3))) {
            z11 = false;
        }
        nVar.f٩٧٣٧q = z11;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        int paddingLeft = i10 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i11 - (getPaddingTop() + getPaddingBottom());
        j indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        f progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void p(int i10, boolean z10) {
        a aVar = this.f٩٥٧١a;
        if (aVar != null && ((n) aVar).f٩٧٣٥o == 0 && isIndeterminate()) {
            return;
        }
        super.p(i10, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public n i(Context context, AttributeSet attributeSet) {
        return new n(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i10) {
        if (((n) this.f٩٥٧١a).f٩٧٣٥o == i10) {
            return;
        }
        if (r() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        a aVar = this.f٩٥٧١a;
        ((n) aVar).f٩٧٣٥o = i10;
        ((n) aVar).h();
        if (i10 == 0) {
            getIndeterminateDrawable().A(new l((n) this.f٩٥٧١a));
        } else {
            getIndeterminateDrawable().A(new m(getContext(), (n) this.f٩٥٧١a));
        }
        o();
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((n) this.f٩٥٧١a).h();
    }

    public void setIndicatorDirection(int i10) {
        a aVar = this.f٩٥٧١a;
        ((n) aVar).f٩٧٣٦p = i10;
        n nVar = (n) aVar;
        boolean z10 = true;
        if (i10 != 1 && ((getLayoutDirection() != 1 || ((n) this.f٩٥٧١a).f٩٧٣٦p != 2) && (getLayoutDirection() != 0 || i10 != 3))) {
            z10 = false;
        }
        nVar.f٩٧٣٧q = z10;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i10) {
        super.setTrackCornerRadius(i10);
        ((n) this.f٩٥٧١a).h();
        invalidate();
    }

    public void setTrackInnerCornerRadius(int i10) {
        a aVar = this.f٩٥٧١a;
        if (((n) aVar).f٩٧٤٠t != i10) {
            ((n) aVar).f٩٧٤٠t = Math.round(Math.min(i10, ((n) aVar).f٩٥٩٢a / 2.0f));
            a aVar2 = this.f٩٥٧١a;
            ((n) aVar2).f٩٧٤٢v = false;
            ((n) aVar2).f٩٧٤٣w = true;
            ((n) aVar2).h();
            invalidate();
        }
    }

    public void setTrackInnerCornerRadiusFraction(float f10) {
        a aVar = this.f٩٥٧١a;
        if (((n) aVar).f٩٧٤١u != f10) {
            ((n) aVar).f٩٧٤١u = Math.min(f10, 0.5f);
            a aVar2 = this.f٩٥٧١a;
            ((n) aVar2).f٩٧٤٢v = true;
            ((n) aVar2).f٩٧٤٣w = true;
            ((n) aVar2).h();
            invalidate();
        }
    }

    public void setTrackStopIndicatorPadding(Integer num) {
        if (!Objects.equals(((n) this.f٩٥٧١a).f٩٧٣٩s, num)) {
            ((n) this.f٩٥٧١a).f٩٧٣٩s = num;
            invalidate();
        }
    }

    public void setTrackStopIndicatorSize(int i10) {
        a aVar = this.f٩٥٧١a;
        if (((n) aVar).f٩٧٣٨r != i10) {
            ((n) aVar).f٩٧٣٨r = Math.min(i10, ((n) aVar).f٩٥٩٢a);
            ((n) this.f٩٥٧١a).h();
            invalidate();
        }
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, f٩٥٩١q);
        t();
        this.f٩٥٨١k = true;
    }
}
