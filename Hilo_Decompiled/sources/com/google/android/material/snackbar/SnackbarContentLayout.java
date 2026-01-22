package com.google.android.material.snackbar;

import a8.k;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f١٠٠٠٧a;

    /* renamed from: b, reason: collision with root package name */
    private Button f١٠٠٠٨b;

    /* renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f١٠٠٠٩c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٠٠١٠d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    private static void a(View view, int i10, int i11) {
        if (view.isPaddingRelative()) {
            view.setPaddingRelative(view.getPaddingStart(), i10, view.getPaddingEnd(), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    private boolean b(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f١٠٠٠٧a.getPaddingTop() == i11 && this.f١٠٠٠٧a.getPaddingBottom() == i12) {
            return z10;
        }
        a(this.f١٠٠٠٧a, i11, i12);
        return true;
    }

    public Button getActionView() {
        return this.f١٠٠٠٨b;
    }

    public TextView getMessageView() {
        return this.f١٠٠٠٧a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f١٠٠٠٧a = (TextView) findViewById(R.id.snackbar_text);
        this.f١٠٠٠٨b = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        boolean z10;
        super.onMeasure(i10, i11);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.f١٠٠٠٧a.getLayout();
        if (layout != null && layout.getLineCount() > 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && this.f١٠٠١٠d > 0 && this.f١٠٠٠٨b.getMeasuredWidth() > this.f١٠٠١٠d) {
            if (!b(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                return;
            }
        } else {
            if (!z10) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!b(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f١٠٠١٠d = i10;
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٠٠٠٩c = k.g(context, R.attr.motionEasingEmphasizedInterpolator, p7.a.f١٦٩٤٨b);
    }
}
