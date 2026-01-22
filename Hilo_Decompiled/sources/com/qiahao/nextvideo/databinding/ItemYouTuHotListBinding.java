package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemYouTuHotListBinding extends ViewDataBinding {
    public final TextView count;
    public final QMUIRadiusImageView image;
    public final ImageView playIcon;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemYouTuHotListBinding(Object obj, View view, int i, TextView textView, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.count = textView;
        this.image = qMUIRadiusImageView;
        this.playIcon = imageView;
        this.title = textView2;
    }

    public static ItemYouTuHotListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemYouTuHotListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemYouTuHotListBinding bind(View view, Object obj) {
        return (ItemYouTuHotListBinding) ViewDataBinding.bind(obj, view, R.layout.item_you_tu_hot_list);
    }

    @Deprecated
    public static ItemYouTuHotListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemYouTuHotListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_you_tu_hot_list, viewGroup, z, obj);
    }

    public static ItemYouTuHotListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemYouTuHotListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemYouTuHotListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_you_tu_hot_list, (ViewGroup) null, false, obj);
    }
}
