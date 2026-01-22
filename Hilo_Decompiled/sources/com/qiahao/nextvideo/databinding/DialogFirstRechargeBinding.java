package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogFirstRechargeBinding extends ViewDataBinding {
    public final ImageView closeImage;
    public final ImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogFirstRechargeBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.closeImage = imageView;
        this.image = imageView2;
    }

    public static DialogFirstRechargeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogFirstRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogFirstRechargeBinding bind(View view, Object obj) {
        return (DialogFirstRechargeBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_first_recharge);
    }

    @Deprecated
    public static DialogFirstRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogFirstRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_first_recharge, viewGroup, z, obj);
    }

    public static DialogFirstRechargeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogFirstRechargeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogFirstRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_first_recharge, (ViewGroup) null, false, obj);
    }
}
