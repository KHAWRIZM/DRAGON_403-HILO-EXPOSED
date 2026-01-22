package com.qhqc.core.basic.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.qhqc.core.basic.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicDialogMenuSelectBinding implements a {
    public final RecyclerView mRV;
    public final TextView mTvCancel;
    private final LinearLayoutCompat rootView;

    private BasicDialogMenuSelectBinding(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayoutCompat;
        this.mRV = recyclerView;
        this.mTvCancel = textView;
    }

    public static BasicDialogMenuSelectBinding bind(View view) {
        int i10 = R.id.mRV;
        RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
        if (recyclerView != null) {
            i10 = R.id.mTvCancel;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                return new BasicDialogMenuSelectBinding((LinearLayoutCompat) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static BasicDialogMenuSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BasicDialogMenuSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.basic_dialog_menu_select, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }
}
