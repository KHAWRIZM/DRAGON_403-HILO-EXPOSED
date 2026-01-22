package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomRolledBinding extends ViewDataBinding {
    public final LinearLayout rollerNumber;
    public final TextView tipRoller;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomRolledBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.rollerNumber = linearLayout;
        this.tipRoller = textView;
    }

    public static HiloRoomRolledBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomRolledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomRolledBinding bind(View view, Object obj) {
        return (HiloRoomRolledBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_rolled);
    }

    @Deprecated
    public static HiloRoomRolledBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomRolledBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_rolled, viewGroup, z, obj);
    }

    public static HiloRoomRolledBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomRolledBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomRolledBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_rolled, (ViewGroup) null, false, obj);
    }
}
