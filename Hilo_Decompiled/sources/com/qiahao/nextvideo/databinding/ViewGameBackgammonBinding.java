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
public abstract class ViewGameBackgammonBinding extends ViewDataBinding {
    public final ImageView add;
    public final FrameLayout backgammonGameLayout;
    public final TextView betDiamond;
    public final LinearLayout betText;
    public final TextView button;
    public final ImageView change;
    public final ImageView close;
    public final ImageView diamond;
    public final TextView diamondText;
    public final ImageView diamondTwo;
    public final SVGAImageView gameLogo;
    public final ConstraintLayout gameTitleLayout;
    public final ImageView information;
    public final ConstraintLayout moneyLayout;
    public final IncludeJackaroItemBinding oneUser;
    public final ConstraintLayout prepareLayout;
    public final ConstraintLayout prepareTop;
    public final TextView quick;
    public final ImageView sound;
    public final IncludeJackaroItemBinding twoUser;
    public final LinearLayoutCompat userLayout;
    public final ImageView vs;
    public final ConstraintLayout waitLayout;
    public final TextView waitText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGameBackgammonBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, TextView textView2, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, ImageView imageView5, SVGAImageView sVGAImageView, ConstraintLayout constraintLayout, ImageView imageView6, ConstraintLayout constraintLayout2, IncludeJackaroItemBinding includeJackaroItemBinding, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView4, ImageView imageView7, IncludeJackaroItemBinding includeJackaroItemBinding2, LinearLayoutCompat linearLayoutCompat, ImageView imageView8, ConstraintLayout constraintLayout5, TextView textView5) {
        super(obj, view, i);
        this.add = imageView;
        this.backgammonGameLayout = frameLayout;
        this.betDiamond = textView;
        this.betText = linearLayout;
        this.button = textView2;
        this.change = imageView2;
        this.close = imageView3;
        this.diamond = imageView4;
        this.diamondText = textView3;
        this.diamondTwo = imageView5;
        this.gameLogo = sVGAImageView;
        this.gameTitleLayout = constraintLayout;
        this.information = imageView6;
        this.moneyLayout = constraintLayout2;
        this.oneUser = includeJackaroItemBinding;
        this.prepareLayout = constraintLayout3;
        this.prepareTop = constraintLayout4;
        this.quick = textView4;
        this.sound = imageView7;
        this.twoUser = includeJackaroItemBinding2;
        this.userLayout = linearLayoutCompat;
        this.vs = imageView8;
        this.waitLayout = constraintLayout5;
        this.waitText = textView5;
    }

    public static ViewGameBackgammonBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGameBackgammonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGameBackgammonBinding bind(View view, Object obj) {
        return (ViewGameBackgammonBinding) ViewDataBinding.bind(obj, view, R.layout.view_game_backgammon);
    }

    @Deprecated
    public static ViewGameBackgammonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGameBackgammonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_backgammon, viewGroup, z, obj);
    }

    public static ViewGameBackgammonBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGameBackgammonBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGameBackgammonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_backgammon, (ViewGroup) null, false, obj);
    }
}
