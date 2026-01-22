package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemSvipPointBinding extends ViewDataBinding {
    public final TextView diamond;
    public final View line;
    public final TextView subTitle;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSvipPointBinding(Object obj, View view, int i, TextView textView, View view2, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.diamond = textView;
        this.line = view2;
        this.subTitle = textView2;
        this.title = textView3;
    }

    public static ItemSvipPointBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemSvipPointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemSvipPointBinding bind(View view, Object obj) {
        return (ItemSvipPointBinding) ViewDataBinding.bind(obj, view, R.layout.item_svip_point);
    }

    @Deprecated
    public static ItemSvipPointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSvipPointBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_svip_point, viewGroup, z, obj);
    }

    public static ItemSvipPointBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemSvipPointBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSvipPointBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_svip_point, (ViewGroup) null, false, obj);
    }
}
