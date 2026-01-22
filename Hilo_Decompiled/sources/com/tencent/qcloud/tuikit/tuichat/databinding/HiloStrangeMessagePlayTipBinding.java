package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloStrangeMessagePlayTipBinding extends ViewDataBinding {
    public final ConstraintLayout allContent;
    public final TextView content;
    public final ImageView tipImage;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloStrangeMessagePlayTipBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.allContent = constraintLayout;
        this.content = textView;
        this.tipImage = imageView;
        this.title = textView2;
    }

    public static HiloStrangeMessagePlayTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloStrangeMessagePlayTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloStrangeMessagePlayTipBinding bind(View view, Object obj) {
        return (HiloStrangeMessagePlayTipBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_strange_message_play_tip);
    }

    @Deprecated
    public static HiloStrangeMessagePlayTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloStrangeMessagePlayTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_strange_message_play_tip, viewGroup, z, obj);
    }

    public static HiloStrangeMessagePlayTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloStrangeMessagePlayTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloStrangeMessagePlayTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_strange_message_play_tip, (ViewGroup) null, false, obj);
    }
}
