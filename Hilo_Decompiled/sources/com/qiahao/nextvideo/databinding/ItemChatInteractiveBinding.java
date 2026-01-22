package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemChatInteractiveBinding extends ViewDataBinding {
    public final RoundedImageView imgPic;
    public final ImageView tipImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemChatInteractiveBinding(Object obj, View view, int i, RoundedImageView roundedImageView, ImageView imageView) {
        super(obj, view, i);
        this.imgPic = roundedImageView;
        this.tipImage = imageView;
    }

    public static ItemChatInteractiveBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemChatInteractiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemChatInteractiveBinding bind(View view, Object obj) {
        return (ItemChatInteractiveBinding) ViewDataBinding.bind(obj, view, R.layout.item_chat_interactive);
    }

    @Deprecated
    public static ItemChatInteractiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChatInteractiveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_interactive, viewGroup, z, obj);
    }

    public static ItemChatInteractiveBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemChatInteractiveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChatInteractiveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_chat_interactive, (ViewGroup) null, false, obj);
    }
}
