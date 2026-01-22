package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFragmentTransferCenterBinding extends ViewDataBinding {
    public final ConstraintLayout constraintLayout;
    public final TextView diamond;

    /* renamed from: id, reason: collision with root package name */
    public final TextView f٦١id;
    public final TextView position;
    public final TextView sales;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFragmentTransferCenterBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.constraintLayout = constraintLayout;
        this.diamond = textView;
        this.f٦١id = textView2;
        this.position = textView3;
        this.sales = textView4;
    }

    public static ItemFragmentTransferCenterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFragmentTransferCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFragmentTransferCenterBinding bind(View view, Object obj) {
        return (ItemFragmentTransferCenterBinding) ViewDataBinding.bind(obj, view, R.layout.item_fragment_transfer_center);
    }

    @Deprecated
    public static ItemFragmentTransferCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFragmentTransferCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_transfer_center, viewGroup, z, obj);
    }

    public static ItemFragmentTransferCenterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFragmentTransferCenterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFragmentTransferCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_transfer_center, (ViewGroup) null, false, obj);
    }
}
