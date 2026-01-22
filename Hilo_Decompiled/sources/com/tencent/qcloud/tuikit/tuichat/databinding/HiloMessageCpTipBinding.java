package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageCpTipBinding extends ViewDataBinding {
    public final ConstraintLayout allContent;
    public final TextView content;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageCpTipBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.allContent = constraintLayout;
        this.content = textView;
    }

    public static HiloMessageCpTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageCpTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageCpTipBinding bind(View view, Object obj) {
        return (HiloMessageCpTipBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_cp_tip);
    }

    @Deprecated
    public static HiloMessageCpTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageCpTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_cp_tip, viewGroup, z, obj);
    }

    public static HiloMessageCpTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageCpTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageCpTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_cp_tip, (ViewGroup) null, false, obj);
    }
}
