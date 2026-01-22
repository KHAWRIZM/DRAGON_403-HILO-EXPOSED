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
public abstract class DialogCreateCarromBinding extends ViewDataBinding {
    public final ImageView add;
    public final ImageView autoMatch;
    public final AppCompatTextView autoText;
    public final TextView bet;
    public final TextView carrom;
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final AppCompatTextView createButton;
    public final ImageView diamondImg;
    public final TextView diamondText;
    public final TextView freestyle;
    protected View.OnClickListener mClick;
    public final ImageView minus;
    public final ConstraintLayout moneyLayout;
    public final FrameLayout rootLayout;
    public final SVGAImageView svga;
    public final TextView two;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCreateCarromBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, TextView textView, TextView textView2, ImageView imageView3, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView2, ImageView imageView4, TextView textView3, TextView textView4, ImageView imageView5, ConstraintLayout constraintLayout2, FrameLayout frameLayout, SVGAImageView sVGAImageView, TextView textView5) {
        super(obj, view, i);
        this.add = imageView;
        this.autoMatch = imageView2;
        this.autoText = appCompatTextView;
        this.bet = textView;
        this.carrom = textView2;
        this.close = imageView3;
        this.constraint = constraintLayout;
        this.createButton = appCompatTextView2;
        this.diamondImg = imageView4;
        this.diamondText = textView3;
        this.freestyle = textView4;
        this.minus = imageView5;
        this.moneyLayout = constraintLayout2;
        this.rootLayout = frameLayout;
        this.svga = sVGAImageView;
        this.two = textView5;
    }

    public static DialogCreateCarromBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCreateCarromBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogCreateCarromBinding bind(View view, Object obj) {
        return (DialogCreateCarromBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_create_carrom);
    }

    @Deprecated
    public static DialogCreateCarromBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCreateCarromBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_carrom, viewGroup, z, obj);
    }

    public static DialogCreateCarromBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCreateCarromBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCreateCarromBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_create_carrom, (ViewGroup) null, false, obj);
    }
}
