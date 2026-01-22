package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qiahao.nextvideo.R;
import j3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CellRowIconTitleBinding implements a {
    private final LinearLayout rootView;

    private CellRowIconTitleBinding(LinearLayout linearLayout) {
        this.rootView = linearLayout;
    }

    public static CellRowIconTitleBinding bind(View view) {
        if (view != null) {
            return new CellRowIconTitleBinding((LinearLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static CellRowIconTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CellRowIconTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cell_row_icon_title, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
