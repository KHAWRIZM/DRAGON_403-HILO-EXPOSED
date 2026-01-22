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
public abstract class RoomMessageNoSupportCostomBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView msgBodyTv;
    public final ConstraintLayout msgContent;
    public final ProgressBar progress;
    public final ConstraintLayout stateLayout;
    public final ImageView statusImg;
    public final IncludeMessageTitleBinding titleLayout;

    public RoomMessageNoSupportCostomBinding(Object obj, View view, int i10, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, ConstraintLayout constraintLayout, ProgressBar progressBar, ConstraintLayout constraintLayout2, ImageView imageView, IncludeMessageTitleBinding includeMessageTitleBinding) {
        super(obj, view, i10);
        this.avatar = qMUIRadiusImageView;
        this.msgBodyTv = textView;
        this.msgContent = constraintLayout;
        this.progress = progressBar;
        this.stateLayout = constraintLayout2;
        this.statusImg = imageView;
        this.titleLayout = includeMessageTitleBinding;
    }

    public static RoomMessageNoSupportCostomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static RoomMessageNoSupportCostomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static RoomMessageNoSupportCostomBinding bind(View view, Object obj) {
        return (RoomMessageNoSupportCostomBinding) ViewDataBinding.bind(obj, view, R.layout.room_message_no_support_costom);
    }

    @Deprecated
    public static RoomMessageNoSupportCostomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (RoomMessageNoSupportCostomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_message_no_support_costom, viewGroup, z10, obj);
    }

    public static RoomMessageNoSupportCostomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static RoomMessageNoSupportCostomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (RoomMessageNoSupportCostomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.room_message_no_support_costom, null, false, obj);
    }
}
