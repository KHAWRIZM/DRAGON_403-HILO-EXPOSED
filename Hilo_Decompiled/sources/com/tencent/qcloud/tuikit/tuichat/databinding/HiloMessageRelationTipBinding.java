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
public abstract class HiloMessageRelationTipBinding extends ViewDataBinding {
    public final ConstraintLayout allContent;
    public final TextView content;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageRelationTipBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.allContent = constraintLayout;
        this.content = textView;
    }

    public static HiloMessageRelationTipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageRelationTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageRelationTipBinding bind(View view, Object obj) {
        return (HiloMessageRelationTipBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_relation_tip);
    }

    @Deprecated
    public static HiloMessageRelationTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageRelationTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_relation_tip, viewGroup, z, obj);
    }

    public static HiloMessageRelationTipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageRelationTipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageRelationTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_relation_tip, (ViewGroup) null, false, obj);
    }
}
