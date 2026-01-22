package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFragmentTransferBinding extends ViewDataBinding {
    public final ConstraintLayout constraintLayout;
    public final TextView diamond;
    public final TextView dollar;
    public final ImageView icon;
    public final LinearLayout topLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFragmentTransferBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.constraintLayout = constraintLayout;
        this.diamond = textView;
        this.dollar = textView2;
        this.icon = imageView;
        this.topLayout = linearLayout;
    }

    public static ItemFragmentTransferBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFragmentTransferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFragmentTransferBinding bind(View view, Object obj) {
        return (ItemFragmentTransferBinding) ViewDataBinding.bind(obj, view, R.layout.item_fragment_transfer);
    }

    @Deprecated
    public static ItemFragmentTransferBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFragmentTransferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_transfer, viewGroup, z, obj);
    }

    public static ItemFragmentTransferBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFragmentTransferBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFragmentTransferBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_transfer, (ViewGroup) null, false, obj);
    }
}
