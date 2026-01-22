package com.qhqc.core.basic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qhqc.core.basic.R;
import j3.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicDialogMenuSelectItemBinding implements a {
    public final TextView mTvMenu;
    private final TextView rootView;

    private BasicDialogMenuSelectItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.mTvMenu = textView2;
    }

    public static BasicDialogMenuSelectItemBinding bind(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new BasicDialogMenuSelectItemBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    public static BasicDialogMenuSelectItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BasicDialogMenuSelectItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.basic_dialog_menu_select_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public TextView getRoot() {
        return this.rootView;
    }
}
