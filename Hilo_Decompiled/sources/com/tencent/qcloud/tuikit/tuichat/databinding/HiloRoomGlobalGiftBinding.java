package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomGlobalGiftBinding extends ViewDataBinding {
    public final TextView giftTipText;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomGlobalGiftBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.giftTipText = textView;
    }

    public static HiloRoomGlobalGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomGlobalGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomGlobalGiftBinding bind(View view, Object obj) {
        return (HiloRoomGlobalGiftBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_global_gift);
    }

    @Deprecated
    public static HiloRoomGlobalGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomGlobalGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_global_gift, viewGroup, z, obj);
    }

    public static HiloRoomGlobalGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomGlobalGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomGlobalGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_global_gift, (ViewGroup) null, false, obj);
    }
}
