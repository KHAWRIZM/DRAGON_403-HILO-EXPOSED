package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPk1v1Binding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ConstraintLayout constraint;
    public final TextView nick;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPk1v1Binding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.constraint = constraintLayout;
        this.nick = textView;
    }

    public static ItemPk1v1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPk1v1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPk1v1Binding bind(View view, Object obj) {
        return (ItemPk1v1Binding) ViewDataBinding.bind(obj, view, R.layout.item_pk1v1);
    }

    @Deprecated
    public static ItemPk1v1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPk1v1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pk1v1, viewGroup, z, obj);
    }

    public static ItemPk1v1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPk1v1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPk1v1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pk1v1, (ViewGroup) null, false, obj);
    }
}
