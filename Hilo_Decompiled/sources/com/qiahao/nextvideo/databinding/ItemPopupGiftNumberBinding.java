package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPopupGiftNumberBinding extends ViewDataBinding {
    public final TextView number;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPopupGiftNumberBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.number = textView;
    }

    public static ItemPopupGiftNumberBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPopupGiftNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPopupGiftNumberBinding bind(View view, Object obj) {
        return (ItemPopupGiftNumberBinding) ViewDataBinding.bind(obj, view, R.layout.item_popup_gift_number);
    }

    @Deprecated
    public static ItemPopupGiftNumberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPopupGiftNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_popup_gift_number, viewGroup, z, obj);
    }

    public static ItemPopupGiftNumberBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPopupGiftNumberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPopupGiftNumberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_popup_gift_number, (ViewGroup) null, false, obj);
    }
}
