package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPowerTeamMemberManagerBinding extends ViewDataBinding {
    public final HiloGradeView activityLevel;
    public final GenderAgeTextView ageTextView;
    public final HiloGradeView charmLevel;
    public final ImageView countryImage;
    public final LinearLayout llLevel;
    public final View onlineStatus;
    public final ImageView powerMedal;
    public final CircleImageView userAvatarCimageView;
    public final TextView userName;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPowerTeamMemberManagerBinding(Object obj, View view, int i, HiloGradeView hiloGradeView, GenderAgeTextView genderAgeTextView, HiloGradeView hiloGradeView2, ImageView imageView, LinearLayout linearLayout, View view2, ImageView imageView2, CircleImageView circleImageView, TextView textView, HiloGradeView hiloGradeView3) {
        super(obj, view, i);
        this.activityLevel = hiloGradeView;
        this.ageTextView = genderAgeTextView;
        this.charmLevel = hiloGradeView2;
        this.countryImage = imageView;
        this.llLevel = linearLayout;
        this.onlineStatus = view2;
        this.powerMedal = imageView2;
        this.userAvatarCimageView = circleImageView;
        this.userName = textView;
        this.wealthLevel = hiloGradeView3;
    }

    public static ItemPowerTeamMemberManagerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPowerTeamMemberManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPowerTeamMemberManagerBinding bind(View view, Object obj) {
        return (ItemPowerTeamMemberManagerBinding) ViewDataBinding.bind(obj, view, R.layout.item_power_team_member_manager);
    }

    @Deprecated
    public static ItemPowerTeamMemberManagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPowerTeamMemberManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_power_team_member_manager, viewGroup, z, obj);
    }

    public static ItemPowerTeamMemberManagerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPowerTeamMemberManagerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPowerTeamMemberManagerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_power_team_member_manager, (ViewGroup) null, false, obj);
    }
}
