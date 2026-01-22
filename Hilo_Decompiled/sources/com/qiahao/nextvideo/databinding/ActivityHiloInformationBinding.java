package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityHiloInformationBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final LinearLayoutCompat linearLayout;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityHiloInformationBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.linearLayout = linearLayoutCompat;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.title = appCompatTextView;
    }

    public static ActivityHiloInformationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityHiloInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityHiloInformationBinding bind(View view, Object obj) {
        return (ActivityHiloInformationBinding) ViewDataBinding.bind(obj, view, R.layout.activity_hilo_information);
    }

    @Deprecated
    public static ActivityHiloInformationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityHiloInformationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_hilo_information, viewGroup, z, obj);
    }

    public static ActivityHiloInformationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityHiloInformationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityHiloInformationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_hilo_information, (ViewGroup) null, false, obj);
    }
}
