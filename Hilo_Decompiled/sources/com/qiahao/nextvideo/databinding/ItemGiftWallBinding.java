package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGiftWallBinding extends ViewDataBinding {
    public final ImageView giftPic;
    public final ImageView giftPicNumber;
    public final HiloImageView receiverAvatar;
    public final ImageView receiverIconNoble;
    public final ImageView receiverIconVip;
    public final HiloImageView sendAvatar;
    public final ImageView sendIconNoble;
    public final ImageView sendIconVip;
    public final TextView userName1;
    public final TextView userName2;
    public final View viewBackGroup;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGiftWallBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, HiloImageView hiloImageView, ImageView imageView3, ImageView imageView4, HiloImageView hiloImageView2, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.giftPic = imageView;
        this.giftPicNumber = imageView2;
        this.receiverAvatar = hiloImageView;
        this.receiverIconNoble = imageView3;
        this.receiverIconVip = imageView4;
        this.sendAvatar = hiloImageView2;
        this.sendIconNoble = imageView5;
        this.sendIconVip = imageView6;
        this.userName1 = textView;
        this.userName2 = textView2;
        this.viewBackGroup = view2;
    }

    public static ItemGiftWallBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGiftWallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGiftWallBinding bind(View view, Object obj) {
        return (ItemGiftWallBinding) ViewDataBinding.bind(obj, view, R.layout.item_gift_wall);
    }

    @Deprecated
    public static ItemGiftWallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGiftWallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gift_wall, viewGroup, z, obj);
    }

    public static ItemGiftWallBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGiftWallBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGiftWallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gift_wall, (ViewGroup) null, false, obj);
    }
}
