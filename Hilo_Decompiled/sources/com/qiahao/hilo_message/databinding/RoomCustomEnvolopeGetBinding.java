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
public abstract class RoomCustomEnvolopeGetBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ConstraintLayout msgContent;
    public final ProgressBar progress;
    public final ConstraintLayout stateLayout;
    public final ImageView statusImg;
    public final TextView text;
    public final IncludeMessageTitleBinding titleLayout;

    public RoomCustomEnvolopeGetBinding(Object obj, View view, int i10, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, ProgressBar progressBar, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, IncludeMessageTitleBinding includeMessageTitleBinding) {
        super(obj, view, i10);
        this.avatar = qMUIRadiusImageView;
        this.msgContent = constraintLayout;
        this.progress = progressBar;
        this.stateLayout = constraintLayout2;
        this.statusImg = imageView;
        this.text = textView;
        this.titleLayout = includeMessageTitleBinding;
    }

    public static RoomCustomEnvolopeGetBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomEnvolopeGetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomEnvolopeGetBinding bind(View view, Object obj) {
        return (RoomCustomEnvolopeGetBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_envolope_get);
    }

    @Deprecated
    public static RoomCustomEnvolopeGetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomEnvolopeGetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_envolope_get, viewGroup, z10, obj);
    }

    public static RoomCustomEnvolopeGetBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomEnvolopeGetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomEnvolopeGetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_envolope_get, null, false, obj);
    }
}
