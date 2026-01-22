package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentLoginPhoneBinding extends ViewDataBinding {
    public final TextView confirmButton;
    public final QMUIRadiusImageView2 countryIcon;
    public final TextView countryPhone;
    public final TextView forgotPassword;
    public final View line;
    public final AppCompatEditText password;
    public final AppCompatEditText phoneNumber;
    public final LinearLayout selectCountryLayout;
    public final TextView tip;
    public final IncludeTitleBinding titleBar;
    public final ImageView viewPassword;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentLoginPhoneBinding(Object obj, View view, int i, TextView textView, QMUIRadiusImageView2 qMUIRadiusImageView2, TextView textView2, TextView textView3, View view2, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, LinearLayout linearLayout, TextView textView4, IncludeTitleBinding includeTitleBinding, ImageView imageView) {
        super(obj, view, i);
        this.confirmButton = textView;
        this.countryIcon = qMUIRadiusImageView2;
        this.countryPhone = textView2;
        this.forgotPassword = textView3;
        this.line = view2;
        this.password = appCompatEditText;
        this.phoneNumber = appCompatEditText2;
        this.selectCountryLayout = linearLayout;
        this.tip = textView4;
        this.titleBar = includeTitleBinding;
        this.viewPassword = imageView;
    }

    public static FragmentLoginPhoneBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentLoginPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentLoginPhoneBinding bind(View view, Object obj) {
        return (FragmentLoginPhoneBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_login_phone);
    }

    @Deprecated
    public static FragmentLoginPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentLoginPhoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_login_phone, viewGroup, z, obj);
    }

    public static FragmentLoginPhoneBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentLoginPhoneBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentLoginPhoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_login_phone, (ViewGroup) null, false, obj);
    }
}
