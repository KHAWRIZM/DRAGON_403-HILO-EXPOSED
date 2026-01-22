package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemVideoImGiftBinding extends ViewDataBinding {
    public final ImageView giftIcon;
    public final TextView number;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemVideoImGiftBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.giftIcon = imageView;
        this.number = textView;
        this.title = textView2;
    }

    public static ItemVideoImGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemVideoImGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemVideoImGiftBinding bind(View view, Object obj) {
        return (ItemVideoImGiftBinding) ViewDataBinding.bind(obj, view, R.layout.item_video_im_gift);
    }

    @Deprecated
    public static ItemVideoImGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemVideoImGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video_im_gift, viewGroup, z, obj);
    }

    public static ItemVideoImGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemVideoImGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemVideoImGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_video_im_gift, (ViewGroup) null, false, obj);
    }
}
