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
public abstract class ItemCpMedalBinding extends ViewDataBinding {
    public final ImageView image;
    public final SVGAImageView svga;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCpMedalBinding(Object obj, View view, int i, ImageView imageView, SVGAImageView sVGAImageView, TextView textView) {
        super(obj, view, i);
        this.image = imageView;
        this.svga = sVGAImageView;
        this.title = textView;
    }

    public static ItemCpMedalBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCpMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCpMedalBinding bind(View view, Object obj) {
        return (ItemCpMedalBinding) ViewDataBinding.bind(obj, view, R.layout.item_cp_medal);
    }

    @Deprecated
    public static ItemCpMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCpMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_medal, viewGroup, z, obj);
    }

    public static ItemCpMedalBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCpMedalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCpMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_medal, (ViewGroup) null, false, obj);
    }
}
