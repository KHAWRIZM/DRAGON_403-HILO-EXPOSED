package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentUserProfileBinding extends ViewDataBinding {
    public final CircleImageView cpAvatar1;
    public final CircleImageView cpAvatar2;
    public final QMUIRadiusImageView cpBg;
    public final LinearLayout cpCertificate;
    public final ConstraintLayout cpConstraint;
    public final ImageView cpHelp;
    public final ImageView cpModel;
    public final ConstraintLayout cpSupport1;
    public final CircleImageView cpSupport1Avatar;
    public final ImageView cpSupport1AvatarBg;
    public final ImageView cpSupport1Noble1;
    public final ConstraintLayout cpSupport2;
    public final CircleImageView cpSupport2Avatar;
    public final ImageView cpSupport2AvatarBg;
    public final ImageView cpSupport2Noble2;
    public final ConstraintLayout cpSupport3;
    public final CircleImageView cpSupport3Avatar;
    public final ImageView cpSupport3AvatarBg;
    public final ImageView cpSupport3Noble3;
    public final AppCompatTextView cpSupportTitle;
    public final AppCompatTextView cpText;
    public final TextView cpValue;
    public final ImageView familyArrow;
    public final PolygonImageView familyAvatar;
    public final ImageView familyBg;
    public final TextView familyName;
    public final IncludeFamilyNamePlateBinding familyNamePlate;
    public final TextView familyNumber;
    public final TextView familyTitle;
    public final ImageView gameLayoutBg;
    public final ConstraintLayout gameLevelLayout;
    public final TextView gameLevelTitle;
    public final LinearLayout gameLinear;
    public final ImageView heardBg;
    public final SVGAImageView ivCpHeart;
    public final LinearLayout llCp;
    public final ConstraintLayout llMedal;
    public final LinearLayout llSupport;
    public final AppCompatTextView medal;
    public final ImageView medalImg;
    public final RecyclerView medalRecyclerView;
    public final TextView message;
    public final ImageView messageArrow;
    public final Group messageGroup;
    public final ConstraintLayout myFamilyLayout;
    public final LinearLayout nameLayout;
    public final RecyclerView namePlateRecycler;
    public final AppCompatTextView namePlateTitle;
    public final LinearLayout rankSupport;
    public final RecyclerView relationRecycle;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentUserProfileBinding(Object obj, View view, int i, CircleImageView circleImageView, CircleImageView circleImageView2, QMUIRadiusImageView qMUIRadiusImageView, LinearLayout linearLayout, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, CircleImageView circleImageView3, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout3, CircleImageView circleImageView4, ImageView imageView5, ImageView imageView6, ConstraintLayout constraintLayout4, CircleImageView circleImageView5, ImageView imageView7, ImageView imageView8, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, ImageView imageView9, PolygonImageView polygonImageView, ImageView imageView10, TextView textView2, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, TextView textView3, TextView textView4, ImageView imageView11, ConstraintLayout constraintLayout5, TextView textView5, LinearLayout linearLayout2, ImageView imageView12, SVGAImageView sVGAImageView, LinearLayout linearLayout3, ConstraintLayout constraintLayout6, LinearLayout linearLayout4, AppCompatTextView appCompatTextView3, ImageView imageView13, RecyclerView recyclerView, TextView textView6, ImageView imageView14, Group group, ConstraintLayout constraintLayout7, LinearLayout linearLayout5, RecyclerView recyclerView2, AppCompatTextView appCompatTextView4, LinearLayout linearLayout6, RecyclerView recyclerView3) {
        super(obj, view, i);
        this.cpAvatar1 = circleImageView;
        this.cpAvatar2 = circleImageView2;
        this.cpBg = qMUIRadiusImageView;
        this.cpCertificate = linearLayout;
        this.cpConstraint = constraintLayout;
        this.cpHelp = imageView;
        this.cpModel = imageView2;
        this.cpSupport1 = constraintLayout2;
        this.cpSupport1Avatar = circleImageView3;
        this.cpSupport1AvatarBg = imageView3;
        this.cpSupport1Noble1 = imageView4;
        this.cpSupport2 = constraintLayout3;
        this.cpSupport2Avatar = circleImageView4;
        this.cpSupport2AvatarBg = imageView5;
        this.cpSupport2Noble2 = imageView6;
        this.cpSupport3 = constraintLayout4;
        this.cpSupport3Avatar = circleImageView5;
        this.cpSupport3AvatarBg = imageView7;
        this.cpSupport3Noble3 = imageView8;
        this.cpSupportTitle = appCompatTextView;
        this.cpText = appCompatTextView2;
        this.cpValue = textView;
        this.familyArrow = imageView9;
        this.familyAvatar = polygonImageView;
        this.familyBg = imageView10;
        this.familyName = textView2;
        this.familyNamePlate = includeFamilyNamePlateBinding;
        this.familyNumber = textView3;
        this.familyTitle = textView4;
        this.gameLayoutBg = imageView11;
        this.gameLevelLayout = constraintLayout5;
        this.gameLevelTitle = textView5;
        this.gameLinear = linearLayout2;
        this.heardBg = imageView12;
        this.ivCpHeart = sVGAImageView;
        this.llCp = linearLayout3;
        this.llMedal = constraintLayout6;
        this.llSupport = linearLayout4;
        this.medal = appCompatTextView3;
        this.medalImg = imageView13;
        this.medalRecyclerView = recyclerView;
        this.message = textView6;
        this.messageArrow = imageView14;
        this.messageGroup = group;
        this.myFamilyLayout = constraintLayout7;
        this.nameLayout = linearLayout5;
        this.namePlateRecycler = recyclerView2;
        this.namePlateTitle = appCompatTextView4;
        this.rankSupport = linearLayout6;
        this.relationRecycle = recyclerView3;
    }

    public static FragmentUserProfileBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentUserProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentUserProfileBinding bind(View view, Object obj) {
        return (FragmentUserProfileBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_user_profile);
    }

    @Deprecated
    public static FragmentUserProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentUserProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_profile, viewGroup, z, obj);
    }

    public static FragmentUserProfileBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentUserProfileBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentUserProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_user_profile, (ViewGroup) null, false, obj);
    }
}
