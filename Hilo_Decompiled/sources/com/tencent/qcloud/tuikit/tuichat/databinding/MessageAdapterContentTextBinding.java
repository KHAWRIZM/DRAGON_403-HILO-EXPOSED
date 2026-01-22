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
public abstract class MessageAdapterContentTextBinding extends ViewDataBinding {
    public final TextView msgBodyTv;
    public final FrameLayout textFrame;

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageAdapterContentTextBinding(Object obj, View view, int i, TextView textView, FrameLayout frameLayout) {
        super(obj, view, i);
        this.msgBodyTv = textView;
        this.textFrame = frameLayout;
    }

    public static MessageAdapterContentTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static MessageAdapterContentTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static MessageAdapterContentTextBinding bind(View view, Object obj) {
        return (MessageAdapterContentTextBinding) ViewDataBinding.bind(obj, view, R.layout.message_adapter_content_text);
    }

    @Deprecated
    public static MessageAdapterContentTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MessageAdapterContentTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.message_adapter_content_text, viewGroup, z, obj);
    }

    public static MessageAdapterContentTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static MessageAdapterContentTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MessageAdapterContentTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.message_adapter_content_text, (ViewGroup) null, false, obj);
    }
}
