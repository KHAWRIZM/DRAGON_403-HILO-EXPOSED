package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Constraints extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    c f٢٣٥٧a;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void c(AttributeSet attributeSet) {
        Log.v("Constraints", " ################# init");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public c getConstraintSet() {
        if (this.f٢٣٥٧a == null) {
            this.f٢٣٥٧a = new c();
        }
        this.f٢٣٥٧a.q(this);
        return this.f٢٣٥٧a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.b(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c(attributeSet);
        super.setVisibility(8);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends ConstraintLayout.b {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;
        public float F0;
        public float G0;
        public float H0;
        public float I0;
        public float J0;

        /* renamed from: x0, reason: collision with root package name */
        public float f٢٣٥٨x0;

        /* renamed from: y0, reason: collision with root package name */
        public boolean f٢٣٥٩y0;

        /* renamed from: z0, reason: collision with root package name */
        public float f٢٣٦٠z0;

        public a(int i10, int i11) {
            super(i10, i11);
            this.f٢٣٥٨x0 = 1.0f;
            this.f٢٣٥٩y0 = false;
            this.f٢٣٦٠z0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.A0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.B0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.C0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.G0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.H0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.I0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.J0 = DownloadProgress.UNKNOWN_PROGRESS;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f٢٣٥٨x0 = 1.0f;
            this.f٢٣٥٩y0 = false;
            this.f٢٣٦٠z0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.A0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.B0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.C0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.D0 = 1.0f;
            this.E0 = 1.0f;
            this.F0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.G0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.H0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.I0 = DownloadProgress.UNKNOWN_PROGRESS;
            this.J0 = DownloadProgress.UNKNOWN_PROGRESS;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintSet_android_alpha) {
                    this.f٢٣٥٨x0 = obtainStyledAttributes.getFloat(index, this.f٢٣٥٨x0);
                } else if (index == R.styleable.ConstraintSet_android_elevation) {
                    this.f٢٣٦٠z0 = obtainStyledAttributes.getFloat(index, this.f٢٣٦٠z0);
                    this.f٢٣٥٩y0 = true;
                } else if (index == R.styleable.ConstraintSet_android_rotationX) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == R.styleable.ConstraintSet_android_rotationY) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == R.styleable.ConstraintSet_android_rotation) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == R.styleable.ConstraintSet_android_scaleX) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == R.styleable.ConstraintSet_android_scaleY) {
                    this.E0 = obtainStyledAttributes.getFloat(index, this.E0);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotX) {
                    this.F0 = obtainStyledAttributes.getFloat(index, this.F0);
                } else if (index == R.styleable.ConstraintSet_android_transformPivotY) {
                    this.G0 = obtainStyledAttributes.getFloat(index, this.G0);
                } else if (index == R.styleable.ConstraintSet_android_translationX) {
                    this.H0 = obtainStyledAttributes.getFloat(index, this.H0);
                } else if (index == R.styleable.ConstraintSet_android_translationY) {
                    this.I0 = obtainStyledAttributes.getFloat(index, this.I0);
                } else if (index == R.styleable.ConstraintSet_android_translationZ) {
                    this.J0 = obtainStyledAttributes.getFloat(index, this.J0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
