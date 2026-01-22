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
public abstract class ItemSearchUserBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final View line;
    public final TextView nickName;
    public final ImageView svipType;
    public final TextView userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSearchUserBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, View view2, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.line = view2;
        this.nickName = textView;
        this.svipType = imageView;
        this.userId = textView2;
    }

    public static ItemSearchUserBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemSearchUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemSearchUserBinding bind(View view, Object obj) {
        return (ItemSearchUserBinding) ViewDataBinding.bind(obj, view, R.layout.item_search_user);
    }

    @Deprecated
    public static ItemSearchUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSearchUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_user, viewGroup, z, obj);
    }

    public static ItemSearchUserBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemSearchUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSearchUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_user, (ViewGroup) null, false, obj);
    }
}
