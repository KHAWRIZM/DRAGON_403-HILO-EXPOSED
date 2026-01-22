package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityFamilyApplicationBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final TextView title;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityFamilyApplicationBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, TextView textView, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.title = textView;
        this.toolbar = toolbar;
    }

    public static ActivityFamilyApplicationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityFamilyApplicationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityFamilyApplicationBinding bind(View view, Object obj) {
        return (ActivityFamilyApplicationBinding) ViewDataBinding.bind(obj, view, R.layout.activity_family_application);
    }

    @Deprecated
    public static ActivityFamilyApplicationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFamilyApplicationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_application, viewGroup, z, obj);
    }

    public static ActivityFamilyApplicationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityFamilyApplicationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFamilyApplicationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_application, (ViewGroup) null, false, obj);
    }
}
