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
public abstract class FragmentVideoRecordingBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentVideoRecordingBinding(Object obj, View view, int i, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
    }

    public static FragmentVideoRecordingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentVideoRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentVideoRecordingBinding bind(View view, Object obj) {
        return (FragmentVideoRecordingBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_video_recording);
    }

    @Deprecated
    public static FragmentVideoRecordingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentVideoRecordingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_video_recording, viewGroup, z, obj);
    }

    public static FragmentVideoRecordingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentVideoRecordingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentVideoRecordingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_video_recording, (ViewGroup) null, false, obj);
    }
}
