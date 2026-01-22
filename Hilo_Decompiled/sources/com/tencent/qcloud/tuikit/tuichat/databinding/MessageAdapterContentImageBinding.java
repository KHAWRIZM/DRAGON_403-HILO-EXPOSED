package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class MessageAdapterContentImageBinding extends ViewDataBinding {
    public final ImageView contentImageIv;
    public final TextView videoDurationTv;
    public final ImageView videoPlayBtn;

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageAdapterContentImageBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2) {
        super(obj, view, i);
        this.contentImageIv = imageView;
        this.videoDurationTv = textView;
        this.videoPlayBtn = imageView2;
    }

    public static MessageAdapterContentImageBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static MessageAdapterContentImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static MessageAdapterContentImageBinding bind(View view, Object obj) {
        return (MessageAdapterContentImageBinding) ViewDataBinding.bind(obj, view, R.layout.message_adapter_content_image);
    }

    @Deprecated
    public static MessageAdapterContentImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MessageAdapterContentImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.message_adapter_content_image, viewGroup, z, obj);
    }

    public static MessageAdapterContentImageBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static MessageAdapterContentImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MessageAdapterContentImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.message_adapter_content_image, (ViewGroup) null, false, obj);
    }
}
