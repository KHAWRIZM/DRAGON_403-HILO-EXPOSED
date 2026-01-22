package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemDiscoverBannerBinding extends ViewDataBinding {
    public final QMUIRadiusImageView bannerPic;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemDiscoverBannerBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView) {
        super(obj, view, i);
        this.bannerPic = qMUIRadiusImageView;
    }

    public static ItemDiscoverBannerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemDiscoverBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemDiscoverBannerBinding bind(View view, Object obj) {
        return (ItemDiscoverBannerBinding) ViewDataBinding.bind(obj, view, R.layout.item_discover_banner);
    }

    @Deprecated
    public static ItemDiscoverBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDiscoverBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_discover_banner, viewGroup, z, obj);
    }

    public static ItemDiscoverBannerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemDiscoverBannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDiscoverBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_discover_banner, (ViewGroup) null, false, obj);
    }
}
