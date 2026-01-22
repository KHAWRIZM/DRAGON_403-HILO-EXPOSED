package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentSelectCountryBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final IncludeTitleBinding titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSelectCountryBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.titleBar = includeTitleBinding;
    }

    public static FragmentSelectCountryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentSelectCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentSelectCountryBinding bind(View view, Object obj) {
        return (FragmentSelectCountryBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_select_country);
    }

    @Deprecated
    public static FragmentSelectCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentSelectCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_select_country, viewGroup, z, obj);
    }

    public static FragmentSelectCountryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentSelectCountryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentSelectCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_select_country, (ViewGroup) null, false, obj);
    }
}
