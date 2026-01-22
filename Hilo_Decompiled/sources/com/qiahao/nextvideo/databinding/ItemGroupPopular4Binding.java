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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGroupPopular4Binding extends ViewDataBinding {
    public final ImageView matchBg;
    public final TextView matchSubTitle;
    public final SVGAImageView matchSvga;
    public final TextView matchTitle;
    public final ImageView sheepBg;
    public final TextView sheepSubTitle;
    public final SVGAImageView sheepSvga;
    public final TextView sheepTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupPopular4Binding(Object obj, View view, int i, ImageView imageView, TextView textView, SVGAImageView sVGAImageView, TextView textView2, ImageView imageView2, TextView textView3, SVGAImageView sVGAImageView2, TextView textView4) {
        super(obj, view, i);
        this.matchBg = imageView;
        this.matchSubTitle = textView;
        this.matchSvga = sVGAImageView;
        this.matchTitle = textView2;
        this.sheepBg = imageView2;
        this.sheepSubTitle = textView3;
        this.sheepSvga = sVGAImageView2;
        this.sheepTitle = textView4;
    }

    public static ItemGroupPopular4Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupPopular4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupPopular4Binding bind(View view, Object obj) {
        return (ItemGroupPopular4Binding) ViewDataBinding.bind(obj, view, R.layout.item_group_popular4);
    }

    @Deprecated
    public static ItemGroupPopular4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupPopular4Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_popular4, viewGroup, z, obj);
    }

    public static ItemGroupPopular4Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupPopular4Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupPopular4Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_popular4, (ViewGroup) null, false, obj);
    }
}
