package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityRoomMemberOnlineBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final AppCompatTextView emptyTipTextView;
    protected View.OnClickListener mClick;
    public final AppCompatImageView more;
    public final RecyclerView recyclerManager;
    public final SmartRefreshLayout smartRefreshLayout;
    public final AppCompatTextView title;
    public final Toolbar titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityRoomMemberOnlineBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, AppCompatTextView appCompatTextView2, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.emptyTipTextView = appCompatTextView;
        this.more = appCompatImageView2;
        this.recyclerManager = recyclerView;
        this.smartRefreshLayout = smartRefreshLayout;
        this.title = appCompatTextView2;
        this.titleBar = toolbar;
    }

    public static ActivityRoomMemberOnlineBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityRoomMemberOnlineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityRoomMemberOnlineBinding bind(View view, Object obj) {
        return (ActivityRoomMemberOnlineBinding) ViewDataBinding.bind(obj, view, R.layout.activity_room_member_online);
    }

    @Deprecated
    public static ActivityRoomMemberOnlineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRoomMemberOnlineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_member_online, viewGroup, z, obj);
    }

    public static ActivityRoomMemberOnlineBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityRoomMemberOnlineBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRoomMemberOnlineBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_member_online, (ViewGroup) null, false, obj);
    }
}
