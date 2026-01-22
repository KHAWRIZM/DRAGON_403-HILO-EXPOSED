package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityFoodieResultDialogBinding extends ViewDataBinding {
    public final QMUIRadiusImageView civBronzeAvatar;
    public final QMUIRadiusImageView civGoldAvatar;
    public final QMUIRadiusImageView civSilverAvatar;
    public final ConstraintLayout clBronzePlace;
    public final ConstraintLayout clGoldPlace;
    public final ConstraintLayout clSilverPlace;
    public final FrameLayout frameLayout;
    public final ImageView ivBronzeBrand;
    public final ImageView ivBronzeCrown;
    public final ImageView ivDog;
    public final ImageView ivEndSilk;
    public final ImageView ivFork;
    public final ImageView ivGoldBrand;
    public final ImageView ivGoldCrown;
    public final ImageView ivKnife;
    public final ImageView ivLongSilk;
    public final ImageView ivResult;
    public final ImageView ivSilverBrand;
    public final ImageView ivSilverCrown;
    public final ImageView ivStartSilk;
    public final FrameLayout parentContainer;
    public final SVGAImageView svgaImageView;
    public final TextView tvBet;
    public final TextView tvBronzeName;
    public final TextView tvBronzeRank;
    public final TextView tvBronzeTag;
    public final TextView tvCountDown;
    public final TextView tvGoldName;
    public final TextView tvGoldRank;
    public final TextView tvGoldTag;
    public final TextView tvRankingTips;
    public final TextView tvReward;
    public final TextView tvRound;
    public final TextView tvSilverName;
    public final TextView tvSilverRank;
    public final TextView tvSilverTag;
    public final TextView tvTipsBet;
    public final TextView tvTipsReward;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityFoodieResultDialogBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, QMUIRadiusImageView qMUIRadiusImageView3, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, FrameLayout frameLayout2, SVGAImageView sVGAImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16) {
        super(obj, view, i);
        this.civBronzeAvatar = qMUIRadiusImageView;
        this.civGoldAvatar = qMUIRadiusImageView2;
        this.civSilverAvatar = qMUIRadiusImageView3;
        this.clBronzePlace = constraintLayout;
        this.clGoldPlace = constraintLayout2;
        this.clSilverPlace = constraintLayout3;
        this.frameLayout = frameLayout;
        this.ivBronzeBrand = imageView;
        this.ivBronzeCrown = imageView2;
        this.ivDog = imageView3;
        this.ivEndSilk = imageView4;
        this.ivFork = imageView5;
        this.ivGoldBrand = imageView6;
        this.ivGoldCrown = imageView7;
        this.ivKnife = imageView8;
        this.ivLongSilk = imageView9;
        this.ivResult = imageView10;
        this.ivSilverBrand = imageView11;
        this.ivSilverCrown = imageView12;
        this.ivStartSilk = imageView13;
        this.parentContainer = frameLayout2;
        this.svgaImageView = sVGAImageView;
        this.tvBet = textView;
        this.tvBronzeName = textView2;
        this.tvBronzeRank = textView3;
        this.tvBronzeTag = textView4;
        this.tvCountDown = textView5;
        this.tvGoldName = textView6;
        this.tvGoldRank = textView7;
        this.tvGoldTag = textView8;
        this.tvRankingTips = textView9;
        this.tvReward = textView10;
        this.tvRound = textView11;
        this.tvSilverName = textView12;
        this.tvSilverRank = textView13;
        this.tvSilverTag = textView14;
        this.tvTipsBet = textView15;
        this.tvTipsReward = textView16;
    }

    public static ActivityFoodieResultDialogBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityFoodieResultDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityFoodieResultDialogBinding bind(View view, Object obj) {
        return (ActivityFoodieResultDialogBinding) ViewDataBinding.bind(obj, view, R.layout.activity_foodie_result_dialog);
    }

    @Deprecated
    public static ActivityFoodieResultDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFoodieResultDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_foodie_result_dialog, viewGroup, z, obj);
    }

    public static ActivityFoodieResultDialogBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityFoodieResultDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFoodieResultDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_foodie_result_dialog, (ViewGroup) null, false, obj);
    }
}
