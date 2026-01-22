package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewGiftWallFlipperHolderBinding extends ViewDataBinding {
    public final ImageView giftPic;
    public final ImageView giftPicNumber;
    public final HiloImageView receiverAvatar;
    public final ImageView receiverIconVip;
    public final ImageView receiverNoble;
    public final HiloImageView sendAvatar;
    public final ImageView sendIconVip;
    public final ImageView sendNoble;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGiftWallFlipperHolderBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, HiloImageView hiloImageView, ImageView imageView3, ImageView imageView4, HiloImageView hiloImageView2, ImageView imageView5, ImageView imageView6) {
        super(obj, view, i);
        this.giftPic = imageView;
        this.giftPicNumber = imageView2;
        this.receiverAvatar = hiloImageView;
        this.receiverIconVip = imageView3;
        this.receiverNoble = imageView4;
        this.sendAvatar = hiloImageView2;
        this.sendIconVip = imageView5;
        this.sendNoble = imageView6;
    }

    public static ViewGiftWallFlipperHolderBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGiftWallFlipperHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGiftWallFlipperHolderBinding bind(View view, Object obj) {
        return (ViewGiftWallFlipperHolderBinding) ViewDataBinding.bind(obj, view, R.layout.view_gift_wall_flipper_holder);
    }

    @Deprecated
    public static ViewGiftWallFlipperHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGiftWallFlipperHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_gift_wall_flipper_holder, viewGroup, z, obj);
    }

    public static ViewGiftWallFlipperHolderBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGiftWallFlipperHolderBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGiftWallFlipperHolderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_gift_wall_flipper_holder, (ViewGroup) null, false, obj);
    }
}
