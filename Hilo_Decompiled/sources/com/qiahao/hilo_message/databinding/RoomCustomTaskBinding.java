package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.hilo_message.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RoomCustomTaskBinding extends ViewDataBinding {
    public final TextView contentText;
    public final LinearLayout linear;

    public RoomCustomTaskBinding(Object obj, View view, int i10, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i10);
        this.contentText = textView;
        this.linear = linearLayout;
    }

    public static RoomCustomTaskBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomTaskBinding bind(View view, Object obj) {
        return (RoomCustomTaskBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_task);
    }

    @Deprecated
    public static RoomCustomTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_task, viewGroup, z10, obj);
    }

    public static RoomCustomTaskBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_task, null, false, obj);
    }
}
