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
public abstract class ItemLudoWinBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ImageView avatarBorder;
    public final ImageView bg;
    public final TextView diamond;
    public final ImageView diamondImage;
    public final TextView nickName;
    public final ImageView rankImage;
    public final TextView score;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemLudoWinBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, TextView textView2, ImageView imageView4, TextView textView3) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.avatarBorder = imageView;
        this.bg = imageView2;
        this.diamond = textView;
        this.diamondImage = imageView3;
        this.nickName = textView2;
        this.rankImage = imageView4;
        this.score = textView3;
    }

    public static ItemLudoWinBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemLudoWinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemLudoWinBinding bind(View view, Object obj) {
        return (ItemLudoWinBinding) ViewDataBinding.bind(obj, view, R.layout.item_ludo_win);
    }

    @Deprecated
    public static ItemLudoWinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemLudoWinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_ludo_win, viewGroup, z, obj);
    }

    public static ItemLudoWinBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemLudoWinBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemLudoWinBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_ludo_win, (ViewGroup) null, false, obj);
    }
}
