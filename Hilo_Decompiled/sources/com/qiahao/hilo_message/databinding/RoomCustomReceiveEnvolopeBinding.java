package com.qiahao.hilo_message.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.hilo_message.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class RoomCustomReceiveEnvolopeBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ImageView bg;
    public final ConstraintLayout msgContent;
    public final ProgressBar progress;
    public final ConstraintLayout stateLayout;
    public final ImageView statusImg;
    public final TextView title;
    public final IncludeMessageTitleBinding titleLayout;

    public RoomCustomReceiveEnvolopeBinding(Object obj, View view, int i10, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, ConstraintLayout constraintLayout, ProgressBar progressBar, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView, IncludeMessageTitleBinding includeMessageTitleBinding) {
        super(obj, view, i10);
        this.avatar = qMUIRadiusImageView;
        this.bg = imageView;
        this.msgContent = constraintLayout;
        this.progress = progressBar;
        this.stateLayout = constraintLayout2;
        this.statusImg = imageView2;
        this.title = textView;
        this.titleLayout = includeMessageTitleBinding;
    }

    public static RoomCustomReceiveEnvolopeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomReceiveEnvolopeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomReceiveEnvolopeBinding bind(View view, Object obj) {
        return (RoomCustomReceiveEnvolopeBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_receive_envolope);
    }

    @Deprecated
    public static RoomCustomReceiveEnvolopeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomReceiveEnvolopeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_receive_envolope, viewGroup, z10, obj);
    }

    public static RoomCustomReceiveEnvolopeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomReceiveEnvolopeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomReceiveEnvolopeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_receive_envolope, null, false, obj);
    }
}
