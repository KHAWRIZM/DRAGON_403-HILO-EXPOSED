package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class HiloGradeBinding extends ViewDataBinding {
    public final ImageView bg;
    public final AppCompatTextView text;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloGradeBinding(Object obj, View view, int i10, ImageView imageView, AppCompatTextView appCompatTextView) {
        super(obj, view, i10);
        this.bg = imageView;
        this.text = appCompatTextView;
    }

    public static HiloGradeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloGradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static HiloGradeBinding bind(View view, Object obj) {
        return (HiloGradeBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_grade);
    }

    @Deprecated
    public static HiloGradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (HiloGradeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_grade, viewGroup, z10, obj);
    }

    public static HiloGradeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloGradeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloGradeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_grade, null, false, obj);
    }
}
