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
public abstract class RoomMessageImageBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final QMUIRadiusImageView contentImageIv;
    public final ConstraintLayout msgContent;
    public final ProgressBar progress;
    public final ConstraintLayout stateLayout;
    public final ImageView statusImg;
    public final IncludeMessageTitleBinding titleLayout;
    public final TextView videoDurationTv;
    public final ImageView videoPlayBtn;

    public RoomMessageImageBinding(Object obj, View view, int i10, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, ConstraintLayout constraintLayout, ProgressBar progressBar, ConstraintLayout constraintLayout2, ImageView imageView, IncludeMessageTitleBinding includeMessageTitleBinding, TextView textView, ImageView imageView2) {
        super(obj, view, i10);
        this.avatar = qMUIRadiusImageView;
        this.contentImageIv = qMUIRadiusImageView2;
        this.msgContent = constraintLayout;
        this.progress = progressBar;
        this.stateLayout = constraintLayout2;
        this.statusImg = imageView;
        this.titleLayout = includeMessageTitleBinding;
        this.videoDurationTv = textView;
        this.videoPlayBtn = imageView2;
    }

    public static RoomMessageImageBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomMessageImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomMessageImageBinding bind(View view, Object obj) {
        return (RoomMessageImageBinding) ViewDataBinding.bind(obj, view, R.layout.room_message_image);
    }

    @Deprecated
    public static RoomMessageImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomMessageImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_message_image, viewGroup, z10, obj);
    }

    public static RoomMessageImageBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomMessageImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomMessageImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_message_image, null, false, obj);
    }
}
