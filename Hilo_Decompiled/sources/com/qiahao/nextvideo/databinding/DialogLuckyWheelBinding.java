package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.TurntableText;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogLuckyWheelBinding extends ViewDataBinding {
    public final ImageView bgContentA;
    public final ImageView bgContentB;
    public final ImageView centerPoint;
    public final ConstraintLayout clLuckyWheel;
    public final ConstraintLayout clWinLayout;
    public final ImageView closeLuckyWheel;
    public final AppCompatTextView diamond;
    public final ImageView faceImage;
    public final AppCompatTextView joinDiamond;
    public final LinearLayout llJoin;
    protected View.OnClickListener mClick;
    public final CircleImageView outAvatar;
    public final ImageView outBg;
    public final AppCompatTextView personNumber;
    public final ImageView smallLuckyWheel;
    public final TextView startClick;
    public final SVGAImageView svgaImageView;
    public final TurntableText turnText;
    public final AppCompatTextView winnerDiamond;
    public final TextView winnerName;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogLuckyWheelBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView4, AppCompatTextView appCompatTextView, ImageView imageView5, AppCompatTextView appCompatTextView2, LinearLayout linearLayout, CircleImageView circleImageView, ImageView imageView6, AppCompatTextView appCompatTextView3, ImageView imageView7, TextView textView, SVGAImageView sVGAImageView, TurntableText turntableText, AppCompatTextView appCompatTextView4, TextView textView2) {
        super(obj, view, i);
        this.bgContentA = imageView;
        this.bgContentB = imageView2;
        this.centerPoint = imageView3;
        this.clLuckyWheel = constraintLayout;
        this.clWinLayout = constraintLayout2;
        this.closeLuckyWheel = imageView4;
        this.diamond = appCompatTextView;
        this.faceImage = imageView5;
        this.joinDiamond = appCompatTextView2;
        this.llJoin = linearLayout;
        this.outAvatar = circleImageView;
        this.outBg = imageView6;
        this.personNumber = appCompatTextView3;
        this.smallLuckyWheel = imageView7;
        this.startClick = textView;
        this.svgaImageView = sVGAImageView;
        this.turnText = turntableText;
        this.winnerDiamond = appCompatTextView4;
        this.winnerName = textView2;
    }

    public static DialogLuckyWheelBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogLuckyWheelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogLuckyWheelBinding bind(View view, Object obj) {
        return (DialogLuckyWheelBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_lucky_wheel);
    }

    @Deprecated
    public static DialogLuckyWheelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogLuckyWheelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_wheel, viewGroup, z, obj);
    }

    public static DialogLuckyWheelBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogLuckyWheelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogLuckyWheelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_lucky_wheel, (ViewGroup) null, false, obj);
    }
}
