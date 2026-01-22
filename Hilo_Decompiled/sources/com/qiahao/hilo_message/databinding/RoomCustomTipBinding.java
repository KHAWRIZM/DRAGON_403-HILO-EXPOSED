package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.hilo_message.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RoomCustomTipBinding extends ViewDataBinding {
    public final TextView contentText;

    public RoomCustomTipBinding(Object obj, View view, int i10, TextView textView) {
        super(obj, view, i10);
        this.contentText = textView;
    }

    public static RoomCustomTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomTipBinding bind(View view, Object obj) {
        return (RoomCustomTipBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_tip);
    }

    @Deprecated
    public static RoomCustomTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_tip, viewGroup, z10, obj);
    }

    public static RoomCustomTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_tip, null, false, obj);
    }
}
