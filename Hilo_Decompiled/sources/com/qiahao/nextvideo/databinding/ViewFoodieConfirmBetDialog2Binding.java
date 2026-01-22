package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.ruffian.library.widget.RTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewFoodieConfirmBetDialog2Binding extends ViewDataBinding {
    public final ImageView ivCheckBox;
    public final RTextView tvCancel;
    public final RTextView tvConfirm;
    public final AppCompatTextView tvDontShowNext;
    public final AppCompatTextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewFoodieConfirmBetDialog2Binding(Object obj, View view, int i, ImageView imageView, RTextView rTextView, RTextView rTextView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.ivCheckBox = imageView;
        this.tvCancel = rTextView;
        this.tvConfirm = rTextView2;
        this.tvDontShowNext = appCompatTextView;
        this.tvTitle = appCompatTextView2;
    }

    public static ViewFoodieConfirmBetDialog2Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewFoodieConfirmBetDialog2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewFoodieConfirmBetDialog2Binding bind(View view, Object obj) {
        return (ViewFoodieConfirmBetDialog2Binding) ViewDataBinding.bind(obj, view, R.layout.view_foodie_confirm_bet_dialog_2);
    }

    @Deprecated
    public static ViewFoodieConfirmBetDialog2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewFoodieConfirmBetDialog2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_confirm_bet_dialog_2, viewGroup, z, obj);
    }

    public static ViewFoodieConfirmBetDialog2Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewFoodieConfirmBetDialog2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewFoodieConfirmBetDialog2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_foodie_confirm_bet_dialog_2, (ViewGroup) null, false, obj);
    }
}
