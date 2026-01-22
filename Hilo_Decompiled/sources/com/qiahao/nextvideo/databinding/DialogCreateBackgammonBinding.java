package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCreateBackgammonBinding extends ViewDataBinding {
    public final ImageView add;
    public final ImageView autoMatch;
    public final AppCompatTextView autoText;
    public final TextView bet;
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final AppCompatTextView createButton;
    public final ImageView diamondImg;
    public final TextView diamondText;
    protected View.OnClickListener mClick;
    public final ImageView minus;
    public final ConstraintLayout moneyLayout;
    public final FrameLayout rootLayout;
    public final TextView second15;
    public final TextView second30;
    public final TextView second45;
    public final TextView second60;
    public final SVGAImageView svga;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCreateBackgammonBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, TextView textView, ImageView imageView3, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, ImageView imageView4, TextView textView2, ImageView imageView5, ConstraintLayout constraintLayout2, FrameLayout frameLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.add = imageView;
        this.autoMatch = imageView2;
        this.autoText = appCompatTextView;
        this.bet = textView;
        this.close = imageView3;
        this.constraint = constraintLayout;
        this.createButton = appCompatTextView2;
        this.diamondImg = imageView4;
        this.diamondText = textView2;
        this.minus = imageView5;
        this.moneyLayout = constraintLayout2;
        this.rootLayout = frameLayout;
        this.second15 = textView3;
        this.second30 = textView4;
        this.second45 = textView5;
        this.second60 = textView6;
        this.svga = sVGAImageView;
    }

    public static DialogCreateBackgammonBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCreateBackgammonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogCreateBackgammonBinding bind(View view, Object obj) {
        return (DialogCreateBackgammonBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_create_backgammon);
    }

    @Deprecated
    public static DialogCreateBackgammonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCreateBackgammonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_backgammon, viewGroup, z, obj);
    }

    public static DialogCreateBackgammonBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCreateBackgammonBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCreateBackgammonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_backgammon, (ViewGroup) null, false, obj);
    }
}
