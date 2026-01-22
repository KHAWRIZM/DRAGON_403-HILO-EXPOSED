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
public abstract class ItemFragmentSecondTfBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final IncludeTransferTextBinding clientLayout;
    public final ConstraintLayout constraintLayout;
    public final View line;
    public final View line1;
    public final TextView name;
    public final View numberBg;
    public final IncludeTransferTextBinding rechargeLayout;
    public final IncludeTransferTextBinding salesLayout;
    public final TextView subTitle;
    public final TextView transfer;
    public final View twoLine;
    public final TextView userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFragmentSecondTfBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, IncludeTransferTextBinding includeTransferTextBinding, ConstraintLayout constraintLayout, View view2, View view3, TextView textView, View view4, IncludeTransferTextBinding includeTransferTextBinding2, IncludeTransferTextBinding includeTransferTextBinding3, TextView textView2, TextView textView3, View view5, TextView textView4) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.clientLayout = includeTransferTextBinding;
        this.constraintLayout = constraintLayout;
        this.line = view2;
        this.line1 = view3;
        this.name = textView;
        this.numberBg = view4;
        this.rechargeLayout = includeTransferTextBinding2;
        this.salesLayout = includeTransferTextBinding3;
        this.subTitle = textView2;
        this.transfer = textView3;
        this.twoLine = view5;
        this.userId = textView4;
    }

    public static ItemFragmentSecondTfBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFragmentSecondTfBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFragmentSecondTfBinding bind(View view, Object obj) {
        return (ItemFragmentSecondTfBinding) ViewDataBinding.bind(obj, view, R.layout.item_fragment_second_tf);
    }

    @Deprecated
    public static ItemFragmentSecondTfBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFragmentSecondTfBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_second_tf, viewGroup, z, obj);
    }

    public static ItemFragmentSecondTfBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFragmentSecondTfBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFragmentSecondTfBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fragment_second_tf, (ViewGroup) null, false, obj);
    }
}
