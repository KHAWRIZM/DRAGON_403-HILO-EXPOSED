package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageBroadcastBinding extends ViewDataBinding {
    public final UserIconView imageRoomAvatar;
    public final LinearLayout messageContainer;
    public final AppCompatTextView subtitleTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageBroadcastBinding(Object obj, View view, int i, UserIconView userIconView, LinearLayout linearLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.imageRoomAvatar = userIconView;
        this.messageContainer = linearLayout;
        this.subtitleTextView = appCompatTextView;
    }

    public static HiloMessageBroadcastBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageBroadcastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageBroadcastBinding bind(View view, Object obj) {
        return (HiloMessageBroadcastBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_broadcast);
    }

    @Deprecated
    public static HiloMessageBroadcastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageBroadcastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_broadcast, viewGroup, z, obj);
    }

    public static HiloMessageBroadcastBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageBroadcastBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageBroadcastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_broadcast, (ViewGroup) null, false, obj);
    }
}
