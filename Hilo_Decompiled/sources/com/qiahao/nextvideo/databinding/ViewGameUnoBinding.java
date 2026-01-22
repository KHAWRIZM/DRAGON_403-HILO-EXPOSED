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
public abstract class ViewGameUnoBinding extends ViewDataBinding {
    public final ImageView add;
    public final TextView betDiamond;
    public final LinearLayout betText;
    public final TextView button;
    public final ImageView change;
    public final ImageView close;
    public final ImageView diamond;
    public final TextView diamondText;
    public final ImageView diamondTwo;
    public final IncludeUnoItemBinding fiveUser;
    public final IncludeUnoItemBinding fourUser;
    public final SVGAImageView gameLogo;
    public final ConstraintLayout gameTitleLayout;
    public final ImageView information;
    public final ConstraintLayout moneyLayout;
    public final IncludeUnoItemBinding oneUser;
    public final TextView pieces;
    public final ConstraintLayout prepareLayout;
    public final ConstraintLayout prepareTop;
    public final IncludeUnoItemBinding sixUser;
    public final ImageView sound;
    public final IncludeUnoItemBinding threeUser;
    public final IncludeUnoItemBinding twoUser;
    public final FrameLayout unoGameLayout;
    public final LinearLayoutCompat userLayout;
    public final LinearLayoutCompat userLayoutTwo;
    public final ConstraintLayout waitLayout;
    public final TextView waitText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGameUnoBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, ImageView imageView5, IncludeUnoItemBinding includeUnoItemBinding, IncludeUnoItemBinding includeUnoItemBinding2, SVGAImageView sVGAImageView, ConstraintLayout constraintLayout, ImageView imageView6, ConstraintLayout constraintLayout2, IncludeUnoItemBinding includeUnoItemBinding3, TextView textView4, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, IncludeUnoItemBinding includeUnoItemBinding4, ImageView imageView7, IncludeUnoItemBinding includeUnoItemBinding5, IncludeUnoItemBinding includeUnoItemBinding6, FrameLayout frameLayout, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, ConstraintLayout constraintLayout5, TextView textView5) {
        super(obj, view, i);
        this.add = imageView;
        this.betDiamond = textView;
        this.betText = linearLayout;
        this.button = textView2;
        this.change = imageView2;
        this.close = imageView3;
        this.diamond = imageView4;
        this.diamondText = textView3;
        this.diamondTwo = imageView5;
        this.fiveUser = includeUnoItemBinding;
        this.fourUser = includeUnoItemBinding2;
        this.gameLogo = sVGAImageView;
        this.gameTitleLayout = constraintLayout;
        this.information = imageView6;
        this.moneyLayout = constraintLayout2;
        this.oneUser = includeUnoItemBinding3;
        this.pieces = textView4;
        this.prepareLayout = constraintLayout3;
        this.prepareTop = constraintLayout4;
        this.sixUser = includeUnoItemBinding4;
        this.sound = imageView7;
        this.threeUser = includeUnoItemBinding5;
        this.twoUser = includeUnoItemBinding6;
        this.unoGameLayout = frameLayout;
        this.userLayout = linearLayoutCompat;
        this.userLayoutTwo = linearLayoutCompat2;
        this.waitLayout = constraintLayout5;
        this.waitText = textView5;
    }

    public static ViewGameUnoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGameUnoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGameUnoBinding bind(View view, Object obj) {
        return (ViewGameUnoBinding) ViewDataBinding.bind(obj, view, R.layout.view_game_uno);
    }

    @Deprecated
    public static ViewGameUnoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGameUnoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_uno, viewGroup, z, obj);
    }

    public static ViewGameUnoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGameUnoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGameUnoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_uno, (ViewGroup) null, false, obj);
    }
}
