package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public abstract class ActivityPromoterBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView arrow;
    public final QMUIRadiusImageView avatar;
    public final QMUIRadiusImageView avatarNo;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final TextView connect;
    public final ConstraintLayout diamondLayout;
    public final QMUIRadiusImageView leaderAvatar;
    public final TextView leaderID;
    public final TextView leaderName;
    public final TextView leaderTitle;
    public final NickTextView nickName;
    public final TextView promoterSubTitle;
    public final AppCompatTextView rechargeId;
    public final AppCompatTextView rechargeOtherId;
    public final TextView select;
    public final SlidingTabLayout tabLayout;
    public final AppCompatTextView title;
    public final LinearLayoutCompat topLayout;
    public final TextView transferId;
    public final TextView transferInvite;
    public final View userBg;
    public final Group userGroup;
    public final Group userGroupNo;
    public final TextView userId;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityPromoterBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, AppCompatImageView appCompatImageView2, View view2, TextView textView, ConstraintLayout constraintLayout, QMUIRadiusImageView qMUIRadiusImageView3, TextView textView2, TextView textView3, TextView textView4, NickTextView nickTextView, TextView textView5, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView6, SlidingTabLayout slidingTabLayout, AppCompatTextView appCompatTextView3, LinearLayoutCompat linearLayoutCompat, TextView textView7, TextView textView8, View view3, Group group, Group group2, TextView textView9, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.arrow = appCompatImageView;
        this.avatar = qMUIRadiusImageView;
        this.avatarNo = qMUIRadiusImageView2;
        this.backImageView = appCompatImageView2;
        this.bar = view2;
        this.connect = textView;
        this.diamondLayout = constraintLayout;
        this.leaderAvatar = qMUIRadiusImageView3;
        this.leaderID = textView2;
        this.leaderName = textView3;
        this.leaderTitle = textView4;
        this.nickName = nickTextView;
        this.promoterSubTitle = textView5;
        this.rechargeId = appCompatTextView;
        this.rechargeOtherId = appCompatTextView2;
        this.select = textView6;
        this.tabLayout = slidingTabLayout;
        this.title = appCompatTextView3;
        this.topLayout = linearLayoutCompat;
        this.transferId = textView7;
        this.transferInvite = textView8;
        this.userBg = view3;
        this.userGroup = group;
        this.userGroupNo = group2;
        this.userId = textView9;
        this.viewPager = viewPager;
    }

    public static ActivityPromoterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityPromoterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityPromoterBinding bind(View view, Object obj) {
        return (ActivityPromoterBinding) ViewDataBinding.bind(obj, view, R.layout.activity_promoter);
    }

    @Deprecated
    public static ActivityPromoterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityPromoterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_promoter, viewGroup, z, obj);
    }

    public static ActivityPromoterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityPromoterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityPromoterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_promoter, (ViewGroup) null, false, obj);
    }
}
