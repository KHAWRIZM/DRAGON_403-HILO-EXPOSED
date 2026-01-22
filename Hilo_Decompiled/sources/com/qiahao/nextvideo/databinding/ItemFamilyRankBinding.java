package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFamilyRankBinding extends ViewDataBinding {
    public final PolygonImageView avatar;
    public final TextView diamond;
    public final View line;
    public final LinearLayout llDiamond;
    public final IncludeFamilyNamePlateBinding namePlate;
    public final TextView position;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFamilyRankBinding(Object obj, View view, int i, PolygonImageView polygonImageView, TextView textView, View view2, LinearLayout linearLayout, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.avatar = polygonImageView;
        this.diamond = textView;
        this.line = view2;
        this.llDiamond = linearLayout;
        this.namePlate = includeFamilyNamePlateBinding;
        this.position = textView2;
        this.userName = textView3;
    }

    public static ItemFamilyRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFamilyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFamilyRankBinding bind(View view, Object obj) {
        return (ItemFamilyRankBinding) ViewDataBinding.bind(obj, view, R.layout.item_family_rank);
    }

    @Deprecated
    public static ItemFamilyRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFamilyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_rank, viewGroup, z, obj);
    }

    public static ItemFamilyRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFamilyRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFamilyRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_rank, (ViewGroup) null, false, obj);
    }
}
