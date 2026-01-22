package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;
import dc.d;
import fc.b;
import ic.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIBottomSheetGridItemView extends QMUIConstraintLayout {

    /* renamed from: c, reason: collision with root package name */
    protected AppCompatImageView f١٣١٢٦c;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f١٣١٢٧d;

    /* renamed from: e, reason: collision with root package name */
    protected Object f١٣١٢٨e;

    public QMUIBottomSheetGridItemView(Context context) {
        this(context, null);
    }

    public Object getModelTag() {
        return this.f١٣١٢٨e;
    }

    protected AppCompatImageView o(Context context) {
        return new AppCompatImageView(context);
    }

    protected TextView p(Context context) {
        return new QMUISpanTouchFixTextView(context);
    }

    public QMUIBottomSheetGridItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIBottomSheetGridItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setChangeAlphaWhenPress(true);
        setPadding(0, i.e(context, R.attr.qmui_bottom_sheet_grid_item_padding_top), 0, i.e(context, R.attr.qmui_bottom_sheet_grid_item_padding_bottom));
        AppCompatImageView o10 = o(context);
        this.f١٣١٢٦c = o10;
        o10.setId(View.generateViewId());
        this.f١٣١٢٦c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int e10 = i.e(context, R.attr.qmui_bottom_sheet_grid_item_icon_size);
        ConstraintLayout.b bVar = new ConstraintLayout.b(e10, e10);
        bVar.f٢٣٠٧e = 0;
        bVar.f٢٣١٣h = 0;
        bVar.f٢٣١٥i = 0;
        addView(this.f١٣١٢٦c, bVar);
        TextView p10 = p(context);
        this.f١٣١٢٧d = p10;
        p10.setId(View.generateViewId());
        b bVar2 = new b();
        bVar2.a("textColor", R.attr.qmui_skin_support_bottom_sheet_grid_item_text_color);
        i.a(this.f١٣١٢٧d, R.attr.qmui_bottom_sheet_grid_item_text_style);
        d.f(this.f١٣١٢٧d, bVar2);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(-2, -2);
        bVar3.f٢٣٠٧e = 0;
        bVar3.f٢٣١٣h = 0;
        bVar3.f٢٣١٧j = this.f١٣١٢٦c.getId();
        ((ViewGroup.MarginLayoutParams) bVar3).topMargin = i.e(context, R.attr.qmui_bottom_sheet_grid_item_text_margin_top);
        addView(this.f١٣١٢٧d, bVar3);
    }
}
