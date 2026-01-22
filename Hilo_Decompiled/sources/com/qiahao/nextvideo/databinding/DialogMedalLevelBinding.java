package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogMedalLevelBinding extends ViewDataBinding {
    public final ImageView bgContent;
    public final ImageView bigPic;
    public final SVGAImageView bigSvga;
    public final TextView buttonActivity;
    public final TextView currentTextView;
    public final FrameLayout frameLayout;
    public final SVGAImageView getMedalSvga;
    public final TextView levelText;
    public final TextView maxTextView;
    public final RecyclerView medalRecyclerView;
    public final TextView minTextView;
    public final ProgressBar progressBar;
    public final ConstraintLayout progressText;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMedalLevelBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, SVGAImageView sVGAImageView, TextView textView, TextView textView2, FrameLayout frameLayout, SVGAImageView sVGAImageView2, TextView textView3, TextView textView4, RecyclerView recyclerView, TextView textView5, ProgressBar progressBar, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.bgContent = imageView;
        this.bigPic = imageView2;
        this.bigSvga = sVGAImageView;
        this.buttonActivity = textView;
        this.currentTextView = textView2;
        this.frameLayout = frameLayout;
        this.getMedalSvga = sVGAImageView2;
        this.levelText = textView3;
        this.maxTextView = textView4;
        this.medalRecyclerView = recyclerView;
        this.minTextView = textView5;
        this.progressBar = progressBar;
        this.progressText = constraintLayout;
    }

    public static DialogMedalLevelBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogMedalLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogMedalLevelBinding bind(View view, Object obj) {
        return (DialogMedalLevelBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_medal_level);
    }

    @Deprecated
    public static DialogMedalLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogMedalLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_medal_level, viewGroup, z, obj);
    }

    public static DialogMedalLevelBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogMedalLevelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogMedalLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_medal_level, (ViewGroup) null, false, obj);
    }
}
