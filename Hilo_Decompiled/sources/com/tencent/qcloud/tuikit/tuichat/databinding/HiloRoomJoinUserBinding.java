package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloRoomJoinUserBinding extends ViewDataBinding {
    public final QMUIRadiusImageView otherUserAvatar;
    public final QMUIRadiusImageView userAvatar;
    public final TextView userJoinContent;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloRoomJoinUserBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView) {
        super(obj, view, i);
        this.otherUserAvatar = qMUIRadiusImageView;
        this.userAvatar = qMUIRadiusImageView2;
        this.userJoinContent = textView;
    }

    public static HiloRoomJoinUserBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloRoomJoinUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloRoomJoinUserBinding bind(View view, Object obj) {
        return (HiloRoomJoinUserBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_room_join_user);
    }

    @Deprecated
    public static HiloRoomJoinUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloRoomJoinUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_join_user, viewGroup, z, obj);
    }

    public static HiloRoomJoinUserBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloRoomJoinUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloRoomJoinUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_room_join_user, (ViewGroup) null, false, obj);
    }
}
