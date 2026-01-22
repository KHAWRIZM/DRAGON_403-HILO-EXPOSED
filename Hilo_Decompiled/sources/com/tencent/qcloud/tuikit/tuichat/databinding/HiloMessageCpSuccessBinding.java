package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageCpSuccessBinding extends ViewDataBinding {
    public final ConstraintLayout allContent;
    public final QMUIRadiusImageView avatar1;
    public final QMUIRadiusImageView avatar2;
    public final TextView goZone;
    public final ImageView image;
    public final UserIconView leftUserIconView;
    public final ImageView love;
    public final LinearLayout msgContentLl;
    public final UserIconView rightUserIconView;
    public final TextView subTitle;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageCpSuccessBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView, ImageView imageView, UserIconView userIconView, ImageView imageView2, LinearLayout linearLayout, UserIconView userIconView2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.allContent = constraintLayout;
        this.avatar1 = qMUIRadiusImageView;
        this.avatar2 = qMUIRadiusImageView2;
        this.goZone = textView;
        this.image = imageView;
        this.leftUserIconView = userIconView;
        this.love = imageView2;
        this.msgContentLl = linearLayout;
        this.rightUserIconView = userIconView2;
        this.subTitle = textView2;
        this.title = textView3;
    }

    public static HiloMessageCpSuccessBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageCpSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageCpSuccessBinding bind(View view, Object obj) {
        return (HiloMessageCpSuccessBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_cp_success);
    }

    @Deprecated
    public static HiloMessageCpSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageCpSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_cp_success, viewGroup, z, obj);
    }

    public static HiloMessageCpSuccessBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageCpSuccessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageCpSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_cp_success, (ViewGroup) null, false, obj);
    }
}
