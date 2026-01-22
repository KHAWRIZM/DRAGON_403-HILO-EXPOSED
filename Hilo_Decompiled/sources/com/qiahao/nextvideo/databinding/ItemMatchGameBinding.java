package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMatchGameBinding extends ViewDataBinding {
    public final ConstraintLayout constraintLayout;
    public final ImageView image;
    public final TextView subTitle;
    public final SVGAImageView svga;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMatchGameBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, SVGAImageView sVGAImageView, TextView textView2) {
        super(obj, view, i);
        this.constraintLayout = constraintLayout;
        this.image = imageView;
        this.subTitle = textView;
        this.svga = sVGAImageView;
        this.title = textView2;
    }

    public static ItemMatchGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMatchGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMatchGameBinding bind(View view, Object obj) {
        return (ItemMatchGameBinding) ViewDataBinding.bind(obj, view, R.layout.item_match_game);
    }

    @Deprecated
    public static ItemMatchGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMatchGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_match_game, viewGroup, z, obj);
    }

    public static ItemMatchGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMatchGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMatchGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_match_game, (ViewGroup) null, false, obj);
    }
}
