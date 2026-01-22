package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemNamePlate1Binding extends ViewDataBinding {
    public final SVGAImageView svga;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemNamePlate1Binding(Object obj, View view, int i, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.svga = sVGAImageView;
    }

    public static ItemNamePlate1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemNamePlate1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemNamePlate1Binding bind(View view, Object obj) {
        return (ItemNamePlate1Binding) ViewDataBinding.bind(obj, view, R.layout.item_name_plate1);
    }

    @Deprecated
    public static ItemNamePlate1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNamePlate1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_name_plate1, viewGroup, z, obj);
    }

    public static ItemNamePlate1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemNamePlate1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNamePlate1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_name_plate1, (ViewGroup) null, false, obj);
    }
}
