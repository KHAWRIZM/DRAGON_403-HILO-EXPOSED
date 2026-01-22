package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogItemMedalBinding extends ViewDataBinding {
    public final ImageView medalImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogItemMedalBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.medalImage = imageView;
    }

    public static DialogItemMedalBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogItemMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogItemMedalBinding bind(View view, Object obj) {
        return (DialogItemMedalBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_item_medal);
    }

    @Deprecated
    public static DialogItemMedalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogItemMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_item_medal, viewGroup, z, obj);
    }

    public static DialogItemMedalBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogItemMedalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogItemMedalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_item_medal, (ViewGroup) null, false, obj);
    }
}
