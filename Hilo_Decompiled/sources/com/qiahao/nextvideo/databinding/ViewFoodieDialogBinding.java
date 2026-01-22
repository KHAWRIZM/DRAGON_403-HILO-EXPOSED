package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.wedgit.overlayView.CustomOverlayView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.foodie.FoodieBigRewardView;
import com.qiahao.nextvideo.ui.foodie.FoodieWheelLayout;
import com.qiahao.nextvideo.view.RatioImageView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewFoodieDialogBinding extends ViewDataBinding {
    public final ConstraintLayout clBalance;
    public final ConstraintLayout clHistory;
    public final ConstraintLayout clRevenue;
    public final ConstraintLayout constraint;
    public final FoodieWheelLayout foodieWheel;
    public final ImageView ivAddBalance;
    public final QMUIRadiusImageView ivAvatar;
    public final ImageView ivBack;
    public final ImageView ivGoldIcon;
    public final ImageView ivHistoryArrowRight;
    public final ImageView ivMusic;
    public final ImageView ivRankArrow;
    public final QMUIRadiusImageView ivRankFirstAvatar;
    public final ImageView ivRule;
    public final ImageView ivShelf;
    public final RatioImageView ivStage;
    public final RatioImageView ivWood;
    public final FoodieBigRewardView meatRewardView;
    public final CustomOverlayView overlay;
    public final TextView repeat;
    public final RelativeLayout rlRanking;
    public final RelativeLayout rlResult;
    public final ConstraintLayout root;
    public final RecyclerView rvJetton;
    public final RecyclerView rvResult;
    public final TextView tvBalance;
    public final TextView tvBonus;
    public final TextView tvGameTips;
    public final ImageView tvIcon;
    public final TextView tvMyHistory;
    public final TextView tvName;
    public final TextView tvRankFirst;
    public final TextView tvRankFirstName;
    public final TextView tvRankValue;
    public final TextView tvRanking;
    public final TextView tvResult;
    public final TextView tvRevenue;
    public final TextView tvRevenueTitle;
    public final TextView tvTodayRound;
    public final View vCenterRef;
    public final View vLineRank;
    public final View vLineResult;
    public final FoodieBigRewardView vegetableRewardView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewFoodieDialogBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, FoodieWheelLayout foodieWheelLayout, ImageView imageView, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, QMUIRadiusImageView qMUIRadiusImageView2, ImageView imageView7, ImageView imageView8, RatioImageView ratioImageView, RatioImageView ratioImageView2, FoodieBigRewardView foodieBigRewardView, CustomOverlayView customOverlayView, TextView textView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ConstraintLayout constraintLayout5, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView2, TextView textView3, TextView textView4, ImageView imageView9, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, View view2, View view3, View view4, FoodieBigRewardView foodieBigRewardView2) {
        super(obj, view, i);
        this.clBalance = constraintLayout;
        this.clHistory = constraintLayout2;
        this.clRevenue = constraintLayout3;
        this.constraint = constraintLayout4;
        this.foodieWheel = foodieWheelLayout;
        this.ivAddBalance = imageView;
        this.ivAvatar = qMUIRadiusImageView;
        this.ivBack = imageView2;
        this.ivGoldIcon = imageView3;
        this.ivHistoryArrowRight = imageView4;
        this.ivMusic = imageView5;
        this.ivRankArrow = imageView6;
        this.ivRankFirstAvatar = qMUIRadiusImageView2;
        this.ivRule = imageView7;
        this.ivShelf = imageView8;
        this.ivStage = ratioImageView;
        this.ivWood = ratioImageView2;
        this.meatRewardView = foodieBigRewardView;
        this.overlay = customOverlayView;
        this.repeat = textView;
        this.rlRanking = relativeLayout;
        this.rlResult = relativeLayout2;
        this.root = constraintLayout5;
        this.rvJetton = recyclerView;
        this.rvResult = recyclerView2;
        this.tvBalance = textView2;
        this.tvBonus = textView3;
        this.tvGameTips = textView4;
        this.tvIcon = imageView9;
        this.tvMyHistory = textView5;
        this.tvName = textView6;
        this.tvRankFirst = textView7;
        this.tvRankFirstName = textView8;
        this.tvRankValue = textView9;
        this.tvRanking = textView10;
        this.tvResult = textView11;
        this.tvRevenue = textView12;
        this.tvRevenueTitle = textView13;
        this.tvTodayRound = textView14;
        this.vCenterRef = view2;
        this.vLineRank = view3;
        this.vLineResult = view4;
        this.vegetableRewardView = foodieBigRewardView2;
    }

    public static ViewFoodieDialogBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewFoodieDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewFoodieDialogBinding bind(View view, Object obj) {
        return (ViewFoodieDialogBinding) ViewDataBinding.bind(obj, view, R.layout.view_foodie_dialog);
    }

    @Deprecated
    public static ViewFoodieDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewFoodieDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_dialog, viewGroup, z, obj);
    }

    public static ViewFoodieDialogBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewFoodieDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewFoodieDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_dialog, (ViewGroup) null, false, obj);
    }
}
