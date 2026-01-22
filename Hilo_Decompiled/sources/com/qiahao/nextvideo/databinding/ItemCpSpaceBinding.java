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
public abstract class ItemCpSpaceBinding extends ViewDataBinding {
    public final ImageView bg;
    public final ImageView privilegeImage;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCpSpaceBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.bg = imageView;
        this.privilegeImage = imageView2;
        this.title = textView;
    }

    public static ItemCpSpaceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCpSpaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCpSpaceBinding bind(View view, Object obj) {
        return (ItemCpSpaceBinding) ViewDataBinding.bind(obj, view, R.layout.item_cp_space);
    }

    @Deprecated
    public static ItemCpSpaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCpSpaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_space, viewGroup, z, obj);
    }

    public static ItemCpSpaceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCpSpaceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCpSpaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_space, (ViewGroup) null, false, obj);
    }
}
