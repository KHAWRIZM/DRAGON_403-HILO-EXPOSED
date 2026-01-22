package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageLinkBinding extends ViewDataBinding {
    public final LinearLayout customContentView;
    public final ImageView image;
    public final TextView tvContent;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageLinkBinding(Object obj, View view, int i, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.customContentView = linearLayout;
        this.image = imageView;
        this.tvContent = textView;
    }

    public static HiloMessageLinkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageLinkBinding bind(View view, Object obj) {
        return (HiloMessageLinkBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_link);
    }

    @Deprecated
    public static HiloMessageLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_link, viewGroup, z, obj);
    }

    public static HiloMessageLinkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_link, (ViewGroup) null, false, obj);
    }
}
