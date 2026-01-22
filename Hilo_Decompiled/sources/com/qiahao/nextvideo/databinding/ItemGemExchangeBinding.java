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
public abstract class ItemGemExchangeBinding extends ViewDataBinding {
    public final ImageView money;
    public final TextView moneyNumber;
    public final TextView rechargeText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGemExchangeBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.money = imageView;
        this.moneyNumber = textView;
        this.rechargeText = textView2;
    }

    public static ItemGemExchangeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGemExchangeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGemExchangeBinding bind(View view, Object obj) {
        return (ItemGemExchangeBinding) ViewDataBinding.bind(obj, view, R.layout.item_gem_exchange);
    }

    @Deprecated
    public static ItemGemExchangeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGemExchangeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gem_exchange, viewGroup, z, obj);
    }

    public static ItemGemExchangeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGemExchangeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGemExchangeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_gem_exchange, (ViewGroup) null, false, obj);
    }
}
