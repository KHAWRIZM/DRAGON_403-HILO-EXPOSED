package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CircularProgressIndicator extends BaseProgressIndicator<e> {

    /* renamed from: q, reason: collision with root package name */
    public static final int f٩٥٩٠q = R.style.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(Context context) {
        this(context, null);
    }

    private void t() {
        b bVar = new b((e) this.f٩٥٧١a);
        setIndeterminateDrawable(j.v(getContext(), (e) this.f٩٥٧١a, bVar));
        setProgressDrawable(f.A(getContext(), (e) this.f٩٥٧١a, bVar));
    }

    public int getIndeterminateAnimationType() {
        return ((e) this.f٩٥٧١a).f٩٦٤٨o;
    }

    public int getIndicatorDirection() {
        return ((e) this.f٩٥٧١a).f٩٦٥١r;
    }

    public int getIndicatorInset() {
        return ((e) this.f٩٥٧١a).f٩٦٥٠q;
    }

    public int getIndicatorSize() {
        return ((e) this.f٩٥٧١a).f٩٦٤٩p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public e i(Context context, AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i10) {
        i cVar;
        if (((e) this.f٩٥٧١a).f٩٦٤٨o == i10) {
            return;
        }
        if (r() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        a aVar = this.f٩٥٧١a;
        ((e) aVar).f٩٦٤٨o = i10;
        ((e) aVar).h();
        if (i10 == 1) {
            cVar = new d(getContext(), (e) this.f٩٥٧١a);
        } else {
            cVar = new c((e) this.f٩٥٧١a);
        }
        getIndeterminateDrawable().A(cVar);
        o();
        invalidate();
    }

    public void setIndicatorDirection(int i10) {
        ((e) this.f٩٥٧١a).f٩٦٥١r = i10;
        invalidate();
    }

    public void setIndicatorInset(int i10) {
        a aVar = this.f٩٥٧١a;
        if (((e) aVar).f٩٦٥٠q != i10) {
            ((e) aVar).f٩٦٥٠q = i10;
            invalidate();
        }
    }

    public void setIndicatorSize(int i10) {
        int max = Math.max(i10, getTrackThickness() * 2);
        a aVar = this.f٩٥٧١a;
        if (((e) aVar).f٩٦٤٩p != max) {
            ((e) aVar).f٩٦٤٩p = max;
            ((e) aVar).h();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i10) {
        super.setTrackThickness(i10);
        ((e) this.f٩٥٧١a).h();
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, f٩٥٩٠q);
        t();
        this.f٩٥٨١k = true;
    }
}
