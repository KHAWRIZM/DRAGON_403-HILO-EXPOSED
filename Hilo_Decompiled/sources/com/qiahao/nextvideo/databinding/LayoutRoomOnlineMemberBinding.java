package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LayoutRoomOnlineMemberBinding extends ViewDataBinding {
    public final LinearLayout llOnlineSum;
    public final LinearLayout llRoomRank;
    public final LottieAnimationView lottieView;
    protected View.OnClickListener mClick;
    public final ImageView numberImage;
    public final RecyclerView numberOnlineRecycler;
    public final TextView numberSum;
    public final ImageView trophy;
    public final TextView trophyRoomRankSum;
    public final SVGAImageView trophySVGA;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutRoomOnlineMemberBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LottieAnimationView lottieAnimationView, ImageView imageView, RecyclerView recyclerView, TextView textView, ImageView imageView2, TextView textView2, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.llOnlineSum = linearLayout;
        this.llRoomRank = linearLayout2;
        this.lottieView = lottieAnimationView;
        this.numberImage = imageView;
        this.numberOnlineRecycler = recyclerView;
        this.numberSum = textView;
        this.trophy = imageView2;
        this.trophyRoomRankSum = textView2;
        this.trophySVGA = sVGAImageView;
    }

    public static LayoutRoomOnlineMemberBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LayoutRoomOnlineMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static LayoutRoomOnlineMemberBinding bind(View view, Object obj) {
        return (LayoutRoomOnlineMemberBinding) ViewDataBinding.bind(obj, view, R.layout.layout_room_online_member);
    }

    @Deprecated
    public static LayoutRoomOnlineMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutRoomOnlineMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_room_online_member, viewGroup, z, obj);
    }

    public static LayoutRoomOnlineMemberBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LayoutRoomOnlineMemberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutRoomOnlineMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_room_online_member, (ViewGroup) null, false, obj);
    }
}
