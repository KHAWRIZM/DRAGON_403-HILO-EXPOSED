package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageShareRoomBinding extends ViewDataBinding {
    public final QMUIRadiusImageView imageRoomAvatar;
    public final LinearLayout messageContainer;
    public final AppCompatTextView subtitleTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageShareRoomBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.imageRoomAvatar = qMUIRadiusImageView;
        this.messageContainer = linearLayout;
        this.subtitleTextView = appCompatTextView;
    }

    public static HiloMessageShareRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageShareRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageShareRoomBinding bind(View view, Object obj) {
        return (HiloMessageShareRoomBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_share_room);
    }

    @Deprecated
    public static HiloMessageShareRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageShareRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_share_room, viewGroup, z, obj);
    }

    public static HiloMessageShareRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageShareRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageShareRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_share_room, (ViewGroup) null, false, obj);
    }
}
