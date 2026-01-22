package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellConnectionLogBinding extends ViewDataBinding {
    public final AppCompatTextView dateTextView;
    public final AppCompatTextView durationTextView;
    public final AppCompatTextView frequencyTextView;
    public final AppCompatTextView likeTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellConnectionLogBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        super(obj, view, i);
        this.dateTextView = appCompatTextView;
        this.durationTextView = appCompatTextView2;
        this.frequencyTextView = appCompatTextView3;
        this.likeTextView = appCompatTextView4;
    }

    public static CellConnectionLogBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellConnectionLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellConnectionLogBinding bind(View view, Object obj) {
        return (CellConnectionLogBinding) ViewDataBinding.bind(obj, view, R.layout.cell_connection_log);
    }

    @Deprecated
    public static CellConnectionLogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellConnectionLogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_connection_log, viewGroup, z, obj);
    }

    public static CellConnectionLogBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellConnectionLogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellConnectionLogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_connection_log, (ViewGroup) null, false, obj);
    }
}
