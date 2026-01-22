package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemTransferBannerBinding extends ViewDataBinding {
    public final QMUIRadiusImageView imageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemTransferBannerBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView) {
        super(obj, view, i);
        this.imageView = qMUIRadiusImageView;
    }

    public static ItemTransferBannerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemTransferBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemTransferBannerBinding bind(View view, Object obj) {
        return (ItemTransferBannerBinding) ViewDataBinding.bind(obj, view, R.layout.item_transfer_banner);
    }

    @Deprecated
    public static ItemTransferBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTransferBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_transfer_banner, viewGroup, z, obj);
    }

    public static ItemTransferBannerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemTransferBannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTransferBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_transfer_banner, (ViewGroup) null, false, obj);
    }
}
