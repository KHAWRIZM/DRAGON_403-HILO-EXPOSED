package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityTransferBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final TextView agencyCenter;
    public final AppCompatImageView arrow;
    public final QMUIRadiusImageView avatar;
    public final QMUIRadiusImageView avatarNo;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final TextView buyDiamond;
    public final AppCompatImageView detail;
    public final AppCompatTextView diamond;
    public final ConstraintLayout diamondLayout;
    public final AppCompatTextView diamondTitle;
    public final AppCompatTextView gem;
    public final ImageView gemIcon;
    public final View line;
    public final NickTextView nickName;
    public final AppCompatTextView powderTitle;
    public final AppCompatImageView promoter;
    public final AppCompatTextView rechargeId;
    public final AppCompatTextView rechargeOtherId;
    public final TextView secondLayout;
    public final TextView select;
    public final SlidingTabLayout tabLayout;
    public final AppCompatTextView title;
    public final LinearLayoutCompat topLayout;
    public final TextView transferId;
    public final TextView transferInvite;
    public final TextView transferSendButton;
    public final View userBg;
    public final Group userGroup;
    public final Group userGroupNo;
    public final TextView userId;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTransferBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView, AppCompatImageView appCompatImageView, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, AppCompatImageView appCompatImageView2, View view2, TextView textView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ImageView imageView, View view3, NickTextView nickTextView, AppCompatTextView appCompatTextView4, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, TextView textView3, TextView textView4, SlidingTabLayout slidingTabLayout, AppCompatTextView appCompatTextView7, LinearLayoutCompat linearLayoutCompat, TextView textView5, TextView textView6, TextView textView7, View view4, Group group, Group group2, TextView textView8, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.agencyCenter = textView;
        this.arrow = appCompatImageView;
        this.avatar = qMUIRadiusImageView;
        this.avatarNo = qMUIRadiusImageView2;
        this.backImageView = appCompatImageView2;
        this.bar = view2;
        this.buyDiamond = textView2;
        this.detail = appCompatImageView3;
        this.diamond = appCompatTextView;
        this.diamondLayout = constraintLayout;
        this.diamondTitle = appCompatTextView2;
        this.gem = appCompatTextView3;
        this.gemIcon = imageView;
        this.line = view3;
        this.nickName = nickTextView;
        this.powderTitle = appCompatTextView4;
        this.promoter = appCompatImageView4;
        this.rechargeId = appCompatTextView5;
        this.rechargeOtherId = appCompatTextView6;
        this.secondLayout = textView3;
        this.select = textView4;
        this.tabLayout = slidingTabLayout;
        this.title = appCompatTextView7;
        this.topLayout = linearLayoutCompat;
        this.transferId = textView5;
        this.transferInvite = textView6;
        this.transferSendButton = textView7;
        this.userBg = view4;
        this.userGroup = group;
        this.userGroupNo = group2;
        this.userId = textView8;
        this.viewPager = viewPager;
    }

    public static ActivityTransferBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityTransferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityTransferBinding bind(View view, Object obj) {
        return (ActivityTransferBinding) ViewDataBinding.bind(obj, view, R.layout.activity_transfer);
    }

    @Deprecated
    public static ActivityTransferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityTransferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_transfer, viewGroup, z, obj);
    }

    public static ActivityTransferBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityTransferBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityTransferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_transfer, (ViewGroup) null, false, obj);
    }
}
