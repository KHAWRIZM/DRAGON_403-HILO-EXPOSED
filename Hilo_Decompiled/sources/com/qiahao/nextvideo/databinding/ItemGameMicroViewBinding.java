package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGameMicroViewBinding extends ViewDataBinding {
    public final ImageView baseMicro;
    public final SVGAImageView faceSvga;
    public final View localTip;
    public final ImageView lockMicro;
    public final AppCompatImageView micOff;
    public final ImageView micUserHeadImg;
    public final SVGAImageView micUserHeadSvga;
    public final AppCompatImageView personMicOff;
    public final PortraitAnimationView speakWave;
    public final CircleImageView userAvatar;
    public final ImageView userMute;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGameMicroViewBinding(Object obj, View view, int i, ImageView imageView, SVGAImageView sVGAImageView, View view2, ImageView imageView2, AppCompatImageView appCompatImageView, ImageView imageView3, SVGAImageView sVGAImageView2, AppCompatImageView appCompatImageView2, PortraitAnimationView portraitAnimationView, CircleImageView circleImageView, ImageView imageView4) {
        super(obj, view, i);
        this.baseMicro = imageView;
        this.faceSvga = sVGAImageView;
        this.localTip = view2;
        this.lockMicro = imageView2;
        this.micOff = appCompatImageView;
        this.micUserHeadImg = imageView3;
        this.micUserHeadSvga = sVGAImageView2;
        this.personMicOff = appCompatImageView2;
        this.speakWave = portraitAnimationView;
        this.userAvatar = circleImageView;
        this.userMute = imageView4;
    }

    public static ItemGameMicroViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGameMicroViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGameMicroViewBinding bind(View view, Object obj) {
        return (ItemGameMicroViewBinding) ViewDataBinding.bind(obj, view, R.layout.item_game_micro_view);
    }

    @Deprecated
    public static ItemGameMicroViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGameMicroViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_micro_view, viewGroup, z, obj);
    }

    public static ItemGameMicroViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGameMicroViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGameMicroViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_micro_view, (ViewGroup) null, false, obj);
    }
}
