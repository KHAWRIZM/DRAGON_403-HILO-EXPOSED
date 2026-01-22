package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomOwnWelcomeBinding extends ViewDataBinding {
    public final TextView content;
    public final ConstraintLayout msgContentFrame;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomOwnWelcomeBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.content = textView;
        this.msgContentFrame = constraintLayout;
    }

    public static HiloRoomOwnWelcomeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomOwnWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomOwnWelcomeBinding bind(View view, Object obj) {
        return (HiloRoomOwnWelcomeBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_own_welcome);
    }

    @Deprecated
    public static HiloRoomOwnWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomOwnWelcomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_own_welcome, viewGroup, z, obj);
    }

    public static HiloRoomOwnWelcomeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomOwnWelcomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomOwnWelcomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_own_welcome, (ViewGroup) null, false, obj);
    }
}
