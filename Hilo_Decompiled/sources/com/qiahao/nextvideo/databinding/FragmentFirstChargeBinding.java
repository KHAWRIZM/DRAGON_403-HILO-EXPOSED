package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentFirstChargeBinding extends ViewDataBinding {
    public final TextView allDiamond;
    public final TextView bonus;
    public final TextView content;
    public final ImageView image;
    public final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentFirstChargeBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, ImageView imageView, RecyclerView recyclerView) {
        super(obj, view, i);
        this.allDiamond = textView;
        this.bonus = textView2;
        this.content = textView3;
        this.image = imageView;
        this.recyclerView = recyclerView;
    }

    public static FragmentFirstChargeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentFirstChargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentFirstChargeBinding bind(View view, Object obj) {
        return (FragmentFirstChargeBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_first_charge);
    }

    @Deprecated
    public static FragmentFirstChargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentFirstChargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_first_charge, viewGroup, z, obj);
    }

    public static FragmentFirstChargeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentFirstChargeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentFirstChargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_first_charge, (ViewGroup) null, false, obj);
    }
}
