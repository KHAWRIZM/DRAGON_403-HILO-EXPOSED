package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemTextGroupBinding extends ViewDataBinding {
    public final RecyclerView recyclerView;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemTextGroupBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.recyclerView = recyclerView;
        this.title = textView;
    }

    public static ItemTextGroupBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemTextGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemTextGroupBinding bind(View view, Object obj) {
        return (ItemTextGroupBinding) ViewDataBinding.bind(obj, view, R.layout.item_text_group);
    }

    @Deprecated
    public static ItemTextGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTextGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_text_group, viewGroup, z, obj);
    }

    public static ItemTextGroupBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemTextGroupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTextGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_text_group, (ViewGroup) null, false, obj);
    }
}
