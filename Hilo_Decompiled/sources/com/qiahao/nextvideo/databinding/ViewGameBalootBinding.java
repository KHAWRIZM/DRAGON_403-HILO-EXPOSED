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
public abstract class ViewGameBalootBinding extends ViewDataBinding {
    public final ImageView add;
    public final FrameLayout balootGameLayout;
    public final TextView betDiamond;
    public final LinearLayout betText;
    public final TextView button;
    public final ImageView change;
    public final ImageView close;
    public final ImageView diamond;
    public final TextView diamondText;
    public final ImageView diamondTwo;
    public final IncludeBalootItemBinding fourUser;
    public final SVGAImageView gameLogo;
    public final ConstraintLayout gameTitleLayout;
    public final ImageView information;
    public final ConstraintLayout moneyLayout;
    public final IncludeBalootItemBinding oneUser;
    public final ConstraintLayout prepareLayout;
    public final ConstraintLayout prepareTop;
    public final TextView quick;
    public final ImageView sound;
    public final IncludeBalootItemBinding threeUser;
    public final IncludeBalootItemBinding twoUser;
    public final LinearLayoutCompat userLayout;
    public final ImageView vs;
    public final ConstraintLayout waitLayout;
    public final TextView waitText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGameBalootBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, TextView textView2, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, ImageView imageView5, IncludeBalootItemBinding includeBalootItemBinding, SVGAImageView sVGAImageView, ConstraintLayout constraintLayout, ImageView imageView6, ConstraintLayout constraintLayout2, IncludeBalootItemBinding includeBalootItemBinding2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView4, ImageView imageView7, IncludeBalootItemBinding includeBalootItemBinding3, IncludeBalootItemBinding includeBalootItemBinding4, LinearLayoutCompat linearLayoutCompat, ImageView imageView8, ConstraintLayout constraintLayout5, TextView textView5) {
        super(obj, view, i);
        this.add = imageView;
        this.balootGameLayout = frameLayout;
        this.betDiamond = textView;
        this.betText = linearLayout;
        this.button = textView2;
        this.change = imageView2;
        this.close = imageView3;
        this.diamond = imageView4;
        this.diamondText = textView3;
        this.diamondTwo = imageView5;
        this.fourUser = includeBalootItemBinding;
        this.gameLogo = sVGAImageView;
        this.gameTitleLayout = constraintLayout;
        this.information = imageView6;
        this.moneyLayout = constraintLayout2;
        this.oneUser = includeBalootItemBinding2;
        this.prepareLayout = constraintLayout3;
        this.prepareTop = constraintLayout4;
        this.quick = textView4;
        this.sound = imageView7;
        this.threeUser = includeBalootItemBinding3;
        this.twoUser = includeBalootItemBinding4;
        this.userLayout = linearLayoutCompat;
        this.vs = imageView8;
        this.waitLayout = constraintLayout5;
        this.waitText = textView5;
    }

    public static ViewGameBalootBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGameBalootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGameBalootBinding bind(View view, Object obj) {
        return (ViewGameBalootBinding) ViewDataBinding.bind(obj, view, R.layout.view_game_baloot);
    }

    @Deprecated
    public static ViewGameBalootBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGameBalootBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_baloot, viewGroup, z, obj);
    }

    public static ViewGameBalootBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGameBalootBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGameBalootBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_baloot, (ViewGroup) null, false, obj);
    }
}
