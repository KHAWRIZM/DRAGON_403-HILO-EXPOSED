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
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.svip.CustomProgressView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class RoomPk1v1Binding extends ViewDataBinding {
    public final QMUIRadiusImageView blueAvatar;
    public final ImageView blueFire;
    public final TextView blueNick;
    public final TextView bluePoint;
    public final PortraitAnimationView blueSpeakWave;
    public final ImageView blueWinHead;
    public final ImageView blueWinLight;
    public final ConstraintLayout constraint;
    public final CustomProgressView progress;
    public final QMUIRadiusImageView redAvatar;
    public final ImageView redFire;
    public final TextView redNick;
    public final TextView redPoint;
    public final PortraitAnimationView redSpeakWave;
    public final ImageView redWinHead;
    public final ImageView redWinLight;
    public final SVGAImageView svga;
    public final TextView time;
    public final LinearLayout topLayout;
    public final TextView winText;

    /* JADX INFO: Access modifiers changed from: protected */
    public RoomPk1v1Binding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, TextView textView, TextView textView2, PortraitAnimationView portraitAnimationView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, CustomProgressView customProgressView, QMUIRadiusImageView qMUIRadiusImageView2, ImageView imageView4, TextView textView3, TextView textView4, PortraitAnimationView portraitAnimationView2, ImageView imageView5, ImageView imageView6, SVGAImageView sVGAImageView, TextView textView5, LinearLayout linearLayout, TextView textView6) {
        super(obj, view, i);
        this.blueAvatar = qMUIRadiusImageView;
        this.blueFire = imageView;
        this.blueNick = textView;
        this.bluePoint = textView2;
        this.blueSpeakWave = portraitAnimationView;
        this.blueWinHead = imageView2;
        this.blueWinLight = imageView3;
        this.constraint = constraintLayout;
        this.progress = customProgressView;
        this.redAvatar = qMUIRadiusImageView2;
        this.redFire = imageView4;
        this.redNick = textView3;
        this.redPoint = textView4;
        this.redSpeakWave = portraitAnimationView2;
        this.redWinHead = imageView5;
        this.redWinLight = imageView6;
        this.svga = sVGAImageView;
        this.time = textView5;
        this.topLayout = linearLayout;
        this.winText = textView6;
    }

    public static RoomPk1v1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomPk1v1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static RoomPk1v1Binding bind(View view, Object obj) {
        return (RoomPk1v1Binding) ViewDataBinding.bind(obj, view, R.layout.room_pk1v1);
    }

    @Deprecated
    public static RoomPk1v1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (RoomPk1v1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_pk1v1, viewGroup, z, obj);
    }

    public static RoomPk1v1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomPk1v1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomPk1v1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_pk1v1, (ViewGroup) null, false, obj);
    }
}
