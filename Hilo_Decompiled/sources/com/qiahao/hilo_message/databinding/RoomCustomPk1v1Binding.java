package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.hilo_message.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RoomCustomPk1v1Binding extends ViewDataBinding {
    public final TextView content;
    public final ImageView image;

    public RoomCustomPk1v1Binding(Object obj, View view, int i10, TextView textView, ImageView imageView) {
        super(obj, view, i10);
        this.content = textView;
        this.image = imageView;
    }

    public static RoomCustomPk1v1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomPk1v1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomPk1v1Binding bind(View view, Object obj) {
        return (RoomCustomPk1v1Binding) ViewDataBinding.bind(obj, view, R.layout.room_custom_pk1v1);
    }

    @Deprecated
    public static RoomCustomPk1v1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomPk1v1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_pk1v1, viewGroup, z10, obj);
    }

    public static RoomCustomPk1v1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomPk1v1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomPk1v1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_pk1v1, null, false, obj);
    }
}
