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
public abstract class ActivityRedEnvelopeRecordBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final IncludeTitleBinding titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityRedEnvelopeRecordBinding(Object obj, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, IncludeTitleBinding includeTitleBinding) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.titleBar = includeTitleBinding;
    }

    public static ActivityRedEnvelopeRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityRedEnvelopeRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityRedEnvelopeRecordBinding bind(View view, Object obj) {
        return (ActivityRedEnvelopeRecordBinding) ViewDataBinding.bind(obj, view, R.layout.activity_red_envelope_record);
    }

    @Deprecated
    public static ActivityRedEnvelopeRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRedEnvelopeRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_red_envelope_record, viewGroup, z, obj);
    }

    public static ActivityRedEnvelopeRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityRedEnvelopeRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRedEnvelopeRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_red_envelope_record, (ViewGroup) null, false, obj);
    }
}
