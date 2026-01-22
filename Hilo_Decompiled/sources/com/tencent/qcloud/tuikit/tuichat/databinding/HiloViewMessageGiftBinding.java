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
public abstract class HiloViewMessageGiftBinding extends ViewDataBinding {
    public final TextView giftNumber;
    public final ImageView giftPic;
    public final TextView text1;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloViewMessageGiftBinding(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2) {
        super(obj, view, i);
        this.giftNumber = textView;
        this.giftPic = imageView;
        this.text1 = textView2;
    }

    public static HiloViewMessageGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloViewMessageGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloViewMessageGiftBinding bind(View view, Object obj) {
        return (HiloViewMessageGiftBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_view_message_gift);
    }

    @Deprecated
    public static HiloViewMessageGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloViewMessageGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_view_message_gift, viewGroup, z, obj);
    }

    public static HiloViewMessageGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloViewMessageGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloViewMessageGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_view_message_gift, (ViewGroup) null, false, obj);
    }
}
