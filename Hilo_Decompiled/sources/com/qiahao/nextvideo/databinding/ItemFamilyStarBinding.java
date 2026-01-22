package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFamilyStarBinding extends ViewDataBinding {
    public final TextView diamond;
    public final ImageView diamondImg;
    public final View line;
    public final TextView listPosition;
    public final LinearLayout llDiamond;
    public final MedalGridLayout llMedal;
    public final QMUIRadiusImageView userAvatarCimageView;
    public final ShineTextView userId;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFamilyStarBinding(Object obj, View view, int i, TextView textView, ImageView imageView, View view2, TextView textView2, LinearLayout linearLayout, MedalGridLayout medalGridLayout, QMUIRadiusImageView qMUIRadiusImageView, ShineTextView shineTextView, TextView textView3) {
        super(obj, view, i);
        this.diamond = textView;
        this.diamondImg = imageView;
        this.line = view2;
        this.listPosition = textView2;
        this.llDiamond = linearLayout;
        this.llMedal = medalGridLayout;
        this.userAvatarCimageView = qMUIRadiusImageView;
        this.userId = shineTextView;
        this.userName = textView3;
    }

    public static ItemFamilyStarBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFamilyStarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFamilyStarBinding bind(View view, Object obj) {
        return (ItemFamilyStarBinding) ViewDataBinding.bind(obj, view, R.layout.item_family_star);
    }

    @Deprecated
    public static ItemFamilyStarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFamilyStarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_star, viewGroup, z, obj);
    }

    public static ItemFamilyStarBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFamilyStarBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFamilyStarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_star, (ViewGroup) null, false, obj);
    }
}
