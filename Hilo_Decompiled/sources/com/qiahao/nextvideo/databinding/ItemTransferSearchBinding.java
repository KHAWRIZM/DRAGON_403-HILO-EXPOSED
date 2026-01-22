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
public abstract class ItemTransferSearchBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final View line;
    public final TextView nickName;
    public final ImageView svipType;
    public final TextView userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemTransferSearchBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, View view2, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.line = view2;
        this.nickName = textView;
        this.svipType = imageView;
        this.userId = textView2;
    }

    public static ItemTransferSearchBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemTransferSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemTransferSearchBinding bind(View view, Object obj) {
        return (ItemTransferSearchBinding) ViewDataBinding.bind(obj, view, R.layout.item_transfer_search);
    }

    @Deprecated
    public static ItemTransferSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTransferSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_transfer_search, viewGroup, z, obj);
    }

    public static ItemTransferSearchBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemTransferSearchBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTransferSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_transfer_search, (ViewGroup) null, false, obj);
    }
}
