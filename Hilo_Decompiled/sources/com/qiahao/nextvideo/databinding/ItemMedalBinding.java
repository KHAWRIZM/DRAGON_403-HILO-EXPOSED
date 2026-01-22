package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMedalBinding extends ViewDataBinding {
    public final ImageView imagMedal;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMedalBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.imagMedal = imageView;
    }

    public static ItemMedalBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMedalBinding bind(View view, Object obj) {
        return (ItemMedalBinding) ViewDataBinding.bind(obj, view, R.layout.item_medal);
    }

    @Deprecated
    public static ItemMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_medal, viewGroup, z, obj);
    }

    public static ItemMedalBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMedalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_medal, (ViewGroup) null, false, obj);
    }
}
