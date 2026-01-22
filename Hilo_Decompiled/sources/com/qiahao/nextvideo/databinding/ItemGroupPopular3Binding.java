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
public abstract class ItemGroupPopular3Binding extends ViewDataBinding {
    public final ImageView ludoBg;
    public final TextView ludoSubTitle;
    public final SVGAImageView ludoSvga;
    public final TextView ludoTitle;
    public final ImageView unoBg;
    public final TextView unoSubTitle;
    public final SVGAImageView unoSvga;
    public final TextView unoTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGroupPopular3Binding(Object obj, View view, int i, ImageView imageView, TextView textView, SVGAImageView sVGAImageView, TextView textView2, ImageView imageView2, TextView textView3, SVGAImageView sVGAImageView2, TextView textView4) {
        super(obj, view, i);
        this.ludoBg = imageView;
        this.ludoSubTitle = textView;
        this.ludoSvga = sVGAImageView;
        this.ludoTitle = textView2;
        this.unoBg = imageView2;
        this.unoSubTitle = textView3;
        this.unoSvga = sVGAImageView2;
        this.unoTitle = textView4;
    }

    public static ItemGroupPopular3Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGroupPopular3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGroupPopular3Binding bind(View view, Object obj) {
        return (ItemGroupPopular3Binding) ViewDataBinding.bind(obj, view, R.layout.item_group_popular3);
    }

    @Deprecated
    public static ItemGroupPopular3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGroupPopular3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_popular3, viewGroup, z, obj);
    }

    public static ItemGroupPopular3Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGroupPopular3Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGroupPopular3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_group_popular3, (ViewGroup) null, false, obj);
    }
}
