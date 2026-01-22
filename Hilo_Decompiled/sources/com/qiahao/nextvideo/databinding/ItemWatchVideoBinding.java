package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemWatchVideoBinding extends ViewDataBinding {
    public final QMUIRadiusImageView fourImage;
    public final QMUIRadiusImageView image;
    public final View line;
    public final LinearLayout linearLayout;
    public final TextView number;
    public final QMUIRadiusImageView oneImage;
    public final QMUIRadiusImageView threeImage;
    public final TextView title;
    public final QMUIRadiusImageView twoImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemWatchVideoBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, View view2, LinearLayout linearLayout, TextView textView, QMUIRadiusImageView qMUIRadiusImageView3, QMUIRadiusImageView qMUIRadiusImageView4, TextView textView2, QMUIRadiusImageView qMUIRadiusImageView5) {
        super(obj, view, i);
        this.fourImage = qMUIRadiusImageView;
        this.image = qMUIRadiusImageView2;
        this.line = view2;
        this.linearLayout = linearLayout;
        this.number = textView;
        this.oneImage = qMUIRadiusImageView3;
        this.threeImage = qMUIRadiusImageView4;
        this.title = textView2;
        this.twoImage = qMUIRadiusImageView5;
    }

    public static ItemWatchVideoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemWatchVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemWatchVideoBinding bind(View view, Object obj) {
        return (ItemWatchVideoBinding) ViewDataBinding.bind(obj, view, R.layout.item_watch_video);
    }

    @Deprecated
    public static ItemWatchVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemWatchVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_watch_video, viewGroup, z, obj);
    }

    public static ItemWatchVideoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemWatchVideoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemWatchVideoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_watch_video, (ViewGroup) null, false, obj);
    }
}
