package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityFamilyCenterHeaderBinding extends ViewDataBinding {
    public final IncludeFamilyItemBinding active;
    public final LinearLayout all;
    public final ImageView allArrow;
    public final PolygonImageView avatar;
    public final IncludeFamilyItemBinding charm;
    public final TextView dailyTitle;
    public final View diamondBg;
    public final TextView diamondNumber;
    public final TextView diamondText;
    public final TextView exp;
    public final ConstraintLayout familyButton;
    public final ImageView familyHeader;
    public final TextView familyLevel;
    public final ConstraintLayout familyLevelLayout;
    public final TextView familyMember;
    public final ConstraintLayout familyMemberLayout;
    public final AppCompatTextView familyName;
    public final IncludeFamilyNamePlateBinding familyNamePlate;
    public final TextView familyRoom;
    public final TextView familyStar;
    public final ConstraintLayout familyStarLayout;
    public final AppCompatTextView familyWelcome;
    public final ImageView familyWelcomeImage;
    public final IncludeFamilyItemBinding famous;
    public final ImageView gradeMedal;
    public final View levelLive;
    public final View memberLive;
    public final RecyclerView memberRecycleView;
    public final TextView monthlyRanking;
    public final View numberBg;
    public final TextView numberNumber;
    public final TextView numberText;
    public final ProgressBar progressBar;
    public final TextView rankText;
    public final ImageView rankingArrow;
    public final LinearLayout rankingTo;
    public final View starLive;
    public final SuperStatusView statusView;
    public final ConstraintLayout todayDetail;
    public final AppCompatImageView topImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityFamilyCenterHeaderBinding(Object obj, View view, int i, IncludeFamilyItemBinding includeFamilyItemBinding, LinearLayout linearLayout, ImageView imageView, PolygonImageView polygonImageView, IncludeFamilyItemBinding includeFamilyItemBinding2, TextView textView, View view2, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout, ImageView imageView2, TextView textView5, ConstraintLayout constraintLayout2, TextView textView6, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, TextView textView7, TextView textView8, ConstraintLayout constraintLayout4, AppCompatTextView appCompatTextView2, ImageView imageView3, IncludeFamilyItemBinding includeFamilyItemBinding3, ImageView imageView4, View view3, View view4, RecyclerView recyclerView, TextView textView9, View view5, TextView textView10, TextView textView11, ProgressBar progressBar, TextView textView12, ImageView imageView5, LinearLayout linearLayout2, View view6, SuperStatusView superStatusView, ConstraintLayout constraintLayout5, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.active = includeFamilyItemBinding;
        this.all = linearLayout;
        this.allArrow = imageView;
        this.avatar = polygonImageView;
        this.charm = includeFamilyItemBinding2;
        this.dailyTitle = textView;
        this.diamondBg = view2;
        this.diamondNumber = textView2;
        this.diamondText = textView3;
        this.exp = textView4;
        this.familyButton = constraintLayout;
        this.familyHeader = imageView2;
        this.familyLevel = textView5;
        this.familyLevelLayout = constraintLayout2;
        this.familyMember = textView6;
        this.familyMemberLayout = constraintLayout3;
        this.familyName = appCompatTextView;
        this.familyNamePlate = includeFamilyNamePlateBinding;
        this.familyRoom = textView7;
        this.familyStar = textView8;
        this.familyStarLayout = constraintLayout4;
        this.familyWelcome = appCompatTextView2;
        this.familyWelcomeImage = imageView3;
        this.famous = includeFamilyItemBinding3;
        this.gradeMedal = imageView4;
        this.levelLive = view3;
        this.memberLive = view4;
        this.memberRecycleView = recyclerView;
        this.monthlyRanking = textView9;
        this.numberBg = view5;
        this.numberNumber = textView10;
        this.numberText = textView11;
        this.progressBar = progressBar;
        this.rankText = textView12;
        this.rankingArrow = imageView5;
        this.rankingTo = linearLayout2;
        this.starLive = view6;
        this.statusView = superStatusView;
        this.todayDetail = constraintLayout5;
        this.topImage = appCompatImageView;
    }

    public static ActivityFamilyCenterHeaderBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityFamilyCenterHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityFamilyCenterHeaderBinding bind(View view, Object obj) {
        return (ActivityFamilyCenterHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.activity_family_center_header);
    }

    @Deprecated
    public static ActivityFamilyCenterHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFamilyCenterHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_center_header, viewGroup, z, obj);
    }

    public static ActivityFamilyCenterHeaderBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityFamilyCenterHeaderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFamilyCenterHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_family_center_header, (ViewGroup) null, false, obj);
    }
}
