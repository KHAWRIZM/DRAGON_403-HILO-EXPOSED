package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageFamilyInviteBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView enter;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageFamilyInviteBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.enter = textView;
        this.title = textView2;
    }

    public static HiloMessageFamilyInviteBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageFamilyInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageFamilyInviteBinding bind(View view, Object obj) {
        return (HiloMessageFamilyInviteBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_family_invite);
    }

    @Deprecated
    public static HiloMessageFamilyInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageFamilyInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_family_invite, viewGroup, z, obj);
    }

    public static HiloMessageFamilyInviteBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageFamilyInviteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageFamilyInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_family_invite, (ViewGroup) null, false, obj);
    }
}
