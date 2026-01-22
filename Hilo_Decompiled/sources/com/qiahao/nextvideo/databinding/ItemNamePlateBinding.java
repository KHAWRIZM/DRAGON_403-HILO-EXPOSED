package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemNamePlateBinding extends ViewDataBinding {
    public final SVGAImageView svga;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemNamePlateBinding(Object obj, View view, int i, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.svga = sVGAImageView;
    }

    public static ItemNamePlateBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemNamePlateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemNamePlateBinding bind(View view, Object obj) {
        return (ItemNamePlateBinding) ViewDataBinding.bind(obj, view, R.layout.item_name_plate);
    }

    @Deprecated
    public static ItemNamePlateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNamePlateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_name_plate, viewGroup, z, obj);
    }

    public static ItemNamePlateBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemNamePlateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNamePlateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_name_plate, (ViewGroup) null, false, obj);
    }
}
