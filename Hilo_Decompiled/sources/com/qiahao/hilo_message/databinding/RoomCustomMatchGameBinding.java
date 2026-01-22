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
public abstract class RoomCustomMatchGameBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView content;
    public final ImageView gameImage;
    public final ImageView image;
    public final ConstraintLayout msgContent;
    public final ProgressBar progress;
    public final ConstraintLayout stateLayout;
    public final ImageView statusImg;
    public final IncludeMessageTitleBinding titleLayout;

    public RoomCustomMatchGameBinding(Object obj, View view, int i10, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, ProgressBar progressBar, ConstraintLayout constraintLayout2, ImageView imageView3, IncludeMessageTitleBinding includeMessageTitleBinding) {
        super(obj, view, i10);
        this.avatar = qMUIRadiusImageView;
        this.content = textView;
        this.gameImage = imageView;
        this.image = imageView2;
        this.msgContent = constraintLayout;
        this.progress = progressBar;
        this.stateLayout = constraintLayout2;
        this.statusImg = imageView3;
        this.titleLayout = includeMessageTitleBinding;
    }

    public static RoomCustomMatchGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomMatchGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomMatchGameBinding bind(View view, Object obj) {
        return (RoomCustomMatchGameBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_match_game);
    }

    @Deprecated
    public static RoomCustomMatchGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomMatchGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_match_game, viewGroup, z10, obj);
    }

    public static RoomCustomMatchGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomMatchGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomMatchGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_match_game, null, false, obj);
    }
}
