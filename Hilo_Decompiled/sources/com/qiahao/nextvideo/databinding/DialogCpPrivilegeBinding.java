package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogCpPrivilegeBinding extends ViewDataBinding {
    public final View buttonBg;
    public final TextView confirm;
    public final ConstraintLayout constraintLayout;
    public final TextView content;
    public final Group group;
    public final ImageView image;
    public final TextView privilegeTitle;
    public final SwitchButton switchView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCpPrivilegeBinding(Object obj, View view, int i, View view2, TextView textView, ConstraintLayout constraintLayout, TextView textView2, Group group, ImageView imageView, TextView textView3, SwitchButton switchButton) {
        super(obj, view, i);
        this.buttonBg = view2;
        this.confirm = textView;
        this.constraintLayout = constraintLayout;
        this.content = textView2;
        this.group = group;
        this.image = imageView;
        this.privilegeTitle = textView3;
        this.switchView = switchButton;
    }

    public static DialogCpPrivilegeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCpPrivilegeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCpPrivilegeBinding bind(View view, Object obj) {
        return (DialogCpPrivilegeBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_cp_privilege);
    }

    @Deprecated
    public static DialogCpPrivilegeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCpPrivilegeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_privilege, viewGroup, z, obj);
    }

    public static DialogCpPrivilegeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCpPrivilegeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCpPrivilegeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_privilege, (ViewGroup) null, false, obj);
    }
}
