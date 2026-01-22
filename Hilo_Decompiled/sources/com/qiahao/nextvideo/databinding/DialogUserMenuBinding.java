package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogUserMenuBinding extends ViewDataBinding {
    public final View backView;
    public final TextView blockButton;
    public final AppCompatButton cancelButton;
    public final TextView deleteButton;
    public final View deleteLine;
    public final TextView pinnedButton;
    public final View pinnedLine;
    public final TextView profileButton;
    public final View profileLine;
    public final TextView reportButton;
    public final TextView svipButton;
    public final ConstraintLayout svipLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogUserMenuBinding(Object obj, View view, int i, View view2, TextView textView, AppCompatButton appCompatButton, TextView textView2, View view3, TextView textView3, View view4, TextView textView4, View view5, TextView textView5, TextView textView6, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.backView = view2;
        this.blockButton = textView;
        this.cancelButton = appCompatButton;
        this.deleteButton = textView2;
        this.deleteLine = view3;
        this.pinnedButton = textView3;
        this.pinnedLine = view4;
        this.profileButton = textView4;
        this.profileLine = view5;
        this.reportButton = textView5;
        this.svipButton = textView6;
        this.svipLayout = constraintLayout;
    }

    public static DialogUserMenuBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogUserMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogUserMenuBinding bind(View view, Object obj) {
        return (DialogUserMenuBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_user_menu);
    }

    @Deprecated
    public static DialogUserMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogUserMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_user_menu, viewGroup, z, obj);
    }

    public static DialogUserMenuBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogUserMenuBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogUserMenuBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_user_menu, (ViewGroup) null, false, obj);
    }
}
