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
public abstract class DialogCreateLudoBinding extends ViewDataBinding {
    public final ImageView add;
    public final ImageView autoMatch;
    public final AppCompatTextView autoText;
    public final TextView bet;
    public final TextView classic;
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final AppCompatTextView createButton;
    public final ImageView diamondImg;
    public final TextView diamondText;
    public final TextView fourSelect;
    protected View.OnClickListener mClick;
    public final TextView magic;
    public final ImageView magicIcon;
    public final ImageView magicSelect;
    public final ImageView minus;
    public final ConstraintLayout moneyLayout;
    public final TextView quick;
    public final FrameLayout rootLayout;
    public final SVGAImageView svga;
    public final TextView twoSelect;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCreateLudoBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, TextView textView, TextView textView2, ImageView imageView3, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, ImageView imageView4, TextView textView3, TextView textView4, TextView textView5, ImageView imageView5, ImageView imageView6, ImageView imageView7, ConstraintLayout constraintLayout2, TextView textView6, FrameLayout frameLayout, SVGAImageView sVGAImageView, TextView textView7) {
        super(obj, view, i);
        this.add = imageView;
        this.autoMatch = imageView2;
        this.autoText = appCompatTextView;
        this.bet = textView;
        this.classic = textView2;
        this.close = imageView3;
        this.constraint = constraintLayout;
        this.createButton = appCompatTextView2;
        this.diamondImg = imageView4;
        this.diamondText = textView3;
        this.fourSelect = textView4;
        this.magic = textView5;
        this.magicIcon = imageView5;
        this.magicSelect = imageView6;
        this.minus = imageView7;
        this.moneyLayout = constraintLayout2;
        this.quick = textView6;
        this.rootLayout = frameLayout;
        this.svga = sVGAImageView;
        this.twoSelect = textView7;
    }

    public static DialogCreateLudoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCreateLudoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogCreateLudoBinding bind(View view, Object obj) {
        return (DialogCreateLudoBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_create_ludo);
    }

    @Deprecated
    public static DialogCreateLudoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCreateLudoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_ludo, viewGroup, z, obj);
    }

    public static DialogCreateLudoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCreateLudoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCreateLudoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_ludo, (ViewGroup) null, false, obj);
    }
}
