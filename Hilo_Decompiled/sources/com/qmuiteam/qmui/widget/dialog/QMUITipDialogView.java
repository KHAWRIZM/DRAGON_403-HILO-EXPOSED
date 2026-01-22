package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import dc.d;
import dc.f;
import ic.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUITipDialogView extends QMUILinearLayout {

    /* renamed from: c, reason: collision with root package name */
    private final int f١٣١٥٩c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٣١٦٠d;

    /* renamed from: e, reason: collision with root package name */
    private final int f١٣١٦١e;

    public QMUITipDialogView(Context context) {
        super(context);
        setOrientation(1);
        setGravity(1);
        int e10 = i.e(context, R.attr.qmui_tip_dialog_radius);
        int i10 = R.attr.qmui_skin_support_tip_dialog_bg;
        Drawable f10 = i.f(context, i10);
        int e11 = i.e(context, R.attr.qmui_tip_dialog_padding_horizontal);
        int e12 = i.e(context, R.attr.qmui_tip_dialog_padding_vertical);
        setBackground(f10);
        setPadding(e11, e12, e11, e12);
        setRadius(e10);
        f a10 = f.a();
        a10.b(i10);
        d.g(this, a10);
        a10.f();
        this.f١٣١٥٩c = i.e(context, R.attr.qmui_tip_dialog_max_width);
        this.f١٣١٦٠d = i.e(context, R.attr.qmui_tip_dialog_min_width);
        this.f١٣١٦١e = i.e(context, R.attr.qmui_tip_dialog_min_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.layout.QMUILinearLayout, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int i12 = this.f١٣١٥٩c;
        if (size > i12) {
            i10 = View.MeasureSpec.makeMeasureSpec(i12, mode);
        }
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        int i13 = this.f١٣١٦٠d;
        boolean z11 = true;
        if (measuredWidth < i13) {
            i10 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
            z10 = true;
        } else {
            z10 = false;
        }
        int measuredHeight = getMeasuredHeight();
        int i14 = this.f١٣١٦١e;
        if (measuredHeight < i14) {
            i11 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        } else {
            z11 = z10;
        }
        if (z11) {
            super.onMeasure(i10, i11);
        }
    }
}
