package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class AudioHiloGameBetItemBinding extends ViewDataBinding {
    public final ConstraintLayout buttonConstraint;
    public final ConstraintLayout constraint;
    public final TextView diamond;
    public final ImageView diamondIcon;
    public final QMUIRadiusImageView image;
    public final ImageView oneHead;

    /* JADX INFO: Access modifiers changed from: protected */
    public AudioHiloGameBetItemBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView2) {
        super(obj, view, i);
        this.buttonConstraint = constraintLayout;
        this.constraint = constraintLayout2;
        this.diamond = textView;
        this.diamondIcon = imageView;
        this.image = qMUIRadiusImageView;
        this.oneHead = imageView2;
    }

    public static AudioHiloGameBetItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static AudioHiloGameBetItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static AudioHiloGameBetItemBinding bind(View view, Object obj) {
        return (AudioHiloGameBetItemBinding) ViewDataBinding.bind(obj, view, R.layout.audio_hilo_game_bet_item);
    }

    @Deprecated
    public static AudioHiloGameBetItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AudioHiloGameBetItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.audio_hilo_game_bet_item, viewGroup, z, obj);
    }

    public static AudioHiloGameBetItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static AudioHiloGameBetItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AudioHiloGameBetItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.audio_hilo_game_bet_item, (ViewGroup) null, false, obj);
    }
}
