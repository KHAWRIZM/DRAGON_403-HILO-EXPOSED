package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemNewUserBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final View head;
    public final TextView name;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemNewUserBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, View view2, TextView textView) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.head = view2;
        this.name = textView;
    }

    public static ItemNewUserBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemNewUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemNewUserBinding bind(View view, Object obj) {
        return (ItemNewUserBinding) ViewDataBinding.bind(obj, view, R.layout.item_new_user);
    }

    @Deprecated
    public static ItemNewUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemNewUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_new_user, viewGroup, z, obj);
    }

    public static ItemNewUserBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemNewUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemNewUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_new_user, (ViewGroup) null, false, obj);
    }
}
