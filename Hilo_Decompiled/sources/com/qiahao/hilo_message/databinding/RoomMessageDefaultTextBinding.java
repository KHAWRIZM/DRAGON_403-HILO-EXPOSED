package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.hilo_message.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RoomMessageDefaultTextBinding extends ViewDataBinding {
    public final TextView chatTip;
    public final TextView messageTime;

    public RoomMessageDefaultTextBinding(Object obj, View view, int i10, TextView textView, TextView textView2) {
        super(obj, view, i10);
        this.chatTip = textView;
        this.messageTime = textView2;
    }

    public static RoomMessageDefaultTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomMessageDefaultTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomMessageDefaultTextBinding bind(View view, Object obj) {
        return (RoomMessageDefaultTextBinding) ViewDataBinding.bind(obj, view, R.layout.room_message_default_text);
    }

    @Deprecated
    public static RoomMessageDefaultTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomMessageDefaultTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_message_default_text, viewGroup, z10, obj);
    }

    public static RoomMessageDefaultTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomMessageDefaultTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomMessageDefaultTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_message_default_text, null, false, obj);
    }
}
