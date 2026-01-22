package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewFruitConfirmRepeatDialogBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final TextView diamond;
    public final ImageView diamondIcon;
    public final ImageView ivCheckBox;
    public final TextView tvCancel;
    public final TextView tvConfirm;
    public final AppCompatTextView tvDontShowNext;
    public final AppCompatTextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewFruitConfirmRepeatDialogBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.constraint = constraintLayout;
        this.diamond = textView;
        this.diamondIcon = imageView;
        this.ivCheckBox = imageView2;
        this.tvCancel = textView2;
        this.tvConfirm = textView3;
        this.tvDontShowNext = appCompatTextView;
        this.tvTitle = appCompatTextView2;
    }

    public static ViewFruitConfirmRepeatDialogBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewFruitConfirmRepeatDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewFruitConfirmRepeatDialogBinding bind(View view, Object obj) {
        return (ViewFruitConfirmRepeatDialogBinding) ViewDataBinding.bind(obj, view, R.layout.view_fruit_confirm_repeat_dialog);
    }

    @Deprecated
    public static ViewFruitConfirmRepeatDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewFruitConfirmRepeatDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_fruit_confirm_repeat_dialog, viewGroup, z, obj);
    }

    public static ViewFruitConfirmRepeatDialogBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewFruitConfirmRepeatDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewFruitConfirmRepeatDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_fruit_confirm_repeat_dialog, (ViewGroup) null, false, obj);
    }
}
