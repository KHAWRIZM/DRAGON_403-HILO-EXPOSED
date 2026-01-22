package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerDeleteAccount3Binding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final View line;
    public final TextView logOut;
    public final LinearLayout successfulApplication;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final TextView text4;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerDeleteAccount3Binding(Object obj, View view, int i, AppCompatImageView appCompatImageView, View view2, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.line = view2;
        this.logOut = textView;
        this.successfulApplication = linearLayout;
        this.text1 = textView2;
        this.text2 = textView3;
        this.text3 = textView4;
        this.text4 = textView5;
        this.toolbar = toolbar;
    }

    public static ViewControllerDeleteAccount3Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerDeleteAccount3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerDeleteAccount3Binding bind(View view, Object obj) {
        return (ViewControllerDeleteAccount3Binding) ViewDataBinding.bind(obj, view, R.layout.view_controller_delete_account3);
    }

    @Deprecated
    public static ViewControllerDeleteAccount3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerDeleteAccount3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_delete_account3, viewGroup, z, obj);
    }

    public static ViewControllerDeleteAccount3Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerDeleteAccount3Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerDeleteAccount3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_delete_account3, (ViewGroup) null, false, obj);
    }
}
