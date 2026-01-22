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
public abstract class ViewGameCarromBinding extends ViewDataBinding {
    public final ImageView add;
    public final TextView betDiamond;
    public final LinearLayout betText;
    public final TextView button;
    public final FrameLayout carromGameLayout;
    public final ImageView change;
    public final ImageView close;
    public final ImageView diamond;
    public final TextView diamondText;
    public final ImageView diamondTwo;
    public final IncludeCarromItemBinding fourUser;
    public final SVGAImageView gameLogo;
    public final ConstraintLayout gameTitleLayout;
    public final ImageView information;
    public final ConstraintLayout moneyLayout;
    public final IncludeCarromItemBinding oneUser;
    public final ConstraintLayout prepareLayout;
    public final ConstraintLayout prepareTop;
    public final TextView quick;
    public final ImageView sound;
    public final IncludeCarromItemBinding threeUser;
    public final IncludeCarromItemBinding twoUser;
    public final LinearLayoutCompat userLayout;
    public final ImageView vs;
    public final ConstraintLayout waitLayout;
    public final TextView waitText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGameCarromBinding(Object obj, View view, int i, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2, FrameLayout frameLayout, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, ImageView imageView5, IncludeCarromItemBinding includeCarromItemBinding, SVGAImageView sVGAImageView, ConstraintLayout constraintLayout, ImageView imageView6, ConstraintLayout constraintLayout2, IncludeCarromItemBinding includeCarromItemBinding2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView4, ImageView imageView7, IncludeCarromItemBinding includeCarromItemBinding3, IncludeCarromItemBinding includeCarromItemBinding4, LinearLayoutCompat linearLayoutCompat, ImageView imageView8, ConstraintLayout constraintLayout5, TextView textView5) {
        super(obj, view, i);
        this.add = imageView;
        this.betDiamond = textView;
        this.betText = linearLayout;
        this.button = textView2;
        this.carromGameLayout = frameLayout;
        this.change = imageView2;
        this.close = imageView3;
        this.diamond = imageView4;
        this.diamondText = textView3;
        this.diamondTwo = imageView5;
        this.fourUser = includeCarromItemBinding;
        this.gameLogo = sVGAImageView;
        this.gameTitleLayout = constraintLayout;
        this.information = imageView6;
        this.moneyLayout = constraintLayout2;
        this.oneUser = includeCarromItemBinding2;
        this.prepareLayout = constraintLayout3;
        this.prepareTop = constraintLayout4;
        this.quick = textView4;
        this.sound = imageView7;
        this.threeUser = includeCarromItemBinding3;
        this.twoUser = includeCarromItemBinding4;
        this.userLayout = linearLayoutCompat;
        this.vs = imageView8;
        this.waitLayout = constraintLayout5;
        this.waitText = textView5;
    }

    public static ViewGameCarromBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGameCarromBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGameCarromBinding bind(View view, Object obj) {
        return (ViewGameCarromBinding) ViewDataBinding.bind(obj, view, R.layout.view_game_carrom);
    }

    @Deprecated
    public static ViewGameCarromBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGameCarromBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_carrom, viewGroup, z, obj);
    }

    public static ViewGameCarromBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGameCarromBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGameCarromBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_carrom, (ViewGroup) null, false, obj);
    }
}
