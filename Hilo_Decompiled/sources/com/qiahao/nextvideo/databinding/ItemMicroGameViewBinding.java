package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMicroGameViewBinding extends ViewDataBinding {
    public final ConstraintLayout baseMicro;
    public final SVGAImageView cpSvga;
    public final ImageView emptyMicImage;
    public final SVGAImageView emptyMicSVGA;
    public final SVGAImageView faceSvga;
    public final ImageView iconNoble;
    public final ImageView iconSvip;
    public final View localTip;
    public final ImageView lockMicro;
    public final AppCompatImageView micOff;
    public final ImageView micUserHeadImg;
    public final SVGAImageView micUserHeadSvga;
    public final SVGAImageView musicSvga;
    public final AppCompatImageView personMicOff;
    public final PortraitAnimationView speakWave;
    public final CircleImageView userAvatar;
    public final ImageView userMute;
    public final ImageView userVip;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMicroGameViewBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, ImageView imageView, SVGAImageView sVGAImageView2, SVGAImageView sVGAImageView3, ImageView imageView2, ImageView imageView3, View view2, ImageView imageView4, AppCompatImageView appCompatImageView, ImageView imageView5, SVGAImageView sVGAImageView4, SVGAImageView sVGAImageView5, AppCompatImageView appCompatImageView2, PortraitAnimationView portraitAnimationView, CircleImageView circleImageView, ImageView imageView6, ImageView imageView7) {
        super(obj, view, i);
        this.baseMicro = constraintLayout;
        this.cpSvga = sVGAImageView;
        this.emptyMicImage = imageView;
        this.emptyMicSVGA = sVGAImageView2;
        this.faceSvga = sVGAImageView3;
        this.iconNoble = imageView2;
        this.iconSvip = imageView3;
        this.localTip = view2;
        this.lockMicro = imageView4;
        this.micOff = appCompatImageView;
        this.micUserHeadImg = imageView5;
        this.micUserHeadSvga = sVGAImageView4;
        this.musicSvga = sVGAImageView5;
        this.personMicOff = appCompatImageView2;
        this.speakWave = portraitAnimationView;
        this.userAvatar = circleImageView;
        this.userMute = imageView6;
        this.userVip = imageView7;
    }

    public static ItemMicroGameViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMicroGameViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMicroGameViewBinding bind(View view, Object obj) {
        return (ItemMicroGameViewBinding) ViewDataBinding.bind(obj, view, R.layout.item_micro_game_view);
    }

    @Deprecated
    public static ItemMicroGameViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMicroGameViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_micro_game_view, viewGroup, z, obj);
    }

    public static ItemMicroGameViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMicroGameViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMicroGameViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_micro_game_view, (ViewGroup) null, false, obj);
    }
}
