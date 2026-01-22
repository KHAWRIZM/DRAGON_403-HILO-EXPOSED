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
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRank1Binding extends ViewDataBinding {
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
    public final CountryIDView userId;
    public final NickTextView userName;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRank1Binding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, HiloGradeView hiloGradeView, TextView textView, ImageView imageView, ImageView imageView2, View view2, TextView textView2, LinearLayout linearLayout, MedalGridLayout medalGridLayout, ImageView imageView3, HiloImageView hiloImageView, CountryIDView countryIDView, NickTextView nickTextView, HiloGradeView hiloGradeView2) {
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
        this.userId = countryIDView;
        this.userName = nickTextView;
        this.wealthLevel = hiloGradeView2;
    }

    public static ItemRank1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRank1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRank1Binding bind(View view, Object obj) {
        return (ItemRank1Binding) ViewDataBinding.bind(obj, view, R.layout.item_rank1);
    }

    @Deprecated
    public static ItemRank1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRank1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_rank1, viewGroup, z, obj);
    }

    public static ItemRank1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRank1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRank1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_rank1, (ViewGroup) null, false, obj);
    }
}
