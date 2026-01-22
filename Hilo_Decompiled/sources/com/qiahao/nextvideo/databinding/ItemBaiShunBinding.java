package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemBaiShunBinding extends ViewDataBinding {
    public final QMUIRadiusImageView img;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemBaiShunBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView) {
        super(obj, view, i);
        this.img = qMUIRadiusImageView;
    }

    public static ItemBaiShunBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemBaiShunBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemBaiShunBinding bind(View view, Object obj) {
        return (ItemBaiShunBinding) ViewDataBinding.bind(obj, view, R.layout.item_bai_shun);
    }

    @Deprecated
    public static ItemBaiShunBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemBaiShunBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_bai_shun, viewGroup, z, obj);
    }

    public static ItemBaiShunBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemBaiShunBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemBaiShunBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_bai_shun, (ViewGroup) null, false, obj);
    }
}
