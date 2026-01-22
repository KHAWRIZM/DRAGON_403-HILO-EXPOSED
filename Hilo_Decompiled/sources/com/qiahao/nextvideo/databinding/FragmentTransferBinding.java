package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentTransferBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTransferBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
    }

    public static FragmentTransferBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentTransferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentTransferBinding bind(View view, Object obj) {
        return (FragmentTransferBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_transfer);
    }

    @Deprecated
    public static FragmentTransferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTransferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_transfer, viewGroup, z, obj);
    }

    public static FragmentTransferBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentTransferBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTransferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_transfer, (ViewGroup) null, false, obj);
    }
}
