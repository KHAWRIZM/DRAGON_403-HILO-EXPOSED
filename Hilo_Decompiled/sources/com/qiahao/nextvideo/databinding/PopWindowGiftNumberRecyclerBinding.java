package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class PopWindowGiftNumberRecyclerBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public PopWindowGiftNumberRecyclerBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
    }

    public static PopWindowGiftNumberRecyclerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static PopWindowGiftNumberRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static PopWindowGiftNumberRecyclerBinding bind(View view, Object obj) {
        return (PopWindowGiftNumberRecyclerBinding) ViewDataBinding.bind(obj, view, R.layout.pop_window_gift_number_recycler);
    }

    @Deprecated
    public static PopWindowGiftNumberRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PopWindowGiftNumberRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_window_gift_number_recycler, viewGroup, z, obj);
    }

    public static PopWindowGiftNumberRecyclerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static PopWindowGiftNumberRecyclerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PopWindowGiftNumberRecyclerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pop_window_gift_number_recycler, (ViewGroup) null, false, obj);
    }
}
