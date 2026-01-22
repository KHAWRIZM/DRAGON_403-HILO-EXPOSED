package com.scwang.smart.refresh.classics;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import com.scwang.smart.refresh.footer.classics.R;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import tc.a;
import tc.e;
import tc.f;
import uc.c;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class ClassicsAbstract<T extends ClassicsAbstract<?>> extends SimpleComponent implements a {
    public static final int n = R.id.srl_classics_title;
    public static final int o = R.id.srl_classics_arrow;
    public static final int p = R.id.srl_classics_progress;
    protected TextView a;
    protected ImageView b;
    protected ImageView c;
    protected e d;
    protected qc.a e;
    protected qc.a f;
    protected boolean g;
    protected boolean h;
    protected int i;
    protected int j;
    protected int k;
    protected int l;
    protected int m;

    public ClassicsAbstract(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 500;
        this.k = 20;
        this.l = 20;
        this.m = 0;
        this.mSpinnerStyle = c.d;
    }

    protected ClassicsAbstract a() {
        return this;
    }

    public ClassicsAbstract b(int i) {
        this.g = true;
        this.a.setTextColor(i);
        qc.a aVar = this.e;
        if (aVar != null) {
            aVar.a(i);
            this.b.invalidateDrawable(this.e);
        }
        qc.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.a(i);
            this.c.invalidateDrawable(this.f);
        }
        return a();
    }

    public ClassicsAbstract c(int i) {
        this.h = true;
        this.i = i;
        e eVar = this.d;
        if (eVar != null) {
            eVar.f(this, i);
        }
        return a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.b;
        ImageView imageView2 = this.c;
        imageView.animate().cancel();
        imageView2.animate().cancel();
        Object drawable = this.c.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public int onFinish(f fVar, boolean z) {
        ImageView imageView = this.c;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.j;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public void onInitialized(e eVar, int i, int i2) {
        this.d = eVar;
        eVar.f(this, this.i);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.m == 0) {
            this.k = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.l = paddingBottom;
            if (this.k == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i3 = this.k;
                if (i3 == 0) {
                    i3 = wc.c.c(20.0f);
                }
                this.k = i3;
                int i4 = this.l;
                if (i4 == 0) {
                    i4 = wc.c.c(20.0f);
                }
                this.l = i4;
                setPadding(paddingLeft, this.k, paddingRight, i4);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int size = View.MeasureSpec.getSize(i2);
            int i5 = this.m;
            if (size < i5) {
                int i6 = (size - i5) / 2;
                setPadding(getPaddingLeft(), i6, getPaddingRight(), i6);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.k, getPaddingRight(), this.l);
        }
        super.onMeasure(i, i2);
        if (this.m == 0) {
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                int measuredHeight = getChildAt(i7).getMeasuredHeight();
                if (this.m < measuredHeight) {
                    this.m = measuredHeight;
                }
            }
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public void onReleased(f fVar, int i, int i2) {
        onStartAnimator(fVar, i, i2);
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public void onStartAnimator(f fVar, int i, int i2) {
        ImageView imageView = this.c;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.c.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.h) {
                c(iArr[0]);
                this.h = false;
            }
            if (!this.g) {
                if (iArr.length > 1) {
                    b(iArr[1]);
                }
                this.g = false;
            }
        }
    }
}
