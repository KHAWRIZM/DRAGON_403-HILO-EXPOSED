package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogDefaultMoreBinding extends ViewDataBinding {
    public final AppCompatButton cancelButton;
    public final LinearLayoutCompat linearLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogDefaultMoreBinding(Object obj, View view, int i, AppCompatButton appCompatButton, LinearLayoutCompat linearLayoutCompat) {
        super(obj, view, i);
        this.cancelButton = appCompatButton;
        this.linearLayout = linearLayoutCompat;
    }

    public static DialogDefaultMoreBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogDefaultMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogDefaultMoreBinding bind(View view, Object obj) {
        return (DialogDefaultMoreBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_default_more);
    }

    @Deprecated
    public static DialogDefaultMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogDefaultMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_default_more, viewGroup, z, obj);
    }

    public static DialogDefaultMoreBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogDefaultMoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogDefaultMoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_default_more, (ViewGroup) null, false, obj);
    }
}
