package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageRelationInviteBinding extends ViewDataBinding {
    public final ConstraintLayout allContent;
    public final ImageView image;
    public final TextView join;
    public final UserIconView leftUserIconView;
    public final LinearLayout msgContentLl;
    public final UserIconView rightUserIconView;
    public final TextView subTitle;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageRelationInviteBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, UserIconView userIconView, LinearLayout linearLayout, UserIconView userIconView2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.allContent = constraintLayout;
        this.image = imageView;
        this.join = textView;
        this.leftUserIconView = userIconView;
        this.msgContentLl = linearLayout;
        this.rightUserIconView = userIconView2;
        this.subTitle = textView2;
        this.title = textView3;
    }

    public static HiloMessageRelationInviteBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageRelationInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageRelationInviteBinding bind(View view, Object obj) {
        return (HiloMessageRelationInviteBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_relation_invite);
    }

    @Deprecated
    public static HiloMessageRelationInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageRelationInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_relation_invite, viewGroup, z, obj);
    }

    public static HiloMessageRelationInviteBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageRelationInviteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageRelationInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_relation_invite, (ViewGroup) null, false, obj);
    }
}
