package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemWalletBannerBinding extends ViewDataBinding {
    public final QMUIRadiusImageView imageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemWalletBannerBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView) {
        super(obj, view, i);
        this.imageView = qMUIRadiusImageView;
    }

    public static ItemWalletBannerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemWalletBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemWalletBannerBinding bind(View view, Object obj) {
        return (ItemWalletBannerBinding) ViewDataBinding.bind(obj, view, R.layout.item_wallet_banner);
    }

    @Deprecated
    public static ItemWalletBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemWalletBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_wallet_banner, viewGroup, z, obj);
    }

    public static ItemWalletBannerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemWalletBannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemWalletBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_wallet_banner, (ViewGroup) null, false, obj);
    }
}
