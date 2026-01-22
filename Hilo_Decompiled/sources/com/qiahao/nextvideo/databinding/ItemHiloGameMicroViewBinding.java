package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemHiloGameMicroViewBinding extends ViewDataBinding {
    public final ConstraintLayout baseMicro;
    public final ImageView emptyMicImage;
    public final SVGAImageView emptyMicSVGA;
    public final SVGAImageView faceSvga;
    public final View localTip;
    public final ImageView lockMicro;
    public final ImageView micIcon;
    public final AppCompatImageView micOff;
    public final ImageView micUserHeadImg;
    public final SVGAImageView musicSvga;
    public final AppCompatImageView personMicOff;
    public final TextView position;
    public final PortraitAnimationView speakWave;
    public final CircleImageView userAvatar;
    public final ImageView userMute;
    public final ImageView userTag;
    public final ConstraintLayout userTagLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemHiloGameMicroViewBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2, View view2, ImageView imageView2, ImageView imageView3, AppCompatImageView appCompatImageView, ImageView imageView4, SVGAImageView sVGAImageView3, AppCompatImageView appCompatImageView2, TextView textView, PortraitAnimationView portraitAnimationView, CircleImageView circleImageView, ImageView imageView5, ImageView imageView6, ConstraintLayout constraintLayout2) {
        super(obj, view, i);
        this.baseMicro = constraintLayout;
        this.emptyMicImage = imageView;
        this.emptyMicSVGA = sVGAImageView;
        this.faceSvga = sVGAImageView2;
        this.localTip = view2;
        this.lockMicro = imageView2;
        this.micIcon = imageView3;
        this.micOff = appCompatImageView;
        this.micUserHeadImg = imageView4;
        this.musicSvga = sVGAImageView3;
        this.personMicOff = appCompatImageView2;
        this.position = textView;
        this.speakWave = portraitAnimationView;
        this.userAvatar = circleImageView;
        this.userMute = imageView5;
        this.userTag = imageView6;
        this.userTagLayout = constraintLayout2;
    }

    public static ItemHiloGameMicroViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemHiloGameMicroViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemHiloGameMicroViewBinding bind(View view, Object obj) {
        return (ItemHiloGameMicroViewBinding) ViewDataBinding.bind(obj, view, R.layout.item_hilo_game_micro_view);
    }

    @Deprecated
    public static ItemHiloGameMicroViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemHiloGameMicroViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_hilo_game_micro_view, viewGroup, z, obj);
    }

    public static ItemHiloGameMicroViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemHiloGameMicroViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemHiloGameMicroViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_hilo_game_micro_view, (ViewGroup) null, false, obj);
    }
}
