package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.hilo_message.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RoomCustomJoinUserBinding extends ViewDataBinding {
    public final QMUIRadiusImageView otherUserAvatar;
    public final QMUIRadiusImageView userAvatar;
    public final TextView userJoinContent;

    public RoomCustomJoinUserBinding(Object obj, View view, int i10, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView) {
        super(obj, view, i10);
        this.otherUserAvatar = qMUIRadiusImageView;
        this.userAvatar = qMUIRadiusImageView2;
        this.userJoinContent = textView;
    }

    public static RoomCustomJoinUserBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomJoinUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomJoinUserBinding bind(View view, Object obj) {
        return (RoomCustomJoinUserBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_join_user);
    }

    @Deprecated
    public static RoomCustomJoinUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomJoinUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_join_user, viewGroup, z10, obj);
    }

    public static RoomCustomJoinUserBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomJoinUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomJoinUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_join_user, null, false, obj);
    }
}
