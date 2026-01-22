package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerDeleteAccount2Binding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final TextView cancel;
    public final ImageView check;
    public final LinearLayout checkAgreement;
    public final TextView deleteMyAccount;
    public final LinearLayout linearLayout1;
    public final LinearLayout linearLayout2;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerDeleteAccount2Binding(Object obj, View view, int i, AppCompatImageView appCompatImageView, TextView textView, ImageView imageView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.cancel = textView;
        this.check = imageView;
        this.checkAgreement = linearLayout;
        this.deleteMyAccount = textView2;
        this.linearLayout1 = linearLayout2;
        this.linearLayout2 = linearLayout3;
        this.toolbar = toolbar;
    }

    public static ViewControllerDeleteAccount2Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerDeleteAccount2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerDeleteAccount2Binding bind(View view, Object obj) {
        return (ViewControllerDeleteAccount2Binding) ViewDataBinding.bind(obj, view, R.layout.view_controller_delete_account2);
    }

    @Deprecated
    public static ViewControllerDeleteAccount2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerDeleteAccount2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_delete_account2, viewGroup, z, obj);
    }

    public static ViewControllerDeleteAccount2Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerDeleteAccount2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerDeleteAccount2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_delete_account2, (ViewGroup) null, false, obj);
    }
}
