package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class HiloMedalViewBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMedalViewBinding(Object obj, View view, int i10, RecyclerView recyclerView) {
        super(obj, view, i10);
        this.recyclerView = recyclerView;
    }

    public static HiloMedalViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMedalViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static HiloMedalViewBinding bind(View view, Object obj) {
        return (HiloMedalViewBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_medal_view);
    }

    @Deprecated
    public static HiloMedalViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (HiloMedalViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_medal_view, viewGroup, z10, obj);
    }

    public static HiloMedalViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMedalViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMedalViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_medal_view, null, false, obj);
    }
}
