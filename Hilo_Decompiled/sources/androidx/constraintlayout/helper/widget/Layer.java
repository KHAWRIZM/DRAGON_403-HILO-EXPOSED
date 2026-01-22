package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import c2.e;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Layer extends ConstraintHelper {
    private boolean A;

    /* renamed from: j, reason: collision with root package name */
    private float f١٨٠٩j;

    /* renamed from: k, reason: collision with root package name */
    private float f١٨١٠k;

    /* renamed from: l, reason: collision with root package name */
    private float f١٨١١l;

    /* renamed from: m, reason: collision with root package name */
    ConstraintLayout f١٨١٢m;

    /* renamed from: n, reason: collision with root package name */
    private float f١٨١٣n;

    /* renamed from: o, reason: collision with root package name */
    private float f١٨١٤o;

    /* renamed from: p, reason: collision with root package name */
    protected float f١٨١٥p;

    /* renamed from: q, reason: collision with root package name */
    protected float f١٨١٦q;

    /* renamed from: r, reason: collision with root package name */
    protected float f١٨١٧r;

    /* renamed from: s, reason: collision with root package name */
    protected float f١٨١٨s;

    /* renamed from: t, reason: collision with root package name */
    protected float f١٨١٩t;

    /* renamed from: u, reason: collision with root package name */
    protected float f١٨٢٠u;

    /* renamed from: v, reason: collision with root package name */
    boolean f١٨٢١v;

    /* renamed from: w, reason: collision with root package name */
    View[] f١٨٢٢w;

    /* renamed from: x, reason: collision with root package name */
    private float f١٨٢٣x;

    /* renamed from: y, reason: collision with root package name */
    private float f١٨٢٤y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f١٨٢٥z;

    public Layer(Context context) {
        super(context);
        this.f١٨٠٩j = Float.NaN;
        this.f١٨١٠k = Float.NaN;
        this.f١٨١١l = Float.NaN;
        this.f١٨١٣n = 1.0f;
        this.f١٨١٤o = 1.0f;
        this.f١٨١٥p = Float.NaN;
        this.f١٨١٦q = Float.NaN;
        this.f١٨١٧r = Float.NaN;
        this.f١٨١٨s = Float.NaN;
        this.f١٨١٩t = Float.NaN;
        this.f١٨٢٠u = Float.NaN;
        this.f١٨٢١v = true;
        this.f١٨٢٢w = null;
        this.f١٨٢٣x = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٢٤y = DownloadProgress.UNKNOWN_PROGRESS;
    }

    private void x() {
        int i10;
        if (this.f١٨١٢m == null || (i10 = this.f٢٢٨٩b) == 0) {
            return;
        }
        View[] viewArr = this.f١٨٢٢w;
        if (viewArr == null || viewArr.length != i10) {
            this.f١٨٢٢w = new View[i10];
        }
        for (int i11 = 0; i11 < this.f٢٢٨٩b; i11++) {
            this.f١٨٢٢w[i11] = this.f١٨١٢m.getViewById(this.f٢٢٨٨a[i11]);
        }
    }

    private void y() {
        double radians;
        if (this.f١٨١٢m == null) {
            return;
        }
        if (this.f١٨٢٢w == null) {
            x();
        }
        w();
        if (Float.isNaN(this.f١٨١١l)) {
            radians = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            radians = Math.toRadians(this.f١٨١١l);
        }
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f10 = this.f١٨١٣n;
        float f11 = f10 * cos;
        float f12 = this.f١٨١٤o;
        float f13 = (-f12) * sin;
        float f14 = f10 * sin;
        float f15 = f12 * cos;
        for (int i10 = 0; i10 < this.f٢٢٨٩b; i10++) {
            View view = this.f١٨٢٢w[i10];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f16 = left - this.f١٨١٥p;
            float f17 = top - this.f١٨١٦q;
            float f18 = (((f11 * f16) + (f13 * f17)) - f16) + this.f١٨٢٣x;
            float f19 = (((f16 * f14) + (f15 * f17)) - f17) + this.f١٨٢٤y;
            view.setTranslationX(f18);
            view.setTranslationY(f19);
            view.setScaleY(this.f١٨١٤o);
            view.setScaleX(this.f١٨١٣n);
            if (!Float.isNaN(this.f١٨١١l)) {
                view.setRotation(this.f١٨١١l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void i(ConstraintLayout constraintLayout) {
        h(constraintLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void n(AttributeSet attributeSet) {
        super.n(attributeSet);
        this.f٢٢٩٢e = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f١٨٢٥z = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.A = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f١٨١٢m = (ConstraintLayout) getParent();
        if (this.f١٨٢٥z || this.A) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i10 = 0; i10 < this.f٢٢٨٩b; i10++) {
                View viewById = this.f١٨١٢m.getViewById(this.f٢٢٨٨a[i10]);
                if (viewById != null) {
                    if (this.f١٨٢٥z) {
                        viewById.setVisibility(visibility);
                    }
                    if (this.A && elevation > DownloadProgress.UNKNOWN_PROGRESS) {
                        viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void q(ConstraintLayout constraintLayout) {
        x();
        this.f١٨١٥p = Float.NaN;
        this.f١٨١٦q = Float.NaN;
        e b10 = ((ConstraintLayout.b) getLayoutParams()).b();
        b10.o1(0);
        b10.P0(0);
        w();
        layout(((int) this.f١٨١٩t) - getPaddingLeft(), ((int) this.f١٨٢٠u) - getPaddingTop(), ((int) this.f١٨١٧r) + getPaddingRight(), ((int) this.f١٨١٨s) + getPaddingBottom());
        y();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void s(ConstraintLayout constraintLayout) {
        this.f١٨١٢m = constraintLayout;
        float rotation = getRotation();
        if (rotation == DownloadProgress.UNKNOWN_PROGRESS) {
            if (!Float.isNaN(this.f١٨١١l)) {
                this.f١٨١١l = rotation;
                return;
            }
            return;
        }
        this.f١٨١١l = rotation;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        g();
    }

    @Override // android.view.View
    public void setPivotX(float f10) {
        this.f١٨٠٩j = f10;
        y();
    }

    @Override // android.view.View
    public void setPivotY(float f10) {
        this.f١٨١٠k = f10;
        y();
    }

    @Override // android.view.View
    public void setRotation(float f10) {
        this.f١٨١١l = f10;
        y();
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        this.f١٨١٣n = f10;
        y();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        this.f١٨١٤o = f10;
        y();
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        this.f١٨٢٣x = f10;
        y();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        this.f١٨٢٤y = f10;
        y();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        g();
    }

    protected void w() {
        if (this.f١٨١٢m == null) {
            return;
        }
        if (!this.f١٨٢١v && !Float.isNaN(this.f١٨١٥p) && !Float.isNaN(this.f١٨١٦q)) {
            return;
        }
        if (!Float.isNaN(this.f١٨٠٩j) && !Float.isNaN(this.f١٨١٠k)) {
            this.f١٨١٦q = this.f١٨١٠k;
            this.f١٨١٥p = this.f١٨٠٩j;
            return;
        }
        View[] m10 = m(this.f١٨١٢m);
        int left = m10[0].getLeft();
        int top = m10[0].getTop();
        int right = m10[0].getRight();
        int bottom = m10[0].getBottom();
        for (int i10 = 0; i10 < this.f٢٢٨٩b; i10++) {
            View view = m10[i10];
            left = Math.min(left, view.getLeft());
            top = Math.min(top, view.getTop());
            right = Math.max(right, view.getRight());
            bottom = Math.max(bottom, view.getBottom());
        }
        this.f١٨١٧r = right;
        this.f١٨١٨s = bottom;
        this.f١٨١٩t = left;
        this.f١٨٢٠u = top;
        if (Float.isNaN(this.f١٨٠٩j)) {
            this.f١٨١٥p = (left + right) / 2;
        } else {
            this.f١٨١٥p = this.f١٨٠٩j;
        }
        if (Float.isNaN(this.f١٨١٠k)) {
            this.f١٨١٦q = (top + bottom) / 2;
        } else {
            this.f١٨١٦q = this.f١٨١٠k;
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٨٠٩j = Float.NaN;
        this.f١٨١٠k = Float.NaN;
        this.f١٨١١l = Float.NaN;
        this.f١٨١٣n = 1.0f;
        this.f١٨١٤o = 1.0f;
        this.f١٨١٥p = Float.NaN;
        this.f١٨١٦q = Float.NaN;
        this.f١٨١٧r = Float.NaN;
        this.f١٨١٨s = Float.NaN;
        this.f١٨١٩t = Float.NaN;
        this.f١٨٢٠u = Float.NaN;
        this.f١٨٢١v = true;
        this.f١٨٢٢w = null;
        this.f١٨٢٣x = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٢٤y = DownloadProgress.UNKNOWN_PROGRESS;
    }

    public Layer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٨٠٩j = Float.NaN;
        this.f١٨١٠k = Float.NaN;
        this.f١٨١١l = Float.NaN;
        this.f١٨١٣n = 1.0f;
        this.f١٨١٤o = 1.0f;
        this.f١٨١٥p = Float.NaN;
        this.f١٨١٦q = Float.NaN;
        this.f١٨١٧r = Float.NaN;
        this.f١٨١٨s = Float.NaN;
        this.f١٨١٩t = Float.NaN;
        this.f١٨٢٠u = Float.NaN;
        this.f١٨٢١v = true;
        this.f١٨٢٢w = null;
        this.f١٨٢٣x = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٢٤y = DownloadProgress.UNKNOWN_PROGRESS;
    }
}
