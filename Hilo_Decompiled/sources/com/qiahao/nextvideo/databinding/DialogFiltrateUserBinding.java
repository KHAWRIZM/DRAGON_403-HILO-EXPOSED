package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogFiltrateUserBinding extends ViewDataBinding {
    public final AppCompatTextView adminButton;
    public final AppCompatTextView cancelButton;
    public final AppCompatTextView manageButton;
    public final AppCompatTextView memberButton;
    public final AppCompatTextView ownButton;
    public final View profileLine;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogFiltrateUserBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, View view2) {
        super(obj, view, i);
        this.adminButton = appCompatTextView;
        this.cancelButton = appCompatTextView2;
        this.manageButton = appCompatTextView3;
        this.memberButton = appCompatTextView4;
        this.ownButton = appCompatTextView5;
        this.profileLine = view2;
    }

    public static DialogFiltrateUserBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogFiltrateUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogFiltrateUserBinding bind(View view, Object obj) {
        return (DialogFiltrateUserBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_filtrate_user);
    }

    @Deprecated
    public static DialogFiltrateUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogFiltrateUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_filtrate_user, viewGroup, z, obj);
    }

    public static DialogFiltrateUserBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogFiltrateUserBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogFiltrateUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_filtrate_user, (ViewGroup) null, false, obj);
    }
}
