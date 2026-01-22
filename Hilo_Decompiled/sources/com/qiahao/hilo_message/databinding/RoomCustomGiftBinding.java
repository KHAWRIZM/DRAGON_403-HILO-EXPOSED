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
public abstract class RoomCustomGiftBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView giftNumber;
    public final ImageView giftPic;
    public final ConstraintLayout msgContent;
    public final ProgressBar progress;
    public final TextView receiverUserName;
    public final TextView send;
    public final ConstraintLayout stateLayout;
    public final ImageView statusImg;
    public final TextView text1;
    public final IncludeMessageTitleBinding titleLayout;

    public RoomCustomGiftBinding(Object obj, View view, int i10, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, ProgressBar progressBar, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView4, IncludeMessageTitleBinding includeMessageTitleBinding) {
        super(obj, view, i10);
        this.avatar = qMUIRadiusImageView;
        this.giftNumber = textView;
        this.giftPic = imageView;
        this.msgContent = constraintLayout;
        this.progress = progressBar;
        this.receiverUserName = textView2;
        this.send = textView3;
        this.stateLayout = constraintLayout2;
        this.statusImg = imageView2;
        this.text1 = textView4;
        this.titleLayout = includeMessageTitleBinding;
    }

    public static RoomCustomGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomCustomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomCustomGiftBinding bind(View view, Object obj) {
        return (RoomCustomGiftBinding) ViewDataBinding.bind(obj, view, R.layout.room_custom_gift);
    }

    @Deprecated
    public static RoomCustomGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomCustomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_gift, viewGroup, z10, obj);
    }

    public static RoomCustomGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomCustomGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomCustomGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_custom_gift, null, false, obj);
    }
}
