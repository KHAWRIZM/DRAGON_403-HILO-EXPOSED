package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRoomGiftCustomizeBinding extends ViewDataBinding {
    public final ImageView addImage;
    public final View bg;
    public final ConstraintLayout content;
    public final TextView customize;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRoomGiftCustomizeBinding(Object obj, View view, int i, ImageView imageView, View view2, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.addImage = imageView;
        this.bg = view2;
        this.content = constraintLayout;
        this.customize = textView;
    }

    public static ItemRoomGiftCustomizeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRoomGiftCustomizeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRoomGiftCustomizeBinding bind(View view, Object obj) {
        return (ItemRoomGiftCustomizeBinding) ViewDataBinding.bind(obj, view, R.layout.item_room_gift_customize);
    }

    @Deprecated
    public static ItemRoomGiftCustomizeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRoomGiftCustomizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_gift_customize, viewGroup, z, obj);
    }

    public static ItemRoomGiftCustomizeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRoomGiftCustomizeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRoomGiftCustomizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_gift_customize, (ViewGroup) null, false, obj);
    }
}
