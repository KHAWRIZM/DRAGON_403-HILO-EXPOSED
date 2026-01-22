package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class RoomButtonPkBinding extends ViewDataBinding {
    public final View blueClick;
    public final ImageView blueFire;
    public final TextView blueNumber;
    public final QMUIRadiusImageView blueOne;
    public final ImageView blueOneBg;
    public final View bluePro;
    public final QMUIRadiusImageView blueThree;
    public final ImageView blueThreeBg;
    public final QMUIRadiusImageView blueTwo;
    public final ImageView blueTwoBg;
    public final View buttonBg;
    public final ImageView chestSVGA;
    public final ImageView fireSVGA;
    public final TextView level;
    public final View redClick;
    public final ImageView redFire;
    public final TextView redNumber;
    public final QMUIRadiusImageView redOne;
    public final ImageView redOneBg;
    public final View redPro;
    public final QMUIRadiusImageView redThree;
    public final ImageView redThreeBg;
    public final QMUIRadiusImageView redTwo;
    public final ImageView redTwoBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public RoomButtonPkBinding(Object obj, View view, int i, View view2, ImageView imageView, TextView textView, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView2, View view3, QMUIRadiusImageView qMUIRadiusImageView2, ImageView imageView3, QMUIRadiusImageView qMUIRadiusImageView3, ImageView imageView4, View view4, ImageView imageView5, ImageView imageView6, TextView textView2, View view5, ImageView imageView7, TextView textView3, QMUIRadiusImageView qMUIRadiusImageView4, ImageView imageView8, View view6, QMUIRadiusImageView qMUIRadiusImageView5, ImageView imageView9, QMUIRadiusImageView qMUIRadiusImageView6, ImageView imageView10) {
        super(obj, view, i);
        this.blueClick = view2;
        this.blueFire = imageView;
        this.blueNumber = textView;
        this.blueOne = qMUIRadiusImageView;
        this.blueOneBg = imageView2;
        this.bluePro = view3;
        this.blueThree = qMUIRadiusImageView2;
        this.blueThreeBg = imageView3;
        this.blueTwo = qMUIRadiusImageView3;
        this.blueTwoBg = imageView4;
        this.buttonBg = view4;
        this.chestSVGA = imageView5;
        this.fireSVGA = imageView6;
        this.level = textView2;
        this.redClick = view5;
        this.redFire = imageView7;
        this.redNumber = textView3;
        this.redOne = qMUIRadiusImageView4;
        this.redOneBg = imageView8;
        this.redPro = view6;
        this.redThree = qMUIRadiusImageView5;
        this.redThreeBg = imageView9;
        this.redTwo = qMUIRadiusImageView6;
        this.redTwoBg = imageView10;
    }

    public static RoomButtonPkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomButtonPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static RoomButtonPkBinding bind(View view, Object obj) {
        return (RoomButtonPkBinding) ViewDataBinding.bind(obj, view, R.layout.room_button_pk);
    }

    @Deprecated
    public static RoomButtonPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RoomButtonPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_button_pk, viewGroup, z, obj);
    }

    public static RoomButtonPkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomButtonPkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomButtonPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_button_pk, (ViewGroup) null, false, obj);
    }
}
