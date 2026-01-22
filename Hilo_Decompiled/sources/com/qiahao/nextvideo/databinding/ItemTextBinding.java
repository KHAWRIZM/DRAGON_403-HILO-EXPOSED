package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemTextBinding extends ViewDataBinding {
    /* JADX INFO: Access modifiers changed from: protected */
    public ItemTextBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemTextBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemTextBinding bind(View view, Object obj) {
        return (ItemTextBinding) ViewDataBinding.bind(obj, view, R.layout.item_text);
    }

    @Deprecated
    public static ItemTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_text, viewGroup, z, obj);
    }

    public static ItemTextBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemTextBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_text, (ViewGroup) null, false, obj);
    }
}
