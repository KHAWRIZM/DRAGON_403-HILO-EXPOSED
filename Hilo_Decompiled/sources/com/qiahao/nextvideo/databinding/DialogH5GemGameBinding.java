package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogH5GemGameBinding extends ViewDataBinding {
    public final ImageView activity;
    public final ImageView add;
    public final QMUIRadiusImageView avatar1;
    public final QMUIRadiusImageView avatar2;
    public final QMUIRadiusImageView avatar3;
    public final View bg;
    public final ImageView diamond;
    public final TextView diamondText;
    public final TextView gameTitle;
    public final ConstraintLayout moneyLayout;
    public final QMUIRadiusImageView rank;
    public final LinearLayout rankLayout;
    public final RecyclerView recyclerView;
    public final View topBg;
    public final WebView webView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogH5GemGameBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, QMUIRadiusImageView qMUIRadiusImageView3, View view2, ImageView imageView3, TextView textView, TextView textView2, ConstraintLayout constraintLayout, QMUIRadiusImageView qMUIRadiusImageView4, LinearLayout linearLayout, RecyclerView recyclerView, View view3, WebView webView) {
        super(obj, view, i);
        this.activity = imageView;
        this.add = imageView2;
        this.avatar1 = qMUIRadiusImageView;
        this.avatar2 = qMUIRadiusImageView2;
        this.avatar3 = qMUIRadiusImageView3;
        this.bg = view2;
        this.diamond = imageView3;
        this.diamondText = textView;
        this.gameTitle = textView2;
        this.moneyLayout = constraintLayout;
        this.rank = qMUIRadiusImageView4;
        this.rankLayout = linearLayout;
        this.recyclerView = recyclerView;
        this.topBg = view3;
        this.webView = webView;
    }

    public static DialogH5GemGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogH5GemGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogH5GemGameBinding bind(View view, Object obj) {
        return (DialogH5GemGameBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_h5_gem_game);
    }

    @Deprecated
    public static DialogH5GemGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogH5GemGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_h5_gem_game, viewGroup, z, obj);
    }

    public static DialogH5GemGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogH5GemGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogH5GemGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_h5_gem_game, (ViewGroup) null, false, obj);
    }
}
