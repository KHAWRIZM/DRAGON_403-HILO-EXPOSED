package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.webview.BaseWebView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class AudioHiloGameBinding extends ViewDataBinding {
    public final AudioHiloGameBetItemBinding bet1;
    public final AudioHiloGameBetItemBinding bet2;
    public final AudioHiloGameBetItemBinding bet3;
    public final AudioHiloGameBetItemBinding bet4;
    public final AudioHiloGameBetItemBinding bet5;
    public final View betBg;
    public final TextView betDiamond;
    public final ConstraintLayout betLayout;
    public final TextView betTitle;
    public final View bg;
    public final ConstraintLayout buttonLayout;
    public final CardView cardView;
    public final TextView count;
    public final ConstraintLayout downloadLayout;
    public final SVGAImageView downloadSvga;
    public final TextView downloadText;
    public final ConstraintLayout gameConstraint;
    public final ConstraintLayout gameLayout;
    public final QMUIRadiusImageView leftAvatar;
    public final LinearLayout micLayout;
    public final RecyclerView micRecyclerView;
    public final ConstraintLayout onLineCount;
    public final ConstraintLayout onLineLayout;
    public final ImageView onlineIcon;
    public final QMUIRadiusImageView rightAvatar;
    public final BaseWebView webView;
    public final SVGAImageView winSvga;

    /* JADX INFO: Access modifiers changed from: protected */
    public AudioHiloGameBinding(Object obj, View view, int i, AudioHiloGameBetItemBinding audioHiloGameBetItemBinding, AudioHiloGameBetItemBinding audioHiloGameBetItemBinding2, AudioHiloGameBetItemBinding audioHiloGameBetItemBinding3, AudioHiloGameBetItemBinding audioHiloGameBetItemBinding4, AudioHiloGameBetItemBinding audioHiloGameBetItemBinding5, View view2, TextView textView, ConstraintLayout constraintLayout, TextView textView2, View view3, ConstraintLayout constraintLayout2, CardView cardView, TextView textView3, ConstraintLayout constraintLayout3, SVGAImageView sVGAImageView, TextView textView4, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, QMUIRadiusImageView qMUIRadiusImageView, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ImageView imageView, QMUIRadiusImageView qMUIRadiusImageView2, BaseWebView baseWebView, SVGAImageView sVGAImageView2) {
        super(obj, view, i);
        this.bet1 = audioHiloGameBetItemBinding;
        this.bet2 = audioHiloGameBetItemBinding2;
        this.bet3 = audioHiloGameBetItemBinding3;
        this.bet4 = audioHiloGameBetItemBinding4;
        this.bet5 = audioHiloGameBetItemBinding5;
        this.betBg = view2;
        this.betDiamond = textView;
        this.betLayout = constraintLayout;
        this.betTitle = textView2;
        this.bg = view3;
        this.buttonLayout = constraintLayout2;
        this.cardView = cardView;
        this.count = textView3;
        this.downloadLayout = constraintLayout3;
        this.downloadSvga = sVGAImageView;
        this.downloadText = textView4;
        this.gameConstraint = constraintLayout4;
        this.gameLayout = constraintLayout5;
        this.leftAvatar = qMUIRadiusImageView;
        this.micLayout = linearLayout;
        this.micRecyclerView = recyclerView;
        this.onLineCount = constraintLayout6;
        this.onLineLayout = constraintLayout7;
        this.onlineIcon = imageView;
        this.rightAvatar = qMUIRadiusImageView2;
        this.webView = baseWebView;
        this.winSvga = sVGAImageView2;
    }

    public static AudioHiloGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static AudioHiloGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static AudioHiloGameBinding bind(View view, Object obj) {
        return (AudioHiloGameBinding) ViewDataBinding.bind(obj, view, R.layout.audio_hilo_game);
    }

    @Deprecated
    public static AudioHiloGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (AudioHiloGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.audio_hilo_game, viewGroup, z, obj);
    }

    public static AudioHiloGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static AudioHiloGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (AudioHiloGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.audio_hilo_game, (ViewGroup) null, false, obj);
    }
}
