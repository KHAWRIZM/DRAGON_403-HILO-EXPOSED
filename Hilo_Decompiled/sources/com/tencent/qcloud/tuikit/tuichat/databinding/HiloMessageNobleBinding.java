package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class HiloMessageNobleBinding extends ViewDataBinding {
    public final ImageView imagView;
    public final LinearLayout messageContainer;
    public final AppCompatTextView subtitleTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public HiloMessageNobleBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.imagView = imageView;
        this.messageContainer = linearLayout;
        this.subtitleTextView = appCompatTextView;
    }

    public static HiloMessageNobleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static HiloMessageNobleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static HiloMessageNobleBinding bind(View view, Object obj) {
        return (HiloMessageNobleBinding) ViewDataBinding.bind(obj, view, R.layout.hilo_message_noble);
    }

    @Deprecated
    public static HiloMessageNobleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HiloMessageNobleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_noble, viewGroup, z, obj);
    }

    public static HiloMessageNobleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static HiloMessageNobleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HiloMessageNobleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.hilo_message_noble, (ViewGroup) null, false, obj);
    }
}
