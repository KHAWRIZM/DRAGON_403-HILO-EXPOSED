package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityChangePasswordBinding extends ViewDataBinding {
    public final TextView confirmButton;
    public final View line;
    public final AppCompatEditText newPassword;
    public final AppCompatEditText oldPassword;
    public final TextView tip;
    public final IncludeTitleBinding titleBar;
    public final ImageView viewNewPassword;
    public final ImageView viewOldPassword;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityChangePasswordBinding(Object obj, View view, int i, TextView textView, View view2, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, TextView textView2, IncludeTitleBinding includeTitleBinding, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.confirmButton = textView;
        this.line = view2;
        this.newPassword = appCompatEditText;
        this.oldPassword = appCompatEditText2;
        this.tip = textView2;
        this.titleBar = includeTitleBinding;
        this.viewNewPassword = imageView;
        this.viewOldPassword = imageView2;
    }

    public static ActivityChangePasswordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityChangePasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityChangePasswordBinding bind(View view, Object obj) {
        return (ActivityChangePasswordBinding) ViewDataBinding.bind(obj, view, R.layout.activity_change_password);
    }

    @Deprecated
    public static ActivityChangePasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityChangePasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_change_password, viewGroup, z, obj);
    }

    public static ActivityChangePasswordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityChangePasswordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityChangePasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_change_password, (ViewGroup) null, false, obj);
    }
}
