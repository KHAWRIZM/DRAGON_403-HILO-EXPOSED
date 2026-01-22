package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomPk1v1Binding extends ViewDataBinding {
    public final TextView content;
    public final ImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomPk1v1Binding(Object obj, View view, int i, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.content = textView;
        this.image = imageView;
    }

    public static HiloRoomPk1v1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomPk1v1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomPk1v1Binding bind(View view, Object obj) {
        return (HiloRoomPk1v1Binding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_pk1v1);
    }

    @Deprecated
    public static HiloRoomPk1v1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomPk1v1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_pk1v1, viewGroup, z, obj);
    }

    public static HiloRoomPk1v1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomPk1v1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomPk1v1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_pk1v1, (ViewGroup) null, false, obj);
    }
}
