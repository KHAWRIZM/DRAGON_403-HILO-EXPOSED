package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPeopleMatchBinding extends ViewDataBinding {
    public final HiloGradeView activityLevel;
    public final GenderAgeTextView ageTextView;
    public final CircleImageView avatar;
    public final HiloGradeView charmLevel;
    public final ImageView countryImage;
    public final ImageView gameIcon;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final AppCompatButton likeCallButton;
    public final LinearLayout llLevel;
    public final TextView userName;
    public final AppCompatButton videoCallButton;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPeopleMatchBinding(Object obj, View view, int i, HiloGradeView hiloGradeView, GenderAgeTextView genderAgeTextView, CircleImageView circleImageView, HiloGradeView hiloGradeView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, AppCompatButton appCompatButton, LinearLayout linearLayout, TextView textView, AppCompatButton appCompatButton2, HiloGradeView hiloGradeView3) {
        super(obj, view, i);
        this.activityLevel = hiloGradeView;
        this.ageTextView = genderAgeTextView;
        this.avatar = circleImageView;
        this.charmLevel = hiloGradeView2;
        this.countryImage = imageView;
        this.gameIcon = imageView2;
        this.iconNoble = imageView3;
        this.iconVip = imageView4;
        this.likeCallButton = appCompatButton;
        this.llLevel = linearLayout;
        this.userName = textView;
        this.videoCallButton = appCompatButton2;
        this.wealthLevel = hiloGradeView3;
    }

    public static ItemPeopleMatchBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPeopleMatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPeopleMatchBinding bind(View view, Object obj) {
        return (ItemPeopleMatchBinding) ViewDataBinding.bind(obj, view, R.layout.item_people_match);
    }

    @Deprecated
    public static ItemPeopleMatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPeopleMatchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_people_match, viewGroup, z, obj);
    }

    public static ItemPeopleMatchBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPeopleMatchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPeopleMatchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_people_match, (ViewGroup) null, false, obj);
    }
}
