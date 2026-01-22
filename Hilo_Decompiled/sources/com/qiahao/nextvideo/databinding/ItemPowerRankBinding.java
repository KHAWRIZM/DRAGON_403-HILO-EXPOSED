package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPowerRankBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final View bottomLine;
    public final LinearLayout contentBg;
    public final TextView diamond;
    public final TextView listPosition;
    public final LinearLayout llDiamond;
    public final TextView numberMember;
    public final TextView roomName;
    public final ConstraintLayout top1AllView;
    public final TextView top1Text;
    public final ImageView top1Title;
    public final ConstraintLayout top2AllView;
    public final TextView top2Text;
    public final ImageView top2Title;
    public final ConstraintLayout top3AllView;
    public final TextView top3Text;
    public final ImageView top3Title;
    public final PorterShapeImageView userAvatarIrregularView;
    public final ImageView userAvatarIrregularViewBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPowerRankBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, View view2, LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout, TextView textView5, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView6, ImageView imageView2, ConstraintLayout constraintLayout3, TextView textView7, ImageView imageView3, PorterShapeImageView porterShapeImageView, ImageView imageView4) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.bottomLine = view2;
        this.contentBg = linearLayout;
        this.diamond = textView;
        this.listPosition = textView2;
        this.llDiamond = linearLayout2;
        this.numberMember = textView3;
        this.roomName = textView4;
        this.top1AllView = constraintLayout;
        this.top1Text = textView5;
        this.top1Title = imageView;
        this.top2AllView = constraintLayout2;
        this.top2Text = textView6;
        this.top2Title = imageView2;
        this.top3AllView = constraintLayout3;
        this.top3Text = textView7;
        this.top3Title = imageView3;
        this.userAvatarIrregularView = porterShapeImageView;
        this.userAvatarIrregularViewBg = imageView4;
    }

    public static ItemPowerRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPowerRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPowerRankBinding bind(View view, Object obj) {
        return (ItemPowerRankBinding) ViewDataBinding.bind(obj, view, R.layout.item_power_rank);
    }

    @Deprecated
    public static ItemPowerRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPowerRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_power_rank, viewGroup, z, obj);
    }

    public static ItemPowerRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPowerRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPowerRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_power_rank, (ViewGroup) null, false, obj);
    }
}
