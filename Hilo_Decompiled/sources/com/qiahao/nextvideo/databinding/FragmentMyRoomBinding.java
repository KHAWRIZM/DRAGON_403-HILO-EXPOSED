package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentMyRoomBinding extends ViewDataBinding {
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final CoordinatorLayout commonIdContentContainer;
    public final FrameLayout container;
    public final CardView createMyGroup;
    public final TextView emptyRecentlyOrJoined;
    public final ImageView imag;
    public final AppCompatTextView joinedText;
    public final LinearLayout linearLayout;
    public final LinearLayout llRecommendGroup;
    protected View.OnClickListener mClick;
    public final TextView recentlyText;
    public final RecyclerView recyclerJoinGroup;
    public final RecyclerView recyclerMy;
    public final RecyclerView recyclerRecentlyGroup;
    public final RecyclerView recyclerRecommend;
    public final SmartRefreshLayout smartRefreshLayout;
    public final TextView text1;
    public final TextView text2;
    public final AppBarLayout toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentMyRoomBinding(Object obj, View view, int i, CollapsingToolbarLayout collapsingToolbarLayout, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, CardView cardView, TextView textView, ImageView imageView, AppCompatTextView appCompatTextView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView2, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, SmartRefreshLayout smartRefreshLayout, TextView textView3, TextView textView4, AppBarLayout appBarLayout) {
        super(obj, view, i);
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.commonIdContentContainer = coordinatorLayout;
        this.container = frameLayout;
        this.createMyGroup = cardView;
        this.emptyRecentlyOrJoined = textView;
        this.imag = imageView;
        this.joinedText = appCompatTextView;
        this.linearLayout = linearLayout;
        this.llRecommendGroup = linearLayout2;
        this.recentlyText = textView2;
        this.recyclerJoinGroup = recyclerView;
        this.recyclerMy = recyclerView2;
        this.recyclerRecentlyGroup = recyclerView3;
        this.recyclerRecommend = recyclerView4;
        this.smartRefreshLayout = smartRefreshLayout;
        this.text1 = textView3;
        this.text2 = textView4;
        this.toolbar = appBarLayout;
    }

    public static FragmentMyRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentMyRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static FragmentMyRoomBinding bind(View view, Object obj) {
        return (FragmentMyRoomBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_my_room);
    }

    @Deprecated
    public static FragmentMyRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentMyRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_my_room, viewGroup, z, obj);
    }

    public static FragmentMyRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentMyRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentMyRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_my_room, (ViewGroup) null, false, obj);
    }
}
