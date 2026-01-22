package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageSheepInviteBinding extends ViewDataBinding {
    public final ConstraintLayout allContent;
    public final QMUIRadiusImageView image;
    public final UserIconView leftUserIconView;
    public final LinearLayout msgContentLl;
    public final UserIconView rightUserIconView;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageSheepInviteBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, QMUIRadiusImageView qMUIRadiusImageView, UserIconView userIconView, LinearLayout linearLayout, UserIconView userIconView2) {
        super(obj, view, i);
        this.allContent = constraintLayout;
        this.image = qMUIRadiusImageView;
        this.leftUserIconView = userIconView;
        this.msgContentLl = linearLayout;
        this.rightUserIconView = userIconView2;
    }

    public static HiloMessageSheepInviteBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageSheepInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageSheepInviteBinding bind(View view, Object obj) {
        return (HiloMessageSheepInviteBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_sheep_invite);
    }

    @Deprecated
    public static HiloMessageSheepInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageSheepInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_sheep_invite, viewGroup, z, obj);
    }

    public static HiloMessageSheepInviteBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageSheepInviteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageSheepInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_sheep_invite, (ViewGroup) null, false, obj);
    }
}
