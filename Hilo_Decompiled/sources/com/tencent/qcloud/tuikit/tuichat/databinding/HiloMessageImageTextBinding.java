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
public abstract class HiloMessageImageTextBinding extends ViewDataBinding {
    public final ConstraintLayout allContent;
    public final LinearLayout customContentView;
    public final ImageView image;
    public final UserIconView leftUserIconView;
    public final LinearLayout msgContentLl;
    public final UserIconView rightUserIconView;
    public final TextView tvContent;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageImageTextBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, UserIconView userIconView, LinearLayout linearLayout2, UserIconView userIconView2, TextView textView) {
        super(obj, view, i);
        this.allContent = constraintLayout;
        this.customContentView = linearLayout;
        this.image = imageView;
        this.leftUserIconView = userIconView;
        this.msgContentLl = linearLayout2;
        this.rightUserIconView = userIconView2;
        this.tvContent = textView;
    }

    public static HiloMessageImageTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageImageTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageImageTextBinding bind(View view, Object obj) {
        return (HiloMessageImageTextBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_image_text);
    }

    @Deprecated
    public static HiloMessageImageTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageImageTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_image_text, viewGroup, z, obj);
    }

    public static HiloMessageImageTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageImageTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageImageTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_image_text, (ViewGroup) null, false, obj);
    }
}
