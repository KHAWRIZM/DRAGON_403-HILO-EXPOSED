package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGroupSupportBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final LinearLayout groupAdmin;
    public final TextView lastLevelText;
    public final TextView lastSupportText;
    public final TextView lastTrophyText;
    public final TextView lastWeekLevel;
    public final TextView lastWeekSupport;
    public final TextView lastWeekTrophy;
    public final LinearLayout llCanReward;
    public final ConstraintLayout llOwner;
    public final LinearLayout llOwnerGroup;
    protected View.OnClickListener mClick;
    public final CircleImageView ownerAvatar;
    public final TextView ownerId;
    public final TextView ownerName;
    public final TextView receiveRewardBtn;
    public final RecyclerView recyclerGroupAdmin;
    public final TextView text1;
    public final TextView text2;
    public final TextView thisLevelText;
    public final TextView thisSupportText;
    public final TextView thisTrophyText;
    public final TextView thisWeekLevel;
    public final TextView thisWeekSupport;
    public final TextView thisWeekTrophy;
    public final Toolbar titleBar;
    public final LinearLayout unreceiveAwardBtn1;
    public final View view1;
    public final View view2;
    public final View view3;
    public final View view4;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGroupSupportBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout2, ConstraintLayout constraintLayout, LinearLayout linearLayout3, CircleImageView circleImageView, TextView textView7, TextView textView8, TextView textView9, RecyclerView recyclerView, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, Toolbar toolbar, LinearLayout linearLayout4, View view2, View view3, View view4, View view5) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.groupAdmin = linearLayout;
        this.lastLevelText = textView;
        this.lastSupportText = textView2;
        this.lastTrophyText = textView3;
        this.lastWeekLevel = textView4;
        this.lastWeekSupport = textView5;
        this.lastWeekTrophy = textView6;
        this.llCanReward = linearLayout2;
        this.llOwner = constraintLayout;
        this.llOwnerGroup = linearLayout3;
        this.ownerAvatar = circleImageView;
        this.ownerId = textView7;
        this.ownerName = textView8;
        this.receiveRewardBtn = textView9;
        this.recyclerGroupAdmin = recyclerView;
        this.text1 = textView10;
        this.text2 = textView11;
        this.thisLevelText = textView12;
        this.thisSupportText = textView13;
        this.thisTrophyText = textView14;
        this.thisWeekLevel = textView15;
        this.thisWeekSupport = textView16;
        this.thisWeekTrophy = textView17;
        this.titleBar = toolbar;
        this.unreceiveAwardBtn1 = linearLayout4;
        this.view1 = view2;
        this.view2 = view3;
        this.view3 = view4;
        this.view4 = view5;
    }

    public static ActivityGroupSupportBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGroupSupportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityGroupSupportBinding bind(View view, Object obj) {
        return (ActivityGroupSupportBinding) ViewDataBinding.bind(obj, view, R.layout.activity_group_support);
    }

    @Deprecated
    public static ActivityGroupSupportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGroupSupportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_group_support, viewGroup, z, obj);
    }

    public static ActivityGroupSupportBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGroupSupportBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGroupSupportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_group_support, (ViewGroup) null, false, obj);
    }
}
