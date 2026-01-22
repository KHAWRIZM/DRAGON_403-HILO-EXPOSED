package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomTipBinding extends ViewDataBinding {
    public final TextView contentText;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomTipBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.contentText = textView;
    }

    public static HiloRoomTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomTipBinding bind(View view, Object obj) {
        return (HiloRoomTipBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_tip);
    }

    @Deprecated
    public static HiloRoomTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_tip, viewGroup, z, obj);
    }

    public static HiloRoomTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_tip, (ViewGroup) null, false, obj);
    }
}
