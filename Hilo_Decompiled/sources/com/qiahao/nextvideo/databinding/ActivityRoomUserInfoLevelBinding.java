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
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityRoomUserInfoLevelBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final GenderAgeTextView ageTextView;
    public final AppCompatImageView backImageView;
    public final HiloGradeView charmLevel;
    public final TextView confim;
    public final ImageView countryImage;
    public final LinearLayout llAdmin;
    public final LinearLayout llLevel;
    public final LinearLayout llManager;
    public final LinearLayout llMember;
    protected View.OnClickListener mClick;
    public final TextView memberContent;
    public final View onlineStatus;
    public final Toolbar titleBar;
    public final LinearLayout tourist;
    public final CircleImageView userAvatarCimageView;
    public final TextView userName;
    public final ImageView userTag;
    public final View viewAdmin;
    public final View viewManager;
    public final View viewMember;
    public final View viewTourist;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityRoomUserInfoLevelBinding(Object obj, View view, int i, FrameLayout frameLayout, GenderAgeTextView genderAgeTextView, AppCompatImageView appCompatImageView, HiloGradeView hiloGradeView, TextView textView, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView2, View view2, Toolbar toolbar, LinearLayout linearLayout5, CircleImageView circleImageView, TextView textView3, ImageView imageView2, View view3, View view4, View view5, View view6, HiloGradeView hiloGradeView2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.ageTextView = genderAgeTextView;
        this.backImageView = appCompatImageView;
        this.charmLevel = hiloGradeView;
        this.confim = textView;
        this.countryImage = imageView;
        this.llAdmin = linearLayout;
        this.llLevel = linearLayout2;
        this.llManager = linearLayout3;
        this.llMember = linearLayout4;
        this.memberContent = textView2;
        this.onlineStatus = view2;
        this.titleBar = toolbar;
        this.tourist = linearLayout5;
        this.userAvatarCimageView = circleImageView;
        this.userName = textView3;
        this.userTag = imageView2;
        this.viewAdmin = view3;
        this.viewManager = view4;
        this.viewMember = view5;
        this.viewTourist = view6;
        this.wealthLevel = hiloGradeView2;
    }

    public static ActivityRoomUserInfoLevelBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityRoomUserInfoLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityRoomUserInfoLevelBinding bind(View view, Object obj) {
        return (ActivityRoomUserInfoLevelBinding) ViewDataBinding.bind(obj, view, R.layout.activity_room_user_info_level);
    }

    @Deprecated
    public static ActivityRoomUserInfoLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRoomUserInfoLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_user_info_level, viewGroup, z, obj);
    }

    public static ActivityRoomUserInfoLevelBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityRoomUserInfoLevelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRoomUserInfoLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_user_info_level, (ViewGroup) null, false, obj);
    }
}
