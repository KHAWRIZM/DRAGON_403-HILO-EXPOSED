package com.zhpan.bannerview;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class f extends RecyclerView.ViewHolder {
    private final SparseArray a;

    public f(View view) {
        super(view);
        this.a = new SparseArray();
    }

    public View a(int i) {
        View view = (View) this.a.get(i);
        if (view == null) {
            View findViewById = ((RecyclerView.ViewHolder) this).itemView.findViewById(i);
            this.a.put(i, findViewById);
            return findViewById;
        }
        return view;
    }
}
