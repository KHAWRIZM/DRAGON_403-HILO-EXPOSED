package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.hilo_message.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RoomCustomGlobalGiftBinding extends ViewDataBinding {
    public final TextView giftTipText;
    public final ConstraintLayout msgContent;

    public RoomCustomGlobalGiftBinding(Object obj, View view, int i10, TextView textView, ConstraintLayout constraintLayout) {
        super(obj, view, i10);
        this.giftTipText = textView;
        this.msgContent = constraintLayout;
    }

    public static RoomCustomGlobalGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomGlobalGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomGlobalGiftBinding bind(View view, Object obj) {
        return (RoomCustomGlobalGiftBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_global_gift);
    }

    @Deprecated
    public static RoomCustomGlobalGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomGlobalGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_global_gift, viewGroup, z10, obj);
    }

    public static RoomCustomGlobalGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomGlobalGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomGlobalGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_global_gift, null, false, obj);
    }
}
