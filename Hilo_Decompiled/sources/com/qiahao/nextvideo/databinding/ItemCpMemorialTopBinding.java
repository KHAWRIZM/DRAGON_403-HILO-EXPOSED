package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemCpMemorialTopBinding extends ViewDataBinding {
    public final TextView content;
    public final HiloImageView leftAvatar;
    public final HiloImageView rightAvatar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCpMemorialTopBinding(Object obj, View view, int i, TextView textView, HiloImageView hiloImageView, HiloImageView hiloImageView2) {
        super(obj, view, i);
        this.content = textView;
        this.leftAvatar = hiloImageView;
        this.rightAvatar = hiloImageView2;
    }

    public static ItemCpMemorialTopBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCpMemorialTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCpMemorialTopBinding bind(View view, Object obj) {
        return (ItemCpMemorialTopBinding) ViewDataBinding.bind(obj, view, R.layout.item_cp_memorial_top);
    }

    @Deprecated
    public static ItemCpMemorialTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCpMemorialTopBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_memorial_top, viewGroup, z, obj);
    }

    public static ItemCpMemorialTopBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCpMemorialTopBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCpMemorialTopBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_cp_memorial_top, (ViewGroup) null, false, obj);
    }
}
