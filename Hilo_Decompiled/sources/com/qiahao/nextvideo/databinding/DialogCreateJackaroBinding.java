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
public abstract class DialogCreateJackaroBinding extends ViewDataBinding {
    public final ImageView add;
    public final ImageView autoMatch;
    public final AppCompatTextView autoText;
    public final TextView baseMode;
    public final TextView bet;
    public final ImageView close;
    public final TextView complexMode;
    public final ConstraintLayout constraint;
    public final AppCompatTextView createButton;
    public final ImageView diamondImg;
    public final TextView diamondText;
    protected View.OnClickListener mClick;
    public final ImageView minus;
    public final ConstraintLayout moneyLayout;
    public final TextView one;
    public final FrameLayout rootLayout;
    public final SVGAImageView svga;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCreateJackaroBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, TextView textView, TextView textView2, ImageView imageView3, TextView textView3, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, ImageView imageView4, TextView textView4, ImageView imageView5, ConstraintLayout constraintLayout2, TextView textView5, FrameLayout frameLayout, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.add = imageView;
        this.autoMatch = imageView2;
        this.autoText = appCompatTextView;
        this.baseMode = textView;
        this.bet = textView2;
        this.close = imageView3;
        this.complexMode = textView3;
        this.constraint = constraintLayout;
        this.createButton = appCompatTextView2;
        this.diamondImg = imageView4;
        this.diamondText = textView4;
        this.minus = imageView5;
        this.moneyLayout = constraintLayout2;
        this.one = textView5;
        this.rootLayout = frameLayout;
        this.svga = sVGAImageView;
    }

    public static DialogCreateJackaroBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCreateJackaroBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogCreateJackaroBinding bind(View view, Object obj) {
        return (DialogCreateJackaroBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_create_jackaro);
    }

    @Deprecated
    public static DialogCreateJackaroBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCreateJackaroBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_jackaro, viewGroup, z, obj);
    }

    public static DialogCreateJackaroBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCreateJackaroBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCreateJackaroBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_jackaro, (ViewGroup) null, false, obj);
    }
}
