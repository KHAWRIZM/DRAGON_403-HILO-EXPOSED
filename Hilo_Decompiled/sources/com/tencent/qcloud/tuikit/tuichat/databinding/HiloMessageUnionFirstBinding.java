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
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageUnionFirstBinding extends ViewDataBinding {
    public final TextView chatTimeTv;
    public final ConstraintLayout clContent;
    public final ImageView contentImageIv;
    public final ImageView giftPic1;
    public final ImageView giftPic2;
    public final ImageView giftPic3;
    public final ImageView giftPic4;
    public final TextView giftValue1;
    public final TextView giftValue2;
    public final TextView giftValue3;
    public final TextView giftValue4;
    public final QMUIRadiusImageView leftUserIconView;
    public final QMUIRadiusImageView leftUserIconViews;
    public final TextView messageContainer;
    public final TextView msgBodyTv;
    public final LinearLayout msgContentLl;
    public final QMUIRadiusImageView rightUserIconView;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageUnionFirstBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView2, TextView textView3, TextView textView4, TextView textView5, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView6, TextView textView7, LinearLayout linearLayout, QMUIRadiusImageView qMUIRadiusImageView3) {
        super(obj, view, i);
        this.chatTimeTv = textView;
        this.clContent = constraintLayout;
        this.contentImageIv = imageView;
        this.giftPic1 = imageView2;
        this.giftPic2 = imageView3;
        this.giftPic3 = imageView4;
        this.giftPic4 = imageView5;
        this.giftValue1 = textView2;
        this.giftValue2 = textView3;
        this.giftValue3 = textView4;
        this.giftValue4 = textView5;
        this.leftUserIconView = qMUIRadiusImageView;
        this.leftUserIconViews = qMUIRadiusImageView2;
        this.messageContainer = textView6;
        this.msgBodyTv = textView7;
        this.msgContentLl = linearLayout;
        this.rightUserIconView = qMUIRadiusImageView3;
    }

    public static HiloMessageUnionFirstBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageUnionFirstBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageUnionFirstBinding bind(View view, Object obj) {
        return (HiloMessageUnionFirstBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_union_first);
    }

    @Deprecated
    public static HiloMessageUnionFirstBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageUnionFirstBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_union_first, viewGroup, z, obj);
    }

    public static HiloMessageUnionFirstBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageUnionFirstBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageUnionFirstBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_union_first, (ViewGroup) null, false, obj);
    }
}
