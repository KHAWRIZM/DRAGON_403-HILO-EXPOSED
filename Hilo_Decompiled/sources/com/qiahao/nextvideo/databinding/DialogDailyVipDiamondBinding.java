package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogDailyVipDiamondBinding extends ViewDataBinding {
    public final ConstraintLayout contraint1;
    public final ConstraintLayout contraint2;
    public final ImageView diamondDay;
    public final TextView diamondText;
    public final ImageView light1;
    public final ImageView light2;
    public final ImageView matchTimes;
    public final TextView matchTimesText;
    public final TextView okButton;
    public final SVGAImageView onlineSvga;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogDailyVipDiamondBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView2, TextView textView3, SVGAImageView sVGAImageView, TextView textView4) {
        super(obj, view, i);
        this.contraint1 = constraintLayout;
        this.contraint2 = constraintLayout2;
        this.diamondDay = imageView;
        this.diamondText = textView;
        this.light1 = imageView2;
        this.light2 = imageView3;
        this.matchTimes = imageView4;
        this.matchTimesText = textView2;
        this.okButton = textView3;
        this.onlineSvga = sVGAImageView;
        this.title = textView4;
    }

    public static DialogDailyVipDiamondBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogDailyVipDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogDailyVipDiamondBinding bind(View view, Object obj) {
        return (DialogDailyVipDiamondBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_daily_vip_diamond);
    }

    @Deprecated
    public static DialogDailyVipDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogDailyVipDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_daily_vip_diamond, viewGroup, z, obj);
    }

    public static DialogDailyVipDiamondBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogDailyVipDiamondBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogDailyVipDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_daily_vip_diamond, (ViewGroup) null, false, obj);
    }
}
