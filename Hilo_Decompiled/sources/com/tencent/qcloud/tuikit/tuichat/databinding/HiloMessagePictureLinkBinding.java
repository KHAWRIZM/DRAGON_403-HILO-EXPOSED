package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessagePictureLinkBinding extends ViewDataBinding {
    public final TextView go;
    public final QMUIRadiusImageView image;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessagePictureLinkBinding(Object obj, View view, int i, TextView textView, QMUIRadiusImageView qMUIRadiusImageView, TextView textView2) {
        super(obj, view, i);
        this.go = textView;
        this.image = qMUIRadiusImageView;
        this.title = textView2;
    }

    public static HiloMessagePictureLinkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessagePictureLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessagePictureLinkBinding bind(View view, Object obj) {
        return (HiloMessagePictureLinkBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_picture_link);
    }

    @Deprecated
    public static HiloMessagePictureLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessagePictureLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_picture_link, viewGroup, z, obj);
    }

    public static HiloMessagePictureLinkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessagePictureLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessagePictureLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_picture_link, (ViewGroup) null, false, obj);
    }
}
