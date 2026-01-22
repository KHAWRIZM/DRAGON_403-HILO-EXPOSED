package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIPriorityLinearLayout;
import dc.d;
import dc.f;
import ic.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIBottomSheetRootLayout extends QMUIPriorityLinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private final int f١٣١٣٨e;

    /* renamed from: f, reason: collision with root package name */
    private final float f١٣١٣٩f;

    /* renamed from: g, reason: collision with root package name */
    private final int f١٣١٤٠g;

    public QMUIBottomSheetRootLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.layout.QMUIPriorityLinearLayout, com.qmuiteam.qmui.layout.QMUILinearLayout, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int i12 = this.f١٣١٤٠g;
        if (size > i12) {
            i10 = View.MeasureSpec.makeMeasureSpec(i12, mode);
        }
        int size2 = View.MeasureSpec.getSize(i11);
        if (size2 >= this.f١٣١٣٨e) {
            i11 = View.MeasureSpec.makeMeasureSpec((int) (size2 * this.f١٣١٣٩f), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
    }

    public QMUIBottomSheetRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        int i10 = R.attr.qmui_skin_support_bottom_sheet_bg;
        setBackground(i.f(context, i10));
        f a10 = f.a();
        a10.b(i10);
        d.g(this, a10);
        a10.f();
        int e10 = i.e(context, R.attr.qmui_bottom_sheet_radius);
        if (e10 > 0) {
            e(e10, 3);
        }
        this.f١٣١٣٨e = i.e(context, R.attr.qmui_bottom_sheet_use_percent_min_height);
        this.f١٣١٣٩f = i.i(context, R.attr.qmui_bottom_sheet_height_percent);
        this.f١٣١٤٠g = i.e(context, R.attr.qmui_bottom_sheet_max_width);
    }
}
