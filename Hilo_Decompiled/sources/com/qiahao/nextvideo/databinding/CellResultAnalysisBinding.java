package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellResultAnalysisBinding extends ViewDataBinding {
    /* JADX INFO: Access modifiers changed from: protected */
    public CellResultAnalysisBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static CellResultAnalysisBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellResultAnalysisBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellResultAnalysisBinding bind(View view, Object obj) {
        return (CellResultAnalysisBinding) ViewDataBinding.bind(obj, view, R.layout.cell_result_analysis);
    }

    @Deprecated
    public static CellResultAnalysisBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellResultAnalysisBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_result_analysis, viewGroup, z, obj);
    }

    public static CellResultAnalysisBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellResultAnalysisBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellResultAnalysisBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_result_analysis, (ViewGroup) null, false, obj);
    }
}
