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
public abstract class ItemTransferRecordBinding extends ViewDataBinding {
    public final TextView diamond;
    public final View line;
    public final ImageView promoterIcon;
    public final TextView promoterId;
    public final TextView time;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemTransferRecordBinding(Object obj, View view, int i, TextView textView, View view2, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.diamond = textView;
        this.line = view2;
        this.promoterIcon = imageView;
        this.promoterId = textView2;
        this.time = textView3;
        this.title = textView4;
    }

    public static ItemTransferRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemTransferRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemTransferRecordBinding bind(View view, Object obj) {
        return (ItemTransferRecordBinding) ViewDataBinding.bind(obj, view, R.layout.item_transfer_record);
    }

    @Deprecated
    public static ItemTransferRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTransferRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_transfer_record, viewGroup, z, obj);
    }

    public static ItemTransferRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemTransferRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTransferRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_transfer_record, (ViewGroup) null, false, obj);
    }
}
