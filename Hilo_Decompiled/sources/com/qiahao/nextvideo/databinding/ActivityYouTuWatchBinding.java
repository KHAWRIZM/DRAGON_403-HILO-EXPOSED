package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityYouTuWatchBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final TextView content;
    public final ImageView myBg;
    public final Group myGroup;
    public final TextView myRoom;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final IncludeTitleBinding titleLayout;
    public final ImageView videoIcon;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityYouTuWatchBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView, ImageView imageView, Group group, TextView textView2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, IncludeTitleBinding includeTitleBinding, ImageView imageView2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.content = textView;
        this.myBg = imageView;
        this.myGroup = group;
        this.myRoom = textView2;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.titleLayout = includeTitleBinding;
        this.videoIcon = imageView2;
    }

    public static ActivityYouTuWatchBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityYouTuWatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityYouTuWatchBinding bind(View view, Object obj) {
        return (ActivityYouTuWatchBinding) ViewDataBinding.bind(obj, view, R.layout.activity_you_tu_watch);
    }

    @Deprecated
    public static ActivityYouTuWatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityYouTuWatchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_you_tu_watch, viewGroup, z, obj);
    }

    public static ActivityYouTuWatchBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityYouTuWatchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityYouTuWatchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_you_tu_watch, (ViewGroup) null, false, obj);
    }
}
