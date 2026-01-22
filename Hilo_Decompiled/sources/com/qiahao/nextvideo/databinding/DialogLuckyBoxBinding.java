package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogLuckyBoxBinding extends ViewDataBinding {
    public final View bannerClick;
    public final BannerViewPager bannerView;
    public final ImageView box1;
    public final ImageView box2;
    public final ImageView box3;
    public final ImageView box4;
    public final ImageView box5;
    public final ImageView box6;
    public final TextView confirm;
    public final DiamondTickTextView diamondCountTickTextView;
    public final View drawOneTimes;
    public final View drawTeenTimes;
    public final ImageView icLuckyBoxList;
    public final ImageView icLuckyBoxRank;
    public final ImageView imge1;
    public final ConstraintLayout llBroadCast;
    public final LinearLayout llDiamond;
    public final ConstraintLayout luckyBoxContent;
    protected View.OnClickListener mClick;
    public final TextView onceAgain;
    public final View onceLight;
    public final ImageView oneReward;
    public final TextView oneTimesDiamond;
    public final TextView oneTimesText;
    public final View rewardAgain;
    public final View rewardConfirm;
    public final ConstraintLayout rewardLayout;
    public final ImageView rewardList;
    public final TextView teenTimesDiamond;
    public final RecyclerView teenTimesReward;
    public final TextView teenTimesText;
    public final View titleBg;
    public final View topLineView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLuckyBoxBinding(Object obj, View view, int i, View view2, BannerViewPager bannerViewPager, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, DiamondTickTextView diamondTickTextView, View view3, View view4, ImageView imageView7, ImageView imageView8, ImageView imageView9, ConstraintLayout constraintLayout, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView2, View view5, ImageView imageView10, TextView textView3, TextView textView4, View view6, View view7, ConstraintLayout constraintLayout3, ImageView imageView11, TextView textView5, RecyclerView recyclerView, TextView textView6, View view8, View view9) {
        super(obj, view, i);
        this.bannerClick = view2;
        this.bannerView = bannerViewPager;
        this.box1 = imageView;
        this.box2 = imageView2;
        this.box3 = imageView3;
        this.box4 = imageView4;
        this.box5 = imageView5;
        this.box6 = imageView6;
        this.confirm = textView;
        this.diamondCountTickTextView = diamondTickTextView;
        this.drawOneTimes = view3;
        this.drawTeenTimes = view4;
        this.icLuckyBoxList = imageView7;
        this.icLuckyBoxRank = imageView8;
        this.imge1 = imageView9;
        this.llBroadCast = constraintLayout;
        this.llDiamond = linearLayout;
        this.luckyBoxContent = constraintLayout2;
        this.onceAgain = textView2;
        this.onceLight = view5;
        this.oneReward = imageView10;
        this.oneTimesDiamond = textView3;
        this.oneTimesText = textView4;
        this.rewardAgain = view6;
        this.rewardConfirm = view7;
        this.rewardLayout = constraintLayout3;
        this.rewardList = imageView11;
        this.teenTimesDiamond = textView5;
        this.teenTimesReward = recyclerView;
        this.teenTimesText = textView6;
        this.titleBg = view8;
        this.topLineView = view9;
    }

    public static DialogLuckyBoxBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLuckyBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogLuckyBoxBinding bind(View view, Object obj) {
        return (DialogLuckyBoxBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_lucky_box);
    }

    @Deprecated
    public static DialogLuckyBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLuckyBoxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_box, viewGroup, z, obj);
    }

    public static DialogLuckyBoxBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLuckyBoxBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLuckyBoxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_box, (ViewGroup) null, false, obj);
    }
}
