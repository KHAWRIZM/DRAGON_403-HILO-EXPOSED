package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageCommonTextBinding extends ViewDataBinding {
    public final TextView messageContainer;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageCommonTextBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.messageContainer = textView;
    }

    public static HiloMessageCommonTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageCommonTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageCommonTextBinding bind(View view, Object obj) {
        return (HiloMessageCommonTextBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_common_text);
    }

    @Deprecated
    public static HiloMessageCommonTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageCommonTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_common_text, viewGroup, z, obj);
    }

    public static HiloMessageCommonTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageCommonTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageCommonTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_common_text, (ViewGroup) null, false, obj);
    }
}
