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
public abstract class DialogCreateNuoBinding extends ViewDataBinding {
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
    public final TextView player;
    public final FrameLayout rootLayout;
    public final SVGAImageView svga;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCreateNuoBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, TextView textView, ImageView imageView3, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, ImageView imageView4, TextView textView2, ImageView imageView5, ConstraintLayout constraintLayout2, TextView textView3, FrameLayout frameLayout, SVGAImageView sVGAImageView) {
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
        this.player = textView3;
        this.rootLayout = frameLayout;
        this.svga = sVGAImageView;
    }

    public static DialogCreateNuoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCreateNuoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogCreateNuoBinding bind(View view, Object obj) {
        return (DialogCreateNuoBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_create_nuo);
    }

    @Deprecated
    public static DialogCreateNuoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCreateNuoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_nuo, viewGroup, z, obj);
    }

    public static DialogCreateNuoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCreateNuoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCreateNuoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_nuo, (ViewGroup) null, false, obj);
    }
}
