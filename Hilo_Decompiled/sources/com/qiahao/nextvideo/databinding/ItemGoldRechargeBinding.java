package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGoldRechargeBinding extends ViewDataBinding {
    public final ImageView gemIcon;
    public final AppCompatTextView number;
    public final TextView rechargeText;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGoldRechargeBinding(Object obj, View view, int i, ImageView imageView, AppCompatTextView appCompatTextView, TextView textView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.gemIcon = imageView;
        this.number = appCompatTextView;
        this.rechargeText = textView;
        this.title = appCompatTextView2;
    }

    public static ItemGoldRechargeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGoldRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGoldRechargeBinding bind(View view, Object obj) {
        return (ItemGoldRechargeBinding) ViewDataBinding.bind(obj, view, R.layout.item_gold_recharge);
    }

    @Deprecated
    public static ItemGoldRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGoldRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gold_recharge, viewGroup, z, obj);
    }

    public static ItemGoldRechargeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGoldRechargeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGoldRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gold_recharge, (ViewGroup) null, false, obj);
    }
}
