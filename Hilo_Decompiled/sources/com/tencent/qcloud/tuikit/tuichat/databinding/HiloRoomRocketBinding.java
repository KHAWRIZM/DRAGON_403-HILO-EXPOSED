package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomRocketBinding extends ViewDataBinding {
    public final TextView contentText;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomRocketBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.contentText = textView;
    }

    public static HiloRoomRocketBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomRocketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomRocketBinding bind(View view, Object obj) {
        return (HiloRoomRocketBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_rocket);
    }

    @Deprecated
    public static HiloRoomRocketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomRocketBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_rocket, viewGroup, z, obj);
    }

    public static HiloRoomRocketBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomRocketBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomRocketBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_rocket, (ViewGroup) null, false, obj);
    }
}
