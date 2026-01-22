package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class HiloMedalItemBinding extends ViewDataBinding {
    public final ImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMedalItemBinding(Object obj, View view, int i10, ImageView imageView) {
        super(obj, view, i10);
        this.image = imageView;
    }

    public static HiloMedalItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMedalItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static HiloMedalItemBinding bind(View view, Object obj) {
        return (HiloMedalItemBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_medal_item);
    }

    @Deprecated
    public static HiloMedalItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (HiloMedalItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_medal_item, viewGroup, z10, obj);
    }

    public static HiloMedalItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMedalItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMedalItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_medal_item, null, false, obj);
    }
}
