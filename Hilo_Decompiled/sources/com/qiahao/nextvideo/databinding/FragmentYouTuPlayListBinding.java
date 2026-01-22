package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentYouTuPlayListBinding extends ViewDataBinding {
    public final TextView addVideo;
    public final View bg;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentYouTuPlayListBinding(Object obj, View view, int i, TextView textView, View view2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.addVideo = textView;
        this.bg = view2;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
    }

    public static FragmentYouTuPlayListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentYouTuPlayListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentYouTuPlayListBinding bind(View view, Object obj) {
        return (FragmentYouTuPlayListBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_you_tu_play_list);
    }

    @Deprecated
    public static FragmentYouTuPlayListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentYouTuPlayListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_you_tu_play_list, viewGroup, z, obj);
    }

    public static FragmentYouTuPlayListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentYouTuPlayListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentYouTuPlayListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_you_tu_play_list, (ViewGroup) null, false, obj);
    }
}
