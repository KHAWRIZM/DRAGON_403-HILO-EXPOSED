package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomUnNoBinding extends ViewDataBinding {
    public final TextView text;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomUnNoBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.text = textView;
    }

    public static HiloRoomUnNoBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomUnNoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomUnNoBinding bind(View view, Object obj) {
        return (HiloRoomUnNoBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_un_no);
    }

    @Deprecated
    public static HiloRoomUnNoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomUnNoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_un_no, viewGroup, z, obj);
    }

    public static HiloRoomUnNoBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomUnNoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomUnNoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_un_no, (ViewGroup) null, false, obj);
    }
}
