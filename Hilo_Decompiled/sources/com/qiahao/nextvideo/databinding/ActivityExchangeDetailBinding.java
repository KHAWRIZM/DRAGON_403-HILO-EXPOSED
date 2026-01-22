package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityExchangeDetailBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final IncludeTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityExchangeDetailBinding(Object obj, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.titleLayout = includeTitleBinding;
    }

    public static ActivityExchangeDetailBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityExchangeDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityExchangeDetailBinding bind(View view, Object obj) {
        return (ActivityExchangeDetailBinding) ViewDataBinding.bind(obj, view, R.layout.activity_exchange_detail);
    }

    @Deprecated
    public static ActivityExchangeDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityExchangeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exchange_detail, viewGroup, z, obj);
    }

    public static ActivityExchangeDetailBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityExchangeDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityExchangeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exchange_detail, (ViewGroup) null, false, obj);
    }
}
