package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageGiftBinding extends ViewDataBinding {
    public final ConstraintLayout allContent;
    public final HiloViewMessageGiftBinding giftContent;
    public final UserIconView leftUserIconView;
    public final TextView messageContainer;
    public final LinearLayout msgContentLl;
    public final UserIconView rightUserIconView;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageGiftBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, HiloViewMessageGiftBinding hiloViewMessageGiftBinding, UserIconView userIconView, TextView textView, LinearLayout linearLayout, UserIconView userIconView2) {
        super(obj, view, i);
        this.allContent = constraintLayout;
        this.giftContent = hiloViewMessageGiftBinding;
        this.leftUserIconView = userIconView;
        this.messageContainer = textView;
        this.msgContentLl = linearLayout;
        this.rightUserIconView = userIconView2;
    }

    public static HiloMessageGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageGiftBinding bind(View view, Object obj) {
        return (HiloMessageGiftBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_gift);
    }

    @Deprecated
    public static HiloMessageGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_gift, viewGroup, z, obj);
    }

    public static HiloMessageGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_gift, (ViewGroup) null, false, obj);
    }
}
