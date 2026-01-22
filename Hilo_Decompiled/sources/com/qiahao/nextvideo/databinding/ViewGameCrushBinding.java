package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewGameCrushBinding extends ViewDataBinding {
    public final ImageView add;
    public final TextView betDiamond;
    public final LinearLayout betText;
    public final TextView button;
    public final ImageView change;
    public final ImageView close;
    public final FrameLayout crushGameLayout;
    public final ImageView diamond;
    public final TextView diamondText;
    public final ImageView diamondTwo;
    public final IncludeLudoItemBinding fourUser;
    public final SVGAImageView gameLogo;
    public final ConstraintLayout gameTitleLayout;
    public final ImageView information;
    public final ConstraintLayout moneyLayout;
    public final IncludeLudoItemBinding oneUser;
    public final TextView pieces;
    public final ConstraintLayout prepareLayout;
    public final ConstraintLayout prepareTop;
    public final ImageView sound;
    public final IncludeLudoItemBinding threeUser;
    public final IncludeLudoItemBinding twoUser;
    public final LinearLayoutCompat userLayout;
    public final ConstraintLayout waitLayout;
    public final TextView waitText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGameCrushBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2, ImageView imageView2, ImageView imageView3, FrameLayout frameLayout, ImageView imageView4, TextView textView3, ImageView imageView5, IncludeLudoItemBinding includeLudoItemBinding, SVGAImageView sVGAImageView, ConstraintLayout constraintLayout, ImageView imageView6, ConstraintLayout constraintLayout2, IncludeLudoItemBinding includeLudoItemBinding2, TextView textView4, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView7, IncludeLudoItemBinding includeLudoItemBinding3, IncludeLudoItemBinding includeLudoItemBinding4, LinearLayoutCompat linearLayoutCompat, ConstraintLayout constraintLayout5, TextView textView5) {
        super(obj, view, i);
        this.add = imageView;
        this.betDiamond = textView;
        this.betText = linearLayout;
        this.button = textView2;
        this.change = imageView2;
        this.close = imageView3;
        this.crushGameLayout = frameLayout;
        this.diamond = imageView4;
        this.diamondText = textView3;
        this.diamondTwo = imageView5;
        this.fourUser = includeLudoItemBinding;
        this.gameLogo = sVGAImageView;
        this.gameTitleLayout = constraintLayout;
        this.information = imageView6;
        this.moneyLayout = constraintLayout2;
        this.oneUser = includeLudoItemBinding2;
        this.pieces = textView4;
        this.prepareLayout = constraintLayout3;
        this.prepareTop = constraintLayout4;
        this.sound = imageView7;
        this.threeUser = includeLudoItemBinding3;
        this.twoUser = includeLudoItemBinding4;
        this.userLayout = linearLayoutCompat;
        this.waitLayout = constraintLayout5;
        this.waitText = textView5;
    }

    public static ViewGameCrushBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGameCrushBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGameCrushBinding bind(View view, Object obj) {
        return (ViewGameCrushBinding) ViewDataBinding.bind(obj, view, R.layout.view_game_crush);
    }

    @Deprecated
    public static ViewGameCrushBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGameCrushBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_crush, viewGroup, z, obj);
    }

    public static ViewGameCrushBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGameCrushBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGameCrushBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_crush, (ViewGroup) null, false, obj);
    }
}
