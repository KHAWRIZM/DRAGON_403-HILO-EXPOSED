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
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.GroupSendGiftLinearLayout;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogOtherGiftBinding extends ViewDataBinding {
    public final ImageView bagImage;
    public final CircleImageView circleAvatar;
    public final TextView diamondText;
    public final LinearLayout giftViewAll;
    public final ImageView rechargeIcon;
    public final TextView rechargeText;
    public final ConstraintLayout rootBack;
    public final LinearLayout selectMember;
    public final GroupSendGiftLinearLayout sendGiftLinearLayout;
    public final ViewPage2TabLayout tabLayout;
    public final ImageView tip;
    public final TextView userName;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogOtherGiftBinding(Object obj, View view, int i, ImageView imageView, CircleImageView circleImageView, TextView textView, LinearLayout linearLayout, ImageView imageView2, TextView textView2, ConstraintLayout constraintLayout, LinearLayout linearLayout2, GroupSendGiftLinearLayout groupSendGiftLinearLayout, ViewPage2TabLayout viewPage2TabLayout, ImageView imageView3, TextView textView3, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.bagImage = imageView;
        this.circleAvatar = circleImageView;
        this.diamondText = textView;
        this.giftViewAll = linearLayout;
        this.rechargeIcon = imageView2;
        this.rechargeText = textView2;
        this.rootBack = constraintLayout;
        this.selectMember = linearLayout2;
        this.sendGiftLinearLayout = groupSendGiftLinearLayout;
        this.tabLayout = viewPage2TabLayout;
        this.tip = imageView3;
        this.userName = textView3;
        this.viewPage = viewPager2;
    }

    public static DialogOtherGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogOtherGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogOtherGiftBinding bind(View view, Object obj) {
        return (DialogOtherGiftBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_other_gift);
    }

    @Deprecated
    public static DialogOtherGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogOtherGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_other_gift, viewGroup, z, obj);
    }

    public static DialogOtherGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogOtherGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogOtherGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_other_gift, (ViewGroup) null, false, obj);
    }
}
