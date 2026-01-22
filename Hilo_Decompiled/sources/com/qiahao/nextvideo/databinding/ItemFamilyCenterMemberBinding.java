package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFamilyCenterMemberBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final AppCompatTextView name;
    public final AppCompatImageView typeImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFamilyCenterMemberBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.name = appCompatTextView;
        this.typeImage = appCompatImageView;
    }

    public static ItemFamilyCenterMemberBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFamilyCenterMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFamilyCenterMemberBinding bind(View view, Object obj) {
        return (ItemFamilyCenterMemberBinding) ViewDataBinding.bind(obj, view, R.layout.item_family_center_member);
    }

    @Deprecated
    public static ItemFamilyCenterMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFamilyCenterMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_center_member, viewGroup, z, obj);
    }

    public static ItemFamilyCenterMemberBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFamilyCenterMemberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFamilyCenterMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_center_member, (ViewGroup) null, false, obj);
    }
}
