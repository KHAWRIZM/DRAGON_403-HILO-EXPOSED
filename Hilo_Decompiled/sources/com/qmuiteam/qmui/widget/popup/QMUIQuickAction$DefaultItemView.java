package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import ic.i;
import ic.k;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIQuickAction$DefaultItemView extends QMUIQuickAction$ItemView {

    /* renamed from: c, reason: collision with root package name */
    private AppCompatImageView f١٣١٧٨c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f١٣١٧٩d;

    public QMUIQuickAction$DefaultItemView(Context context) {
        this(context, null);
    }

    public QMUIQuickAction$DefaultItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int e10 = i.e(context, R.attr.qmui_quick_action_item_padding_hor);
        int e11 = i.e(context, R.attr.qmui_quick_action_item_padding_ver);
        setPadding(e10, e11, e10, e11);
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        this.f١٣١٧٨c = appCompatImageView;
        appCompatImageView.setId(k.b());
        TextView textView = new TextView(context);
        this.f١٣١٧٩d = textView;
        textView.setId(k.b());
        this.f١٣١٧٩d.setTextSize(10.0f);
        this.f١٣١٧٩d.setTypeface(Typeface.DEFAULT_BOLD);
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
        bVar.f٢٣٠٧e = 0;
        bVar.f٢٣١٣h = 0;
        bVar.f٢٣١٥i = 0;
        bVar.f٢٣١٩k = this.f١٣١٧٩d.getId();
        bVar.O = 2;
        addView(this.f١٣١٧٨c, bVar);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-2, -2);
        bVar2.f٢٣٠٧e = 0;
        bVar2.f٢٣١٣h = 0;
        bVar2.f٢٣١٧j = this.f١٣١٧٨c.getId();
        bVar2.f٢٣٢١l = 0;
        ((ViewGroup.MarginLayoutParams) bVar2).topMargin = i.e(context, R.attr.qmui_quick_action_item_middle_space);
        bVar2.O = 2;
        bVar2.f٢٣٤٥x = 0;
        addView(this.f١٣١٧٩d, bVar2);
    }
}
