package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.hilo.C2CInputView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloChatLayoutBinding extends ViewDataBinding {
    public final C2CInputView chatInputLayout;
    public final MessageRecyclerView chatMessageLayout;
    public final ImageView recordingIcon;
    public final TextView recordingTips;
    public final TextView svipTip;
    public final RelativeLayout voiceRecordingView;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloChatLayoutBinding(Object obj, View view, int i, C2CInputView c2CInputView, MessageRecyclerView messageRecyclerView, ImageView imageView, TextView textView, TextView textView2, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.chatInputLayout = c2CInputView;
        this.chatMessageLayout = messageRecyclerView;
        this.recordingIcon = imageView;
        this.recordingTips = textView;
        this.svipTip = textView2;
        this.voiceRecordingView = relativeLayout;
    }

    public static HiloChatLayoutBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloChatLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloChatLayoutBinding bind(View view, Object obj) {
        return (HiloChatLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_chat_layout);
    }

    @Deprecated
    public static HiloChatLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloChatLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_chat_layout, viewGroup, z, obj);
    }

    public static HiloChatLayoutBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloChatLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloChatLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_chat_layout, (ViewGroup) null, false, obj);
    }
}
