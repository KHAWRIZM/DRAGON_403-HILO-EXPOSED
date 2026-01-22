package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentRoomProfileBinding extends ViewDataBinding {
    public final TextView allDiamond;
    public final TextView announcement;
    public final TextView announcementContent;
    public final ImageView enterRight;
    public final ImageView familyArrow;
    public final PolygonImageView familyAvatar;
    public final ImageView familyBg;
    public final TextView familyName;
    public final IncludeFamilyNamePlateBinding familyNamePlate;
    public final TextView familyNumber;
    public final TextView familyTitle;
    public final FrameLayout flTop1;
    public final FrameLayout flTop2;
    public final FrameLayout flTop3;
    public final ConstraintLayout groupActivity;
    public final ImageView groupActivityImage;
    public final TextView groupContribution;
    public final TextView groupMember;
    public final ConstraintLayout groupMemberLayout;
    public final RecyclerView groupMemberRecycler;
    public final ImageView heardBg;
    public final TextView introduction;
    public final TextView introductionContent;
    public final TextView joinButton;
    public final ConstraintLayout lcGroupSupport;
    public final LinearLayout llGroupContribution;
    public final TextView llLeave;
    public final LinearLayout llMedal;
    protected View.OnClickListener mClick;
    public final AppCompatTextView medal;
    public final RecyclerView medalRecyclerView;
    public final ConstraintLayout myFamilyLayout;
    public final TextView setting;
    public final ImageView supportImage;
    public final CircleImageView top1Avatar;
    public final CircleImageView top2Avatar;
    public final CircleImageView top3Avatar;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRoomProfileBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, ImageView imageView, ImageView imageView2, PolygonImageView polygonImageView, ImageView imageView3, TextView textView4, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, TextView textView5, TextView textView6, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ConstraintLayout constraintLayout, ImageView imageView4, TextView textView7, TextView textView8, ConstraintLayout constraintLayout2, RecyclerView recyclerView, ImageView imageView5, TextView textView9, TextView textView10, TextView textView11, ConstraintLayout constraintLayout3, LinearLayout linearLayout, TextView textView12, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, RecyclerView recyclerView2, ConstraintLayout constraintLayout4, TextView textView13, ImageView imageView6, CircleImageView circleImageView, CircleImageView circleImageView2, CircleImageView circleImageView3) {
        super(obj, view, i);
        this.allDiamond = textView;
        this.announcement = textView2;
        this.announcementContent = textView3;
        this.enterRight = imageView;
        this.familyArrow = imageView2;
        this.familyAvatar = polygonImageView;
        this.familyBg = imageView3;
        this.familyName = textView4;
        this.familyNamePlate = includeFamilyNamePlateBinding;
        this.familyNumber = textView5;
        this.familyTitle = textView6;
        this.flTop1 = frameLayout;
        this.flTop2 = frameLayout2;
        this.flTop3 = frameLayout3;
        this.groupActivity = constraintLayout;
        this.groupActivityImage = imageView4;
        this.groupContribution = textView7;
        this.groupMember = textView8;
        this.groupMemberLayout = constraintLayout2;
        this.groupMemberRecycler = recyclerView;
        this.heardBg = imageView5;
        this.introduction = textView9;
        this.introductionContent = textView10;
        this.joinButton = textView11;
        this.lcGroupSupport = constraintLayout3;
        this.llGroupContribution = linearLayout;
        this.llLeave = textView12;
        this.llMedal = linearLayout2;
        this.medal = appCompatTextView;
        this.medalRecyclerView = recyclerView2;
        this.myFamilyLayout = constraintLayout4;
        this.setting = textView13;
        this.supportImage = imageView6;
        this.top1Avatar = circleImageView;
        this.top2Avatar = circleImageView2;
        this.top3Avatar = circleImageView3;
    }

    public static FragmentRoomProfileBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentRoomProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static FragmentRoomProfileBinding bind(View view, Object obj) {
        return (FragmentRoomProfileBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_room_profile);
    }

    @Deprecated
    public static FragmentRoomProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRoomProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_room_profile, viewGroup, z, obj);
    }

    public static FragmentRoomProfileBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentRoomProfileBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRoomProfileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_room_profile, (ViewGroup) null, false, obj);
    }
}
