package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomEnvolopeGetBinding extends ViewDataBinding {
    public final TextView text;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomEnvolopeGetBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.text = textView;
    }

    public static HiloRoomEnvolopeGetBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomEnvolopeGetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomEnvolopeGetBinding bind(View view, Object obj) {
        return (HiloRoomEnvolopeGetBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_envolope_get);
    }

    @Deprecated
    public static HiloRoomEnvolopeGetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomEnvolopeGetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_envolope_get, viewGroup, z, obj);
    }

    public static HiloRoomEnvolopeGetBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomEnvolopeGetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomEnvolopeGetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_envolope_get, (ViewGroup) null, false, obj);
    }
}
