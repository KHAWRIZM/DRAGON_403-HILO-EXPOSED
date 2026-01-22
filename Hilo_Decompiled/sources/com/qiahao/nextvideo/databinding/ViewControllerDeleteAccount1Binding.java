package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerDeleteAccount1Binding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final TextView cancel;
    public final ImageView condition1;
    public final ImageView condition2;
    public final ImageView condition3;
    public final ImageView condition4;
    public final TextView iUnderstand;
    public final TextView next;
    public final TextView tipTitle;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerDeleteAccount1Binding(Object obj, View view, int i, AppCompatImageView appCompatImageView, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView2, TextView textView3, TextView textView4, Toolbar toolbar) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.cancel = textView;
        this.condition1 = imageView;
        this.condition2 = imageView2;
        this.condition3 = imageView3;
        this.condition4 = imageView4;
        this.iUnderstand = textView2;
        this.next = textView3;
        this.tipTitle = textView4;
        this.toolbar = toolbar;
    }

    public static ViewControllerDeleteAccount1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerDeleteAccount1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerDeleteAccount1Binding bind(View view, Object obj) {
        return (ViewControllerDeleteAccount1Binding) ViewDataBinding.bind(obj, view, R.layout.view_controller_delete_account1);
    }

    @Deprecated
    public static ViewControllerDeleteAccount1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerDeleteAccount1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_delete_account1, viewGroup, z, obj);
    }

    public static ViewControllerDeleteAccount1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerDeleteAccount1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerDeleteAccount1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_delete_account1, (ViewGroup) null, false, obj);
    }
}
