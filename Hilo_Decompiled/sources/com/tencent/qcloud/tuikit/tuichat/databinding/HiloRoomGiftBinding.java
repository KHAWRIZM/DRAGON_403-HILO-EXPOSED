package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomGiftBinding extends ViewDataBinding {
    public final TextView giftNumber;
    public final ImageView giftPic;
    public final ConstraintLayout msgContentFrame;
    public final TextView receiverUserName;
    public final TextView send;
    public final TextView text1;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomGiftBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.giftNumber = textView;
        this.giftPic = imageView;
        this.msgContentFrame = constraintLayout;
        this.receiverUserName = textView2;
        this.send = textView3;
        this.text1 = textView4;
    }

    public static HiloRoomGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomGiftBinding bind(View view, Object obj) {
        return (HiloRoomGiftBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_gift);
    }

    @Deprecated
    public static HiloRoomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_gift, viewGroup, z, obj);
    }

    public static HiloRoomGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_gift, (ViewGroup) null, false, obj);
    }
}
