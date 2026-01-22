package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LayoutDiscoverBroadCastBinding extends ViewDataBinding {
    public final FrameLayout parentContent;
    public final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutDiscoverBroadCastBinding(Object obj, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView) {
        super(obj, view, i);
        this.parentContent = frameLayout;
        this.recyclerView = recyclerView;
    }

    public static LayoutDiscoverBroadCastBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LayoutDiscoverBroadCastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static LayoutDiscoverBroadCastBinding bind(View view, Object obj) {
        return (LayoutDiscoverBroadCastBinding) ViewDataBinding.bind(obj, view, R.layout.layout_discover_broad_cast);
    }

    @Deprecated
    public static LayoutDiscoverBroadCastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutDiscoverBroadCastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_discover_broad_cast, viewGroup, z, obj);
    }

    public static LayoutDiscoverBroadCastBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LayoutDiscoverBroadCastBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutDiscoverBroadCastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_discover_broad_cast, (ViewGroup) null, false, obj);
    }
}
