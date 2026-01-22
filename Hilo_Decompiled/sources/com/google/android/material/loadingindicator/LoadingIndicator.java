package com.google.android.material.loadingindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.R;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class LoadingIndicator extends View implements Drawable.Callback {

    /* renamed from: c, reason: collision with root package name */
    static final int f٩٣٦٧c = R.style.Widget_Material3_LoadingIndicator;

    /* renamed from: a, reason: collision with root package name */
    private final b f٩٣٦٨a;

    /* renamed from: b, reason: collision with root package name */
    private final d f٩٣٦٩b;

    public LoadingIndicator(Context context) {
        this(context, null);
    }

    boolean a() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() != 0) {
                    return false;
                }
                return true;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    boolean b() {
        if (isAttachedToWindow() && getWindowVisibility() == 0 && a()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return ProgressBar.class.getName();
    }

    public int getContainerColor() {
        return this.f٩٣٦٩b.f٩٤٠٢f;
    }

    public int getContainerHeight() {
        return this.f٩٣٦٩b.f٩٤٠٠d;
    }

    public int getContainerWidth() {
        return this.f٩٣٦٩b.f٩٣٩٩c;
    }

    public b getDrawable() {
        return this.f٩٣٦٨a;
    }

    public int[] getIndicatorColor() {
        return this.f٩٣٦٩b.f٩٤٠١e;
    }

    public int getIndicatorSize() {
        return this.f٩٣٦٩b.f٩٣٩٨b;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        this.f٩٣٦٨a.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        c c10 = this.f٩٣٦٨a.c();
        int e10 = c10.e() + getPaddingLeft() + getPaddingRight();
        int d10 = c10.d() + getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(size, e10), 1073741824);
        } else if (mode == 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(e10, 1073741824);
        }
        if (mode2 == Integer.MIN_VALUE) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(size2, d10), 1073741824);
        } else if (mode2 == 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(d10, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f٩٣٦٨a.setBounds(0, 0, i10, i11);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        boolean z10;
        super.onVisibilityChanged(view, i10);
        b bVar = this.f٩٣٦٨a;
        boolean b10 = b();
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        bVar.f(b10, false, z10);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        boolean z10;
        super.onWindowVisibilityChanged(i10);
        b bVar = this.f٩٣٦٨a;
        boolean b10 = b();
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        bVar.f(b10, false, z10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(b8.a aVar) {
        this.f٩٣٦٨a.f٩٣٨١a = aVar;
    }

    public void setContainerColor(int i10) {
        d dVar = this.f٩٣٦٩b;
        if (dVar.f٩٤٠٢f != i10) {
            dVar.f٩٤٠٢f = i10;
            invalidate();
        }
    }

    public void setContainerHeight(int i10) {
        d dVar = this.f٩٣٦٩b;
        if (dVar.f٩٤٠٠d != i10) {
            dVar.f٩٤٠٠d = i10;
            requestLayout();
            invalidate();
        }
    }

    public void setContainerWidth(int i10) {
        d dVar = this.f٩٣٦٩b;
        if (dVar.f٩٣٩٩c != i10) {
            dVar.f٩٣٩٩c = i10;
            requestLayout();
            invalidate();
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{v7.a.b(getContext(), androidx.appcompat.R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.f٩٣٦٩b.f٩٤٠١e = iArr;
            this.f٩٣٦٨a.b().h();
            invalidate();
        }
    }

    public void setIndicatorSize(int i10) {
        d dVar = this.f٩٣٦٩b;
        if (dVar.f٩٣٩٨b != i10) {
            dVar.f٩٣٩٨b = i10;
            requestLayout();
            invalidate();
        }
    }

    public LoadingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.loadingIndicatorStyle);
    }

    public LoadingIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, f٩٣٦٧c), attributeSet, i10);
        Context context2 = getContext();
        b a10 = b.a(context2, new d(context2, attributeSet, i10));
        this.f٩٣٦٨a = a10;
        a10.setCallback(this);
        this.f٩٣٦٩b = a10.c().f٩٣٩١a;
        setAnimatorDurationScaleProvider(new b8.a());
    }
}
