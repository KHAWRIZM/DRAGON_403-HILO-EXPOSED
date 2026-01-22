package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageVideoCallBinding extends ViewDataBinding {
    public final FrameLayout allContent;
    public final TextView text;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageVideoCallBinding(Object obj, View view, int i, FrameLayout frameLayout, TextView textView) {
        super(obj, view, i);
        this.allContent = frameLayout;
        this.text = textView;
    }

    public static HiloMessageVideoCallBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageVideoCallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageVideoCallBinding bind(View view, Object obj) {
        return (HiloMessageVideoCallBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_video_call);
    }

    @Deprecated
    public static HiloMessageVideoCallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageVideoCallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_video_call, viewGroup, z, obj);
    }

    public static HiloMessageVideoCallBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageVideoCallBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageVideoCallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_video_call, (ViewGroup) null, false, obj);
    }
}
