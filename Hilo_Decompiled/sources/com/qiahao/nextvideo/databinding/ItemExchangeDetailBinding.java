package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemExchangeDetailBinding extends ViewDataBinding {
    public final View line;
    public final TextView number;
    public final TextView time;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemExchangeDetailBinding(Object obj, View view, int i, View view2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.line = view2;
        this.number = textView;
        this.time = textView2;
        this.title = textView3;
    }

    public static ItemExchangeDetailBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemExchangeDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemExchangeDetailBinding bind(View view, Object obj) {
        return (ItemExchangeDetailBinding) ViewDataBinding.bind(obj, view, R.layout.item_exchange_detail);
    }

    @Deprecated
    public static ItemExchangeDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemExchangeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exchange_detail, viewGroup, z, obj);
    }

    public static ItemExchangeDetailBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemExchangeDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemExchangeDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exchange_detail, (ViewGroup) null, false, obj);
    }
}
