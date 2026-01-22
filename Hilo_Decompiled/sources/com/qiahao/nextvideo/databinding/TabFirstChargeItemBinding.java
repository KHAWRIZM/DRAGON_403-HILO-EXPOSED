package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class TabFirstChargeItemBinding extends ViewDataBinding {
    public final ImageView bg;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public TabFirstChargeItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.bg = imageView;
        this.title = textView;
    }

    public static TabFirstChargeItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static TabFirstChargeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static TabFirstChargeItemBinding bind(View view, Object obj) {
        return (TabFirstChargeItemBinding) ViewDataBinding.bind(obj, view, R.layout.tab_first_charge_item);
    }

    @Deprecated
    public static TabFirstChargeItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TabFirstChargeItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.tab_first_charge_item, viewGroup, z, obj);
    }

    public static TabFirstChargeItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static TabFirstChargeItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TabFirstChargeItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.tab_first_charge_item, (ViewGroup) null, false, obj);
    }
}
