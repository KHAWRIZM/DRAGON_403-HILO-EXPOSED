package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityRoomUserBlockBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final GenderAgeTextView ageTextView;
    public final AppCompatImageView backImageView;
    public final HiloGradeView charmLevel;
    public final TextView confim;
    public final TextView content;
    public final ImageView countryImage;
    public final View line;
    public final LinearLayout llBlockDeleteHistory;
    public final LinearLayout llBlockNotDeleteHistory;
    public final LinearLayout llKickOut;
    public final LinearLayout llLevel;
    protected View.OnClickListener mClick;
    public final View onlineStatus;
    public final ConstraintLayout svipLinear;
    public final View svipView;
    public final TextView text;
    public final Toolbar titleBar;
    public final CircleImageView userAvatarCimageView;
    public final TextView userName;
    public final ImageView userTag;
    public final View viewBlockDeleteHistory;
    public final View viewBlockNotDeleteHistory;
    public final View viewKickOut;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityRoomUserBlockBinding(Object obj, View view, int i, FrameLayout frameLayout, GenderAgeTextView genderAgeTextView, AppCompatImageView appCompatImageView, HiloGradeView hiloGradeView, TextView textView, TextView textView2, ImageView imageView, View view2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, View view3, ConstraintLayout constraintLayout, View view4, TextView textView3, Toolbar toolbar, CircleImageView circleImageView, TextView textView4, ImageView imageView2, View view5, View view6, View view7, HiloGradeView hiloGradeView2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.ageTextView = genderAgeTextView;
        this.backImageView = appCompatImageView;
        this.charmLevel = hiloGradeView;
        this.confim = textView;
        this.content = textView2;
        this.countryImage = imageView;
        this.line = view2;
        this.llBlockDeleteHistory = linearLayout;
        this.llBlockNotDeleteHistory = linearLayout2;
        this.llKickOut = linearLayout3;
        this.llLevel = linearLayout4;
        this.onlineStatus = view3;
        this.svipLinear = constraintLayout;
        this.svipView = view4;
        this.text = textView3;
        this.titleBar = toolbar;
        this.userAvatarCimageView = circleImageView;
        this.userName = textView4;
        this.userTag = imageView2;
        this.viewBlockDeleteHistory = view5;
        this.viewBlockNotDeleteHistory = view6;
        this.viewKickOut = view7;
        this.wealthLevel = hiloGradeView2;
    }

    public static ActivityRoomUserBlockBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityRoomUserBlockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityRoomUserBlockBinding bind(View view, Object obj) {
        return (ActivityRoomUserBlockBinding) ViewDataBinding.bind(obj, view, R.layout.activity_room_user_block);
    }

    @Deprecated
    public static ActivityRoomUserBlockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRoomUserBlockBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_user_block, viewGroup, z, obj);
    }

    public static ActivityRoomUserBlockBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityRoomUserBlockBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRoomUserBlockBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_user_block, (ViewGroup) null, false, obj);
    }
}
