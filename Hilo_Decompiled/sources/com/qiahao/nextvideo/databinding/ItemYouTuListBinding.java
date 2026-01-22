package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemYouTuListBinding extends ViewDataBinding {
    public final QMUIRadiusImageView image;
    public final ImageView more;
    public final SVGAImageView playIcon;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemYouTuListBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, SVGAImageView sVGAImageView, TextView textView) {
        super(obj, view, i);
        this.image = qMUIRadiusImageView;
        this.more = imageView;
        this.playIcon = sVGAImageView;
        this.title = textView;
    }

    public static ItemYouTuListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemYouTuListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemYouTuListBinding bind(View view, Object obj) {
        return (ItemYouTuListBinding) ViewDataBinding.bind(obj, view, R.layout.item_you_tu_list);
    }

    @Deprecated
    public static ItemYouTuListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemYouTuListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_you_tu_list, viewGroup, z, obj);
    }

    public static ItemYouTuListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemYouTuListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemYouTuListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_you_tu_list, (ViewGroup) null, false, obj);
    }
}
