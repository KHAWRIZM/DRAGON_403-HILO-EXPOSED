package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemActivitiesDetailBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final HiloGradeView charmLevel;
    public final TextView diamond;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final View line;
    public final TextView listPosition;
    public final LinearLayout llDiamond;
    public final MedalGridLayout llMedal;
    public final ImageView svip;
    public final HiloImageView userAvatarCimageView;
    public final ShineTextView userId;
    public final NickTextView userName;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemActivitiesDetailBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, HiloGradeView hiloGradeView, TextView textView, ImageView imageView, ImageView imageView2, View view2, TextView textView2, LinearLayout linearLayout, MedalGridLayout medalGridLayout, ImageView imageView3, HiloImageView hiloImageView, ShineTextView shineTextView, NickTextView nickTextView, HiloGradeView hiloGradeView2) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.charmLevel = hiloGradeView;
        this.diamond = textView;
        this.iconNoble = imageView;
        this.iconVip = imageView2;
        this.line = view2;
        this.listPosition = textView2;
        this.llDiamond = linearLayout;
        this.llMedal = medalGridLayout;
        this.svip = imageView3;
        this.userAvatarCimageView = hiloImageView;
        this.userId = shineTextView;
        this.userName = nickTextView;
        this.wealthLevel = hiloGradeView2;
    }

    public static ItemActivitiesDetailBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemActivitiesDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemActivitiesDetailBinding bind(View view, Object obj) {
        return (ItemActivitiesDetailBinding) ViewDataBinding.bind(obj, view, R.layout.item_activities_detail);
    }

    @Deprecated
    public static ItemActivitiesDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemActivitiesDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_activities_detail, viewGroup, z, obj);
    }

    public static ItemActivitiesDetailBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemActivitiesDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemActivitiesDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_activities_detail, (ViewGroup) null, false, obj);
    }
}
