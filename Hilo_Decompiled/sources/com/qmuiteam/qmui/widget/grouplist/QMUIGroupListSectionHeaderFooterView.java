package com.qmuiteam.qmui.widget.grouplist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import ic.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIGroupListSectionHeaderFooterView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private TextView f١٣١٧٤a;

    public QMUIGroupListSectionHeaderFooterView(Context context) {
        this(context, null, R.attr.QMUIGroupListSectionViewStyle);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.qmui_group_list_section_layout, (ViewGroup) this, true);
        setGravity(80);
        this.f١٣١٧٤a = (TextView) findViewById(R.id.group_list_section_header_textView);
    }

    public TextView getTextView() {
        return this.f١٣١٧٤a;
    }

    public void setText(CharSequence charSequence) {
        if (g.f(charSequence)) {
            this.f١٣١٧٤a.setVisibility(8);
        } else {
            this.f١٣١٧٤a.setVisibility(0);
        }
        this.f١٣١٧٤a.setText(charSequence);
    }

    public void setTextGravity(int i10) {
        this.f١٣١٧٤a.setGravity(i10);
    }

    public QMUIGroupListSectionHeaderFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIGroupListSectionViewStyle);
    }

    public QMUIGroupListSectionHeaderFooterView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context);
    }
}
