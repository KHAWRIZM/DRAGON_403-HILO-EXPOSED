package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomGiftBinding extends ViewDataBinding {
    public final ImageView bagImage;
    public final CircleImageView circleAvatar;
    public final TextView diamondText;
    public final LinearLayout giftViewAll;
    public final QMUIRadiusImageView2 image;
    public final QMUIRadiusImageView2 imageOne;
    public final QMUIRadiusImageView2 imageTwo;
    public final ConstraintLayout oneLayout;
    public final ImageView rechargeIcon;
    public final TextView rechargeText;
    public final ConstraintLayout rootBack;
    public final LinearLayout selectMember;
    public final GroupSendGiftLinearLayout sendGiftLinearLayout;
    public final LinearLayout svipLayout;
    public final ImageView svipLeftImage;
    public final ImageView svipLevel;
    public final ViewPage2TabLayout tabLayout;
    public final ImageView tip;
    public final ImageView topFrameBg;
    public final FrameLayout topFrameLayout;
    public final ConstraintLayout topLayout;
    public final ConstraintLayout twoLayout;
    public final TextView userName;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomGiftBinding(Object obj, View view, int i, ImageView imageView, CircleImageView circleImageView, TextView textView, LinearLayout linearLayout, QMUIRadiusImageView2 qMUIRadiusImageView2, QMUIRadiusImageView2 qMUIRadiusImageView22, QMUIRadiusImageView2 qMUIRadiusImageView23, ConstraintLayout constraintLayout, ImageView imageView2, TextView textView2, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, GroupSendGiftLinearLayout groupSendGiftLinearLayout, LinearLayout linearLayout3, ImageView imageView3, ImageView imageView4, ViewPage2TabLayout viewPage2TabLayout, ImageView imageView5, ImageView imageView6, FrameLayout frameLayout, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView3, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.bagImage = imageView;
        this.circleAvatar = circleImageView;
        this.diamondText = textView;
        this.giftViewAll = linearLayout;
        this.image = qMUIRadiusImageView2;
        this.imageOne = qMUIRadiusImageView22;
        this.imageTwo = qMUIRadiusImageView23;
        this.oneLayout = constraintLayout;
        this.rechargeIcon = imageView2;
        this.rechargeText = textView2;
        this.rootBack = constraintLayout2;
        this.selectMember = linearLayout2;
        this.sendGiftLinearLayout = groupSendGiftLinearLayout;
        this.svipLayout = linearLayout3;
        this.svipLeftImage = imageView3;
        this.svipLevel = imageView4;
        this.tabLayout = viewPage2TabLayout;
        this.tip = imageView5;
        this.topFrameBg = imageView6;
        this.topFrameLayout = frameLayout;
        this.topLayout = constraintLayout3;
        this.twoLayout = constraintLayout4;
        this.userName = textView3;
        this.viewPage = viewPager2;
    }

    public static DialogRoomGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRoomGiftBinding bind(View view, Object obj) {
        return (DialogRoomGiftBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_gift);
    }

    @Deprecated
    public static DialogRoomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_gift, viewGroup, z, obj);
    }

    public static DialogRoomGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_gift, (ViewGroup) null, false, obj);
    }
}
