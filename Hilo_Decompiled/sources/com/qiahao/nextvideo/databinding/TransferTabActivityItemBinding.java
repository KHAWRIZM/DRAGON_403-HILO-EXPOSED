package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class TransferTabActivityItemBinding extends ViewDataBinding {
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public TransferTabActivityItemBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.title = textView;
    }

    public static TransferTabActivityItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static TransferTabActivityItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static TransferTabActivityItemBinding bind(View view, Object obj) {
        return (TransferTabActivityItemBinding) ViewDataBinding.bind(obj, view, R.layout.transfer_tab_activity_item);
    }

    @Deprecated
    public static TransferTabActivityItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TransferTabActivityItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.transfer_tab_activity_item, viewGroup, z, obj);
    }

    public static TransferTabActivityItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static TransferTabActivityItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TransferTabActivityItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.transfer_tab_activity_item, (ViewGroup) null, false, obj);
    }
}
