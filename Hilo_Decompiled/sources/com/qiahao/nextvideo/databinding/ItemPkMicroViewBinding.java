package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPkMicroViewBinding extends ViewDataBinding {
    public final ConstraintLayout baseMicro;
    public final SVGAImageView cpSvga;
    public final ImageView emptyMicImage;
    public final SVGAImageView faceSvga;
    public final ImageView fireImage;
    public final ImageView iconNoble;
    public final ImageView iconSvip;
    public final View localTip;
    public final ImageView lockMicro;
    public final AppCompatImageView micOff;
    public final ImageView micUserHeadImg;
    public final SVGAImageView micUserHeadSvga;
    public final SVGAImageView musicSvga;
    public final TextView number;
    public final LinearLayout numberLayout;
    public final AppCompatImageView personMicOff;
    public final PortraitAnimationView speakWave;
    public final CircleImageView userAvatar;
    public final LinearLayout userInfoLinearLayout;
    public final ImageView userMute;
    public final NickTextView userName;
    public final ImageView userTag;
    public final ImageView userVip;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPkMicroViewBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, ImageView imageView, SVGAImageView sVGAImageView2, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view2, ImageView imageView5, AppCompatImageView appCompatImageView, ImageView imageView6, SVGAImageView sVGAImageView3, SVGAImageView sVGAImageView4, TextView textView, LinearLayout linearLayout, AppCompatImageView appCompatImageView2, PortraitAnimationView portraitAnimationView, CircleImageView circleImageView, LinearLayout linearLayout2, ImageView imageView7, NickTextView nickTextView, ImageView imageView8, ImageView imageView9) {
        super(obj, view, i);
        this.baseMicro = constraintLayout;
        this.cpSvga = sVGAImageView;
        this.emptyMicImage = imageView;
        this.faceSvga = sVGAImageView2;
        this.fireImage = imageView2;
        this.iconNoble = imageView3;
        this.iconSvip = imageView4;
        this.localTip = view2;
        this.lockMicro = imageView5;
        this.micOff = appCompatImageView;
        this.micUserHeadImg = imageView6;
        this.micUserHeadSvga = sVGAImageView3;
        this.musicSvga = sVGAImageView4;
        this.number = textView;
        this.numberLayout = linearLayout;
        this.personMicOff = appCompatImageView2;
        this.speakWave = portraitAnimationView;
        this.userAvatar = circleImageView;
        this.userInfoLinearLayout = linearLayout2;
        this.userMute = imageView7;
        this.userName = nickTextView;
        this.userTag = imageView8;
        this.userVip = imageView9;
    }

    public static ItemPkMicroViewBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPkMicroViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPkMicroViewBinding bind(View view, Object obj) {
        return (ItemPkMicroViewBinding) ViewDataBinding.bind(obj, view, R.layout.item_pk_micro_view);
    }

    @Deprecated
    public static ItemPkMicroViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPkMicroViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pk_micro_view, viewGroup, z, obj);
    }

    public static ItemPkMicroViewBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPkMicroViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPkMicroViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pk_micro_view, (ViewGroup) null, false, obj);
    }
}
