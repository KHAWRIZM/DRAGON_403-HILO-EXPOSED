package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGroupSettingBinding extends ViewDataBinding {
    public final ConstraintLayout actionRecords;
    public final FrameLayout activityMainContainer;
    public final TextView ann;
    public final TextView announcement;
    public final TextView auto;
    public final TextView autoWelcomeContnet;
    public final AppCompatImageView backImageView;
    public final ConstraintLayout clAnnouncement;
    public final ConstraintLayout clAutoWelcome;
    public final ConstraintLayout clBlocklist;
    public final ConstraintLayout clDice;
    public final ConstraintLayout clIntroduction;
    public final ConstraintLayout clJoinedPassword;
    public final ConstraintLayout clMic;
    public final ConstraintLayout clTheme;
    public final TextView diceNumber;
    public final TextView diceTap;
    public final ImageView imageView12;
    public final ImageView imageView13;
    public final ImageView imageView2;
    public final ImageView imageView3;
    public final ImageView imageView4;
    public final ImageView imageView5;
    public final ImageView imageView8;
    public final ImageView imageView9;
    public final RoundedImageView imgPic;
    public final AppCompatImageView imge;
    public final TextView intr;
    public final TextView introduction;
    public final TextView joinedPassword;
    public final ConstraintLayout lcGroupSupport;
    protected View.OnClickListener mClick;
    public final ConstraintLayout membership;
    public final AppCompatTextView membershipDiamond;
    public final TextView membershipText;
    public final ImageView membershipTo;
    public final TextView micNumber;
    public final TextView micTap;
    public final TextView na;
    public final TextView name;
    public final ConstraintLayout roomName;
    public final FrameLayout setMessage;
    public final SwitchButton setMessageButton;
    public final FrameLayout setMic;
    public final SwitchButton setMicButton;
    public final FrameLayout setPicture;
    public final SwitchButton setPictureButton;
    public final SwitchButton switchLockText;
    public final TextView themeTap;
    public final Toolbar titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGroupSettingBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, TextView textView5, TextView textView6, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RoundedImageView roundedImageView, AppCompatImageView appCompatImageView2, TextView textView7, TextView textView8, TextView textView9, ConstraintLayout constraintLayout10, ConstraintLayout constraintLayout11, AppCompatTextView appCompatTextView, TextView textView10, ImageView imageView9, TextView textView11, TextView textView12, TextView textView13, TextView textView14, ConstraintLayout constraintLayout12, FrameLayout frameLayout2, SwitchButton switchButton, FrameLayout frameLayout3, SwitchButton switchButton2, FrameLayout frameLayout4, SwitchButton switchButton3, SwitchButton switchButton4, TextView textView15, Toolbar toolbar) {
        super(obj, view, i);
        this.actionRecords = constraintLayout;
        this.activityMainContainer = frameLayout;
        this.ann = textView;
        this.announcement = textView2;
        this.auto = textView3;
        this.autoWelcomeContnet = textView4;
        this.backImageView = appCompatImageView;
        this.clAnnouncement = constraintLayout2;
        this.clAutoWelcome = constraintLayout3;
        this.clBlocklist = constraintLayout4;
        this.clDice = constraintLayout5;
        this.clIntroduction = constraintLayout6;
        this.clJoinedPassword = constraintLayout7;
        this.clMic = constraintLayout8;
        this.clTheme = constraintLayout9;
        this.diceNumber = textView5;
        this.diceTap = textView6;
        this.imageView12 = imageView;
        this.imageView13 = imageView2;
        this.imageView2 = imageView3;
        this.imageView3 = imageView4;
        this.imageView4 = imageView5;
        this.imageView5 = imageView6;
        this.imageView8 = imageView7;
        this.imageView9 = imageView8;
        this.imgPic = roundedImageView;
        this.imge = appCompatImageView2;
        this.intr = textView7;
        this.introduction = textView8;
        this.joinedPassword = textView9;
        this.lcGroupSupport = constraintLayout10;
        this.membership = constraintLayout11;
        this.membershipDiamond = appCompatTextView;
        this.membershipText = textView10;
        this.membershipTo = imageView9;
        this.micNumber = textView11;
        this.micTap = textView12;
        this.na = textView13;
        this.name = textView14;
        this.roomName = constraintLayout12;
        this.setMessage = frameLayout2;
        this.setMessageButton = switchButton;
        this.setMic = frameLayout3;
        this.setMicButton = switchButton2;
        this.setPicture = frameLayout4;
        this.setPictureButton = switchButton3;
        this.switchLockText = switchButton4;
        this.themeTap = textView15;
        this.titleBar = toolbar;
    }

    public static ActivityGroupSettingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGroupSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityGroupSettingBinding bind(View view, Object obj) {
        return (ActivityGroupSettingBinding) ViewDataBinding.bind(obj, view, R.layout.activity_group_setting);
    }

    @Deprecated
    public static ActivityGroupSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGroupSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_group_setting, viewGroup, z, obj);
    }

    public static ActivityGroupSettingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGroupSettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGroupSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_group_setting, (ViewGroup) null, false, obj);
    }
}
