package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloGameFragmentBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloGameFragmentBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
    }

    public static HiloGameFragmentBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloGameFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloGameFragmentBinding bind(View view, Object obj) {
        return (HiloGameFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_game_fragment);
    }

    @Deprecated
    public static HiloGameFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloGameFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_game_fragment, viewGroup, z, obj);
    }

    public static HiloGameFragmentBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloGameFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloGameFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_game_fragment, (ViewGroup) null, false, obj);
    }
}
